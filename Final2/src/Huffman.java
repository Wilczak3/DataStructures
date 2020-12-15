import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Huffman
{
  // This is the Huffman tree.
  private Tree nodes;

  // This populates the nodes attribute from a file.
  public void buildTreeFromFile(String fileName) throws FileNotFoundException
  {
    List<Tree> items = new ArrayList<Tree>();
    populateNodesFromFile(fileName, items);
    nodes = buildTreeFromNodes(items);
  }

  private void populateNodesFromFile(String fileName, List<Tree> nodes) throws FileNotFoundException
  {
    File file = new File(fileName);
    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine())
    {
      String line = scanner.nextLine();
      String[] data = line.split(",");

      char character = data[0].charAt(0);
      int frequency = Integer.parseInt(data[1]);

      Tree node = new Tree(null, null, character, frequency);
      nodes.add(node);
    }

    scanner.close();
  }

  private Tree buildTreeFromNodes(List<Tree> nodes)
  {
    if(nodes.size() == 1)
    {
      return nodes.get(0);
    }
    else
    {
      Collections.sort(nodes);

      Tree left = nodes.get(0);
      Tree right = nodes.get(1);
      int total = left.getTotal() + right.getTotal();

      Tree newNode = new Tree(left, right, Character.MIN_VALUE, total);

      if(nodes.size() == 2)
        return newNode;

      nodes.remove(left);
      nodes.remove(right);
      nodes.add(newNode);

      return buildTreeFromNodes(nodes);
    }
  }

  public void printTree()
  {
    System.out.println(nodes.toString());
  }

  public String getCode(char ch)
  {
    return buildCode(nodes, ch, "");
  }

  public String encode(String input)
  {
      String h = "";
    for(int i = 0; i < input.length(); i++)
    {
        h = h + getCode(input.charAt(i));
    }
    return h;

  }
  public String decode(String input)
  {
    String result = "";
    Tree r = nodes;
    for(int i = 0; i < input.length(); i++)
    {
        char ch = input.charAt(i);
        if(ch == '0')
        {
            r = r.getLeft();
        }
        else
        {
            r = r.getRight();
        }
        if(r.isLeaf())
        {
            result = result + r.getChar();
            r = nodes;
        }
    }
    return result;
    }

  private String buildCode(Tree root, char ch, String code)
  {
    if (root.isLeaf() && Character.isLetter(root.getChar()))
    {
      return root.getChar() == ch ? code : "";
    }
    String leftCode = buildCode(root.getLeft(), ch, code + "0");
    String rightCode = buildCode(root.getRight(), ch, code + "1");

    code = leftCode.length() > 0 ? leftCode : rightCode;
    return code;
  }
}