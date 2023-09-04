package com.meng.store.model.dao;

import com.meng.store.model.dto.PublishDto;

/**
 * Author: Meng
 * Date: 2023-04-13
 * Desc:
 */
public class NewestDao {
    private PublishDto prod;
    private PublishDto test;
    private PublishDto uat;

    public PublishDto getProd() {
        return prod;
    }

    public void setProd(PublishDto prod) {
        this.prod = prod;
    }

    public PublishDto getTest() {
        return test;
    }

    public void setTest(PublishDto test) {
        this.test = test;
    }

    public PublishDto getUat() {
        return uat;
    }

    public void setUat(PublishDto uat) {
        this.uat = uat;
    }
}
