import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreateCustomerSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;


    @Test
    @DisplayName("Check to create new customer with valid data")
    @Description("Basic test for /auth/register endpoint")
    public void checkCreateNewCustomer() {
        customer = CustomerGenerator.random();
        ValidatableResponse response = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(response);
        check.assertCreatedSuccess(response);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }

}
