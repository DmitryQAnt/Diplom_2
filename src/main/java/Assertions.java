import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.CoreMatchers.equalTo;

public class Assertions {
    @Step("Assert is new courier is created successfully, code 200")
    public void assertCreatedSuccess(ValidatableResponse response) {
        response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("success", equalTo(true));
    }
    @Step("Assert is  courier is login in successfully, code 200")
    public void loggedInSuccessfully(ValidatableResponse loginResponse) {
        loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("success", equalTo(true));
    }

    @Step("Assert data is updated successfully, code 200")
    public void updatingDataIsSuccessful(ValidatableResponse loginResponse) {
        loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("success", equalTo(true));
    }

    @Step("Assert is customer is deleted")
    public void isDeleteIsSuccessfully(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_ACCEPTED)
                .body("success", equalTo(true));
    }
    @Step("Assert is order is in progress")
    public void isOrderIsSuccessful(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("name", equalTo("Space метеоритный флюоресцентный бургер"));
    }
    @Step("Assert is order is in progress")
    public void isTheSameCustomerRegistrationForbidden(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN)
                .body("message", equalTo("User already exists"));
    }

    public void isTheRegistrationWithoutPasswordIsForbidden(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_FORBIDDEN)
                .body("message", equalTo("Email, password and name are required fields"));
    }

    public void isLoginWithWrongCredsForbidden(ValidatableResponse deletedCreds) {
        deletedCreds .assertThat()
                .statusCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                .body("message", equalTo("email or password are incorrect"));
    }

    public void updatingDataIsFail(ValidatableResponse response1) {
        response1
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                .body("success", equalTo(false));
    }
    @Step("Assert is order is impossible")
    public void isOrderIsImpossible(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .body("success", equalTo(false));
    }
    @Step("Assert is server return 500")
    public void isOrderIsServerReturn500(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_SERVER_ERROR);
    }
    @Step("Assert is order exist")
    public void isOrderExist(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .body("success", equalTo(true));
    }
    @Step("Assert is receive order's list without authorization is impossible")
    public void isGettingOrderIsImpossible(ValidatableResponse response) {
        response .assertThat()
                .statusCode(HttpURLConnection.HTTP_UNAUTHORIZED)
                .body("success", equalTo(false));
    }
}
