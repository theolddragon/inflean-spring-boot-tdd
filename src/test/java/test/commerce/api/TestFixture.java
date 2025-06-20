package test.commerce.api;

import commerce.command.CreateShopperCommand;
import commerce.query.IssueShopperToken;
import commerce.result.AccessTokenCarrier;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

import static test.commerce.EmailGenerator.generateEmail;
import static test.commerce.PasswordGenerator.generatePassword;
import static test.commerce.UsernameGenerator.generateUsername;

public record TestFixture(TestRestTemplate client) {

    public String createShopperThenIssueToken() {
        String email = generateEmail();
        String password = generatePassword();
        this.createShopper(email, generateUsername(), password);
        return this.issueShopperToken(email, password);
    }

    public void createShopper(String email, String username, String password) {
        var command = new CreateShopperCommand(email, username, password);
        client.postForEntity("/shopper/signUp", command, Void.class);
    }

    public String issueShopperToken(String email, String password) {
        AccessTokenCarrier carrier = client.postForObject(
            "/shopper/issueToken",
            new IssueShopperToken(email, password),
            AccessTokenCarrier.class
        );
        return carrier.accessToken();
    }

    public void setShopperAsDefaultUser(String email, String password) {
        String token = issueShopperToken(email, password);
        RestTemplate template = client.getRestTemplate();
        template.getInterceptors().add((request, body, execution) -> {
           if (!request.getHeaders().containsKey("Authorization")) {
               request.getHeaders().add("Authorization", "Bearer " + token);
           }

           return execution.execute(request, body);
        });
    }
}
