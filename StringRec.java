

public class StringRec {
	
	public static String decompress(String compressedText){
		
		String decom = "";
		char index;
		
		if(compressedText.length() <= 1 || compressedText == "" || compressedText == null){
			return compressedText;
		}
		
		index = compressedText.charAt(0);
		
		if(Character.isDigit(index)){
			if(index != '0'){
				index--;
				decom += compressedText.charAt(1) + decompress(index+compressedText.substring(1));
				
			}else {
				decom += decompress(compressedText.substring(2));
			}
		} else {
			decom += compressedText.charAt(0) + decompress(compressedText.substring(1)); 
		}
		return decom;
	}
}
