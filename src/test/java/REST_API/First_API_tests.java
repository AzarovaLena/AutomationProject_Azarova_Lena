package REST_API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class First_API_tests {
    @BeforeTest
    public void preconditions() {
        RestAssured.baseURI = "https://reqres.in/";
    }

    @Test (priority = 1)
    public void listUsers_Test1() {
        String endpoint = "/api/users?page=2";
       given().contentType(ContentType.JSON)
                .when().get(endpoint)
               .then().statusCode(200).and().body("page", equalTo(2)).and().body("data[0].id", equalTo(7));
    }
    @Test (priority = 2)
    public void SingleUser_Test2() {
        String endpoint = "/api/users/2";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(200).and().body("data.email", equalTo("janet.weaver@reqres.in"));
    }
    @Test (priority = 3)
    public void SingleUserNotFound_Test3() {
        String endpoint = "/api/users/23";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(404);
    }
    @Test (priority = 4)
    public void ListResource_Test4() {
        String endpoint = "/api/unknown";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(200).and().body("data.size()", equalTo(6));
    }
    @Test (priority = 5)
    public void SingleResource_Test5() {
        String endpoint = "/api/unknown/2";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(200).and().body("data.name", equalTo("fuchsia rose"));
    }
    @Test (priority = 6)
    public void SingleResourceNotFound_Test6() {
        String endpoint = "/api/unknown/23";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(404);
    }
    @Test (priority = 7)
    public void Create_Test7() {
        String endpoint = "/api/users";
        String requestBody =readFileAsString("postForTest_7");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().post(endpoint)
                .then().statusCode(201).body("name", equalTo("morpheus")).and().body("job", equalTo("leader"));
    }
    @Test (priority = 8)
    public void Update_Test8() {
        String endpoint = "/api/users/2";
        String requestBody =readFileAsString("putForTest_8");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().put(endpoint)
                .then().statusCode(200).body("name", equalTo("morpheus")).and().body("job", equalTo("zion resident"));
    }
    @Test (priority = 9)
    public void Update_Test9() {
        String endpoint = "/api/users/2";
        String requestBody =readFileAsString("patchForTest_9");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().patch(endpoint)
                .then().statusCode(200).body("name", equalTo("morpheus")).and().body("job", equalTo("zion resident"));
    }
    @Test (priority = 10)
    public void delete_Test10() {
        String endpoint = "/api/users/2";
        given().contentType(ContentType.JSON)
                .when().delete(endpoint)
                .then().statusCode(204);
    }
    @Test (priority = 11)
    public void registerSuccessful_Test11() {
        String endpoint = "/api/register";
        String requestBody =readFileAsString("postForTest_11");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().post(endpoint)
                .then().statusCode(200).body("id", equalTo(4)).and().body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
    @Test (priority = 12)
    public void registerUnsuccessful_Test12() {
        String endpoint = "/api/register";
        String requestBody =readFileAsString("postForTest12");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().post(endpoint)
                .then().statusCode(400).body("error", equalTo("Missing password"));
    }
    @Test (priority = 13)
    public void loginSuccessful_Test13() {
        String endpoint = "/api/login";
        String requestBody =readFileAsString("postForTest_13");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().post(endpoint)
                .then().statusCode(200).body("token", equalTo("QpwL5tke4Pnpja7X4"));
    }
    @Test (priority = 14)
    public void loginUnsuccessful_Test14() {
        String endpoint = "/api/login";
        String requestBody =readFileAsString("postForTest_14");
        given().header("Content-Type","application/json" ).body(requestBody)
                .when().post(endpoint)
                .then().statusCode(400).body("error", equalTo("Missing password"));
    }
    @Test (priority = 15)
    public void delayedResponse_Test15()  {
        String endpoint = "api/users?delay=3";
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(200).body("page", equalTo(1)).and().body("data.size()", equalTo(6));
    }


    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/REST_API/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}


