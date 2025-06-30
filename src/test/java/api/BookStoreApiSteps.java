package api;

import specs.Specs;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class BookStoreApiSteps {

    public static void addBook(String token, String userId, String isbn) {
        AddBookRequest request = new AddBookRequest(userId, isbn);

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(request)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(Specs.responseSpec(201));
    }

    public static void deleteBook(String token, String userId, String isbn) {
        DeleteBookRequest request = new DeleteBookRequest(userId, isbn);

        given()
                .header("Authorization", "Bearer " + token)
                .body(request)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .log().all()
                .spec(Specs.responseSpec(204));
    }

    public static void deleteAllBooks(String token, String userId) {
        given()
                .header("Authorization", "Bearer " + token)
                .queryParam("UserId", userId)
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(Specs.responseSpec(204));
    }
}