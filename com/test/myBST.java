package com.test;

public class myBST {

	public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }
	
    public static boolean isBST(int[] sequence, int start, int end) {
        if(end <= start) return true;
        int i;
        for(i = start; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for(int j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        return isBST(sequence, start, i - 1) && isBST(sequence, i, end - 1);
    }
}
