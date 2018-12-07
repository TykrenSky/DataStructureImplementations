public class ImBoredNode<NodeType> {
   private NodeType data;
   private ImBoredNode<NodeType> next;
   
   public ImBoredNode(NodeType data, ImBoredNode<NodeType> next) {
      this.data = data;
      this.next = next;
   }
   
   public NodeType get() {
      return data;
   }
   
   public ImBoredNode<NodeType> getNext() {
      return next;
   }
   
   public void set(NodeType data) {
      this.data = data;
   }
   
   public void setNext(ImBoredNode<NodeType> next) {
      this.next = next;
   }
}