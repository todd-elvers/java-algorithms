package te.interview.prep.linked_lists;

import te.interview.prep.linked_lists.domain.Node;

import java.util.Stack;

//TODO: Can be done better using the fast/slow runner technique
public class PalindromeDetector {

    boolean isPalindrome(Node<Character> head) {
        // Determine length & hydrate first stack
        int length = 0;
        Node<Character> n = head;
        Stack<Character> allChars = new Stack<>();
        while (n != null) {
            allChars.push(n.data);
            n = n.next;
            length++;
        }

        // Pop half of the values onto our second stack
        boolean isEvenLength = length % 2 == 0;
        int pivot = isEvenLength ? length / 2 : (length / 2) + 1;
        Stack<Character> halfChars = new Stack<>();
        while(pivot > 0) {
            if(pivot == 1 && !isEvenLength) {
                // Ignore middle character in strings w/ odd # of chars
                allChars.pop();
            } else {
                halfChars.push(allChars.pop());
            }
            pivot--;
        }

        // Check for palindrome
        while(!allChars.empty()) {
            if(!allChars.pop().equals(halfChars.pop())) {
                return false;
            }
        }

        return true;
    }

}
