package Model;

import java.util.Date;

public class Facture_Fournisseur_Libre extends Facture_Fournisseur {
	Ligne_Facture_Fournisseur liste_produit_fournisseur_factur�;

	public Facture_Fournisseur_Libre() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Facture_Fournisseur_Libre(Ligne_Facture_Fournisseur liste_produit_fournisseur_factur�) {
		super();
		this.liste_produit_fournisseur_factur� = liste_produit_fournisseur_factur�;
	}

	public Ligne_Facture_Fournisseur getListe_produit_fournisseur_factur�() {
		return liste_produit_fournisseur_factur�;
	}

	public void setListe_produit_fournisseur_factur�(Ligne_Facture_Fournisseur liste_produit_fournisseur_factur�) {
		this.liste_produit_fournisseur_factur� = liste_produit_fournisseur_factur�;
	}
	
	

}
