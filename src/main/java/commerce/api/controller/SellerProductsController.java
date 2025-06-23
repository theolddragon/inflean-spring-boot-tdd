package commerce.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerProductsController() {

    @PostMapping("/seller/products")
    ResponseEntity<?> registerProducts() {
        return ResponseEntity.status(201).build();
    }
}
