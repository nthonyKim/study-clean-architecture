package com.study.coupon.coupon.application.infra;

import com.study.coupon.coupon.application.port.in.ExpireCouponUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponExpiredScheduler {

    private final ExpireCouponUseCase expireCoupon;

    @Scheduled(cron = "0 0 0 * * *")
    public void expire() {
        expireCoupon.expire();
    }
}
