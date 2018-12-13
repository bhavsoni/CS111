

public class LuckySevens {
	public static void main(String [] args){
		
		System.out.println("enter lower bound");
		int lowbound = IO.readInt();
		
		System.out.println("enter upper bound");
		int upbound = IO.readInt();
		
		int count = 0;
		
		if(upbound<lowbound){
			IO.reportBadInput();
			return;
		}
		
		for(int i = lowbound; i<=upbound; i++){
			int j = i;
			while(j!=0){
				int remainder = j%10;
				j=j/10;
				if(remainder == 7 || remainder ==-7){
					count++;
				}
			}
		}
		IO.outputIntAnswer(count);
	}
}
