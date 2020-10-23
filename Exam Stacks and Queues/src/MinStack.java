public class MinStack<T extends Comparable<T>> implements IStack<T>
{
    IStack<T> actualStack = new StackLL<T>();
    IStack<T> auxStack = new StackLL<T>();
    private Node m_head;
	private int m_count;
    
    public MinStack()
    {
       m_head = new Node(null);
    }
    
	@Override
	public void push(T item)
	{
        // runs in constant time...
        Node n = new Node(item);
        if(m_count == 0)
        {
            actualStack.push(item);
            auxStack.push(item);
            m_count++;
        }
        else
        {
            actualStack.push(item);
            T x = auxStack.pop();
            auxStack.push(x);
        
            if(item.compareTo(x) <= -1)
            {
                auxStack.push(item);
            }
            else 
            {
                actualStack.push(item);
            }
        }
        n.m_next = m_head.m_next;
		m_head.m_next = n;
		m_count++;
    }
 
    public T min()
    {
        return auxStack.top();
    }

	@Override
	public T pop()
	{
		// runs in constant time...

        if (isEmpty())
        {
            throw new IllegalStateException("pop error: stack is empty!");
        }
        else
        {
            auxStack.pop();
        }
        m_count--; 
		T ret = m_head.m_next.m_data;
		m_head.m_next = m_head.m_next.m_next;

		return ret;
        
	}

	@Override
	public T top()
	{
		// runs in constant time...

		if (isEmpty())
			throw new IllegalStateException("top error: stack is empty!");
		return  m_head.m_next.m_data;
	}

	@Override
	public boolean isEmpty()
	{
		// runs in constant time...

		return getSize() == 0;
	}

	@Override
	public int getSize()
	{
		// runs in constant time...

		return m_count;
	}

	@Override
	public String toString()
	{
		// runs in linear time...

		StringBuffer sb = new StringBuffer("top->");
		if (!isEmpty())
		{
			Node node = m_head.m_next;
			sb.append(node.m_data.toString());
			while (node.m_next != null)
			{
				node = node.m_next;
				sb.append("->");
				sb.append(node.m_data.toString());
			}
		}
		return sb.toString();
	}


	/**
	 * <p>Internal class used to represent a link in a linked list
	 * structure.  Each node in the list contains the element
	 * that was added to the stack, as well as a reference to the
	 * next item in the stack.</p>
	 */
	private class Node
	{
	 	private T m_data;
	 	private Node m_next;

		public Node(T data)
		{
			m_data = data;
			m_next = null;
		}
	}

}