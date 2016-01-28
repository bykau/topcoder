import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class Boxing {
	public int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e) {
		Map<Integer, Integer> punches = new TreeMap<Integer, Integer>();
		for (int x: a) {
			if (!punches.containsKey(x)) punches.put(x, 1);
			else punches.put(x, punches.get(x) | 1);
		}
		for (int x: b) {
			if (!punches.containsKey(x)) punches.put(x, 2);
			else punches.put(x, punches.get(x) | 2);
		}
		for (int x: c) {
			if (!punches.containsKey(x)) punches.put(x, 4);
			else punches.put(x, punches.get(x) | 4);
		}
		for (int x: d) {
			if (!punches.containsKey(x)) punches.put(x, 8);
			else punches.put(x, punches.get(x) | 8);
		}
		for (int x: e) {
			if (!punches.containsKey(x)) punches.put(x, 16);
			else punches.put(x, punches.get(x) | 16);
		}
		
		List<Map.Entry<Integer, Integer>> sortedPunches = new ArrayList<Map.Entry<Integer, Integer>>();
		for (Map.Entry<Integer, Integer> punch: punches.entrySet()) {
			sortedPunches.add(punch);
		}
		
		int cnt = 0;
		int from = 0;
		int to = 0;
		while (to < sortedPunches.size()) {
			if (sortedPunches.get(to).getKey() - sortedPunches.get(from).getKey() <= 1000) {
				if (getNJudges(sortedPunches, from, to) >= 3) {
					cnt ++;					
					from = to + 1;
					to = to + 1;
				} else {
					to ++;
				}
			} else {
				from ++;
			}
		}
		return cnt;
	}
	
	private int getNJudges(List<Map.Entry<Integer, Integer>> punches, int from, int to) {
		int curJudges = 0;
		for (int i = from; i <= to; i++) 
			curJudges |= punches.get(i).getValue();
		return Integer.bitCount(curJudges);
	}
	
	public static void main(String[] args) {
//		System.out.println(maxCredit(new int[]{100,200,300,1200,6000},
//				new int[]{},
//				new int[]{900,902,1200,4000,5000,6001},
//				new int[]{0,2000,6002},
//				new int[]{1,2,3,4,5,6,7,8}));
	}
}