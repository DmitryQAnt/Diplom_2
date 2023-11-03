import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CustomerGenerator {
    @Step("Generating of random customer login")
    public static Customer random() {
        return new Customer(RandomStringUtils.randomAlphanumeric(5,10) + "@yandex.ru", "password", "murachka");
    }

    @Step("Generating customer without password field")
    public static Customer CustomerWithoutPasswordField() {
        return new Customer("ulan-udensky@yandex.ru", null, "murachka");
    }
    @Step("Generating customer with constant creds")
    public static Customer CustomerBasic() {
        return new Customer("ulan-udensky@yandex.ru", "password", "murachka");
    }
    @Step("Generating customer with different password")
    public static Customer CustomerWrongPassword() {
        return new Customer ("ulan-udensky@yandex.ru", "wrongpassword", "murachka");
    }
    @Step("Generating customer with empty login field")
    public static Customer CustomerWithoutLogin() {
        return new Customer("", "password", "murachka");
    }
}
