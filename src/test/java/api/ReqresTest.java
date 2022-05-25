package api;

//import com.sun.tools.javac.util.Assert;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import org.junit.jupiter.api.Test;

//import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReqresTest {
    private static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON)
                .get(URL + "/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data",UserData.class);
        users.forEach(x-> assertTrue(x.getAvatar().contains(x.getId().toString())));


    }
}
