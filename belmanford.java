import java.util.*;
public class belmanford
{
	public static final int max_value=999;
	private int no_vertices;
	private int[] dist;
	
	public belmanford(int no_vertices)
	{
		this.no_vertices=no_vertices;
		dist=new int [no_vertices+1];
	}
	public static void main(String args[])
	{
	Scanner in = new Scanner(System.in);
	int source;
	int no_vertices;
	int[][] adj;
	System.out.println("Enter number of vertices: ");
	no_vertices = in.nextInt();
	adj = new int[no_vertices+1][no_vertices+1];
	System.out.println("Enter adjacency matrix:");
	for(int i=0;i<no_vertices;i++)
	for(int j=0;j<no_vertices;j++)
	{
        	adj[i][j] = in.nextInt();
		if(i==j)
		{
			adj[i][j] = 0;
			continue;
		}
		if(adj[i][j]==0)
		adj[i][j]=max_value;
	}
	System.out.println("Enter source vertex");
	source = in.nextInt();
	belmanford b = new belmanford(no_vertices);
	b.belmanfordEvaluation(adj, source);
	in.close();
	}
	public void belmanfordEvaluation(int[][] adj, int source)
	{
	for(int node=0; node<no_vertices; node++)
	dist[node] = max_value;
	dist[source] = 0;
	for(int node=0;node<no_vertices; node++)
	for(int sn=0; sn<no_vertices; sn++)
	for(int dn=0; dn<no_vertices; dn++)
	{
		if(adj[sn][dn]!=max_value)
		if(dist[dn] > dist[sn]+adj[sn][dn])
		dist[dn] = dist[sn]+adj[sn][dn];
	}
	for(int sn=0; sn<no_vertices; sn++)
	for(int dn=0; dn<no_vertices; dn++)
	{
		if(adj[sn][dn]!=max_value)
		if(dist[dn] > dist[sn]+adj[sn][dn])
		System.out.println("Contains negative edges!!!");
	}
	for(int vertex=0; vertex<no_vertices; vertex++)
	System.out.println("Shortest distance from source "+source+" to "+vertex+" is "+dist[vertex]);
	}
}

Output:
Enter the number of vertices 4
Enter the adjacency matrix 
0	5	0	0
5	0	3	4
0	3	0	2
0	4	2	0
Enter the source vertex 2
Distance of source 2 to 1 is 5
Distance of source 2 to 2 is 0
Distance of source 2 to 3 is 3
Distance of source 2 to 4 is 4

