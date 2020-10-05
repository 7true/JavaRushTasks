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
    private final String[] FUNCTIONS = {"abs", "acos", "arg",
    "atan", "conj", "cos","cosh", "exp",
    "imag", "log", "neg", "pow", "real",
    "sin", "sinh", "sqrt", "tan", "tanh"};

    private final String OPERATORS = "+-*/";
    private final String VARIABLE = "var";
    private final String SEPARATOR = ",";
    private Stack<String> StackOperations = new Stack<String>();
    private Stack<String> StackOPN = new Stack<String>();
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

    private byte getPrecendence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        return 2;
    }

    public void recurse(final String expression, int countOperation) {
        //implement
        String expressionL = expression.replace(" ", "").replace("(-", "(0-")
                .replace(",-", ",0-");

        Stack<Double> currentRes = new Stack<>();
        StringTokenizer st = new StringTokenizer(expressionL,
                OPERATORS + SEPARATOR  + "()", true);
        System.out.println(st);

        String str = expressionL.replaceFirst("\\(", "");
        String[] results = str.split("\\)")[0].split("\\(");

        for (String string : results) {
            System.out.println(string);
        }

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
    }
}
