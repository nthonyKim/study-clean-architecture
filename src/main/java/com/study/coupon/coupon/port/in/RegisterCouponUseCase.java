package com.study.coupon.coupon.port.in;

import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.port.in.command.RegisterCouponCommand;

public interface RegisterCouponUseCase {
    void register(RegisterCouponCommand command);
    void validate(Coupon coupon);
}
