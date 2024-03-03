package com.study.coupon.point.application.port.in;

import com.study.coupon.point.application.port.in.command.PaymentPointCommand;
import com.study.coupon.point.domain.Point;

public interface PaymentPointUseCase {
    void payment(PaymentPointCommand command);
    void validate(Point point);
}
