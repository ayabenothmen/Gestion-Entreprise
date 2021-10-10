package Connexion;

import Model.*;

public class Requettes {
	
	public static String ajouter_entreprise(Entreprise ent) {
		return "INSERT INTO entreprise VALUES ('"
				+ ent.getMatricule_fiscale()
				+ "','"
				+ ent.getRaison_social()
				+"','"
				+ ent.getType()
				+"','"
				+ ent.getDescription_activité()
				+"','"
                + ent.getCompte_bancaire()
                +"','"
                + ent.getAdresse()
                +"','"
                + ent.getNum_tel_fixe()
                +"','"
                + ent.getNum_tel_mobile()
                +"','"
                + ent.getFax()
                +"','"
                 + ent.getEmail()
                +"','"
                 + ent.getSite_web()
                +"','"
                 + ent.getDonnée_etat_fiscale()
                + "');";
		
	}
	
	public static String modifier_entreprise(Entreprise entUp) {
		return "UPDATE entreprise SET raison_sociale='" + entUp.getRaison_social() + "', type='"
				+ entUp.getType() + "', description_activite='" + entUp.getDescription_activité()
				+ "', compte_bancaire='" + entUp.getCompte_bancaire() 
			    + "', adresse='" + entUp.getAdresse()
				+ "', num_tel_fixe='" + entUp.getNum_tel_fixe()
				+ "', num_tel_mobile='" + entUp.getNum_tel_mobile()
				+ "', fax='" + entUp.getFax()
				+ "', email='" + entUp.getEmail()
				+ "', site_web='" + entUp.getSite_web()
				+ "', etat_fiscale='" + entUp.getDonnée_etat_fiscale()
				+ "' WHERE matricule_fiscale='" + entUp.getMatricule_fiscale()
				+ "';";
	}
	
	public static String ajouter_devis(Devis devis) {
		 return "INSERT INTO devis (date,code_client,ligne_devis,m_total_TVA,m_total_hors_TVA,"
	        		+ "m_total_Payer)VALUES ('"
	                + devis.getDate()
	                + "','"
	                + devis.getCode_client()
	                + "','"
	                + devis.getLigne_devis()
	                + "','"
	                + devis.getM_total_TVA()
	                + "','"
	                + devis.getM_total_hors_TVA()
	                + "','"
	                + devis.getM_total_Payer()+"');";
	}
	
	 public static String modifier_devis(Devis devisUp) {
	        return "UPDATE devis SET date='" + devisUp.getDate() + "', code_client='"
	                + devisUp.getCode_client() + "',"
	                + "ligne_devis='"+devisUp.getLigne_devis()+"',"
	                + "m_total_TVA='"+devisUp.getM_total_TVA()+"',"
	                + "m_total_hors_TVA='"+devisUp.getM_total_hors_TVA()+"',"
	                + "m_total_Payer='"+devisUp.getM_total_Payer()
	                + "' WHERE code='" + devisUp.getCode()
	                + "';";
	    }
	
	
	
	public static String ajouter_client(Client client) {
		return "INSERT INTO client VALUES ('"
				+ client.getCode()
				+ "','"
				+ client.getMatricule_fiscale()
				+ "','"
				+ client.getRaison_social()
				+ "','"
				+ client.getType()
				+ "','"
				+ client.getDescription_activité()
				+ "','"
				+ client.getCompte_bancaire()
				+ "','"
				+ client.getAdresse()
				+ "','"
				+ client.getNum_tel_fixe()
				+ "','"
				+ client.getNum_tel_mobile()
				+ "','"
				+ client.getFax()
				+ "','"
				+ client.getEmail()
				+ "','"
				+ client.getSite_web()
				+ "','"
				+ client.getDonnée_etat_fiscale()+"');";
	}
	
