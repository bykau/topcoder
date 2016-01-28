package dp;

public class MinSteps {
	/* Integer.MAX_VALUE means not reachable, 
	length >= 2 */
	public static int minSteps(int[] a){
		int[] dp = new int[a.length];
		for (int i = 0; i < dp.length; i++){
			dp[i] = Integer.MAX_VALUE;
		}
		dp[dp.length-1] = 0;
		for (int i = dp.length-2; i >= 0; i--){
			for (int j = (i+1); j <= (i+a[i]) && j < dp.length; j++){
				if (dp[i] > (dp[j]+1)){
					dp[i] = dp[j] + 1;
				}
			}		
		} 
		return dp[0];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(minSteps(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));

	}

}
