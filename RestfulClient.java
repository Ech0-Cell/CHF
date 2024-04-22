import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestfulClient {

    public static void main(String[] args) {
        try {
            // the URL of the service
            String urlString = "http://universities.hipolabs.com/search?name=bahce";

            // create a URL object
            URL url = new URL(urlString);

            // open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // set the request method to GET
            connection.setRequestMethod("GET");

            // set the request headers
            connection.setRequestProperty("Accept", "application/json");

            // check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // if the response code is 200-OK, read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }// end of while
                in.close();

                // print the response
                System.out.println(response);
            }// end of if
            else {
                System.out.println("The request didn't work");
            }


            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }//end of catch


    }// end of main
}// end of the class
