import java.lang.reflect.Array;
import java.util.*;

public class Main
{    
        public static void main(String args[])
        {
        // -----------------------------------
        // do not edit main...       
        // -----------------------------------
        List<Person> people = new ArrayList<Person>();
        
        people.add(new Person("Frank", "Denton", 73));
        people.add(new Person("Mark", "Cohen", 44)); 
        people.add(new Person("Tim", "Smith", 22));
        people.add(new Person("Steve", "Denton", 16)); 
        people.add(new Person("Andy", "Ashton", 44)); 
        people.add(new Person("Albert", "Denton", 58)); 
        
        List<Person> ans = mergeSort(people);
        System.out.println(ans);
        // -----------------------------------
        }
    
    public static List<Person> mergeSort(List<Person> items)
    {
        List<Person> sorted = new ArrayList<Person>();
        if (items.size() == 1)
        {
            return items;
        }
        else
        {
            int midpoint = items.size() / 2;
            List<Person> left = Arrays.asList(new Person[midpoint]);
            List<Person> right;
            if(items.size() % 2 == 0)
            {
                right = Arrays.asList(new Person[midpoint]);
            }
                else
                {
                    right = Arrays.asList(new Person[midpoint + 1]);
                }
            
                    for(int i = 0; i < midpoint; i++)
                    {
                        left.set(i, items.get(i));
                    }

                    for(int j = 0; j < right.size(); j++)
                    {
                        right.set(j, items.get(midpoint + j));
                    }

                    left = mergeSort(left);
                    right = mergeSort(right);
                    sorted = merge(left,right);
        }
            return sorted;    
    }
    
    private static List<Person> merge(List<Person> partA, List<Person> partB)
    {
         List<Person> merged = Arrays.asList(new Person[partA.size() + partB.size()]);
         
         int leftP, rightP, resultP;
         leftP = rightP = resultP = 0;

         while(leftP < partA.size() || rightP < partB.size())
         {
             if(leftP < partA.size() && rightP < partB.size())
             {
                 if(partA.get(leftP).compareTo(partB.get(rightP)) < 1)
                 {
                    merged.set(resultP++, partA.get(leftP++));
                 }
                 else
                 {
                    merged.set(resultP++, partB.get(rightP++));
                 }
             }
             else if(leftP < partA.size())
             {
                 merged.set(resultP++, partA.get(leftP++));
             }
             else if(rightP < partB.size())
             {
                 merged.set(resultP++, partB.get(rightP++));
             }
         }
         return merged;
    }
}