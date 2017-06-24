package Graph;
//its a cycle in undirected graph
import java.util.*;

 
public class CycleinGraph {
	
	static Edge[] edge;
	int V;
	int E;
	CycleinGraph(int e,int v){
		E = e;
		V=v;
		edge = new Edge[E];
		for(int i=0;i<E;i++){
			edge[i] = new Edge();
		}
	}
	class Node{
		long data;
		int rank;
		Node parent;
	}
	class disjoint_Set{
		
		private Map<Long,Node> map = new HashMap<>();
		
		public void makeSet(long data){
			Node node = new Node();
			node.data = data;
			node.rank=0;
			node.parent = node;
			map.put(data, node);
		}
		
		public long findSet(long data){
			return findSet(map.get(data)).data;
		}
		public Node findset(long data){
			return findSet(map.get(data));
		}
		private Node findSet(Node node){
			Node parent = node.parent;
			if(parent == node)
			{
				return node;
			}
			node.parent = findSet(node.parent);
			return node.parent;
		}
		public boolean Union(long data1,long data2){
			Node node1 = map.get(data1);
			Node node2 = map.get(data2);
			
			Node parent1 = findSet(node1);
			Node parent2 = findSet(node2);
			//if they are same do nothing
			if(parent1 == parent2){
				return false;
			}
			//else whoever ranks is higher make it parent
			if(parent1.rank >= parent2.rank){
				//increment rank if both sets have same rank
				parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank +1 :parent1.rank;
				parent2.parent = parent1;
			}else{
				parent1.parent = parent2;
			}
			return true;
			
		}
	}
	
	public boolean hasCycle(){
		disjoint_Set ds = new disjoint_Set();
		//make set for every vertex
		for(int i=0;i<V;i++){
			ds.makeSet(i);
		}
		
		for(int i=0;i<E;i++){
			Node rep1 = ds.findset(edge[i].from);
			Node rep2 = ds.findset(edge[i].to);
			if(rep1 == rep2){
				return true;
			}
			ds.Union(edge[i].from,edge[i].to);
			
		}
		return false;
	}
	public static void main(String args[])
	{
		CycleinGraph cig = new CycleinGraph(4,4);
		edge[0].from = 0;
		edge[0].to = 1;
		
		edge[1].from = 0;
		edge[1].to = 2;
		
		edge[2].from = 1;
		edge[2].to = 2;
		
		edge[3].from = 2;
		edge[3].to = 3;
		
		System.out.println(cig.hasCycle());
	}
}
