package CS111;

public class Compress {
	public static void main(String[] args){
		System.out.println(compress("qqwwwwwwwwweeeeerrtyyyyyqqqqwEErTTT"));
		System.out.println(compress("apple"));
		System.out.println(compress("piineapplee"));
		System.out.println(compress("nigga"));
		System.out.println(compress("balloon"));
		System.out.println(compress("CCCCaaatttriiinndskjsjjjs ttthhhfff sssddd"));
		
		System.out.println(alphabet("hello", "hi"));
	}
	
	
	public static String compress(String original){
		int count = 1;
		String result = "";
		char initial = original.charAt(0);
		for(int i=1; i<original.length(); i++){
			if(initial==original.charAt(i)){
				count++;
			} else{
				result = result + count + initial;
				initial = original.charAt(i);
				count = 1;
			}
		}
		result = result + count + initial;
		
		return result.replaceAll("1", "");
	}
	
	public static String alphabet(String str1, String str2){
		if(str1.compareTo(str2)>0){
			return str1;
		}else{
			return str2;
		}
	}
}
