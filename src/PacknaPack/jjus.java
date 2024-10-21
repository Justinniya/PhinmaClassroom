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
public class jjus extends JFrame implements ActionListener{
	public static void main(String [] args) {
		new jjus();
	}

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

	public jjus() {
		setTitle("UI Classroom");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600,400);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setVisible(true);
		Frame.setLayout(null);
		Frame.setBackground(new Color(0,128,0));
		isaP();
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
				JTable ttbl = new JTable(tbl);
				ttbl.setSurrendersFocusOnKeystroke(true);
				ttbl.setAlignmentX(Component.RIGHT_ALIGNMENT);
				JScrollPane BSIT_2_1 = new JScrollPane();
				ttbl.getColumnModel().getColumn(0).setResizable(false);
				ttbl.getColumnModel().getColumn(1).setPreferredWidth(165);
				BSIT_2_1.setViewportView(ttbl);
			}
			conn.close();
		}

		catch (Exception e1) {
			System.out.println(e1.toString());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
