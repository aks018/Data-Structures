import java.util.HashMap;
import java.util.Map;

public class RandomLinkedList {
    class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };

    public RandomListNode copyRandomList(RandomListNode head)
    {
        if(head==null)
            return null;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;

        while(curr!=null)
        {
            map.put(curr, new RandomListNode(curr.label));
            curr = curr.next;
        }

        for(Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet())
        {
            RandomListNode newNode = entry.getKey();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}
