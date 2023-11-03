import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

public class LoginCustomerWithWrongCredsFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;

    @Test
    @DisplayName("Check to login new courier  with invalid credentials")
    @Description("Successful login test for /api/v1/courier/login endpoint")
    public void checkLoginCustomerWithWrongCreds() {
        customer = CustomerGenerator.random();
        ValidatableResponse loginResponse = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(loginResponse);
        CustomerOperations.delete(bearer);
        ValidatableResponse deletedCreds = CustomerOperations.login(CustomerCredentials.from(customer));
        check.isLoginWithWrongCredsForbidden(deletedCreds);
    }

}
