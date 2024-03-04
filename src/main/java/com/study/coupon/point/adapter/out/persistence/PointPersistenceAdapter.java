package com.study.coupon.point.adapter.out.persistence;

import com.study.coupon.point.application.port.out.UpdatePointPort;
import com.study.coupon.point.domain.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PointPersistenceAdapter implements UpdatePointPort {

    private final PointRepository pointRepository;
    private final PointConverter pointConverter;

    @Override
    public void save(Point point) {
        pointRepository.save(pointConverter.domainToEntity(point));
    }
}
