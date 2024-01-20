package com.mdx.hubing.module.network;

import java.util.Map;

/**
 * Author: Meng
 * Date: 2023-11-11
 * Desc:
 */
public class RequestOption<T> {
    public String url;
    public String method;
    public T params;
    public Map<String, String> headers;

    public RequestOption(String url) {
        this(url, "get");
    }

    public RequestOption(String url, String method) {
        this(url, method, null);
    }

    public RequestOption(String url, String method, T params) {
        this(url, "get", params, null);
    }

    public RequestOption(String url, String method, T params, Map<String, String> headers) {
        this.url = url;
        this.method = method;
        this.params = params;
        this.headers = headers;
    }
}
