public interface MyList<E> extends Iterable<E> { //1
   public void add(E item); // 2
   
   public void add(int i, E item);
   
   public E get(int i); // 3
   
   public void remove(int i);
   
   public void set(int i, E item);
   
   public int size();
}
