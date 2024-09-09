package SampleTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;

public class Api {

    @Test
    public void testGetPosts() {
        String apiEndpoint = "https://jsonplaceholder.typicode.com/posts";
        Response response = RestAssured.get(apiEndpoint);
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        ResponseBody responseBody = response.getBody();
        Map[] responseBodyList = responseBody.as(Map[].class);
        Assert.assertTrue(responseBodyList.length > 0, "Response should contain at least one post");
        Map<String, Object> firstPost = responseBodyList[0];
        Assert.assertTrue(firstPost.containsKey("userId"), "First post should contain 'userId'");
        Assert.assertTrue(firstPost.containsKey("id"), "First post should contain 'id'");
        Assert.assertTrue(firstPost.containsKey("title"), "First post should contain 'title'");
        Assert.assertTrue(firstPost.containsKey("body"), "First post should contain 'body'");
    }
}
