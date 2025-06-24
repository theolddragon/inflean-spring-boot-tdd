package commerce.view;

public record PageCarrier<ProductView>(
    ProductView[] items,
    String continuationToken
) {
}
