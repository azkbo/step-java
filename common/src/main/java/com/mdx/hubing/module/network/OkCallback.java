package com.mdx.hubing.module.network;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Author: Meng
 * Date: 2023-11-10
 * Desc:
 */
public abstract class OkCallback<T> implements Callback {
    private String TAG = "OkCallback";

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        if (response.isSuccessful()) {
            String data = response.body().string();
//            System.out.printf("%S---> %s%n", TAG, data);
            if (data != null) {
                Gson gson = new Gson();
                ResultData<T> result = gson.fromJson(data, ResultData.class);
                onResult(result);
            } else {
                onFail(-1, response.message());
            }
        } else {
            onFail(response.code(), response.message());
        }
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        System.out.printf("%S---> %s%s", TAG, call.request().url(), e.getMessage());
    }

    private void onFail(int code, String msg) {
        System.out.printf("%s---> %d%s", TAG, code, msg);
    }

    protected abstract void onResult(ResultData<T> data);

}
