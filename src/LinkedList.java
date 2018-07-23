import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

    public LinkedListNode mergeTwoListsRecursive(LinkedListNode l1, LinkedListNode l2)
    {
        if(l1 == null ) return l2;
        if(l2 == null) return l1;

        if(l1.data <= l2.data) {
            mergeTwoListsRecursive(l1.next, l2);
            return l1;
        }
        else
        {
            mergeTwoListsRecursive(l1,l2.next);
            return l2;
        }
    }

    public LinkedListNode mergeTwoLists(LinkedListNode l1, LinkedListNode l2)
    {
        if(l1 == null && l2 == null)
            return null;
        if(l1==null)
            return l2;
        if(l2 == null)
            return l1;

        LinkedListNode result = new LinkedListNode(0);
        LinkedListNode cur = result;

        while(l1!=null && l2==null)
        {
            if(l1.data <= l2.data)
            {
                cur.next = l1;
                l1 = l1.next;
            }
            else
            {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1!=null)
        {
            cur.next = l1;
        }
        if(l2!=null)
        {
            cur.next = l2;
        }

        return result.next;
    }

    public LinkedListNode deleteDuplicates(LinkedListNode head)
    {
        LinkedListNode ans = head;

        while(ans!=null && ans.next!=null)
        {
            if(ans.data == ans.next.data)
            {
                ans.next = ans.next.next;
            }
            else
            {
                ans = ans.next;
            }
        }

        return head;
    }

    public boolean hasCycle(LinkedListNode head)
    {
        if(head == null)
            return false;

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast)
                return true;
        }
        return false;
    }

    public LinkedListNode plusOne(LinkedListNode head){
        if(plusOneHelper(head) == 0)
        {
            return head;
        }

        LinkedListNode node = new LinkedListNode(1);
        node.next = head;
        return node;
    }

    public int plusOneHelper(LinkedListNode node)
    {
        if(node == null) return 1;

        int sum = node.data + plusOneHelper(node);
        node.data = sum%10;
        return sum/10;
    }

    public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2)
    {
        LinkedListNode ans = new LinkedListNode(0);
        LinkedListNode head = ans;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0)
        {
            LinkedListNode cur = new LinkedListNode(0);
            int sum = ((l2==null) ? 0:l2.data) + ((l1==null)?0:l1.data) + carry;
            cur.data = sum%10;
            carry = sum%10;
            ans.next = cur;
            ans = cur;

            l1 = ((l1==null) ? l1 : l1.next);
            l2 = ((l2==null) ? l2 : l2.next);

        }

        return head.next;


    }

    public LinkedListNode addTwoNumbersPartTwo(LinkedListNode l1, LinkedListNode l2)
    {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1!=null)
        {
            s1.push(l1.data);
            l1 = l1.next;
        }

        while(l2!=null)
        {
            s2.push(l2.data);
            l2 = l2.next;
        }

        int sum =0;
        LinkedListNode head = new LinkedListNode(0);

        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();

            head.data = sum%10;
            LinkedListNode cur = new LinkedListNode(0);
            cur.next = head;
            head = cur;

            sum/=10;

        }

        return head.data == 0 ? head.next : head;

    }

    public int numComponents(LinkedListNode head, int[] G)
    {
        Set<Integer> s = new HashSet<>();
        for(int i:G) s.add(i);
        int total = 0;
        while(head!=null)
        {
            if(s.contains(head.data) && (!s.contains(head.next.data) || head.next==null))
            {
                total++;
            }
            head = head.next;
        }

        return total;
    }



}
