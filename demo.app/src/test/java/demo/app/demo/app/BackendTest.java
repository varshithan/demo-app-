package demo.app.demo.app;

import static org.testng.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BackendTest {
	static Connection con = null;
	private static Statement stmt;
	public static String DB_URL = "jdbc:mysql://localhost:3306/blogger";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "root";

	@BeforeTest
	public void setUp() throws Exception {

		try {

			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = con.createStatement();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1, description = "get all data")
	public void test() {
		try {
			String query = "select * from blogger";
			ResultSet res = stmt.executeQuery(query);
			while (res.next()) {
				System.out.print(res.getString(1));
				System.out.print("\t" + res.getString(2));
				System.out.print("\t" + res.getString(3));
				System.out.println("\t" + res.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void gettitle() throws SQLException {
		String author = "varshi";
		String query = "select Id,author from blogger where author='" + author + "'";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			System.out.print("\t" + res.getString(1));
			System.out.print("\t" + res.getString(2));
		}
	}

	@Test(priority = 3, description = "positive testing")
	public void getsingledata() throws SQLException {
		String query = "select * from blogger where id='" + 4 + "'";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			System.out.print(res.getString(1));
			assertEquals("4", res.getString(1));
			System.out.print("\t" + res.getString(3));
			assertEquals("hai", res.getString(3));
			System.out.print("\t" + res.getString(4));
			assertEquals("new", res.getString(4));

		}
	}

	@AfterTest
	public void tearDown() throws Exception {
		if (con != null) {
			con.close();
		}
	}

}
