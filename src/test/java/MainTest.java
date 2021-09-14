import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private String URL = "http://localhost/";
    private String HELLO_WORLD = "Hello world";

    @Test
    public void testHelloWorldStatusCode() {
        given().
                when().
                get(URL).
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void testHelloWorldBody() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        assertEquals(response.getBody(), HELLO_WORLD);
    }
}
