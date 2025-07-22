package com.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    public static int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        for (int index = 1; index < heights.length; index++) {
            
            var height = heights[index -1 ] < heights[index] ? heights[index -1] : heights[index];
            int newMaxArea = (height * 2);
            maxArea = newMaxArea > maxArea ? newMaxArea :maxArea;
        }
        return maxArea;
    }

    public static long solution(int[] numbers) {

        List<Integer> powersOfTwo = new ArrayList<>();
        int num = 0;
        int maxPower = (int) (2 * Math.pow(10, 6)); // 20 million
        do {
            num = num == 0 ? 1 : num * 2; // Start with 1, then keep doubling
            powersOfTwo.add((int) num);
        }
        while(num < maxPower);
        int totalPairs = 0;
        //System.out.println("Powers of Two: " + powersOfTwo);
        
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length ; j++) {
                int calNumber = numbers[i] + numbers[j];
                // System.out.println("calNumber: " + calNumber);
                if (powersOfTwo.contains(calNumber)) {
                    totalPairs++;
                }
            }
        }

        return totalPairs;
    }

    
    public static void ratInMaze(int [][]maze) {
        int ySize = maze.length;
        int xSize = maze[0].length;
        boolean routeFound = false;
        for (int yPos = 0; yPos < ySize; yPos++) {
            for (int xPos = 0 ; xPos < xSize; xPos++) {
                routeFound = navigate(maze, yPos, xPos);
                if (routeFound) {
                    System.out.println ("Solution -> "+ routeFound);
                    break;
                }
            }
            if (routeFound) {
                maze[ySize-1][xSize-1] = 9;
                break;
            }
        }

        for (int yPos = 0; yPos < ySize; yPos++) {
            for (int xPos = 0 ; xPos < xSize; xPos++) {
                System.out.print(maze[yPos][xPos]);
            }
            System.out.println();
        }
    }

    public static boolean navigate(int [][]maze, int yPos, int xPos) {
        boolean routeFound = true;
        if (yPos < 0 || yPos > maze.length - 1 || xPos < 0 || xPos > maze[0].length - 1) {
            return false;
        }

        if (maze[yPos][xPos] == 1) {
            // Node visited
            maze[yPos][xPos] = 8;
        }else {
            routeFound = false;
        }

        if (routeFound) {
            boolean west = navigate(maze, yPos, xPos-1);
            boolean east = navigate(maze, yPos, xPos+1);
            boolean north = navigate(maze, yPos-1, xPos);
            boolean south = navigate(maze, yPos+1, xPos);
            System.out.println("west -> " + west + "| east -> " + east + " | north -> " + north + " | south -> " + south);
            if (!west && !east && !north && !south) {
                //reset back to 1 as no route exists
                maze[yPos][xPos] = 1;
            }
        }
        
        return routeFound;
    }
    
    
    


    public static void main(String[] args) {
        
        int i = 01;
        BigDecimal d1 = new BigDecimal(2.0);
        BigDecimal d2 = new BigDecimal(2.00);
        System.out.println(d1.equals(d2));
        System.out.println(d1.compareTo(d2) == 0);
        
      
        //System.out.println(i);

        int[][] maze = {
                    {1, 1, 1, 0, 0, 0}, 
                    {1, 1, 1, 0, 1, 0}, 
                    {0, 0, 1, 1, 0, 0}, 
                    {1, 0, 1, 1, 1, 1}
                };



        //List<Integer> a = List.of(1,2,3);
        
        //int[] arr = a.stream().mapToInt(Integer::intValue).toArray();
        //Integer[] arr = a.toArray(Integer[]::new);
    }
}