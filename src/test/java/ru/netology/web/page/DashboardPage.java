package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.visible;

public class DashboardPage() {

public DashboardPage() {
    heading.shouldBe(visible);
}

public int getCardBalance(String maskedCardNumber) {
    var text = cards.findBy(Condition.text(maskedCardNumber)).getText();
    return extractBalance(text);
}

public void reloadDashboardPage() {
    reloadButton.click();
    heading.shouldBe(visible);
}

private int extractBalance(String text) {
    var start = text.indexOf(balanceStart);
    var finish = text.indexOf(balanceFinish);
    var value = text.substring(start + balanceStart.length(), finish);
    return Integer.parseInt(value);

}
}

