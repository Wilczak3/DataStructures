public class Test
{
    public static void main(String[] args)
    {
        Schedule s1 = new Schedule();
        Course c1 = new Course("Networking I" , "8am" , "8:50am");
        s1.addCourse(c1);
        Course c2 = new Course("Database" , "8am" , "8:50am");
        s1.addCourse(c2);
        Course c3 = new Course("Web Development" , "8am" , "8:50am");
        s1.addCourse(c3);
        Course c4 = new Course("Java I" , "8am" , "8:50am");
        s1.addCourse(c4);
        System.out.println(s1.toString());
    }
}