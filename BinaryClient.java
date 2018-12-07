public class BinaryClient {
   public static void main(String[] args) {
      BinaryIntTree tree = new BinaryIntTree();
      tree.add(5);
      tree.add(7);
      tree.add(3);
      tree.add(6);
      tree.add(20);
      System.out.println(tree.hasValue(7) + " " + tree.hasValue(20));
   }
}