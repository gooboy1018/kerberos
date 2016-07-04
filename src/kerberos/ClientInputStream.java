package kerberos;
import java.net.*;
import java.io.*;
public class ClientInputStream implements Runnable {
	static String line;
    private Socket socket=null;
	public ClientInputStream(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while(true){
				try {
					line=br.readLine();
					System.out.println(line);
					
				} catch (SocketException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					break;
				}
			}
			//br.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getline(){
		return line;
	}
}
