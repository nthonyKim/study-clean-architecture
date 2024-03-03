package com.study.coupon.point.application.service;

import com.study.coupon.point.application.port.in.CompletePointUseCase;
import com.study.coupon.point.application.port.out.UpdatePointPort;
import com.study.coupon.point.domain.Point;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompletePointService implements CompletePointUseCase {

    private final UpdatePointPort updatePointPort;

    @Override
    @Transactional
    public void complete(Point point) {
        point.complete();
        updatePointPort.save(point);
    }
}
