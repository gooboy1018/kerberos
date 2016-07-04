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
    	   new MyFrame("认证系统");
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
	//初始化相关的组件
	private void init(){
		label1=new JLabel("帐号：");
		label2=new JLabel("输入密码：");
		label3=new JLabel("欢迎进入聊天室！");
		
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
	    capne.setBackground(null);//设置背景颜色
	   
	    // capne.add(ip);
		//capne.add(tv_area);		
	    this.setSize(600, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭时退出程序
		
		//定义工具包使居中
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth=screenSize.width;//获得屏幕的宽度
		int screenHeigh=screenSize.height;
		int windowWidth=this.getWidth();//获得当前窗体的宽度
		int windowHeigh=this.getHeight();
		this.setLocation((screenWidth-windowWidth)/2, (screenHeigh-windowHeigh)/2);
	}
	//给相关组件（控件）设置事件监听器
	private void registerListener(){
		//text1.addActionListener(MyFrame);
	}
	public void actionPerformed(ActionEvent e){  //事件发生时的处理操作
		
		
		//text1.setText(line1);
		
	}
	
	
}
/*class ImageJPanel extends JPanel
{
private ImageIcon ii;
public ImageJPanel()
{
//指定背景图片的名称
	ii=new ImageIcon("E:/workspace/Client/bin/test/keshe.jpg");
} 

//绘制背景图片
public void paintComponent(Graphics g)
{
super.paintComponent(g);
g.drawImage(ii.getImage(),0,0,this);
}
}*/