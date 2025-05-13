//TCPS.java SERVER
import java.io.*;
import java.net.*;
public class TCPS
{
public static void main(String args[])
{
int port =9999;
try(ServerSocket ss= new ServerSocket(port)){
System.out.println ("Server LISTENING on port : "+port);
Socket clientSocket =ss.accept();
System.out.println("Clinet Connected :"+clientSocket.getInetAddress());

PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
out.println("Hello from java");

clientSocket.close();
}
catch(IOException e){
e.printStackTrace();
}
}
}
