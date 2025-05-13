//TCPC.java CLIENT

import java.io.*;
import java.net.*;

public class TCPC
{
public static void main(String args[])
{
String host ="localhost";
int port =9999;
try(Socket s=new Socket(host,port);
BufferedReader in= new BufferedReader(new InputStreamReader(s.getInputStream()))){
String msgFromClient = in.readLine();
System.out.println("Client sent: " + msgFromClient);
}
catch (IOException e)
{
e.printStackTrace();
}
}
}
