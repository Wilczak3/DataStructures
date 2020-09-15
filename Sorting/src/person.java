public class person implements Comparable<person>
{
    private static int m_count;
    private String m_name;
    private int m_age;

    public person(String name, int age)
    {
        m_name = name;
        m_age = age;
        m_count++;
    }

    public String getName()
    {
        return m_name;
    }

    public int getAge()
    {
        return m_age;
    }

    public static int getCount()
    {
        return m_count;
    }

    @Override
    public int compareTo(person other)
    {
        return ~(Integer.compare(this.getAge(), other.getAge()));
    }

    @Override
    public String toString()
    {
        String s = String.format("%s (%s)", m_name, m_age);
        return s;
    }
    
}