package com.study.coupon.coupon.application.port.out;

import com.study.coupon.coupon.domain.Coupon;

public interface UpdateCouponPort {

    void save(Coupon coupon);
}
