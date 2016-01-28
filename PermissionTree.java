package tree;

public class PermissionTree {

	public int[] findHome(String[] folders, String[] users) {
		assert 1 <= folders.length && folders.length <= 50;
		assert 1 <= users.length && users.length <= 50;
		
		int[] homeFolders = new int[users.length];
		int[] parents = new int[folders.length];
		String[][] permissions = new String[folders.length][];
		
		for (int i = 0; i < folders.length; i++) {
			String[] items = folders[i].split(" ");
			parents[i] = Integer.parseInt(items[0]);
			permissions[i] = items[1].split(",");
		}
		
		for (int i = 0; i < users.length; i++) {
			int home = -1;
			for (int j = 0; j < permissions.length; j++) {
				if (!accessible(users[i], permissions[j])) continue;
				home = (home == -1) ? j : findNearestCommonAncestor(home, j, parents);
			}
			homeFolders[i] = home;
		}
		return homeFolders;
	}

	private int findNearestCommonAncestor(int home, int j, int[] parents) {
		for (int p = home; p > 0; p = parents[p]) {
			for (int q = j; q > 0; q = parents[q]) {
				if (q == p) return p;
			}
		}
		return 0;
	}

	private boolean accessible(String u, String[] users) {
		for (int i = 0; i < users.length; i++)
			if (u.equals(users[i])) return true;
		return false;
	}

}
