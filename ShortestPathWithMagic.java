public class ShortestPathWithMagic {
	public double getTime(String[] dist, int k) {
		int n = dist.length;
		int[] minDist = new int[n*(k+1)];
		boolean[] visited = new boolean[n*(k+1)];
		for (int i = 0; i < minDist.length; i ++) minDist[i] = Integer.MAX_VALUE;
		minDist[0+k] = 0;
		for (int i = 0; i < minDist.length; i ++) {
			int curMinNode = -1;
			int curMinDist = Integer.MAX_VALUE;
			for (int j = 0; j < minDist.length; j ++) {
				if (!visited[j] && minDist[j] < curMinDist) {
					curMinDist = minDist[j];
					curMinNode = j;
				}
			}
			if (curMinNode == -1) break;
			int curI = curMinNode / (k+1);
			int curK = curMinNode % (k+1);
			if (curK == 0) {
				for (int j = 0; j < n; j++) {
					if (!visited[j*(k+1)] && j != curI && minDist[curMinNode] + Character.getNumericValue(dist[curI].charAt(j))*2 < minDist[j*(k+1)]) {
						minDist[j*(k+1)] = minDist[curMinNode] + Character.getNumericValue(dist[curI].charAt(j))*2;
					}
				} 
			} else {
				for (int j = 0; j < n; j++) {
					if (!visited[j*(k+1) + curK - 1] && j != curI && minDist[curMinNode] + Character.getNumericValue(dist[curI].charAt(j)) < minDist[j*(k+1) + curK - 1]) {
						minDist[j*(k+1) + curK - 1] = minDist[curMinNode] + Character.getNumericValue(dist[curI].charAt(j));
					}
				}
			}
			visited[curMinNode] = true;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= k; i ++) {
			if (minDist[k+1+i] < result) result = minDist[k+1+i];
		}
		return result/((double) 2);
	}
	
	public static void main(String[] args){
		ShortestPathWithMagic s = new ShortestPathWithMagic();
		System.out.println(s.getTime(new String[]{"094", "904", "440"}, 2));
	}
}
