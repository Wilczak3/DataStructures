import java.io.FileReader;
import java.util.*;
import java.util.ArrayList;
public class Huffman 
{	
        public void populateNodesFromFile(String file, List nodes) throws FileNotFoundException
        {
            FileReader readFile = new FileReader(file);
            StringBuffer sb = new StringBuffer();
            try
            {
                while (readFile.ready()) 
                {
                    char c = (char) readFile.read();
                    if (c == '\n') 
                    {
                        nodes.add(sb.toString());
                        sb = new StringBuffer();
                    } 
                    else 
                    {
                        sb.append(c);
                    }

                    if (sb.length() > 0) 
                    {
                        nodes.add(sb.toString());
                    }
                }
            }
            catch(IOException e)
            {
                System.out.println("Not Populating");
            }
        }

        public Tree buildTreeFromNodes(List nodes)
        { 
            return 0;
        }
	
	public void printTree(Tree root)
	{
    
	}   
	
	public String getCode(Tree root, char ch)
	{   
 
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.c)) 
        { 
            // c is the character in the node 
            System.out.println(root.c + ":" + ch); 
            return null;
        } 
  
        printCode(root.getLeft(), ch + "0"); 
        printCode(root.getRight(), ch + "1"); 
	}
				
	public String decode(Tree root, String code)
	{
	   return 0;
	}
}