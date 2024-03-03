package com.study.coupon.point.domain.event;

import com.study.coupon.point.domain.Point;

public class PointEvent {

    public record Completed(Point point) {}
}
