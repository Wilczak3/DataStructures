import java.util.*;

public class main
{
    public static void main(String[] args)
    {
            person p1 =  new person("Matt", 23);
            person p2 =  new person("Adam", 34);
            person p3 =  new person("Nick", 20);
            person p4 =  new person("Ryan", 50);

            List<person> people = new ArrayList<person>();
            people.add(p1);
            people.add(p2);
            people.add(p3);
            people.add(p4);

            Collections.sort(people);
            System.out.println(people);
        

            Collections.sort(people,
            new Comparator<person>()
            {
                @Override
                public int compare(person x1, person x2)
                {
                    if(x1.getAge() > x2.getAge())
                        return 1;
                    else if(x1.getAge() < x2.getAge())
                        return -1;
                    else 
                        return 0;
                }
            }
            );
            System.out.println(people);
    }
}