package commerce.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerMeController() {

    @GetMapping("/seller/me")
    void me() {

    }
}
