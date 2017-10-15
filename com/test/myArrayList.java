package com.test;

public class myArrayList {

	public static class ListNode {
		int val;
		ListNode next = null;
		ListNode(int v) { val = v; }
	}
	
	private ListNode head;
	private ListNode tail;
	//private int pos = 0;
	
	myArrayList() {
		head = null;
		tail = null;
	}
	
	myArrayList(ListNode n) {
		head = n;
		tail = n;
	}
	
	myArrayList(int v) {
		head = new ListNode(v);
		tail = head;
	}
	
	myArrayList(int[] values) {
		if(values.length == 0) {
			head = null;
			tail = null;
		}else {
			head = new ListNode(values[0]);
			ListNode p = head;
			for(int i = 1; i < values.length; i++) {
				p.next = new ListNode(values[i]);
				p = p.next;
			}
			tail = p;
		}	
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public ListNode getHead() {
		return head;
	}
	
	public void add(int v) {
		ListNode n = new ListNode(v);
		if(isEmpty()) {
			head = n;
			tail = n;
		}else {
			tail.next = n;
			tail = n;
		}
	}
	
	public void addBefore(int index, int v) {
		
	}
	
	public void addAfter(int index, int v) {
		
	}
	
	public ListNode FindKthToTail(int k) {
        ListNode p = head;
        int i = 1;
        while(p.next != null && i < k) {
            p = p.next;
            i++;
        }
        if(i != k) return null;
        ListNode q = head;
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
	
	public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        /*
        ListNode preNode = null;
        ListNode currNode = head;
        ListNode nextNode;
        while(currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
        */
        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
