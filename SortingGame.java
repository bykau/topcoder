import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SortingGame {
	int[] board;
	int k;
	
	public int fewestMoves(int[] board, int k) {
		this.board = board;
		this.k = k;
		Set<String> visited = new HashSet<String>();
		Queue<Node> q = new LinkedList<Node>();
		visited.add(board2Str(board));
		q.add(new Node(board, 0));
		int[] finalStateArr = new int[board.length];
		for (int i = 0; i < board.length; i++) finalStateArr[i] = i + 1;
		String finalState = board2Str(finalStateArr);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (finalState.equals(board2Str(cur.board))) return cur.dist;
			for (int[] next: getNextPos(cur.board)) {
				if (!visited.contains(board2Str(next))) {
					visited.add(board2Str(next));
					q.add(new Node(next, cur.dist + 1));
				}
			}
		}
		return -1;
	}

	private int[][] getNextPos(int[] pos) {
		int[][] res = new int[pos.length - k + 1][];
		for (int i = 0; i <= pos.length - k; i ++) {
			int[] newPos = new int[pos.length];
			for (int j = 0; j < pos.length; j ++) newPos[j] = pos[j];
			for (int j = 0; j < k; j++) newPos[i+j] = pos[i + k - 1 - j];
			res[i] = newPos;
		}
		return res;
	}

	private String board2Str(int[] board) {
		StringBuffer sb = new StringBuffer();
		for(int el: board) sb.append(el);
		return sb.toString();
	}

	public static class Node {
		int[] board;
		int dist;
		
		public Node(int[] board, int dist) {
			this.board = board;
			this.dist = dist;
		}
	}

}
