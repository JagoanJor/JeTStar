
public abstract class Type {

	private String name, flightType, destination, departure, ID;
	private int cost;
	
	public Type(String ID, String flightType, String name, String destination, String departure, int cost) {
		super();
		this.ID = ID;
		this.flightType = flightType;
		this.name = name;
		this.destination = destination;
		this.departure = departure;
		this.cost = cost;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getId() {
		return ID;
	}

	public void setId(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
