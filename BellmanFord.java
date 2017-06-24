package Graph;
import java.util.*;
public class BellmanFord {
	int V;
	int E;
	class Edge{
		int from,to;
		int weight;
	}
	
	Edge[] edge;
	
	BellmanFord(int v, int e){
		V=v;
		E=e;
		edge = new Edge[E];
		for(int i=0;i<e;i++){
			edge[i] = new Edge();
		}
	}
	
	public void getShortestPath(int sourceVertex){
		Map<Integer,Integer> distance = new HashMap<>();
		Map<Integer,Integer> parent = new HashMap<>();
		
		for(int i=0;i<V;i++){
			distance.put(i, Integer.MAX_VALUE);
			parent.put(i,null);
		}
		distance.put(sourceVertex,0);
		
		for(int i=0;i<V-1;i++){
			for(int j=0;j<E;j++){
				int u = edge[j].from;
				int v = edge[j].to;
				//System.out.println(u+" "+v+" "+edge[j].weight);
				
				if(distance.get(u) + edge[j].weight < distance.get(v) ){
					distance.put(v,distance.get(u)+edge[j].weight);
					parent.put(v, u);
				}
			}
		}
		//to check if there is a negative weight in the cycle
		//if there is , then we still get lesser distance
		System.out.println(distance);
		for(int i=0;i<E;i++){
			int u = edge[i].from;
			int v = edge[i].to;
			if(distance.get(u) + edge[i].weight < distance.get(v)){
				System.out.println("There is a negative weight in the cycle");
				break;
			}
		}
	}
	
	public static void main(String[] args){
		BellmanFord bf = new BellmanFord(5,7);
		bf.edge[0].from =0;
		bf.edge[0].to =1;
		bf.edge[0].weight =4;
		
		bf.edge[1].from =0;
		bf.edge[1].to =2;
		bf.edge[1].weight =8;
		
		bf.edge[2].from =0;
		bf.edge[2].to =3;
		bf.edge[2].weight =5;
		
		bf.edge[3].from =1;
		bf.edge[3].to =2;
		bf.edge[3].weight =-3;
		
		bf.edge[4].from =2;
		bf.edge[4].to =4;
		bf.edge[4].weight =4;
		
		bf.edge[5].from =3;
		bf.edge[5].to =4;
		bf.edge[5].weight =2;
		
		bf.edge[6].from =4;
		bf.edge[6].to =3;
		bf.edge[6].weight =1;
		
		bf.getShortestPath(0);
	}
	
}
