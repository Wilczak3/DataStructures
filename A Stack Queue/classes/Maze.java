import java.util.Scanner;
 
public class Maze
{
    private char[][] maze ={{ '*', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' },
                            { '-', '-', '-', '-', '-', '-', '-', '-', '-', '-' }}; 
    private int y = 0;
    private int x= 0;
    private boolean g = true;
    private IStack<String> undo = new StackAL<String>();
    private IStack<String> redo = new StackAL<String>();
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Maze m = new Maze();
        
        while(m.g)
        {
            if(m.undo.isEmpty())
            {
                m.print();
                System.out.println("What have you mage?");
                System.out.print("N: North\nS: South\nE: East\nW: West\nG: Grog\nU: Undo\nR: Redo\nQ: Quit");
                String direction = s.nextLine();
                
                m.move(direction);
            }
            else
            {
                System.out.println("undo stack:" + m.undo.toString());
                System.out.println("redo Stack:" + m.redo.toString());
                m.print();
                System.out.println("What have you mage?");
                System.out.print("N: North\nS: South\nE: East\nW: West\nG: Grog\nU: Undo\nR: Redo\nQ: Quit");
                String direction = s.nextLine();
                
                m.move(direction);
            }
        }
        
        s.close();
    }

    public int getRow()
    {
        return x;
    }
    public int getColumn()
    {
        return y;
    }

    public void moveDirections(String s)
    {
        switch(s.toLowerCase())
        {
            case "n":
            if(getRow() == 0)
            {
                System.out.println("Ouch!");
            }
            else
            {
                maze[getRow()][getColumn()] = '-';
                x--;
                maze[getRow()][getColumn()] = '*';
                undo.push("S");
            }
            break;
            //---------------------------------------------------------------------------
            case "s":
            if(getRow() == 9)
            {
                System.out.println("Ouch!");
            }
            else
            {
                maze[getRow()][getColumn()] = '-';
                x++;
                maze[getRow()][getColumn()] = '*';
                undo.push("N");
            }
            break;
            //---------------------------------------------------------------------------
            case "w":
            if(getColumn() == 0)
            {
                System.out.println("Ouch!");
            }
            else
            {
                maze[getRow()][getColumn()] = '-';
                y--;
                maze[getRow()][getColumn()] = '*';
                undo.push("E");
            }
            break;
            //---------------------------------------------------------------------------
            case "e":
            if(getColumn() == 9)
            {
                System.out.println("Ouch!");
            }
            else
            {
                maze[getRow()][getColumn()] = '-';
                y++;
                maze[getRow()][getColumn()] = '*';
                undo.push("W");
            }
            break;
            //--------------------------------------------------------------------------
            case "g":
            System.out.println("Gulp!");
            undo.push("G");
                break;

            default:
                return;
        }
    }
    public void move(String s)
    {
        switch(s.toLowerCase())
        {
            case"n":
            case"s":
            case"w":
            case"e":
            case"g":
                moveDirections(s);
                break;
            //---------------------------------------------------------------------------------------------
            case "q":
            g = false;
            return;
            //---------------------------------------------------------------------------------------------
            case "u":
            undo();
            return;
            //---------------------------------------------------------------------------------------------
            case "r":
            redo();
            return;
            //--------------------------------------------------------------------------------------
            default:
            System.out.println("Invaid input from user");
            return;
        }
        redo.clear();
    }

    public void undo()
    {
        if(!undo.isEmpty())
        {
            String temp = undo.top();
            undo.pop();
            if(temp == "N")
            {
                moveDirections("N");
                undo.pop();
                redo.push("S");
            }
            else if(temp == "S")
            {
                moveDirections("s");
                undo.pop();
                redo.push("N");
            }
            else if(temp == "W")
            {
                moveDirections("W");
                undo.pop();
                redo.push("E");

            }
            else if(temp == "E")
            {
                moveDirections("E");
                undo.pop();
                redo.push("W");
            }
            else if(temp == "G")
            {
                System.out.println("Blah!");
                undo.pop();
            }
            else if(undo.isEmpty())
            {
                System.out.println("Stack is Empty");
            }
        }
        else
        {
            System.out.println("No more moves to undo");
        }
    }

    public void redo()
    {
        if(!redo.isEmpty())
        {
            String temp = redo.top();
            redo.pop();
            moveDirections(temp);
        }
        else
        {
            System.out.println("No more moves to redo");
        }
    }

    public void print()
    {
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze.length; j++)
            {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

    }
    
}


