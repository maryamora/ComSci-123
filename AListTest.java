//Created by Danielle Hernandez and Mary Danielle Amora

import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class AListTest extends TestCase {
  
  
  public void testAddOne() {
    AList l = new AList();
    l.add("Shampoo");
    assertEquals("added one item", "Shampoo", l.get(0));
  }
  
  public void testAddTwo() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Soap", "Soap", l.get(1));
  }
  
  public void testAddBetween() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(1, "Deodorant");
    assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
    assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    assertEquals("added two items and third was Soap", "Soap", l.get(2));
  }
  
  public void testGetOutOfBoundsWhenEmpty() {
    AList l = new AList();
    try {
      l.get(0);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  
  public void testGetOutOfBounds() {
    AList l = new AList();
    l.add("Shampoo");
    try {
      l.get(1);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      // expected!
    }
  }
  
  public void testRemoveLast() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(2);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Deodorant", "Deodorant", l.get(1));
    }
  }
  
  
  public void testRemoveMid() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove(1);
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("added two items and first was Shampoo", "Shampoo", l.get(0));
      assertEquals("added two items and second was Soap", "Soap", l.get(1));
    }
  }
  
  
  public void testSet() {
    AList l = new AList();
    l.add("Shampoo");
    l.set(0, "Deodorant");
    assertEquals("added two items and first was Deodorant", "Deodorant", l.get(0));
  }

  public void testAddStart() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(0, "Noodles");
    assertEquals("added an item at the first and it was", "Noodles", l.get(0));
    assertEquals("added an item at the start, the next item should remain", "Shampoo", l.get(1));
    assertEquals("added an item at the start, the next item should remain", "Soap", l.get(2));
  }
  
  
    public void testAddEnd() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add(2, "Noodles");
    assertEquals("added an item at the end and it was", "Noodles", l.get(2));
  }
  
  public void testAddOffEnd() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Soap");
    l.add("Noodles");
    l.add("Oats");
    l.add("Chicken Breast");
    l.add("Milo");
    l.add("Coffee");
    l.add("Vegetables");
    l.add("Fruits");
    l.add("Conditioner");
    l.add("ConditionerSunsilk");
    
    
     try {
       l.add("Junk Food");
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
    //nothing
    }
     
  }
  
  public void testRemoveString() {
    AList l = new AList();
    l.add("Shampoo");
    l.add("Deodorant");
    l.add("Soap");
    l.remove("Shampoo");
    try {
      l.get(2);
      fail("Should have thrown an exception!");
    } catch (IndexOutOfBoundsException e) {  
      assertEquals("removed a string", "Deodorant", l.get(0));
      assertEquals("removed a string", "Soap", l.get(1));
    }
  }
  
  
}