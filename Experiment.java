import java.util.Random;
public class Experiment {
    public static void main(String[] args){
        int[] sizes={100,1000,10000};
        for(int size:sizes){
            runExperiment(size);
        }
    }
    private static void runExperiment(int size){
        int repetitions=5;
        long bstInsert=0;
        long bstSearch=0;
        long bstDelete=0;
        long hashInsert=0;
        long hashSearch=0;
        long hashDelete=0;
        for(int r=0;r<repetitions;r++){
            int[] values=createValues(size,r);
            BinarySearchTree bst=new BinarySearchTree();
            long start=System.nanoTime();
            for(int value:values){
                bst.insert(value);
            }
            bstInsert+=System.nanoTime()-start;
            start=System.nanoTime();
            for(int value:values){
                bst.search(value);
            }
            bstSearch+=System.nanoTime()-start;
            start=System.nanoTime();
            for(int value:values){
                bst.delete(value);
            }
            bstDelete+=System.nanoTime()-start;
            HashTable table=new HashTable(size*2+1);
            start=System.nanoTime();
            for(int value:values){
                table.insert(value);
            }
            hashInsert+=System.nanoTime()-start;
            start=System.nanoTime();
            for(int value:values){
                table.search(value);
            }
            hashSearch+=System.nanoTime()-start;
            start=System.nanoTime();
            for(int value:values){
                table.delete(value);
            }
            hashDelete+=System.nanoTime()-start;
        }
        System.out.println("Size: "+size);
        System.out.println("BST insert: "+bstInsert/repetitions+" ns");
        System.out.println("BST search: "+bstSearch/repetitions+" ns");
        System.out.println("BST delete: "+bstDelete/repetitions+" ns");
        System.out.println("Hash insert: "+hashInsert/repetitions+" ns");
        System.out.println("Hash search: "+hashSearch/repetitions+" ns");
        System.out.println("Hash delete: "+hashDelete/repetitions+" ns");
        System.out.println();
    }
    private static int[] createValues(int size,int repetition) {
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = i;
        }
        Random random = new Random(42 + repetition);
        for (int i = size - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
        }
        return values;
    }
}
