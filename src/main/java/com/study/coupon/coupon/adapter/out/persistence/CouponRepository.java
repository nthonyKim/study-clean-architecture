package com.study.coupon.coupon.adapter.out.persistence;

import com.study.coupon.coupon.domain.CouponStatus;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
    Optional<CouponEntity> findFirstByCode(String code);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT c FROM CouponEntity c WHERE c.status = :status AND c.expiredAt < :time ORDER BY c.expiredAt ASC")
    List<CouponEntity> findByStatusAndExpiredAtBefore(CouponStatus status, Long time, Pageable pageable);

}
