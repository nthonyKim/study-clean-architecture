package com.study.coupon.coupon.adapter.out.persistence;

import com.study.coupon.coupon.CouponStatus;
import com.study.coupon.coupon.domain.Coupon;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    Optional<CouponEntity> findFirstByCode(String code);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<CouponEntity> findTop100ByStatusAndExpiredAtBefore(CouponStatus status, Long time);

}
