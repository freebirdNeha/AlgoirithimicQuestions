import java.util.*;
import java.lang.*;
import java.io.*;

class HamiltonianPathAdjMatrix {
    private static int v;
    private static LinkedList<Integer> adj[];
    public static boolean flag = false;
	
	
    @SuppressWarnings("unchecked")
    HamiltonianPathAdjMatrix(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }

    }

    @SuppressWarnings("unchecked")
    public void addEdge(int start, int end) {
        adj[start].add(end);
        adj[end].add(start);
    }
    
    @SuppressWarnings("unchecked")
	public static void main (String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
        int noOfTestcases = sc.nextInt();
        while (noOfTestcases > 0) {
            flag = false;
            int vertices = sc.nextInt();
            int noOfEdges = sc.nextInt();
            HamiltonianPathAdjMatrix g = new HamiltonianPathAdjMatrix(vertices);
            while (noOfEdges > 0) {
                g.addEdge(sc.nextInt() - 1, sc.nextInt() - 1);
                noOfEdges--;
            }
            g.getHamiltonianPath();
            System.out.println(flag?"1":"0");
            noOfTestcases--;
        }
		
	}
	
	@SuppressWarnings("unchecked")
	public void getPath(int i, boolean visited[], List<Integer> path) {
        if(path.size() == v) {
            flag = true;
        }
        Iterator<Integer> it = adj[i].listIterator();
        while(it.hasNext()) {
            int temp = it.next();
            if(!visited[temp]) {
                visited[temp] = true;
                path.add(temp);
                getPath(temp, visited, path);
                visited[temp] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void getHamiltonianPath() {
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++) {
            visited[i] = false;
        }
        List<Integer> path = new ArrayList<Integer>();
        for(int i = 0; i < v; i++) {
            visited[i] = true;
            path.add(i);
            getPath(i, visited, path);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
        
    }
}
