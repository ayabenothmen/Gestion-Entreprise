package Model;

public class Ligne_Facture_Produit_Rendu {
	String r�f;
    String d�signation;
    String unit�_m�sure;
    int qt�_de_retour;
    float PU_hors_TVA;
    float TVA_appliqu�e;
    float P_total_horsTVA;
	public Ligne_Facture_Produit_Rendu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_Facture_Produit_Rendu(String r�f, String d�signation, String unit�_m�sure, int qt�_de_retour,
			float pU_hors_TVA, float tVA_appliqu�e, float p_total_horsTVA) {
		super();
		this.r�f = r�f;
		this.d�signation = d�signation;
		this.unit�_m�sure = unit�_m�sure;
		this.qt�_de_retour = qt�_de_retour;
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
	public int getQt�_de_retour() {
		return qt�_de_retour;
	}
	public void setQt�_de_retour(int qt�_de_retour) {
		this.qt�_de_retour = qt�_de_retour;
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
