import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OwnerJSonTest {

    @Test
    public void whenPostJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {

        //        String json = "{\n" +
        //                "    \"id\": 0,\n" +
        //                "    \"firstName\": \"George3\",\n" +
        //                "    \"lastName\": \"Franklin\",\n" +
        //                "    \"address\": \"110 W. Liberty St.\",\n" +
        //                "    \"city\": \"Madison\",\n" +
        //                "    \"telephone\": \"6085551023\",\n" +
        //                "    \"pets\": []\n" +
        //                "}";

        JSONObject owner = new JSONObject();
        owner.put("id", "0");
        owner.put("firstName", "George");
        owner.put("lastName", "Franklin");
        owner.put("address", "12 Long Island");
        owner.put("city", "New York");
        owner.put("telephone", "6085551023");
        owner.put("pet", new JSONArray());

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:9966/petclinic/api/owners");

        StringEntity entity = new StringEntity(owner.toString());
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        assertEquals(201, response.getStatusLine().getStatusCode());
        String bodyAsString = EntityUtils.toString(response.getEntity());
        JSONObject o = new JSONObject(bodyAsString);

        assertEquals( owner.get("firstName"), o.get("firstName"));

        client.close();
    }

    @Test
    public void whenGetJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:9966/petclinic/api/owners");
        httpGet.setHeader("Accept", "application/json");

        CloseableHttpResponse response = client.execute(httpGet);

        assertEquals(200, response.getStatusLine().getStatusCode());

        String bodyAsString = EntityUtils.toString(response.getEntity());
        JSONArray o = new JSONArray(bodyAsString);
        JSONObject owner = (JSONObject)o.get(0);
        assertEquals( "George", owner.get("firstName"));

        client.close();
    }

    
}
