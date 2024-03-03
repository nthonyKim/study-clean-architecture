package com.study.coupon.point.domain;

import com.study.coupon.common.domain.BaseModel;
import com.study.coupon.point.domain.event.PointEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class Point extends BaseModel {
    private Long id;
    private Long userId;
    private Long amount;
    private PaymentMethodType type;
    private PointStatus status = PointStatus.READY;
    private boolean isFree = false; // 유상 / 무상 (소멸시한 상이)
    private Long createdAt;
    private Long paidAt;
    private Long canceledAt;

    public static Point byCoupon(Long userId, Long amount) {
        Point point = new Point();
        point.setAmount(amount);
        point.setUserId(userId);
        point.setType(PaymentMethodType.COUPON);
        point.isFree = true;
        point.setCreatedAt(Instant.now().getEpochSecond());
        return point;
    }

    public static Point byPayment(Long userId, Long amount, PaymentMethodType type) {
        Point point = new Point();
        point.setAmount(amount);
        point.setUserId(userId);
        point.setType(type);
        point.isFree = false;
        point.setCreatedAt(Instant.now().getEpochSecond());
        return point;
    }

    public boolean isCompleted() {
        return PointStatus.PAID.equals(this.status);
    }

    public void complete() {
        if (isCompleted()) {
            throw new IllegalStateException("Point already completed");
        }
        this.status = PointStatus.PAID;
        this.paidAt = Instant.now().getEpochSecond();
        registerEvent(new PointEvent.Completed(this));
    }
}