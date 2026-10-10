public class BinarySearchTree{
    private Node root;
    private static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
        }
    }
    public void insert(int value){
        Node newNode=new Node(value);
        if(root==null){
            root=newNode;
            return;
        }
        Node current=root;
        while(true){
            if(value<current.value){
                if(current.left==null){
                    current.left=newNode;
                    return;
                }
                current=current.left;
            }else if(value>current.value){
                if(current.right==null){
                    current.right=newNode;
                    return;
                }
                current=current.right;
            }else{
                return;
            }
        }
    }
    public boolean search(int value){
        Node current=root;
        while(current!=null){
            if(value==current.value){
                return true;
            }
            if(value<current.value){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        return false;
    }
    public void delete(int value){
        root=deleteNode(root,value);
    }
    private Node deleteNode(Node node,int value){
        if(node==null){
            return null;
        }
        if(value<node.value){
            node.left=deleteNode(node.left,value);
        }else if(value>node.value){
            node.right=deleteNode(node.right,value);
        }else{
            if(node.left==null){
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }
            int smallest=findSmallest(node.right);
            node.value=smallest;
            node.right=deleteNode(node.right,smallest);
        }
        return node;
    }
    private int findSmallest(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node.value;
    }
}

