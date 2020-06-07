package com.miracle.controller;

import com.miracle.api.article.IArticleService;
import com.miracle.entity.article.ArticleDTO;
import com.miracle.entity.article.ArticleDetailDTO;
import com.miracle.entity.article.ArticleQueryDTO;
import com.miracle.service.ArticleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author Miracle
 * @date 13:32 2020/6/7
 */
@RestController
public class BlogArticleController implements IArticleService {

    private final ArticleService articleService;

    public BlogArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    public Flux<ArticleDTO> getArticleList(@RequestBody @Valid ArticleQueryDTO articleQueryDTO) {
        return null;
    }

    @Override
    public Mono<ArticleDetailDTO> getArticleById(@RequestParam("id") String id) {
        Mono.justOrEmpty(new SubmissionPublisher<>() {

        });
        return null;
    }


}
