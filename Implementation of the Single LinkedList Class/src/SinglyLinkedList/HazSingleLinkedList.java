package SinglyLinkedList;

public class HazSingleLinkedList<E> {
	//IMPLEMENT A NODE
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
//		Constructor --> creates a new node with a null next field
		private Node(E dataItem) {
			this.data = dataItem;
			this.next = null;
		}
		
		//Constructor --> Creates a node that references another node
		private Node(E dataItem, Node<E> nodeRef) {
			data = dataItem;
			next = nodeRef;
		}
		
		public E getData() {
			return data;
		}
		
		public Node<E> getNext(){
			return next;
		}
		
		public void setNext(Node<E> nodeRef) {
			next = nodeRef;
		}
	}
	
//	List Implementation
	private Node<E> head = null;
	private Node<E> tail = null;
	
	public HazSingleLinkedList() {
		
	};
	
	private int size = 0;
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

//	get first element in the list
	public E first() {
		if(isEmpty()) {
			return null;
		}
		return head.getData();
	}
	
//	get last element in the list
	public E last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getData();
	}
	
//	Implementing .addFirst(E item)
	public void addFirst(E item) {
		Node<E> temp = new Node<E>(item, head);
		head = temp;
		size++;
	}
	
//	Implementing .addAfter(Node<E> node, E item)
	private void addAfter(Node<E> node, E item) {
		Node<E> temp = new Node<E>(item, node.next);
		node.next = temp;
		size++;
	}
	
//	Implementing .removeAfter(Node<E> node)
	private E removeAfter(Node<E> node) {
		Node<E> temp = node.next;
		if(temp != null) {
			node.next = temp.next;
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
//	Implementing .removeFirst()
	private E removeFirst() {
		Node<E> temp = head;
		if(head != null) {
			head = head.next;
		}
		if(temp != null) {
			size--;
			return temp.data;
		} else {
			return null;
		}
	}
	
//	Implementing .toString()
	public String toString() {
		Node<String> nodeRef = (Node<String>) head;
		StringBuilder result = new StringBuilder();
		while(nodeRef != null) {
			result.append(nodeRef.data);
			if(nodeRef.next != null) {
				result.append(" ==> ");
			}
			nodeRef = nodeRef.next;
		}
		return result.toString();
	}
	
//	Implementing .getNode(int)
	private Node<E> getNode(int index){
		Node<E> node = head;
		for(int i = 0; i < index && node != null; i++) {
			node = node.next;
		}
		return node;
	}
	
//	Implementing .get(int index)
	public E get(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		return node.data;
	}
	
//	Implementing .set(int index, E newValue)
	public E set(int index, E anEntry){
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		Node<E> node = getNode(index);
		E result = node.data;
		node.data = anEntry;
		return result;
	}
	
//	Implementing .add(int index, E item)
	public void add(int index, E item) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		if(index == 0) {
			addFirst(item);
		} else {
			Node<E> node = getNode(index - 1);
			addAfter(node, item);
		}
	}
}
