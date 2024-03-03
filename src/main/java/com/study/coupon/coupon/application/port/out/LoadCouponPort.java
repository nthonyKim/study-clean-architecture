package com.study.coupon.coupon.application.port.out;

import com.study.coupon.coupon.domain.Coupon;

import java.util.List;
import java.util.Optional;

public interface LoadCouponPort {
    Optional<Coupon> byCode(String code);

    List<Coupon> findExpiryList(Long time, int limit);
}
