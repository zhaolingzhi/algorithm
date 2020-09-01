package template.list;


public class 链表逆序 {
    public ListNode reverse(ListNode head, ListNode endPos){
        ListNode h = new ListNode(0);
        ListNode pos = head;
        while(pos != endPos){
            ListNode t = pos.next;
            pos.next = h.next;
            h.next = pos;
            pos = t;
        }
        return h.next;
    }
}
