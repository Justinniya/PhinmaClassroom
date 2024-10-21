package PacknaPack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.filechooser.*;
import java.awt.image.BufferedImage;
import javax.swing.JList;

public class SDashboard extends JFrame implements ActionListener {
	Connection conn = null;

	public SDashboard() {
		dashboard();
	}

	Random rand = new Random();
	String a[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	int arr = a.length;
	int randoms = rand.nextInt(arr);
	String ran = a[randoms];
	private JPanel Frame, Activities;
	private JTextField MONDAYATT, TUESDAYATT, WEDNESDAYATT, FRIDAYATT, THURSDAYATTT;
	private JTextField DBA, DSA, OA;
	JTabbedPane Tab, Activity;
	Border bord = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white);
	DataBase aa = new DataBase();

	public void dashboard() {
		setVisible(true);
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600, 400);
		Frame = new JPanel();
		setContentPane(Frame);
		Frame.setLayout(null);
		JButton Logout = new JButton("Log Out");
		Logout.setBounds(5, 332, 82, 21);
		Logout.setBackground(Color.CYAN);
		Frame.add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Loginas();
			}
		});
		
		Tab = new JTabbedPane(JTabbedPane.LEFT);
		Tab.setBackground(Color.CYAN);
		Tab.setOpaque(false);
		Tab.setBounds(10, 10, 566, 343);
		Tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		Frame.add(Tab);
		JPanel Attendance = new JPanel();
		Attendance.setBackground(new Color(0, 100, 0));
		Tab.addTab("Attendance", null, Attendance, null);
		Attendance.setOpaque(true);
		Attendance.setLayout(null);
		JTabbedPane AT = new JTabbedPane(JTabbedPane.TOP);
		AT.setBackground(Color.GREEN);
		AT.setOpaque(false);
		AT.setBounds(36, 64, 413, 211);
		Attendance.add(AT);
		MONDAYATT = new JTextField();
		MONDAYATT.setColumns(10);
		MONDAYATT.setOpaque(false);
		MONDAYATT.setBorder(bord);
		MONDAYATT.setBounds(73, 57, 252, 26);
		JPanel Monday = new JPanel();
		Monday.setBackground(new Color(153, 50, 204));
		Monday.setOpaque(true);
		AT.addTab("Monday", null, Monday, null);
		JButton Submit1 = new JButton("Submit");
		Submit1.setOpaque(false);
		Submit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mondays = MONDAYATT.getText().toString();
				aa.MondayAA(mondays);
			}
		});
		Submit1.setBounds(157, 112, 85, 21);
		Monday.add(Submit1);

		JLabel M = new JLabel("Enter code for attendance");
		M.setFont(new Font("Tahoma", Font.BOLD, 18));
		M.setBounds(80, 10, 264, 37);
		Monday.add(M);
		Monday.add(MONDAYATT);
		Submit1.setBounds(154, 106, 85, 21);

		Monday.setLayout(null);

		JPanel Tuesday = new JPanel();
		Tuesday.setBackground(new Color(153, 50, 204));
		AT.addTab("Tuesday", null, Tuesday, null);
		JButton Submit2 = new JButton("Submit");
		Submit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tuesday = TUESDAYATT.getText().toString();
				aa.TuesdayAA(tuesday);
			}
		});
		Submit2.setBounds(157, 112, 85, 21);
		Tuesday.add(Submit2);

		JLabel TT = new JLabel("Enter code for attendance");
		TT.setFont(new Font("Tahoma", Font.BOLD, 18));
		TT.setBounds(80, 10, 264, 37);
		Tuesday.add(TT);

		TUESDAYATT = new JTextField();
		TUESDAYATT.setColumns(10);
		TUESDAYATT.setOpaque(false);
		TUESDAYATT.setBorder(bord);
		TUESDAYATT.setBounds(73, 57, 252, 26);
		Tuesday.add(TUESDAYATT);
		Submit2.setBounds(154, 106, 85, 21);
		Tuesday.setLayout(null);

		JPanel Wednesday = new JPanel();
		Wednesday.setBackground(new Color(153, 50, 204));
		AT.addTab("Wednesday", null, Wednesday, null);
		JButton Submit3 = new JButton("Submit");
		Submit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String wednesday = WEDNESDAYATT.getText().toString();
				aa.WednesdayAA(wednesday);
			}
		});
		Submit3.setBounds(154, 106, 85, 21);
		Wednesday.add(Submit3);

		JLabel W = new JLabel("Enter code for attendance");
		W.setFont(new Font("Tahoma", Font.BOLD, 18));
		W.setBounds(80, 10, 264, 37);
		Wednesday.add(W);

		WEDNESDAYATT = new JTextField();
		WEDNESDAYATT.setColumns(10);
		WEDNESDAYATT.setOpaque(false);
		WEDNESDAYATT.setBorder(bord);
		WEDNESDAYATT.setBounds(73, 57, 252, 26);
		Wednesday.add(WEDNESDAYATT);
		Wednesday.setBounds(157, 112, 85, 21);
		Wednesday.setLayout(null);

		JPanel Thursday = new JPanel();
		Thursday.setBackground(new Color(153, 50, 204));
		AT.addTab("Thursday", null, Thursday, null);
		JButton Submit4 = new JButton("Submit");
		Submit4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String thursday = THURSDAYATTT.getText().toString();
				aa.ThursdayAA(thursday);
			}
		});
		Submit4.setBounds(154, 106, 85, 21);
		Thursday.add(Submit4);

		JLabel T = new JLabel("Enter code for attendance");
		T.setFont(new Font("Tahoma", Font.BOLD, 18));
		T.setBounds(80, 10, 264, 37);
		Thursday.add(T);

		THURSDAYATTT = new JTextField();
		THURSDAYATTT.setColumns(10);
		THURSDAYATTT.setOpaque(false);
		THURSDAYATTT.setBorder(bord);
		THURSDAYATTT.setBounds(73, 57, 252, 26);
		Thursday.add(THURSDAYATTT);
		Submit4.setBounds(154, 106, 85, 21);
		Thursday.setLayout(null);

		JPanel Friday = new JPanel();
		Friday.setBackground(new Color(153, 50, 204));
		AT.addTab("Friday", null, Friday, null);
		FRIDAYATT = new JTextField();
		FRIDAYATT.setBounds(73, 57, 252, 26);
		FRIDAYATT.setOpaque(false);
		FRIDAYATT.setBorder(bord);
		Friday.add(FRIDAYATT);
		FRIDAYATT.setColumns(10);
		JLabel FRIDAYT = new JLabel("Enter code for attendance");
		FRIDAYT.setFont(new Font("Tahoma", Font.BOLD, 18));
		FRIDAYT.setBounds(80, 10, 264, 37);
		Friday.add(FRIDAYT);

		JButton Submit5 = new JButton("Submit");
		Submit5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String friday = FRIDAYATT.getText().toString();
				aa.FridayAA(friday);
			}
		});
		Submit5.setBounds(154, 106, 85, 21);
		Friday.add(Submit5);
		Friday.setLayout(null);

		Activities = new JPanel();
		Activities.setBackground(new Color(0, 100, 0));
		Tab.addTab("Activities", null, Activities, null);
		Activities.setLayout(null);

		Activity = new JTabbedPane(JTabbedPane.TOP);
		Activity.setBackground(Color.GREEN);
		Activity.setBounds(49, 54, 403, 235);
		Activities.add(Activity);
		DataBase();
		DS();
		OOP();
	}

	public void DataBase() {
		JPanel DataBase = new JPanel();
		DataBase.setBackground(new Color(153, 50, 204));
		Activity.addTab("DataBase", null, DataBase, null);
		DataBase.setLayout(null);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
			Statement stat = conn.createStatement();
			String aa = "SELECT * FROM Activities WHERE Subject = 'DATABASE'";
			final ResultSet result = stat.executeQuery(aa);
			if (result.next()) {
				String DBquiz = result.getString("Act");
				JLabel DataBaseT = new JLabel(DBquiz);
				DataBaseT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
				DataBaseT.setForeground(Color.WHITE);
				DataBaseT.setBounds(91, 10, 237, 53);
				DataBase.add(DataBaseT);

				DBA = new JTextField();
				DBA.setBounds(101, 74, 214, 34);
				DataBase.add(DBA);
				DBA.setOpaque(false);
				DBA.setBorder(bord);
				DBA.setColumns(10);

				JButton ADB = new JButton("Answer");
				ADB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String a;
						try {
							a = result.getString("Answer");
							if (a.equals(DBA.getText().toString())) {
								JOptionPane.showMessageDialog(null, "Correct Answer", "Succes", 1);
							} else {
								JOptionPane.showMessageDialog(null, "Wrong Answer", "Error", 1);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				ADB.setBounds(168, 120, 85, 21);
				DataBase.add(ADB);
			}
		} catch (Exception e) {
		}
	}

	public void DS() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
			Statement stat = conn.createStatement();
			String aa = "SELECT * FROM Activities WHERE Subject = 'DATA STRUCTURE'";
			final ResultSet result = stat.executeQuery(aa);
			if (result.next()) {
				JPanel DataStructure = new JPanel();
				DataStructure.setBackground(new Color(153, 50, 204));
				Activity.addTab("Data Structure", null, DataStructure, null);
				DataStructure.setLayout(null);
				String DSquiz = result.getString("Act");
				JLabel DataStructureT = new JLabel(DSquiz);
				DataStructureT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
				DataStructureT.setForeground(Color.WHITE);
				DataStructureT.setBounds(91, 10, 237, 53);
				DataStructure.add(DataStructureT);

				DSA = new JTextField();
				DSA.setBounds(101, 74, 214, 34);
				DSA.setOpaque(false);
				DSA.setBorder(bord);
				DataStructure.add(DSA);
				DSA.setColumns(10);

				JButton ADS = new JButton("Answer");
				ADS.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String a;
						try {
							a = result.getString("Answer");
							if (a.equals(DSA.getText().toString())) {
								JOptionPane.showMessageDialog(null, "Correct Answer", "Succes", 1);
							} else {
								JOptionPane.showMessageDialog(null, "Wrong Answer", "Error", 1);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				ADS.setBounds(168, 120, 85, 21);
				DataStructure.add(ADS);
			}
		} catch (Exception e) {
		}
	}

	public void OOP() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
			Statement stat = conn.createStatement();
			String aa = "SELECT * FROM Activities WHERE Subject = 'OOP'";
			final ResultSet result = stat.executeQuery(aa);

			if (result.next()) {

				JPanel OOP = new JPanel();
				OOP.setBackground(new Color(153, 50, 204));
				Activity.addTab("OOP", null, OOP, null);
				OOP.setLayout(null);
				String OOPquiz = result.getString("Act");
				JLabel OOPT = new JLabel(OOPquiz);
				OOPT.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
				OOPT.setForeground(Color.WHITE);
				OOPT.setBounds(91, 10, 237, 53);
				OOP.add(OOPT);

				OA = new JTextField();
				OA.setBounds(101, 74, 214, 34);
				OA.setOpaque(false);
				OA.setBorder(bord);
				OOP.add(OA);
				OA.setColumns(10);

				JButton AOOP = new JButton("Answer");
				AOOP.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String a;
						try {
							a = result.getString("Answer");
							if (a.equals(OA.getText().toString())) {
								JOptionPane.showMessageDialog(null, "Correct Answer", "Succes", 1);
							} else {
								JOptionPane.showMessageDialog(null, "Wrong Answer", "Error", 1);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				AOOP.setBounds(168, 120, 85, 21);
				OOP.add(AOOP);
			}
		} catch (Exception e) {
		}
	}

	

	public void ProfileSet(String fn, String ln, String mn, String bd, String add, String gender, String id,
			String years, String section, String email) {
		JPanel Profile = new JPanel();
		Profile.setBackground(new Color(0, 100, 0));
		Profile.setOpaque(true);
		Tab.addTab("Profile", null, Profile, null);
		Profile.setLayout(null);
		final JLabel profile = new JLabel();
		profile.setBounds(191, 0, 100, 100);
		Profile.add(profile);
		JLabel l1 = new JLabel("_________________");
		JLabel l2 = new JLabel("_________________");
		JLabel l3 = new JLabel("_________________");
		JLabel l4 = new JLabel("_________________");
		JLabel l5 = new JLabel("_________________");
		JLabel l6 = new JLabel("_________________");
		JLabel l7 = new JLabel("_________________");
		JLabel l5_1 = new JLabel("_________________");
		JLabel l5_2 = new JLabel("_________________");
		JLabel l5_3 = new JLabel("_________________");
		l1.setBounds(90, 107, 179, 30);
		l2.setBounds(100, 148, 179, 30);
		l3.setBounds(90, 189, 179, 30);
		l4.setBounds(90, 233, 179, 30);
		l5.setBounds(331, 148, 179, 30);
		l6.setBounds(331, 189, 179, 30);
		l7.setBounds(331, 233, 179, 30);
		l5_1.setBounds(82, 285, 168, 30);
		l5_2.setBounds(310, 290, 179, 30);
		l5_3.setBounds(345, 107, 179, 30);
		Profile.add(l1);
		Profile.add(l2);
		Profile.add(l3);
		Profile.add(l4);
		Profile.add(l5);
		Profile.add(l6);
		Profile.add(l7);
		Profile.add(l5_1);
		Profile.add(l5_3);
		Profile.add(l5_2);
		try {
			JButton select = new JButton("Select image");
			select.setBounds(373, 40, 110, 21);
			Profile.add(select);
			select.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFileChooser file = new JFileChooser();
					FileNameExtensionFilter a = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
					file.setFileFilter(a);

					int returnVal = file.showOpenDialog(null);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						try {
							File selected = file.getSelectedFile();
							BufferedImage bilogna = ImageIO.read(selected);
							int dia = Math.min(bilogna.getWidth(), bilogna.getHeight());
							BufferedImage bilognagdya = new BufferedImage(dia, dia, BufferedImage.TYPE_INT_ARGB);
							Graphics2D d2 = bilognagdya.createGraphics();
							d2.setClip(new Ellipse2D.Float(0, 0, dia, dia));
							d2.drawImage(bilogna, 0, 0, dia, dia, null);
							d2.dispose();

							ImageIcon icon = new ImageIcon(bilognagdya);
							profile.setIcon(icon);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			JLabel Pfn = new JLabel("First name : " + fn);
			Pfn.setForeground(Color.WHITE);
			Pfn.setBounds(31, 100, 179, 30);
			Profile.add(Pfn);

			JLabel Pmn = new JLabel("Middle name : " + mn);
			Pmn.setBounds(31, 143, 179, 30);
			Pmn.setForeground(Color.WHITE);
			Profile.add(Pmn);

			JLabel Pln = new JLabel("Last name :" + ln);
			Pln.setBounds(31, 187, 179, 30);
			Pln.setForeground(Color.WHITE);
			Profile.add(Pln);

			JLabel Pstud = new JLabel("Student Id : " + id);
			Pstud.setBounds(31, 233, 179, 30);
			Pstud.setForeground(Color.WHITE);
			Profile.add(Pstud);

			JLabel Padd = new JLabel("Address : " + add);
			Padd.setBounds(31, 282, 179, 30);
			Padd.setForeground(Color.WHITE);
			Profile.add(Padd);

			JLabel Pbd = new JLabel("BirthDate : " + bd);
			Pbd.setBounds(286, 100, 179, 30); 
			Pbd.setForeground(Color.WHITE);
			Profile.add(Pbd);

			JLabel Pgender = new JLabel("Gender : " + gender);
			Pgender.setBounds(286, 143, 179, 30);
			Pgender.setForeground(Color.WHITE);
			Profile.add(Pgender);

			JLabel Pyear = new JLabel("Year : "  + years);
			Pyear.setBounds(286, 187, 179, 30);
			Pyear.setForeground(Color.WHITE);
			Profile.add(Pyear);

			JLabel Psec = new JLabel("Section : " + section);
			Psec.setBounds(286, 233, 179, 30);
			Psec.setForeground(Color.WHITE);
			Profile.add(Psec);

			JLabel Puser = new JLabel("Email : " + email);
			Puser.setBounds(286, 282, 179, 30);
			Puser.setForeground(Color.WHITE);
			Profile.add(Puser);

			
			
			} catch (Exception e) {
		}

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM anouncement WHERE Section = 'BSIT 2-2'");

			while(result.next()) {
				String ann = result.getString("Post");
		JOptionPane.showMessageDialog(null, ann, "Announcement", 1);
	}
		}catch (Exception ee1) {
			System.out.println(ee1.toString());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
