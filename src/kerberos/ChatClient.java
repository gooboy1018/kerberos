package kerberos;
import java.net.*;
import java.io.*;
import java.awt.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
public class ChatClient {
       public static void main(String[] args) throws IOException{
    	  
    	   Socket socket=new Socket("192.168.0.112",8888);
    	   //Socket socket1=new Socket("192.168.0.107",9000);
    	   new MyFrame("��֤ϵͳ");
    	   new Thread(new ClientInputStream(socket)).start();
    	   new Thread(new ClientOutputStream(socket)).start();
    	   
    	   //new Thread(new ClientInputStream(socket1)).start();
    	  // new Thread(new ClientOutputStream(socket1)).start();
    	   
       }
}

class MyFrame extends JFrame{
	
	//private ImageJPanel ip;
	private JTextArea tv_area=null;
	static JLabel label1,label2,label3,label4;
	static JTextField text1,text2;
	public MyFrame(String title){
		super(title);
		init();
		registerListener();
	}
	//��ʼ����ص����
	private void init(){
		label1=new JLabel("�ʺţ�");
		label2=new JLabel("�������룺");
		label3=new JLabel("��ӭ���������ң�");
		
		text1=new JTextField(15);
		text2=new JTextField(15);
		JTextArea tv_area=new JTextArea(20,48);
		//ip=new ImageJPanel();
		
		
		Container capne=this.getContentPane();
		capne.setLayout(new FlowLayout());
		
		//ip.setBounds(0,0,this.getWidth(),this.getHeight());
		
		
		capne.add(label1);
	    capne.add(text1);
	    capne.add(label2);
	    capne.add(text2);
	    capne.add(label3,BorderLayout.CENTER);
	    capne.add(tv_area,BorderLayout.CENTER);
	    capne.setBackground(null);//���ñ�����ɫ
	   
	    // capne.add(ip);
		//capne.add(tv_area);		
	    this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�ر�ʱ�˳�����
		
		//���幤�߰�ʹ����
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth=screenSize.width;//�����Ļ�Ŀ��
		int screenHeigh=screenSize.height;
		int windowWidth=this.getWidth();//��õ�ǰ����Ŀ��
		int windowHeigh=this.getHeight();
		this.setLocation((screenWidth-windowWidth)/2, (screenHeigh-windowHeigh)/2);
	}
	//�����������ؼ��������¼�������
	private void registerListener(){
		//text1.addActionListener(MyFrame);
	}
	public void actionPerformed(ActionEvent e){  //�¼�����ʱ�Ĵ������
		
		
		//text1.setText(line1);
		
	}
	
	
}
/*class ImageJPanel extends JPanel
{
private ImageIcon ii;
public ImageJPanel()
{
//ָ������ͼƬ������
	ii=new ImageIcon("E:/workspace/Client/bin/test/keshe.jpg");
} 

//���Ʊ���ͼƬ
public void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawImage(ii.getImage(),0,0,this);
}
}*/