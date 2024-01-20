package com.mdx.hubing.module.api;

import com.google.gson.Gson;
import com.mdx.hubing.config.AppConfig;
import com.mdx.hubing.model.dto.WxResult;
import com.mdx.hubing.module.network.OkRequest;
import com.mdx.hubing.module.network.RequestOption;

/**
 * Author: Meng
 * Date: 2023-11-10
 * Desc:
 */
public class WxApis {
    private static final String WXHost = "https://api.weixin.qq.com";

    public WxResult getWxOpenid(String wxCode) {
        String url = String.format("%s/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code", WXHost, AppConfig.WX_APPID, AppConfig.WX_SECRET, wxCode);
        RequestOption option = new RequestOption(url);
        String data = OkRequest.request(option);

        WxResult result = null;
        if(data != null) {
            Gson gson = new Gson();
            result = gson.fromJson(data, WxResult.class);
        }
        return result;
    }
}
