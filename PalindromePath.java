package dp;

public class PalindromePath {

	public int shortestLength(int n, int[] a, int[] b, String c) {
		char[][] edges = new char[n][n];
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				edges[i][j] = '-';
				dp[i][j] = Integer.MAX_VALUE;
			}
			dp[i][i] = 0;
		}
		for (int i = 0; i < a.length; i ++) {
			edges[a[i]][b[i]] = c.charAt(i);
			edges[b[i]][a[i]] = c.charAt(i);
			dp[a[i]][b[i]] = 1;
			dp[b[i]][a[i]] = 1;
		}
		
		for (int l = 2; l <= n*(n-2)/2; l ++) {
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j++) {
					if (dp[i][j] < Integer.MAX_VALUE) {
						for (int aa = 0; aa < n; aa ++) {
							for (int bb = 0; bb < n; bb ++) {
								if (edges[aa][i] == edges[bb][j] && edges[aa][i] != '-') {
									int newMin = 2 + dp[i][j];
									if (newMin < dp[aa][bb]) dp[aa][bb] = newMin;
								}
							}
						}
					}
				}
			}			
		}
		if (dp[0][1] < Integer.MAX_VALUE) 
			return dp[0][1];
		else 
			return -1;
	}
	
	public static void main(String[] args) {
		PalindromePath p = new PalindromePath();
		System.out.println(p.shortestLength(5, new int[]{2,2,0,3,4}, new int[]{0,1,3,4,1}, "abxyx"));
	}

}
