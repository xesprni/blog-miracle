package com.miracle.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Miracle
 * @date 06:05 2019/8/31
 */
@Slf4j
public class WebUtils {

    public static <T> T getResultByUrl(String url, Class<T> clazz) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            StringBuilder response;
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                response = new StringBuilder();
                String currentLine;
                while ((currentLine = in.readLine()) != null) {
                    response.append(currentLine);
                }
                return JsonUtil.string2Bean(response.toString(), clazz);
            } catch (IOException e) {
                log.error("Read Error: " + e);
            }
        } catch (IOException e) {
            log.error("Open Url Er-ror: " + e);
        }
        return null;
    }
}
