package com.test;

public class StringMatch {

	private String pstr;
	private int plen;
	private int[] next;
	
	StringMatch(String str) {
		pstr = new String(str);
		plen = pstr.length();
		next = new int[plen];
		this.getNext();
	}
	
	public void getNext() {
		next[0] = -1;
		int j = 0;
		int k = -1;
		while(j < plen - 1) {
			if(k == -1 || pstr.charAt(j) == pstr.charAt(k)) {
				++j;
				++k;
				if(pstr.charAt(j) != pstr.charAt(k)) {
					next[j] = k;
				}else {
					next[j] = next[k];
				}
			}else {
				k = next[k];
			}
		}
	}
	
	public int KMP(String sstr) {
		int slen = sstr.length();
		int i = 0, j = 0;
		while(i < slen && j < plen) {
			if(j == -1 || sstr.charAt(i) == pstr.charAt(j)) {
				++i;
				++j;
			}else {
				j = next[j];
			}
		}
		if(j == plen) {
			return i - j;
		}else {
			return -1;
		}
	}
	
	public int BM(String sstr) {
		return -1;
	}
}
