package com.study.coupon.coupon.application.port.in;

import com.study.coupon.coupon.application.port.in.command.GenerateCouponCommand;

public interface GenerateCouponUseCase {
    String generate(GenerateCouponCommand command);
}
