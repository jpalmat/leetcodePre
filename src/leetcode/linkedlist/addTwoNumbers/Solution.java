package leetcode.linkedlist.addTwoNumbers;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 1;
        head.next = null;

        ListNode head1 = new ListNode();
        head1.val = 8;
        head1.next = null;

        insertItem(head, head1);

        ListNode head2 = new ListNode();
        head2.val = 0;
        head2.next = null;

        System.out.println(addTwoNumbers(head, head2));
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        Long total = getVal(l1) + getVal(l2);
//        StringBuilder totalString = new StringBuilder(String.valueOf(total));
//        totalString.reverse();
//        String test = String.valueOf(totalString.charAt(0));
//        ListNode head = new ListNode(Integer.valueOf(String.valueOf(totalString.charAt(0))), null);
//        for(int i = 1; i < totalString.length(); i++){
//            ListNode n = new ListNode();
//            n.val = Integer.valueOf(String.valueOf(totalString.charAt(i)));
//            n.next = null;
//            insertItem(head, n);
//        }
//
//        return head;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        int mod = 0;
        int sum = 0;
        boolean createHead = true;
        ListNode head = new ListNode();
        StringBuilder sbHelper = new StringBuilder();
        while(true){
            sbHelper.setLength(0);
            if(node1 == null && node2 == null){
                break;
            }
            sum = (node1 == null ? 0 : node1.val) + (node2 == null ? 0 : node2.val)  + mod;
            mod = sum/10;
            if(sum > 9){
                sbHelper.append(sum);
                sum = Integer.valueOf(String.valueOf(sbHelper.charAt(sbHelper.length() - 1)));
            }

            if(createHead){
                head.val = sum;
                head.next = null;
                createHead = false;
            } else {
                ListNode n = new ListNode();
                n.val = sum;
                n.next = null;
                insertItem(head, n);
            }
            node1 = node1 == null ? node1 :  node1.next;
            node2 = node2 == null ? node2 :  node2.next;
        }

        if(mod>0){
            ListNode n = new ListNode();
            n.val = mod;
            n.next = null;
            insertItem(head, n);
        }

        return head;
    }

    public static void insertItem(ListNode head, ListNode nodeInsert) {
        ListNode node = head;
        while (true){
            if(node.next == null){
                node.next = nodeInsert;
                break;
            }
            node = node.next;
        }

    }

    private Long getVal(ListNode l1) {
        StringBuilder sb = new StringBuilder();
        ListNode node = l1;
        while(node!=null){
            sb.append(node.val);
            node = node.next;
        }
        sb.reverse();
        return Long.valueOf(sb.toString());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}