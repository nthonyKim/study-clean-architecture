package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.application.port.in.ExpireCouponUseCase;

import com.study.coupon.coupon.application.port.out.LoadCouponPort;
import com.study.coupon.coupon.application.port.out.UpdateCouponPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
class ExpireCouponService implements ExpireCouponUseCase {

    private final UpdateCouponPort updateCouponPort;
    private final LoadCouponPort loadCouponPort;

    @Override
    public void expire() {
        loadCouponPort.findExpiryList(Instant.now().getEpochSecond(), 100)
            .forEach(c -> {
                c.expired();
                updateCouponPort.save(c);
            });
    }
}
