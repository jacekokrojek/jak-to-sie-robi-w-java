import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OwnerTest {

    @Test
    public void shouldReturnAllOwners() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            CloseableHttpResponse response = client.execute(new HttpGet("http://localhost:8080/owners?lastName="));
            assertEquals(response.getStatusLine().getStatusCode(), 200);

            String contentMimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
            assertEquals(contentMimeType, ContentType.TEXT_HTML.getMimeType());

            String bodyAsString = EntityUtils.toString(response.getEntity());
            assertTrue(bodyAsString.contains("<a href=\"/owners/1\">George Franklin</a></a>"));
            assertTrue(bodyAsString.contains("<a href=\"/owners/2\">Betty Davis</a></a>"));
            assertTrue(bodyAsString.contains("<a href=\"/owners/3\">Eduardo Rodriquez</a></a>"));
            // ... additional assertions

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Todo
    public void shouldReturnMatchingOwnersIfMoreThenOne() {

    }

    //Todo
    public void shouldReturnMatchingOwnerDetails() {
    }

    @Test
    public void shouldAddOwner() {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost("http://localhost:8080/owners/new");

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            
            params.add(new BasicNameValuePair("firstName", "John"));
            params.add(new BasicNameValuePair("lastName", "Smith"));
            params.add(new BasicNameValuePair("address", "15 New Port"));
            params.add(new BasicNameValuePair("city", "London"));
            params.add(new BasicNameValuePair("telephone", "2134576352"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);
            assertEquals(response.getStatusLine().getStatusCode(), 302);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldAddOwnerDetails() {
        try {
            CloseableHttpClient client = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
            HttpPost httpPost = new HttpPost("http://localhost:8080/owners/new");

            List<NameValuePair> params = new ArrayList<NameValuePair>();

            params.add(new BasicNameValuePair("firstName", "John"));
            params.add(new BasicNameValuePair("lastName", "Smith"));
            params.add(new BasicNameValuePair("address", "15 New Port"));
            params.add(new BasicNameValuePair("city", "London"));
            params.add(new BasicNameValuePair("telephone", "2134576352"));
            httpPost.setEntity(new UrlEncodedFormEntity(params));

            CloseableHttpResponse response = client.execute(httpPost);
            String bodyAsString = EntityUtils.toString(response.getEntity());
            assertTrue(bodyAsString.contains("<td><b>John Smith</b></td>"));
            assertTrue(bodyAsString.contains("<td>15 New Port</td>"));

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
