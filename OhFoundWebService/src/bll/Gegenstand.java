package bll;

import java.awt.Image;

import com.mysql.jdbc.Blob;

public class Gegenstand {
	
	private int id;
	private Ueberbegriff ueberbegriff;
	private String beschreibung;
	private String ort;
	private byte[] image;   //keine ahnung ob blob oder image
	 
	public Gegenstand() {
		
	}
	
	public Gegenstand(int id, Ueberbegriff ueberbegriff, String beschreibung, String ort, byte[] image) {
		super();
		this.id = id;
		this.ueberbegriff = ueberbegriff;
		this.beschreibung = beschreibung;
		this.ort = ort;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ueberbegriff getUeberbegriff() {
		return ueberbegriff;
	}

	public void setUeberbegriff(Ueberbegriff ueberbegriff) {
		this.ueberbegriff = ueberbegriff;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
