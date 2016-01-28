import java.util.Arrays;
import java.util.Comparator;

class GUMIAndSongsDiv2 {
	public static int maxSongs (int[] duration, int[] tone, int T) {
		int N = duration.length;
		Node[] arr = new Node[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new Node(duration[i], tone[i]);
		}
		Arrays.sort(arr, new Comparator<Node> () {
			@Override
			public int compare(Node n1, Node n2) {
				if (n1.tone == n2.tone) {
					return n1.duration - n2.duration;
				} else {
					return n1.tone - n2.tone;
				}
			}
		});
		int count = (int) Math.pow(2, N);
		int maxSongs = 0;
		for (int i = 0; i < count; i++) {
			int firstTone = 0;
			int lastTone = 0;
			int length = 0;
			int nSongs = 0;
			for (int j = 0; j < N; j++) {
				boolean isFirst = true;
				if (((i >> j) & 1) == 1) {
					if (isFirst) {
						firstTone = arr[j].tone;
						isFirst = false;
					}
					length += arr[j].duration;
					lastTone = arr[j].tone;
					nSongs ++;	
				}
			}
			if (T >= length + (lastTone - firstTone) && nSongs > maxSongs) {
				maxSongs = nSongs;
			}
		}
		return maxSongs;
	}

	public static class Node {
		int duration;
		int tone;

		public Node(int duration, int tone){
			this.duration = duration;
			this.tone = tone;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(maxSongs(new int[]{3, 5, 4, 11}, new int[]{2, 1, 3, 1}, 17));
		System.out.println(maxSongs(new int[]{100, 200, 300}, new int[]{1, 2, 3}, 10));
		System.out.println(maxSongs(new int[]{1, 2, 3, 4}, new int[]{1, 1, 1, 1}, 100));
		System.out.println(maxSongs(new int[]{10, 10, 10}, new int[]{58, 58, 58}, 30));
		System.out.println(maxSongs(new int[]{8, 11, 7, 15, 9, 16, 7, 9}, new int[]{3, 8, 5, 4, 2, 7, 4, 1}, 14));
		System.out.println(maxSongs(new int[]{5611,39996,20200,56574,81643,90131,33486,99568,48112,97168,5600,49145,73590,3979,94614}, new int[]{2916,53353,64924,86481,44803,61254,99393,5993,40781,2174,67458,74263,69710,40044,80853}, 302606));
	}
}

