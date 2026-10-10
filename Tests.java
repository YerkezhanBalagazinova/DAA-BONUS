public class Tests {
    public static void main(String[] args){
        testBST();
        testHashTable();
    }
    private static void testBST(){
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        System.out.println("BST search 40: "+bst.search(40));
        System.out.println("BST search 100: "+bst.search(100));
        bst.delete(20);
        System.out.println("BST search 20 after delete: "+bst.search(20));
        bst.delete(30);
        System.out.println("BST search 30 after delete: "+bst.search(30));
        bst.delete(50);
        System.out.println("BST search 50 after delete: "+bst.search(50));
    }
    private static void testHashTable(){
        HashTable table=new HashTable(10);
        table.insert(15);
        table.insert(25);
        table.insert(35);
        table.insert(8);
        System.out.println("HashTable search 25: "+table.search(25));
        System.out.println("HashTable search 100: "+table.search(100));
        table.delete(25);
        System.out.println("HashTable search 25 after delete: "+table.search(25));
        table.delete(8);
        System.out.println("HashTable search 8 after delete: "+table.search(8));
    }
}
