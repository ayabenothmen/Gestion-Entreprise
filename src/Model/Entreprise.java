package Model;



public class Entreprise {
	String matricule_fiscale;
	String raison_social;
	String type;
	String description_activité;
	String compte_bancaire;
	String adresse;
	int num_tel_fixe;
	int num_tel_mobile;
	int fax;
	String email;
	String site_web;
	String donnée_etat_fiscale;
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Entreprise(String matricule_fiscale, String raison_social, String type, String discription_activité,
			String compte_bancaire, String adresse, int num_tel_fixe, int num_tel_mobile, int fax, String email,
			String site_web, String donnée_etat_fiscale) {
		super();
		this.matricule_fiscale = matricule_fiscale;
		this.raison_social = raison_social;
		this.type = type;
		this.description_activité = discription_activité;
		this.compte_bancaire = compte_bancaire;
		this.adresse = adresse;
		this.num_tel_fixe = num_tel_fixe;
		this.num_tel_mobile = num_tel_mobile;
		this.fax = fax;
		this.email = email;
		this.site_web = site_web;
		this.donnée_etat_fiscale = donnée_etat_fiscale;
	}
	@Override
	public String toString() {
		return "Entreprise [matricule_fiscale=" + matricule_fiscale + ", raison_social=" + raison_social + ", type="
				+ type + ", description_activité=" + description_activité + ", compte_bancaire=" + compte_bancaire
				+ ", adresse=" + adresse + ", num_tel_fixe=" + num_tel_fixe + ", num_tel_mobile=" + num_tel_mobile
				+ ", fax=" + fax + ", email=" + email + ", site_web=" + site_web + ", donnée_etat_fiscale="
				+ donnée_etat_fiscale + "]";
	}
	public String getMatricule_fiscale() {
		return matricule_fiscale;
	}
	public void setMatricule_fiscale(String matricule_fiscale) {
		this.matricule_fiscale = matricule_fiscale;
	}
	public String getRaison_social() {
		return raison_social;
	}
	public void setRaison_social(String raison_social) {
		this.raison_social = raison_social;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription_activité() {
		return description_activité;
	}
	public void setDescription_activité(String description_activité) {
		this.description_activité = description_activité;
	}
	public String getCompte_bancaire() {
		return compte_bancaire;
	}
	public void setCompte_bancaire(String compte_bancaire) {
		this.compte_bancaire = compte_bancaire;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNum_tel_fixe() {
		return num_tel_fixe;
	}
	public void setNum_tel_fixe(int num_tel_fixe) {
		this.num_tel_fixe = num_tel_fixe;
	}
	public int getNum_tel_mobile() {
		return num_tel_mobile;
	}
	public void setNum_tel_mobile(int num_tel_mobile) {
		this.num_tel_mobile = num_tel_mobile;
	}
	public int getFax() {
		return fax;
	}
	public void setFax(int fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	public String getDonnée_etat_fiscale() {
		return donnée_etat_fiscale;
	}
	public void setDonnée_etat_fiscale(String donnée_etat_fiscale) {
		this.donnée_etat_fiscale = donnée_etat_fiscale;
	}
	
	

}
