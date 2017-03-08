
public class PriorityQueue {
	
	static void Increase_key(int[] a , int i , int key)
	{
		if(key<=a[i])
		{
			System.out.println("New key is not larger than the existing key");
		}
		else
		{
			a[i]=key;
		}
		while(i>0)
		{
			int temp = a[i];
			a[i]=a[(i/2)-1];
			a[(i/2)-1] = temp;
			i=(i/2)-1;
		}
		
	}
	static int Extract_Max(int[] a,int n)
	{
		int max;
		if(n<0)
		{
			System.out.println("heap underflow");
			return 0;
		}
		else
		{
			 max =a[0];
		}
		int temp = a[0];
		a[0]=a[n-1];
		a[n-1]=temp;
		
		n--;
		Max_heapify(a,n,0);
		return max;
	}
	
	static void Max_heapify(int a[] ,int n,int i)
	{
		int largest =i;
		int l = 2*i+1;
		int r = 2*i+2;
		if(l<n && a[l]>a[largest])
		{
			largest =l;
		}
		if(r<n && a[r]>a[largest])
		{
			largest = r;
		}
		
		if(largest !=i)
		{
			int temp = a[i];
			a[i]=a[largest];
			a[largest]=temp;
			Max_heapify(a,n,largest);
		}
	}
	void Build_heap(int[] a, int n)
	{
		for(int i=n/2 -1;i>=0;i--)
		{
			Max_heapify(a,n-1,i);
		}
	}
	
	static void Insert(int[] a , int n,int key)
	{
		//n = a.length++;
		n=n+1;
		
		a[n] = -10000;
		
		Increase_key(a,n,key);
	}
	static void printArray(int a[],int n)
	{
		for(int i=0;i<n;i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println();
	}
	
	public static void main(String args[])
	{
		int[] a = {16,4,10,14,7,9,3,2,8,1,0};
		int n = a.length-1;
		PriorityQueue p = new PriorityQueue();
		p.Build_heap(a, n);
		System.out.println(n);
		//int t = Extract_Max(a,n);
		//System.out.println("\n\n"+ Extract_Max(a,n));
		printArray(a,n);
		Increase_key(a,3,21);
		printArray(a,n);
		//Insert(a,n,6);
		
		
	}

}
