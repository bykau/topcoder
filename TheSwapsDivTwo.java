public class TheSwapsDivTwo {
	public int find (int[] sequence) {
		int N = sequence.length;
		int[] cnt = new int[48];
		boolean unique = true;
		for (int i = 0; i < N; i++) {
			cnt[sequence[i]] ++;
			if (cnt[sequence[i]] > 1) unique = false;
		}
		int result = 0;
		for (int i = 0; i <=47; i++) {
			result += cnt[i] * (N - cnt[i]);
		}
		if (unique) {
			return result /2 ;
		} else 
			return result / 2 + 1;
	}
}
