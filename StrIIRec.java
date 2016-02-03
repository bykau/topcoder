public class StrIIRec {
	public String recovstr(int n, int minInv, String minStr) {
		char[] letters = new char[n];
		for (int i = 0; i < n; i++) {
			letters[i] = (char) ('a' + i);
		}
		return rec(new String(letters), minInv);
	}
	
	private String rec(String letters, int minInv) {
		if (letters.equals("")) return "";
		int N = letters.length();
		for (int i = 0; i < N; i ++) {
			if ((N-1)*(N-2)/2 >= (minInv - i)) {
				return letters.charAt(i) + rec(letters.substring(0, i) + letters.substring(i+1,N), minInv - i);
			}
        }
        return "";
    }

	public static void main(String[] args) {
		StrIIRec s = new StrIIRec();
		System.out.println(s.recovstr(11, 1, ""));
	}

}
