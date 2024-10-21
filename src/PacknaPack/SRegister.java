package PacknaPack;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
public class SRegister extends JFrame implements ActionListener{
	final String url = "jdbc:mysql://localhost:3306/fproject";
	final String username = "root";
	String password = "";
	Connection conn = null;
	String db = "com.mysql.cj.jdbc.Driver";
	private JPanel Frame;
	private String Fns,Mns,Lns,Locs ,Years,Ids,Sections,Sexs,Ages;
	private JTextField Fn,Mn,Ln,Loc ,Id,Age;
	private JLabel Firstname,Lastname,Middlename,Birthdate,IID,Sectionn,Yearr,Address;
	private JLabel lblNewLabel;
	private JComboBox Sex,Year,Section;
	DataBase a = new DataBase();
	public SRegister() {
		setTitle("UI Classroom");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 170, 600, 400);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		Border bord = BorderFactory.createMatteBorder(0,0,1,0,Color.white);
		setContentPane(Frame);
		Frame.setLayout(null);
		
		Fn = new JTextField();
		Fn.setFont(new Font("Tahoma", Font.BOLD, 10));
		Fn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
			});
		Fn.setForeground(Color.white);
		Fn.setOpaque(false);
		Fn.setBorder(bord);
		Fn.setBounds(114, 107, 86, 20);
		Frame.add(Fn);
		Fn.setColumns(10);
		
		Mn = new JTextField();
		Mn.setFont(new Font("Tahoma", Font.BOLD, 10));
		Mn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
			});
		Mn.setForeground(Color.white);
		Mn.setOpaque(false);
		Mn.setBorder(bord);
		Mn.setBounds(241, 107, 86, 20);
		Frame.add(Mn);
		Mn.setColumns(10);
		
		Ln = new JTextField();
		Ln.setFont(new Font("Tahoma", Font.BOLD, 10));
		Ln.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
			});
		Ln.setForeground(Color.white);
		Ln.setOpaque(false);
		Ln.setBorder(bord);
		Ln.setColumns(10);
		Ln.setBounds(367, 107, 86, 20);
		Frame.add(Ln);
		
		Age = new JTextField();
		Age.setFont(new Font("Tahoma", Font.BOLD ,10));
		Age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
			});
		Age.setForeground(Color.white);
		Age.setOpaque(false);
		Age.setBorder(bord);
		Age.setBounds(241, 162, 86, 20);
		Frame.add(Age);
		
		Loc = new JTextField();
		Loc.setFont(new Font("Tahoma", Font.BOLD, 10));
		Loc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
			});
		Loc.setForeground(Color.white);
		Loc.setOpaque(false);
		Loc.setBorder(bord);
		Loc.setColumns(10);
		Loc.setBounds(367, 161, 86, 20);
		Frame.add(Loc);
		
		Year = new JComboBox();
		Year.setModel(new DefaultComboBoxModel(new String[] {"1st Year", "2nd Year","3rd Year","4th Year"}));
		Year.setFont(new Font("Tahoma", Font.BOLD, 10));
		Year.setForeground(Color.white);
		Year.setBackground(new Color(0, 121, 51));
		Year.setOpaque(false);
		Year.setBorder(bord);
		Year.setBounds(114, 215, 86, 20);
		Frame.add(Year);
		//Year.setAction(null);
			Section = new JComboBox();
			Section.setModel(new DefaultComboBoxModel(new String[] {"BSIT 1-1", "BSIT 1-2","BSIT 1-3","BSIT 2-1", "BSIT 2-2","BSIT 2-3","BSIT 3-1", "BSIT 3-2","BSIT 3-3","BSIT 4-1", "BSIT 4-2","BSIT 4-3"}));
			Section.setFont(new Font("Tahoma", Font.BOLD, 10));
			Section.setForeground(Color.white);
			Section.setBackground(new Color(0, 121, 51));
			Section.setOpaque(false);
			Section.setBorder(bord);
			Section.setBounds(367, 215, 86, 20);
			Frame.add(Section);
		
		Id = new JTextField();
		Id.setFont(new Font("Tahoma", Font.BOLD, 10));
		Loc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
					}
					else {
					Fns = Fn.getText().toString();
					Mns= Mn.getText().toString();
					Lns=Ln.getText().toString();
					Ages=Age.getText().toString();
					Locs=Loc.getText().toString();
					Years=(String) Year.getSelectedItem();
					Ids=Id.getText().toString();
					Sections=(String) Section.getSelectedItem();
					Sexs= (String) Sex.getSelectedItem();
					a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
					dispose();
					}
				}
			}
		});
		Id.setForeground(Color.white);
		Id.setOpaque(false);
		Id.setColumns(10);
		Id.setBorder(bord);
		Id.setBounds(114, 161, 86, 20);
		Frame.add(Id);
		

		
		Firstname = new JLabel("Firstname");
		Firstname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Firstname.setForeground(Color.WHITE);
		Firstname.setBounds(114, 83, 86, 14);
		Frame.add(Firstname);
		
		Lastname = new JLabel("Lastname");
		Lastname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Lastname.setForeground(Color.WHITE);
		Lastname.setBounds(367, 83, 86, 14);
		Frame.add(Lastname);
		
		Middlename = new JLabel("Middlename");
		Middlename.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Middlename.setForeground(Color.WHITE);
		Middlename.setBounds(241, 83, 86, 14);
		Frame.add(Middlename);
		
		Address = new JLabel("Address");
		Address.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Address.setForeground(Color.WHITE);
		Address.setBounds(367, 137, 86, 14);
		Frame.add(Address);
		
		Birthdate = new JLabel("Birthdate(yyyy-mm-dd)");
		Birthdate.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Birthdate.setForeground(Color.WHITE);
		Birthdate.setBounds(221, 138, 136, 14);
		Frame.add(Birthdate);
		
		IID = new JLabel("Student ID");
		IID.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		IID.setForeground(Color.WHITE);
		IID.setBounds(114, 137, 86, 14);
		Frame.add(IID);
		
		Sectionn = new JLabel("Section");
		Sectionn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Sectionn.setForeground(Color.WHITE);
		Sectionn.setBounds(367, 191, 86, 14);;
		Frame.add(Sectionn);
		
		Yearr = new JLabel("Year");
		Yearr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		Yearr.setForeground(Color.WHITE);
		Yearr.setBounds(114, 191, 86, 14);
		Frame.add(Yearr);
		
		
		
		
		JButton Register = new JButton("Next");
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Fn.getText().toString().equals("") || Mn.getText().toString().equals("") || Ln.getText().toString().equals("") || Loc.getText().toString().equals("") || Age.getText().toString().equals("") || Id.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null,"Missing inputs","Warning", 1);
				}
				else {
				Fns = Fn.getText().toString();
				Mns= Mn.getText().toString();
				Lns=Ln.getText().toString();
				Ages=Age.getText().toString();
				Locs=Loc.getText().toString();
				Years=(String) Year.getSelectedItem();
				Ids=Id.getText().toString();
				Sections=(String) Section.getSelectedItem();
				Sexs= (String) Sex.getSelectedItem();
				a.DSRegister(Fns, Mns, Lns, Ages, Locs, Sexs, Years, Sections, Ids);
				dispose();
				}
			}
		});
		Register.setBackground(new Color(153, 50, 204));
		Register.setFont(new Font("Tahoma", Font.BOLD, 15));
		Register.setBounds(230, 249, 114, 23);
		Frame.add(Register);
		
		JButton Back = new JButton("Back");
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SLLogin();
			}
		});
		Back.setBounds(510, 11, 64, 23);
		Frame.add(Back);
		
		lblNewLabel = new JLabel("Step 1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(257, 50, 87, 23);
		Frame.add(lblNewLabel);
		lblNewLabel = new JLabel("Gender");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 10));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(241, 189, 87, 23);
		Frame.add(lblNewLabel);
		Sex = new JComboBox();
		Sex.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		Sex.setFont(new Font("Tahoma", Font.BOLD, 10));
		Sex.setForeground(new Color(255, 250, 250));
		Sex.setBackground(new Color(0, 121, 51));
		Sex.setBounds(241, 215, 86, 19);
		Frame.add(Sex);
		
		
		JLabel Background = new JLabel("Background");
		Background.setIcon(new ImageIcon("C:\\\\Users\\\\Natalie Jenh Alarcon\\\\Desktop\\\\received_288983967383600.jpeg"));
		Background.setBounds(-30, -57, 829, 538);
		Frame.add(Background);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
