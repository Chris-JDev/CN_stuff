//PalindromeClient
import java.io.*;
import java.net.*;

public class PalindromeClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;

        try (
            Socket socket = new Socket(host, port);
            BufferedReader console = new BufferedReader(
                new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.print("Enter a string: ");
            String userInput = console.readLine();
            out.println(userInput);

            String response = in.readLine();
            System.out.println("Server response: " + response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
