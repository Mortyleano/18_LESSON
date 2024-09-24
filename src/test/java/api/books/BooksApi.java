package api.books;

import helpers.WebDriverCookieManager;
import io.qameta.allure.Step;
import models.BookModel;
import models.IsbnDataModel;

import java.util.List;

import static io.restassured.RestAssured.given;
import static specs.AddBookSpec.addBookRequestSpec;
import static specs.AddBookSpec.addBookResponseSpec;

public class BooksApi {

    private final static String DEFAULT_ISBN_ID = "9781449325862";
    private final static String API_PATH_BOOKS = "/BookStore/v1/Books";
    private final static String TOKEN = WebDriverCookieManager.extactValueFromCookieString("token");
    private final static String USER_ID = WebDriverCookieManager.extactValueFromCookieString("userID");

    @Step("Добавляем книгу в коллекцию")
    public void addBookToCollections() {
        List<IsbnDataModel> books = List.of(new IsbnDataModel(DEFAULT_ISBN_ID));
        BookModel bookData = new BookModel(USER_ID, books);

        given(addBookRequestSpec)
                .header("Authorization", "Bearer " + TOKEN)
                .body(bookData)
                .when()
                .post(API_PATH_BOOKS)
                .then()
                .spec(addBookResponseSpec)
                .extract().response();
    }
}