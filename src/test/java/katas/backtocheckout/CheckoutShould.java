package katas.backtocheckout;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutShould {
    private Checkout checkout;

    private Map<Character, Integer> priceList = Map.of(
            'A', 50,
            'B', 30,
            'C', 20,
            'D', 15);
    private Map<Character, Promotion> promotions = Map.of(
            'A', new Promotion(3, 130),
            'B', new Promotion(2, 45));

    @BeforeEach
    public void setup() {
        checkout = new Checkout(priceList);
    }

    @ParameterizedTest
    @CsvSource({
            "A, 50",
            "AA, 100",
            "AB, 80",
            "ABCD, 115"
    })
    public void
    calculate_total_price_for_single_product(String productCodes, int total) {
        for (char c : productCodes.toCharArray()) {
            checkout.scan(c);
        }

        assertThat(checkout.total()).isEqualTo(total);
    }

    @ParameterizedTest
    @CsvSource({
            "AAA, 130",
            "AAAA, 180",
            "AAAB, 160",
            "AAABB, 175",
            "AAABBD, 190",
            "DABABA, 190"
    })
    public void
    calculate_total_price_for_products_on_promotion(String productCodes, int total) {
        checkout = new Checkout(priceList, promotions);

        for (char c : productCodes.toCharArray()) {
            checkout.scan(c);
        }

        assertThat(checkout.total()).isEqualTo(total);
    }
}
