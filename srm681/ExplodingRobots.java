package srm681;

import java.util.HashSet;
import java.util.Set;

public class ExplodingRobots {
	public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
		int n = instructions.length();
		Set<Coor> pos1 = new HashSet<Coor>();
		Set<Coor> pos2 = new HashSet<Coor>();
		
		pos1.add(new Coor(x1, y1));
		pos2.add(new Coor(x2, y2));
		for (int i = 0; i < n; i ++) {
			char inst = instructions.charAt(i);
			
			Set<Coor> newPos1 = new HashSet<Coor>();
			for (Coor from: pos1) {
				newPos1.add(from);
				if (inst == 'U') newPos1.add(new Coor(from.x, from.y+1));
				if (inst == 'D') newPos1.add(new Coor(from.x, from.y-1));
				if (inst == 'L') newPos1.add(new Coor(from.x-1, from.y));
				if (inst == 'R') newPos1.add(new Coor(from.x+1, from.y));
			}
			
			Set<Coor> newPos2 = new HashSet<Coor>();
			for (Coor from: pos2) {
				newPos2.add(from);
				if (inst == 'U') newPos2.add(new Coor(from.x, from.y+1));
				if (inst == 'D') newPos2.add(new Coor(from.x, from.y-1));
				if (inst == 'L') newPos2.add(new Coor(from.x-1, from.y));
				if (inst == 'R') newPos2.add(new Coor(from.x+1, from.y));
			}
			
			for (Coor c: newPos1) {
				if (newPos2.contains(c)) return "Explosion";
			}
			
			pos1 = newPos1;
			pos2 = newPos2;
		}
		return "Safe";
	}
	
	public static class Coor {
		int x;
		int y;
		
		public Coor(int x, int y){
			this.x = x; 
			this.y = y;
		}
		
		@Override
		public int hashCode() {
	        int result = (int) (x ^ (x >>> 32));
	        result = 31 * result + (int) (y ^ (y >>> 32));
	        return result;
		}
		
		@Override
		public boolean equals(Object obj) {
		        Coor that = (Coor) obj;
		        if (x != that.x) return false;
		        if (y != that.y) return false;
		        return true;
		}
		
		@Override
		public String toString() {
			return x + "," + y;
		}
	}
}
