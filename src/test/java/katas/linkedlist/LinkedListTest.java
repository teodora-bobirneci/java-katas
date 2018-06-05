package katas.linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LinkedListTest
{

	@Test
	public void whenAddingTheNodeToAnEmptyList_listContainsJustThatElement()
	{
		LinkedList list = new LinkedList();
		LinkedListNode nodeToAdd = new LinkedListNode("asd");
		list.add(nodeToAdd);

		assertEquals(1, list.size());
		assertEquals(nodeToAdd, list.first());
	}

	@Test
	public void whenAddingASecondElement_itIsInsertedAsSecondAndSizeIsUpdated()
	{
		LinkedList list = new LinkedList();
		LinkedListNode firstNodeToAdd = new LinkedListNode("asd");
		LinkedListNode secondNodeToAdd = new LinkedListNode("adsadsasd");

		list.add(firstNodeToAdd);
		list.add(secondNodeToAdd);

		assertEquals(2, list.size());
		assertEquals(firstNodeToAdd, list.first());
		assertEquals(secondNodeToAdd, list.first().next());
	}
}
