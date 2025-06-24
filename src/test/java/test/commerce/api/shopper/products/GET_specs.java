package test.commerce.api.shopper.products;

import java.util.List;
import java.util.UUID;

import commerce.view.PageCarrier;
import commerce.view.ProductView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import test.commerce.api.CommerceApiTest;
import test.commerce.api.TestFixture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.get;

@CommerceApiTest
@DisplayName("GET /shopper/products")
public class GET_specs {

    public static final int PAGE_SIZE = 10;

    @Test
    void 올바르게_요청하면_200_OK_상태코드를_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange
        fixture.createShopperThenSetAsDefaultUser();

        // Act
        ResponseEntity<PageCarrier<ProductView>> response =
            fixture.client().exchange(
                get("/shopper/products").build(),
                new ParameterizedTypeReference<>() { }
            );

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }

    @Test
    void 판매자_접근_토큰을_사용하면_403_Forbidden_상태코드를_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange
        fixture.createSellerThenSetAsDefaultUser();

        // Act
        ResponseEntity<PageCarrier<ProductView>> response =
            fixture.client().exchange(
                get("/shopper/products").build(),
                new ParameterizedTypeReference<>() { }
            );

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(403);
    }

    @Test
    void 첫_번째_페이지의_상품을_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange
        fixture.deleteAllProducts();

        fixture.createSellerThenSetAsDefaultUser();
        List<UUID> ids = fixture.registerProducts(PAGE_SIZE);

        fixture.createShopperThenSetAsDefaultUser();

        // Act
        ResponseEntity<PageCarrier<ProductView>> response =
            fixture.client().exchange(
                get("/shopper/products").build(),
                new ParameterizedTypeReference<>() { }
            );

        // Assert
        PageCarrier<ProductView> actual = response.getBody();
        assertThat(actual).isNotNull();
        assertThat(actual.items()).extracting(ProductView::id).containsAll(ids);
    }

    @Test
    void 상품_목록을_등록_시점_역순으로_정렬한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 상품_정보를_올바르게_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 판매자_정보를_올바르게_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 두_번째_페이지를_올바르게_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 마지막_페이지를_올바르게_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void continuationToken_매개변수에_빈_문자열이_지정되면_첫_번째_페이지를_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }
}
