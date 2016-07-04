package kerberos;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.IOException;

import java.net.DatagramPacket;

public class UDPclient {
	   public static void main(String[] args) throws IOException{
		   DatagramSocket socket=new DatagramSocket();
		   String str="I am client!";
		   //把数据进行封装，封装到数据报包中
		   DatagramPacket packet=new DatagramPacket(str.getBytes(),
				   str.length(),InetAddress.getByName("localhost"),8000);
		   socket.send(packet);
		
		   byte[] buff=new byte[100];
		   DatagramPacket packet2=new DatagramPacket(buff,100);
		   socket.receive(packet2);
		   System.out.print(new String(buff,0,packet2.getLength()));
		   socket.close();
		   
		   
	   }
	}