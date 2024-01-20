package com.mdx.hubing.module.network;

/**
 * Author: Meng
 * Date: 2023-11-10
 * Desc:
 */

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Author: Meng
 * Date: 2023/04/13
 * Desc:
 */
public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request result = chain.request();
        Request.Builder builder = result.newBuilder()
//            .addHeader("Cache-Control", "max-age=300")
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("userAgent", "version:0.0.1,device:java server");

//        if (result.method().equalsIgnoreCase("get")) {
//            HttpUrl newUrl = result.url()
//                    .newBuilder()
//                    .addQueryParameter("TOKEN", "token")
//                    .build();
//            builder.url(newUrl);
//        }
        return chain.proceed(builder.build());
    }
}
