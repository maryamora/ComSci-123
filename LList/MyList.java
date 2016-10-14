import java.util.*;
public interface MyList extends Iterable{
  public void add(Object item);
  public void add(int i, Object item);
  public void set(int i, Object item);
  public String get(int i);
  public void remove(int i);
  public void remove(Object item);
}
  