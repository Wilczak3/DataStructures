public class main
{
    public static void main(String[] args)
    {
        Recursion r = new Recursion();
        String word = "Banana";
        char c1 = 'a';
        char c2 = 'o';
        System.out.println("Old Word:" + word);
        System.out.println("New Word:" + r.change(word, c1, c2));
    }
}