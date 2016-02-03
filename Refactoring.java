public class Refactoring {

	public static int refactor(int n) {
		return count(n, 2);
	}

	public static int count(int n, int lastFactor) {
	    int result = 0;
	    for (int a = lastFactor; a*a <= n; a++) 
	    if (n % a == 0) 
	        result += count(n/a, a) + 1;
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(refactor(24));
	}

}
