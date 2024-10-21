package PacknaPack;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Rup extends JFrame implements ActionListener{
	private JPanel Frame;
	private JTextField Username;
	final String url = "jdbc:mysql://localhost:3306/fproject";
	final String username = "root";
	final String password = "";
	Connection conn = null;
	String db = "com.mysql.cj.jdbc.Driver";
	JPasswordField Password;
	DataBase a = new DataBase();
	public Rup(){
		setTitle("UI Classroom");
		setBounds(375, 170, 600, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
		JLabel Email = new JLabel();
		Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		JLabel JPassword = new JLabel();
		JPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		setContentPane(Frame);
		Email.setBounds(159,117, 148, 23);
		Email.setText("Email");
		Email.setForeground(Color.white);
		JPassword.setBounds(127, 165, 147, 20);
		JPassword.setText("Password");
		JPassword.setForeground(Color.white);
		Frame.add(JPassword);
		Frame.add(Email);
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(229,121, 148, 20);
		Username.setFont(new Font("Tahoma", Font.BOLD, 10));
		Username.setForeground(Color.white);
		Username.setOpaque(false);
		Username.setBorder(bord);
		Username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Username.getText().toString().equals("") || Password.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
						if(Username.getText().toString().contains(".ui@phinmaed.com")){
					try {
						
						Class.forName(db);
						conn=DriverManager.getConnection(url,username,password);
						Statement stat  = conn.createStatement();
						String insert = ("UPDATE student SET Username='"+Username.getText().toString()+"',Password='"+Password.getText().toString()+"' WHERE Username='username'");
						ResultSet rst = stat.executeQuery("SELECT Username FROM student");
						
						
						stat.executeUpdate(insert);
						JOptionPane.showMessageDialog(null,"Register Successfully","Register", 1);
						dispose();
						new SLLogin();
						conn.close();
						
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"Invalid Credentials","Warning", 1);
					}
					}
						else JOptionPane.showMessageDialog(null,"phinma account invalid","Warning", 1);
					}
					}
					
				}
			});
		Frame.add(Username);
		Password = new JPasswordField();
		Password.setEchoChar('*');
		Password.setFont(new Font("Tahoma", Font.BOLD, 10));
		Password.setForeground(Color.white);
		Password.setOpaque(false);
		Password.setBorder(bord);
		Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Username.getText().toString().equals("") || Password.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
						if(Username.getText().toString().contains(".ui@phinmaed.com")){
					try {
						
						Class.forName(db);
						conn=DriverManager.getConnection(url,username,password);
						Statement stat  = conn.createStatement();
						String insert = ("UPDATE student SET Username='"+Username.getText().toString()+"',Password='"+Password.getText().toString()+"' WHERE Username='username'");
						ResultSet rst = stat.executeQuery("SELECT Username FROM student");
						
						
						stat.executeUpdate(insert);
						JOptionPane.showMessageDialog(null,"Register Successfully","Register", 1);
						dispose();
						new SLLogin();
						conn.close();
						
						
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,"Invalid Credentials","Warning", 1);
					}
					}
						else JOptionPane.showMessageDialog(null,"phinma account invalid","Warning", 1);
					}
					}
					
				}
			});
		Password.setColumns(10);
		Password.setBounds(230, 165, 147, 20);
		Frame.add(Password);
		
		JButton reg = new JButton("Register");
		reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Username.getText().toString().equals("") || Password.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
				}
				else {
					if(Username.getText().toString().contains(".ui@phinmaed.com")){
				try {
					
					Class.forName(db);
					conn=DriverManager.getConnection(url,username,password);
					Statement stat  = conn.createStatement();
					String insert = ("UPDATE student SET Username='"+Username.getText().toString()+"',Password='"+Password.getText().toString()+"' WHERE Username='username'");
					ResultSet rst = stat.executeQuery("SELECT Username FROM student");
					
					
					stat.executeUpdate(insert);
					JOptionPane.showMessageDialog(null,"Register Successfully","Register", 1);
					dispose();
					new SLLogin();
					conn.close();
					
					
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Invalid Credentials","Warning", 1);
				}
				}
					else JOptionPane.showMessageDialog(null,"phinma account invalid","Warning", 1);
				}
				
			
			}
		});
		reg.setFont(new Font("Tahoma", Font.BOLD, 15));
		reg.setBounds(250, 212, 113,30);
		Frame.add(reg);
		
		JLabel Step1 = new JLabel("Step 2");
		Step1.setFont(new Font("Tahoma", Font.BOLD, 18));
		Step1.setForeground(new Color(255, 255, 255));
		Step1.setBounds(269, 68, 81, 30);
		Frame.add(Step1);
		JButton Back = new JButton("Reset");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SRegister();
				a.DDSRegister();
			}
		});
		Back.setBounds(510, 11, 74, 23);
		Frame.add(Back);
		JLabel Background = new JLabel("Background");
		Background.setIcon(new ImageIcon("C:\\\\Users\\\\Natalie Jenh Alarcon\\\\Desktop\\\\received_288983967383600.jpeg"));
		Background.setBounds(-35, 0, 619, 415);
		Frame.add(Background);
		Frame.setLayout(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
