package com.study.coupon.coupon.port.in.command;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class RegisterCouponCommand {
    @NotNull
    String code;
}
