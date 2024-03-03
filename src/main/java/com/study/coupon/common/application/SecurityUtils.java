package com.study.coupon.common.application;


import com.study.coupon.user.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtils {

    public static Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof User) {
            return (Optional<User>) principal;
        }

        throw new IllegalStateException("not exists User");
    }
}
