package com.study.coupon.coupon.adapter.out.persistence;

import com.study.coupon.coupon.domain.CouponStatus;
import com.study.coupon.coupon.application.port.out.LoadCouponPort;
import com.study.coupon.coupon.application.port.out.UpdateCouponPort;
import com.study.coupon.coupon.application.service.CouponConverter;
import com.study.coupon.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
class CouponPersistenceAdapter implements LoadCouponPort, UpdateCouponPort {

    private final CouponConverter couponConverter;
    private final CouponRepository couponRepository;


    @Override
    public Optional<Coupon> byCode(String code) {
        return couponRepository.findFirstByCode(code)
                .flatMap(c -> Optional.ofNullable(couponConverter.entityToDomain(c)));
    }

    @Override
    public List<Coupon> findExpiryList(Long time, int limit) {
        return couponRepository.findByStatusAndExpiredAtBefore(CouponStatus.READY, time, PageRequest.of(0, limit))
                .stream()
                .map(couponConverter::entityToDomain)
                .toList();
    }

    @Override
    public void save(Coupon coupon) {
        couponRepository.save(couponConverter.domainToEntity(coupon));
    }
}
