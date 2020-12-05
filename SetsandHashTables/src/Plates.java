import java.util.*;
import java.io.*;
public class Plates
{
  private Map<String, Integer> plateMap;
  private final int min_count = 0;
  private final int min_size = 2;

  public Plates()
  {
    plateMap = new HashMap<String, Integer>();
  }

  // Implement me please...
  public void buildMap()
  {
    try(BufferedReader reader = new BufferedReader(new FileReader("plates.txt")))
    {
        String line = reader.readLine();
        while(line != null)
        {
            String words[] = line.split("\\s+");
            for(String word : words)
            {
                word = cleanWord(word);
                if(word.length() < min_size)
                {
                    continue;
                }
                if(!plateMap.containsKey(word))
                {
                    plateMap.put(word, 0);
                }
                int count = plateMap.get(word);
                plateMap.put(word, count+1);
            }
            line = reader.readLine();
        }
    }
    catch(IOException x)
    {
        System.err.format("IOException : %s%n", x);
    }
  }

  public String cleanWord(String word)
  {
      String ret = "";
      word = word.toUpperCase();
      for(Character c : word.toCharArray())
      {
          if(Character.isLetter(c))
          {
              ret = ret + c;
          }
      }
      return ret.trim();
  }

  public void printCounts()
  {
     /* do not edit the implementation of this method*/
     System.out.println("Number of Plates: " + plateMap.keySet().size());
     for (String key : plateMap.keySet())
       System.out.printf("%s -> %s%n", key, plateMap.get(key));
  }
}