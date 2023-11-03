import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class OrderCreationWrongIngredientsFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private String bearer;
    private Customer customer;
    @Test
    @DisplayName("Check to create order with wrong ingredients")
    @Description("Fail POST-test for /api/orders endpoint")
    public void checkCreateNewOrderWithoutIngredients() {
        customer = CustomerGenerator.random();
        bearer = newCustomer.getAuthorizationBearer(CustomerOperations.create(customer));
        System.out.println(bearer);
        ValidatableResponse response = OrderCreation.create(bearer, OrderGenerator.withWrongHash());
        check.isOrderIsServerReturn500(response);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
