package PacknaPack;
import java.sql.*;
import javax.swing.JOptionPane;

public class DataBase {
	final String url = "jdbc:mysql://localhost:3306/fproject";
	final String username = "root";
	String password = "";
	Connection conn = null;
	String db = "com.mysql.cj.jdbc.Driver";
	public void DSLLogin(String userField,String Password) {
		try {  

			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM student WHERE Username = '"+userField+"' AND Password = '"+Password+"'");

			if(result.next()) {
				SDashboard aa = new SDashboard();
				String UI1 = result.getString("UI_ID");
				ResultSet result1 = stat.executeQuery("SELECT * FROM student WHERE UI_ID = '"+UI1+"'");
				aa.dashboard();
				if(result1.next()){
					String Fn = result1.getString("Fn");
					String Mn = result1.getString("Mn");
					String Ln = result1.getString("Ln");
					String Age = result1.getString("Bdate");
					String Loc = result1.getString("Loc");
					String Section = result1.getString("Section");
					String Year = result1.getString("Year");
					String UI = result1.getString("UI_ID");
					String sex = result1.getString("Sex");
					String email = result1.getString("Username");

					aa.ProfileSet(Fn, Mn, Ln, Age, Loc, sex, UI, Year, Section,email);
				}
			}
			else {
				JOptionPane.showMessageDialog(null,"Wrong Password or Username","Warning", 2);
			}


			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
			new SLLogin();
		}

	}
	public void DTlogin(String userField, String passwordField) {
		try {

			Class.forName(db);
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","");
			Statement stat  = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM teacher WHERE Username = '"+userField+"' AND Password = '"+passwordField+"'");
			if(result.next()) {
				TDashboard a = new TDashboard();
				String UI1 = result.getString("id");
				ResultSet result1 = stat.executeQuery("SELECT * FROM teacher WHERE id = '"+UI1+"'");
				if(result1.next()){
					String Fn = result1.getString("Fn");
					String Ln = result1.getString("Ln");
					String Age = result1.getString("Bday");
					String Loc = result1.getString("Address");
					String Subject = result1.getString("Subject");
					String UI = result1.getString("id");
					String sex = result1.getString("Gender");
					String email = result1.getString("Username");
					Teacherset(UI1);
					a.TeacherSet(Fn, Ln, UI1, Subject, Age, UI, email);
				}
			}
			else JOptionPane.showMessageDialog(null,"Wrong Password or Username","Warning", 1);

			conn.close();
		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
	}
	public void DSRegister(String Fn,String Mn,String Ln,String ages,String Loc,String Sex,String Year,String Section,String Id) {
		try {


			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("DELETE FROM student WHERE Username = 'username'");
			stat.executeUpdate(delete);
			String insert = ("INSERT INTO student (UI_ID,Fn,Mn,Ln,Bdate,Loc,Sex,Year,Section) VALUES('"+Id+"','"+Fn+"','"+Mn+"','"+Ln+"','"+ages+"','"+Loc+"','"+Sex+"' ,'"+Year+"','"+Section+"') ");
			stat.executeUpdate(insert);
			new Rup();


			conn.close();




		}
		catch(Exception e1) {
			System.out.println(e1.toString());
			JOptionPane.showMessageDialog(null,"Invalid Credentials","Warning", 1);
		}

	}
	public void DDSRegister() {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("DELETE FROM student WHERE Username = 'username'");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}


	}
	public void MondayA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Monday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void TuesdayA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Tuesday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void WednesdayA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Wednesday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void ThursdayA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Thursday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void FridayA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Friday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void MondayAA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Monday FROM studentac WHERE Monday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void TuesdayAA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Tuesday FROM studentac WHERE Tuesday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void WednesdayAA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Wednesday FROM studentac WHERE Wednesday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void ThursdayAA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Thursday FROM studentac WHERE Thursday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void FridayAA(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Friday FROM studentac WHERE Friday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}
	}
	public void MondayA2(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Monday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void TuesdayA2(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Tuesday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void WednesdayA2(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Wednesday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void ThursdayA2(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Thursday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void FridayA2(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			String delete = ("UPDATE studentac SET Friday = '"+Act+"' WHERE ID = 1");
			stat.executeUpdate(delete);
			conn.close();


		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void MondayAA1(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Monday FROM studentac1 WHERE Monday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void TuesdayAA1(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Tuesday FROM studentac1 WHERE Tuesday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void WednesdayAA1(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Wednesday FROM studentac1 WHERE Wednesday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void ThursdayAA1(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Thursday FROM studentac1 WHERE Thursday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}
	public void FridayAA1(String Act) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet delete = stat.executeQuery("SELECT Friday FROM studentac1 WHERE Friday = '"+Act+"'");


			if(delete.next()) {
				System.out.println("Present");
			}
			else {
				System.out.println("Absent");
			}
			conn.close();

		}
		catch(Exception e1) {
			System.out.println(e1.toString());
		}

	}

	public void Teacherset(String Act) {

		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet result1 = stat.executeQuery("SELECT * FROM teacher WHERE UI_ID = '"+Act+"'");
			TDashboard a = new TDashboard();
			String Fn = result1.getString("Fn");
			String Ln = result1.getString("Ln");
			String Age = result1.getString("Bday");
			String Loc = result1.getString("Address");
			String Subject = result1.getString("Subject");
			String UI = result1.getString("id");
			String sex = result1.getString("Gender");
			String email = result1.getString("Username");
			a.TeacherSet(Fn, Ln, Age,Subject, UI,  sex, email);
		}
		catch(Exception e) {}
	}
	public void ForgetPassword(String Pass, String Codes, String Email) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			ResultSet result = stat.executeQuery("SELECT * FROM student WHERE Username = '"+Email+"' ");

			if(result.next()) {
				System.out.println("Success");
				stat.executeUpdate("UPDATE student SET Password = '"+Pass+"' WHERE  Codes = '"+Codes+"' AND Username = '"+Email+"'");
				JOptionPane.showMessageDialog(null, "Changed Password Success", "Success", 1);
				stat.executeUpdate("UPDATE student SET Codes = '16' WHERE  Codes = '"+Codes+"'");
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Email or Password", "Invalid", 2);
			}
		}
		catch(Exception e) {
			System.out.println(e.toString());
			System.out.println("diri");
		}
	}
	public void Codes(String code) {

		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			stat.executeUpdate("UPDATE student SET Codes = '"+code+"' WHERE Codes = 16");

		}
		catch(Exception e) {}

	}
	public void Act(String Section,String Answer,String Year,String post, String Subject) {
		try {
			Class.forName(db);
			conn=DriverManager.getConnection(url,username,password);
			Statement stat  = conn.createStatement();
			stat.executeUpdate("INSERT INTO Activities (Act,Year,Section,Answer,Subject) VALUES ('"+post+"','"+Year+"','"+Section+"','"+Answer+"','"+Subject+"')");
			JOptionPane.showMessageDialog(null, "Activity Inserted", "Success", 1);
		}
		catch(Exception e) {}

	}
	public void OOP() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/fproject","root","");
			Statement stat  = conn.createStatement();
		}catch (Exception e) {}
		
	}
}

