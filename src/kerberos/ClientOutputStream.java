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
        	System.out.println("请输入信息：");
        	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream pw = new PrintStream(socket.getOutputStream());
			while(true){
			    
				String line = br.readLine();
				pw.println(line);
				if(line.equals("bye")){
					System.out.println("已从服务器断开！");
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
