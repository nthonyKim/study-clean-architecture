package com.study.coupon.coupon.domain.event;

import com.study.coupon.coupon.domain.Coupon;

public class CouponEvent {

    public record Expired(Coupon coupon) {}
}
