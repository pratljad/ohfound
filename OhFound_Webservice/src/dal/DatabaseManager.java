package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bll.Account;
import bll.Activity;
import bll.Item;
import bll.Request;

public class DatabaseManager {

	private static DatabaseManager instance = null;

	private DatabaseManager() {}

	public static DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	private Connection createConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/OHFOUND";
		String user = "pupil";
		String password = "Pupil!#1";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return connection;
	}
	
	// REST - accounts
	
	public List<Account> GETaccounts() {
		List<Account> accounts = new ArrayList<Account>();
		Statement stmt;
		ResultSet set;
		Connection con = null;
		String query = "SELECT account_id, username, pwd, firstname, lastname, organizationname, locked, suspicion_level FROM Accounts";
		Account account;

		con = this.createConnection();
		try {
			stmt = con.createStatement();
			set = stmt.executeQuery(query);

			while (set.next()) {
				account = new Account(set.getInt(1), set.getString(2), set.getString(3), set.getString(4),
						set.getString(5), set.getString(6), set.getBoolean(7), set.getInt(8));
				accounts.add(account);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accounts;
	}

	public boolean POSTaccounts(Account acc) {
		boolean success = false;
		String query = "INSERT INTO Accounts (account_id, username, pwd, firstname, lastname, organizationname, locked, suspicion_level) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, acc.getAccount_id());
			pstmt.setString(2, acc.getUsername());
			pstmt.setString(3, acc.getPassword());
			pstmt.setString(4, acc.getFirstname());
			pstmt.setString(5, acc.getLastname());
			pstmt.setString(6, acc.getOrganizationname());
			pstmt.setBoolean(7, acc.isLocked());
			pstmt.setInt(8, acc.getSuspicion_level());

			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean UPDATEaccounts(Account acc) {
		boolean success = false;
		DELETEaccounts(acc.getAccount_id());
		POSTaccounts(acc);
		return success;
	}
	
	public boolean DELETEaccounts(String id) {
		boolean success = false;
		String query = "DELETE FROM Accounts WHERE account_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean DELETEaccounts(int id) {
		boolean success = false;
		String query = "DELETE FROM Accounts WHERE account_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	// REST - activities
	
	public List<Activity> GETactivities() {
		List<Activity> activities = new ArrayList<Activity>();
		Statement stmt;
		ResultSet set;
		Connection con = null;
		String query = "SELECT activity_id, category, account_id, account_name FROM Activities";
		Activity activity;

		con = this.createConnection();
		try {
			stmt = con.createStatement();
			set = stmt.executeQuery(query);

			while (set.next()) {
				activity = new Activity(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4));
				activities.add(activity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return activities;
	}

	public boolean POSTactivities(Activity act) {
		boolean success = false;
		String query = "INSERT INTO Activities (activity_id, category, account_id, account_name) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, act.getActivity_id());
			pstmt.setString(2, act.getCategory());
			pstmt.setInt(3, act.getAccount_id());
			pstmt.setString(4, act.getAccount_name());
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean UPDATEactivities(Activity act) {
		boolean success = false;
		DELETEactivities(act.getActivity_id());
		POSTactivities(act);
		return success;
	}
	
	public boolean DELETEactivities(String id) {
		boolean success = false;
		String query = "DELETE FROM Activities WHERE activity_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean DELETEactivities(int id) {
		boolean success = false;
		String query = "DELETE FROM Activities WHERE activity_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	// REST - items
	
	public List<Item> GETitems() {
		List<Item> items = new ArrayList<Item>();
		Statement stmt;
		ResultSet set;
		Connection con = null;
		String query = "SELECT item_id, title, description, published, marked_for_deletion FROM Items";
		Item item;

		con = this.createConnection();
		try {
			stmt = con.createStatement();
			set = stmt.executeQuery(query);

			while (set.next()) {
				item = new Item(set.getInt(1), set.getString(2), set.getString(3), set.getDate(4), set.getBoolean(5));
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	public boolean POSTitems(Item ite) {
		boolean success = false;
		String query = "INSERT INTO Items (item_id, title, description, published, marked_for_deletion) VALUES (?, ?, ?, ?, ?);";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, ite.getItem_id());
			pstmt.setString(2, ite.getTitle());
			pstmt.setString(3, ite.getDescription());
			pstmt.setDate(4, ite.getPublished());
			pstmt.setBoolean(5, ite.isMarked_for_deletion());

			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean UPDATEitems(Item ite) {
		boolean success = false;
		DELETEitems(ite.getItem_id());
		POSTitems(ite);
		return success;
	}
	
	public boolean DELETEitems(String id) {
		boolean success = false;
		String query = "DELETE FROM Items WHERE item_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean DELETEitems(int id) {
		boolean success = false;
		String query = "DELETE FROM Items WHERE item_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	// REST - requests
	
	public List<Request> GETrequests() {
		List<Request> requests = new ArrayList<Request>();
		Statement stmt;
		ResultSet set;
		Connection con = null;
		String query = "SELECT request_id, useraccount_id, organization_id, item_id, denied, opposed, approved FROM Requests";
		Request request;

		con = this.createConnection();
		try {
			stmt = con.createStatement();
			set = stmt.executeQuery(query);

			while (set.next()) {
				request = new Request(set.getInt(1), set.getInt(2), set.getInt(3), set.getInt(4),
						set.getBoolean(5), set.getBoolean(6), set.getBoolean(7));
				requests.add(request);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return requests;
	}

	public boolean POSTrequests(Request req) {
		boolean success = false;
		String query = "INSERT INTO Requests (request_id, useraccount_id, organization_id, item_id, denied, opposed, approved) VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, req.getRequest_id());
			pstmt.setInt(2, req.getUseraccount_id());
			pstmt.setInt(3, req.getOrganizationaccount_id());
			pstmt.setInt(4, req.getItem_id());
			pstmt.setBoolean(5, req.isDenied());
			pstmt.setBoolean(6, req.isOpposed());
			pstmt.setBoolean(7, req.isApproved());

			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean UPDATErequests(Request req) {
		boolean success = false;
		DELETErequests(req.getRequest_id());
		POSTrequests(req);
		return success;
	}
	
	public boolean DELETErequests(String id) {
		boolean success = false;
		String query = "DELETE FROM Requests WHERE request_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean DELETErequests(int id) {
		boolean success = false;
		String query = "DELETE FROM Requests WHERE request_id = ?";

		PreparedStatement pstmt;
		Connection con = this.createConnection();
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			success = pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
}
