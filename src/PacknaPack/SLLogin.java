package PacknaPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SLLogin extends JFrame implements ActionListener{
	
	private JPanel Frame;
	private JTextField userField;
	private JPasswordField Password;
	DataBase a = new DataBase();
	public SLLogin() {
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600, 400);
		Frame = new JPanel();
		setVisible(true);
		setResizable(true/**false**/);
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
		Border bord1 = BorderFactory.createMatteBorder(0,0,0,0,Color.white);

		setContentPane(Frame);
		Frame.setLayout(null);
		
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.BOLD, 10));
		userField.setForeground(Color.white);
		userField.setBounds(221, 122, 189, 20);
		userField.setOpaque(false);
		userField.setBorder(bord);
		Frame.add(userField);
		userField.setColumns(10);
		
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
					String user = userField.getText().toString();
					String pass = Password.getText().toString();
					a.DSLLogin(user, pass);
				}
			}
		});
		Password.setBounds(221, 172, 189, 20);
		Frame.add(Password);
		
		JLabel Vuser = new JLabel("Email :");
		Vuser.setForeground(new Color(255, 255, 255));
		Vuser.setFont(new Font("Tahoma", Font.BOLD, 11));
		Vuser.setBounds(173, 125, 64, 14);
		Frame.add(Vuser);
		
		JLabel Vpass = new JLabel("Password  :");
		Vpass.setForeground(Color.WHITE);
		Vpass.setFont(new Font("Tahoma", Font.BOLD, 11));
		Vpass.setBounds(147, 175, 64, 14);
		Frame.add(Vpass);
		
		JButton LoginB = new JButton("Login");
		LoginB.setFont(new Font("Tahoma", Font.BOLD, 11));
		LoginB.setBackground(new Color(148, 0, 211));
		LoginB.setForeground(new Color(255, 255, 0));
		LoginB.setBounds(267, 200, 89, 23);
		LoginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userField.getText().toString();
				String pass = Password.getText().toString();
				a.DSLLogin(user, pass);
			}
		});
		Frame.add(LoginB);
		
		JLabel CAMS = new JLabel("Classroom Monitoring System");
		CAMS.setForeground(Color.WHITE);
		CAMS.setFont(new Font("Tahoma", Font.BOLD, 15));
		CAMS.setBounds(173, 57, 386, 41);
		Frame.add(CAMS);
		JLabel ha = new JLabel();
		ha.setText("Don't have an account yet?");
		ha.setForeground(Color.white);
		ha.setBounds(247,243,189,23);
		Frame.add(ha);
		JButton Register = new JButton("SIGN UP");
		Register.setOpaque(false);
		Register.setBorder(bord1);
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SRegister();
			}
		});
		Register.setForeground(new Color(255, 255, 0));
		Register.setFont(new Font("Tahoma", Font.BOLD, 11));
		Register.setBackground(new Color(75, 0, 130));
		Register.setBounds(395, 243, 89, 23);
		Frame.add(Register);
		JButton Back = new JButton("Back");
		Back.setOpaque(false);
		Back.setFont(new Font("Tahoma", Font.BOLD, 11));
		Back.setBorder(bord1);
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Loginas();
			}
		});
		Back.setBounds(510, 11, 64, 23);
		Frame.add(Back);
		
		final JCheckBox SP = new JCheckBox("Show");
		SP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		SP.setForeground(Color.WHITE);
		SP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SP.isSelected()) {
					Password.setEchoChar((char)0);
				}
				else {
					Password.setEchoChar('*');
				}
			}
				
		});
		SP.setOpaque(false);
		SP.setBounds(416, 171, 68, 21);
		Frame.add(SP);
		
		JButton Forgot = new JButton("Forget Password?");
		Forgot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ForgetPassword();
				dispose();
			}
		});
		Forgot.setBounds(10, 327, 145, 23);
		Frame.add(Forgot);
		
		
		
		
		
		JLabel Background = new JLabel("Background");
		Background.setIcon(new ImageIcon("C:\\Users\\Natalie Jenh Alarcon\\Desktop\\received_288983967383600.jpeg"));
		//Background.setIcon(new ImageIcon("C:\\Users\\Justin De La Vega\\Pictures\\Saved Pictures\\received_288983967383600.jpeg"));
		Background.setBounds(-35, 0, 619, 415);
		Frame.add(Background);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