	public static String modifier_client(Client clientUp) {
		return "UPDATE client SET matricule_fiscale='" + clientUp.getMatricule_fiscale() + "',"
				+ "raison_sociale='" + clientUp.getRaison_social() + "', type='"
				+ clientUp.getType() + "', description='" + clientUp.getDescription_activité()
				+ "', compte_bancaire='" + clientUp.getCompte_bancaire() 
			    + "', adresse='" + clientUp.getAdresse()
				+ "', num_tlf_fixe='" + clientUp.getNum_tel_fixe()
				+ "', num_tlf_mobile='" + clientUp.getNum_tel_mobile()
				+ "', fax='" + clientUp.getFax()
				+ "', email='" + clientUp.getEmail()
				+ "', site_web='" + clientUp.getSite_web()
				+ "', etat_fiscale='" + clientUp.getDonnée_etat_fiscale()
				+ "' WHERE code='" + clientUp.getCode()
				+ "';";
	}
	
	public static String ajouter_fournisseur(Fournisseur fournisseur) {
		return "INSERT INTO fournisseur VALUES ('"
				+ fournisseur.getCode()
				+ "','"
				+ fournisseur.getMatricule_fiscale()
				+ "','"
				+ fournisseur.getRaison_social()
				+ "','"
				+ fournisseur.getType()
				+ "','"
				+ fournisseur.getDescription_activité()
				+ "','"
				+ fournisseur.getCompte_bancaire()
				+ "','"
				+ fournisseur.getAdresse()
				+ "','"
				+ fournisseur.getNum_tel_fixe()
				+ "','"
				+ fournisseur.getNum_tel_mobile()
				+ "','"
				+ fournisseur.getFax()
				+ "','"
				+ fournisseur.getEmail()
				+ "','"
				+ fournisseur.getSite_web()
				+ "','"
				+ fournisseur.getDonnée_etat_fiscale()+"');";
	}
	
	public static String modifier_fournisseur(Fournisseur fournisseurUp) {
		return "UPDATE fournisseur SET matricule_fiscale='" + fournisseurUp.getMatricule_fiscale() + "',"
				+ "raison_sociale='" + fournisseurUp.getRaison_social() + "', type='"
				+ fournisseurUp.getType() + "', description='" + fournisseurUp.getDescription_activité()
				+ "', compte_bancaire='" + fournisseurUp.getCompte_bancaire() 
			    + "', adresse='" + fournisseurUp.getAdresse()
				+ "', num_tlf_fixe='" + fournisseurUp.getNum_tel_fixe()
				+ "', num_tlf_mobile='" + fournisseurUp.getNum_tel_mobile()
				+ "', fax='" + fournisseurUp.getFax()
				+ "', email='" + fournisseurUp.getEmail()
				+ "', site_web='" + fournisseurUp.getSite_web()
				+ "', etat_fiscale='" + fournisseurUp.getDonnée_etat_fiscale()
				+ "' WHERE code='" + fournisseurUp.getCode()
				+ "';";
	}
	
	public static String stock_min() {
		return "SELECT * FROM produit where stock < stock_min " ;
		}
	
	public static String ajouter_produit(Produit produit) {
		return "INSERT INTO produit VALUES ('"
				+ produit.getCode()
				+ "','"
				+ produit.getReference()
				+ "','"
				+ produit.getDesignation()
				+ "','"
				+ produit.getUnité_mesure()
				+ "','"
				+ produit.getFournisseur()
				+ "','"
				+ produit.getFamille_produit()
				+ "','"
				+ produit.getStock()
				+ "','"
				+ produit.getStock_min()
				+ "','"
				+ produit.getPU_hors_taxe()
				+ "','"
				+ produit.getTva()+"');";
	}
	

