package ���ݿ����ҵText;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import javax.swing.table.DefaultTableModel;

public class ZhangDemo extends JFrame implements ActionListener {
	static ZhangDemo mainJFrame = new ZhangDemo();  //�½�����
	//��½����,���õ����ݿ�Ϊzhanghongrui
	static JLabel user = new JLabel("��ݣ�");
	static String data[]={"��ѡ��","�������Ա","ѧ��"};
	static JComboBox cbx=new JComboBox(data);		//�����б��
	static JLabel name=new JLabel("��ӭ��½����ѧ���������ϵͳ");
	static JLabel lbl2 = new JLabel("�˺ţ�");
	static JLabel lbl3 = new JLabel("���룺");
	static JTextField jTextField=new JTextField(10);
	static JPasswordField jPasswordField=new JPasswordField(10);
	static JPanel jPanel=new JPanel();
	static JDialog diag = new JDialog(mainJFrame); // ����������mainJFrame�ĶԻ���
	static JButton bt_login = new JButton("��¼");
	static JButton bt_cancel = new JButton("���");
	//��ѯѧ����Ϣ������
	static JLabel stu=new JLabel("��ӭ��ѯѧ����Ϣ");	
	static JLabel stu1 = new JLabel("ѧ�ţ�");
	static JLabel stu2 = new JLabel("������");
	static JTextField stu3=new JTextField(10);
	static JTextField stu4=new JTextField(10);
	static JButton stu5 = new JButton("��ѯ");
	static JButton stu6 = new JButton("���");
	//�޸ĵ�½����������,����stu_stu6��հ�ť
	static JLabel stu_stu=new JLabel("�������޸ĵ�½����");
	static JLabel stu_stu1 = new JLabel("ԭ���룺");
	static JLabel stu_stu2 = new JLabel("�����룺");
	static JTextField stu_stu3=new JTextField(10);
	static JTextField stu_stu4=new JTextField(10);
	static JButton stu_stu5 = new JButton("�޸�");	
	//��ѯѧ����Ϣ������,����stu1,stu2,stu3,stu4��ť
	static JLabel stu7 = new JLabel("�༶��");
	static JTextField stu8=new JTextField(10);
	static JButton insert = new JButton("����");
	static JButton del = new JButton("ɾ��");
	static JButton mod = new JButton("�޸�");
	static JButton inquire = new JButton("��ѯ");
	static JButton stu_stu6 = new JButton("���");
	//��ѯ������Ϣ������
	static JLabel zhr1 = new JLabel("����ţ�");
	static JLabel zhr2 = new JLabel("����绰��");
	static JLabel zhr3= new JLabel("����¥�㣺");
	static JTextField zhr4=new JTextField(10);
	static JTextField zhr5=new JTextField(10);
	static JTextField zhr6=new JTextField(10);
	static JButton zhr7 = new JButton("����");
	static JButton zhr8= new JButton("�޸�");
	static JButton zhr9 = new JButton("ɾ��");
	static JButton zhr10= new JButton("���");
	static JButton zhr11 = new JButton("��ѯ");
	//��ѯ����Ʋ�������
	static JLabel hong1 = new JLabel("��Ʒ��ţ�");
	static JLabel hong2 = new JLabel("��Ʒ����");
	static JLabel hong3= new JLabel("��Ʒ�۸�");
	static JTextField hong4=new JTextField(10);
	static JTextField hong5=new JTextField(10);
	static JTextField hong6=new JTextField(10);
	static JButton hong7 = new JButton("����");
	static JButton hong8 = new JButton("�޸�");
	static JButton hong9 = new JButton("ɾ��");
	static JButton hong10= new JButton("���");
	static JButton hong11 = new JButton("��ѯ");
	//��ѯ���ᱨ����Ϣ������
	static JLabel rui1 = new JLabel("����ţ�");
	static JLabel rui2 = new JLabel("������������");
	static JLabel rui3= new JLabel("������Ʒ����");
	static JTextField rui4=new JTextField(10);
	static JTextField rui5=new JTextField(10);
	static JTextField rui6=new JTextField(10);
	static JButton rui7 = new JButton("����");
	static JButton rui8 = new JButton("�޸�");
	static JButton rui9 = new JButton("ɾ��");
	static JButton rui10= new JButton("���");
	static JButton rui11 = new JButton("��ѯ");
	//��ѯѧ�������Ϣ������
	static JLabel wang1 = new JLabel("����ţ�");
	static JLabel wang2 = new JLabel("������");
	static JLabel wang3= new JLabel("���ʱ�䣺");
	static JTextField wang4=new JTextField(10);
	static JTextField wang5=new JTextField(10);
	static JTextField wang6=new JTextField(10);
	static JButton wang7 = new JButton("����");
	static JButton wang8 = new JButton("�޸�");
	static JButton wang9 = new JButton("ɾ��");
	static JButton wang10= new JButton("���");
	static JButton wang11 = new JButton("��ѯ");
	//��ѯѧ����У��Ϣ������
	static JLabel mei1 = new JLabel("����ţ�");
	static JLabel mei2 = new JLabel("������");
	static JLabel mei3= new JLabel("��Уʱ�䣺");
	static JTextField mei4=new JTextField(10);
	static JTextField mei5=new JTextField(10);
	static JTextField mei6=new JTextField(10);
	static JButton mei7 = new JButton("����");
	static JButton mei8 = new JButton("�޸�");
	static JButton mei9 = new JButton("ɾ��");
	static JButton mei10= new JButton("���");
	static JButton mei11 = new JButton("��ѯ");
	//��ѯѧ�������Ϣ������
	static JLabel ting1 = new JLabel("ѧ�ţ�");
	static JLabel ting2 = new JLabel("������");
	static JLabel ting3= new JLabel("����ţ�");
	static JTextField ting4=new JTextField(10);
	static JTextField ting5=new JTextField(10);
	static JTextField ting6=new JTextField(10);
	static JButton ting7 = new JButton("����");
	static JButton ting8 = new JButton("�޸�");
	static JButton ting9 = new JButton("ɾ��");
	static JButton ting10= new JButton("���");
	static JButton ting11 = new JButton("��ѯ");
	
	static String Sno ;                        //ѧ��
	static String stu_name;		        //ѧ������
	static String course;                   //�༶
	static String dormnum;            //�����
	static String begnum;               //����
	static String stu_username;    //ѧ���û���
	static String man_username;  //����Ա�û���
	static JPanel p=new JPanel();
	static JPanel panelA=new JPanel(false);   //ѧ����Ϣ��ѯ���,��ʹ��˫����,�ڴ�ռ����һ��
	static JPanel panelB=new JPanel(false);	//ѧ�������޸����
	static JPanel panel1=new JPanel(false);   //����7�����ѯ���,û�������ض��Ļ������
	static JPanel panel2=new JPanel(false);
	static JPanel panel3=new JPanel(false);
	static JPanel panel4=new JPanel(false);
	static JPanel panel5=new JPanel(false);
	static JPanel panel6=new JPanel(false);
	static JPanel panel7=new JPanel(false);
	static JTabbedPane tabbedPane1=new JTabbedPane();  //��ఴť�������
	static JTabbedPane Pane=new JTabbedPane();  //����Ϣչʾ�ֲ����

