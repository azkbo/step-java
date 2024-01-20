package com.mdx.hubing.module.network;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Author: Meng
 * Date: 2023-11-10
 * Desc:
 */
public class LogInterceptor implements Interceptor {
    private String TAG = "LogInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        long t1 = System.nanoTime();
        Request request = chain.request();
        System.out.printf("------> Request: %s %s %s%n", request.method(), request.url(), request.headers());
        Response response = chain.proceed(request);

        long t2 = System.nanoTime();
        System.out.printf("------> Response: %.1fms %s %n", (t2 - t1) / 1e6, request.url());
        return response;
    }
}
