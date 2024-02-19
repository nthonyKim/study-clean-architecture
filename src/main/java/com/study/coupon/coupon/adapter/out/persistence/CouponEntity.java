package com.study.coupon.coupon.adapter.out.persistence;


import com.study.coupon.coupon.CouponStatus;
import com.study.coupon.coupon.CouponType;
import jakarta.persistence.*;

@Entity
@Table(name = "coupon")
public class CouponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String code;

    private int point;
    @Enumerated(EnumType.STRING)
    private CouponType type;
    @Enumerated(EnumType.STRING)
    private CouponStatus status;
    private Long createdAt;
    private Long usedAt;
    private Long expiredAt;
}