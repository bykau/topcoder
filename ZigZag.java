class ZigZag{
	public static int longestZigZag(int[] sequence){
		int N = sequence.length;
		if (N < 2) {
			return 1;	
		}
		int[] pos = new int[N];
		int[] neg = new int[N];
		pos[N-1] = 1;
		neg[N-1] = 1;
		int max = 1;
		for (int i = N-2; i >= 0; i--){
			int max_pos = 1;
			int max_neg = 1;
			for (int j = i+1; j < N; j++){
				if (sequence[j] - sequence[i] > 0) {
					if (1 + neg[j] > max_pos) {
						max_pos = 1 + neg[j];
					}
				} else if (sequence[j] - sequence[i] < 0){
					if (1 + pos[j] > max_neg) {
						max_neg = 1 + pos[j];
					}
				}
			}
			pos[i] = max_pos;
			neg[i] = max_neg;
			if (max < max_pos) {
				max = max_pos;
			}
			if (max < max_neg) {
				max = max_neg;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] a1 = new int[]{ 1, 7, 4, 9, 2, 5 };
		System.out.println(longestZigZag(a1));
		int[] a2 = new int[]{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		System.out.println(longestZigZag(a2));
		int[] a3 = new int[]{ 44 };
		System.out.println(longestZigZag(a3));
		int[] a4 = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(longestZigZag(a4));
		int[] a5 = new int[]{ 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
		System.out.println(longestZigZag(a5));
		int[] a6 = new int[]{ 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
		System.out.println(longestZigZag(a6));
	}
}
