package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    /*
           http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
           donen Response'in
           status code'unun 200,
           ve content type'inin application/json,
           ve response body'sindeki
               employees sayisinin 24
               ve employee'lerden birinin "Ashton Cox"
               ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
           test edin.
    */
    @Test
    public void get01(){

        // 1- URL hazirlayalim

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2 - Expected data hazirla (bu 2. adim fakat soruda bizden bunu istemiyor bu yüzden bu adimi atliyoruz.
        // eger 3 P den biri olsaydı yani put, patch veya post ozaman 2. adımı uygulayacaktık.)

        // 3 - Response'i kaydedelim.

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        response
                .then()
                .assertThat()
                .statusCode(200).contentType("application/json")
                .body("data.id", Matchers.hasSize(24)
                       , "data.employee_name", Matchers.hasItem("Ashton Cox")
                        , "data.employee_age", Matchers.hasItems(61,40,30));
    }

}