	public static String modifier_produit(Produit produitUp) {
		return "UPDATE produit SET ref='" + produitUp.getReference() + "', designation='"
				+ produitUp.getDesignation() + "', unite_mesure='" + produitUp.getUnité_mesure() + "',"
				+ "fournisseur='" + produitUp.getFournisseur()+"', famille_produit='"
				+produitUp.getFamille_produit() + "',"
			    + "stock='"+produitUp.getStock()+ "',"
			    + "stock_min='"+produitUp.getStock_min()+ "',"
			    + "PU_hors_taxe='"+produitUp.getPU_hors_taxe()+"',"
			    + "TVA='"+produitUp.getTva()
				+ "' WHERE code='" + produitUp.getCode()
				+ "';";
	}
	 public static String ajouter_bon_livraison(Bon_livraison bonlivraison1) {
	        return "INSERT INTO bon_livraison (code_client,date_bon,date_livraison,adresse_livraison,num_cmd_vente,ligne_bl,m_total_TVA,m_total_hors_TVA,"
	        		+ "m_total_Payer)VALUES ('"
	               /* + bonlivraison1.getCode()
	                + "','"*/
	                + bonlivraison1.getCodeclient()
	                + "','"
	                + bonlivraison1.getDate_bon()
	                + "','"
	                + bonlivraison1.getDate_livraison()
	                + "','"
	                + bonlivraison1.getAdresse_livraison()
	                + "','"
	                + bonlivraison1.getNum_cmd_vente()
	                + "','"
	                + bonlivraison1.getLigne_bl()
	                + "','"
	                + bonlivraison1.getM_total_TVA()
	                + "','"
	                + bonlivraison1.getM_total_hors_TVA()
	                + "','"
	                + bonlivraison1.getM_total_Payer()+"');";
	    }
	
	public static String modifier_bon_livraison(Bon_livraison bonlivraisonUp) {
		return "UPDATE bon_livraison SET code_client='" + bonlivraisonUp.getCodeclient() + "', date_bon='"
				+ bonlivraisonUp.getDate_bon() + "', date_livraison='" + bonlivraisonUp.getDate_livraison() + "',"
				+ "adresse_livraison='" + bonlivraisonUp.getAdresse_livraison()+"', num_cmd_vente='"
				+bonlivraisonUp.getNum_cmd_vente() + "',"
			    + "ligne_bl='"+bonlivraisonUp.getLigne_bl()+"',"
			    + "m_total_TVA='"+bonlivraisonUp.getM_total_TVA()+"',"
			    + "m_total_hors_TVA='"+bonlivraisonUp.getM_total_hors_TVA()+"',"
			    + "m_total_Payer='"+bonlivraisonUp.getM_total_Payer()
				+ "' WHERE code='" + bonlivraisonUp.getCode()
				+ "';";
	}


	
	public static String ajouter_bon_reception(Bon_reception bonreception) {
		return "INSERT INTO bon_reception VALUES ('"
				+ bonreception.getCode()
				+ "','"
				+ bonreception.getCodefournisseur()
				+ "','"
				+ bonreception.getDate_bon()
				+ "','"
				+ bonreception.getDate_reception()
				+ "','"
				+ bonreception.getAdresse_reception()
				+ "','"
				+ bonreception.getNum_cmd_achat()
				+ "','"
				+ bonreception.getLigne_br()
				+ "','"
				+ bonreception.getM_total_TVA()
				+ "','"
				+ bonreception.getM_total_hors_TVA()
				+ "','"
				+ bonreception.getM_total_Payer()+"');";
	}
	
	public static String modifier_bon_reception(Bon_reception bonreceptionUp) {
		return "UPDATE bon_reception SET code_fournisseur='" + bonreceptionUp.getCodefournisseur() + "', date_bon='"
				+ bonreceptionUp.getDate_bon() + "', date_reception='" + bonreceptionUp.getDate_reception() + "',"
				+ "adresse_reception='" + bonreceptionUp.getAdresse_reception()+"', num_cmd_achat='"
				+bonreceptionUp.getNum_cmd_achat() + "',"
			    + "ligne_br='"+bonreceptionUp.getLigne_br()+"',"
			    + "m_total_TVA='"+bonreceptionUp.getM_total_TVA()+"',"
			    + "m_total_hors_TVA='"+bonreceptionUp.getM_total_hors_TVA()+"',"
			    + "m_total_Payer='"+bonreceptionUp.getM_total_Payer()
				+ "' WHERE code='" + bonreceptionUp.getCode()
				+ "';";
	}
	
	public static String ajouter_ligne_BR(Ligne_BR ligneBR) {
        return "INSERT INTO ligne_br VALUES ('"
                + ligneBR.getRef()
                + "','"
                + ligneBR.getCode_Fournisseur()
                + "','"
                + ligneBR.getDesignation()
                + "','"
                + ligneBR.getUnite_mesure()
                + "','"
                + ligneBR.getQte_receptionnee()
                + "','"
                + ligneBR.getPU_hors_TVA()
                + "','"
                + ligneBR.getTVA()
                + "','"
                + ligneBR.getP_total_horsTVA()+"');";
    }
   
