package utils;

public class Session {
	private String email;
	private String language;
	private static Session session;
	
	private Session(){}
	
	public static Session getInstance(){
		if(session == null){
			session = new Session();
		}
		return session;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	

}
