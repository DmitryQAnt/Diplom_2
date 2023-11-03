import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class ChangeCustomerDataSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;
    private String bearer;
    private Customer updatedCustomer;

    @Test
    @DisplayName("Check to login new courier  with valid credentials")
    @Description("Successful login test for /api/v1/courier/login endpoint")
    public void checkCreateNewCustomerWithUniqueData() {
        customer = CustomerGenerator.random();
        ValidatableResponse response = CustomerOperations.create(customer);
        bearer = newCustomer.getAuthorizationBearer(response);
        updatedCustomer = CustomerGenerator.random();
        ValidatableResponse response2 = CustomerOperations.changeDataWithAuthorization(bearer, updatedCustomer);
        check.updatingDataIsSuccessful(response2);

    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
