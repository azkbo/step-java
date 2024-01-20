package com.mdx.hubing.service.impl;

import com.mdx.hubing.exception.CustomException;
import com.mdx.hubing.exception.ErrorCode;
import com.mdx.hubing.model.body.ShopBody;
import com.mdx.hubing.model.entity.ShopEntity;
import com.mdx.hubing.model.mapper.ShopMapper;
import com.mdx.hubing.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-22
 * Desc:
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopMapper shopMapper;

    @Override
    public int addShop(ShopBody body) throws CustomException {
        int code = 0;
        try {
            System.out.println(body);
            code = shopMapper.addShop(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public List<ShopEntity> queryShops(int uid) throws CustomException {
        List<ShopEntity> list = null;
        try {
            list = shopMapper.queryShop(uid);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return list;
    }

    @Override
    public ShopEntity shopDetail(int id) throws CustomException {
        ShopEntity shop = null;
        try {
            shop = shopMapper.shopDetail(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return shop;
    }

    @Override
    public int updateShop(ShopBody body) throws CustomException {
        int code = 0;
        try {
            code = shopMapper.updateShop(body);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }

    @Override
    public int deleteShop(int id) throws CustomException {
        int code = 0;
        try {
            code = shopMapper.deleteShop(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw CustomException.create(ErrorCode.FAIL);
        }
        return code;
    }
}
