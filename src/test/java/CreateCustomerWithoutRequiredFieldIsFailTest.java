import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class CreateCustomerWithoutRequiredFieldIsFailTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private Customer customer;


    @Test
    @DisplayName("Check creat customer WithoutRequiredField (password)")
    @Description("Basic negative test for /auth/register endpoint")
    public void checkCreateCustomerWithoutRequiredFieldIsFailing() {
        customer = CustomerGenerator.CustomerWithoutPasswordField();
        ValidatableResponse response = CustomerOperations.create(customer);
        check.isTheRegistrationWithoutPasswordIsForbidden(response);
    }
}