    public static String modifier_ligneBR(Ligne_BR ligneBRUp) {
        return "UPDATE ligne_br SET code_fournisseur='" + ligneBRUp.getCode_Fournisseur() + "', designation='"
                + ligneBRUp.getDesignation() + "', unite_mesure='" + ligneBRUp.getUnite_mesure() + "',"
                + "qte_receptionnee='" + ligneBRUp.getQte_receptionnee()+"', PU_hors_TVA='"
                +ligneBRUp.getPU_hors_TVA() + "',"
                + "TVA='"+ligneBRUp.getTVA()+ "',"
                + "P_total_horsTVA='"+ligneBRUp.getP_total_horsTVA()
                + "' WHERE ref='" + ligneBRUp.getRef()
                + "';";
    }
    public static String ajouter_ligne_BL(Ligne_BL ligneBL) {
        return "INSERT INTO ligne_bl VALUES ('"
                + ligneBL.getRef()
                + "','"
                + ligneBL.getCode_client()
                + "','"
                + ligneBL.getDesignation()
                + "','"
                + ligneBL.getUnite_mesure()
                + "','"
                + ligneBL.getQte_livree()
                + "','"
                + ligneBL.getPU_hors_TVA()
                + "','"
                + ligneBL.getTVA()
                + "','"
                + ligneBL.getP_total_horsTVA()+"');";
    }
   
    public static String modifier_ligneBL(Ligne_BL ligneBLUp) {
        return "UPDATE ligne_bl SET code_client='" + ligneBLUp.getCode_client() + "', designation='"
                + ligneBLUp.getDesignation() + "', unite_mesure='" + ligneBLUp.getUnite_mesure() + "',"
                + "qte_receptionnee='" + ligneBLUp.getQte_livree()+"', PU_hors_TVA='"
                +ligneBLUp.getPU_hors_TVA() + "',"
                + "TVA='"+ligneBLUp.getTVA()+ "',"
                + "P_total_horsTVA='"+ligneBLUp.getP_total_horsTVA()
                + "' WHERE ref='" + ligneBLUp.getRef()
                + "';";
    }
    public static String ajouter_ligne_Devis(Ligne_devis ligneDevis) {
		return "INSERT INTO ligne_devis VALUES ('"
				+ ligneDevis.getRef()
				+ "','"
				+ ligneDevis.getCode_client()
				+ "','"
				+ ligneDevis.getDesignation()
				+ "','"
				+ ligneDevis.getUnite_mesure()
				+ "','"
				+ ligneDevis.getQte_receptionnee()
				+ "','"
				+ ligneDevis.getPU_hors_TVA()
				+ "','"
				+ ligneDevis.getTVA_appliquee()
				+ "','"
				+ ligneDevis.getP_total_horsTVA()+"');";
	}
	
	public static String modifier_ligneDevis(Ligne_devis ligneDevisUp) {
		return "UPDATE ligne_devis SET code_client='" + ligneDevisUp.getCode_client() + "', designation='"
				+ ligneDevisUp.getDesignation() + "', unite_mesure='" + ligneDevisUp.getUnite_mesure() + "',"
				+ "qte_receptionnee='" + ligneDevisUp.getQte_receptionnee()+"', PU_hors_TVA='"
				+ligneDevisUp.getPU_hors_TVA() + "',"
			    + "TVA_appliquee='"+ligneDevisUp.getTVA_appliquee()+ "',"
			    + "P_total_horsTVA='"+ligneDevisUp.getP_total_horsTVA()
				+ "' WHERE ref='" + ligneDevisUp.getRef()
				+ "';";
	}
	
