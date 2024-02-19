package com.study.coupon.common.application;

public interface EntityConverter<T, D> {
    D entityToDomain(T entity);
    T domainToEntity(D domain);
}
