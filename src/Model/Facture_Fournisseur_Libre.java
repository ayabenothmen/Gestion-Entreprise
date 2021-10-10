package Model;

import java.util.Date;

public class Facture_Fournisseur_Libre extends Facture_Fournisseur {
	Ligne_Facture_Fournisseur liste_produit_fournisseur_facturé;

	public Facture_Fournisseur_Libre() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Facture_Fournisseur_Libre(Ligne_Facture_Fournisseur liste_produit_fournisseur_facturé) {
		super();
		this.liste_produit_fournisseur_facturé = liste_produit_fournisseur_facturé;
	}

	public Ligne_Facture_Fournisseur getListe_produit_fournisseur_facturé() {
		return liste_produit_fournisseur_facturé;
	}

	public void setListe_produit_fournisseur_facturé(Ligne_Facture_Fournisseur liste_produit_fournisseur_facturé) {
		this.liste_produit_fournisseur_facturé = liste_produit_fournisseur_facturé;
	}
	
	

}
