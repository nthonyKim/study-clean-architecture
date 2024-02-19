package com.study.coupon.coupon.port.in.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.study.coupon.coupon.CouponType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.Range;

import java.util.stream.Stream;

@Value
public class GenerateCouponCommand {
    @NotNull
    @Min(100)
    @Max(50000)
    Long point;
    @NotNull
    CouponType type;

    @JsonCreator
    public static CouponType by(String value) {
        return Stream.of(CouponType.values())
                .filter(couponType -> couponType.toString().equals(value.toUpperCase()))
                .findFirst()
                .orElse(null);
    }
}
