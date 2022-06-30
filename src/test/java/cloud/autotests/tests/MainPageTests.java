package cloud.autotests.tests;

import cloud.autotests.helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Login modal form should appear on main page")
    void generatedTest() {
        step("Open url 'https://habr.com/'", () ->
                open("https://habr.com/"));

        step("Click on Profile button", () ->
                $("[data-test-id=menu-toggle-guest]").click());

        step("Login modal should be visible", () ->
                $(".tm-user-menu").shouldBe(visible));
    }

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://habr.com/'", () ->
                open("https://habr.com/"));

        step("Page title should have text 'All posts in a row / Habr'", () -> {
            String expectedTitle = "All posts in a row / Habr";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://habr.com/'", () ->
                open("https://habr.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}