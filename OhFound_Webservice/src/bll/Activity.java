package bll;

public class Activity {
	private int Activity_id = 0;
	private String Category = "";
	private int Account_id = 0;
	private String Account_name = "";
	
	public Activity() {}

	public Activity(int activity_id, String category, int account_id, String account_name) {
		super();
		Activity_id = activity_id;
		Category = category;
		Account_id = account_id;
		Account_name = account_name;
	}

	public int getActivity_id() {
		return Activity_id;
	}

	public void setActivity_id(int activity_id) {
		Activity_id = activity_id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	}

	public String getAccount_name() {
		return Account_name;
	}

	public void setAccount_name(String account_name) {
		Account_name = account_name;
	}

	@Override
	public String toString() {
		return "Activity [Activity_id=" + Activity_id + ", Category=" + Category + ", Account_id=" + Account_id
				+ ", Account_name=" + Account_name + "]";
	}
}
