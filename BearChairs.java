import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * SRM 680 Div 2 Level 2
 * @author bykau
 *
 */
public class BearChairs {
	int FOUND = 1;
	int NOT_FOUND = 0;
	
	public int[] findPositions(int[] atLeast, int d) {
		int n = atLeast.length;
		int[] res = new int[n];
		List<Integer> sortedPos = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int STATUS = NOT_FOUND;
			for (int pos: sortedPos) {
				if (atLeast[i] <= pos - d) {
					STATUS = FOUND;
				} else if (atLeast[i] < pos + d) {
					atLeast[i] = pos + d;
				}
				if (STATUS == FOUND) break;
			}
			res[i] = atLeast[i];
			sortedPos.add(atLeast[i]);
			Collections.sort(sortedPos);
		}
		return res;
	}
}
