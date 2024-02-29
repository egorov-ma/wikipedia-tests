package org.wikipedia.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("remote")
@DisplayName("Тестировании мобильного приложения Wikipedia на удаленном эмуляторе")
public class WikiRemoteTests extends TestBase {
    @Test
    @DisplayName("Проверить непустой список выдачи при запросе")
    void successfulSearchTest() {
        step("Сделать поисковой запрос", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Porsche");
        });

        step("Проверить результат запроса", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }
}