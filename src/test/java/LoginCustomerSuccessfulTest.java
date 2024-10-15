import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class LoginCustomerSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;

    @Test
    @DisplayName("Check to login new courier  with valid credentials")
    @Description("Successful login test for /api/v1/courier/login endpoint")
    public void checkCreateNewCustomerWithUniqueData() {
        customer = CustomerGenerator.random();
        CustomerOperations.create(customer);
        ValidatableResponse loginResponse = CustomerOperations.login(CustomerCredentials.from(customer));
        bearer = newCustomer.getAuthorizationBearer(loginResponse);
        check.loggedInSuccessfully(loginResponse);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
