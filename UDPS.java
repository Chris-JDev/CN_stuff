import java.io.IOException;
import java.net.*;

public class UDPS {
    public static void main(String[] args) throws IOException {
        int port = 7878;
        DatagramSocket s = new DatagramSocket(port);
        System.out.println("UDP server on port " + port);
        byte[] buf = new byte[1024];

        while (true) {
            // use 'packet' to match the receive call
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            s.receive(packet);

            String msg = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Got: " + msg);

            DatagramPacket resp = new DatagramPacket(
                packet.getData(), packet.getLength(),
                packet.getAddress(), packet.getPort()
            );
            s.send(resp);
        }
    }
}
