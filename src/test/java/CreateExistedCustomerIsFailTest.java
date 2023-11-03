import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreateExistedCustomerIsFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;


    @Test
    @DisplayName("Check already created customer ")
    @Description("Basic negative test for /auth/register endpoint")
    public void checkCreateExistedCustomerIsFailing() {
        customer = CustomerGenerator.random();
        ValidatableResponse newClient = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(newClient);
        ValidatableResponse theSameClient = CustomerOperations.create(customer);
        check.isTheSameCustomerRegistrationForbidden(theSameClient);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
