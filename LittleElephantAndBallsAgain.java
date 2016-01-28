
public class LittleElephantAndBallsAgain {

	public int getNumber(String S) {
		int min = S.length();
		int i = 0;
		int j = 0;
		while (i < S.length()) {
			while (S.charAt(i) == S.charAt(j) && j < S.length()) j ++;
			if ((i + S.length() - j) < min) min = i + S.length() - j;
			i = j;
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
