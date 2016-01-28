public class TheCowDivTwo {
	public int find (int N, int K) {
		int result = 0;
		for (int i = N; i <= (N*(N-1)/2); i += N) {
			result += nSets(i, N-1, K);
		}
		return result % 1000000007;
	}

	private int nSets(int sum, int max, int k) {
		if (sum < 0 || max < 0 || k < 0) return 0;
		if (k == 0 && sum == 0) return 1;
		
		int result = nSets(sum - max, max - 1, k - 1) + nSets(sum, max - 1, k);
		System.out.println(sum + " " + max + " " + k + " " + result);
		return result;
	}
	public static void main(String[] args) {
		TheCowDivTwo t = new TheCowDivTwo();
		System.out.println(t.find(7, 4));
	}

}
