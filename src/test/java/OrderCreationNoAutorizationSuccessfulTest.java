import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class OrderCreationNoAutorizationSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private final OrderCreation newOrder = new OrderCreation();
    private String noBearer;
    private Customer customer;
    private Order order;
    @Test
    @DisplayName("Check to create order without authorization valid ingredients")
    @Description("Successful POST-test for /api/orders endpoint")
    public void checkCreateNewOrderWithRightData() {
        noBearer = "";
        ValidatableResponse response = OrderCreation.create(noBearer, OrderGenerator.rightsIngredients());
        check.isOrderIsSuccessful(response);
    }
}
