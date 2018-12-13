package CS111;

/* 
Write your code in the file PigLatin.java. 
Your code should go into a method with the following signature. 
You may write your own main method to test your code. 
The graders will ignore your main method:

public static String translate (String original){}

"Pig Latin" is a fake language used as a children's game. 
A word in English is "translated" into Pig Latin using the following 
rules:

If the English word begins with a consonant, move the consonant to the end 
of the word and add "ai". The letter Y should be considered a consonant.

If the English word begins with a vowel (A, E, I, O, or U), simply add "vai" 
to the end of the word.
(This is a simplified dialect of Pig Latin, of course.)

Write your method so that it returns the pig latin translated original string. 
You may assume that the input does not contain digits, punctuation, or spaces. 
The input may be in any combination of uppercase or lowercase. 
The case of your output does not matter.

*/

public class PigLatin {
	public static void main(String[] args){
		System.out.println(translate("apple"));
		System.out.println(translate("elephant"));
		System.out.println(translate("igloo"));
		System.out.println(translate("orange"));
		System.out.println(translate("umbrella"));
		System.out.println(translate("baseball"));
		System.out.println(translate("cat"));
		System.out.println(translate("dog"));
		System.out.println(translate("flag"));
		System.out.println(translate("ghost"));
		System.out.println(translate("hat"));
		System.out.println(translate("jack"));
		System.out.println(translate("kite"));
		System.out.println(translate("yay"));
		
	}

	
	public static String translate (String original) {
		if(original.charAt(0) == 'a' || original.charAt(0) == 'e' || original.charAt(0) == 'i' || original.charAt(0) == 'o' || original.charAt(0) == 'u' ){
			return (original+"vai"); 
		} else{
			char firstLetter = original.charAt(0);
			String newString = original.substring(1);
			return (newString + firstLetter + "ai");
		}

	}
}
