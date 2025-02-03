//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Jacob Dovalina
/*Lab Description :   Read in a group of symbols and check to see if the appropriate opening symbol correctly matches up with the appropriate closing symbol.  
The opening symbols are “{(<[“ and the appropriate closing symbols are “})>]“.

You must read in and analyze each group.  

If you were to read in {[]}, you would have a correct balance of opening and closing symbols.
If you were to read in {[}], you would not have a correct balance of opening and closing symbols.


Sample Data : 
(abc(*def) 
[{}]
[
[{<()>}]
{<html[value=4]*(12)>{$x}}
[one]<two>{three}(four)
car(cdr(a)(b)))
car(cdr(a)(b))


Sample Output :
(abc(*def) is incorrect.

[{}] is correct.

[ is incorrect.

[{<()>}] is correct.

{<html[value=4]*(12)>{$x}} is correct.

[one]<two>{three}(four) is correct.

car(cdr(a)(b))) is incorrect.

car(cdr(a)(b)) is correct.
*/


import java.util.Stack;

public class SyntaxCheckRunner {
    public static void main(String[] args) {
        // Sample test cases
        String[] testCases = {
                "(abc(*def)",
                "[{}]",
                "[",
                "[{<()>}]",
                "{<html[value=4]*(12)>{$x}}",
                "[one]<two>{three}(four)",
                "car(cdr(a)(b)))",
                "car(cdr(a)(b))"
        };

        for (String testCase : testCases) {
            boolean result = isBalanced(testCase);
            System.out.println(testCase + " is " + (result ? "correct." : "incorrect."));
        }
    }

    public static boolean isBalanced(String symbols) {
        Stack<Character> stack = new Stack<>();
        String opening = "{([<";
        String closing = "})]>";

        for (char ch : symbols.toCharArray()) {
            if (opening.indexOf(ch) != -1) {
                // Push opening symbols onto the stack
                stack.push(ch);
            } else if (closing.indexOf(ch) != -1) {
                // Check if stack is empty or the top of the stack doesn't match
                if (stack.isEmpty() || closing.indexOf(ch) != opening.indexOf(stack.pop())) {
                    return false;
                }
            }
        }

        // If the stack is empty, the string is balanced
        return stack.isEmpty();
    }
}
