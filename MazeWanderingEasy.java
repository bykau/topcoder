import java.util.Queue;
import java.util.LinkedList;

public class MazeWanderingEasy {
	public int decisions(String[] maze) {
		int decisions = 0;
		int N = maze.length;
		int M = maze[0].length();
		boolean[] visited = new boolean[N*M];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maze[i].charAt(j) == 'M'){
					q.add(N*i + j);
					visited[N*i + j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			int i = cur / N;
			int j = cur % N; 
			if (maze[i].charAt(j) == '*') return decisions;
			int cnt = 0;
			if (i + 1 < N && !visited[N*(i+1)+j] && maze[i+1].charAt(j) != 'X'){
				q.add(N*(i+1)+j);
				visited[N*(i+1)+j] = true;
				cnt ++;
			}
			if (i - 1 > 0 && !visited[N*(i-1)+j] && maze[i-1].charAt(j) != 'X'){
				q.add(N*(i-1)+j);
				visited[N*(i-1)+j] = true;
				cnt ++;
			}
			if (j + 1 < N && !visited[N*i+j+1] && maze[i].charAt(j+1) != 'X'){
				q.add(N*i+j+1);
				visited[N*i+j+1] = true;
				cnt ++;
			}
			if (j - 1 > 0 && !visited[N*i+j-1] && maze[i].charAt(j-1) != 'X'){
				q.add(N*i+j-1);
				visited[N*i+j-1] = true;
				cnt ++;
			}
			if (cnt > 1) decisions ++;
		}
		return decisions;
	}
	
	public static void main(String[] args){
		MazeWanderingEasy m = new MazeWanderingEasy();
		System.out.println(m.decisions(new String[]{"*.M",
 ".X."}
));
	}
}
