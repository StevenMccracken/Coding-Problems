public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
        this.val = 0;
    }
    ListNode(int x) { this.val = x; }

    public void printNodes() {
        ListNode curr = this;
        while(curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if(curr != null) {
                System.out.print(" -> ");
            }
        }
    }

    // Reverses a linked list of nodes and returns the new head node
    public ListNode reverseList() {
        if(this == null || this.next == null) return this;
        ListNode oldHead = this, newHead = null;
        while(oldHead != null) {
            ListNode next = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = next;
        }
        return newHead;
    }
}