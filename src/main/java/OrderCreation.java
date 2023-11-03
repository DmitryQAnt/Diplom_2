import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;


public class OrderCreation extends GeneralURL {
    public static final String ORDER_PATH = "/orders";
    @Step("Creation of order")
    public static ValidatableResponse create(String accessToken, Order order) {
        return getRequestSpecification()
                .log().all()
                .auth().oauth2(accessToken)
                .and()
                .body(order)
                .when()
                .post(ORDER_PATH)
                .then();
    }
    @Step("Receiving list of authorized client's orders")
    public static ValidatableResponse receiveOrderList(String accessToken) {
        return getRequestSpecification()
                .log().all()
                .auth().oauth2(accessToken)
                .when()
                .get(ORDER_PATH)
                .then();
    }
    @Step("Receiving no authorized client's orders")
    public static ValidatableResponse receiveOrderListNoAuthorization() {
        return getRequestSpecification()
                .log().all()
                .when()
                .get(ORDER_PATH)
                .then();
    }
}
