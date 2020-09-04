package template.list;

public class 链表判环 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        ListNode p = n1;
        ListNode q = n3;

        while (p != q){
            p = p.next;
            q = q.next.next;
        }
        System.out.println(p.val);
    }
}
