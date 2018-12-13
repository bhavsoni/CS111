package CS111;

public class LuckyNines {
	
	public static int countLuckyNines(int lowerEnd, int upperEnd){
		
		if(lowerEnd>upperEnd){
			return -1;
		}
		
		int count =0;
		for(int i=lowerEnd; i<=upperEnd; i++){
			int j = i;
			while(j!=0){
				int remainder = j%10;
				j = j/10;
				if(remainder==9 || remainder==-9){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String [] args){
		System.out.println("enter lower bound");
		int lowerEnd = IO.readInt();
		
		System.out.println("enter upper bound");
		int upperEnd = IO.readInt();
		
		IO.outputIntAnswer(countLuckyNines(lowerEnd, upperEnd));
		
	}
}
