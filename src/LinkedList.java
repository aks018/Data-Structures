class LinkedListNode{
    int data;
    LinkedListNode next;

    public LinkedListNode(int val)
    {
        this.data = val;
    }
}
public class LinkedList {
    LinkedListNode head;

    public LinkedList()
    {
        head = null;
    }


    public LinkedListNode findMiddleElement()
    {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast.next!= null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    /*

    Leetcode Problem #206

     */

    /*Iterative method for reversing a linkedlist*/
    public LinkedListNode reverseLinkedList(LinkedListNode head)
    {
        LinkedListNode prev = null;
        LinkedListNode cur = head;
        LinkedListNode next = null;
        while(cur!=null)
        {
            next = cur.next;
            cur.next= prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public LinkedListNode reverseLinkedListRecursive(LinkedListNode head)
    {
        if(head == null)
            return null;
        else if(head.next == null)
            return head;
        else{
            LinkedListNode nextNode = head.next;
            head.next = null;
            LinkedListNode rest = reverseLinkedListRecursive(nextNode);
            nextNode.next = head;
            return rest;
        }
    }


    public void deleteNode(LinkedListNode node)
    {
        if(node.next!=null) {
            node.data = node.next.data;
            node.next = node.next.next;
        }
        else
        {
            node = null;
        }
    }



}
