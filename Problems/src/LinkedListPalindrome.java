public class LinkedListPalindrome {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.printNodes();
		System.out.println(isLinkedListPalindrome(head) ? " is a palindrome." : " is not a palindrome.");
		
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.printNodes();
		System.out.println(isLinkedListPalindrome(head) ? " is a palindrome." : " is not a palindrome.");
		
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);
		head.printNodes();
		System.out.println(isLinkedListPalindrome(head) ? " is a palindrome." : " is not a palindrome.");
		
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		head.printNodes();
		System.out.println(isLinkedListPalindrome(head) ? " is a palindrome." : " is not a palindrome.");
		
		head.val = 7;
		head.printNodes();
		System.out.println(isLinkedListPalindrome(head) ? " is a palindrome." : " is not a palindrome.");
	}

	public static boolean isLinkedListPalindrome(ListNode head) {
		if(head == null) return false;
		if(head.next == null) return true;
		if(head.next.next == null && head.val == head.next.val) return true;
		
		ListNode fast = head, slow = head;
		// Find midpoint of list
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// List is of odd length, so skip the middle element
		if(fast != null) {
			slow = slow.next;
		}
		
		// Reverse 2nd half
		slow = slow.reverseList();
		
		// Compare each node of list halves. They should be identical.
		while(slow != null) {
			if(head.val != slow.val) return false;
			slow = slow.next;
			head = head.next;
		}
		return true;
	}
}