package kerberos;
import java.io.*;
import java.net.*;
//import java.util.*;

public class ChatServer {
       public static void main(String[] args) throws IOException{
    	   ServerSocket serverSocket = new ServerSocket(8888);
    	   int number = 1;
    	   while(true){
    	   Socket socket = serverSocket.accept();
    	   System.out.println("客户端"+number+"连接成功！");
    	   //鏈嶅姟绔紑鍚竴涓嫭绔嬬殑绾跨▼鏉ュ瀹㈡埛绔繘琛岃鍐欐搷浣�
    	   new Thread(new ServerStream(socket,number)).start();
    	   number++;
    	   }
       }
}
