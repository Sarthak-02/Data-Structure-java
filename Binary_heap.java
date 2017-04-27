package heap;

public class Binary_Heap {
	
	static void build_heap(int[] arr)
	{
		int n = arr.length;
		for(int i=n-1;i>=0;i--)
		{
			Max_heapify(arr,i,n);
		}
		
	}

	
	static void Max_heapify(int[] arr,int i,int n)
	{
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left <n && arr[left] > arr[largest])
		{
			largest=left;
		}
		if(right <n && arr[right]> arr[largest])
		{
			largest = right;
		}
		if(largest != i)
		{
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			Max_heapify(arr,largest,n);
		}
		
	}
	
	static void print_build(int[] arr)
	{
		for(int i =0 ; i< arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static void heap_extract_max(int[] arr)
	{
		int n = arr.length;
		if(n<1)
		{
			System.out.println("heap underflow");
		}
		int max = arr[0];
		arr[0] = arr[n-1];
		n=n-1;
		Max_heapify(arr,1,n);
		System.out.println("Max element is "+max);
	}
	
	static void max_heap_insert(int arr[] , int key)
	{
		int n = arr.length;
		n++;
		arr[n] = Integer.MIN_VALUE;
		heap_increase_key(arr,n,key);
	}
	static void heap_increase_key(int[] arr , int i, int key)
	{
		int n =i;
		if(key<arr[i])
		{
			System.out.println("new key is smaller than the current key");
		}
		else
		{
			arr[i] = key;
		}
		
		while(i>0 && arr[i/2 -1] < arr[i])
		{
			int temp = arr[i];
			arr[i] = arr[i/2 - 1];
			arr[i/2 -1] = temp;
			i = i/2-1;
		}
		print_build(arr);
	}
	public static void main(String args[])
	{
		int[ ] arr = { 1, 2, 3, 4, 7, 8, 9, 10, 14, 16 };
		build_heap(arr); //building the max heap
		print_build(arr); //print the heap
		heap_extract_max(arr); // extract the max element in the heap
		max_heap_insert(arr,15);//insert the element
	}
}
