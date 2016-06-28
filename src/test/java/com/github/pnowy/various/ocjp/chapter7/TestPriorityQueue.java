package com.github.pnowy.various.ocjp.chapter7;

import java.util.Collections;
import java.util.PriorityQueue;

public class TestPriorityQueue
{

    public static void main(String[] args)
    {
	PriorityQueue<String> pq = new PriorityQueue<String>();
	pq.add("2");
	pq.add("4");
	System.out.println(pq.peek());
	pq.offer("1");
	pq.add("3");
	pq.remove("1");
	System.out.println(pq.poll()+ " ");
	if (pq.remove("2")) System.out.println(pq.poll());
//	System.out.println(Collections.reverse(pq));
    }

}
