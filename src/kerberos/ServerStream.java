package kerberos;
import java.io.*;
import java.net.*;
// import java.util.*;
public class ServerStream implements Runnable {
    private Socket socket = null;
    private int number;
    
	public ServerStream(Socket socket, int number) {
		super();
		this.socket = socket;
		this.number = number;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintStream pw = new PrintStream(socket.getOutputStream(),true);
			while(true){
				String line = br.readLine();
				System.out.println("�ͻ���"+number+":"+line);
				pw.println(line.toUpperCase());
				if(line.equals("bye")){
					System.out.println("�ͻ��ˣ�"+number+"�Ѿ��Ͽ�");
					break;
				}
			}
			//br.close();
			pw.close();
		}
        
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
