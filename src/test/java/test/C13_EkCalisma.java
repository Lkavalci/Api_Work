package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C13_EkCalisma {

    /*
    C13_Get_SoftAssertIleExpectedDataTesti
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

       Response Body
            {
            "status": "success",
            "data": {
                        "id": 3,
                         "employee_name": "Ashton Cox",
                         "employee_salary": 86000,
                         "employee_age": 66,
                         "profile_image": ""
                         },
            "message": "Successfully! Record has been fetched."
            }
     */

    @Test
    public void get01(){

     //   1 - url hazirlayalim ve edpoint'e gidelim

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - expected data hazirlayalim

        JSONObject expData = new JSONObject();

        expData.put("id", 3);
        expData.put("employee_name", "Ashton Cox");
        expData.put("employee_salary", 86000);
        expData.put("employee_age", 66);
        expData.put("profile_image", "");

        JSONObject expBody = new JSONObject();

        expBody.put("status", "success");
        expBody.put("data", expData);
        expBody.put("message", "Successfully! Record has been fetched.");



        // 3 - Response hazirlayalim

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(expBody.get("status"), respJP.get("status"));
        assertEquals(expBody.get("message"), respJP.get("message"));

        assertEquals(expBody.getJSONObject("data").get("id"),respJP.get("data.id"));
        assertEquals(expBody.getJSONObject("data").get("employee_name"),respJP.get("data.employee_name"));
        assertEquals(expBody.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        assertEquals(expBody.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        assertEquals(expBody.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));

    }
}
