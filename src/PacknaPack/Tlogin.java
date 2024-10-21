package PacknaPack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class Tlogin extends JFrame implements ActionListener{
	private JPanel Frame;
	private JTextField userField;
	private JPasswordField passwordField;
	DataBase a = new DataBase();
	public Tlogin() {
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600, 400);
		Frame = new JPanel();
		setVisible(true);
		setResizable(true/**false**/);
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
		setContentPane(Frame);
		Frame.setLayout(null);
		userField = new JTextField();
		userField.setFont(new Font("Tahoma", Font.BOLD, 10));
		userField.setBounds(221, 122, 189, 20);
		userField.setForeground(Color.white);
		userField.setOpaque(false);
		userField.setBorder(bord);
		Frame.add(userField);
		userField.setColumns(10);
		JLabel CAMS = new JLabel("Classroom Monitoring System");
		CAMS.setForeground(Color.WHITE);
		CAMS.setFont(new Font("Tahoma", Font.BOLD, 15));
		CAMS.setBounds(173, 57, 386, 41);
		Frame.add(CAMS);
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setForeground(Color.white);
		passwordField.setOpaque(false);
		passwordField.setBorder(bord);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					String user = userField.getText().toString();
					String pass = passwordField.getText().toString();
					a.DTlogin(user, pass);
					dispose();
				}
			}
		});
		passwordField.setBounds(221, 172, 189, 20);
		Frame.add(passwordField);
		JLabel Vuser = new JLabel("Username :");
		Vuser.setForeground(new Color(255, 255, 255));
		Vuser.setFont(new Font("Tahoma", Font.BOLD, 11));
		Vuser.setBounds(147, 125, 64, 14);
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
		LoginB.setBounds(267, 215, 89, 23);
		LoginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userField.getText().toString();
				String pass = passwordField.getText().toString();
				a.DTlogin(user, pass);
				dispose();
			}
		});
		Frame.add(LoginB);
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Loginas();
			}
		});
		Back.setBounds(510, 11, 64, 23);
		Frame.add(Back);
		
		JCheckBox SP = new JCheckBox("");
		SP.setOpaque(false);
		SP.setBounds(416, 172, 21, 21);
		Frame.add(SP);
		JLabel Background = new JLabel("Background");
		Background.setIcon(new ImageIcon("C:\\Users\\Natalie Jenh Alarcon\\Desktop\\received_288983967383600.jpeg"));
		Background.setBounds(-35, 0, 619, 415);
		Frame.add(Background);
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
