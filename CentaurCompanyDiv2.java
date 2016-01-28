import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CentaurCompanyDiv2 {
	Map<Integer, List<Integer>> children = new HashMap<Integer, List<Integer>>();

	public long count(int[] a, int[] b) {
		int N = a.length + 1;
		Queue<Integer> q = new LinkedList<Integer>();		
		boolean[] visited = new boolean[N];
		
		q.add(1);
		visited[1 - 1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			List<Integer> curChildren = new ArrayList<Integer>();
			visited[cur - 1] = true;
			for (int i = 0; i < (N-1); i ++){
				if (a[i] == cur && !visited[b[i] - 1]) {
					visited[b[i] - 1] = true;
					curChildren.add(b[i]);
					q.add(b[i]);
				}
				if (b[i] == cur && !visited[a[i] - 1]) {
					visited[a[i] - 1] = true;
					curChildren.add(a[i]);
					q.add(a[i]);
				}
			}
			children.put(cur, curChildren);
		}
		return cnt(1, true) + cnt(1, false);
	}
	
	private long cnt(int root, boolean isHuman) {
		long allCnt = 0;
		long horseCnt = 0;
		for (int child: children.get(root)) {
			long human = cnt(child, true);
			long horse = cnt(child, false);
			if (allCnt == 0) allCnt = (human + horse);
			else allCnt *= (human + horse);
			if (horseCnt == 0) horseCnt = horse;
			else horseCnt *= horse;
		}
		if (isHuman) return allCnt - horseCnt + 1;
		else return allCnt + 1;
	}

	public static void main(String[] args) {
		CentaurCompanyDiv2 c = new CentaurCompanyDiv2();
		System.out.println(c.count(new int[]{1}, new int[]{2}));
	}

}
