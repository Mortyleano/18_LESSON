package api.authtorization;

import io.restassured.response.Response;
import models.AuthorizationModel;

import static io.restassured.RestAssured.given;
import static specs.AuthorizationUserSpec.authorizationRequestSpec;
import static specs.AuthorizationUserSpec.authorizationResponseSpec;


public class AuthorizationApi {

    private final static String DEFAULT_USER_NAME = "qa_user";
    private final static String DEFAULT_PASSWORD = "QA_user1%";
    private final static String API_PATH_LOGIN = "/Account/v1/Login";

    public Response getAuthorizationResponse() {
        AuthorizationModel model = new AuthorizationModel(DEFAULT_USER_NAME, DEFAULT_PASSWORD);

        return given(authorizationRequestSpec)
                .body(model)
                .when()
                .post(API_PATH_LOGIN)
                .then()
                .spec(authorizationResponseSpec)
                .extract().response();
    }
}