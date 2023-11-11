import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;

public class CustomerGenerator {
    @Step("Generating of random customer login")
    public static Customer random() {
        return new Customer(RandomStringUtils.randomAlphanumeric(5,10) + "@yandex.ru", "password", "murachka");
    }

    @Step("Generating customer without password field")
    public static Customer customerWithoutPasswordField() {
        return new Customer("ulan-udensky@yandex.ru", null, "murachka");
    }
    @Step("Generating customer with constant creds")
    public static Customer customerBasic() {
        return new Customer("ulan-udensky@yandex.ru", "password", "murachka");
    }
    @Step("Generating customer with different password")
    public static Customer customerWrongPassword() {
        return new Customer ("ulan-udensky@yandex.ru", "wrongpassword", "murachka");
    }
    @Step("Generating customer with empty login field")
    public static Customer customerWithoutLogin() {
        return new Customer("", "password", "murachka");
    }
}
