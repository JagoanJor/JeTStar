
public class Business extends Type{

	private String loungeType;
	
	public Business(String ID, String flightType, String name, String destination, String departure, int cost, String loungeType) {
		super(ID, flightType, name, destination, departure, cost);
		this.loungeType = loungeType;
	}

	public String getloungeType() {
		return loungeType;
	}

	public void setloungeType(String loungeType) {
		this.loungeType = loungeType;
	}

}
