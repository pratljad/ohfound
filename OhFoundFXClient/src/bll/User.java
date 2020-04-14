package bll;

public class User {

	private int id;
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	private String passwort_wiederholen;
	private boolean isAdmin;

	public User() {
		
	}
	public User(int id, String vorname, String nachname, String email, String passwort, boolean isAdmin) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.isAdmin = isAdmin;
	}

	public User(int id, String vorname, String nachname, String email, String passwort, String passwort_wiederholen,
			boolean isAdmin) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
		this.passwort_wiederholen = passwort_wiederholen;
		this.isAdmin = isAdmin;
	}

	public User(String email, String passwort) {
		this.email = email;
		this.passwort = passwort;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPasswort_wiederholen() {
		return passwort_wiederholen;
	}

	public void setPasswort_wiederholen(String passwort_wiederholen) {
		this.passwort_wiederholen = passwort_wiederholen;
	}


	public boolean getIsAdmin() {
	    return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
	    this.isAdmin = isAdmin;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", email=" + email + ", passwort="
				+ passwort + ", passwort_wiederholen=" + passwort_wiederholen + ", isAdmin=" + isAdmin + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
