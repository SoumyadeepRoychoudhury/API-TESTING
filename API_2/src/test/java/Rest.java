import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest {
	public static List<String[]> result = new ArrayList<String[]>();
	
	@BeforeTest
	public void setHeader() {
		result.add(new String[] { "Request Type", "Status Code","Response" });
	}

	@Test
	public void GET() {
		// Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		Response response = RestAssured.get("https://www.googleapis.com/fitness/v1/users/me/sessions");
		System.out.println(response.asString());
		// System.out.println(response.getHeaders());
		System.out.println(response.getBody());
		// System.out.println(response.getTime());
		System.out.println(response.statusCode());
		result.add(new String[] { "GET", String.valueOf(response.statusCode()), String.valueOf(response.getBody())});
		
	}

	@Test
	public void GET1() {
//		given();
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		result.add(new String[] { "GET1", String.valueOf(response.statusCode()),String.valueOf(response.getBody()) });
		
	}

//	private Rest given() {
//		// TODO Auto-generated method stub
//		return null;
//
//	}

	@Test
	public void PUT() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("job", "name");
		map.put("teacher", "shyam");
		Response response = RestAssured.get("https://www.googleapis.com/fitness/v1/users/me/sessions");
		// System.out.print(map);

		JSONObject request = new JSONObject(map);
		System.out.println(request);
		//result.add(new String[] { "PUT", String.valueOf(response.statusCode()) });
		result.add(new String[] { "PUT", String.valueOf(response.statusCode()),String.valueOf(response.getBody()) });
	}

	@Test
	public void DELETE() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.statusCode());
		//result.add(new String[] {"DELETE", String.valueOf(response.getStatusCode())});
		// when();
		// RestAssured.delete("https://reqres.in/api/users/2").then().statusCode(204);
		result.add(new String[] { "DELETE", String.valueOf(response.statusCode()),String.valueOf(response.getBody()) });
	}

//	private void when() {
//		// TODO Auto-generated method stub
//
//	}

	@Test
	public void POST() {
		// HashMap<String,Object> map= new HashMap<String,Object>();

		// System.out.print(map);
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		JSONObject request = new JSONObject();
		request.put("job", "name");
		request.put("teacher", "shyam");
		//result.add(new String[] { "POST", String.valueOf(response.getStatusCode()) });
		result.add(new String[] { "POST", String.valueOf(response.statusCode()),String.valueOf(response.getBody()) });
		// System.out.println(request);
		System.out.println(request.toJSONString());

		// RestAssured.when().post("https://reqres.in/api/users/2").then().statusCode(415).log().all();

	}

//	private ResponseOptions<Response> given1() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	private void when1() {
//		// TODO Auto-generated method stub
//	}

	@Test
	public void PATCH() {
		// HashMap<String,Object> map= new HashMap<String,Object>();

		// System.out.print(map);

		JSONObject request = new JSONObject();
		request.put("job", "name");
		request.put("teacher", "shyam");

		System.out.println(request);
		System.out.println(request.toJSONString());
//		when();
		Response response = RestAssured.patch("https://reqres.in/api/users/2").then().statusCode(200).log().all()
				.extract().response();
		//result.add(new String[] { "PATCH", String.valueOf(response.getStatusCode()) });
		result.add(new String[] { "PATCH", String.valueOf(response.statusCode()),String.valueOf(response.getBody()) });
	}

//	private void when11() {
//		// TODO Auto-generated method stub
//
//	}

	@AfterTest
	public void writeData() {
		for(String[] object : result) {
			for(String str: object) {
				System.out.print(str + "\t");
			}
		}
		
		writeToExcel writetoexcel = new writeToExcel(result);
	}
}

//class data {
//	public static void main(String args[]) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Plz type your request");
//		int request = sc.nextInt();
//		Rest ob = new Rest();
//
//		if (request == 1) {
//			System.out.println("GET REQUEST");
//			ob.GET();
//			ob.GET1();
//		} else if (request == 2) {
//			System.out.println("PUT REQUEST");
//			ob.PUT();
//
//		} else if (request == 3) {
//			System.out.println("DELETE REQUEST");
//			ob.DELETE();
//		} else if (request == 4) {
//			System.out.println("POST REQUEST");
//			ob.POST();
//		} else if (request == 4) {
//			System.out.println("PATCH REQUEST");
//			ob.PATCH();
//		} else {
//			System.out.println("INVALID REQUEST");
//		}
//	}

//}
