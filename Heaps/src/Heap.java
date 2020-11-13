import java.util.*;
import java.util.List;
class heapNode 
{
    private int m_data;

    public heapNode(int d)
    {
        m_data = d;
    }

    public int getData()
    {
        return m_data;
    }

    public void setData(int id)
    {
        m_data = id;
    }
}
public class Heap implements IHeap
{
    private heapNode[] m_heap;
    private int m_current;
    private int m_max;
   
    public Heap(int max)
    {
        m_max = max;
        m_current = 0;
        m_heap = new heapNode[m_max];
    }

    @Override
    public void insert(int item)
    {
        if(m_current == m_max)
        {
            System.out.println("The Heap is full");
        }  
        else
        {
            heapNode h = new heapNode(item);
            m_heap[m_current] = h;
            moveUp(m_current++);
        } 
    }

    @Override
    public void insertAll(List<Integer> items)
    {
        for (int i = 0; i < items.size(); i++) 
        {
            heapNode insertItems = new heapNode(items.get(i));
            m_heap[i] = insertItems;
            moveUp(m_current++);
        }
    }
   
   
    @Override 
    public int size()
    {
        return m_current;
    }
    
    @Override 
    public void clear() 
    {
    }

    @Override
    public heapNode removeTop()
    {
        heapNode root = m_heap[0];
		m_heap[0] = m_heap[--m_current];
		moveDown(0);
		return root;
    }
    
    private void moveUp(int nodeIndex)
    {
        int p = getParent(nodeIndex);
        heapNode bot = m_heap[nodeIndex];

        while(nodeIndex > 0 && m_heap[p].getData() < bot.getData())
        {
            m_heap[nodeIndex] = m_heap[p];
            nodeIndex = p;
            p = (p - 1) / 2;
        }

        m_heap[nodeIndex] = bot;
            
    }

    private void moveDown(int nodeIndex)
    {
        int child;
		heapNode top = m_heap[nodeIndex];
        while(nodeIndex < m_current / 2) 
        {
			int leftC= getLeft(nodeIndex, m_heap);
			int rightC = getRight(nodeIndex, m_heap);

            if (rightC < m_current && m_heap[leftC].getData() < m_heap[rightC].getData()) 
            {
				child = rightC;
            } 
            else 
            {
				child = leftC;
			}

            if (top.getData() >= m_heap[child].getData()) 
            {
				break;
			}

			m_heap[nodeIndex] = m_heap[child];
			nodeIndex = child;
        }
        
		m_heap[nodeIndex] = top;
    }
    
    @Override
    public String toString()
    {
        System.out.print("Backing The Array: ");

        for (int i = 0; i < m_current; i++) 
        {
            if (i == m_current - 1) 
            {
				System.out.print(m_heap[i].getData());
            } 
            else 
            {
				System.out.print(m_heap[i].getData() + " ~ ");
			}
		}
		System.out.println();
		return "";
    }
    
    private int getParent(int nodeIndex)
    {
        return nodeIndex - 1 / 2;
    }
    
    private int getLeft(int nodeIndex, heapNode ary[])
    {
        return nodeIndex * 2 + 1;
    }
    
    private int getRight(int nodeIndex, heapNode ary[])
    {
        return nodeIndex * 2 + 2;
    }
      
}
