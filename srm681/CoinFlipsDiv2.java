package srm681;

public class CoinFlipsDiv2 {
	public int countCoins(String state) {
		int n = state.length();
		int res = 0;
		for (int i = 0; i < n; i++) {
			boolean interesting = false;
			if (i-1 >= 0 && state.charAt(i-1) != state.charAt(i)) interesting = true;
			if (i+1 < n && state.charAt(i+1) != state.charAt(i)) interesting = true;
			if (interesting) res ++;
		}
		return res;
	}
}
