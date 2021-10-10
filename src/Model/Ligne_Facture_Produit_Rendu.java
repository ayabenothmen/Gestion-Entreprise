package Model;

public class Ligne_Facture_Produit_Rendu {
	String réf;
    String désignation;
    String unité_mésure;
    int qté_de_retour;
    float PU_hors_TVA;
    float TVA_appliquée;
    float P_total_horsTVA;
	public Ligne_Facture_Produit_Rendu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ligne_Facture_Produit_Rendu(String réf, String désignation, String unité_mésure, int qté_de_retour,
			float pU_hors_TVA, float tVA_appliquée, float p_total_horsTVA) {
		super();
		this.réf = réf;
		this.désignation = désignation;
		this.unité_mésure = unité_mésure;
		this.qté_de_retour = qté_de_retour;
		PU_hors_TVA = pU_hors_TVA;
		TVA_appliquée = tVA_appliquée;
		P_total_horsTVA = p_total_horsTVA;
	}
	public String getRéf() {
		return réf;
	}
	public void setRéf(String réf) {
		this.réf = réf;
	}
	public String getDésignation() {
		return désignation;
	}
	public void setDésignation(String désignation) {
		this.désignation = désignation;
	}
	public String getUnité_mésure() {
		return unité_mésure;
	}
	public void setUnité_mésure(String unité_mésure) {
		this.unité_mésure = unité_mésure;
	}
	public int getQté_de_retour() {
		return qté_de_retour;
	}
	public void setQté_de_retour(int qté_de_retour) {
		this.qté_de_retour = qté_de_retour;
	}
	public float getPU_hors_TVA() {
		return PU_hors_TVA;
	}
	public void setPU_hors_TVA(float pU_hors_TVA) {
		PU_hors_TVA = pU_hors_TVA;
	}
	public float getTVA_appliquée() {
		return TVA_appliquée;
	}
	public void setTVA_appliquée(float tVA_appliquée) {
		TVA_appliquée = tVA_appliquée;
	}
	public float getP_total_horsTVA() {
		return P_total_horsTVA;
	}
	public void setP_total_horsTVA(float p_total_horsTVA) {
		P_total_horsTVA = p_total_horsTVA;
	}
    

}
