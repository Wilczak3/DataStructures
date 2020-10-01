public class Recursion
{
    public String change(String s, char oldc, char newc)
    {   
        int stringlength = s.length();

        if(stringlength < 1)
        {
            return "no character left in string";
        }
        else
        {
            for(int i = 0; i < stringlength; i++)
            {
                if(s.charAt(i) == oldc )
                {
                    s = s.substring(0, i) + newc + s.substring(++i);
                    return change(s, oldc, newc); 
                }
            }
        }
        return s;
    }
}