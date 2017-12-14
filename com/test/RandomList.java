package com.test;

import java.util.HashMap;

public class RandomList {

	public static class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) { this.label = label; }
	}
	
	public static RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode p = pHead;
        while(p != null) {
            RandomListNode pCloned = new RandomListNode(p.label);
            pCloned.next = p.next;
            p.next = pCloned;
            p = pCloned.next;
        }
        RandomListNode pClonedHead = pHead.next;
        p = pHead;
        while(p != null) {
            if(p.random != null) p.next.random = p.random.next;
            p = p.next.next;
        }
        p = pHead;
        RandomListNode pCloned = pClonedHead;
        while(p != null) {
            p.next = pCloned.next;
            if(pCloned.next != null) pCloned.next = p.next.next;
            p = p.next;
            pCloned = pCloned.next;
        }
        return pClonedHead;
    }
	
	public static RandomListNode Clone2(RandomListNode pHead) {
		if(pHead == null) return null;
		HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode p = pHead;
		while(p != null) {
			map.put(p, new RandomListNode(p.label));
			p = p.next;
		}
		p = pHead;
		while(p != null) {
			map.get(p).next = map.get(p.next);
			map.get(p).random = map.get(p.random);
			p = p.next;
		}
		return map.get(pHead);
	}
	
}
