import java.util.HashMap;
import java.util.Map;

class ShortPalindromes {
	public static Map<String, String> memo = new HashMap<String, String>();

	public static String shortest(String base) {
		if (memo.containsKey(base)) return memo.get(base);
		int N = base.length();
		if (N <= 1) {
			return base;
		}
		
		if (base.charAt(0) == base.charAt(N - 1)) {
			return base.charAt(0) + shortest(base.substring(1, N-1)) + base.charAt(N-1);
		}

		String right =  base.charAt(0) + shortest(base.substring(1, N)) + base.charAt(0);
		String left =  base.charAt(N-1) + shortest(base.substring(0, N-1)) + base.charAt(N-1);
		
		String result;
		if (right.length() < left.length()){
			result = right;
		} else if (right.length() > left.length()) {
			result = left;
		} else if (left.compareTo(right) > 0) {
			result = right;
		} else {
			result = left;
		}
		memo.put(base, result);
		return result;	
	}
	
	public static void main(String[] args) {
		System.out.println(shortest("RACE"));
		System.out.println(shortest("TOPCODER"));
		System.out.println(shortest("Q"));
		System.out.println(shortest("MADAMIMADAM"));
		System.out.println(shortest("ALRCAGOEUAOEURGCOEUOOIGFA"));
	}
}
