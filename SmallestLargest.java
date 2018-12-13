
public class SmallestLargest {
	public static void main(String [] args){
		
		System.out.print("Type in terminating value (must be a number): ");
		double terminate = IO.readDouble();
		
		System.out.println("enter number: ");
		double x = IO.readDouble();
		
		if (x == terminate){
			IO.reportBadInput();
			return;
		}
		
		double minimum = x;
		double maximum = x;
		
		while(terminate != x){
		    System.out.println("enter number. to stop enter terminating value: ");
		    x = IO.readDouble();
		    
		    if(terminate != x && x < minimum){
		        minimum = x;
		    }else if(terminate != x && x > maximum){
		        maximum = x;
		    }
		}
		
		
		IO.outputDoubleAnswer(minimum);
		IO.outputDoubleAnswer(maximum);
	}
}

