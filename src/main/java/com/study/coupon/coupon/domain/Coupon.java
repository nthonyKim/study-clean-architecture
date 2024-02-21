package com.study.coupon.coupon.domain;

import com.study.coupon.coupon.CouponStatus;
import com.study.coupon.coupon.CouponType;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class Coupon {
    private Long id;
    private String code;
    private Long point;
    private CouponType type;
    private CouponStatus status;
    private Long createdAt;
    private Long usedAt;
    private Long expiredAt;

    public static Coupon generate(Long point, CouponType type) {
        Coupon coupon = new Coupon();
        coupon.setCode(UUID.randomUUID().toString().replace("-", "").substring(0, 32));
        coupon.setPoint(point);
        coupon.setType(type);
        coupon.setStatus(CouponStatus.READY);
        coupon.setCreatedAt(Instant.now().getEpochSecond());
        coupon.setExpiredAt(Instant.now().plus(5, ChronoUnit.YEARS).getEpochSecond());
        return coupon;
    }

    public boolean useAvailable() {
        return CouponStatus.READY.equals(status);
    }

    public void registered() {
        this.status = CouponStatus.PROGRESS;
        this.usedAt = Instant.now().getEpochSecond();
        // 이벤트 발행
    }
}