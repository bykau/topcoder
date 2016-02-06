/**
 * SRM 674 Div 2 Level 2
 * @author bykau
 *
 */
public class PlaneGame {
    public int bestShot(int[] x, int[] y) {
        int n = x.length;
        int max_count = 0;
        for (int i1 = 0; i1 < n; i1 ++) {
            for (int j1 = 0; j1 < n; j1++) {
                if (i1 != j1) {
                    boolean hasPerpend = false;
                    for (int i2 = 0; i2 < n; i2 ++) {
            			for (int j2 = 0; j2 < n; j2++) {
                            if (i2 != j2) {
                                if (perpend(x[i1], y[i1], x[j1], y[j1], x[i2], y[i2], x[j2], y[j2])) {
                                    hasPerpend = true;
                                    int count = 0;
                                    for (int k = 0; k < n; k++) {
                                        if (belongs(x[i1], y[i1], x[j1], y[j1], x[k], y[k]) || belongs(x[i1], y[i1], x[j1], y[j1], x[k], y[k])) count++;
                                    }
                                    if (count > max_count) max_count = count;
                                }
                            }
            			}
        			}
                    if (!hasPerpend) {
                        int count = 2;
                        for (int k = 0; k < n; k++) {                            
                        	if (!((x[i1] == x[k] && y[j1] == y[k]) || (x[j1] == x[k] && y[j1] == y[k])) && (belongs(x[i1], y[i1], x[j1], y[j1], x[k], y[k]) || belongs(x[i1], y[i1], x[j1], y[j1], x[k], y[k]))) count++;
                        }
                        if (count > max_count) max_count = count;
                    }
                }
            }
        }
        return max_count;
    }
    
    private boolean perpend(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        if ((y1-y2)/((double) (x1-x2)) == -(y3-y4)/((double) (x3-x4))) return true;
        else return false;
    }
            
    private boolean belongs(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((y1-y2)/((double) (x1-x2)) == (y2-y3)/((double) (x2 - x3))) return true;
        else return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
