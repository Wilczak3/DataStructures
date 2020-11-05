public class Tree implements Comparable
{
	private Tree m_left;
	private Tree m_right;
	private Tree m_parent;
	private char m_char;
	private int m_total;

	public Tree(Tree l, Tree r, char ch, int total)
	{
		m_left = l;
		m_right = r;
		m_char = ch;
		m_total = total;
	}

	public Tree getLeft()
	{ return m_left; }
	
	public Tree getRight()
	{ return m_right; }
	
	public Tree getParent()
	{ return m_parent; }
	
	public void setParent(Tree n)
	{ m_parent = n; }
	   
	public int getTotal()
	{ return m_total; }
	
	public char getChar()
	{ return m_char; }
	
	public void printTree()
	{
	   _printTree(this);
	}
	
	public void _printTree(Tree n)
	{
		// add code here to print the tree 
        // using a preorder traversal...
        n.append("\n"+ m_value);
        
        if (m_left != null)
        {
            m_left._printTree(n);
        }
        
        if (m_right != null)
        {
            m_right._printTree(n);
        }
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%2d)", m_char, m_total);
	}
	
	@Override
	public int compareTo(Tree t2)
	{
		// add code here to ensure that the natural ordering 
		// sorts trees in ascending order based on the tree's total, 
		// in the case of a tie sort in ascending order 
        // based on the tree's letter...
        return m_value.compareTo(t2.m_value);
	}
}