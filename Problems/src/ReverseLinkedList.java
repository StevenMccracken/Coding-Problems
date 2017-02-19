public class ReverseLinkedList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.printNodes();
		
		head = reverseBetween(head,2,4);
		System.out.println();
		head.printNodes();
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		int counter = 1;
		ListNode curr = head, prev = null;
		while(counter++ != m) {
			prev = curr;
			curr = curr.next;
		}
		counter--;
		
		ListNode curr2 = curr, innerHead = null, next = null;
		while(counter++ != n+1) {
			next = curr2.next;
			curr2.next = innerHead;
			innerHead = curr2;
			curr2 = next;
		}
		
		if(prev != null) prev.next = innerHead;
		else head = innerHead;
		curr.next = curr2;
		
        return head;
    }
}