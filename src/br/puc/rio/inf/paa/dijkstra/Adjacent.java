package br.puc.rio.inf.paa.dijkstra;

public class Adjacent {

	public int vertex;
	public int distance;

	public Adjacent(int vertex, int cost) {
		this.vertex = vertex;
		this.distance = cost;
	}

}