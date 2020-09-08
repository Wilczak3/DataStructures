public class Rectangle
{
    private int m_width;
    private int m_height;

    public Rectangle()
    {

    }

    public Rectangle(int w, int h)
    {
        m_width = w;
        m_height = h;
    }

    public int getWidth()
    {
        return m_width;
    }

    public int getHeight()
    {
        return m_height;
    }

    public int getArea()
    {
        return m_height * m_width;
    }

    public int getParameter()
    {
        return (m_height*2)+(m_width*2);
    }
}