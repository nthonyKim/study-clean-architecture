package com.study.coupon.coupon.domain;

import com.study.coupon.common.domain.BaseModel;
import com.study.coupon.coupon.domain.event.CouponEvent;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Setter
@Getter
public class Coupon extends BaseModel {
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
        if (useAvailable()) {
            throw new IllegalStateException("Coupon already used");
        }
        this.status = CouponStatus.USED;
        this.usedAt = Instant.now().getEpochSecond();
    }

    public void expired() {
        this.status = CouponStatus.EXPIRED;
        registerEvent(new CouponEvent.Expired(this));
    }
}