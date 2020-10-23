public class main 
{
    public static void main(String[] args)
    {
        MinStack<Integer> m = new MinStack<Integer>();
        m.push(10);
        m.push(20);
        m.push(30);
        m.push(5);
        System.out.println(m.min());
        System.out.println(m.toString());
        m.pop();
        System.out.println(m.min());
        System.out.println(m.toString());
        
    }
}