import java.util.HashSet;
import java.util.Set;

public class CyclicWords {
	public int differentCW(String[] words) {
		Set<String> seen = new HashSet<String>();
		for (String word: words) seen.add(signature(word));
		return seen.size();
	}

	private String signature(String word) {
		char min = word.charAt(0);
		int pos = 0;
		for (int i = 1; i < word.length(); i ++) {
			if (min >= word.charAt(i) && word.charAt(i - 1) != word.charAt(i)) {
				min = word.charAt(i);
				pos = i;
			} 
		}
		if (pos == -1) return word;
		else return word.substring(pos, word.length()) + word.substring(0, pos);
	}
	
	public static void main(String[] args){
		CyclicWords cw = new CyclicWords();
		System.out.println(cw.differentCW(new String[]{ "picture", "turepic", "icturep", "word", "ordw" }));
	}
}
