package com.epam.list_example.runner;

import com.epam.list_example.entity.MyList;

public class ListExampleMain {

	public static void main(String[] args) {
		MyList list = new MyList();
		list.addFirst("1");
		list.addElement("a");
		list.addElement("b");
		list.addFirst("1");
		list.addElement("c");
		list.printList();
		System.out.println("---");
		list.addFirst("1");
		list.addElement(2, "middle");
		list.printList();
		System.out.println("---");
		System.out.println(list.findElement(0));
		System.out.println(list.findElement("c"));
		System.out.println("---");
		list.removeElement(0);
		list.printList();
		
	}
}
