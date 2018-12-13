package CS111;

public class PayFee {
	public static void main(String[] args){
		double user_payment, fee;
		
		System.out.println("Enter payment amount: ");
		user_payment = IO.readDouble();
		
		if(user_payment <= 500){
			fee = 10;
		} else if(user_payment>500 && user_payment<5000){
			if((user_payment*0.01) > 20){
				fee = user_payment*0.01;
			} else{
				fee = 20;
			}		
		} else if(user_payment>= 5000 && user_payment<10000){
			if(user_payment*0.02 > 120){
				fee = user_payment*0.02;
			} else{
				fee = 120;
			}
		} else{
			if(user_payment == 10000){
				fee = 200;
			}else if(user_payment>10000 && user_payment<= 15000){
				fee = ((user_payment-10000)*0.03) + 200;
			} else{
				fee = ((user_payment - 15000)*0.04)+350;
			}
		}
		IO.outputDoubleAnswer(fee);
	}
}
