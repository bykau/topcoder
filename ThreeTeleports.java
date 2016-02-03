import java.util.ArrayList;
import java.util.List;

public class ThreeTeleports {
	public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
		int shortest = Math.abs(xMe - xHome) + Math.abs(yMe - yHome);
		for (String t: teleports) {
			String[] coors = t.split(" ");
			int x1 = Integer.parseInt(coors[0]);
			int y1 = Integer.parseInt(coors[1]);
			int x2 = Integer.parseInt(coors[2]);
			int y2 = Integer.parseInt(coors[3]);
			int ent1 = Math.abs(xMe - x1) + Math.abs(yMe - y1) + 10 + shortestDistance(x2, y2, xHome, yHome, minus(teleports, t));
			int ent2 = Math.abs(xMe - x2) + Math.abs(yMe - y2) + 10 + shortestDistance(x1, y1, xHome, yHome, minus(teleports, t));
			if (ent1 < shortest && ent1 > 0) shortest = ent1;
			if (ent2 < shortest && ent2 > 0) shortest = ent2;
		}
		return shortest;
	}

	private String[] minus(String[] arr, String el) {
		List<String> res = new ArrayList<String>();
		for (String s: arr) {
			if (!s.equals(el)) res.add(s);
		}
		return res.toArray(new String[res.size()]);
	}
	
	public static void main(String[] args) {
		ThreeTeleports t = new ThreeTeleports();
		System.out.println(t.shortestDistance(3, 3, 4, 5, new String[]{"1000 1001 1000 1002", "1000 1003 1000 1004", "1000 1005 1000 1006"}
));
	}

}
