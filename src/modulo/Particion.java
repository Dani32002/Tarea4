package modulo;

public class Particion {
	int n;
	
	
	public Particion(int n) {
		this.n = n;
	}
	
	public int find(int v) {
		
	}
	
	public Boolean sameSubset(int v1, int v2) {
		return find(v1) == find(v2);
	}
	
	public void union(int v1, int v2) {
		int s1 = find(v1);
		int s2 = find(v2);
	}
}
