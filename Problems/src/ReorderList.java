public class ReorderList {
	/*
	 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
		reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

		You must do this in-place without altering the nodes' values.
	 */
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		head.printNodes();
		System.out.println();
		reorderList(head);
		head.printNodes();
	}

	
	public static void reorderList(ListNode head) {
		// Do nothing if list is 0, 1, or 2 nodes deep
		if(head == null || head.next == null || head.next.next == null) return;
		
		// Swap middle and last nodes if list is only 3 nodes deep
		if(head.next.next.next == null) {
			ListNode mid = head.next;
			head.next = head.next.next;
			head.next.next = mid;
			mid.next = null;
			return;
		}
		
		// Find midpoint
		ListNode slow = head, fast = head, prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null; // Split two lists at midpoint
		
		// Reverse the second half
		ListNode l2 = slow.reverseList();
		
		// Merge two lists one by one
		while (head != null) {
			ListNode n1 = head.next, n2 = l2.next;
	        head.next = l2;
	        
	        if (n1 == null) break;
	            
	        l2.next = n1;
	        head = n1;
	        l2 = n2;
      }
    }
}