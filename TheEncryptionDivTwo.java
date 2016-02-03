import java.util.HashMap;
import java.util.Map;

public class TheEncryptionDivTwo {
	public static String encrypt(String message){
		StringBuffer result = new StringBuffer();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int i = 0;
		Map<Character, Character> mapping = new HashMap<Character, Character>();
		for (int j = 0; j < message.length(); j++){
			if (!mapping.containsKey(message.charAt(j))){
				mapping.put(message.charAt(j), alphabet.charAt(i));
				i ++;
			}
			result.append(mapping.get(message.charAt(j)));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(encrypt("hello"));
		System.out.println(encrypt("abcd"));
		System.out.println(encrypt("topcoder"));
		System.out.println(encrypt("encryption"));
	}

}
