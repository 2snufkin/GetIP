package fr.afpa;

import java.io.IOException;


class GetYourIP {
    public static final String endpoint  = "http://ip-api.com/json";

    public static void main(String[] args )  {

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(endpoint);
        String ip = "not found";

        try {
            HttpResponse response = client.execute(request);
            String jsonResponse = EntityUtils.toString(response.getEntity());
            System.out.println("Response as String : " + jsonResponse );
            JSONObject responseObj = new JSONObject( jsonResponse);
            ip  = responseObj.getString("query");
            System.out.println("ip: " +  ip );
        }
        catch (IOException e ) {
            e.printStackTrace();
        }
    }
}