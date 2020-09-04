package template.list;

public class 链表判交叉 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);

        ListNode na = new ListNode(7);
        ListNode nb = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        na.next = nb;
        nb.next = n4;

        ListNode p = n1;
        ListNode q = na;

        while (p != q){
            if(p == null){
                p = na;
            }else {
                p = p.next;
            }
            if (q == null){
                q = n1;
            }else {
                q = q.next;
            }
        }
        if (p != null){
            System.out.println(p.val);
        }else {
            System.out.println("False");
        }

    }
}
