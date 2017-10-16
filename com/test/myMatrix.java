package com.test;

import java.util.ArrayList;

public class myMatrix {

	private int[][] matrix;
	
	myMatrix() { matrix = null; }
	
	myMatrix(int[][] m) { matrix = m; }
	
	public ArrayList<Integer> printMatrix() {
        if(matrix == null) return null;
        ArrayList<Integer> result = new ArrayList<>();
        int r_min = 0;
        int r_max = matrix.length - 1;
        int c_min = 0;
        int c_max = matrix[0].length - 1;
        while(r_min <= r_max && c_min <= c_max) {
            for(int j = c_min; j <= c_max; j++) result.add(matrix[r_min][j]);
            
            for(int i = r_min + 1; i <= r_max; i++) result.add(matrix[i][c_max]);
            
            if(r_min < r_max) {
                for(int j = c_max - 1; j >= c_min; j--) result.add(matrix[r_max][j]);
            }
            
            if(c_min < c_max) {
                for(int i = r_max - 1; i > r_min; i--) result.add(matrix[i][c_min]);
            }
            
            r_min++; r_max--; c_min++; c_max--; 
        }
        return result;
    }
}
