package Model;

import java.util.Date;

public class Facture_Client_Libre extends Facture_Client {
	Ligne_Facture_Client liste_produit_client_factur�;

	public Facture_Client_Libre() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Facture_Client_Libre(Ligne_Facture_Client liste_produit_client_factur�) {
		super();
		this.liste_produit_client_factur� = liste_produit_client_factur�;
	}

	public Ligne_Facture_Client getListe_produit_client_factur�() {
		return liste_produit_client_factur�;
	}

	public void setListe_produit_client_factur�(Ligne_Facture_Client liste_produit_client_factur�) {
		this.liste_produit_client_factur� = liste_produit_client_factur�;
	}
	
	

}
