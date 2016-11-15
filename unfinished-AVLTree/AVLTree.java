public class AVLTree {

  private MyTreeNode root;

  public AVLTree() {
    this.root = null;
  }

  public void add(Integer data) throws Exception {
    this.root = add(root, data);
    System.out.println(root.getHeight());
    print();
  }

  private MyTreeNode add(MyTreeNode node, Integer data) throws Exception {
    if (node == null) {
            return new MyTreeNode(data);
        } else if (node.getData().equals(data)) {
            throw new Exception("Item is already in the tree");
        }

        if (data < node.getData()) {
            node.setLeft(add(node.getLeft(), data));
            
            if (node.getRight() == null && node.getLeft() != null){
              node.setHeight(node.getLeft().getHeight());
            } else if (node.getRight() != null && node.getLeft() == null){
              node.setHeight(node.getRight().getHeight());
            } else{
            
              if (node.getLeft().getHeight() >= node.getRight().getHeight()){
                node.setHeight(node.getLeft().getHeight() + 1);
              }else{
                node.setHeight(node.getRight().getHeight() + 1);
              }
            }
        } else if (data > node.getData()) {
            node.setRight(add(node.getRight(), data));
            
            if (node.getRight() == null && node.getLeft() != null){
              node.setHeight(node.getLeft().getHeight() + 1);
            } else if (node.getRight() != null && node.getLeft() == null){
              node.setHeight(node.getRight().getHeight() + 1);
            } else{
            
              if (node.getLeft().getHeight() >= node.getRight().getHeight()){
                node.setHeight(node.getLeft().getHeight() + 1);
              }else{
                node.setHeight(node.getRight().getHeight() + 1);
              }
               
            }
            
        }
         
        return node;
  }


  public boolean contains(Integer data) {
    return contains(root, data);
  }

  private boolean contains(MyTreeNode root, Integer data) {
    if (root == null) {
      return false;
    } else if (root.getData() < data) {
      return contains(root.getLeft(), data);
    } else if(root.getData() > data)  {
      return contains(root.getRight(), data);
    } else {
      return true;
    }
  }

  public String toString() {
    return toString(root);
  }

  private String toString(MyTreeNode root) {
    if (root == null) {
      return "";
    } else {
      return toString(root.getLeft()) + root.getData() + " " + toString(root.getRight());
    }
  }

  private void print() {
    if (root != null) {
      root.print();
    }
  }


  private class MyTreeNode {
    private Integer data;
    private MyTreeNode left;
    private MyTreeNode right;
    private int height;
    private int balance;

    public MyTreeNode(Integer data) {
      this.data = data;
      this.left = null;
      this.right = null;
      this.height = 1;
      this.balance = 0;
    }

    // print adapted from
    // http://stackoverflow.com/q/4965335/
    
    // how it works here:
    // https://goo.gl/9LqufD
    public void print() {
      print("", true);
    }

    private void print(String prefix, boolean isTail) {
      System.out.println(prefix + (isTail ? "??? " : "??? ") + data);
      if (right != null) {
        right.print(prefix + (isTail ? "    " : "?   "), false);
      } else {
        System.out.println(prefix + (isTail ? "    " : "?   ") + (isTail ? "??? " : "??? "));
      }

      if (left != null) {
        left.print(prefix + (isTail ? "    " : "?   "), false);
      } else {
        System.out.println(prefix + (isTail ? "    " : "?   ") + (isTail ? "??? " : "??? "));
      }
    }

    public Integer getData() {
      return data;
    }

    public void setData(Integer data) {
      this.data = data;
    }

    public MyTreeNode getLeft() {
      return left;
    }

    public void setLeft(MyTreeNode left) {
      this.left = left;
    }

    public MyTreeNode getRight() {
      return right;
    }

    public void setRight(MyTreeNode right) {
      this.right = right;
    }

    public int getHeight() {
      return height;
    }

    public void setHeight(int height) {
      this.height = height;
    }

    public int getBalance() {
      return balance;
    }

    public void setBalance(int balance) {
      this.balance = balance;
    }
  }
}