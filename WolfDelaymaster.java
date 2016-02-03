public class WolfDelaymaster {
	
	public static String check(String str){
		if (str.length() == 0) {
			return "VALID";
		}
		int n = 0;
		while (str.charAt(n) == 'w') n++;
		if (n == 0) return "INVALID";
		StringBuffer pattern = new StringBuffer();
		for (char c: new char[]{'w','o','l','f'}){
			for (int i = 0; i < n; i++){
				pattern.append(c);
			}
		}
		if (str.substring(0, 4*n).equals(pattern.toString()) && check(str.substring(4*n, str.length())).equals("VALID")){
			return "VALID";
		} else {
			return "INVALID";
		}
	}

	public static void main(String[] args) {
		System.out.println(check("wolf"));
		System.out.println(check("wwolfolf"));
		System.out.println(check("wolfwwoollffwwwooolllfffwwwwoooollllffff"));
		System.out.println(check("flowolf"));
	}

}
