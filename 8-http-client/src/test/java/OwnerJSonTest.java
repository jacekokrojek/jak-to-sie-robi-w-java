import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OwnerJSonTest {

    static CloseableHttpClient client;

    @Before
    public void setUp(){
        client = HttpClients.createDefault();
    }

    @After
    public void TearDown()  {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
        owner.put("firstName", "Ben");
        owner.put("lastName", "Lewis");
        owner.put("address", "12 Long Island");
        owner.put("city", "New York");
        owner.put("telephone", "6085551023");
        owner.put("pet", new JSONArray());


        HttpPost httpPost = new HttpPost("http://localhost:9966/petclinic/api/owners");

        StringEntity entity = new StringEntity(owner.toString());
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);
        assertEquals(201, response.getStatusLine().getStatusCode());
        String bodyAsString = EntityUtils.toString(response.getEntity());
        JSONObject o = new JSONObject(bodyAsString);

        assertEquals(owner.get("firstName"), o.get("firstName"));
        assertTrue(o.getInt("id") > 0 );

        client.close();
    }

    @Test
    public void whenPutJsonUsingHttpClient_thenCorrect()
            throws ClientProtocolException, IOException {

        JSONObject owner = new JSONObject();
        owner.put("id", "5");
        owner.put("firstName", "Ben" + System.currentTimeMillis());
        owner.put("lastName", "Lewis");
        owner.put("address", "12 Long Island");
        owner.put("city", "New York");
        owner.put("telephone", "6085551023");

        //CloseableHttpClient client = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("http://localhost:9966/petclinic/api/owners/5");

        StringEntity entity = new StringEntity(owner.toString());
        httpPut.setEntity(entity);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPut);
        assertEquals(204, response.getStatusLine().getStatusCode());

        HttpGet httpGet = new HttpGet("http://localhost:9966/petclinic/api/owners/5");
        httpGet.setHeader("Accept", "application/json");

        CloseableHttpResponse getResponse = client.execute(httpGet);
        String bodyAsString = EntityUtils.toString(getResponse.getEntity());
        JSONObject o = new JSONObject(bodyAsString);
        assertEquals(owner.get("firstName"), o.get("firstName"));

        //client.close();
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
        System.out.println("bodyAsString = " + bodyAsString);
        JSONArray o = new JSONArray(bodyAsString);
        JSONObject owner = (JSONObject) o.get(0);
        assertEquals("George", owner.get("firstName"));
        assertEquals("Franklin", owner.get("lastName"));
        client.close();
    }


    @Test
    public void whenFileterForExistingOwner_thenGetOwenerDetails()
            throws ClientProtocolException, IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        String searchPhrase = "Dav";
        HttpGet httpGet = new HttpGet("http://localhost:9966/petclinic/api/owners/*/lastname/" + searchPhrase);
        httpGet.setHeader("Accept", "application/json");

        CloseableHttpResponse response = client.execute(httpGet);

        assertEquals(200, response.getStatusLine().getStatusCode());

        String bodyAsString = EntityUtils.toString(response.getEntity());

        JSONArray o = new JSONArray(bodyAsString);
        for (int i = 0; i < o.length(); i++) {
            JSONObject owner = (JSONObject) o.get(i);
            assertTrue(owner.get("lastName").toString().contains(searchPhrase));
        }
        client.close();
    }

}
