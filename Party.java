package CS111;

public class Party {
	public static void main(String [] args){
		
		int people;
		int slices_eat, cans_drink, slices_num, cans_num, total_Cases, total_Pies;
		
		double pizza_cost, soda_cost, total_cost, total_pies, total_cases;
		
		System.out.println("number of people attending:");
		people = IO.readInt();
		
		System.out.println("number of slices people eat: ");
		slices_eat = IO.readInt();
		
		System.out.println("number of soda cans people drinking: ");
		cans_drink = IO.readInt();
		
		System.out.println("cost of pizza pie: ");
		pizza_cost = IO.readDouble();
		
		System.out.println("number of slices in a pizza pie: ");
		slices_num = IO.readInt();
		
		System.out.println("cost of soda case: ");
		soda_cost = IO.readDouble();
		
		System.out.println("number of cans in soda case: ");
		cans_num = IO.readInt();
		
		total_pies = (people * slices_eat)/(double)slices_num;
		if(total_pies > (int)total_pies){
			total_Pies = (int)(total_pies + 1.0);
		} else{
						total_Pies = (int)total_pies;
						}
	
		total_cases = (people * cans_drink)/(double)cans_num;
		
		if(total_cases > (int)total_cases){
			total_Cases = (int)(total_cases + 1.0);
		} else{
			total_Cases = (int)total_cases;
			}
		
		total_cost = (total_Pies * pizza_cost) + (total_Cases * soda_cost);
		IO.outputDoubleAnswer(total_cost);

	}
}
