package 数据库大作业Text;

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
	static ZhangDemo mainJFrame = new ZhangDemo();  //新建窗口
	//登陆界面,所用的数据库为zhanghongrui
	static JLabel user = new JLabel("身份：");
	static String data[]={"请选择","宿舍管理员","学生"};
	static JComboBox cbx=new JComboBox(data);		//下拉列表框
	static JLabel name=new JLabel("欢迎登陆华广学生宿舍管理系统");
	static JLabel lbl2 = new JLabel("账号：");
	static JLabel lbl3 = new JLabel("密码：");
	static JTextField jTextField=new JTextField(10);
	static JPasswordField jPasswordField=new JPasswordField(10);
	static JPanel jPanel=new JPanel();
	static JDialog diag = new JDialog(mainJFrame); // 创建隶属于mainJFrame的对话框
	static JButton bt_login = new JButton("登录");
	static JButton bt_cancel = new JButton("清空");
	//查询学生信息面板组件
	static JLabel stu=new JLabel("欢迎查询学生信息");	
	static JLabel stu1 = new JLabel("学号：");
	static JLabel stu2 = new JLabel("姓名：");
	static JTextField stu3=new JTextField(10);
	static JTextField stu4=new JTextField(10);
	static JButton stu5 = new JButton("查询");
	static JButton stu6 = new JButton("清空");
	//修改登陆密码面板组件,共用stu_stu6清空按钮
	static JLabel stu_stu=new JLabel("您正在修改登陆密码");
	static JLabel stu_stu1 = new JLabel("原密码：");
	static JLabel stu_stu2 = new JLabel("新密码：");
	static JTextField stu_stu3=new JTextField(10);
	static JTextField stu_stu4=new JTextField(10);
	static JButton stu_stu5 = new JButton("修改");	
	//查询学生信息面板组件,共用stu1,stu2,stu3,stu4按钮
	static JLabel stu7 = new JLabel("班级：");
	static JTextField stu8=new JTextField(10);
	static JButton insert = new JButton("插入");
	static JButton del = new JButton("删除");
	static JButton mod = new JButton("修改");
	static JButton inquire = new JButton("查询");
	static JButton stu_stu6 = new JButton("清空");
	//查询宿舍信息面板组件
	static JLabel zhr1 = new JLabel("宿舍号：");
	static JLabel zhr2 = new JLabel("宿舍电话：");
	static JLabel zhr3= new JLabel("宿舍楼层：");
	static JTextField zhr4=new JTextField(10);
	static JTextField zhr5=new JTextField(10);
	static JTextField zhr6=new JTextField(10);
	static JButton zhr7 = new JButton("插入");
	static JButton zhr8= new JButton("修改");
	static JButton zhr9 = new JButton("删除");
	static JButton zhr10= new JButton("清空");
	static JButton zhr11 = new JButton("查询");
	//查询宿舍财产面板组件
	static JLabel hong1 = new JLabel("物品编号：");
	static JLabel hong2 = new JLabel("物品名：");
	static JLabel hong3= new JLabel("物品价格：");
	static JTextField hong4=new JTextField(10);
	static JTextField hong5=new JTextField(10);
	static JTextField hong6=new JTextField(10);
	static JButton hong7 = new JButton("插入");
	static JButton hong8 = new JButton("修改");
	static JButton hong9 = new JButton("删除");
	static JButton hong10= new JButton("清空");
	static JButton hong11 = new JButton("查询");
	//查询宿舍报修信息面板组件
	static JLabel rui1 = new JLabel("宿舍号：");
	static JLabel rui2 = new JLabel("报修人姓名：");
	static JLabel rui3= new JLabel("报修物品名：");
	static JTextField rui4=new JTextField(10);
	static JTextField rui5=new JTextField(10);
	static JTextField rui6=new JTextField(10);
	static JButton rui7 = new JButton("插入");
	static JButton rui8 = new JButton("修改");
	static JButton rui9 = new JButton("删除");
	static JButton rui10= new JButton("清空");
	static JButton rui11 = new JButton("查询");
	//查询学生晚归信息面板组件
	static JLabel wang1 = new JLabel("宿舍号：");
	static JLabel wang2 = new JLabel("姓名：");
	static JLabel wang3= new JLabel("晚归时间：");
	static JTextField wang4=new JTextField(10);
	static JTextField wang5=new JTextField(10);
	static JTextField wang6=new JTextField(10);
	static JButton wang7 = new JButton("插入");
	static JButton wang8 = new JButton("修改");
	static JButton wang9 = new JButton("删除");
	static JButton wang10= new JButton("清空");
	static JButton wang11 = new JButton("查询");
	//查询学生离校信息面板组件
	static JLabel mei1 = new JLabel("宿舍号：");
	static JLabel mei2 = new JLabel("姓名：");
	static JLabel mei3= new JLabel("离校时间：");
	static JTextField mei4=new JTextField(10);
	static JTextField mei5=new JTextField(10);
	static JTextField mei6=new JTextField(10);
	static JButton mei7 = new JButton("插入");
	static JButton mei8 = new JButton("修改");
	static JButton mei9 = new JButton("删除");
	static JButton mei10= new JButton("清空");
	static JButton mei11 = new JButton("查询");
	//查询学生请假信息面板组件
	static JLabel ting1 = new JLabel("学号：");
	static JLabel ting2 = new JLabel("姓名：");
	static JLabel ting3= new JLabel("宿舍号：");
	static JTextField ting4=new JTextField(10);
	static JTextField ting5=new JTextField(10);
	static JTextField ting6=new JTextField(10);
	static JButton ting7 = new JButton("插入");
	static JButton ting8 = new JButton("修改");
	static JButton ting9 = new JButton("删除");
	static JButton ting10= new JButton("清空");
	static JButton ting11 = new JButton("查询");
	
	static String Sno ;                        //学号
	static String stu_name;		        //学生姓名
	static String course;                   //班级
	static String dormnum;            //宿舍号
	static String begnum;               //床号
	static String stu_username;    //学生用户名
	static String man_username;  //管理员用户名
	static JPanel p=new JPanel();
	static JPanel panelA=new JPanel(false);   //学生信息查询面板,不使用双缓冲,内存占用少一点
	static JPanel panelB=new JPanel(false);	//学生密码修改面板
	static JPanel panel1=new JPanel(false);   //定义7个表查询面板,没有设置特定的缓冲策略
	static JPanel panel2=new JPanel(false);
	static JPanel panel3=new JPanel(false);
	static JPanel panel4=new JPanel(false);
	static JPanel panel5=new JPanel(false);
	static JPanel panel6=new JPanel(false);
	static JPanel panel7=new JPanel(false);
	static JTabbedPane tabbedPane1=new JTabbedPane();  //左侧按钮操作面板
	static JTabbedPane Pane=new JTabbedPane();  //表信息展示分层面板

	public static void main(String args[]) {
		mainJFrame.setTitle("欢迎登陆!");                 //设置顶层容器的属性
		mainJFrame.setSize(590, 500);
		mainJFrame.setLocationRelativeTo(null);  //出现的位置为屏幕中心
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // 设置关闭动作为退出程序
		Container container = mainJFrame.getContentPane();                         //获取内容面板
		container.setLayout(null);    //设置为绝对布局方式,用坐标值确定位置
		
		//为内容面板添加组件
		name.setFont(new Font("黑体", Font.BOLD, 35));		//添加窗口标题
		name.setForeground(Color.blue);
		name.setBounds(30, 30, 600, 80);
		container.add(name);
		
		user.setBounds(150, 200, 50, 50);		//身份标签
		user.setForeground(Color.CYAN);
		container.add(user);
		cbx.setBounds(200, 210, 100, 30);		//下拉列表框
		container.add(cbx);
		
		lbl2.setBounds(150, 250, 50, 50);		//用户名标签
		lbl2.setForeground(Color.CYAN);
		container.add(lbl2);
		jTextField.setBounds(200,260,200,30);
		container.add(jTextField);
		
		lbl3.setBounds(150,300,50,50);//密码标签
		lbl3.setForeground(Color.CYAN);
		container.add(lbl3);
		jPasswordField.setBounds(200,310,200,30);
		container.add(jPasswordField);
		
		bt_cancel.setBounds(200, 400, 60, 30);  //取消按钮
		container.add(bt_cancel);
		bt_login.setBounds(300, 400, 60, 30);  //登陆按钮
		container.add(bt_login);
				
		ImageIcon image = new ImageIcon("image/666.jpg");  		//添加背景图片
		JLabel lb_image = new JLabel(image);  		
		lb_image.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		container.add(lb_image);
		
		//为按钮和窗口添加事件监听器
		bt_login.addActionListener(mainJFrame);
		bt_cancel.addActionListener(mainJFrame);
		mainJFrame.setVisible(true);
	}  //main函数结束处
	
	public void actionPerformed(ActionEvent e) { // 单击登陆界面的登陆按钮的处理事件
		JButton bt = (JButton) e.getSource();              // 获取被单击的按钮
		if (bt ==bt_cancel) {                                             // 若单击的是清空按钮
			jTextField.setText("");
			jPasswordField.setText("");
		}
		if (bt==bt_login) {													// 若单击登陆按钮执行
			String username=jTextField.getText().trim();     //获取两个文本框的内容
			String pwd=new String(jPasswordField.getPassword()).trim();
			String s= (String) cbx.getSelectedItem();			//获取下拉列表框选中的值
			if(s.equals("学生")) {                                               //学生登陆操作
				if(username.equals("") || pwd.equals("")) { //若文本框有一个为空则弹出对话框提示
					createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60); //显示为空的信息
				}
				else {      //文本框都不为空执行try-catch语句
					try {				
						boolean flag=true;  //由flag判断是否登陆成功
						stu_username = null;  //从数据库中查询出来的账号
						String stu_pwd = null;  //从数据库中查询出来的密码
						Class.forName("com.mysql.cj.jdbc.Driver");  //加载MySQL驱动
						//建立与数据库的连接
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();  //声明Statement来传送SQL statements到数据库
						//定义SQL语句
						String sql = "SELECT username,password FROM zhanghongrui.user where username='"+username+"' and password='"+pwd+"'";
						ResultSet rs = stmt.executeQuery(sql);  //执行SQL语句
						
							while(rs.next()) {						//查询是否有账号和密码,则flag为false
								stu_username = rs.getString("username");  
								stu_pwd = rs.getString("password");
								flag=false;
							}	
							if(!flag) {      //学生账号和密码都正确时进入登陆操作界面
								if(stu_username.equals(username) && stu_pwd.equals(pwd)) {
									Stu_Excute();  //学生登陆成功执行函数
								}  
							}
							if(flag) {            //账号或密码不正确则弹出对话框提示
								createDialog("账号或密码不正确","您输入的账号或密码不正确",20,10, 20, 280, 80); 
							}																
							rs.close();	//关闭相关连接
							stmt.close();
							conn.close();					
					}catch(Exception ee) {
						System.err.println(ee.getMessage());
					}	
				}	
			}
			else if(s.equals("宿舍管理员")) {      //宿舍管理员登陆操作
				if(username.equals("") || pwd.equals("")) {
					createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
				}
				else {      //文本框都不为空执行try-catch语句
					try {				
						boolean flag=true;
						man_username = null;
						String man_pwd = null;
						Class.forName("com.mysql.cj.jdbc.Driver"); 
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String sql = "SELECT username,password FROM zhanghongrui.manager where username='"+username+"' and password='"+pwd+"'";
						ResultSet rs = stmt.executeQuery(sql);
						
							while(rs.next()) {                                            //查询是否有匹配的账号和密码
								man_username = rs.getString("username"); 
								man_pwd = rs.getString("password");
								flag=false;
							}	
							if(!flag) {         //管理员账号或密码正确时进入登陆操作界面
								if(man_username.equals(username)&& man_pwd.equals(pwd)) {
									Man_Excute();      //管理员登陆成功的执行函数
								}  //判断账号或密码是否输入正确的if语句结束处
							}
							if(flag) {            //账号或密码不正确
								createDialog("账号或密码不正确","您输入的账号或密码不正确",20,10, 20, 280, 80); 
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
				createDialog("请选择身份","请选择身份",30,60, 30, 280, 60); 
			}
		}	
	}
	protected static void Stu_Excute(){      //学生登陆成功执行函数
				jTextField.setText("");
				jPasswordField.setText("");
				JDialog dialog=new JDialog(mainJFrame,"登录成功",true);		//创建对话框,对话框有模式
				dialog.setSize(400,300);								//设置对话框的大小
				dialog.setLocationRelativeTo(null);			//设置对话框显示在屏幕中央
				dialog.setResizable(true);								//设置对话框可改变大小
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);	//设置关闭动作
				Container container=dialog.getContentPane();
				tabbedPane1.setPreferredSize(new Dimension(400,300));		//设置分层面板的首选大小
				
				panelA.setSize(400,300);        //学生信息查询面板
				panelA.setLayout(null);          //设置为绝对布局方式，用坐标值确定位置
				
				stu.setFont(new Font("宋体", Font.BOLD, 30));    //页面标签
				stu.setBounds(55, 20, 380, 60);
				panelA.add(stu);
				
				stu1.setBounds(70, 80, 50, 50);                                //学号标签
				panelA.add(stu1);
				stu3.setBounds(110,90,200,30);		
				panelA.add(stu3);
				stu3.setText("");
				
				stu2.setBounds(70,120,50,50);                                 //姓名标签
				panelA.add(stu2);
				stu4.setBounds(110,130,200,30);			
				panelA.add(stu4);
				stu4.setText("");
				
				stu5.setBounds(140, 180, 60, 30);                            //查询按钮
				panelA.add(stu5);
				stu6.setBounds(210, 180, 60, 30);                            //清空按钮
				panelA.add(stu6);
				tabbedPane1.addTab("学生信息查询", panelA);    //将学生信息查询面板加入分层面板
				
				panelB.setSize(400,300);                   //学生登陆密码修改面板
				panelB.setLayout(null);                     //设置为绝对布局方式，用坐标值确定位置
				
				stu_stu.setFont(new Font("宋体", Font.BOLD, 30));  //标签
				stu_stu.setBounds(50, 20, 380, 60);
				panelB.add(stu_stu);
				
				stu_stu1.setBounds(60, 80, 60, 50);        //原密码标签
				panelB.add(stu_stu1);
				stu_stu3.setBounds(120,90,200,30);
				panelB.add(stu_stu3);
				stu_stu3.setText("");
				
				stu_stu2.setBounds(60,120,60,50);       //新密码标签
				panelB.add(stu_stu2);
				stu_stu4.setBounds(120,130,200,30);
				panelB.add(stu_stu4);
				stu_stu4.setText("");
				
				stu_stu5.setBounds(140, 180, 60, 30);    //修改按钮
				panelB.add(stu_stu5);
				stu_stu6.setBounds(210, 180, 60, 30);    //清空按钮
				panelB.add(stu_stu6);
				
				tabbedPane1.addTab("学生登陆密码修改", panelB);       //将修改登陆密码面板加入分层面板
				container.add(tabbedPane1);
				
				stu5.addActionListener(new ActionListener() {    //学生信息查询按钮的响应方法
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	message_inquire(stu3,stu4);      //查询操作
		            }});
				stu6.addActionListener(new ActionListener() {		//清空按钮相应方法
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	stu3.setText("");
						stu4.setText("");
		            }});
				
				stu_stu5.addActionListener(new ActionListener() {  //学生密码修改按钮
		            @Override
		            public void actionPerformed(ActionEvent e) {						
						//获取两个文本框的内容
						String pwd=stu_stu3.getText().trim();                  //获取原密码
						String new_pwd=stu_stu4.getText().trim();        //获取新密码
						
						if(pwd.equals("") || new_pwd.equals("")) {
							createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   //显示为空的信息
						}
						else {      //文本框都不为空执行try-catch语句
							try {				
								String stu_pwd=null;
								boolean flag=true;
								Class.forName("com.mysql.cj.jdbc.Driver");      //首先找原密码
								Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
								Statement stmt = conn.createStatement();
								String sql = "select password from zhanghongrui.user where username= '"+stu_username+"' and password='"+pwd+"'";
								ResultSet rs = stmt.executeQuery(sql);
									
								while(rs.next()) {      //若找得到原密码
										stu_pwd = rs.getString("password");
										flag=false;
									}	
								
									if(!flag) {      //则将找到的原密码修改为新密码
										Class.forName("com.mysql.cj.jdbc.Driver");
										conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
										stmt = conn.createStatement();
										String sql1="update zhanghongrui.user set password='"+new_pwd+"' where username= '"+stu_username+"' and password='"+stu_pwd+"'";
										stmt.executeUpdate(sql1);
										createDialog("密码修改成功","密码修改成功",30,35, 20, 280, 80);
									}
									if(flag) {      //输入的原密码找不到的情况
										createDialog("原密码输入有误","原密码输入有误",30,25, 20, 280, 80);
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
				dialog.setVisible(true); // 显示对话框
	}
	
	public static void Man_Excute() {       //管理员登陆成功执行函数
		JDialog dialog=new JDialog(mainJFrame,"登录成功",true);  //创建管理员操作窗口
		dialog.setSize(700,600);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container=dialog.getContentPane();
		container.setLayout(new BorderLayout());      //将窗口设置为边界布局
		
		p.setSize(700,300);
		p.setBackground(Color.PINK);      //设置放置标签的面板的背景色
		JLabel name=new JLabel("欢迎登陆华广学生宿舍管理系统");
		name.setFont(new Font("黑体", Font.BOLD, 35));
		name.setSize(400,150);
		name.setForeground(Color.BLUE);                //设置标签的字体颜色
		p.add(name);
		container.add(p,BorderLayout.NORTH);
		
		JTabbedPane tabbedPane=new JTabbedPane();
		Component panel=makeMenuPanel();        //生成具有操作按钮的面板函数
		tabbedPane.addTab("操作导航", panel);
		tabbedPane.setPreferredSize(new Dimension(150,400));  //设置tabbedPane大小
		container.add(tabbedPane,BorderLayout.WEST);
		
		Pane.setPreferredSize(new Dimension(400,300));	//展示各个表格信息的分层面板
		
		Component panel1 = createPanel1();      //分别调用方法创建管理员操作页面,一个7个页面,对应7张数据表
		Component panel2 = createPanel2();
		Component panel3 = createPanel3();
		Component panel4 = createPanel4();
		Component panel5 = createPanel5();
		Component panel6 = createPanel6();
		Component panel7 = createPanel7();
		
		Pane.addTab("学生信息", panel1);               //将每个页面加入分层面板
		Pane.addTab("宿舍信息", panel2);
		Pane.addTab("宿舍财产", panel3);
		Pane.addTab("报修情况", panel4);
		Pane.addTab("晚归情况", panel5);
		Pane.addTab("离校情况", panel6);
		Pane.addTab("请假情况", panel7);
		
		container.add(Pane,BorderLayout.CENTER);
		dialog.setVisible(true);
	}
	
	protected static  Component makeMenuPanel() {      //生成操作按钮面板的方法
		JPanel panel=new JPanel(false);
		panel.setLayout(new FlowLayout());
		JLabel lb1 =new JLabel("学生信息");
		lb1.setFont(new Font("宋体", Font.BOLD, 10));
		JButton[] menu=new JButton[7];
		for(int i=0;i<menu.length;i++) {
			menu[i]=new JButton();                                        //创建7个按钮
			menu[i].setMargin(new Insets(10,20,10,20));  //为每个按钮设置大小
		}	
		menu[0].setText("查询学生信息");	                         //为第一个按钮设置文本信息
		menu[0].addActionListener(new ActionListener() {    //为第一个按钮添加事件监听
			public void actionPerformed(ActionEvent e) {
				methodA();
			}
			private void methodA() {        //将每个面板的信息显示出来,其他6个按钮功能类似
				Pane.removeAll();
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("报修情况", panel4);
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("离校情况", panel6);
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[1].setText("查询宿舍信息");
		menu[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodB();
			}
			private void methodB() {
				Pane.removeAll();
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("学生信息", panel1);			
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("报修情况", panel4);
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("离校情况", panel6);
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[2].setText("查询宿舍财产");
		menu[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodC();
			}
			private void methodC() {
				Pane.removeAll();
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("报修情况", panel4);
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("离校情况", panel6);
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[3].setText("查询报修情况");
		menu[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodD();
			}
			private void methodD() {
				Pane.removeAll();
				Pane.addTab("报修情况", panel4);
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("宿舍财产", panel3);				
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("离校情况", panel6);
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[4].setText("查询晚归情况");
		menu[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodE();
			}
			private void methodE() {
				Pane.removeAll();
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("报修情况", panel4);				
				Pane.addTab("离校情况", panel6);
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[5].setText("查询离校情况");
		menu[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodF();
			}
			private void methodF() {
				Pane.removeAll();
				Pane.addTab("离校情况", panel6);
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("报修情况", panel4);
				Pane.addTab("晚归情况", panel5);				
				Pane.addTab("请假情况", panel7);
			}
		});
		menu[6].setText("查询请假情况");
		menu[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methodF();
			}
			private void methodF() {
				Pane.removeAll();
				Pane.addTab("请假情况", panel7);
				Pane.addTab("学生信息", panel1);
				Pane.addTab("宿舍信息", panel2);
				Pane.addTab("宿舍财产", panel3);
				Pane.addTab("报修情况", panel4);
				Pane.addTab("晚归情况", panel5);
				Pane.addTab("离校情况", panel6);			
			}
		});
		for(int i=0;i<menu.length;i++) {
			panel.add(menu[i]);
		}
		return panel;
	}
	//创建提示对话框的方法
	protected static void createDialog(String title,String name,int size,int x,int y,int width,int height) {  //前3个参数依次是对话框标题,标签名,字体大小,后4个参数为标签的位置
		JDialog dialog1=new JDialog(mainJFrame,title,true);  //创建有模式的对话框
		dialog1.setSize(300,200);														//设置对话框的大小
		dialog1.setLocationRelativeTo(null);									//设置对话框在中心显示
		dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container1=dialog1.getContentPane();
		container1.setLayout(null);//设置为绝对布局方式，用坐标值确定位置	
		JLabel p= new JLabel(name);		//标题
		p.setFont(new Font("黑体", Font.BOLD, size));
		
		if(title.indexOf("成功") != -1)           //若传入的标题有“成功”两个字则标签字体颜色为蓝色
			p.setForeground(Color.blue);
		else 													    //否则,标签字体颜色为红色
			p.setForeground(Color.red);
		
		p.setBounds(x, y, width, height);	//设置标题的大小和位置
		container1.add(p);
		dialog1.setVisible(true);
	}
	protected static void message_inquire(JTextField n1,JTextField n2 ) {  //学生信息查询方法,传入两个文本框用于获取对应的值
		JDialog dialog=new JDialog(mainJFrame,"学生信息查询",true);
		dialog.setSize(410,150);
		dialog.setLocationRelativeTo(null);
		dialog.setResizable(true);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		Container container=dialog.getContentPane();
		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
		
		String num=n1.getText().trim();      //获取两个文本框的内容
		String name_stu=n2.getText().trim();
		if(num.equals("") || name_stu.equals("")) {
			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
		}
		else {      //文本框都不为空执行try-catch语句
			try {				
				boolean flag=true;
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
				Statement stmt = conn.createStatement();
				String request = "SELECT Sno,student.name,class,dorm_num,beg_num from zhanghongrui.student,zhanghongrui.dorm where Sno='"+num+"' and student.name='"+name_stu+"'and student.name=dorm.name";
				ResultSet rs = stmt.executeQuery(request);
				
					while(rs.next()) {        //从数据库中将学号,姓名,班级,宿舍号,床号查询出来
						Sno = rs.getString("Sno");
						stu_name = rs.getString("name");
						course = rs.getString("class");
						dormnum = rs.getString("dorm_num");
						begnum = rs.getString("beg_num");
						//定义表头
						String[] colname = {"学号","姓名","班级","宿舍号","床位号"};
						String[][] tablevalues = {{Sno,stu_name,course,dormnum,begnum}};
						//创建表格模型
						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
						JTable table = new JTable(tablemodel);  //创建表格
						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
						container.add(scrollpane);
						dialog.setVisible(true);       // 显示对话框
						flag=false;
					}	
					if(flag) {
						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
					}																
					rs.close();	
					stmt.close();
					conn.close();					
			}catch(Exception ee) {
				System.err.println(ee.getMessage());
			}	
		}	
	}
	
	protected static Component createPanel1() {  //创建学生信息操作页面
		panel1.setLayout(null);  //设置为绝对布局方式，用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();  //创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"学号","姓名","班级"});  //创建表头
		try {				//查询学生信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.student";
			ResultSet rs = stmt.executeQuery(request);//执行查询语句
			
			while(rs.next()) {		//将学号,姓名,班级查询出来
					String Sno = rs.getString("Sno");
					String stu_name = rs.getString("name");
					String course = rs.getString("class");
					//将查询出来的数据一行一行地添加进表格中
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});					
			}		
				rs.close();	
				stmt.close();
				conn.close();					
		}catch(Exception ee) {
			System.err.println(ee.getMessage());
			ee.printStackTrace();
		}	
		final JTable table = new JTable(zhang_tablemodel);  //创建表格
		JScrollPane scrollpane = new JScrollPane(table);		//将表格设置成滚动面板
		scrollpane.setBounds(60,20,400,200);
		panel1.add(scrollpane);                             //显示学生信息表
		
		stu1.setBounds(100, 240, 50, 50);           //学号标签
		panel1.add(stu1);
		stu3.setBounds(140,250,200,30);		
		panel1.add(stu3);
		
		stu2.setBounds(100,270,50,50);               //姓名标签
		panel1.add(stu2);
		stu4.setBounds(140,280,200,30);			
		panel1.add(stu4);
		
		stu7.setBounds(100,300,50,50);               //班级标签
		panel1.add(stu7);
		stu8.setBounds(140,310,200,30);			
		panel1.add(stu8);
		
		insert.setBounds(50, 380, 60, 30);           //插入按钮
		panel1.add(insert);
		
		mod.setBounds(130, 380, 60, 30);           //修改按钮
		panel1.add(mod);
		
		del.setBounds(210, 380, 60, 30);              //删除按钮
		panel1.add(del);
		
		inquire.setBounds(290, 380, 60, 30);       //查询按钮
		panel1.add(inquire);
		
		stu6.setBounds(370, 380, 60, 30);            //清空按钮
		panel1.add(stu6);
		
		
		insert.addActionListener(new ActionListener() {  //插入按钮的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = stu3.getText();  //分别获取3个文本框的值
				String text2 = stu4.getText();
				String text3 = stu8.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.student";
						ResultSet rs = stmt.executeQuery(request);  //将学生信息表的信息查询出来
						
						while(rs.next()) {		//查询是否已有学号
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  				//已有学号弹出对话框
							createDialog("学号输入错误","您输入的学号已存在",25,20, 20, 280, 80);
						}
						if(!flag) {  				//若无相同学号则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into student values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		del.addActionListener(new ActionListener() {		//删除按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = stu3.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select Sno from zhanghongrui.student";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有学号
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //无学号则弹出对话框
							createDialog("学号输入错误","您输入的学号不存在",25,20, 20, 280, 80);
						}
						if(!flag) {        //若有学号则删除数据
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  //若未选中行
								createDialog("未选中行","请选中与学号相同的行",20,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {			//当输入的学号与选中行的学号一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.student where Sno='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与学号相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		mod.addActionListener(new ActionListener() {  //修改按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = stu3.getText();
				String text2 = stu4.getText();
				String text3 = stu8.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();  //修改时先选中待修改的行,获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();		//获取表格对象
							if(selectedRow!= -1) { 		//是否存在选中行,若未中行则相应的行索引为-1
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//将选中行的第一列即学号获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //根据行数获取每行的第一个单元格的值
										if(s.equals(text1)) {  //再将每行第一个单元格的值与输入的学号比较是否相同（学号不能相同）
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的学号不相同则修改数据,即同一个表格中不能存在相同的学号
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.student SET Sno='"+text1+"',name='"+text2+"',class='"+text3+"' where Sno='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("学号已经存在","学号已经存在",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		inquire.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=stu3.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT Sno,student.name,class from zhanghongrui.student where Sno='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将学号,姓名,班级查询出来
        						Sno = rs.getString("Sno");
        						stu_name = rs.getString("name");
        						course = rs.getString("class");
        						//定义表头
        						String[] colname = {"学号","姓名","班级"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
	protected static Component createPanel2() {		//创建宿舍信息表操作页面
		panel2.setLayout(null);		//设置为绝对布局方式，用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"宿舍号","宿舍电话","宿舍楼层"});//创建表头
		try {				//查询学生信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.dorm_message";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		  //将宿舍号,宿舍电话,宿舍所在楼层查询出来
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("dorm_tel");
					String course = rs.getString("dorm_floor");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel2.add(scrollpane);        				//显示宿舍信息表
		
		zhr1.setBounds(100, 240, 80, 50);		//宿舍号标签
		panel2.add(zhr1);
		zhr4.setBounds(160,250,200,30);		
		panel2.add(zhr4);
		
		zhr2.setBounds(100,270,80,50);			//宿舍电话标签
		panel2.add(zhr2);
		zhr5.setBounds(160,280,200,30);			
		panel2.add(zhr5);
		
		zhr3.setBounds(100,300,80,50);  		//宿舍所在楼层标签
		panel2.add(zhr3);
		zhr6.setBounds(160,310,200,30);			
		panel2.add(zhr6);
		
		zhr7.setBounds(80, 380, 60, 30);        //插入按钮
		panel2.add(zhr7);
		
		zhr8.setBounds(160, 380, 60, 30);		//修改按钮
		panel2.add(zhr8);
			
		zhr11.setBounds(240, 380, 60, 30);       //查询按钮
		panel2.add(zhr11);
		
		zhr9.setBounds(320, 380, 60, 30);		//删除按钮
		panel2.add(zhr9);
		
		zhr10.setBounds(400, 380, 60, 30);	//清空按钮
		panel2.add(zhr10);
		
		
		zhr7.addActionListener(new ActionListener() {	//插入学生宿舍信息按钮的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = zhr4.getText();
				String text2 = zhr5.getText();
				String text3 = zhr6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.dorm_message";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否已有宿舍号
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //已有宿舍号弹出对话框
							createDialog("宿舍号输入错误","您输入的宿舍号已存在",25,15, 20, 280, 80);
						}
						if(!flag) {  //若无相同宿舍号则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into dorm_message values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		zhr8.addActionListener(new ActionListener() { //修改学生宿舍信息按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = zhr4.getText();
				String text2 = zhr5.getText();
				String text3 = zhr6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();	//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { 		//是否存在选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//将选中行的宿舍号获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //根据行数获取每行的第一个单元格的值
										if(s.equals(text1)) {  //再将每行第一个单元格的值与输入的宿舍号是否相同（宿舍号不能相同）
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的宿舍号不相同则修改数据
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.dorm_message SET dorm_num='"+text1+"',dorm_tel='"+text2+"',dorm_floor='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
											stmt.close();
											conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("宿舍号已存在","宿舍号已存在",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		zhr9.addActionListener(new ActionListener() {	//删除学生宿舍信息按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = zhr4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num from zhanghongrui.dorm_message";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有宿舍号
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //无宿舍号则弹出对话框
							createDialog("宿舍号输入错误","您输入的宿舍号不存在",25,15, 20, 280, 80);
						}
						if(!flag) {        //若有宿舍号则删除数据
							int row = table.getSelectedRow();		//获取选择的行号
							if(row==-1) {  		//若未选中行
								createDialog("未选中行","请选中与宿舍号相同的行",20,25, 20, 280, 80);
							}
							else {						//若选中行执行
								int selectedRow = table.getSelectedRow();	//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.dorm_message where dorm_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与宿舍号相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		zhr10.addActionListener(new ActionListener() {		//清空文本框内容的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {
            	zhr4.setText("");
            	zhr5.setText("");
            	zhr6.setText("");
            }});
		zhr11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=zhr4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT dorm_num,dorm_tel,dorm_floor from zhanghongrui.dorm_message where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将宿舍号,宿舍电话,宿舍所在楼层查询出来
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("dorm_tel");
        						course = rs.getString("dorm_floor");
        						//定义表头
        						String[] colname = {"宿舍号","宿舍电话","宿舍所在楼层"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
	protected static Component createPanel3() {	//创建宿舍财产数据表的操作页面
		panel3.setLayout(null);		//设置为绝对布局方式,用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"物品编号","物品名","物品价格"});//创建表头
		try {				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.property";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//查询宿舍财产信息并显示出来
					String Sno = rs.getString("goods_num");
					String stu_name = rs.getString("goods_name");
					float course = rs.getFloat("goods_price");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel3.add(scrollpane);        					//显示宿舍财产信息表
		
		hong1.setBounds(100, 240, 80, 50);		//物品编号
		panel3.add(hong1);
		hong4.setBounds(160,250,200,30);		
		panel3.add(hong4);
		
		hong2.setBounds(100,270,80,50);			//物品名
		panel3.add(hong2);
		hong5.setBounds(160,280,200,30);			
		panel3.add(hong5);
		
		hong3.setBounds(100,300,80,50);  		//物品价格
		panel3.add(hong3);
		hong6.setBounds(160,310,200,30);			
		panel3.add(hong6);
		
		hong7.setBounds(80, 380, 60, 30);        //插入按钮
		panel3.add(hong7);
		
		hong8.setBounds(160, 380, 60, 30);		//修改按钮
		panel3.add(hong8);
		
		hong11.setBounds(240, 380, 60, 30);       //查询按钮
		panel3.add(hong11);
		
		hong9.setBounds(320, 380, 60, 30);		//删除按钮
		panel3.add(hong9);
		
		hong10.setBounds(400, 380, 60, 30);	//清空按钮
		panel3.add(hong10);
		
		
		hong7.addActionListener(new ActionListener() {		//插入宿舍财产信息的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = hong4.getText();
				String text2 = hong5.getText();
				String text3 = hong6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.property";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否已有物品号
								zhr1 = rs.getString("goods_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //已有物品号弹出对话框
							createDialog("物品号输入错误","您输入的物品号已存在",25,10, 20, 280, 80);
						}
						if(!flag) {  //若无相同物品号则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.property values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		hong8.addActionListener(new ActionListener() { 		//修改宿舍财产信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = hong4.getText();
				String text2 = hong5.getText();
				String text3 = hong6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();	//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) {	 //是否存在选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//将选中行的物品号获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //根据行数获取每行的第一个单元格的值
										if(s.equals(text1)) {  //再将每行第一个单元格的值与输入的物品号是否相同（物品号不能相同）
											flag=true;
											break;
										}
									}
									if(!flag) {  //若物品号不相同则修改
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.property SET goods_num='"+text1+"',goods_name='"+text2+"',goods_price='"+text3+"' where goods_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("物品号已存在","物品号已存在",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		hong9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = hong4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   //显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select goods_num from zhanghongrui.property";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有物品号
								zhr1 = rs.getString("goods_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //无物品号则弹出对话框
							createDialog("物品号输入错误","您输入的物品号不存在",25,10, 20, 280, 80);
						}
						if(!flag) {        //若有物品号则删除数据
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  		//若未选中行
								createDialog("未选中行","请选中与物品号相同的行",22,12, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.property where goods_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与物品号相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		hong10.addActionListener(new ActionListener() {	//清空文本框
            @Override
            public void actionPerformed(ActionEvent e) {
            	hong4.setText("");
            	hong5.setText("");
            	hong6.setText("");
            }});
		hong11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=hong4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.property where goods_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将"物品编号","物品名","物品价格"查询出来
        						Sno = rs.getString("goods_num");
        						stu_name = rs.getString("goods_name");
        						course = rs.getString("goods_price");
        						//定义表头
        						String[] colname = {"物品编号","物品名","物品价格"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
		panel4.setLayout(null);//设置为绝对布局方式，用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"宿舍号","报修人姓名","报修物品名"});//创建表头
		try {				//查询报修信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.maintain";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//查询宿舍号,报修人姓名,报修物品名
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
					String course = rs.getString("goods_name");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel4.add(scrollpane);        //显示报修信息表
		
		rui1.setBounds(100, 240, 80, 50);		//宿舍号
		panel4.add(rui1);
		rui4.setBounds(180,250,200,30);		
		panel4.add(rui4);
		
		rui2.setBounds(100,270,80,50);		//报修人姓名
		panel4.add(rui2);
		rui5.setBounds(180,280,200,30);			
		panel4.add(rui5);
		
		rui3.setBounds(100,300,80,50);  	//报修物品名
		panel4.add(rui3);
		rui6.setBounds(180,310,200,30);			
		panel4.add(rui6);
		
		rui7.setBounds(80, 380, 60, 30);     	 //插入按钮
		panel4.add(rui7);
		
		rui8.setBounds(160, 380, 60, 30);		//修改按钮
		panel4.add(rui8);
		
		rui11.setBounds(240, 380, 60, 30);       //查询按钮
		panel4.add(rui11);
		
		rui9.setBounds(320, 380, 60, 30);		//删除按钮
		panel4.add(rui9);
		
		rui10.setBounds(400, 380, 60, 30);		//清空按钮
		panel4.add(rui10);
		
		
		rui7.addActionListener(new ActionListener() {	//插入报修信息的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = rui4.getText();
				String text2 = rui5.getText();
				String text3 = rui6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.maintain";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否已有宿舍号
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //已有宿舍号弹出对话框
							createDialog("宿舍号输入错误","您输入的宿舍号已存在",25,10, 20, 280, 80);
						}
						if(!flag) {  //若无相宿舍号则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.maintain values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		rui8.addActionListener(new ActionListener() { //修改报修信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = rui4.getText();
				String text2 = rui5.getText();
				String text3 = rui6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //是否存在选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);	//将选中行的宿舍号获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //根据行数获取每行的第一个单元格的值
										if(s.equals(text1)) {  //再将每行第一个单元格的值与输入的宿舍号是否相同（宿舍号不能相同）
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的宿舍号不相同
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.maintain SET dorm_num='"+text1+"',name='"+text2+"',goods_name='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("宿舍号已存在","宿舍号已存在",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		rui9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = rui4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num from zhanghongrui.maintain";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有宿舍号
								zhr1 = rs.getString("dorm_num");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //无宿舍号则弹出对话框
							createDialog("宿舍号输入错误","您输入的宿舍号不存在",25,10, 20, 280, 80);
						}
						if(!flag) {        //若有宿舍号则删除数据
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  //若未选中行
								createDialog("未选中行","请选中与宿舍号相同的行",20,25, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.maintain where dorm_num='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与宿舍号相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		rui11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=rui4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.maintain where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将"宿舍号","报修人姓名","报修物品名"查询出来
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("name");
        						course = rs.getString("goods_name");
        						//定义表头
        						String[] colname = {"宿舍号","报修人姓名","报修物品名"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
		panel5.setLayout(null);//设置为绝对布局方式，用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"宿舍号","姓名","晚归时间"});//创建表头
		try {				//查询学生晚归信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.late";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//查询宿舍号,姓名,晚归时间
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
					String course = rs.getString("late_time");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel5.add(scrollpane);        //显示晚归信息表
		
		wang1.setBounds(100, 240, 80, 50);	//宿舍号
		panel5.add(wang1);
		wang4.setBounds(160,250,200,30);		
		panel5.add(wang4);
		
		wang2.setBounds(100,270,80,50);		//姓名
		panel5.add(wang2);
		wang5.setBounds(160,280,200,30);			
		panel5.add(wang5);
		
		wang3.setBounds(100,300,80,50);  	//晚归时间
		panel5.add(wang3);
		wang6.setBounds(160,310,200,30);			
		panel5.add(wang6);
		
		wang7.setBounds(80, 380, 60, 30);      //插入按钮
		panel5.add(wang7);
		
		wang8.setBounds(160, 380, 60, 30);		//修改按钮
		panel5.add(wang8);
		
		wang11.setBounds(240, 380, 60, 30);       //查询按钮
		panel5.add(wang11);
		
		wang9.setBounds(320, 380, 60, 30);		//删除按钮
		panel5.add(wang9);
		
		wang10.setBounds(400, 380, 60, 30);	//清空按钮
		panel5.add(wang10);
		
		
		wang7.addActionListener(new ActionListener() {	//插入学生晚归信息的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String zhr2=null;
				String text1 = wang4.getText();
				String text2 = wang5.getText();
				String text3 = wang6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.late";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//宿舍号和姓名不能相同
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = true;
								}
						}		
						if(flag) {  //已有宿舍号和姓名弹出对话框
							createDialog("宿舍号或姓名输入错误","您输入的宿舍号和姓名已存在",20,5, 20, 280, 80);
						}
						if(!flag) {  //否则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.late values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		wang8.addActionListener(new ActionListener() { //修改学生晚归信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = wang4.getText();
				String text2 = wang5.getText();
				String text3 = wang6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//将选中行的宿舍号和姓名获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //获取每行的宿舍号
										String s1=(String) model.getValueAt(i, 1);  //获取每行的姓名
										if(s.equals(text1) && s1.equals(text2)) {  //宿舍号和姓名不能都相同
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的宿舍号和姓名不相同
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.late SET dorm_num='"+text1+"',name='"+text2+"',late_time='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("信息输入有误","宿舍号与姓名相同",25,30, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
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
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num,name from zhanghongrui.late";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有宿舍号和姓名
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = false;
								}
						}		
						if(flag) {        //无宿舍号或姓名则弹出对话框
							createDialog("输入错误","宿舍号或姓名不存在",25,20, 20, 280, 80);
						}
						if(!flag) {        
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  //若未选中行
								createDialog("未选中行","请选中与宿舍号相同的行",20,25, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								String value1 = (String) table.getModel().getValueAt(selectedRow, 1);
								if(value.equals(text1) && value1.equals(text2)) {//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.late where dorm_num='"+text1+"' and name='"+text2+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与宿舍号和姓名相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		wang11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=wang4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				final DefaultTableModel zhang_tablemodel = new DefaultTableModel();  //创建表格模型
        				zhang_tablemodel.setColumnIdentifiers(new Object[] {"宿舍号","姓名","晚归时间"});  //创建表头
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.late where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将"宿舍号","姓名","晚归时间"查询出来
        						String Sno1 = rs.getString("dorm_num");
        						String stu_name1 = rs.getString("name");
//        						course = rs.getString("late_time");
        						Time course = rs.getTime("late_time");
        						//定义表头
//        						String[] colname = {"宿舍号","姓名","晚归时间"};
//        						String[][] tablevalues = {{Sno,stu_name,course}};
        						zhang_tablemodel.addRow(new Object[] {Sno1,stu_name1,course});	
        						//创建表格模型
//        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(zhang_tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
		panel6.setLayout(null);//设置为绝对布局方式,用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"宿舍号","姓名","离校时间"});//创建表头
		try {				//查询学生信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.leave";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//查询宿舍号,姓名,离校时间
					String Sno = rs.getString("dorm_num");
					String stu_name = rs.getString("name");
//					String course = rs.getString("leave_time");
					Date course = rs.getDate("leave_time");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel6.add(scrollpane);        //显示离校信息表
		
		mei1.setBounds(100, 240, 80, 50);		//宿舍号
		panel6.add(mei1);
		mei4.setBounds(160,250,200,30);		
		panel6.add(mei4);
		
		mei2.setBounds(100,270,80,50);		//姓名
		panel6.add(mei2);
		mei5.setBounds(160,280,200,30);			
		panel6.add(mei5);
		
		mei3.setBounds(100,300,80,50);  		//离校时间
		panel6.add(mei3);
		mei6.setBounds(160,310,200,30);			
		panel6.add(mei6);
		
		mei7.setBounds(80, 380, 60, 30);     	 //插入按钮
		panel6.add(mei7);
		
		mei8.setBounds(160, 380, 60, 30);		  //修改按钮
		panel6.add(mei8);
		
		mei11.setBounds(240, 380, 60, 30);       //查询按钮
		panel6.add(mei11);
		
		mei9.setBounds(320, 380, 60, 30);		  //删除按钮
		panel6.add(mei9);
		
		mei10.setBounds(400, 380, 60, 30);	  //清空按钮
		panel6.add(mei10);
		
		mei7.addActionListener(new ActionListener() {		//插入学生离校信息的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String zhr2=null;
				String text1 = mei4.getText();
				String text2 = mei5.getText();
				String text3 = mei6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   				
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.leave";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = true;
								}
						}		
						if(flag) {  //已有宿舍号和姓名弹出对话框
							createDialog("输入错误","您输入的宿舍号和姓名已存在",20,6, 20, 280, 80);
						}
						if(!flag) {  //否则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into zhanghongrui.leave values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		mei8.addActionListener(new ActionListener() {  //修改学生离校信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {						
            	String text1 = mei4.getText();
				String text2 = mei5.getText();
				String text3 = mei6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//将选中行的宿舍号和姓名或取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //获取每行的宿舍号
										String s1=(String) model.getValueAt(i, 1);  //获取每行的姓名
										if(s.equals(text1) && s1.equals(text2)) {  //宿舍号和姓名不能都相同
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的宿舍号和姓名都不相同
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.leave SET dorm_num='"+text1+"',name='"+text2+"',leave_time='"+text3+"' where dorm_num='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("信息输入有误","宿舍号与姓名相同",25,30, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		mei9.addActionListener(new ActionListener() {		//删除学生离校信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = mei4.getText();
            	String text2 = mei5.getText();
				String zhr1=null;
				String zhr2=null;
            	if(text1.equals("") || text2.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select dorm_num,name from zhanghongrui.leave";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有宿舍号和姓名
								zhr1 = rs.getString("dorm_num");
								zhr2 = rs.getString("name");
								if(zhr1.equals(text1) && zhr2.equals(text2)) {
									flag = false;
								}
						}		
						if(flag) {        //无宿舍号和姓名则弹出对话框
							createDialog("输入错误","您输入的宿舍号或姓名不存在",20,6, 20, 280, 80);
						}
						if(!flag) {        //否则删除数据
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  //若未选中行
								createDialog("未选中行","请选中相应的行",30,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();	//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								String value1 = (String) table.getModel().getValueAt(selectedRow, 1);
								if(value.equals(text1) && value1.equals(text2)) {		//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.leave where dorm_num='"+text1+"' and name='"+text2+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与宿舍号和姓名相同的行","请选中相应的行",30,30, 20, 280, 80);
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
		mei11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=mei4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.leave where dorm_num='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将"宿舍号","姓名","离校时间"查询出来
        						Sno = rs.getString("dorm_num");
        						stu_name = rs.getString("name");
        						course = rs.getString("leave_time");
        						//定义表头
        						String[] colname = {"宿舍号","姓名","离校时间"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
		panel7.setLayout(null);		//设置为绝对布局方式，用坐标值确定位置
		final DefaultTableModel zhang_tablemodel = new DefaultTableModel();//创建表格模型
		zhang_tablemodel.setColumnIdentifiers(new Object[] {"学号","姓名","宿舍号"});//创建表头
		try {				//查询学生请假信息并显示出来
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
			Statement stmt = conn.createStatement();
			String request = "select * from zhanghongrui.off";
			ResultSet rs = stmt.executeQuery(request);
			
			while(rs.next()) {		//查询学号,姓名,宿舍号
					String Sno = rs.getString("Sno");
					String stu_name = rs.getString("name");
					String course = rs.getString("dorm_num");
					zhang_tablemodel.addRow(new Object[] {Sno,stu_name,course});//添加数据					
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
		panel7.add(scrollpane);        //显示学生请假信息表
		
		ting1.setBounds(100, 240, 80, 50);		//学号
		panel7.add(ting1);
		ting4.setBounds(150,250,200,30);		
		panel7.add(ting4);
		
		ting2.setBounds(100,270,80,50);		//姓名
		panel7.add(ting2);
		ting5.setBounds(150,280,200,30);			
		panel7.add(ting5);
		
		ting3.setBounds(100,300,80,50);  		//宿舍号
		panel7.add(ting3);
		ting6.setBounds(150,310,200,30);			
		panel7.add(ting6);
		
		ting7.setBounds(80, 380, 60, 30);      //插入按钮
		panel7.add(ting7);
		
		ting8.setBounds(160, 380, 60, 30);		//查询按钮
		panel7.add(ting8);
		
		ting11.setBounds(240, 380, 60, 30);       //查询按钮
		panel7.add(ting11);
		
		ting9.setBounds(320, 380, 60, 30);		//修改按钮
		panel7.add(ting9);
		
		ting10.setBounds(400, 380, 60, 30);	//清空按钮
		panel7.add(ting10);
		
		ting7.addActionListener(new ActionListener() {	//插入学生请假信息的响应方法
			public void actionPerformed(ActionEvent e) {
				String zhr1=null;
				String text1 = ting4.getText();
				String text2 = ting5.getText();
				String text3 = ting6.getText();
				if(text1.equals("") || text2.equals("")  || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   		//显示为空的信息
				}
				else {
					try {			
						boolean flag = false;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select * from zhanghongrui.off";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否已有学号
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = true;
								}
						}		
						if(flag) {  //已有学号弹出对话框
							createDialog("学号输入错误","您输入的学号已存在",25,20, 20, 280, 80);
						}
						if(!flag) {  //若无相同学号则插入数据
							int id=0;
							zhang_tablemodel.addRow(new Object[] {text1,text2,text3});      //添加数据
							Class.forName("com.mysql.cj.jdbc.Driver");
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
							stmt = conn.createStatement();
							String sql="insert into off values('"+id+"','"+text1+"','"+text2+"','"+text3+"')";
							stmt.executeUpdate(sql);
							createDialog("信息插入成功","信息插入成功",30,35, 20, 280, 80);
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
		ting8.addActionListener(new ActionListener() {  //修改学生离校信息的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {		
            	String text1 = ting4.getText();
				String text2 = ting5.getText();
				String text3 = ting6.getText();
			 	if(text1.equals("") || text2.equals("") || text3.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   				//显示为空的信息
				}
				else {
					int selectedRow = table.getSelectedRow();//获得选中行的索引
					DefaultTableModel model = (DefaultTableModel) table.getModel();
							if(selectedRow!= -1) { //是否存在选中行
								boolean flag=false;
								String value = (String) table.getModel().getValueAt(selectedRow, 0);//将选中行的学号获取出来
									for(int i=0;i<model.getRowCount();i++) {  //获取表格的行数
										String s=(String) model.getValueAt(i, 0);  //根据行数获取每行的第一个单元格的值
										if(s.equals(text1)) {  //再将每行第一个单元格的值与输入的学号是否相同（学号不能相同）
											flag=true;
											break;
										}
									}
									if(!flag) {  //每行第一个单元格的值与输入的学号不相同
										model.setValueAt(text1, selectedRow, 0);
										model.setValueAt(text2, selectedRow, 1);
										model.setValueAt(text3, selectedRow, 2);
										try {			
											Class.forName("com.mysql.cj.jdbc.Driver");     
											Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
											Statement stmt = conn.createStatement();
											String sql = "UPDATE zhanghongrui.off SET Sno='"+text1+"',name='"+text2+"',dorm_num='"+text3+"' where Sno='"+value+"'";
											stmt.executeUpdate(sql);
											createDialog("信息修改成功","信息修改成功",30,35, 20, 280, 80);
												stmt.close();
												conn.close();			
									}catch(Exception ee) {
										System.err.println(ee.getMessage());
									}	
								}else {
									createDialog("学号已存在","学号已经存在",30,35, 20, 280, 80);
								}
							}
							else
								createDialog("未选中行","请选中待修改的行",30,10, 20, 280, 80);
				}
            }});
		ting9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String text1 = ting4.getText();
				String zhr1=null;
            	if(text1.equals("")) {
					createDialog("输入信息错误","文本框有空",30,55, 30, 280, 60);   	//显示为空的信息
				}
				else {
					try {			
						boolean flag = true;
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
						Statement stmt = conn.createStatement();
						String request = "select Sno from zhanghongrui.off";
						ResultSet rs = stmt.executeQuery(request);
						
						while(rs.next()) {		//查询是否有学号
								zhr1 = rs.getString("Sno");
								if(zhr1.equals(text1)) {
									flag = false;
								}
						}		
						if(flag) {        //无学号则弹出对话框
							createDialog("学号输入错误","您输入的学号不存在",25,20, 20, 280, 80);
						}
						if(!flag) {        //若有学号则删除数据
							int row = table.getSelectedRow();//获取选择的行号
							if(row==-1) {  //若未选中行
								createDialog("未选中行","请选中与学号相同的行",20,30, 20, 280, 80);
							}
							else {
								int selectedRow = table.getSelectedRow();//获得选中行的索引
								String value = (String) table.getModel().getValueAt(selectedRow, 0);
								if(value.equals(text1)) {		//当数据一致时删除
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.removeRow(row);
									Class.forName("com.mysql.cj.jdbc.Driver");
									conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
									stmt = conn.createStatement();
									String sql="delete from zhanghongrui.off where Sno='"+text1+"'";
									stmt.executeUpdate(sql);
									createDialog("信息删除成功","信息删除成功",30,35, 20, 280, 80);
								}
								else
									createDialog("未选中与学号相同的行","请选中与学号相同的行",20,30, 20, 280, 80);
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
		ting11.addActionListener(new ActionListener() {       //查询按钮的响应方法
            @Override
            public void actionPerformed(ActionEvent e) {	
            	JDialog dialog=new JDialog(mainJFrame,"信息查询",true);
        		dialog.setSize(410,150);
        		dialog.setLocationRelativeTo(null);
        		dialog.setResizable(true);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		Container container=dialog.getContentPane();
        		container.setLayout(null);                 //设置为绝对布局方式，用坐标值确定位置
        		
        		String num=ting4.getText().trim();      //获取两个文本框的内容
        		if(num.equals("")) {
        			createDialog("输入信息错误","文本框有空",30,50, 30, 280, 60);  	//显示为空的信息
        		}
        		else {      //文本框都不为空执行try-catch语句
        			try {				
        				boolean flag=true;
        				Class.forName("com.mysql.cj.jdbc.Driver");
        				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhanghongrui?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","root");
        				Statement stmt = conn.createStatement();
        				String request = "SELECT * from zhanghongrui.off where Sno='"+num+"'";
        				ResultSet rs = stmt.executeQuery(request);
        					while(rs.next()) {        //从数据库中将"学号","姓名","宿舍号"查询出来
        						Sno = rs.getString("Sno");
        						stu_name = rs.getString("name");
        						course = rs.getString("dorm_num");
        						//定义表头
        						String[] colname = {"学号","姓名","宿舍号"};
        						String[][] tablevalues = {{Sno,stu_name,course}};
        						//创建表格模型
        						final DefaultTableModel tablemodel = new DefaultTableModel(tablevalues,colname);
        						JTable table = new JTable(tablemodel);  //创建表格
        						JScrollPane scrollpane = new JScrollPane(table);  //将表格加入滚动面板
        						scrollpane.setBounds(10, 25, 380, 60);  //设置滚动面板的位置
        						container.add(scrollpane);
        						dialog.setVisible(true);       // 显示对话框
        						flag=false;
        					}	
        					if(flag) {
        						createDialog("找不到信息","您查找的信息不存在",25,20, 20, 280, 80);  
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
