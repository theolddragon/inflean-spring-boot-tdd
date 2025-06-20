package commerce.api.controller;

import commerce.view.ShopperMeView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public record ShopperMeController() {

    @GetMapping("/shopper/me")
    ShopperMeView me() {
        return new ShopperMeView(UUID.randomUUID(), null, null);
    }
}
