import java.util.*;

public class Test
{
    public static void main(String args[])
    {
        /*
                A
            B       C
         D     E       F
        */
        BinaryTree<String> treeD = new BinaryTree<String>("D");
        BinaryTree<String> treeE = new BinaryTree<String>("E");
        BinaryTree<String> treeF = new BinaryTree<String>("F");
        BinaryTree<String> treeB = new BinaryTree<String>("B", treeD, treeE);
        BinaryTree<String> treeC = new BinaryTree<String>("C", null, treeF);
        BinaryTree<String> root = new BinaryTree<String>("A", treeB, treeC);
        
        // D B E A C F
        String s = root.toString();
        System.out.println(s);
        
        List<BinaryTree> trees = new ArrayList<BinaryTree>();
        trees.add(treeD);
        trees.add(treeF);
        trees.add(treeC);
        trees.add(treeE);
        trees.add(root);
        trees.add(treeB);
        
        Collections.sort(trees);
        
        for (BinaryTree t : trees)
        {
            System.out.println();
            System.out.print(t.getValue() + " ");
            System.out.println();
        } 
    }
}