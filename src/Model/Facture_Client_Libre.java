package Model;

import java.util.Date;

public class Facture_Client_Libre extends Facture_Client {
	Ligne_Facture_Client liste_produit_client_facturé;

	public Facture_Client_Libre() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Facture_Client_Libre(Ligne_Facture_Client liste_produit_client_facturé) {
		super();
		this.liste_produit_client_facturé = liste_produit_client_facturé;
	}

	public Ligne_Facture_Client getListe_produit_client_facturé() {
		return liste_produit_client_facturé;
	}

	public void setListe_produit_client_facturé(Ligne_Facture_Client liste_produit_client_facturé) {
		this.liste_produit_client_facturé = liste_produit_client_facturé;
	}
	
	

}
