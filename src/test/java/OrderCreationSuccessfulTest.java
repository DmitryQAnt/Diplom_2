import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class OrderCreationSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private final OrderCreation newOrder = new OrderCreation();
    private String bearer;
    private Customer customer;
    private Order order;
    @Test
    @DisplayName("Check to create order with authorization and valid ingredients")
    @Description("Successful POST-test for /api/orders endpoint")
    public void checkCreateNewOrderWithRightData() {
        customer = CustomerGenerator.random();
        bearer = newCustomer.getAuthorizationBearer(CustomerOperations.create(customer));
        System.out.println(bearer);
        ValidatableResponse response = OrderCreation.create(bearer, OrderGenerator.rightsIngredients());
        check.isOrderIsSuccessful(response);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
