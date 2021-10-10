package Model;

import java.util.Date;
import java.util.Vector;

public class Devis {
	int code;
	String date;
	int code_client;
	Vector<Ligne_devis>ligne_devis;
	float m_total_TVA;
	float m_total_hors_TVA;
	float m_total_Payer;
	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devis(int code, String date, int code_client, Vector<Ligne_devis> ligne_devis, float m_total_TVA,
			float m_total_hors_TVA, float m_total_Payer) {
		super();
		this.code = code;
		this.date = date;
		this.code_client = code_client;
		this.ligne_devis = ligne_devis;
		this.m_total_TVA = m_total_TVA;
		this.m_total_hors_TVA = m_total_hors_TVA;
		this.m_total_Payer = m_total_Payer;
	}
	public Devis(int code, String date, int code_client, float m_total_TVA,
			float m_total_hors_TVA, float m_total_Payer) {
		super();
		this.code = code;
		this.date = date;
		this.code_client = code_client;
		this.m_total_TVA = m_total_TVA;
		this.m_total_hors_TVA = m_total_hors_TVA;
		this.m_total_Payer = m_total_Payer;
	}
	@Override
	public String toString() {
		return "Devis [code=" + code + ", date=" + date + ", code_client=" + code_client + ", ligne_devis="
				+ ligne_devis + ", m_total_TVA=" + m_total_TVA + ", m_total_hors_TVA=" + m_total_hors_TVA
				+ ", m_total_Payer=" + m_total_Payer + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCode_client() {
		return code_client;
	}
	public void setCode_client(int code_client) {
		this.code_client = code_client;
	}
	public Vector<Ligne_devis> getLigne_devis() {
		return ligne_devis;
	}
	public void setLigne_devis(Vector<Ligne_devis> ligne_devis) {
		this.ligne_devis = ligne_devis;
	}
	public float getM_total_TVA() {
		return m_total_TVA;
	}
	public void setM_total_TVA(float m_total_TVA) {
		this.m_total_TVA = m_total_TVA;
	}
	public float getM_total_hors_TVA() {
		return m_total_hors_TVA;
	}
	public void setM_total_hors_TVA(float m_total_hors_TVA) {
		this.m_total_hors_TVA = m_total_hors_TVA;
	}
	public float getM_total_Payer() {
		return m_total_Payer;
	}
	public void setM_total_Payer(float m_total_Payer) {
		this.m_total_Payer = m_total_Payer;
	}
	

}
