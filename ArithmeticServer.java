//ArithmeticServer
import java.io.*;
import java.net.*;
import java.util.regex.*;

public class ArithmeticServer {
    public static void main(String[] args) {
        int port = 9999;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Arithmetic Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket socket;
    // matches "number operator number", operators: +, -, *, /
    private static final Pattern EXPR =
        Pattern.compile("\\s*(\\d+)\\s*([+\\-*/])\\s*(\\d+)\\s*");

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                socket.getOutputStream(), true)
        ) {
            String line = in.readLine();
            if (line != null) {
                Matcher m = EXPR.matcher(line);
                if (m.matches()) {
                    long a = Long.parseLong(m.group(1));
                    String op = m.group(2);
                    long b = Long.parseLong(m.group(3));
                    String result;
                    switch (op) {
                        case "+":
                            result = String.valueOf(a + b);
                            break;
                        case "-":
                            result = String.valueOf(a - b);
                            break;
                        case "*":
                            result = String.valueOf(a * b);
                            break;
                        case "/":
                            result = (b == 0)
                                ? "Error: division by zero"
                                : String.valueOf(a / b);
                            break;
                        default:
                            result = "Error: unknown operator";
                    }
                    out.println(result);
                } else {
                    out.println("Error: invalid expression");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}
