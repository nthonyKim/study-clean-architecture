package com.study.coupon.coupon.application.port.in;

import com.study.coupon.coupon.application.port.in.command.RegisterCouponCommand;
import com.study.coupon.coupon.domain.Coupon;

public interface RegisterCouponUseCase {
    void register(RegisterCouponCommand command);
    void validate(Coupon coupon);
}
