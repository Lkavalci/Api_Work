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

        JSONObject data = new JSONObject();

        data.put("id", 3);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000);
        data.put("employee_age", 66);
        data.put("profile_image", "");

        JSONObject expData = new JSONObject();

        expData.put("status", "success");
        expData.put("data", data);
        expData.put("message", "Successfully! Record has been fetched.");



        // 3 - Response hazirlayalim

        Response response = given().when().get(url);

        response.prettyPrint();

        // 4 - Assertion

        JsonPath respJP = response.jsonPath();

        assertEquals(expData.get("status"), respJP.get("status"));
        assertEquals(expData.get("message"), respJP.get("message"));

        assertEquals(expData.getJSONObject("data").get("id"),respJP.get("data.id"));
        assertEquals(expData.getJSONObject("data").get("employee_name"),respJP.get("data.employee_name"));
        assertEquals(expData.getJSONObject("data").get("employee_salary"),respJP.get("data.employee_salary"));
        assertEquals(expData.getJSONObject("data").get("employee_age"),respJP.get("data.employee_age"));
        assertEquals(expData.getJSONObject("data").get("profile_image"),respJP.get("data.profile_image"));

    }
}
