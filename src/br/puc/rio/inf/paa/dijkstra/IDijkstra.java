package br.puc.rio.inf.paa.dijkstra;

public interface IDijkstra {

	public void initialize(GraphInstance graph, int start);

	public int getMin();

	public int[] getDistanceTotal();

	public int[] getPath();

	public void relax(int from, int to, int distance);
	
	public void setVisited(int vertice);
	
}
