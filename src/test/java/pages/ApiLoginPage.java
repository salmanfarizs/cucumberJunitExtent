package pages;

import hooks.Hooks;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiLoginPage {

	public void getToken() {

		try {
			RestAssured.baseURI = "https://gorest.co.in/public/v2/posts";

			Response response = RestAssured.given().contentType(ContentType.JSON).get("/public/v2/users/507");

			System.out.println(response.getBody().asString());
			Hooks.test.pass("Api captured");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Hooks.test.pass("Api not captured");

		}

	}

}
