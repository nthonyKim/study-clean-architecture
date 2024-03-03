package com.study.coupon.point.application.port.in.command;

import com.study.coupon.point.domain.PaymentMethodType;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PaymentPointCommand {
    @NotNull
    Long amount;
    @NotNull
    PaymentMethodType type;
}
