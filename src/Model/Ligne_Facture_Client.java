package Model;

public class Ligne_Facture_Client {
	String r�f;
    String d�signation;
    String unit�_m�sure;
    int qt�_livr�e;
    float PU_hors_TVA;
    float TVA_appliqu�e;
    float P_total_horsTVA;
	public Ligne_Facture_Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_Facture_Client(String r�f, String d�signation, String unit�_m�sure, int qt�_livr�e, float pU_hors_TVA,
			float tVA_appliqu�e, float p_total_horsTVA) {
		super();
		this.r�f = r�f;
		this.d�signation = d�signation;
		this.unit�_m�sure = unit�_m�sure;
		this.qt�_livr�e = qt�_livr�e;
		PU_hors_TVA = pU_hors_TVA;
		TVA_appliqu�e = tVA_appliqu�e;
		P_total_horsTVA = p_total_horsTVA;
	}
	public String getR�f() {
		return r�f;
	}
	public void setR�f(String r�f) {
		this.r�f = r�f;
	}
	public String getD�signation() {
		return d�signation;
	}
	public void setD�signation(String d�signation) {
		this.d�signation = d�signation;
	}
	public String getUnit�_m�sure() {
		return unit�_m�sure;
	}
	public void setUnit�_m�sure(String unit�_m�sure) {
		this.unit�_m�sure = unit�_m�sure;
	}
	public int getQt�_livr�e() {
		return qt�_livr�e;
	}
	public void setQt�_livr�e(int qt�_livr�e) {
		this.qt�_livr�e = qt�_livr�e;
	}
	public float getPU_hors_TVA() {
		return PU_hors_TVA;
	}
	public void setPU_hors_TVA(float pU_hors_TVA) {
		PU_hors_TVA = pU_hors_TVA;
	}
	public float getTVA_appliqu�e() {
		return TVA_appliqu�e;
	}
	public void setTVA_appliqu�e(float tVA_appliqu�e) {
		TVA_appliqu�e = tVA_appliqu�e;
	}
	public float getP_total_horsTVA() {
		return P_total_horsTVA;
	}
	public void setP_total_horsTVA(float p_total_horsTVA) {
		P_total_horsTVA = p_total_horsTVA;
	}
    
    

}
