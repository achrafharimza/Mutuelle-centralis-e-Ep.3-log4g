package models;



public class Client {
	
	private String Nbadge ;
	private String NomEntreprise ;
	private String DateDebut;
	private String Prenom ;
	private String Nom ;
	private String CNIPassport ;
	private String Phone ;
	private String Email ;
	private String Adresse ;
	
	public Client(String nbadge, String nomEntreprise, String dateDebut, String prenom, String nom, String cNIPassport,
			String phone, String email, String adresse) {
		super();
		Nbadge = nbadge;
		NomEntreprise = nomEntreprise;
		DateDebut = dateDebut;
		Prenom = prenom;
		Nom = nom;
		CNIPassport = cNIPassport;
		Phone = phone;
		Email = email;
		Adresse = adresse;
	}

	public String getNbadge() {
		return Nbadge;
	}

	public void setNbadge(String nbadge) {
		Nbadge = nbadge;
	}

	public String getNomEntreprise() {
		return NomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		NomEntreprise = nomEntreprise;
	}

	public String getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(String dateDebut) {
		DateDebut = dateDebut;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getCNIPassport() {
		return CNIPassport;
	}

	public void setCNIPassport(String cNIPassport) {
		CNIPassport = cNIPassport;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	
	
	

}
