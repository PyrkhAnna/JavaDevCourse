package com.epam.list_example.entity;

public class MyList {
	private Node node;
	private Node linkPrev;
	private Node first;
	private Node last;
	private int size;

	public MyList() {
		node = new Node();
		size = 0;
	}

	public boolean addElement(Object o) {
		if (size == 0) {
			node.setElement(o);
			first = node;
			size++;
			last = node;
			return true;
		} else {
			if (size > 0) {
				Node current = new Node(o, null);
				node.setNext(current);
				node = current;
				size++;
				last = node;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean addElement(int index, Object o) {
		if (index >= 0 && index <= (size - 1)) {
			Node prevNode = findElement(index);
			Node currentNode = new Node(o, prevNode.getNext());
			prevNode.setNext(currentNode);
			size++;
			return true;
		} else {
			return false;
		}
	}

	public boolean addFirst(Object o) {
		if (size > 0) {
			Node current = new Node(o, first);
			first = current;
			size++;
			return true;
		} else if (addElement(o)) {
			return true;
		} else {
			return false;
		}
	}

	public Node findElement(int index) {
		if (index >= 0 && index < size) {
			Node current = first;
			for (int i = 0; i < index; i++) {
				linkPrev = current;
				current = current.getNext();
			}
			if (index == 0) {
				linkPrev = null;
			}
			return current;
		} else {
			return null;
		}
	}

	public Node findElement(Object o) {
		Node current = first;
		Node foundItem = null;
		int i = 0;
		do {
			if (current.getElement().equals(o)) {
				foundItem = current;
			} else {
				linkPrev = current;
				current = current.getNext();
				i++;
			}
		} while (foundItem == null && i < size);
		if (foundItem != null) {
			return foundItem;
		} else {
			return null;
		}
	}

	public boolean removeElement(int index) {
		if (index >= 0 && index < size) {
			Node currentNode = findElement(index);
			Node nextNode = currentNode.getNext();
			if (linkPrev != null) {
				linkPrev.setNext(nextNode);
			}
			first = nextNode;
			currentNode = null;
			size--;
			return true;
		} else {
			return false;
		}
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public Node getLast() {
		return last;
	}

	public void setLast(Node last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void printList() {
		Node a = first;
		while (a.getNext() != null) {
			System.out.println(a);
			a = a.getNext();
		}
		System.out.println(a);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyList other = (MyList) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
}
