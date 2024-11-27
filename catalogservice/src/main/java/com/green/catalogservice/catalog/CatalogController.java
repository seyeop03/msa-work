package com.green.catalogservice.catalog;


import com.green.catalogservice.catalog.service.CatalogService;
import com.green.catalogservice.catalog.vo.CatalogRequest;
import com.green.catalogservice.catalog.vo.CatalogResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping("join")
    public ResponseEntity<?> joinUser(@Valid @RequestBody CatalogRequest catalogRequest) {

        catalogService.join(catalogRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("login/{user-id}")
    public ResponseEntity<CatalogResponse> getOrder(@PathVariable("order-id") Long orderId) {
        CatalogResponse catalogResponse = catalogService.getOrder(orderId);
        return ResponseEntity.ok(catalogResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> getKakaoLogin() {
        return ResponseEntity.ok(null);
    }
}
