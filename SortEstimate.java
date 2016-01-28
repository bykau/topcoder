package search;

public class SortEstimate {
	public double howMany(int c, int time) {
		return search(1, 2000000000, c, time);
	}

	private double search(double from, double to, int c, int time) {
		System.out.println(from + " " + to);
		double mid = (to + from) / 2;
		System.out.println(mid);
		if (to/from < 1 + 1e-14) {
			return mid;
		} else if (c * mid * Math.log(mid)/Math.log(2) < time) {
			return search(mid, to, c, time);
		} else return search(from, mid, c, time);
	}	
	
	public static void main(String[] args) {
		SortEstimate se = new SortEstimate();
		System.out.println(se.howMany(1, 2000000000));
	}

}
