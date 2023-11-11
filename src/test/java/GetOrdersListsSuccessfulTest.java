import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;

public class GetOrdersListsSuccessfulTest {
    private final CustomerOperations newCustomer = new CustomerOperations();
    private final Assertions check = new Assertions();
    private final OrderCreation newOrder = new OrderCreation();
    private String bearer;
    private Customer customer;
    private Order order;
    @Test
    @DisplayName("Check to get order of authorized client")
    @Description("Successful GET-test for /api/orders endpoint")
    public void checkGetOrdersAuthorizedClient() {
        customer = CustomerGenerator.random();
        bearer = newCustomer.getAuthorizationBearer(CustomerOperations.create(customer));
        System.out.println(bearer);
        OrderCreation.create(bearer, OrderGenerator.rightsIngredients());
        ValidatableResponse response = OrderCreation.receiveOrderList(bearer);
        check.isOrderExist(response);
    }
    @Test
    @DisplayName("Check to get order of no authorized client")
    @Description("Successful GET-test for /api/orders endpoint")
    public void checkGetOrdersNoAuthorizedClient() {
        customer = CustomerGenerator.random();
        bearer = newCustomer.getAuthorizationBearer(CustomerOperations.create(customer));
        System.out.println(bearer);
        OrderCreation.create(bearer, OrderGenerator.rightsIngredients());
        ValidatableResponse response = OrderCreation.receiveOrderListNoAuthorization();
        check.isGettingOrderIsImpossible(response);
    }
    @After
    public void clearData() {
        ValidatableResponse response = CustomerOperations.delete(bearer);
        check.isDeleteIsSuccessfully(response);
    }
}
