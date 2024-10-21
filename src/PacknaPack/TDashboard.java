package PacknaPack;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
public class TDashboard extends JFrame implements ActionListener{

	private JPanel Frame;
	String Fn, UI, Age, Year, Section, Present, Ln, Mn, Loc;
	DefaultTableModel tbl, tbl1, tbl2, grade1, grade2, grade3, Monday;
	Random rand = new Random();
	String code[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	int arr = code.length;
	int randems = rand.nextInt(arr);
	String randem1 = code[randems];
	String randem2= code[randems];
	String randem3= code[randems];
	String randem4 = code[randems];
	String randem5 = code[randems];
	JTabbedPane SProfile, Grades;
	DataBase aa = new DataBase();
	private JTextField Activity;
	private JComboBox SectionAct,YearAct,Subject,Acti;
	JTabbedPane Dashboard;
	private JTextField textField;
	private JTextField Sabat;
	JComboBox YearAct_1,SectionAct_1;
	Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);

	public TDashboard() {
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600,400);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		Frame.setLayout(null);
		Frame.setBackground(new Color(0,128,0));
		isaP();
		apat();
		Delete();
	}

	public void isaP() {

		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM student WHERE Section = 'BSIT 2-2'");
			// ResultSet result1 = stat.executeQuery("SELECT * FROM student WHERE Section =
			// 'BSIT 2-2'");
			tbl = new DefaultTableModel();
			tbl.addColumn("UI ID");
			tbl.addColumn("Full Name");
			tbl.addColumn("BirthDate");
			tbl.addColumn("Year");
			tbl.addColumn("Section");
			tbl.addColumn("Address");

			while (result.next()) {
				Fn = result.getString("Ln") + " , " + result.getString("Fn") + " " + result.getString("Mn");
				Age = result.getString("Bdate");
				Loc = result.getString("Loc");
				Section = result.getString("Section");
				Year = result.getString("Year");
				UI = result.getString("UI_ID");

				String[] row = { UI, Fn, Age, Year, Section, Loc };
				tbl.addRow(row);
			}
			conn.close();
		}

		catch (Exception e1) {
			System.out.println(e1.toString());
		}
	}

	public void apat() {
		JButton Search = new JButton("Search");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton Drop = new JButton("Drop");
		Drop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = "";
				id = JOptionPane.showInputDialog("Enter UI - ID");
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
					Statement stat = conn.createStatement();
					ResultSet result = stat.executeQuery("SELECT ln FROM student WHERE ln = '"+id+"'");
					if(result.next()) {
						stat.executeUpdate("DELETE FROM student WHERE ln = '"+id+"'");
						JOptionPane.showMessageDialog(null, "Drop success", "Succes", 1);
						
					}else {
					JOptionPane.showMessageDialog(null, "No "+id+" founded", "Invalid", 1);
					}
						
						
						
				
				
			}catch(Exception ee) {}
			}
		});
		Drop.setBounds(10, 193, 89, 23);
		Frame.add(Drop);
		Search.setBounds(10, 159, 89, 23);
		Frame.add(Search);

		JButton Logout = new JButton("Log Out");
		Logout.setBackground(new Color(153, 50, 204));
		Logout.setBounds(20, 313, 82, 21);
		Frame.add(Logout);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Loginas();
			}
		});
		Dashboard = new JTabbedPane(JTabbedPane.LEFT);
		Dashboard.setPreferredSize(new Dimension(10, 10));
		Dashboard.setBackground(new Color(153, 50, 204));
		Dashboard.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		Dashboard.setBounds(20, 10, 554, 351);
		Frame.add(Dashboard);

		SProfile = new JTabbedPane(JTabbedPane.TOP);
		SProfile.setBackground(new Color(153, 50, 204));
		Dashboard.addTab("Student Profile", null, SProfile, null);
		SProfile.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		JTable ttbl = new JTable(tbl);
		ttbl.setSurrendersFocusOnKeystroke(true);
		ttbl.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JScrollPane BSIT_2_1 = new JScrollPane();
		ttbl.getColumnModel().getColumn(0).setResizable(false);
		ttbl.getColumnModel().getColumn(1).setPreferredWidth(165);
		BSIT_2_1.setViewportView(ttbl);
		SProfile.addTab("BSIT 2-2", null, BSIT_2_1, null);

		JTabbedPane Attendance = new JTabbedPane(JTabbedPane.TOP);
		Attendance.setBackground(new Color(153, 50, 204));
		Dashboard.addTab("Attendance", null, Attendance, null);

		final JPanel AB1 = new JPanel();
		AB1.setBackground(new Color(0,128,0));
		Attendance.addTab("BSIT_2_2", null, AB1, null);

		JButton ARC = new JButton("Monday");
		ARC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.MondayA(randem1);
				JOptionPane.showMessageDialog(null, "Your code for Monday si " + randem1, "Submitted", 1);
			}
		});
		AB1.setLayout(null);
		ARC.setBounds(25, 11, 182, 50);
		AB1.add(ARC);

		JButton ARC_1 = new JButton("Tuesday");
		ARC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.TuesdayA(randem2);
				JOptionPane.showMessageDialog(null, "Your code for Tuesday si " + randem2, "Submitted", 1);
			}
		});
		ARC_1.setBounds(226, 71, 182, 50);
		AB1.add(ARC_1);

		JButton ARC_2 = new JButton("Wednesday");
		ARC_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.WednesdayA(randem3);
				JOptionPane.showMessageDialog(null, "Your code for Wednesday si " + randem3, "Submitted", 1);
			}
		});
		ARC_2.setBounds(25, 128, 182, 50);
		AB1.add(ARC_2);

		JButton ARC_3 = new JButton("Thursday");
		ARC_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.ThursdayA(randem4);
				JOptionPane.showMessageDialog(null, "Your code for Thursday si " + randem4, "Submitted", 1);
			}
		});
		ARC_3.setBounds(226, 187, 182, 43);
		AB1.add(ARC_3);

		JButton ARC_4 = new JButton("Friday");
		ARC_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aa.FridayA(randem5);
				JOptionPane.showMessageDialog(null, "Your code for Friday si " + randem5, "Submitted", 1);
			}
		});
		ARC_4.setBounds(25, 243, 182, 50);
		AB1.add(ARC_4);

		JPanel Activities = new JPanel();
		Activities.setBackground(new Color(0, 121, 51));
		Dashboard.addTab("Activities", null, Activities, null);
		Activities.setLayout(null);

		Activity = new JTextField();
		Activity.setBorder(bord);
		Activity.setOpaque(false);
		Activity.setBounds(52, 88, 346, 45);
		Activities.add(Activity);
		Activity.setColumns(10);

		SectionAct = new JComboBox();
		SectionAct.setModel(new DefaultComboBoxModel(new String[] {"BSIT 1-1", "BSIT 1-2","BSIT 1-3","BSIT 2-1", "BSIT 2-2","BSIT 2-3","BSIT 3-1", "BSIT 3-2","BSIT 3-3","BSIT 4-1", "BSIT 4-2","BSIT 4-3"}));
		SectionAct.setFont(new Font("Tahoma", Font.BOLD, 10));
		SectionAct.setForeground(new Color(255, 250, 250));
		SectionAct.setBackground(new Color(153, 50, 204));
		SectionAct.setBounds(52, 213, 99, 35);
		Activities.add(SectionAct);

		JLabel New = new JLabel("Enter Activity");
		New.setFont(new Font("Tahoma", Font.BOLD, 20));
		New.setBounds(149, 40, 148, 25);
		Activities.add(New);

		 YearAct = new JComboBox();
		YearAct.setModel(new DefaultComboBoxModel(new String[] { "1st Year", "2nd Year", "3rd Year", "4th Year" }));
		YearAct.setForeground(new Color(255, 250, 250));
		YearAct.setFont(new Font("Tahoma", Font.BOLD, 10));
		YearAct.setBackground(new Color(153, 50, 204));
		YearAct.setBounds(289, 213, 99, 35);
		Activities.add(YearAct);
		
		Sabat = new JTextField();
		Sabat.setColumns(10);
		Sabat.setBorder(bord);
		Sabat.setOpaque(false);
		Sabat.setBounds(52, 157, 346, 45);
		Activities.add(Sabat);
		
		JLabel Answer = new JLabel("Answer");
		Answer.setBounds(52, 144, 46, 14);
		Activities.add(Answer);
		
		Subject = new JComboBox();
		Subject.setModel(new DefaultComboBoxModel(new String[] { "OOP","DATA STRUCTURE","DATABASE" }));
		Subject.setForeground(new Color(255, 250, 250));
		Subject.setFont(new Font("Tahoma", Font.BOLD, 10));
		Subject.setBackground(new Color(153, 50, 204));
		Subject.setBounds(174, 213, 99, 35);
		Activities.add(Subject);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","");
					Statement stat  = conn.createStatement();
					stat.executeUpdate("DELETE FROM Activities WHERE Subject = '"+Subject.getSelectedItem().toString()+"' AND Year = '"+YearAct.getSelectedItem()+"'");
					String Section = SectionAct.getSelectedItem().toString();
					String Year= YearAct.getSelectedItem().toString();
					String Answer = Sabat.getText().toString();
					String Post = Activity.getText().toString();
					String Subjectz = Subject.getSelectedItem().toString();
				aa.Act(Section, Answer, Year, Post, Subjectz);
				}catch (Exception ee) {}
			}
		});
		Submit.setBounds(174, 279, 106, 25);
		Activities.add(Submit);

		JTabbedPane Announcements = new JTabbedPane(JTabbedPane.TOP);
		Announcements.setBackground(new Color(153, 50, 204));
		Dashboard.addTab("Announcement", null, Announcements, null);
		
		JPanel Announcement = new JPanel();
		Announcements.addTab("Announcement", null, Announcement, null);
		Announcement.setLayout(null);
		
		final JTextField anns = new JTextField();
		anns.setBounds(81, 71, 284, 39);
		Announcement.add(anns);
		anns.setColumns(10);
		
		JLabel nounce = new JLabel("Announcement");
		nounce.setFont(new Font("Tahoma", Font.BOLD, 15));
		nounce.setBounds(174, 34, 127, 26);
		Announcement.add(nounce);
		
		YearAct_1 = new JComboBox();
		YearAct_1.setForeground(new Color(255, 250, 250));
		YearAct_1.setModel(new DefaultComboBoxModel(new String[] { "1st Year", "2nd Year", "3rd Year", "4th Year" }));
		YearAct_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		YearAct_1.setBackground(new Color(0, 121, 51));
		YearAct_1.setBounds(100, 121, 99, 35);
		Announcement.add(YearAct_1);
		
		SectionAct_1 = new JComboBox();
		SectionAct_1.setForeground(new Color(255, 250, 250));
		SectionAct_1.setModel(new DefaultComboBoxModel(new String[] {"BSIT 1-1", "BSIT 1-2","BSIT 1-3","BSIT 2-1", "BSIT 2-2","BSIT 2-3","BSIT 3-1", "BSIT 3-2","BSIT 3-3","BSIT 4-1", "BSIT 4-2","BSIT 4-3"}));
		SectionAct_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		SectionAct_1.setBackground(new Color(0, 121, 51));
		SectionAct_1.setBounds(288, 121, 99, 35);
		Announcement.add(SectionAct_1);
		
		JButton sub = new JButton("Submit");
		sub.setFont(new Font("Tahoma", Font.BOLD, 14));
		sub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject", "root", "");
					Statement stat = conn.createStatement();
					String insert = "INSERT INTO anouncement (Post,Year,Section) VALUES('"+anns.getText().toString()+"','"+YearAct_1.getSelectedItem().toString()+"','"+SectionAct_1.getSelectedItem().toString()+"')";
					stat.executeUpdate(insert);
					JOptionPane.showMessageDialog(null, "Announcement Posted", "Success", 1);
			}catch(Exception e1) {
				System.out.println(e1.toString());
			}
			}
		});
		sub.setBounds(190, 178, 111, 35);
		Announcement.add(sub);
	}

	public void TeacherSet(String fn, String ln, String bd, String add, String gender, String id, String email) {
		JPanel Profile = new JPanel();
		Profile.setOpaque(false);
		Dashboard.addTab("Profile", null, Profile, null);
		Profile.setLayout(null);
		final JLabel profile = new JLabel();
		profile.setBounds(121, 11, 100, 100);
		Profile.add(profile);
		
		JLabel l1 = new JLabel("_________________");
		JLabel l2 = new JLabel("_________________");
		JLabel l3 = new JLabel("_________________");
		JLabel l4 = new JLabel("_________________");
		JLabel l5 = new JLabel("_________________");
		JLabel l6 = new JLabel("_________________");
		JLabel l7 = new JLabel("_________________");
		l1.setBounds(90, 126, 179, 30);
		l2.setBounds(90, 182, 179, 30);
		l3.setBounds(90, 241, 179, 30);
		l4.setBounds(83, 305, 179, 30);
		l5.setBounds(276, 148, 179, 30);
		l6.setBounds(269, 209, 179, 30);
		l7.setBounds(264, 277, 179, 30);
		
		Profile.add(l1);
		Profile.add(l2);
		Profile.add(l3);
		Profile.add(l4);
		Profile.add(l5);
		Profile.add(l6);
		Profile.add(l7);

		try {

			JButton select = new JButton("Select image");
			select.setBounds(336, 25, 110, 21);
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
			Pfn.setBounds(23, 122, 179, 30);
							
			
			Profile.add(Pfn);

			JLabel Pmn = new JLabel("Last name : " + ln);
			Pmn.setBounds(23, 182, 179, 30);
			Profile.add(Pmn);

			JLabel Pstud = new JLabel("Teacher Id : " + id);
			Pstud.setBounds(23, 241, 179, 30);
			Profile.add(Pstud);

			JLabel Padd = new JLabel("Address : " + add);
			Padd.setBounds(23, 305, 179, 30);
			Profile.add(Padd);

			JLabel Pbd = new JLabel("BirthDate : " + bd);
			Pbd.setBounds(212, 148, 179, 30);
			Profile.add(Pbd);

			JLabel Pgender = new JLabel("Gender : " + gender);
			Pgender.setBounds(212, 209, 179, 30);
			Profile.add(Pgender);

			JLabel Puser = new JLabel("Subject : OOP");
			Puser.setBounds(212, 277, 179, 30);
			Profile.add(Puser);

			JButton Edit = new JButton("Edit Profile");
			Edit.setBounds(336, 60, 110, 21);
			Profile.add(Edit);
		} catch (Exception e) {
		}
		setContentPane(Frame);
		
	}

	public void Delete() {
	}
	public void Search() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
