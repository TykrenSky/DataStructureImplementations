public class BinaryIntTree {
   private BinaryNode<Integer> root;
   
   public void add(int data) {
      if (root == null) {
         root = new BinaryNode<Integer>(data, null, null);
      } else {
         BinaryNode<Integer> current = root;
         while (data != current.get()) {
            if (direct(data, current) != null) {
               current = direct(data, current);
            } else {
               if (data > current.get()) {
                  current.setRight(new BinaryNode<Integer>(data, null, null));
               } else {
                  current.setLeft(new BinaryNode<Integer>(data, null, null));
               }
            }
         }
      }
   }
   
   public boolean hasValue(int val) {
      BinaryNode<Integer> current = root;
      while (current != null) {
         if (current.get() == val) {
            return true;
         }
         current = direct(val, current);
      }
      return false;
   }
   
   private BinaryNode<Integer> direct(int data, BinaryNode<Integer> node) {
      if (data > node.get()) {
         return node.getRight();
      } else {
         return node.getLeft();
      }
   }
   
   public class ImBoredNode<NodeType> {
      private NodeType data;
      private ImBoredNode<NodeType> next;
      
      public ImBoredNode(NodeType data, ImBoredNode<NodeType> next) {
         this.data = data;
         this.next = next;
      }
   }
}