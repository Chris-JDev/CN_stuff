//PalindromeServer 
import java.io.*;
import java.net.*;

public class PalindromeServer {
    public static void main(String[] args) {
        int port = 9999;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Palindrome Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new Handler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Handler implements Runnable {
    private final Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true);
        ) {
            String input = in.readLine();
            if (input != null) {
                // normalize: remove non-letters/digits, lowercase
                String cleaned = input.replaceAll("\\W", "").toLowerCase();
                String reversed = new StringBuilder(cleaned).reverse().toString();
                if (cleaned.equals(reversed)) {
                    out.println("Yes, \"" + input + "\" is a palindrome.");
                } else {
                    out.println("No, \"" + input + "\" is not a palindrome.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}
