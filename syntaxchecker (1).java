//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Nathan Carrillo

import java.util.Stack;

public class SyntaxChecker {
    private String exp;
    private Stack<Character> symbols;

    // Default constructor
    public SyntaxChecker() {
        this.exp = "";
        this.symbols = new Stack<>();
    }

    // Parameterized constructor
    public SyntaxChecker(String s) {
        this.exp = s;
        this.symbols = new Stack<>();
    }

    // Method to set a new expression
    public void setExpression(String s) {
        this.exp = s;
        this.symbols.clear(); // Clear the stack for a new expression
    }

    // Method to check if the expression is balanced
    public boolean checkExpression() {
        String opening = "{([<";
        String closing = "})]>";

        for (char ch : exp.toCharArray()) {
            if (opening.indexOf(ch) != -1) {
                // Push opening symbols onto the stack
                symbols.push(ch);
            } else if (closing.indexOf(ch) != -1) {
                // Check if stack is empty or the top of the stack doesn't match
                if (symbols.isEmpty() || closing.indexOf(ch) != opening.indexOf(symbols.pop())) {
                    return false;
                }
            }
        }

        // If the stack is empty, the expression is balanced
        return symbols.isEmpty();
    }

    // toString method to display the result
    @Override
    public String toString() {
        return exp + " is " + (checkExpression() ? "correct." : "incorrect.");
    }

    // Main method for testing
    public static void main(String[] args) {
        SyntaxChecker checker = new SyntaxChecker();

        // Test cases
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
            checker.setExpression(testCase);
            System.out.println(checker);
        }
    }
}
