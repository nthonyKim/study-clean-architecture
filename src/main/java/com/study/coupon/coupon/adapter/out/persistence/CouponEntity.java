package com.study.coupon.coupon.adapter.out.persistence;


import com.study.coupon.coupon.domain.CouponStatus;
import com.study.coupon.coupon.domain.CouponType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "coupon")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private Long point;
    @Enumerated(EnumType.STRING)
    private CouponType type;
    @Enumerated(EnumType.STRING)
    private CouponStatus status;
    private Long createdAt;
    private Long usedAt;
    private Long expiredAt;
}