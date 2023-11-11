import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

public class OrderGenerator {
    private static final String SPACE_SAUCE = "61c0c5a71d1f82001bdaaa73";
    private static final String BEAF_METEORIT = "61c0c5a71d1f82001bdaaa70";
    private static final String BEAN_R2_D3 = "61c0c5a71d1f82001bdaaa6d";
    private static final String WRONG_HASH = "1234567890123243";

    @Step("Generating order with rights ingredients")
    public static Order rightsIngredients() {
        List<String> ingredientsList = Arrays.asList(SPACE_SAUCE, BEAF_METEORIT, BEAN_R2_D3);
        return new Order(ingredientsList);
    }

    @Step("Generating order with without ingredients")
    public static Order withoutIngredients(){
        return new Order(null);
    }
    @Step("Generating order with wrong ingredient's hash")
    public static Order withWrongHash(){
        List<String> ingredientsList = Arrays.asList(WRONG_HASH);
        return new Order(ingredientsList);

    }
    @Step("Generating order with one ingredient")
    public static Order oneIngredient() {
        List<String> ingredientsList = Arrays.asList(SPACE_SAUCE);
        return new Order(ingredientsList);
    }
}
