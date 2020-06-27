package com.miracle.aop;

import com.miracle.annotation.Dict;
import com.miracle.annotation.DictItem;
import com.miracle.api.admin.IDictService;
import com.miracle.entity.admin.po.DictPO;
import com.miracle.model.ModelResult;
import com.miracle.model.PageResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Miracle
 * @date 21:26 2020/6/26
 */
@Configuration
@Aspect
@Slf4j
public class DictInjectAspect {

    private final IDictService dictService;

    public DictInjectAspect(IDictService dictService) {
        this.dictService = dictService;
    }

    /**
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.miracle.controller.*.*(..)))")
    public void dictPoint() {

    }


    /**
     * @description 在连接点执行之后执行的通知（返回通知）
     */
    @SuppressWarnings("unchecked")
    @AfterReturning(pointcut = "dictPoint()", returning = "res")
    public void doAfterReturningInjectDict(JoinPoint joinPoint, Object res) {
        if (res instanceof ModelResult) {
            Object data = ((ModelResult) res).getData();
            List pageData = null;
            if (data instanceof PageResult) {
                pageData = ((PageResult) data).getPageData();
            }
            if (data instanceof List) {
                pageData = (List) data;
            }
            if (pageData != null) {
                pageData.stream().filter(o -> o.getClass().isAnnotationPresent(Dict.class)).forEach(this::setDictValue);
            } else {
                setDictValue(data);
            }
        }
    }

    private void setDictValue(Object data) {
        if (data == null || !data.getClass().isAnnotationPresent(Dict.class)) {
            return;
        }
        Dict annotation = data.getClass().getAnnotation(Dict.class);
        DictItem[] value = annotation.value();
        for (DictItem dictItem : value) {
            try {
                String attr = dictItem.attr();
                String item = dictItem.item();
                Field attrField = data.getClass().getDeclaredField(attr);
                attrField.setAccessible(true);
                Integer type = (Integer) attrField.get(data);
                ModelResult<List<DictPO>> dictByItem = dictService.getDictByItem(item);
                if (!dictByItem.isFlag()) {
                    continue;
                }
                Field injectField = data.getClass().getDeclaredField(attr + "Name");
                injectField.setAccessible(true);
                List<DictPO> dict = dictByItem.getData();
                for (DictPO po : dict) {
                    if (po.getItemValue().equals(type)) {
                        injectField.set(data, po.getItemName());
                    }
                }
            } catch (Exception e) {
                log.error("get field error", e);
            }
        }
    }

}
