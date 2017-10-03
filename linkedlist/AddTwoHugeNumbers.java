/**
 * You're given 2 huge integers represented by linked lists. Each linked list element is a number from 0 to 9999 that represents a number with exactly 4 digits. The represented number might have leading zeros. Your task is to add up these huge integers and return the result in the same format.

	Example

    For a = [9876, 5432, 1999] and b = [1, 8001], the output should be
    addTwoHugeNumbers(a, b) = [9876, 5434, 0].

    Explanation: 987654321999 + 18001 = 987654340000.

    For a = [123, 4, 5] and b = [100, 100, 100], the output should be
    addTwoHugeNumbers(a, b) = [223, 104, 105].

    Explanation: 12300040005 + 10001000100 = 22301040105.

 * @author Valentina Palghadmal
 *
 */
public class AddTwoHugeNumbers {

	public static void main(String[] args) {
		ListNode<Integer> l = new ListNode<Integer>(0);
		ListNode<Integer> b = new ListNode<Integer>(1234);
		b.next = new ListNode<Integer>(123);
		b.next.next = new ListNode<Integer>(0);
		//print(l);
		//print(b);
		//System.out.println("------------");
		print(addTwoHugeNumbers(l, b));

	}

	static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
		if (a == null)
			return b;
		else if (b == null)
			return a;
		a = reverseList(a);
		b = reverseList(b);

		int temp = 0;
		int carry = 0;
		ListNode<Integer> head = a;
		while (a != null && b != null) {
			temp = a.value + b.value + carry;
			carry = temp / 10000;
			a.value = temp % 10000;
			a = a.next;
			b = b.next;
			temp = 0;
		}
		if (a != null) {
			a.value = a.value + carry;
		}

		else if (b != null) {
			ListNode<Integer> t = b;
			while (b != null) {
				temp = b.value + carry;
				carry = temp / 10000;
				b.value = temp % 10000;
				b = b.next;
			}
			b = reverseList(t);
			if (carry != 0) {
				t = new ListNode(carry);
				t.next = b;
				b = t;
			}
			// print(b);

		}
		a = reverseList(head);

		// print(a);
		if (b != null) {
			head = b;
			while (b.next != null) {
				b = b.next;
			}
			b.next = a;
			return head;
		}
		if (carry != 0) {
			head = new ListNode(carry);
			head.next = a;
			a = head;
		}
		return a;
	}

	static ListNode<Integer> reverseList(ListNode<Integer> current) {
		ListNode<Integer> prev = null;
		ListNode<Integer> next = null;
		// reversing the list
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	static void print(ListNode<Integer> l) {
		while (l != null) {
			System.out.print(l.value + "\t");
			l = l.next;
		}
		System.out.println("\n");

	}

}
