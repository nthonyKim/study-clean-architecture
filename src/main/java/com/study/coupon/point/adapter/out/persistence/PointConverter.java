package com.study.coupon.point.adapter.out.persistence;

import com.study.coupon.common.application.EntityConverter;
import com.study.coupon.point.domain.Point;
import org.springframework.stereotype.Component;

@Component
class PointConverter implements EntityConverter<PointEntity, Point> {

    @Override
    public Point entityToDomain(PointEntity entity) {
        if (entity == null) {
            return null;
        }

        Point point = new Point();
        point.setId(entity.getId());
        point.setUserId(entity.getUserId());
        point.setAmount(entity.getAmount());
        point.setType(entity.getType());
        point.setStatus(entity.getStatus());
        point.setFree(entity.isFree());
        point.setCreatedAt(entity.getCreatedAt());
        point.setPaidAt(entity.getPaidAt());
        point.setCanceledAt(entity.getCanceledAt());
        return point;
    }

    @Override
    public PointEntity domainToEntity(Point point) {
        if (point == null) {
            return null;
        }

        PointEntity entity = new PointEntity();
        entity.setId(point.getId());
        entity.setUserId(point.getUserId());
        entity.setAmount(point.getAmount());
        entity.setType(point.getType());
        entity.setStatus(point.getStatus());
        entity.setFree(point.isFree());
        entity.setCreatedAt(point.getCreatedAt());
        entity.setPaidAt(point.getPaidAt());
        entity.setCanceledAt(point.getCanceledAt());
        return entity;
    }
}
