
public class Economy extends Type{

	private int baggageCost;
	
	public Economy(String ID, String flightType, String name, String destination, String departure, int cost, int baggageCost) {
		super(ID, flightType, name, destination, departure, cost);
		this.baggageCost = baggageCost;
	}

	public int getBaggageCost() {
		return baggageCost;
	}

	public void setBaggageCost(int baggageCost) {
		this.baggageCost = baggageCost;
	}
	
}
