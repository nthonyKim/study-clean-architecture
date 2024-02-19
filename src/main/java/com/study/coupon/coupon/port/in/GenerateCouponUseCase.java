package com.study.coupon.coupon.port.in;

import com.study.coupon.coupon.port.in.command.GenerateCouponCommand;

public interface GenerateCouponUseCase {
    String generate(GenerateCouponCommand command);
}
