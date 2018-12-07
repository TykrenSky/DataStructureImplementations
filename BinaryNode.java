private class BinaryNode<E> {
   private E data;
   private BinaryNode<E> left;
   private BinaryNode<E> right;
   
   public BinaryNode(E data, BinaryNode<E> left, BinaryNode<E> right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
   
   public E get() {
      return data;
   }
   
   public void set(E data) {
      this.data = data;
   }
   
   public BinaryNode<E> getLeft() {
      return left;
   }
   
   public BinaryNode<E> getRight() {
      return right;
   }
   
   public void setLeft(BinaryNode<E> left) {
      this.left = left;
   }
   
   public void setRight(BinaryNode<E> right) {
      this.right = right;
   }
   
}