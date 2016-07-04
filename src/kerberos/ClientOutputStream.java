package kerberos;
import java.net.*;
import java.io.*;
public class ClientOutputStream implements Runnable {
    private Socket socket=null;
   
	public ClientOutputStream(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {	
        	System.out.println("��������Ϣ��");
        	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream pw = new PrintStream(socket.getOutputStream());
			while(true){
			    
				String line = br.readLine();
				pw.println(line);
				if(line.equals("bye")){
					System.out.println("�Ѵӷ������Ͽ���");
					break;
				}
			}
			br.close();
			pw.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
