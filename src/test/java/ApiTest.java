import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class ApiTest {

    User user = new User();

    @Test(groups = "userTest")
    public void CreateUser() {
        Response response = given().header("Content-type", ContentType.JSON)
                            .body(user.convertToJson().toString())
                            .when()
                            .post("https://petstore.swagger.io/v2/user");
        Assert.assertEquals(200,response.getStatusCode());
    }


    @Test(groups = "userTest",
            priority = 1,
            dependsOnMethods = "CreateUser")
    public void getUser(){
        Response response  =   given().when().get("https://petstore.swagger.io/v2/user/Nikitka");
        Assert.assertEquals(200, response.getStatusCode());
    }


    @Test(groups = "userTest",
            priority = 2,
            dependsOnMethods = "CreateUser")
    public void deleteUser(){
        given().
                when().
                delete("https://petstore.swagger.io/v2/user/Nikitka").
                then().
                assertThat().statusCode(200);
    }

    @Test(groups = "userTest",
            priority = 1,
            dependsOnMethods = "CreateUser")
    public void loginUser(){
        given().
                queryParam("username" ,user.username).
                queryParam("password" ,user.password).
                when().
                get("https://petstore.swagger.io/v2/user/login").
                then().
                assertThat().statusCode(200);
    }

    @Test(groups = "userTest",
            priority = 1,
            dependsOnMethods = "CreateUser")
    public void logoutUser(){
        given().
                when().
                get("https://petstore.swagger.io/v2/user/logout").
                then().
                assertThat().statusCode(200);
    }
}