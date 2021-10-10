package Model;


public class Produit {
	int code;
	String reference;
	String designation;
	String unité_mesure;
	String fournisseur;
	String famille_produit;
	int stock;
	int stock_min;
	int PU_hors_taxe;
	int tva;
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit(int code, String reference, String designation, String unité_mesure, String fournisseur,
			String famille_produit, int stock, int stock_min, int pU_hors_taxe, int tva) {
		super();
		this.code = code;
		this.reference = reference;
		this.designation = designation;
		this.unité_mesure = unité_mesure;
		this.fournisseur = fournisseur;
		this.famille_produit = famille_produit;
		this.stock = stock;
		this.stock_min = stock_min;
		PU_hors_taxe = pU_hors_taxe;
		this.tva = tva;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int id) {
		this.code = code;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getUnité_mesure() {
		return unité_mesure;
	}
	public void setUnité_mesure(String unité_mesure) {
		this.unité_mesure = unité_mesure;
	}
	public String getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	public String getFamille_produit() {
		return famille_produit;
	}
	public void setFamille_produit(String famille_produit) {
		this.famille_produit = famille_produit;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getStock_min() {
		return stock_min;
	}
	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}
	public int getPU_hors_taxe() {
		return PU_hors_taxe;
	}
	public void setPU_hors_taxe(int pU_hors_taxe) {
		PU_hors_taxe = pU_hors_taxe;
	}
	public int getTva() {
		return tva;
	}
	public void setTva(int tva) {
		this.tva = tva;
	}
	

}
