import java.util.*;
import junit.framework.TestCase;


public class LListTest extends TestCase {
 public void testNext(){
    LList<String> list = new LList<String>();
    list.add("Q");
    list.add("R");
    list.add("S");

    Iterator iter = list.iterator();

    assertEquals("added Q", "Q", iter.next());
    assertEquals("added R", "R", iter.next());
    assertEquals("added S", "S", iter.next());
    }

 public void testRemove(){
   LList<String> list = new LList<String>();
   list.add("Q");
   list.add("R");
   list.add("S");

   Iterator iter = list.iterator();
   iter.next();
   iter.remove();
   assertEquals("removed Q", "R", iter.next());
   iter.remove();
   assertEquals("removed R", "S", iter.next());
 }

 public void testIllegalStateException(){
   LList<String> list = new LList<String>();
   Iterator iter = list.iterator();

  try {
      iter.remove();
      fail("Should have thrown an exception!");
    } catch (IllegalStateException e) {
      //
    }
 }

 public void testISEAgain(){
 LList<String> list = new LList<String>();


   list.add("Q");
   list.add("R");
   list.add("S");

  Iterator iter = list.iterator();
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());

   iter.remove();

  try {
      iter.remove();
      fail("Should have thrown an exception!");
    } catch (IllegalStateException e) {
      //
    }
 }

 public void testNosuchElement(){
    LList<String> list = new LList<String>();
   list.add("Q");
   list.add("R");
   list.add("S");

  Iterator iter = list.iterator();
   System.out.println(iter.next());
   System.out.println(iter.next());
   System.out.println(iter.next());

   try {
      iter.next();
      fail("Should have thrown an exception!");
    } catch (NoSuchElementException e) {
      //
    }

 }

}
