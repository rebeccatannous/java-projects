import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BFS {

	private LinkedList[] graph;

	private int v;


	public BFS(int x) {
		v=x;
		graph = new LinkedList[x];
		weightedGraph= new LinkedList[x];
		for(int i=0; i<graph.length; i++) {
			graph[i]= new LinkedList();
		}
	}
	public void Bfs(int start) {
			boolean[] visited=new boolean[v];
			Queue q = new LinkedList();
			visited[start]=true;
			q.add(start);
			while(!q.isEmpty()) {
				int index=(int) q.poll();
				System.out.print(index + ", ");
				for(int i=0;i<graph[index].size();i++) {
					if( !visited[(int) graph[index].get(i)]) {
						visited[(int) graph[index].get(i)] = true;
						q.add((int) graph[index].get(i));
					}
				}
			}
		}
}