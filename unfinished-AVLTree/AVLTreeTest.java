import junit.framework.TestCase;
import org.junit.Test;


public class AVLTreeTest extends TestCase {
   AVLTree tree;

   @Override
   protected void setUp() throws Exception {
      tree = new AVLTree();
   }

   @Test
   public void testAdd() throws Exception {
      tree.add(15);
      assertTrue(tree.contains(15));
      tree.add(20);
      
   }
/*
   @Test
   public void testRemove() throws Exception {
      tree.add(15);
      tree.add(20);
      tree.remove(15);
      assertFalse(tree.contains(15));
      assertTrue(tree.contains(20));
   }

   @Test
   public void testContains() throws Exception {
      tree.add(5);
      tree.add(10);
      tree.add(30);
      tree.add(5);
      tree.add(20);
      tree.add(40);
      assertEquals(true, tree.contains(5));
      assertEquals(false, tree.contains(16));
   }
*/

}