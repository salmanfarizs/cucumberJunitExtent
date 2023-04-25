package pages;

import hooks.Hooks;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLoginPage {

	public void getToken() {

		try {
			RestAssured.baseURI = "https://reqres.in/api";

			Response response = RestAssured.given().contentType(ContentType.JSON).get("/users?page=2");

			System.out.println(response.getStatusCode());
			System.out.println(response.getBody().asString());
			Hooks.test.pass("Api captured");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Hooks.test.pass("Api not captured");

		}

	}

}
