//Danielle Hernandez && Mary Danielle Amora
import java.util.*;
public class LList<E> implements MyList<E>{
  private int size;
  private MyNode head;
  
  public LList(){
    MyNode head = new MyNode();
    size = 0;
  }
  
  public int size(){
    return size;
  }
  
  public void add(E element){
    if(head == null){
      head = new MyNode((String)element);
      size++;
    } else {
      add(size, element);
    }
  }

  public boolean checking(int i){
    if (i > size){
      throw new ArrayIndexOutOfBoundsException("Invalid Index");
    }
    return true;
  }
  
  public void add(int i, E item){
    if (checking(i) == true){
    //start and empty
    if (i == 0 && size == 0){
      add(item);
    }
    //add start and there are already elements present
    else if (i == 0 && size != 0){
      MyNode temp = new MyNode((String)item);
      temp.setNext(head);
      head = temp;
    }
    //add last
    else if (i == size){
      MyNode current = head;
      MyNode newNode = new MyNode((String)item);
      while(true){
        if (current.getNext() == null){
          break;
        }
        current = current.getNext();
      }
      current.setNext(newNode);
    }
    //middle
    else{
      MyNode current = head.getNext();
      MyNode previous = head;
      MyNode newNode = new MyNode((String)item);
      
      for (int j = 1; j < i; j++){
      current = current.getNext();
      previous = previous.getNext();
      }
      previous.setNext(newNode);
      newNode.setNext(current);
    }
    size++;
    }
  }
  public void set(int i, E item){
    if (checking(i) == true){
    
    MyNode current = head;
    if(i == 0){
      head.setElement((String)item);
    } else {
      for(int j = 0; j < i; j++){
        current = current.getNext();
      }
      current.setElement((String)item);
      }
    }
  }
  public E get(int i){
    if (i >= size){
      throw new ArrayIndexOutOfBoundsException("Invalid");
    }
    if (checking(i) == true){  
    
    MyNode current = head;
      if (i == 0){
        return ((E)toString(head));
      }
      else{
        for (int j = 0; j < i; j++){
        current = current.getNext();
        }
      }
    return ((E)toString(current));
    }
    return (E)"";
  }
  
   public void remove(E item){
    MyNode current = head;
    boolean value;
    int ct = 0;
    //System.out.print(item);
    //String iteme = item.toString();
    while(true){
      value = ((String)item).equals(current.getElement());
        if(value){
          remove(ct);
          break;
        }
        ct++;  
    }
  }
  
  
  public void remove(int i){
    if (i > size){
      throw new ArrayIndexOutOfBoundsException("Invalid");
    }
    if (i < size){
    //start and empty
     }  
    //remove start and there are already elements present
   if (i == 0 && size != 0){
      MyNode temp = head;
      head = head.getNext();
      temp.setNext(null);
    } else {
      MyNode current = head;
      MyNode remove = head;
      
      for(int j = 0; j < i; j++){
        remove = remove.getNext();
      }
      
      for(int j = 0; j < i-1; j++){
        current = current.getNext();
      }
      
      current.setNext(remove.getNext());
      remove.setNext(null);
      
     // System.out.println(remove.getElement() +" == "+ current.getElement());
      
      }
  size--; 
  }
     
  
  public String toString(MyNode node){
    return String.format("%s",node.getElement());
  }
  
  //MyNode Class below
  
  public class MyNode {
  
  private MyNode next;
  private String element;
  
  public MyNode(){
    //null
  }
  public MyNode (String element){
    this.element = element;
  }
    
  public MyNode getNext(){
    return next;
  }
  public void setNext(MyNode node){
    this.next = node;
  }
  
  public String getElement(){
    return element;
  }
  
  public void setElement(String element){
    this.element = element;
  }
}
  
//Iterator Here
  public Iterator<E> iterator() {
    return new LListIterator(head);
  }

  private class LListIterator implements Iterator {
    
    private MyNode current;
    private MyNode temp;
    private MyNode prev;
    private MyNode next;
    
    public LListIterator(MyNode head) {
      next = head;
      current = null;
      prev = null;
    }
    
    public Object next() {
      if (next == null) {
        throw new NoSuchElementException();
      } 
      Object element = next.getElement();
      if(current == null){
        current = next;
        next = next.getNext();
      } else { 
        prev = current;
        current = next;
        next = next.getNext();
      }
      return element;
    }
    
    public boolean hasNext() {
      return next != null;
    }
    
    public void remove(){
     if(current == null){
        throw new IllegalStateException();
      }
      
      if(prev == null){
        head = current.getNext();
        current = null;
        next = head;
        
      } else {
            current = null; 
            prev.setNext(next);
         }
    }
  }
} 
