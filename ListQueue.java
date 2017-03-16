package listqueue;

import java.util.ArrayList;
import java.util.*;

  
public class ListQueue<E> 
{ 
    private ArrayList <E> list;
    	
public ListQueue() 
{  // EFFECTS: The Constructor creates a new empty Array List list
    list = new ArrayList ();
}
    	
public void enqueue (E element) throws NullPointerException
{ 
    //REQUIRES: A null element should not be inserted into the list
    //MODIFIES: list
    //EFFECTS: If the element passed is not null, then it is added to the list, otherwise it throws a NULLPOINTEREXCEPTION	
   if(element.equals("null"))
       throw new NullPointerException("enqueue(): Do not pass Null value");
   else
   {
       list.add(element);
   }
}
 
       
public E dequeue() throws IllegalStateException
  {
      //REQUIRES: The list should not be empty
      //MODIFIES: list
      //EFFECS: It deletes the first element from the list and shifts all elements to the left by one position and  
	//         returns the modified list.It decrements the index by 1. It throws an IllegalStateException if list is empty.
            if( list.isEmpty())
            throw new IllegalStateException("dequeue(): List is empty");
            
            return list.remove(0);
            
        }
    
public int length() 
{ 
    //EFFECTS: It returns the size of the list.
    return list.size(); }
    
    public void reverse() 
    {
        //MODIFIES: list
	//EFFECTS: The elements in the list are reversed. This method uses the third Arraylist l2 to reverse the list
        int length=list.size()-1;
        ArrayList <E> l2=new ArrayList<>();
        for(int i=length;i>=0;i--)
        {
            l2.add(list.remove(i));
           
        }
        
       int len2=l2.size();
        for(int i=0;i<len2;i++)
        {
            list.add(l2.get(i));    
        }
        
    }
    public void append(ListQueue<E> s) 
    {
        //REQUIRES: An ArrayList s
	//MODIFIES: list
	//EFFECTS: The elements in ArrayList s is appended at the end of the ArrayList list.
        int size=s.length();
        for(int i=0;i<size;i++)
        {
            list.add(s.dequeue());
        }
    }
    public E swapFront(E element) throws IllegalStateException
   {
       //REQUIRES: An element to be placed at the first position
        //MODIFIES: list
	//EFFECTS: If the list is non-empty then it swaps the element with the element at the first position of the list 
	//         and returns the entire list otherwise throws a IllegalStateException
                if (list.isEmpty())
                throw new IllegalStateException("swapFront(): List is empty");
                
                E item = list.get(0);    
                list.set(0, element);
                return (E) list;
                
                
    }



    
    public static void main(String[] args) 
{
      ListQueue lq= new ListQueue();
      lq.enqueue(1);
      lq.enqueue(2);
      lq.enqueue(3);
      lq.enqueue(4);
      lq.enqueue(5);
      lq.enqueue(6);
      
      lq.enqueue(7);
      lq.dequeue();
      lq.enqueue(8);
      lq.dequeue();
      
     System.out.println(lq.length());
     
     ListQueue lq1= new ListQueue();
     lq1.enqueue(10);
     lq1.enqueue(11);
     lq1.enqueue(12);
     lq1.enqueue(14);
     
 
     lq.append(lq1);       
     
     
     lq.swapFront(100);
   
     }
      

    }

