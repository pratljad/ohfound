package bll;

public class Request {
	private int Request_id = 0;
	private int Useraccount_id = 0;
	private int Organizationaccount_id = 0;
	private int Item_id = 0;
	private boolean Denied = false;
	private boolean Opposed = false;
	private boolean Approved = false;
	
	public Request() {}

	public Request(int request_id, int useraccount_id, int organizationaccount_id, int item_id, boolean denied,
			boolean opposed, boolean approved) {
		super();
		Request_id = request_id;
		Useraccount_id = useraccount_id;
		Organizationaccount_id = organizationaccount_id;
		Item_id = item_id;
		Denied = denied;
		Opposed = opposed;
		Approved = approved;
	}

	public int getRequest_id() {
		return Request_id;
	}

	public void setRequest_id(int request_id) {
		Request_id = request_id;
	}

	public int getUseraccount_id() {
		return Useraccount_id;
	}

	public void setUseraccount_id(int useraccount_id) {
		Useraccount_id = useraccount_id;
	}

	public int getOrganizationaccount_id() {
		return Organizationaccount_id;
	}

	public void setOrganizationaccount_id(int organizationaccount_id) {
		Organizationaccount_id = organizationaccount_id;
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public boolean isDenied() {
		return Denied;
	}

	public void setDenied(boolean denied) {
		Denied = denied;
	}

	public boolean isOpposed() {
		return Opposed;
	}

	public void setOpposed(boolean opposed) {
		Opposed = opposed;
	}

	public boolean isApproved() {
		return Approved;
	}

	public void setApproved(boolean approved) {
		Approved = approved;
	}

	@Override
	public String toString() {
		return "Request [Request_id=" + Request_id + ", Useraccount_id=" + Useraccount_id + ", Organizationaccount_id="
				+ Organizationaccount_id + ", Item_id=" + Item_id + ", Denied=" + Denied + ", Opposed=" + Opposed
				+ ", Approved=" + Approved + "]";
	}
}
