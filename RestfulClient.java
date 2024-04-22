import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestfulClient {

    public static void main(String[] args) {
        try {
            // The URL of the RESTful service
            String urlString = "http://universities.hipolabs.com/search?name=bahce";

            // Create a URL object from the string representation
            URL url = new URL(urlString);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            connection.setRequestMethod("GET");

            // Set the request headers, if needed (e.g., content type, accept)
            connection.setRequestProperty("Accept", "application/json");

            // Check the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // If the response code is 200-OK, read the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response
                System.out.println(response.toString());
            } else {
                System.out.println("The request didn't work");
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" I think it's working");
    }
}
