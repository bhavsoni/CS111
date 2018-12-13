
public class TwoLargest {
	public static void main(String [] args){
		System.out.println("enter terminate value: ");
		double terminate = IO.readDouble();
		
		System.out.println("enter number x: ");
		double x = IO.readDouble();
		
		while(x==terminate){
			IO.reportBadInput();
			System.out.println("enter x again ");
			x = IO.readDouble();
		}
		
		System.out.println("enter number y: ");
		double y = IO.readDouble();
		
		while(y==terminate){
			IO.reportBadInput();
			System.out.println("enter y again ");
			y = IO.readDouble();
		}
		
		double largest, large;
		
		if(x>y){
			largest = x;
			large = y;
		}else if(x==y){
			large =x;
			largest =x;
		}else{
			largest = y;
			large = x;
		}
		
		
		while(x !=terminate){
			System.out.println("enter number ");
			x = IO.readDouble();
			
			if(x > large && x!= terminate){
				if(x > largest && x!=terminate){
					large = largest;
					largest = x;
					
				}else if(x!=terminate){
					large = x;
				}
			}
		}
		IO.outputDoubleAnswer(largest);
		IO.outputDoubleAnswer(large);
	}
}
	