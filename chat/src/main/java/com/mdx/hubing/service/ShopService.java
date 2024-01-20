package com.mdx.hubing.service;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.model.body.ShopBody;
import com.mdx.hubing.model.entity.ShopEntity;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
public interface ShopService {
    // 添加
    int addShop(ShopBody body) throws CustomException;
    // 列表
    List<ShopEntity> queryShops(int uid) throws CustomException;
    // 详情
    ShopEntity shopDetail(int id) throws CustomException;
    // 更新
    int updateShop(ShopBody body) throws CustomException;
    // 删除
    int deleteShop(int id) throws CustomException;
}