	public static void main(String args[]) {
		mainJFrame.setTitle("��ӭ��½!");                 //���ö�������������
		mainJFrame.setSize(590, 500);
		mainJFrame.setLocationRelativeTo(null);  //���ֵ�λ��Ϊ��Ļ����
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // ���ùرն���Ϊ�˳�����
		Container container = mainJFrame.getContentPane();                         //��ȡ�������
		container.setLayout(null);    //����Ϊ���Բ��ַ�ʽ,������ֵȷ��λ��
		
		//Ϊ�������������
		name.setFont(new Font("����", Font.BOLD, 35));		//��Ӵ��ڱ���
		name.setForeground(Color.blue);
		name.setBounds(30, 30, 600, 80);
		container.add(name);
		
		user.setBounds(150, 200, 50, 50);		//��ݱ�ǩ
		user.setForeground(Color.CYAN);
		container.add(user);
		cbx.setBounds(200, 210, 100, 30);		//�����б��
		container.add(cbx);
		
		lbl2.setBounds(150, 250, 50, 50);		//�û�����ǩ
		lbl2.setForeground(Color.CYAN);
		container.add(lbl2);
		jTextField.setBounds(200,260,200,30);
		container.add(jTextField);
		
		lbl3.setBounds(150,300,50,50);//�����ǩ
		lbl3.setForeground(Color.CYAN);
		container.add(lbl3);
		jPasswordField.setBounds(200,310,200,30);
		container.add(jPasswordField);
		
		bt_cancel.setBounds(200, 400, 60, 30);  //ȡ����ť
		container.add(bt_cancel);
		bt_login.setBounds(300, 400, 60, 30);  //��½��ť
		container.add(bt_login);
				
		ImageIcon image = new ImageIcon("image/666.jpg");  		//��ӱ���ͼƬ
		JLabel lb_image = new JLabel(image);  		
		lb_image.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		container.add(lb_image);
		
		//Ϊ��ť�ʹ�������¼�������
		bt_login.addActionListener(mainJFrame);
		bt_cancel.addActionListener(mainJFrame);
		mainJFrame.setVisible(true);
	}  //main����������
	
	public void actionPerformed(ActionEvent e) { // ������½����ĵ�½��ť�Ĵ����¼�
		JButton bt = (JButton) e.getSource();              // ��ȡ�������İ�ť
		if (bt ==bt_cancel) {                                             // ������������հ�ť
			jTextField.setText("");
			jPasswordField.setText("");
		}
		if (bt==bt_login) {													// ��������½��ťִ��
			String username=jTextField.getText().trim();     //��ȡ�����ı��������
			String pwd=new String(jPasswordField.getPassword()).trim();
			String s= (String) cbx.getSelectedItem();			//��ȡ�����б��ѡ�е�ֵ
			if(s.equals("ѧ��")) {                                               //ѧ����½����
				if(username.equals("") || pwd.equals("")) { //���ı�����һ��Ϊ���򵯳��Ի�����ʾ
					createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60); //��ʾΪ�յ���Ϣ
				}
				else {      //�ı��򶼲�Ϊ��ִ��try-catch���
					try {				
						boolean flag=true;  //��flag�ж��Ƿ��½�ɹ�
						stu_username = null;  //�����ݿ��в�ѯ�������˺�
						String stu_pwd = null;  //�����ݿ��в�ѯ����������
						Class.forName("com.mysql.cj.jdbc.Driver");  //����MySQL����
						//���������ݿ������
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();  //����Statement������SQL statements�����ݿ�
						//����SQL���
						String sql = "SELECT username,password FROM zhanghongrui.user where username='"+username+"' and password='"+pwd+"'";
						ResultSet rs = stmt.executeQuery(sql);  //ִ��SQL���
						
							while(rs.next()) {						//��ѯ�Ƿ����˺ź�����,��flagΪfalse
								stu_username = rs.getString("username");  
								stu_pwd = rs.getString("password");
								flag=false;
							}	
							if(!flag) {      //ѧ���˺ź����붼��ȷʱ�����½��������
								if(stu_username.equals(username) && stu_pwd.equals(pwd)) {
									Stu_Excute();  //ѧ����½�ɹ�ִ�к���
								}  
							}
							if(flag) {            //�˺Ż����벻��ȷ�򵯳��Ի�����ʾ
								createDialog("�˺Ż����벻��ȷ","��������˺Ż����벻��ȷ",20,10, 20, 280, 80); 
							}																
							rs.close();	//�ر��������
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}	
			}
			else if(s.equals("�������Ա")) {      //�������Ա��½����
				if(username.equals("") || pwd.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
				}
				else {      //�ı��򶼲�Ϊ��ִ��try-catch���
					try {				
						boolean flag=true;
						man_username = null;
						String man_pwd = null;
						Class.forName("com.mysql.cj.jdbc.Driver"); 
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String sql = "SELECT username,password FROM zhanghongrui.manager where username='"+username+"' and password='"+pwd+"'";
						ResultSet rs = stmt.executeQuery(sql);
						
							while(rs.next()) {                                            //��ѯ�Ƿ���ƥ����˺ź�����
								man_username = rs.getString("username"); 
								man_pwd = rs.getString("password");
								flag=false;
							}	
							if(!flag) {         //����Ա�˺Ż�������ȷʱ�����½��������
								if(man_username.equals(username)&& man_pwd.equals(pwd)) {
									Man_Excute();      //����Ա��½�ɹ���ִ�к���
								}  //�ж��˺Ż������Ƿ�������ȷ��if��������
							}
							if(flag) {            //�˺Ż����벻��ȷ
								createDialog("�˺Ż����벻��ȷ","��������˺Ż����벻��ȷ",20,10, 20, 280, 80); 
							}																
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}	
			}
			else {
				createDialog("��ѡ�����","��ѡ�����",30,60, 30, 280, 60); 
			}
		}	
	}
	protected static void Stu_Excute(){      //ѧ����½�ɹ�ִ�к���
				jTextField.setText("");
				jPasswordField.setText("");
				JDialog dialog=new JDialog(mainJFrame,"��¼�ɹ�",true);		//�����Ի���,�Ի�����ģʽ
				dialog.setSize(400,300);								//���öԻ���Ĵ�С
				dialog.setLocationRelativeTo(null);			//���öԻ�����ʾ����Ļ����
				dialog.setResizable(true);								//���öԻ���ɸı��С
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//���ùرն���
				Container container=dialog.getContentPane();
				tabbedPane1.setPreferredSize(new Dimension(400,300));		//���÷ֲ�������ѡ��С
				
				panelA.setSize(400,300);        //ѧ����Ϣ��ѯ���
				panelA.setLayout(null);          //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
				
				stu.setFont(new Font("����", Font.BOLD, 30));    //ҳ���ǩ
				stu.setBounds(55, 20, 380, 60);
				panelA.add(stu);
				
				stu1.setBounds(70, 80, 50, 50);                                //ѧ�ű�ǩ
				panelA.add(stu1);
				stu3.setBounds(110,90,200,30);		
				panelA.add(stu3);
				stu3.setText("");
				
				stu2.setBounds(70,120,50,50);                                 //������ǩ
				panelA.add(stu2);
				stu4.setBounds(110,130,200,30);			
				panelA.add(stu4);
				stu4.setText("");
				
				stu5.setBounds(140, 180, 60, 30);                            //��ѯ��ť
				panelA.add(stu5);
				stu6.setBounds(210, 180, 60, 30);                            //��հ�ť
				panelA.add(stu6);
				tabbedPane1.addTab("ѧ����Ϣ��ѯ", panelA);    //��ѧ����Ϣ��ѯ������ֲ����
				
				panelB.setSize(400,300);                   //ѧ����½�����޸����
				panelB.setLayout(null);                     //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
				
				stu_stu.setFont(new Font("����", Font.BOLD, 30));  //��ǩ
				stu_stu.setBounds(50, 20, 380, 60);
				panelB.add(stu_stu);
				
				stu_stu1.setBounds(60, 80, 60, 50);        //ԭ�����ǩ
				panelB.add(stu_stu1);
				stu_stu3.setBounds(120,90,200,30);
				panelB.add(stu_stu3);
				stu_stu3.setText("");
				
				stu_stu2.setBounds(60,120,60,50);       //�������ǩ
				panelB.add(stu_stu2);
				stu_stu4.setBounds(120,130,200,30);
				panelB.add(stu_stu4);
				stu_stu4.setText("");
				
				stu_stu5.setBounds(140, 180, 60, 30);    //�޸İ�ť
				panelB.add(stu_stu5);
				stu_stu6.setBounds(210, 180, 60, 30);    //��հ�ť
				panelB.add(stu_stu6);
				
				tabbedPane1.addTab("ѧ����½�����޸�", panelB);       //���޸ĵ�½����������ֲ����
				container.add(tabbedPane1);
				
				stu5.addActionListener(new ActionListener() {    //ѧ����Ϣ��ѯ��ť����Ӧ����
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	message_inquire(stu3,stu4);      //��ѯ����
		            }});
				stu6.addActionListener(new ActionListener() {		//��հ�ť��Ӧ����
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	stu3.setText("");
						stu4.setText("");
		            }});
				
