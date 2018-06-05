package katas.linkedlist;

class LinkedListNode
{
	private String data;
	private LinkedListNode next;

	LinkedListNode(String data)
	{
		this.data = data;
		this.next = null;
	}

	public LinkedListNode(String data, LinkedListNode next)
	{
		this.data = data;
		this.next = next;
	}

	public String data()
	{
		return data;
	}

	LinkedListNode next()
	{
		return next;
	}

	void next(LinkedListNode node)
	{
		this.next = node;
	}
}

