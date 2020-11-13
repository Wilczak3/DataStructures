import java.util.Arrays;
import java.util.List;
public class Main 
{
   public static void main(String[] args) 
   {
      // you can use this method to test your heap
      // you can put any code you like here   
      
      // here is some sample code that creates
       // a heap...
        Integer[] ary = { 45, 40, 35, 30, 25, 20, 15, 10, 5, 1 };
		List<Integer> l = Arrays.asList(ary);
		Heap h = new Heap(100);
		h.insertAll(l);
		h.toString();

		h.removeTop();
		h.toString();

		h.removeTop();

		System.out.println(h);
   }
}