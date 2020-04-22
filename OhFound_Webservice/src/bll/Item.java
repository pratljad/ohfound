package bll;

import java.sql.Date;

public class Item {
	private int Item_id = 0;
	private String Title = "";
	private String Description = "";
	private Date Published = null;
	private boolean Marked_for_deletion = false;
	
	public Item() {}

	public Item(int item_id, String title, String description, Date published, boolean marked_for_deletion) {
		super();
		Item_id = item_id;
		Title = title;
		Description = description;
		Published = published;
		Marked_for_deletion = marked_for_deletion;
	}

	public int getItem_id() {
		return Item_id;
	}

	public void setItem_id(int item_id) {
		Item_id = item_id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Date getPublished() {
		return Published;
	}

	public void setPublished(Date published) {
		Published = published;
	}

	public boolean isMarked_for_deletion() {
		return Marked_for_deletion;
	}

	public void setMarked_for_deletion(boolean marked_for_deletion) {
		Marked_for_deletion = marked_for_deletion;
	}

	@Override
	public String toString() {
		return "Item [Item_id=" + Item_id + ", Title=" + Title + ", Description=" + Description + ", Published="
				+ Published + ", Marked_for_deletion=" + Marked_for_deletion + "]";
	}
}
