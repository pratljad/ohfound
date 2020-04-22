package bll;

public class Account {
	private int Account_id = 0;
	private String Username = "";
	private String Password = "";
	private String Firstname ="";
	private String Lastname = "";
	private String Organizationname = "";
	private boolean Locked = false;
	private int Suspicion_level = 0;
	
	public Account() {}

	public Account(int account_id, String username, String password, String firstname, String lastname,
			String organizationname, boolean locked, int suspicion_level) {
		super();
		Account_id = account_id;
		Username = username;
		Password = password;
		Firstname = firstname;
		Lastname = lastname;
		Organizationname = organizationname;
		Locked = locked;
		Suspicion_level = suspicion_level;
	}

	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getOrganizationname() {
		return Organizationname;
	}

	public void setOrganizationname(String organizationname) {
		Organizationname = organizationname;
	}

	public boolean isLocked() {
		return Locked;
	}

	public void setLocked(boolean locked) {
		Locked = locked;
	}

	public int getSuspicion_level() {
		return Suspicion_level;
	}

	public void setSuspicion_level(int suspicion_level) {
		Suspicion_level = suspicion_level;
	}

	@Override
	public String toString() {
		return "Account [Account_id=" + Account_id + ", Username=" + Username + ", Password=" + Password
				+ ", Firstname=" + Firstname + ", Lastname=" + Lastname + ", Organizationname=" + Organizationname
				+ ", Locked=" + Locked + ", Suspicion_level=" + Suspicion_level + "]";
	}
}
