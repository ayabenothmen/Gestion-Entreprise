package Model;

import java.util.Vector;

public class Client extends Entreprise{
	int code;
	  public Client(int code,String matricule_fiscale,String raison_sociale,String type,String description_activit?,String compte_bancaire,
			  String adresse,int num_tlf_fixe,int num_tlf_mobile,int fax,String email,String site_web,String donn?e_etat_fiscale) {
		  super(matricule_fiscale,raison_sociale,type,description_activit?,compte_bancaire,adresse,num_tlf_fixe,num_tlf_mobile,fax,email,site_web,donn?e_etat_fiscale);
		  this.code=code;
		  
		  
		  
}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
