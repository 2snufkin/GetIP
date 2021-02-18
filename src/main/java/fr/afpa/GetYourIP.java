package fr.afpa;

import java.io.FileWriter;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;


class GetYourIP {
    public static final String endpoint  = "http://ip-api.com/json";

    public static void main(String[] args )  {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(endpoint);
        String ip = "not found";
        String path = "C:/Users/Home/ip.txt";



        try {
            FileWriter fileWriter = new FileWriter(path);

            HttpResponse response = client.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            fileWriter.write("Response as String : " + jsonResponse + "\n");
            JSONObject responseObj = new JSONObject( jsonResponse);
            ip  = responseObj.getString("query");
            fileWriter.write("ip: " +  ip );
            fileWriter.close();
        }
        catch (IOException e ) {
            e.printStackTrace();
        }
    }
}