package com.alg.leetcode;

/**
 * 
 * Definition for singly-linked list.
 * @author rbaral
 *
 */
public class ListNode {
	int val;
    ListNode next;
    String stringVal="";
    ListNode(int x) { val = x;
    	stringVal=String.valueOf(val)+toString();
    }
    
    public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public String toString(){
   	 String res=stringVal;
   	 ListNode nextNode;
   	 while((nextNode = this.next)!=null){
   		 res+=nextNode.val+",";
   		 System.out.println(res);
   		 next = next.next;
   	 }
   	 //res = res.substring(0,res.lastIndexOf(",")-1);
   	 return res;
    }

	public String getStringVal() {
		return toString();
	}
}