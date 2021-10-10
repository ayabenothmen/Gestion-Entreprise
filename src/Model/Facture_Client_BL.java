package Model;



public class Facture_Client_BL extends Facture_Client{
	int code_bonlivr;
	float m_total_Payer;
	
	

	public Facture_Client_BL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture_Client_BL(int code,int client,String date_facture,String mode_payement,
	String type_facture,int code_bonlivr,float m_total_Payer) {
		super(code,client,date_facture,mode_payement,type_facture);
		this.code_bonlivr = code_bonlivr;
		this.m_total_Payer = m_total_Payer;
		
	}

	public int getCode_bonlivr() {
		return code_bonlivr;
	}

	public void setCode_bonlivr(int code_bonlivr) {
		this.code_bonlivr = code_bonlivr;
	}

	public float getM_total_Payer() {
		return m_total_Payer;
	}

	public void setM_total_Payer(float m_total_Payer) {
		this.m_total_Payer = m_total_Payer;
	}


	
	

}

