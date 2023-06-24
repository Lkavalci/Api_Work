package test;

import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_EkCalisma {
/*
    C14_Put_SoftAssertIleExpectedDataTesti
    http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT
    request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

        Request Body
    {
            "status": "success",
            "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                    }
     }

         Response Body
    {
             "status": "success",
              "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40 }
                    },
             "message": "Successfully! Record has been updated."
             }
 */


        @Test
    public void put01(){

            // 1 - url'ye git
            String url = "http://dummy.restapiexample.com/api/v1/update/21";

            // 2 - request body hazirla

            JSONObject reqData = new JSONObject();

            reqData.put("name", "Ahmet");
            reqData.put("salary", "1230");
            reqData.put("age", "44");
            reqData.put("id", 40);

            JSONObject reqBody = new JSONObject();

            reqBody.put("status", "success");
            reqBody.put("data", reqData);
            reqBody.put("message", "Successfully! Record has been updated.");


            // 3 - expected data hazirla

            JSONObject expData = new JSONObject();

            expData.put("status", "success");
            expData.put("data", reqData);
            expData.put("message", "Successfully! Record has been updated.");

            // 4 - Response kaydedelim
/*
            Response response = given().contentType(ContentType.JSON)
                               .when()
                                    .body(reqBody.toString()).put(url);
   */
   Response response = given().when().get(url);
            response.prettyPrint();

            // Assertion yapalim



                JsonPath resJson = response.jsonPath();






        }

}
