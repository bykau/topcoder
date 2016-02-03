class QuickSums {

	public static int minSums(String numbers, int sum){
		int MAX_SUM = 101;
		int[][] aux = new int[numbers.length()][sum+1];
		for (int i = 0; i < numbers.length(); i++) {
			for (int j = 0; j <= sum; j++) {
				aux[i][j] = MAX_SUM;
			} 
		}
		for (int i = 0; i < numbers.length(); i++) {
			int entire = Integer.parseInt(numbers.substring(0, i+1));
			if (entire <= sum) aux[i][entire] = 0;

			for (int k = i-1; k >= 0; k--){
				int right = Integer.parseInt(numbers.substring(k+1, i+1));
				for (int j = 0; j <= sum; j++) {
					if (aux[k][j] < MAX_SUM && j + right <= sum) {
						if (1 + aux[k][j] < aux[i][j+right]) aux[i][j+right] = 1 + aux[k][j];
					}
				}
			}
		}
		return aux[numbers.length() - 1][sum];
	}
	
	public static void main(String[] args){
		System.out.println(minSums("99999", 45));
		System.out.println(minSums("1110", 3));
		System.out.println(minSums("0123456789", 45));
		System.out.println(minSums("99999", 100));
		System.out.println(minSums("382834", 100));
		System.out.println(minSums("9230560001", 71));
	}
}
