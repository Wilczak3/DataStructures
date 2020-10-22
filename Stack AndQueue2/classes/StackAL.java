import java.util.ArrayList;

public class StackAL<T> implements IStack<T>
{
	ArrayList<T> list;

	public StackAL()
	{
		list = new ArrayList<T>();
	}
	
	@Override
	public void push(T item) 
    { 
        list.add(item);
    } 

	@Override
	public T pop() 
    { 
        if(list.size()==0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(list.size()-1);
    } 

	@Override
	public T top()
	{
        // runs in constant time...
        if(list.size()==0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(getSize()-1);
	}

	@Override
	public boolean isEmpty()
	{
		// runs in constant time...
        if (list.isEmpty())
        {
            return true;
        } 
        else
        {
            return false;
        }
	}

	@Override
	public int getSize()
	{
		// runs in constant time...
		return list.size();
	}

	@Override
	public String toString()
	{
		// runs in linear time...

		StringBuffer sb = new StringBuffer("top->");
		if (!isEmpty())
		{
            for(int i = getSize() - 1; i >= 0; i--)
            {
                if(i == getSize() - 1)
                {
                    sb.append(list.get(i));
                }
                else 
                {
                    sb.append( "->" + list.get(i));
                }
            }
            //System.out.println(sb.toString());
		}
		return sb.toString();
	}
    @Override
    public void clear()
    {
        list.clear();
    }
}