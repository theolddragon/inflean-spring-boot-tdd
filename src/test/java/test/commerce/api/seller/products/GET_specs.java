package test.commerce.api.seller.products;

import commerce.view.ArrayCarrier;
import commerce.view.SellerProductView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import test.commerce.api.CommerceApiTest;
import test.commerce.api.TestFixture;

import static org.assertj.core.api.Assertions.assertThat;

@CommerceApiTest
@DisplayName("GET /seller/products")
public class GET_specs {

    @Test
    void 올바르게_요청하면_200_OK_상태코드를_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange
        fixture.createSellerThenSetAsDefaultUser();

        // Act
        ResponseEntity<ArrayCarrier<SellerProductView>> response =
            fixture.client().exchange(
                RequestEntity.get("/seller/products").build(),
                new ParameterizedTypeReference<>() { }
            );

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }

    @Test
    void 판매자가_등록한_모든_상품을_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 다른_판매자가_등록한_상품이_포함되지_않는다(
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
    void 상품_등록_시각을_올바르게_반환한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }

    @Test
    void 상품_목록을_등록_시점_역순으로_정렬한다(
        @Autowired TestFixture fixture
    ) {
        // Arrange

        // Act

        // Assert
    }
}
