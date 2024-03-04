package com.study.coupon;

import com.study.coupon.coupon.application.port.in.command.GenerateCouponCommand;
import com.study.coupon.coupon.domain.CouponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GenerateCouponTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCouponGenerate() {
        ResponseEntity<String> response = generateCoupon(new GenerateCouponCommand(500L, CouponType.POINT));
        assertThat(response.getStatusCode().equals(HttpStatus.OK));
    }

    private ResponseEntity<String> generateCoupon(GenerateCouponCommand command) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        HttpEntity<GenerateCouponCommand> request = new HttpEntity<>(command, headers);

        return restTemplate.exchange(
                "/api/v1/coupon/generate",
                HttpMethod.POST,
                request,
                String.class);
    }
}
