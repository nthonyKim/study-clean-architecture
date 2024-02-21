package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.adapter.out.persistence.CouponEntity;
import com.study.coupon.coupon.adapter.out.persistence.CouponRepository;
import com.study.coupon.coupon.application.CouponConverter;
import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.application.port.in.RegisterCouponUseCase;
import com.study.coupon.coupon.application.port.in.command.RegisterCouponCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCouponService implements RegisterCouponUseCase {

    private final CouponRepository couponRepository;
    private final CouponConverter couponConverter;

    @Override
    public void register(RegisterCouponCommand command) {
        CouponEntity entity = couponRepository.findFirstByCode(command.getCode()).orElseThrow(() -> new RuntimeException("쿠폰이 존재하지 않음 (커스텀 예외 클래스 필요)"));
        Coupon coupon = couponConverter.entityToDomain(entity);
        validate(coupon);

        coupon.registered();
        couponRepository.save(couponConverter.domainToEntity(coupon));
    }

    @Override
    public void validate(Coupon coupon) {
        if (!coupon.useAvailable()) {
            // TODO throw
        }
    }


}
