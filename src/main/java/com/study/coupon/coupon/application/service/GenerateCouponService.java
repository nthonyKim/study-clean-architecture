package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.adapter.out.persistence.CouponEntity;
import com.study.coupon.coupon.adapter.out.persistence.CouponRepository;
import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.application.port.in.command.GenerateCouponCommand;
import com.study.coupon.coupon.application.port.in.GenerateCouponUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GenerateCouponService implements GenerateCouponUseCase {

    private final CouponRepository couponRepository;
    private final CouponConverter couponConverter;

    @Override
    public String generate(GenerateCouponCommand command) {
        CouponEntity entity = couponConverter.domainToEntity(Coupon.generate(command.getPoint(), command.getType()));
        couponRepository.save(entity);

        return entity.getCode();
    }
}
