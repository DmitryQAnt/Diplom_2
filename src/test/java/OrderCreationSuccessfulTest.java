import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class OrderCreationSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private String bearer;
    private Customer customer;
    private String noBearer;

    @Test
    @DisplayName("Check to create order with authorization and valid ingredients")
    @Description("Successful POST-test for /api/orders endpoint")
    public void checkCreateNewOrderWithAuthorisation() {
        customer = CustomerGenerator.random();
        bearer = newCustomer.getAuthorizationBearer(CustomerOperations.create(customer));
        System.out.println(bearer);
        ValidatableResponse response = OrderCreation.create(bearer, OrderGenerator.rightsIngredients());
        check.isOrderIsSuccessful(response);
        CustomerOperations.delete(bearer);
    }
    @Test
    @DisplayName("Check to create order without authorization valid ingredients")
    @Description("Successful POST-test for /api/orders endpoint")
    public void checkCreateNewOrderWithNoAuthorisation() {
        noBearer = "";
        ValidatableResponse response = OrderCreation.create(noBearer, OrderGenerator.rightsIngredients());
        check.isOrderIsSuccessful(response);
    }
}
