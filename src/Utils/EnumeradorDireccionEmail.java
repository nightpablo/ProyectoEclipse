package Utils;

public enum EnumeradorDireccionEmail{
	PABLO("pbarragan@frsf.utn.edu.ar"), ANDRES("and-rami@frsf.utn.edu.ar");
	
	private String email;
	
	private EnumeradorDireccionEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
}