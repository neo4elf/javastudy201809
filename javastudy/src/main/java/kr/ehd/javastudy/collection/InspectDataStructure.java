package kr.ehd.javastudy.collection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class InspectDataStructure {
	
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		Queue<String> pq = new PriorityQueue<>();
		Stack<String> s = new Stack<String>();
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		while(!q.isEmpty()) System.out.println(q.poll());
		
		System.out.println("==================================");
		
		pq.offer("2");
		pq.offer("1");
		pq.offer("3");

		while(!pq.isEmpty()) System.out.println(pq.poll());

		System.out.println("==================================");

		s.push("0");
		s.push("1");
		s.push("2");

		while(!s.isEmpty()) System.out.println(s.pop());
	}

}
