package katas.linkedlist;

public class LinkedList
{

	private LinkedListNode first;

	LinkedList()
	{

	}

	public LinkedList(LinkedListNode first)
	{
		this.first = first;
	}

	LinkedListNode first()
	{
		return first;
	}

	void add(LinkedListNode node)
	{
		if (first == null)
		{
			this.first = node;
		}
		else
		{
			LinkedListNode current = first;
			while (current.next() != null)
				current = current.next();
			current.next(node);
		}
	}

	int size()
	{
		if (first == null)
			return 0;
		int size = 1;
		LinkedListNode current = first;
		while (current.next() != null)
		{
			size += 1;
			current = current.next();
		}
		return size;
	}
}
