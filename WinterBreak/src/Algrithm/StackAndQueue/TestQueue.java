package Algrithm.StackAndQueue;

import java.util.Stack;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Every close bracket has a corresponding open bracket of the same type.
 */
public class TestQueue
{
    public boolean isValid(String s)
    {
        if(s.length() % 2 == 1) return false;//如果是奇数，那么一定不匹配
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c)
            {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                default -> {
                    if(stack.isEmpty() || c != stack.pop())
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Input: s = "abbaca"
     * Output: "ca"
     * Explanation:
     * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
     * and this is the only possible move.  The result of this move is that the string is "aaca",
     * of which only "aa" is possible, so the final string is "ca".
     * @param s string
     * @return string without duplication
     */
    public static String removeDuplicates(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            if(stack.isEmpty() || !stack.contains(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }else
            {
                if(s.charAt(i) == stack.peek())
                {
                    stack.pop();
                }
            }
        }
        return stack.toString();
    }
    public static void main(String[] args)
    {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.empty());
        System.out.println(removeDuplicates("abbaca"));
    }
}
