import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreateCustomerFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;


    @Test
    @DisplayName("Check create customer WithoutRequiredField (password)")
    @Description("Basic negative test for /auth/register endpoint")
    public void checkCreateCustomerWithoutRequiredFieldIsFailing() {
        customer = CustomerGenerator.customerWithoutPasswordField();
        ValidatableResponse response = CustomerOperations.create(customer);
        check.isTheRegistrationWithoutPasswordIsForbidden(response);
    }

    @Test
    @DisplayName("Check already created customer ")
    @Description("Basic negative test for /auth/register endpoint")
    public void checkCreateExistedCustomerIsFailing() {
        customer = CustomerGenerator.random();
        ValidatableResponse newClient = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(newClient);
        ValidatableResponse theSameClient = CustomerOperations.create(customer);
        check.isTheSameCustomerRegistrationForbidden(theSameClient);
        CustomerOperations.delete(bearer);
    }

}
