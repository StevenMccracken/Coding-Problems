public class SumLinkedLists {
	public static void main(String[] args) {
		ListNode num1 = new ListNode(7);
		num1.next = new ListNode(1);
		num1.next.next = new ListNode(7);
		
		ListNode num2 = new ListNode(5);
		num2.next = new ListNode(9);
		num2.next.next = new ListNode(2);
		
		ListNode sum = sum(num1, num2);

		System.out.print("("); num1.printNodes();System.out.print(") + (");
		num2.printNodes(); System.out.print(") = (");
		sum.printNodes(); System.out.print(")\n");
	}
	
	/**
	 * Sums two linked lists as if their nodes were digits of a number.
	 * The head of the linked list is considered the least significant digit.
	 * @param num1 the head of the first linked list
	 * @param num2 the head of the second linked list
	 * @return the head of a linked list containing the sum of num1 and num2
	 */
	public static ListNode sum(ListNode num1, ListNode num2) {
		if(num1 == null) return num2;
		if(num2 == null) return num1;
		
		ListNode[] ranked = rankNodes(num1,num2);
		ListNode smaller = ranked[0], bigger = ranked[1], sumHead = new ListNode(), ret = sumHead;
		
		boolean carry = false, first = true;
		while(smaller != null) {
			int sum = smaller.val + bigger.val + (carry ? 1 : 0);
			if(sum > 9) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			
			
			if(first) {
				ret = sumHead;
				first = false;
			}
			
			smaller = smaller.next;
			bigger = bigger.next;
			
			sumHead.val = sum;
			if(bigger != null) {
				sumHead.next = new ListNode();
				sumHead = sumHead.next;
			}
		}
		
		while(bigger != null) {
			int sum = bigger.val + (carry ? 1 : 0);
			if(sum > 9) {
				carry = true;
				sum -= 10;
			} else {
				carry = false;
			}
			
			bigger = bigger.next;
			
			sumHead.val = sum;
			if(bigger != null) {
				sumHead.next = new ListNode();
				sumHead = sumHead.next;
			}
		}
		
		if(carry) {
			sumHead.next = new ListNode();
			sumHead.next.val = 1;
		}
		
		return ret;
	}
	
	/**
	 * Ranks two nodes based on the sum of all of their nodes.
	 * @param a the first node
	 * @param b the second node
	 * @return an array of 2 nodes where the 0th index is the smaller node
	 */
	public static ListNode[] rankNodes(ListNode a, ListNode b) {
		int size1 = 0, size2 = 0;
		ListNode smaller = a, bigger = b;
		
		while(smaller != null || bigger != null) {
			if(smaller != null) {
				size1++;
				smaller = smaller.next;
			}
			if(bigger != null) {
				size2++;
				bigger = bigger.next;
			}
		}
		
		ListNode[] ranked = new ListNode[2];
		ranked[0] = size1 <= size2 ? a : b;
		ranked[1] = size1 <= size2 ? b : a;
		return ranked;
	}
}