	public static String ajouter_facture_fournisseur_BL(Facture_Fournisseur_BL factureBL) {
		return "INSERT INTO facture_fournisseur_bl VALUES ('"
				+ factureBL.getCode()
				+ "','"
				+ factureBL.getFournisseur()
				+ "','"
				+ factureBL.getDate_facture()
				+ "','"
				+ factureBL.getMode_payement()
				+ "','"
				+ factureBL.getType_facture()
				+ "','"
				+ factureBL.getCode_bonrecep()
				+ "','"
				+factureBL.getM_total_Payer()
				+ "','"
				+factureBL.getM_Payer()
				+ "','"
				+factureBL.getM_Reste()
				+"');";
	}
	
	public static String modifier_facture_fournisseur_BL(Facture_Fournisseur_BL factureBLModif) {
		return "UPDATE facture_fournisseur_bl SET code_fournisseur='" + factureBLModif.getFournisseur() + "', date_facture='"
				+ factureBLModif.getDate_facture()+ "', mode_payement='" + factureBLModif.getMode_payement() + "',"
				+ "type_facture='" + factureBLModif.getType_facture()+"', code_bon_recep='"
				+factureBLModif.getCode_bonrecep() + "',"
			    + "m_total_Payer='"+factureBLModif.getM_total_Payer()+ "',"
			    + "m_Payer='"+factureBLModif.getM_Payer()+ "',"
			    + "m_Reste='"+factureBLModif.getM_Reste()
				+ "' WHERE code='" + factureBLModif.getCode()
				+ "';";
	}
	
	public static String ajouter_facture_client_BL(Facture_Client_BL factureCBL) {
		return "INSERT INTO facture_client_bl VALUES ('"
				+ factureCBL.getCode()
				+ "','"
				+ factureCBL.getClient()
				+ "','"
				+ factureCBL.getDate_facture()
				+ "','"
				+ factureCBL.getMode_payement()
				+ "','"
				+ factureCBL.getType_facture()
				+ "','"
				+ factureCBL.getCode_bonlivr()
				+ "','"
				+factureCBL.getM_total_Payer()
				+"');";
	}
	
	public static String modifier_facture_client_BL(Facture_Client_BL factureBLModif) {
		return "UPDATE facture_client_bl SET code_client='" + factureBLModif.getClient() + "', date_facture='"
				+ factureBLModif.getDate_facture()+ "', mode_payement='" + factureBLModif.getMode_payement() + "',"
				+ "type_facture='" + factureBLModif.getType_facture()+"', code_bonlivr='"
				+factureBLModif.getCode_bonlivr() + "',"
			    + "m_total_Payer='"+factureBLModif.getM_total_Payer()
			    + "' WHERE code='" + factureBLModif.getCode()
				+ "';";
	}
	
	public static String ajouter_facture_avoir(Facture_avoir factureavoirAdd) {
		return "INSERT INTO facture_avoir VALUES ('"
				+ factureavoirAdd.getCode()
				+ "','"
				+ factureavoirAdd.getCode_client()
				+ "','"
				+ factureavoirAdd.getDate_facture()
				+ "','"
				+ factureavoirAdd.getMode_payement()
				+ "','"
				+ factureavoirAdd.getCode_facture_client()
				+ "','"
				+ factureavoirAdd.getQteRetour()
				+ "','"
				+ factureavoirAdd.getDesigProd()
				+ "','"
				+ factureavoirAdd.getMTPayer()
				+ "','"
				+ factureavoirAdd.getMRetour()
				+ "','"
				+factureavoirAdd.getMAR()
				+"');";
	}
	
	public static String modifier_facture_avoir(Facture_avoir factureavoirModif) {
		return "UPDATE facture_avoir SET code_client='" + factureavoirModif.getCode_client() + "', date_facture='"
				+ factureavoirModif.getDate_facture()+ "', mode_payement='" + factureavoirModif.getMode_payement() + "',"
				+ "code_facture_client='" + factureavoirModif.getCode_facture_client()+"', qte_retour='"
				+factureavoirModif.getQteRetour() + "',desig_prod='" 
				+factureavoirModif.getDesigProd() + "',MTPayer='"
				+factureavoirModif.getMTPayer() + "',MRetour='"
				+factureavoirModif.getMRetour() + "',"
			    + "MAR='"+factureavoirModif.getMAR()
			    + "' WHERE code='" + factureavoirModif.getCode()
				+ "';";
	}
	
	
		

}
