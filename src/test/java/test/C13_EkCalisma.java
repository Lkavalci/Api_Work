package test;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

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

     //   1 - url ve edpoint'e git

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2 - expected data hazirla

        JSONObject expBody = new JSONObject();

        // 3 - Response hazirla

        Response response =



    }
}
