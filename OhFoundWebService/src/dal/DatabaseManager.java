package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Blob;

import bll.Gegenstand;
import bll.Ueberbegriff;

public class DatabaseManager {
	
	private static DatabaseManager instance = null;
	private static Connection conn = null;

	private DatabaseManager() {

	}

	public static DatabaseManager getInstance() {
		if (DatabaseManager.instance == null) {
			DatabaseManager.instance = new DatabaseManager();
			conn = createConnection();
		}
		return DatabaseManager.instance;
	}

	private static Connection createConnection() {

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OHFOUND", "pupil", "Pupil!#1");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return con;

	}
	
//-----------------------------Ueberbegriff---------------------------------------
	
	public ArrayList<Ueberbegriff> getAllUeberbegriff() throws Exception {
		ArrayList<Ueberbegriff> allUeberbegriffe = new ArrayList<Ueberbegriff>();

		Connection conn = createConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Ueberbegriff");
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
			allUeberbegriffe.add(new Ueberbegriff(rs.getInt(1), rs.getString(2)));

		conn.close();
		return allUeberbegriffe;
	}
	
	public Ueberbegriff getUeberbegriff(int id) {
		Ueberbegriff result = null;

		Connection conn = createConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Ueberbegriff WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.first()) {
				result = new Ueberbegriff(rs.getInt(1), rs.getString(2));
			}
			conn.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public void addUeberbegriff(Ueberbegriff ueberbegriff) throws Exception {
		PreparedStatement stmt = null;

		conn = createConnection();
		stmt = conn.prepareStatement("INSERT INTO Ueberbegriff (Bezeichnung) VALUES (?)");
		stmt.setString(1, ueberbegriff.getBezeichnung());
		stmt.execute();

		stmt.close();
		conn.close();
	}
	
	public void deleteUeberbegriff(int id) throws ClassNotFoundException, SQLException {
		try {
			PreparedStatement stmt = null;
			conn = createConnection();
			stmt = conn.prepareStatement("DELETE FROM Ueberbegriff WHERE id=?");

			stmt.setInt(1, id);
			stmt.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUeberbegriff(Ueberbegriff ueberbegriff) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = this.createConnection();
			stmt = con.prepareStatement("UPDATE Ueberbegriff SET bezeichnung=? WHERE id=?");
			stmt.setString(1, ueberbegriff.getBezeichnung());
			stmt.setInt(2, ueberbegriff.getId());
			stmt.execute();
		} catch (Exception e) {
			throw new Exception("Überbegriff: " + ueberbegriff + " konnte nicht upgedated werden (" + e.getMessage() + ")");
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
//----------------------------------------Gegenstand-----------------------------------------
	public ArrayList<Gegenstand> getAllGegenstaende() throws Exception {
		ArrayList<Gegenstand> allGegenstaende = new ArrayList<Gegenstand>();

		Connection conn = createConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Gegenstand");
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
			allGegenstaende.add(new Gegenstand(rs.getInt("id"), getUeberbegriff(rs.getInt("ueberbegriff_Id")),
					rs.getString("beschreibung"), rs.getString("ort"), (Blob) rs.getBlob("image")));
		conn.close();
		return allGegenstaende;
	}
	
	public Gegenstand getGegensatnd(int id) throws Exception {
		Gegenstand gegenstand = null;

		Connection conn = createConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Gegenstand WHERE id=?");
		stmt.setInt(1, id);
		ResultSet rs = stmt.executeQuery();
		while (rs.next())
			gegenstand = new Gegenstand(rs.getInt("id"), getUeberbegriff(rs.getInt("ueberbegriff_Id")),
					rs.getString("beschreibung"), rs.getString("ort"), (Blob) rs.getBlob("image"));
		conn.close();
		return gegenstand;
	}
	
	public void addGegenstand(Gegenstand gegenstand) throws Exception {
		PreparedStatement stmt = null;

		conn = createConnection();
		
		stmt = conn.prepareStatement("INSERT INTO Gegenstand (Ueberbegriff_Id, Beschreibung,  Ort, Image)  VALUES (?,?,?,?)");
		stmt.setInt(1, gegenstand.getUeberbegriff().getId());
		stmt.setString(2, gegenstand.getBeschreibung());
		stmt.setString(3, gegenstand.getOrt());
		stmt.setBlob(4, gegenstand.getImage());
		stmt.execute();

		stmt.close();
		conn.close();
	}

	public void deleteGegenstand(int id) throws ClassNotFoundException, SQLException {
		try {
			PreparedStatement stmt = null;
			conn = createConnection();
			stmt = conn.prepareStatement("DELETE FROM Gegenstand WHERE id=?");
			stmt.setInt(1, id);
			stmt.execute();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateGegenstand(Gegenstand gegenstand) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = this.createConnection(); 
			stmt = con.prepareStatement("UPDATE Gegenstand SET Ueberbegriff_Id=?,Beschreibung=?,"
					+ "Ort=?,Image=? WHERE id=?");
			
			stmt.setInt(1, gegenstand.getUeberbegriff().getId());
			stmt.setString(2, gegenstand.getBeschreibung());
			stmt.setString(3, gegenstand.getOrt());
			stmt.setBlob(4, gegenstand.getImage());
			
			stmt.execute();
		} catch (Exception e) {
			throw new Exception("Gegenstand: " + gegenstand + " konnte nicht upgedated werden (" + e.getMessage() + ")");
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
















