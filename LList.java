//Created by: Mary Danielle Amora and Danielle Hernandez
//This code is based on our previous code --> AList.java

import java.util.*;
  
public class LList implements MyList{
  private String[] items;
  private int count;
  private int size = 10;
  
  public LList() {
    items = new String[size];
    count = 0;
  }
  
  public void increase(){
  
     String[] tempArr = Arrays.copyOf(items, items.length+1);
     items = Arrays.copyOf(tempArr, tempArr.length);
     
  }
  
  public void add(String item) {
    items[count++] = item;
      increase();
  }
  public void add(int i, String item) {
    if(i <= count){
      count++;
      for (int x = count; x > i; x--){
        items[x]  = items[x - 1];
      }
    
      items[i] = item;
    
    } else if (count == 0 || i > count) {
      throw new IndexOutOfBoundsException();
    }
  }
  
  public String get(int i) {
    if (count == 0 || i >= count) {
      throw new IndexOutOfBoundsException();
    }
    return items[i];
  }
  
  public void remove(int i) {
    for (; i <= count; i++){
     items[i] = items[i+1]; 
    }
    count--;
  }
  
  public void remove(String item){
    for (int x = 0; x < count; x++){
      if (item.compareTo(items[x]) == 0){
        remove(x);
      }
    }
  }
  
  public void set(int i, String item) {
    items[i] = item;
  }
 
  
}