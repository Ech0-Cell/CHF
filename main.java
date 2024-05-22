import java.io.*;

public class main {
    public static void main(String[] args) {
        runScript("incrementII.js");
        runScript("kafkaMSG.js");
        runScript("Balance.js");
    }

    public static void runScript(String fileName) {
        String command = "node " + fileName;

        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
