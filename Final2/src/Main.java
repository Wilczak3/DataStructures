import java.util.*;
import java.util.ArrayList;
public class Main
{
   	public static void main(String[] args) throws Exception
	{
	    Huffman huff = new Huffman();		

	    List nodes = new ArrayList();
	    //System.out.println(nodes);
					
	    huff.buildTreeFromFile("tree.txt");
			
            String encode = "ADDZ";
            System.out.printf(encode + " encoded as: ");					
            System.out.println(huff.encode(encode));

            String decode = "0001011";
            System.out.printf(decode + " decoded as: ");					
            System.out.println(huff.decode(decode));	
        	
    }
}