//multithread.java
import java.io.*;
import java.net.*;

public class multithread
{
public static void main(String args[])
{
int port =9999;

try (ServerSocket s= new ServerSocket(port)){
System.out.println("Server Listening on port :"+ port);
while (true)
{
Socket client = s.accept();
new Thread(new ClientHandler(client)).start();
}
}
catch (IOException e){
e.printStackTrace();
}
}
}

class ClientHandler implements Runnable {
private Socket s;
public ClientHandler(Socket s){this.s=s;};
@Override

public void run(){
try{
String add=s.getInetAddress().toString();
System.out.println("Connected :"+add);
PrintWriter p=new PrintWriter(s.getOutputStream(),true);
p.println("hello from"+Thread.currentThread().getId());
p.flush();
s.close();
}

catch (IOException e){
e.printStackTrace();
}

}
}
