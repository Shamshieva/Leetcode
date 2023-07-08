package manas.task3;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after the integer

        for (int i = 0; i < n; i++) {
            String query = scanner.nextLine();
            if (isValidQuery(query)) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        }
    }

    private static boolean isValidQuery(String query) {
        // Remove all whitespaces from the query
        String sanitizedQuery = query.replaceAll("\\s+", "");

        // Check for empty query
        if (sanitizedQuery.isEmpty()) {
            return false;
        }

        // Check for invalid operators
        if (sanitizedQuery.contains("{}") || sanitizedQuery.contains("[]") ||
                sanitizedQuery.contains("()") || sanitizedQuery.contains("[]]")) {
            return false;
        }

        // Check for missing opening or closing brackets
        Stack<Character> stack = new Stack<>();
        for (char c : sanitizedQuery.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                if (stack.isEmpty() || !isValidPair(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        // Check for consecutive operators or missing tags/predicates
        Pattern pattern = Pattern.compile("\\{[^{}]*\\}|\\[[^\\[\\]]*\\]");
        Matcher matcher = pattern.matcher(sanitizedQuery);
        String prevMatch = null;
        while (matcher.find()) {
            String currentMatch = matcher.group();
            if (currentMatch.equals(prevMatch) || currentMatch.equals("{}") || currentMatch.equals("[]")) {
                return false;
            }
            prevMatch = currentMatch;
        }

        return true;
    }

    private static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']');
    }
}
