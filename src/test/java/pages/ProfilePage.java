package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProfilePage {

    private final SelenideElement deleteBookButton = $("#delete-record-undefined");
    private final SelenideElement confirmDeleteBook = $("#closeSmallModal-ok");
    private final SelenideElement userName = $("#userName-value");
    private final SelenideElement authorOfBook = $(".rt-tr-group");

    @Step("Открываем страницу с профилем пользователя")
    public void openProfilePage() {
        open("/profile");
    }

    @Step("Удаляем книгу из коллекции")
    public void deleteBook() {
        deleteBookButton.click();
        confirmDeleteBook.click();
        confirm();
    }

    @Step("Получаем имя пользователя в профиле")
    public String getUserName() {
        return userName.getText();
    }

    @Step("Получаем имя автора книги в списке коллекции")
    public String getAuthorBook() {
        return authorOfBook.getText();
    }
}