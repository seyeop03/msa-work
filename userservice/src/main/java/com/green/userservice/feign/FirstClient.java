package com.green.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * FeignClient
 */
@FeignClient(name = "first-service", url = "${first-service-url}")
public interface FirstClient {

    @GetMapping("/first-service/test")
    String test();
}
