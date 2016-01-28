import java.util.Arrays;

class FoxAndMp3Easy {
	public static String[] playList(int n){
		String[] arr = new String[n];
		for (int i = 1; i <= n; i++) arr[i-1] = i+".mp3";
		Arrays.sort(arr);
		if (arr.length <= 50) {
			return arr;
		} else {
			return Arrays.copyOf(arr, 50);
		}
	}
	
	public static void main(String[] args){
		for(String el: playList(32)){
			System.out.println(el);
		}
	}
}
