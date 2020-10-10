package com.javarush.task.task34.task3404;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/
public class Solution {
    private final String[] FUNCTIONS = {"s", "c", "t"};
    private final String FUNCTIONS_STRING = "sct";
    private final String OPERATORS = "+-*/^";
    private final String VARIABLE = "var";
    private final String SEPARATOR = ",";
    private Stack<String> StackOperations = new Stack<String>();
    private Stack<String> StackRPN = new Stack<String>();
    private Stack<String> stackAnswer = new Stack<String>();

    public Solution() {
        //don't delete
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isFunction(String token) {
        for (String item : FUNCTIONS) {
            if (item.equals(token)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSeparator(String token) {
        return token.equals(SEPARATOR);
    }

    private boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    private boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static String evalRPN(ArrayList<String> expr){
        LinkedList<Double> stack = new LinkedList<Double>();
        System.out.println("Input\tOperation\tStack after");
        for (String token : expr){
            System.out.print(token + "\t");
            if (token.equals("*")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand * secondOperand);
            } else if (token.equals("/")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand / secondOperand);
            } else if (token.equals("-")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand - secondOperand);
            } else if (token.equals("+")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(firstOperand + secondOperand);
            } else if (token.equals("^")) {
                System.out.print("Operate\t\t");
                double secondOperand = stack.pop();
                double firstOperand = stack.pop();
                stack.push(Math.pow(firstOperand, secondOperand));
            } else if (token.equals("s")) {
                double firstOperand = stack.pop();
                stack.push(Math.sin(Math.toRadians(firstOperand)));
            }
            else if (token.equals("c")) {
                double firstOperand = stack.pop();;
                stack.push(Math.cos(firstOperand));
            }
            else if (token.equals("t")) {
                double firstOperand =  stack.pop();;
                stack.push(Math.tan(firstOperand));
            }
            else {
                System.out.print("Push\t\t");
                try {
                    stack.push(Double.parseDouble(token+""));
                } catch (NumberFormatException e) {
                    System.out.println("\nError: invalid token " + token);
                    return null;
                }
            }
            System.out.println(stack);
        }
        if (stack.size() > 1) {
            System.out.println("Error, too many operands: " + stack);
            return null;
        }
        System.out.println("Final answer: " + stack.peek());
        return stack.pop().toString();
    }

    private byte getPrecendence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        } else if (token.equals("^")) {
            return 3;
        } else if (token.equals("s") || token.equals("c") || token.equals("t")) {
            return 4;
        }
        return 2;
    }

    private String calcRPN(String exp) {
        Stack<String> operations = new Stack<>();
        ArrayList<String> output = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(exp, FUNCTIONS_STRING + OPERATORS + SEPARATOR  + "()", true);
        System.out.println(exp);
        int indexLastOpen = exp.indexOf("(");
        int indexfirstClose = exp.lastIndexOf(")");
        if (indexLastOpen == -1) {
            System.out.println("calc nested exp with RPN");
            output.clear();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (isFunction(token)) {
                    operations.push(token);
                }
                if (isOperator(token)) {
                    int precendenceToken = getPrecendence(token);
                    if (!operations.isEmpty()) {
                        int precedenceFromStack = getPrecendence(operations.peek());
                        if (precendenceToken <= precedenceFromStack || isFunction(operations.peek())) {
                            output.add(operations.pop());
                        }
                    }
                    operations.push(token);
                }
                if (isNumber(token)) {
                    output.add(token);
                }
            }

            while (!operations.isEmpty()) {
                output.add(operations.pop());
            }
            System.out.println("*********");
            for(String i : output) {
                System.out.print(i);
            }
            System.out.println();
            System.out.println("*********");
            return evalRPN(output);
        } else {
            String substrToRPN = exp.substring(indexLastOpen + 1, indexfirstClose);
            String expression = exp.substring(0, indexLastOpen) + calcRPN(substrToRPN) + exp.substring(indexfirstClose + 1);
//            if (exp.substring(0,1).equals("s")) {
//                expression = exp.substring(0,1) + substrToRPN;
//                System.out.println(expression);
//            }
//            long count = exp.chars().filter(ch -> ch == '(').count();
//            if (count == 1 && exp.substring(0,1).equals("s")) {
//                expression = "s" + expression;
//            }
//            calcRPN(expression);
            System.out.println(expression);
            return calcRPN(expression);
        }
    }

    public void recurse(final String expression, int countOperation) {
        //implement
        String expressionL = expression.replace(" ", "")
                .replace("-", "0-").replace("sin", "s").replace("cos","c")
                .replace("tan", "t");
       /* String expressionL = expression.replace(" ", "").replace("(-", "(0-")
                .replace(",-", ",0-");*/
        calcRPN(expressionL);
/*
        int l = results.length;
        for (int j = 0; j < l / 2; j++) {
            String temp = results[j];
            results[j] = results[l - j - 1];
            results[l - j - 1] = temp;
        }


        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
        }
        */

    }
}
