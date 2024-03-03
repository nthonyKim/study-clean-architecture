package com.study.coupon.point.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class Point {
    private Long id;
    private Long userId;
    private Long amount;
    private PaymentMethodType type;
    private PointStatus status = PointStatus.READY;
    private boolean isFree = false;
    private Long createdAt;
    private Long paidAt;
    private Long canceledAt;

    public static Point byCoupon(Long userId, Long amount) {
        Point point = new Point();
        point.setAmount(amount);
        point.setUserId(userId);
        point.setType(PaymentMethodType.COUPON);
        point.setStatus(PointStatus.PAID);
        point.isFree = true;
        point.setCreatedAt(Instant.now().getEpochSecond());
        point.setPaidAt(Instant.now().getEpochSecond());
        return point;
    }

    public static Point byPayment(Long userId, Long amount, PaymentMethodType type) {
        Point point = new Point();
        point.setAmount(amount);
        point.setUserId(userId);
        point.setType(type);
        point.setStatus(PointStatus.READY);
        point.isFree = false;
        point.setCreatedAt(Instant.now().getEpochSecond());
        return point;
    }
}