package commerce.command.api.controller;

import commerce.command.CreateSellerCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public record SellerSignUpController() {

    @PostMapping("/seller/signUp")
    ResponseEntity<?> signUp(@RequestBody CreateSellerCommand command) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        if (command.email() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!command.email().matches(emailRegex)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.noContent().build();
    }
}
