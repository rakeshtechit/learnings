package com.test;


public class Solution2 {
    
    final static int[][] A = {{1}};
    final static int[][] B = {{1,1,1}};
    final static int[][] C = {{1,1},{1,1}};
    final static int[][] D = {{0,1,0},{1,1,1}};
    final static int[][] E = {{1,1,1},{1,0,1}};

    private static int[][] solution(int m, int n, String []pattern) {
        int [][] grid = new int[m][n];
        placePatterns(grid, pattern, 0);
        return grid;
    }
    private static int[][] findPattern(String pattern) {
        int[][]  pt = switch(pattern) {
            case "A" -> A;
            case "B" -> B;
            case "C" -> C;
            case "D" -> D;
            case "E" -> E;
            default -> throw new RuntimeException("Invalid Argument");
        };
        return pt;
        
    }
    
    private static boolean placePatterns(int[][] grid, String[] patterns, int index) {
        if (index == patterns.length) return true;
        
        int[][] pt = findPattern(patterns[index]);
        int h = pt.length;
        int w = pt[0].length;
        
        for (int y = 0; y <= grid.length - h; y++) {
            for (int x = 0; x <= grid[0].length - w; x++) {
                if (canPlace(grid, pt, y, x)) {
                    place(grid, pt, y, x, index);
                    if (placePatterns(grid, patterns, index + 1)) return true;
                    remove(grid, pt, y, x);
                }
            }
        }
        return false;
    }
    
    private static boolean canPlace(int[][] grid, int[][] pt, int y, int x) {
        for (int dy = 0; dy < pt.length; dy++) {
            for (int dx = 0; dx < pt[0].length; dx++) {
                if (pt[dy][dx] == 1 && grid[y + dy][x + dx] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static void place(int[][] grid, int[][] pt, int y, int x, int placeholder) {
        for (int dy = 0; dy < pt.length; dy++) {
            for (int dx = 0; dx < pt[0].length; dx++) {
                if (pt[dy][dx] == 1) {
                    grid[y + dy][x + dx] = placeholder + 1;
                }
            }
        }
    }
    
    private static void remove(int[][] grid, int[][] pt, int y, int x) {
        for (int dy = 0; dy < pt.length; dy++) {
            for (int dx = 0; dx < pt[0].length; dx++) {
                if (pt[dy][dx] == 1) {
                    grid[y + dy][x + dx] = 0;
                }
            }
        }
    }
    
    

    public static void main(String ...args) {
        System.out.println("Test Started");
        String[] pattern = {"A","B","C","D","E"};
        int[][] sol = solution(4,8,pattern);
        for (int[] row : sol) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
        