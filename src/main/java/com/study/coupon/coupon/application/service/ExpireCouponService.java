package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.CouponStatus;import com.study.coupon.coupon.adapter.out.persistence.CouponEntity;
import com.study.coupon.coupon.adapter.out.persistence.CouponRepository;
import com.study.coupon.coupon.application.CouponConverter;
import com.study.coupon.coupon.application.port.in.ExpireCouponUseCase;

import com.study.coupon.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ExpireCouponService implements ExpireCouponUseCase {

    private final CouponRepository couponRepository;
    private final CouponConverter couponConverter;

    @Override
    public void expire() {
        couponRepository.findTop100ByStatusAndExpiredAtBefore(CouponStatus.READY, Instant.now().getEpochSecond())
                .forEach(ce -> {
                    Coupon coupon = couponConverter.entityToDomain(ce);
                    coupon.expired();

                    couponRepository.save(couponConverter.domainToEntity(coupon));
                });
    }
}
