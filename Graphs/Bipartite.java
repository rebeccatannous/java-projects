import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Bipartite {
	private LinkedList[] graph;

	private int v;


	public Bipartite(int x) {
		v=x;
		graph = new LinkedList[x];
		weightedGraph= new LinkedList[x];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new LinkedList();
		}
	}

    public boolean selfLoop(int x) {
		if(graph[x].contains(x))
			return true;
		return false;
	}
    
    public boolean isBipartite(int start) {
		int colors[] = new int[v]; //1 is blue, -1 is red, the array is filled with 0s by default
		boolean[] visited=new boolean[v];
		colors[start]=1;  
		Queue q = new LinkedList();
		visited[start]=true;
		q.add(start);
		while(!q.isEmpty()) {
			int index=(int) q.poll();
			for(int i=0;i<graph[index].size();i++) {

				if( colors[(int) graph[index].get(i)]==0) {
					colors[(int) graph[index].get(i)]=colors[index]*-1;
					visited[(int) graph[index].get(i)] = true;
					q.add((int) graph[index].get(i));
				}else {
					if(colors[index]==colors[(int) graph[index].get(i)])
						return false;
					if(selfLoop((int) graph[index].get(i)))
						return false;
				}
			}
		}
		return true;
	}
}