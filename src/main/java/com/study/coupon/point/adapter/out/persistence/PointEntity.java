package com.study.coupon.point.adapter.out.persistence;


import com.study.coupon.point.domain.PaymentMethodType;
import com.study.coupon.point.domain.PointStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "point")
class PointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethodType type;
    @Enumerated(EnumType.STRING)
    private PointStatus status = PointStatus.READY;
    private boolean isFree = false;
    private Long createdAt;
    private Long paidAt;
    private Long canceledAt;
}