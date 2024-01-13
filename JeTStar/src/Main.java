import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<Type> list = new ArrayList<Type>();
	
	int choose;
	String id, name, destination, departure, loungeType, flightType;
	int cost, baggageCost, counter = 0;
	
	public Main() {
		// TODO Auto-generated constructor stub
		System.out.println("JeTStar Flights");
		System.out.println("================");
		do {
			
			System.out.println("1. Add flight");
			System.out.println("2. View all flights");
			System.out.println("3. Delete flight");
			System.out.println("4. Exit");
			System.out.print(">> ");
			choose = scan.nextInt();
			scan.nextLine();
			
			
			switch (choose) {
			case 1:
				AddFlight();
				break;

			case 2:
				ViewFlight();
				break;
				
			case 3:
				DeleteFlight();
				break;
			}
			
		} while (choose != 4);
	}
	
	private void AddFlight() {
		
		int ftype = 0;
		do {
			System.out.println();
			System.out.println("Choose type of the flights : ");
			System.out.println("1. Economy Class");
			System.out.println("2. Business Class");
			System.out.println("3. Back");
			System.out.print(">> ");
			ftype = scan.nextInt();
			scan.nextLine();
		} while (ftype < 0 || ftype > 3);
		
		if (ftype == 3) {
			return;
		}
		
		do {
			System.out.print("Flight name [ends with 'Airlines'] : ");
			name = scan.nextLine();
		} while (!name.endsWith("Airlines"));
		
		do {
			System.out.print("Flight destination [5 - 25 characters] : ");
			destination = scan.nextLine();
		} while (destination.length() < 5 || destination.length() > 25);
		
		do {
			System.out.print("Flight departure place [cannot same with flight destination] : ");
			departure = scan.nextLine();
		} while (departure.equalsIgnoreCase(destination));
		
		do {
			System.out.print("Input cost [more than 0] : ");
			cost = scan.nextInt();
			scan.nextLine();
		} while (cost < 0);
		
		String var = String.format("%03d", counter++);
		id = "FL" + var;
		
		if (ftype == 1) {
			flightType = "Economy";
			do {
				System.out.print("Input baggage cost [more than 0] : ");
				baggageCost = scan.nextInt();
				scan.nextLine();
			} while (baggageCost < 0);
			
			Economy econ = new Economy(id, flightType, name, destination, departure, Price(cost, baggageCost), baggageCost);
			list.add(econ);
		}
		else {
			flightType = "Business";
			do {
				System.out.print("Input lounge type [bar | buffet | restaurant] : ");
				loungeType = scan.nextLine();
			} while (!(loungeType.equals("bar") || loungeType.equals("restaurant") || loungeType.equals("buffet")));
			
			Business busi = new Business(id, flightType, name, destination, departure, Price(cost, loungeType), loungeType);
			list.add(busi);
		}
		counter++;
		System.out.println();
	}
	
	private void ViewFlight() {
		if(list.isEmpty()) {
			System.out.println();
			System.out.println("========================================");
			System.out.println("|             Flights List             |");
			System.out.println("========================================");
			System.out.println("|     There's no flights right now     |");
			System.out.println("========================================");
			System.out.println();
		}
		else {
			System.out.println("=============================================================================================================================================");
			System.out.println("|                                                         Flights List                                                                      |");
			System.out.println("=============================================================================================================================================");
			System.out.println("| No  | Flight ID  | Name                 | Total Cost | Destination          | Departure Place        | Baggage Cost         | Lounges     |");
			System.out.println("=============================================================================================================================================");
			
			for(int i=0 ; i<list.size(); i++) {
				if(list.get(i).getFlightType().equals("Economy")) {
					System.out.printf("|  %d  | %s      | %-20s | %-10d | %-20s | %-20s   | %-20d | -           |\n", i+1, list.get(i).getId(), list.get(i).getName(), 
							list.get(i).getCost(), list.get(i).getDestination(), list.get(i).getDeparture(), ((Economy) list.get(i)).getBaggageCost());
				}
				else {
					System.out.printf("|  %d  | %s      | %-20s | %-10d | %-20s | %-20s   | -                    | %-10s  |\n", i+1, list.get(i).getId(), list.get(i).getName(), 
							list.get(i).getCost(), list.get(i).getDestination(), list.get(i).getDeparture(), ((Business) list.get(i)).getloungeType());
				}
			}
			System.out.println("=============================================================================================================================================");
			scan.nextLine();
		}
	}
	
	private void DeleteFlight() {
		if(list.isEmpty()) {
			System.out.println();
			System.out.println("========================================");
			System.out.println("|             Flights List             |");
			System.out.println("========================================");
			System.out.println("|     There's no flights right now     |");
			System.out.println("========================================");
			System.out.println();
		}
		else {
			int deleteIndex = -1;
			do {
				System.out.print("Put input flight Number to delete [1 - " + list.size() + "] (0 to back) : ");
				deleteIndex = scan.nextInt();
				scan.nextLine();
			} while (deleteIndex < 0 || deleteIndex > list.size());
			
			list.remove(deleteIndex -1);
			System.out.println("Succesfully deleted TinTin Airlines [press enter]");
			scan.nextLine();
		}
	}

	private int Price(int costt, int baggage) {
		int totalPrice = costt + baggage;
		return totalPrice;
	}
	
	private int Price(int costt, String lounge) {
		int totalPrice = 0;
		
		if(lounge.equals("bar")) {
			totalPrice = (int) Math.round(costt * 1.5);
		}
		else if (lounge.equals("restaurant")) {
			totalPrice = costt * 2;
		}
		else if (lounge.equals("buffet")) {
			totalPrice = (int) Math.round(costt * 2.5);
		}
		
		return totalPrice;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
