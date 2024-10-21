package PacknaPack;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ForgetPassword extends JFrame implements ActionListener{

	private JPanel Frame;
	private JTextField OldPass;
	private JTextField NewPass;
	private JTextField ConfirmPass;
	private JTextField Code;
	String Email,codes;
	JButton Submit;
	String oldPass,code,newPass;
	DataBase aa = new DataBase();
	public ForgetPassword() {
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(375, 170, 600, 400);
		Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
		
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		JLabel Forget = new JLabel("Reset Password");
		Forget.setForeground(Color.WHITE);
		Forget.setBackground(Color.WHITE);
		Forget.setFont(new Font("Tahoma", Font.BOLD, 15));
		Forget.setBounds(223, 49, 128, 30);
		Frame.add(Forget);
		
		Submit = new JButton("Submit");
		Submit.setEnabled(false);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPass = NewPass.getText().toString();
				code = Code.getText().toString();
				//oldPass = OldPass.getText().toString();
				String conPass = ConfirmPass.getText().toString();
				String ee = Email;
				if(codes.equals(code)) {
				if(conPass.equals(newPass)) {
				aa.ForgetPassword(newPass, code,ee);
				}else {
					JOptionPane.showMessageDialog(null, "Re-enter your new Password", "Invalid", 2);
				}
				}
			else {
				JOptionPane.showMessageDialog(null, "Invalid code", "Invalid", 2);
			}
			}
		});
		Submit.setBounds(239, 233, 89, 23);
		
		Frame.add(Submit);
		
		
		NewPass = new JTextField();
		NewPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		NewPass.setOpaque(false);
		NewPass.setBounds(233, 90, 218, 20);
		Frame.add(NewPass);
		NewPass.setColumns(10);
		NewPass.setBorder(bord);
		
		ConfirmPass = new JTextField();
		ConfirmPass.setFont(new Font("Tahoma", Font.BOLD, 13));
		ConfirmPass.setOpaque(false);
		ConfirmPass.setBounds(233, 135, 218, 20);
		Frame.add(ConfirmPass);
		ConfirmPass.setColumns(10);
		ConfirmPass.setBorder(bord);
		
		
		JLabel NewP = new JLabel("New Password :");
		NewP.setForeground(Color.WHITE);
		NewP.setBackground(Color.WHITE);
		NewP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		NewP.setBounds(117, 95, 106, 14);
		Frame.add(NewP);
		
		JLabel CNewP = new JLabel("Confirm Password :");;
		CNewP.setForeground(Color.WHITE);
		CNewP.setBackground(Color.WHITE);
		CNewP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		CNewP.setBounds(91, 140, 132, 14);
		Frame.add(CNewP);
		
		JButton SendOtp = new JButton("Send OTP");
		SendOtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codes = "47234";
				 JOptionPane.showMessageDialog(null,"Your OTP Code is : "+codes,"OTP Code", 1);
				 aa.Codes(codes);
				 Submit.setEnabled(true);
				 new SLLogin();
			}
		});
		SendOtp.setBounds(126, 180, 97, 23);
		Frame.add(SendOtp);
		
		Code = new JTextField();
		Code.setFont(new Font("Tahoma", Font.BOLD, 13));
		Code.setBounds(365, 181, 86, 20);
		Code.setBorder(bord);
		Code.setOpaque(false);
		Frame.add(Code);
		Code.setColumns(10);
		
		JLabel Ecode = new JLabel("Enter code :");
		Ecode.setForeground(Color.WHITE);
		Ecode.setBounds(293, 182, 73, 19);
		Frame.add(Ecode);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SLLogin();
			}
		});
		Back.setBounds(510, 11, 64, 23);
		Frame.add(Back);
		
	JLabel Background = new JLabel("Background");
	Background.setIcon(new ImageIcon("C:\\Users\\Justin De La Vega\\Pictures\\Saved Pictures\\received_288983967383600.jpeg"));
	Background.setBounds(-35, 0, 619, 415);
	Frame.add(Background);
	
	Email = JOptionPane.showInputDialog("Enter you Email");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