				stu_stu5.addActionListener(new ActionListener() {  //ѧ�������޸İ�ť
		            @Override
		            public void actionPerformed(ActionEvent e) {						
						//��ȡ�����ı��������
						String pwd=stu_stu3.getText().trim();                  //��ȡԭ����
						String new_pwd=stu_stu4.getText().trim();        //��ȡ������
						
						if(pwd.equals("") || new_pwd.equals("")) {
							createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   //��ʾΪ�յ���Ϣ
						}
						else {      //�ı��򶼲�Ϊ��ִ��try-catch���
							try {				
								String stu_pwd=null;
								boolean flag=true;
								Class.forName("com.mysql.cj.jdbc.Driver");      //������ԭ����
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
								Statement stmt = conn.createStatement();
								String sql = "select password from zhanghongrui.user where username= '"+stu_username+"' and password='"+pwd+"'";
								ResultSet rs = stmt.executeQuery(sql);
									
								while(rs.next()) {      //���ҵõ�ԭ����
										stu_pwd = rs.getString("password");
										flag=false;
									}	
								
									if(!flag) {      //���ҵ���ԭ�����޸�Ϊ������
										Class.forName("com.mysql.cj.jdbc.Driver");
										conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
										stmt = conn.createStatement();
										String sql1="update zhanghongrui.user set password='"+new_pwd+"' where username= '"+stu_username+"' and password='"+stu_pwd+"'";
										stmt.executeUpdate(sql1);
										createDialog("�����޸ĳɹ�","�����޸ĳɹ�",30,35, 20, 280, 80);
									}
									if(flag) {      //�����ԭ�����Ҳ��������
										createDialog("ԭ������������","ԭ������������",30,25, 20, 280, 80);
									}																
									rs.close();	
									stmt.close();
									conn.close();					
							}catch(Exception ee) {
								System.err.println(ee.getMessage());
							}	
						}	
		            }});
				stu_stu6.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	stu_stu3.setText("");
		            	stu_stu4.setText("");
		            }});
				dialog.setVisible(true); // ��ʾ�Ի���
	}
	
	public static void Man_Excute() {       //����Ա��½�ɹ�ִ�к���
		JDialog dialog=new JDialog(mainJFrame,"��¼�ɹ�",true);  //��������Ա��������
		dialog.setSize(700,600);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container=dialog.getContentPane();
		container.setLayout(new BorderLayout());      //����������Ϊ�߽粼��
		
		p.setSize(700,300);
		p.setBackground(Color.PINK);      //���÷��ñ�ǩ�����ı���ɫ
		JLabel name=new JLabel("��ӭ��½����ѧ���������ϵͳ");
		name.setFont(new Font("����", Font.BOLD, 35));
		name.setSize(400,150);
		name.setForeground(Color.BLUE);                //���ñ�ǩ��������ɫ
		p.add(name);
		container.add(p,BorderLayout.NORTH);
		
		JTabbedPane tabbedPane=new JTabbedPane();
		Component panel=makeMenuPanel();        //���ɾ��в�����ť����庯��
		tabbedPane.addTab("��������", panel);
		tabbedPane.setPreferredSize(new Dimension(150,400));  //����tabbedPane��С
		container.add(tabbedPane,BorderLayout.WEST);
		
		Pane.setPreferredSize(new Dimension(400,300));	//չʾ���������Ϣ�ķֲ����
		
		Component panel1 = createPanel1();      //�ֱ���÷�����������Ա����ҳ��,һ��7��ҳ��,��Ӧ7�����ݱ�
		Component panel2 = createPanel2();
		Component panel3 = createPanel3();
		Component panel4 = createPanel4();
		Component panel5 = createPanel5();
		Component panel6 = createPanel6();
		Component panel7 = createPanel7();
		
		Pane.addTab("ѧ����Ϣ", panel1);               //��ÿ��ҳ�����ֲ����
		Pane.addTab("������Ϣ", panel2);
		Pane.addTab("����Ʋ�", panel3);
		Pane.addTab("�������", panel4);
		Pane.addTab("������", panel5);
		Pane.addTab("��У���", panel6);
		Pane.addTab("������", panel7);
		
		container.add(Pane,BorderLayout.CENTER);
		dialog.setVisible(true);
	}
	
	protected static  Component makeMenuPanel() {      //���ɲ�����ť���ķ���
		JPanel panel=new JPanel(false);
		panel.setLayout(new FlowLayout());
		JLabel lb1 =new JLabel("ѧ����Ϣ");
		lb1.setFont(new Font("����", Font.BOLD, 10));
		JButton[] menu=new JButton[7];
		for(int i=0;i<menu.length;i++) {
			menu[i]=new JButton();                                        //����7����ť
			menu[i].setMargin(new Insets(10,20,10,20));  //Ϊÿ����ť���ô�С
		}	
		menu[0].setText("��ѯѧ����Ϣ");	                         //Ϊ��һ����ť�����ı���Ϣ
		menu[0].addActionListener(new ActionListener() {    //Ϊ��һ����ť����¼�����
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {        //��ÿ��������Ϣ��ʾ����,����6����ť��������
				Pane.removeAll();
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("�������", panel4);
				Pane.addTab("������", panel5);
				Pane.addTab("��У���", panel6);
				Pane.addTab("������", panel7);
			}
		});
		menu[1].setText("��ѯ������Ϣ");
		menu[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodB();
			}
			private void methodB() {
				Pane.removeAll();
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("ѧ����Ϣ", panel1);			
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("�������", panel4);
				Pane.addTab("������", panel5);
				Pane.addTab("��У���", panel6);
				Pane.addTab("������", panel7);
			}
		});
		menu[2].setText("��ѯ����Ʋ�");
		menu[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodC();
			}
			private void methodC() {
				Pane.removeAll();
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("�������", panel4);
				Pane.addTab("������", panel5);
				Pane.addTab("��У���", panel6);
				Pane.addTab("������", panel7);
			}
		});
		menu[3].setText("��ѯ�������");
		menu[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodD();
			}
			private void methodD() {
				Pane.removeAll();
				Pane.addTab("�������", panel4);
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("����Ʋ�", panel3);				
				Pane.addTab("������", panel5);
				Pane.addTab("��У���", panel6);
				Pane.addTab("������", panel7);
			}
		});
		menu[4].setText("��ѯ������");
		menu[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodE();
			}
			private void methodE() {
				Pane.removeAll();
				Pane.addTab("������", panel5);
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("�������", panel4);				
				Pane.addTab("��У���", panel6);
				Pane.addTab("������", panel7);
			}
		});
		menu[5].setText("��ѯ��У���");
		menu[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodF();
			}
			private void methodF() {
				Pane.removeAll();
				Pane.addTab("��У���", panel6);
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("�������", panel4);
				Pane.addTab("������", panel5);				
				Pane.addTab("������", panel7);
			}
		});
		menu[6].setText("��ѯ������");
		menu[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodF();
			}
			private void methodF() {
				Pane.removeAll();
				Pane.addTab("������", panel7);
				Pane.addTab("ѧ����Ϣ", panel1);
				Pane.addTab("������Ϣ", panel2);
				Pane.addTab("����Ʋ�", panel3);
				Pane.addTab("�������", panel4);
				Pane.addTab("������", panel5);
				Pane.addTab("��У���", panel6);			
			}
		});
		for(int i=0;i<menu.length;i++) {
			panel.add(menu[i]);
		}
		return panel;
	}
	//������ʾ�Ի���ķ���
	protected static void createDialog(String title,String name,int size,int x,int y,int width,int height) {  //ǰ3�����������ǶԻ������,��ǩ��,�����С,��4������Ϊ��ǩ��λ��
		JDialog dialog1=new JDialog(mainJFrame,title,true);  //������ģʽ�ĶԻ���
		dialog1.setSize(300,200);														//���öԻ���Ĵ�С
		dialog1.setLocationRelativeTo(null);									//���öԻ�����������ʾ
		dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container1=dialog1.getContentPane();
		container1.setLayout(null);//����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��	
		JLabel p= new JLabel(name);		//����
		p.setFont(new Font("����", Font.BOLD, size));
		
		if(title.indexOf("�ɹ�") != -1)           //������ı����С��ɹ������������ǩ������ɫΪ��ɫ
			p.setForeground(Color.blue);
		else 													    //����,��ǩ������ɫΪ��ɫ
			p.setForeground(Color.red);
		
		p.setBounds(x, y, width, height);	//���ñ���Ĵ�С��λ��
		container1.add(p);
		dialog1.setVisible(true);
	}
	protected static void message_inquire(JTextField n1,JTextField n2 ) {  //ѧ����Ϣ��ѯ����,���������ı������ڻ�ȡ��Ӧ��ֵ
		JDialog dialog=new JDialog(mainJFrame,"ѧ����Ϣ��ѯ",true);
		dialog.setSize(410,150);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container=dialog.getContentPane();
		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		
		String num=n1.getText().trim();      //��ȡ�����ı��������
		String name_stu=n2.getText().trim();
		if(num.equals("") || name_stu.equals("")) {
			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
		}
		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
			try {				
				boolean flag=true;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
				Statement stmt = conn.createStatement();
				String request = "SELECT Sno,student.name,class,dorm_num,beg_num from zhanghongrui.student,zhanghongrui.dorm where Sno='"+num+"' and student.name='"+name_stu+"'and student.name=dorm.name";
				ResultSet rs = stmt.executeQuery(request);
				
					while(rs.next()) {        //�����ݿ��н�ѧ��,����,�༶,�����,���Ų�ѯ����
						Sno = rs.getString("Sno");
						stu_name = rs.getString("name");
						course = rs.getString("class");
						dormnum = rs.getString("dorm_num");
						begnum = rs.getString("beg_num");
						//�����ͷ
						String[] colname = {"ѧ��","����","�༶","�����","��λ��"};
						String[][] tablevalues = {{Sno,stu_name,course,dormnum,begnum}};
						//�������ģ��
						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
						JTable table = new JTable(tablemodel);  //�������
						JScrollPane scrollpane = new JScrollPane(table);  //��������������
						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
						container.add(scrollpane);
						dialog.setVisible(true);       // ��ʾ�Ի���
						flag=false;
					}	
					if(flag) {
						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
					}																
					rs.close();	
					stmt.close();
					conn.close();					
			}catch(Exception ee) {
				System.err.println(ee.getMessage());
			}	
		}	
	}
	
	protected static Component createPanel1() {  //����ѧ����Ϣ����ҳ��
		panel1.setLayout(null);  //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();  //�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"ѧ��","����","�༶"});  //������ͷ
		try {				//��ѯѧ����Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.student";
			ResultSet rs = stmt.executeQuery(request);//ִ�в�ѯ���
			
			while(rs.next()) {		//��ѧ��,����,�༶��ѯ����
					String Sno = rs.getString("Sno");
					String stu_name = rs.getString("name");
					String course = rs.getString("class");
					//����ѯ����������һ��һ�е���ӽ������
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
			ee.printStackTrace();
		}	
		final JTable table = new JTable(zhang_tablemodel);  //�������
		JScrollPane scrollpane = new JScrollPane(table);		//��������óɹ������
		scrollpane.setBounds(60,20,400,200);
		panel1.add(scrollpane);                             //��ʾѧ����Ϣ��
		
		stu1.setBounds(100, 240, 50, 50);           //ѧ�ű�ǩ
		panel1.add(stu1);
		stu3.setBounds(140,250,200,30);		
		panel1.add(stu3);
		
		stu2.setBounds(100,270,50,50);               //������ǩ
		panel1.add(stu2);
		stu4.setBounds(140,280,200,30);			
		panel1.add(stu4);
		
		stu7.setBounds(100,300,50,50);               //�༶��ǩ
		panel1.add(stu7);
		stu8.setBounds(140,310,200,30);			
		panel1.add(stu8);
		
		insert.setBounds(50, 380, 60, 30);           //���밴ť
		panel1.add(insert);
		
		mod.setBounds(130, 380, 60, 30);           //�޸İ�ť
		panel1.add(mod);
		
		del.setBounds(210, 380, 60, 30);              //ɾ����ť
		panel1.add(del);
		
		inquire.setBounds(290, 380, 60, 30);       //��ѯ��ť
		panel1.add(inquire);
		
		stu6.setBounds(370, 380, 60, 30);            //��հ�ť
		panel1.add(stu6);
		
		
		insert.addActionListener(new ActionListener() {  //���밴ť����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = stu3.getText();  //�ֱ��ȡ3���ı����ֵ
				String text2 = stu4.getText();
				String text3 = stu8.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.student";
						ResultSet rs = stmt.executeQuery(request);  //��ѧ����Ϣ�����Ϣ��ѯ����
						
						while(rs.next()) {		//��ѯ�Ƿ�����ѧ��
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  				//����ѧ�ŵ����Ի���
							createDialog("ѧ���������","�������ѧ���Ѵ���",25,20, 20, 280, 80);
						}
						if(!flag) {  				//������ͬѧ�����������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into student values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		stu6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	stu3.setText("");
            	stu4.setText("");
            	stu8.setText("");
            }});
		del.addActionListener(new ActionListener() {		//ɾ����ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = stu3.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select Sno from zhanghongrui.student";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ���ѧ��
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //��ѧ���򵯳��Ի���
							createDialog("ѧ���������","�������ѧ�Ų�����",25,20, 20, 280, 80);
						}
						if(!flag) {        //����ѧ����ɾ������
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  //��δѡ����
								createDialog("δѡ����","��ѡ����ѧ����ͬ����",20,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {			//�������ѧ����ѡ���е�ѧ��һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.student where Sno='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ����ѧ����ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		mod.addActionListener(new ActionListener() {  //�޸İ�ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = stu3.getText();
				String text2 = stu4.getText();
				String text3 = stu8.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();  //�޸�ʱ��ѡ�д��޸ĵ���,���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();		//��ȡ������
							if(selectedRow!= -1) { 		//�Ƿ����ѡ����,��δ��������Ӧ��������Ϊ-1
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//��ѡ���еĵ�һ�м�ѧ�Ż�ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //����������ȡÿ�еĵ�һ����Ԫ���ֵ
										if(s.equals(text1)) {  //�ٽ�ÿ�е�һ����Ԫ���ֵ�������ѧ�űȽ��Ƿ���ͬ��ѧ�Ų�����ͬ��
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�������ѧ�Ų���ͬ���޸�����,��ͬһ������в��ܴ�����ͬ��ѧ��
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.student SET Sno='"+text1+"',name='"+text2+"',class='"+text3+"' where Sno='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("ѧ���Ѿ�����","ѧ���Ѿ�����",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		inquire.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=stu3.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT Sno,student.name,class from zhanghongrui.student where Sno='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�ѧ��,����,�༶��ѯ����
        						Sno = rs.getString("Sno");
        						stu_name = rs.getString("name");
        						course = rs.getString("class");
        						//�����ͷ
        						String[] colname = {"ѧ��","����","�༶"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel1;
	}
	protected static Component createPanel2() {		//����������Ϣ�����ҳ��
		panel2.setLayout(null);		//����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"�����","����绰","����¥��"});//������ͷ
		try {				//��ѯѧ����Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.dorm_message";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		  //�������,����绰,��������¥���ѯ����
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("dorm_tel");
					String course = rs.getString("dorm_floor");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel2.add(scrollpane);        				//��ʾ������Ϣ��
		
		zhr1.setBounds(100, 240, 80, 50);		//����ű�ǩ
		panel2.add(zhr1);
		zhr4.setBounds(160,250,200,30);		
		panel2.add(zhr4);
		
		zhr2.setBounds(100,270,80,50);			//����绰��ǩ
		panel2.add(zhr2);
		zhr5.setBounds(160,280,200,30);			
		panel2.add(zhr5);
		
		zhr3.setBounds(100,300,80,50);  		//��������¥���ǩ
		panel2.add(zhr3);
		zhr6.setBounds(160,310,200,30);			
		panel2.add(zhr6);
		
		zhr7.setBounds(80, 380, 60, 30);        //���밴ť
		panel2.add(zhr7);
		
		zhr8.setBounds(160, 380, 60, 30);		//�޸İ�ť
		panel2.add(zhr8);
			
		zhr11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel2.add(zhr11);
		
		zhr9.setBounds(320, 380, 60, 30);		//ɾ����ť
		panel2.add(zhr9);
		
		zhr10.setBounds(400, 380, 60, 30);	//��հ�ť
		panel2.add(zhr10);
		
		
		zhr7.addActionListener(new ActionListener() {	//����ѧ��������Ϣ��ť����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = zhr4.getText();
				String text2 = zhr5.getText();
				String text3 = zhr6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.dorm_message";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ����������
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //��������ŵ����Ի���
							createDialog("������������","�������������Ѵ���",25,15, 20, 280, 80);
						}
						if(!flag) {  //������ͬ��������������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into dorm_message values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		zhr8.addActionListener(new ActionListener() { //�޸�ѧ��������Ϣ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = zhr4.getText();
				String text2 = zhr5.getText();
				String text3 = zhr6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();	//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { 		//�Ƿ����ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//��ѡ���е�����Ż�ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //����������ȡÿ�еĵ�һ����Ԫ���ֵ
										if(s.equals(text1)) {  //�ٽ�ÿ�е�һ����Ԫ���ֵ�������������Ƿ���ͬ������Ų�����ͬ��
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�����������Ų���ͬ���޸�����
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.dorm_message SET dorm_num='"+text1+"',dorm_tel='"+text2+"',dorm_floor='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
											stmt.close();
											conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("������Ѵ���","������Ѵ���",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		zhr9.addActionListener(new ActionListener() {	//ɾ��ѧ��������Ϣ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = zhr4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num from zhanghongrui.dorm_message";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ��������
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //��������򵯳��Ի���
							createDialog("������������","�����������Ų�����",25,15, 20, 280, 80);
						}
						if(!flag) {        //�����������ɾ������
							int row = table.getSelectedRow();		//��ȡѡ����к�
							if(row==-1) {  		//��δѡ����
								createDialog("δѡ����","��ѡ�����������ͬ����",20,25, 20, 280, 80);
							}
							else {						//��ѡ����ִ��
								int selectedRow = table.getSelectedRow();	//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.dorm_message where dorm_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ�����������ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		zhr10.addActionListener(new ActionListener() {		//����ı������ݵ���Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {
            	zhr4.setText("");
            	zhr5.setText("");
            	zhr6.setText("");
            }});
		zhr11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=zhr4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT dorm_num,dorm_tel,dorm_floor from zhanghongrui.dorm_message where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н������,����绰,��������¥���ѯ����
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("dorm_tel");
        						course = rs.getString("dorm_floor");
        						//�����ͷ
        						String[] colname = {"�����","����绰","��������¥��"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel2;
	}
	protected static Component createPanel3() {	//��������Ʋ����ݱ�Ĳ���ҳ��
		panel3.setLayout(null);		//����Ϊ���Բ��ַ�ʽ,������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"��Ʒ���","��Ʒ��","��Ʒ�۸�"});//������ͷ
		try {				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.property";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//��ѯ����Ʋ���Ϣ����ʾ����
					String Sno = rs.getString("goods_num");
					String stu_name = rs.getString("goods_name");
					float course = rs.getFloat("goods_price");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel3.add(scrollpane);        					//��ʾ����Ʋ���Ϣ��
		
		hong1.setBounds(100, 240, 80, 50);		//��Ʒ���
		panel3.add(hong1);
		hong4.setBounds(160,250,200,30);		
		panel3.add(hong4);
		
		hong2.setBounds(100,270,80,50);			//��Ʒ��
		panel3.add(hong2);
		hong5.setBounds(160,280,200,30);			
		panel3.add(hong5);
		
		hong3.setBounds(100,300,80,50);  		//��Ʒ�۸�
		panel3.add(hong3);
		hong6.setBounds(160,310,200,30);			
		panel3.add(hong6);
		
		hong7.setBounds(80, 380, 60, 30);        //���밴ť
		panel3.add(hong7);
		
		hong8.setBounds(160, 380, 60, 30);		//�޸İ�ť
		panel3.add(hong8);
		
		hong11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel3.add(hong11);
		
		hong9.setBounds(320, 380, 60, 30);		//ɾ����ť
		panel3.add(hong9);
		
		hong10.setBounds(400, 380, 60, 30);	//��հ�ť
		panel3.add(hong10);
		
		
		hong7.addActionListener(new ActionListener() {		//��������Ʋ���Ϣ����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = hong4.getText();
				String text2 = hong5.getText();
				String text3 = hong6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.property";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ�������Ʒ��
								zhr1 = rs.getString("goods_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //������Ʒ�ŵ����Ի���
							createDialog("��Ʒ���������","���������Ʒ���Ѵ���",25,10, 20, 280, 80);
						}
						if(!flag) {  //������ͬ��Ʒ�����������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.property values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		hong8.addActionListener(new ActionListener() { 		//�޸�����Ʋ���Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = hong4.getText();
				String text2 = hong5.getText();
				String text3 = hong6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();	//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) {	 //�Ƿ����ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//��ѡ���е���Ʒ�Ż�ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //����������ȡÿ�еĵ�һ����Ԫ���ֵ
										if(s.equals(text1)) {  //�ٽ�ÿ�е�һ����Ԫ���ֵ���������Ʒ���Ƿ���ͬ����Ʒ�Ų�����ͬ��
											flag=true;
											break;
										}
									}
									if(!flag) {  //����Ʒ�Ų���ͬ���޸�
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.property SET goods_num='"+text1+"',goods_name='"+text2+"',goods_price='"+text3+"' where goods_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("��Ʒ���Ѵ���","��Ʒ���Ѵ���",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		hong9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = hong4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   //��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select goods_num from zhanghongrui.property";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ�����Ʒ��
								zhr1 = rs.getString("goods_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //����Ʒ���򵯳��Ի���
							createDialog("��Ʒ���������","���������Ʒ�Ų�����",25,10, 20, 280, 80);
						}
						if(!flag) {        //������Ʒ����ɾ������
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  		//��δѡ����
								createDialog("δѡ����","��ѡ������Ʒ����ͬ����",22,12, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.property where goods_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ������Ʒ����ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		hong10.addActionListener(new ActionListener() {	//����ı���
            @Override
            public void actionPerformed(ActionEvent e) {
            	hong4.setText("");
            	hong5.setText("");
            	hong6.setText("");
            }});
		hong11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=hong4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.property where goods_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�"��Ʒ���","��Ʒ��","��Ʒ�۸�"��ѯ����
        						Sno = rs.getString("goods_num");
        						stu_name = rs.getString("goods_name");
        						course = rs.getString("goods_price");
        						//�����ͷ
        						String[] colname = {"��Ʒ���","��Ʒ��","��Ʒ�۸�"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel3;
	}
	protected static Component createPanel4() {  
		panel4.setLayout(null);//����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"�����","����������","������Ʒ��"});//������ͷ
		try {				//��ѯ������Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.maintain";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//��ѯ�����,����������,������Ʒ��
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
					String course = rs.getString("goods_name");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel4.add(scrollpane);        //��ʾ������Ϣ��
		
		rui1.setBounds(100, 240, 80, 50);		//�����
		panel4.add(rui1);
		rui4.setBounds(180,250,200,30);		
		panel4.add(rui4);
		
		rui2.setBounds(100,270,80,50);		//����������
		panel4.add(rui2);
		rui5.setBounds(180,280,200,30);			
		panel4.add(rui5);
		
		rui3.setBounds(100,300,80,50);  	//������Ʒ��
		panel4.add(rui3);
		rui6.setBounds(180,310,200,30);			
		panel4.add(rui6);
		
		rui7.setBounds(80, 380, 60, 30);     	 //���밴ť
		panel4.add(rui7);
		
		rui8.setBounds(160, 380, 60, 30);		//�޸İ�ť
		panel4.add(rui8);
		
		rui11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel4.add(rui11);
		
		rui9.setBounds(320, 380, 60, 30);		//ɾ����ť
		panel4.add(rui9);
		
		rui10.setBounds(400, 380, 60, 30);		//��հ�ť
		panel4.add(rui10);
		
		
		rui7.addActionListener(new ActionListener() {	//���뱨����Ϣ����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = rui4.getText();
				String text2 = rui5.getText();
				String text3 = rui6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.maintain";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ����������
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //��������ŵ����Ի���
							createDialog("������������","�������������Ѵ���",25,10, 20, 280, 80);
						}
						if(!flag) {  //��������������������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.maintain values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		rui8.addActionListener(new ActionListener() { //�޸ı�����Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = rui4.getText();
				String text2 = rui5.getText();
				String text3 = rui6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //�Ƿ����ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//��ѡ���е�����Ż�ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //����������ȡÿ�еĵ�һ����Ԫ���ֵ
										if(s.equals(text1)) {  //�ٽ�ÿ�е�һ����Ԫ���ֵ�������������Ƿ���ͬ������Ų�����ͬ��
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�����������Ų���ͬ
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.maintain SET dorm_num='"+text1+"',name='"+text2+"',goods_name='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("������Ѵ���","������Ѵ���",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		rui9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = rui4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num from zhanghongrui.maintain";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ��������
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //��������򵯳��Ի���
							createDialog("������������","�����������Ų�����",25,10, 20, 280, 80);
						}
						if(!flag) {        //�����������ɾ������
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  //��δѡ����
								createDialog("δѡ����","��ѡ�����������ͬ����",20,25, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.maintain where dorm_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ�����������ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		rui10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	rui4.setText("");
            	rui5.setText("");
            	rui6.setText("");
            }});
		rui11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=rui4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.maintain where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�"�����","����������","������Ʒ��"��ѯ����
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("name");
        						course = rs.getString("goods_name");
        						//�����ͷ
        						String[] colname = {"�����","����������","������Ʒ��"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel4;
	}
	protected static Component createPanel5() {
		panel5.setLayout(null);//����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"�����","����","���ʱ��"});//������ͷ
		try {				//��ѯѧ�������Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.late";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//��ѯ�����,����,���ʱ��
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
					String course = rs.getString("late_time");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel5.add(scrollpane);        //��ʾ�����Ϣ��
		
		wang1.setBounds(100, 240, 80, 50);	//�����
		panel5.add(wang1);
		wang4.setBounds(160,250,200,30);		
		panel5.add(wang4);
		
		wang2.setBounds(100,270,80,50);		//����
		panel5.add(wang2);
		wang5.setBounds(160,280,200,30);			
		panel5.add(wang5);
		
		wang3.setBounds(100,300,80,50);  	//���ʱ��
		panel5.add(wang3);
		wang6.setBounds(160,310,200,30);			
		panel5.add(wang6);
		
		wang7.setBounds(80, 380, 60, 30);      //���밴ť
		panel5.add(wang7);
		
		wang8.setBounds(160, 380, 60, 30);		//�޸İ�ť
		panel5.add(wang8);
		
		wang11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel5.add(wang11);
		
		wang9.setBounds(320, 380, 60, 30);		//ɾ����ť
		panel5.add(wang9);
		
		wang10.setBounds(400, 380, 60, 30);	//��հ�ť
		panel5.add(wang10);
		
		
		wang7.addActionListener(new ActionListener() {	//����ѧ�������Ϣ����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String zhr2=null;
				String text1 = wang4.getText();
				String text2 = wang5.getText();
				String text3 = wang6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.late";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//����ź�����������ͬ
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = true;
								}
						}		
						if(flag) {  //��������ź����������Ի���
							createDialog("����Ż������������","�����������ź������Ѵ���",20,5, 20, 280, 80);
						}
						if(!flag) {  //�����������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.late values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		wang8.addActionListener(new ActionListener() { //�޸�ѧ�������Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = wang4.getText();
				String text2 = wang5.getText();
				String text3 = wang6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//��ѡ���е�����ź�������ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //��ȡÿ�е������
										String s1=(String) model.getValueAt(i, 1);  //��ȡÿ�е�����
										if(s.equals(text1) && s1.equals(text2)) {  //����ź��������ܶ���ͬ
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�����������ź���������ͬ
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.late SET dorm_num='"+text1+"',name='"+text2+"',late_time='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("��Ϣ��������","�������������ͬ",25,30, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		wang9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = wang4.getText();
            	String text2 = wang5.getText();
				String zhr1=null;
				String zhr2=null;
            	if(text1.equals("") || text2.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num,name from zhanghongrui.late";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ�������ź�����
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = false;
								}
						}		
						if(flag) {        //������Ż������򵯳��Ի���
							createDialog("�������","����Ż�����������",25,20, 20, 280, 80);
						}
						if(!flag) {        
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  //��δѡ����
								createDialog("δѡ����","��ѡ�����������ͬ����",20,25, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								String value1 = (String) table.getModel().getValueAt(selectedRow, 1);
								if(value.equals(text1) && value1.equals(text2)) {//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.late where dorm_num='"+text1+"' and name='"+text2+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ��������ź�������ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		wang10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	wang4.setText("");
            	wang5.setText("");
            	wang6.setText("");
            }});
		wang11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=wang4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				final DefaultTableModel zhang_tablemodel = new DefaultTableModel();  //�������ģ��
        				zhang_tablemodel.setColumnIdentifiers(new Object[] {"�����","����","���ʱ��"});  //������ͷ
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.late where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�"�����","����","���ʱ��"��ѯ����
        						String Sno1 = rs.getString("dorm_num");
        						String stu_name1 = rs.getString("name");
//        						course = rs.getString("late_time");
        						Time course = rs.getTime("late_time");
        						//�����ͷ
//        						String[] colname = {"�����","����","���ʱ��"};
//        						String[][] tablevalues = {{Sno,stu_name,course}};
        						zhang_tablemodel.addRow(new Object[] {Sno1,stu_name1,course});	
        						//�������ģ��
//        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(zhang_tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel5;
	}
	protected static Component createPanel6() {
		panel6.setLayout(null);//����Ϊ���Բ��ַ�ʽ,������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"�����","����","��Уʱ��"});//������ͷ
		try {				//��ѯѧ����Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.leave";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//��ѯ�����,����,��Уʱ��
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
//					String course = rs.getString("leave_time");
					Date course = rs.getDate("leave_time");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel6.add(scrollpane);        //��ʾ��У��Ϣ��
		
		mei1.setBounds(100, 240, 80, 50);		//�����
		panel6.add(mei1);
		mei4.setBounds(160,250,200,30);		
		panel6.add(mei4);
		
		mei2.setBounds(100,270,80,50);		//����
		panel6.add(mei2);
		mei5.setBounds(160,280,200,30);			
		panel6.add(mei5);
		
		mei3.setBounds(100,300,80,50);  		//��Уʱ��
		panel6.add(mei3);
		mei6.setBounds(160,310,200,30);			
		panel6.add(mei6);
		
		mei7.setBounds(80, 380, 60, 30);     	 //���밴ť
		panel6.add(mei7);
		
		mei8.setBounds(160, 380, 60, 30);		  //�޸İ�ť
		panel6.add(mei8);
		
		mei11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel6.add(mei11);
		
		mei9.setBounds(320, 380, 60, 30);		  //ɾ����ť
		panel6.add(mei9);
		
		mei10.setBounds(400, 380, 60, 30);	  //��հ�ť
		panel6.add(mei10);
		
		mei7.addActionListener(new ActionListener() {		//����ѧ����У��Ϣ����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String zhr2=null;
				String text1 = mei4.getText();
				String text2 = mei5.getText();
				String text3 = mei6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   				
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.leave";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = true;
								}
						}		
						if(flag) {  //��������ź����������Ի���
							createDialog("�������","�����������ź������Ѵ���",20,6, 20, 280, 80);
						}
						if(!flag) {  //�����������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.leave values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		mei8.addActionListener(new ActionListener() {  //�޸�ѧ����У��Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = mei4.getText();
				String text2 = mei5.getText();
				String text3 = mei6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//��ѡ���е�����ź�������ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //��ȡÿ�е������
										String s1=(String) model.getValueAt(i, 1);  //��ȡÿ�е�����
										if(s.equals(text1) && s1.equals(text2)) {  //����ź��������ܶ���ͬ
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�����������ź�����������ͬ
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.leave SET dorm_num='"+text1+"',name='"+text2+"',leave_time='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("��Ϣ��������","�������������ͬ",25,30, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		mei9.addActionListener(new ActionListener() {		//ɾ��ѧ����У��Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = mei4.getText();
            	String text2 = mei5.getText();
				String zhr1=null;
				String zhr2=null;
            	if(text1.equals("") || text2.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num,name from zhanghongrui.leave";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ�������ź�����
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = false;
								}
						}		
						if(flag) {        //������ź������򵯳��Ի���
							createDialog("�������","�����������Ż�����������",20,6, 20, 280, 80);
						}
						if(!flag) {        //����ɾ������
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  //��δѡ����
								createDialog("δѡ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								String value1 = (String) table.getModel().getValueAt(selectedRow, 1);
								if(value.equals(text1) && value1.equals(text2)) {		//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.leave where dorm_num='"+text1+"' and name='"+text2+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ��������ź�������ͬ����","��ѡ����Ӧ����",30,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		mei10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mei4.setText("");
            	mei5.setText("");
            	mei6.setText("");
            }});
		mei11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=mei4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.leave where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�"�����","����","��Уʱ��"��ѯ����
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("name");
        						course = rs.getString("leave_time");
        						//�����ͷ
        						String[] colname = {"�����","����","��Уʱ��"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel6;
	}
	protected static Component createPanel7() {
		panel7.setLayout(null);		//����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//�������ģ��
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"ѧ��","����","�����"});//������ͷ
		try {				//��ѯѧ�������Ϣ����ʾ����
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.off";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//��ѯѧ��,����,�����
					String Sno = rs.getString("Sno");
					String stu_name = rs.getString("name");
					String course = rs.getString("dorm_num");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//�������					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
		}	
		
		final JTable table = new JTable(zhang_tablemodel);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(60,20,400,200);
		panel7.add(scrollpane);        //��ʾѧ�������Ϣ��
		
		ting1.setBounds(100, 240, 80, 50);		//ѧ��
		panel7.add(ting1);
		ting4.setBounds(150,250,200,30);		
		panel7.add(ting4);
		
		ting2.setBounds(100,270,80,50);		//����
		panel7.add(ting2);
		ting5.setBounds(150,280,200,30);			
		panel7.add(ting5);
		
		ting3.setBounds(100,300,80,50);  		//�����
		panel7.add(ting3);
		ting6.setBounds(150,310,200,30);			
		panel7.add(ting6);
		
		ting7.setBounds(80, 380, 60, 30);      //���밴ť
		panel7.add(ting7);
		
		ting8.setBounds(160, 380, 60, 30);		//��ѯ��ť
		panel7.add(ting8);
		
		ting11.setBounds(240, 380, 60, 30);       //��ѯ��ť
		panel7.add(ting11);
		
		ting9.setBounds(320, 380, 60, 30);		//�޸İ�ť
		panel7.add(ting9);
		
		ting10.setBounds(400, 380, 60, 30);	//��հ�ť
		panel7.add(ting10);
		
		ting7.addActionListener(new ActionListener() {	//����ѧ�������Ϣ����Ӧ����
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = ting4.getText();
				String text2 = ting5.getText();
				String text3 = ting6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   		//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.off";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ�����ѧ��
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //����ѧ�ŵ����Ի���
							createDialog("ѧ���������","�������ѧ���Ѵ���",25,20, 20, 280, 80);
						}
						if(!flag) {  //������ͬѧ�����������
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //�������
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into off values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("��Ϣ����ɹ�","��Ϣ����ɹ�",30,35, 20, 280, 80);
						}			
							rs.close();	
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}
			}
		});
		ting8.addActionListener(new ActionListener() {  //�޸�ѧ����У��Ϣ����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {		
            	String text1 = ting4.getText();
				String text2 = ting5.getText();
				String text3 = ting6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   				//��ʾΪ�յ���Ϣ
				}
				else {
					int selectedRow = table.getSelectedRow();//���ѡ���е�����
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //�Ƿ����ѡ����
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//��ѡ���е�ѧ�Ż�ȡ����
									for(int i=0;i<model.getRowCount();i++) {  //��ȡ��������
										String s=(String) model.getValueAt(i, 0);  //����������ȡÿ�еĵ�һ����Ԫ���ֵ
										if(s.equals(text1)) {  //�ٽ�ÿ�е�һ����Ԫ���ֵ�������ѧ���Ƿ���ͬ��ѧ�Ų�����ͬ��
											flag=true;
											break;
										}
									}
									if(!flag) {  //ÿ�е�һ����Ԫ���ֵ�������ѧ�Ų���ͬ
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.off SET Sno='"+text1+"',name='"+text2+"',dorm_num='"+text3+"' where Sno='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("��Ϣ�޸ĳɹ�","��Ϣ�޸ĳɹ�",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("ѧ���Ѵ���","ѧ���Ѿ�����",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("δѡ����","��ѡ�д��޸ĵ���",30,10, 20, 280, 80);
				}
            }});
		ting9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = ting4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("������Ϣ����","�ı����п�",30,55, 30, 280, 60);   	//��ʾΪ�յ���Ϣ
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select Sno from zhanghongrui.off";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//��ѯ�Ƿ���ѧ��
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //��ѧ���򵯳��Ի���
							createDialog("ѧ���������","�������ѧ�Ų�����",25,20, 20, 280, 80);
						}
						if(!flag) {        //����ѧ����ɾ������
							int row = table.getSelectedRow();//��ȡѡ����к�
							if(row==-1) {  //��δѡ����
								createDialog("δѡ����","��ѡ����ѧ����ͬ����",20,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();//���ѡ���е�����
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//������һ��ʱɾ��
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.off where Sno='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("��Ϣɾ���ɹ�","��Ϣɾ���ɹ�",30,35, 20, 280, 80);
								}
								else
									createDialog("δѡ����ѧ����ͬ����","��ѡ����ѧ����ͬ����",20,30, 20, 280, 80);
							}
						}			
							rs.close();	
							stmt.close();
							conn.close();			
				}catch(Exception ee) {
					System.err.println(ee.getMessage());
				}	
            }
            }});
		ting10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ting4.setText("");
            	ting5.setText("");
            	ting6.setText("");
            }});
		ting11.addActionListener(new ActionListener() {       //��ѯ��ť����Ӧ����
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"��Ϣ��ѯ",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //����Ϊ���Բ��ַ�ʽ��������ֵȷ��λ��
        		
        		String num=ting4.getText().trim();      //��ȡ�����ı��������
        		if(num.equals("")) {
        			createDialog("������Ϣ����","�ı����п�",30,50, 30, 280, 60);  	//��ʾΪ�յ���Ϣ
        		}
        		else {      //�ı��򶼲�Ϊ��ִ��try-catch���
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.off where Sno='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //�����ݿ��н�"ѧ��","����","�����"��ѯ����
        						Sno = rs.getString("Sno");
        						stu_name = rs.getString("name");
        						course = rs.getString("dorm_num");
        						//�����ͷ
        						String[] colname = {"ѧ��","����","�����"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//�������ģ��
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //�������
        						JScrollPane scrollpane = new JScrollPane(table);  //��������������
        						scrollpane.setBounds(10, 25, 380, 60);  //���ù�������λ��
        						container.add(scrollpane);
        						dialog.setVisible(true);       // ��ʾ�Ի���
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("�Ҳ�����Ϣ","�����ҵ���Ϣ������",25,20, 20, 280, 80);  
        					}																
        					rs.close();	
        					stmt.close();
        					conn.close();					
        			}catch(Exception ee) {
        				System.err.println(ee.getMessage());
        			}	
        		}	
            }});
		return panel7;
	}
}
