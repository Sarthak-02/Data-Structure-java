import java.util.*;
import java.util.Scanner;
import java.io.*;


class Link{
	int data;
	Link next; //next node
	//Link constructor 
	Link(int d)   
	{
      data =d;
      next = null;

	}
}

class LinkList{
	Link head ;

	LinkList()
	{
		head= null;
	}

	void Insert(int d,int n)
	{
		Link link = new Link(d);
   		//link.next=null;
		if(n==1)
		{
			link.next = head;
		head = link;
	   }
       else
       {
        Link link1;
        link1=head;
        for(int i=0; i<n-2; i++)
        {
        	link1 = link1.next;
        }
         link.next = link1.next;
         link1.next = link;
       }
		
	}
	void Delete(int n)
	{
		Link current = head;
		for(int i=0;i<n-2;i++)
		{
			current = current.next;
		}
		Link current1 = current.next;
		current.next = current1.next;
		current1.next = null;
	}
	void  Middle()
	{
		Link fast = head;
		Link slow = head;

		while(fast.next != null )
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println("The Middle of the List is "+ slow.data);
	}

	void PrintList()
	{
		Link current = head;
		System.out.println("LIST \n");
		while(current != null)
		{
			System.out.print(current.data);
			current = current.next;
			
		}

	}
}



class Link_List{
	public static void main(String args[])
	{
		LinkList link = new LinkList();
        link.Insert(1,1);
        link.Insert(2,1);
        link.Insert(3,2);
        link.Insert(4,1);
        link.Insert(5,3);
        link.PrintList();
         System.out.println();
         link.Middle();

        link.Delete(3);
        //link.Middle();
        System.out.println();
        link.PrintList();
        System.out.println();
	}
}



