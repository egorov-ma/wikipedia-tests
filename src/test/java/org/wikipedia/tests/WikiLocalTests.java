package org.wikipedia.tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("local")
@DisplayName("Тестировании мобильного приложения Wikipedia на локальном эмуляторе")
public class WikiLocalTests extends TestBase {
    @Test
    @DisplayName("Проверка onboarding screen")
    void onBoardingPagesTest() {
        step("Проверить первую страницу", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить вторую страницу", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить третью страницу", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверить четвертую страницу", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/acceptButton")).click();
        });
    }

    @Test
    @DisplayName("Открытие первой найденной ссылки")
    void successfulSearchTest() {
        back();
        step("Отправляем запрос в википедии", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверяем, что обнаружены результаты поиска", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка поиска")
    void searchPageTest() {
        step("Закрыть экран настроек", () -> back());

        step("Перейти в меню поиска", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/nav_more_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/main_drawer_settings_container")).click();
            $$(AppiumBy.id("android:id/title")).findBy(text("Explore Feed")).click();
        });
        step("Проверить, что результатов страницы поиска больше 1", () ->
                $$(AppiumBy.id("org.wikipedia.alpha:id/feed_content_type_title"))
                        .shouldHave(sizeGreaterThan(1)));
    }
}