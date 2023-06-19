package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.

                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body - Expected Body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
*/
    @Test
    public void post01(){

        // 1- Url ve Request Body hazirla

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates = new JSONObject();

        bookingdates.put("checkin", "2021-06-01");
        bookingdates.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();

        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", bookingdates);
        reqBody.put("additionalneeds", "wi-fi");

        // 2 - Expected Data hazirla

        JSONObject expData = new JSONObject();

        expData.put("bookingid", 24);
        expData.put("booking", reqBody);

        // 3 - Response kaydet

        Response response = given().contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();

        // 4 - Assertion

        JsonPath resJP = response.jsonPath();

        assertEquals(expData.getJSONObject("booking").get("firstname"), resJP.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"), resJP.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"), resJP.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"), resJP.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"), resJP.get("booking.additionalneeds"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates"), resJP.get("checkin"), resJP.get("booking.bookingdates.checkout"));


    }


}
