package com.mdx.hubing.model.mapper;

import com.mdx.hubing.model.body.ShopBody;
import com.mdx.hubing.model.entity.ShopEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: Meng
 * Date: 2023-03-23
 * Desc:
 */

public interface ShopMapper {

    int addShop(@Param("body") ShopBody body);

    List<ShopEntity> queryShop(@Param("uid") int uid);

    ShopEntity shopDetail(@Param("id") int id);

    int updateShop(@Param("body") ShopBody body);

    int deleteShop(@Param("id") int id);

}
