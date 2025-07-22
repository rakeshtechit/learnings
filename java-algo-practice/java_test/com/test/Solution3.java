package com.test;

import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {
    public static double solve(String[] tokens) {
     
        Deque<Double> queue = new LinkedList<>();
        
        for (int index = 0; index < tokens.length; index++) {
            String tok = tokens[index];

            switch(tok) {
                case "+" -> {
                    double last = queue.pollLast();
                    double prev = queue.pollLast();
                    double output = prev + last;
                    queue.addLast(output);
                }
                case "-" -> {
                    double last = queue.pollLast();
                    double prev = queue.pollLast();
                    double output = prev - last;
                    queue.addLast(output);

                }
                case "*" -> {
                    double last = queue.pollLast();
                    double prev = queue.pollLast();
                    double output = prev * last;
                    queue.addLast(output);
                }
                case "/" -> {
                    double last = queue.pollLast();
                    double prev = queue.pollLast();
                    double output = prev / last;
                    queue.addLast(output);
                }
                default -> queue.addLast(Double.parseDouble(tokens[index]));
            }

        }
        return queue.poll();

    }

    public static void main(String[] args) {
        String []tokens = {1};
        System.out.println(Math.ceil(solve(tokens)));

    }
}
