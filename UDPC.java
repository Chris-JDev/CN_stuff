import java.io.IOException;
import java.net.*;

public class UDPC {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 7878;
        DatagramSocket s = new DatagramSocket();

        byte[] buf = "Ping".getBytes();
        InetAddress addr = InetAddress.getByName(host);
        DatagramPacket request = new DatagramPacket(buf, buf.length, addr, port);
        s.send(request);

        DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
        s.receive(response);
        System.out.println("reply: " 
            + new String(response.getData(), 0, response.getLength())
        );

        s.close();
    }
}
