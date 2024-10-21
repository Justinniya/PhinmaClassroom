package PacknaPack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Loginas extends JFrame implements ActionListener{

	private JPanel Frame;
	public Loginas() {
		setTitle("UI Classroom");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600, 400);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		Border bord = BorderFactory.createLineBorder(Color.lightGray, 2);
		Frame.setBackground(new Color(0,128,0));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		JLabel Loginas = new JLabel("Login As");
		Loginas.setForeground(Color.WHITE);
		Loginas.setFont(new Font("Tahoma", Font.BOLD, 20));
		Loginas.setBounds(234, 41, 132, 70);
		Frame.add(Loginas);
		
		JButton TeacherC = new JButton("Teacher");
		TeacherC.setFont(new Font("Tahoma", Font.BOLD, 16));
		TeacherC.setBorder(bord);
		TeacherC.setBackground(new Color(153, 50, 204));
		TeacherC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Tlogin();
			}
		});
		TeacherC.setForeground(Color.BLACK);
		TeacherC.setBounds(217, 113, 122, 41);
		Frame.add(TeacherC);
		
		JButton StudentC = new JButton("Student");
		StudentC.setFont(new Font("Tahoma", Font.BOLD, 16));
		StudentC.setBorder(bord);
		StudentC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SLLogin();
			}
		});
		StudentC.setBackground(new Color(153, 50, 204));
		StudentC.setBounds(217, 185, 122, 41);
		Frame.add(StudentC);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
