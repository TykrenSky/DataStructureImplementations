import java.util.*;

public class ImBoredList<NodeType> implements Iterable<NodeType> {
   private ImBoredNode root;
   private int size;
   
   public ImBoredList() {
      root = null;
      size = 0;
   }
   
   public boolean isEmpty() {
      return root == null;
   }
   
   public void add(NodeType data) {
      if (root == null) {
         root = new ImBoredNode(data, null);
      } else {
         goToIndex(size - 1).next = new ImBoredNode(data, null);
      }
      size++;
   }
   
   public void add(NodeType data, int index) {
      if (index == 0) {
         ImBoredNode newNode = new ImBoredNode(data, root);
         root = newNode;
      } else {
         ImBoredNode current = goToIndex(index - 1);
         ImBoredNode newNode = new ImBoredNode(data, current.next);
         current.next = newNode;
      }
      size++;
   }
   
   public void set(NodeType data, int index) {
      goToIndex(index).data = data;
   }
   
   public void remove(int index) {
      if (index == 0) {
         root = root.next;
      } else {
         ImBoredNode current = goToIndex(index - 1);
         ImBoredNode removed = current.next;
         current.next = removed.next;
      }
      size--;
   }
   
   public int size() {
      return size;
   }
   
   public NodeType get(int index) {
      return goToIndex(index).data;
   }
   
   public String toString() {
      if (root == null) {
         return "[]";
      }
      String result = "[";
      ImBoredNode current = root;
      for (int i = 0; i < size - 1; i++) {
         result += current.data + ", ";
         current = current.next;
      }
      result += current.data + "]";
      return result;
   }
   
   public int search(NodeType data) {
      ImBoredNode current = root;
      for (int i = 0; current.next != null; i++) {
         if (current.data.equals(data)) {
            return i;
         }
         current = current.next;
      }
      return -1;
   }
   
   public boolean contains(NodeType data) {
      return search(data) != -1;
   }
   
   private ImBoredNode goToIndex(int index) {
      ImBoredNode current = root;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current;
   }
   
   public Iterator<NodeType> iterator() {
      return new BoredIterator(this);
   }
   
   private class BoredIterator implements Iterator<NodeType> {
      private ImBoredList<NodeType> list;
      private ImBoredNode current;
      private int index;
      private boolean removeOkay;
      
      public BoredIterator(ImBoredList<NodeType> list) {
         current = list.root;
         removeOkay = false;
         index = -1;
         this.list = list;
      }
      
      public boolean hasNext() {
         return current != null;
      }
      
      public NodeType next() {
         NodeType temp = current.data;
         current = current.next;
         index++;
         removeOkay = true;
         return temp;
      }
      
      public void remove() {
         if (!removeOkay) {
            throw new UnsupportedOperationException("dumbass...");
         }
         list.remove(index);
         removeOkay = false;
      }
   }
   
   private class ImBoredNode {
      public NodeType data;
      public ImBoredNode next;
      
      public ImBoredNode(NodeType data, ImBoredNode next) {
         this.data = data;
         this.next = next;
      }
   }
}