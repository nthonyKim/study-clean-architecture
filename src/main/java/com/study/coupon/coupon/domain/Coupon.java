package com.study.coupon.coupon.domain;

import com.study.coupon.coupon.CouponType;

public class Coupon {
    private Long id;
    private String code;
    private int point;
    private CouponType type;
    private Long createdAt;
    private Long usedAt;
    private Long expiredAt;
}