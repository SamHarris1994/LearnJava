package com.test;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.LinkedList;

public class StringSolutions {

	public static ArrayList<String> Permutation(String str) {
        ArrayList<String> ans = new ArrayList<>();
        if(str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, ans);
            Collections.sort(ans);
        }
        return ans;
    }
	public static void PermutationHelper(char[] cs, int k, ArrayList<String> ans) {
        if(k == cs.length - 1){
            ans.add(String.valueOf(cs));
        }else {
            for(int i = k; i < cs.length; i++) {
                if(i == k || cs[i] != cs[k]) {
                    swap(cs, i, k);
                    PermutationHelper(cs, k + 1, ans);
                    swap(cs, i, k);
                }
            }
        }
    }
    public static void swap(char[] cs, int i, int k) {
        char temp = cs[i];
        cs[i] = cs[k];
        cs[k] = temp;
    }
    
    public class myChar {
    	char ch;
    	int ind;
    	myChar(char c, int i) { ch = c; ind = i; }
    }
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() <= 0) return -1;
        char[] cs = str.toCharArray();
        int[] counter = new int['z' + 1];
        for(char c : cs) counter[c]++;
        for(int i = 0; i < cs.length; i++) {
        	if(counter[cs[i]] == 1) return i;
        }
        return -1;
        /*
        LinkedList<myChar> q = new LinkedList<>();
        for(int i = 0; i < cs.length; i++) {
        	if(counter[cs[i]] == 0) q.offer(new myChar(cs[i], i));
        	counter[cs[i]]++;
        }
        while(!q.isEmpty()) {
        	myChar mc = q.poll();
        	if(counter[mc.ch] == 1) return mc.ind;
        }
        return -1;
        */
    }
    
    //private LinkedList<Character> appearedChar = new LinkedList<>();
    private StringBuilder appearedChar2 = new StringBuilder();
    private int[] counts = new int[128];
    public void InsertFromStream(char ch) {
    	//if(counts[ch] == 0) appearedChar.offer(ch);
    	if(counts[ch] == 0) appearedChar2.append(ch);
        counts[ch]++;
    }
    public char FirstCharAppearingOnce() {
    	/*
        while(!appearedChar.isEmpty() && counts[appearedChar.peek()] > 1) {
        	appearedChar.poll();
        }
        if(appearedChar.isEmpty()) return '#';
        return appearedChar.peek();
        */
        char[] cs = appearedChar2.toString().toCharArray();
        int len = cs.length;
        for(int i = 0; i < len; i++) {
            if(counts[cs[i]] == 1) return cs[i];
        }
        return '#';
    }
    
}
