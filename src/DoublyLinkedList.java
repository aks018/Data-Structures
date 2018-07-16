class DoublyLinkedListNode{
    int data;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode()
    {
        data = 0;
        prev = null;
        next = null;
    }

    public DoublyLinkedListNode(int data, DoublyLinkedListNode prev, DoublyLinkedListNode next)
    {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }

    /* Function to set link to next node */
    public void setLinkNext(DoublyLinkedListNode n){
        next = n;
    }

    public void setLinkPrev(DoublyLinkedListNode n){
        prev = n;
    }

    public DoublyLinkedListNode getLinkNext()
    {
        return next;
    }

    public DoublyLinkedListNode getLinkPrev(){
        return prev;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public int getData()
    {
        return data;
    }
}

public class DoublyLinkedList {
    DoublyLinkedListNode start;
    DoublyLinkedListNode end;
    int size;

    public DoublyLinkedList(){
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public int getSize(){
        return size;
    }

    public void insertAtStart(int val)
    {
        DoublyLinkedListNode nptr = new DoublyLinkedListNode(val, null, null);
        if(start == null){
            start = nptr;
            end = start;
        }

        else{
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
    }

    public void insertAtEnd(int val)
    {
        DoublyLinkedListNode nptr = new DoublyLinkedListNode(val, null, null);
        if(start == null)
        {
            start = nptr;
            end = start;
        }

        else
        {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
    }

    public void insertAtPos(int val, int pos)
    {
        DoublyLinkedListNode nptr = new DoublyLinkedListNode(val, null, null);
        if(pos == 1)
        {
            insertAtStart(val);
            return;
        }

        DoublyLinkedListNode ptr = start;
        for(int i=2; i<=size; i++)
        {
            if(i==pos)
            {
                DoublyLinkedListNode temp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(temp);
                temp.setLinkPrev(nptr);
            }
            else
                ptr = ptr.getLinkNext();
        }

        size++;

    }

    public void deleteAtPos(int val, int pos)
    {
        if(pos == 1)
        {
            if(size==1)
            {
                start = null;
                end = null;
                size = 0;
                return;
            }
            start = start.getLinkNext();
            start.setLinkPrev(null);
            size --;
            return;
        }

        if(pos == size)
        {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size --;
        }

        DoublyLinkedListNode ptr = start.getLinkNext();
        for(int i=2; i<=size; i++)
        {
            if(i==pos)
            {
                DoublyLinkedListNode p = ptr.getLinkPrev();
                DoublyLinkedListNode n = ptr.getLinkPrev();

                p.setLinkNext(n);
                n.setLinkPrev(p);

                size--;
                return;
            }
            else
            {
                ptr = ptr.getLinkNext();
            }
        }
    }
}
