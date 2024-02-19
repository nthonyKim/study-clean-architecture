package com.study.coupon.coupon.application;

import com.study.coupon.common.application.EntityConverter;
import com.study.coupon.coupon.adapter.out.persistence.CouponEntity;
import com.study.coupon.coupon.domain.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponConverter implements EntityConverter<CouponEntity, Coupon> {

    @Override
    public Coupon entityToDomain(CouponEntity entity) {
        if (entity == null) {
            // TODO throw
        }

        Coupon coupon = new Coupon();
        coupon.setId(entity.getId());
        coupon.setCode(entity.getCode());
        coupon.setPoint(entity.getPoint());
        coupon.setType(entity.getType());
        coupon.setStatus(entity.getStatus());
        coupon.setCreatedAt(entity.getCreatedAt());
        coupon.setUsedAt(entity.getUsedAt());
        coupon.setExpiredAt(entity.getExpiredAt());
        return coupon;
    }

    @Override
    public CouponEntity domainToEntity(Coupon coupon) {
        if (coupon == null) {
            // TODO throw
        }

        CouponEntity entity = new CouponEntity();
        entity.setId(coupon.getId());
        entity.setCode(coupon.getCode());
        entity.setPoint(coupon.getPoint());
        entity.setType(coupon.getType());
        entity.setStatus(coupon.getStatus());
        entity.setCreatedAt(coupon.getCreatedAt());
        entity.setUsedAt(coupon.getUsedAt());
        entity.setExpiredAt(coupon.getExpiredAt());
        return entity;
    }
}
