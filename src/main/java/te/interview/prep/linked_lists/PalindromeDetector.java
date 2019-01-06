package te.interview.prep.linked_lists;

import java.util.Stack;
import java.util.function.Function;

import te.interview.prep.linked_lists.domain.Node;

public class PalindromeDetector {

    enum Approach {

        NAIVE(head -> {
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
            while (pivot > 0) {
                if (pivot == 1 && !isEvenLength) {
                    // Ignore middle character in strings w/ odd # of chars
                    allChars.pop();
                } else {
                    halfChars.push(allChars.pop());
                }
                pivot--;
            }

            // Check for palindrome
            while (!allChars.empty()) {
                if (!allChars.pop().equals(halfChars.pop())) {
                    return false;
                }
            }

            return true;
        }),

        FAST_SLOW_RUNNER(head -> {
            if (head.next == null) return false;

            Stack<Character> stack = new Stack<>();
            Node<Character> fastRunner = head;
            Node<Character> slowRunner = head;

            while (fastRunner != null && fastRunner.next != null) {
                stack.push(slowRunner.data);
                slowRunner = slowRunner.next;
                fastRunner = fastRunner.next.next;
            }

            // If we are iterating two at a time on the fast runner, and we start on 0 which is even,
            // then if the fastRunner IS null at the end we have an even number of characters.
            boolean hasOddNumChars = fastRunner != null;

            // Edge case: ignore middle character in strings w/ odd # characters
            if (hasOddNumChars) {
                slowRunner = slowRunner.next;
            }

            while (slowRunner != null) {
                if (!slowRunner.data.equals(stack.pop())) {
                    return false;
                }
                slowRunner = slowRunner.next;
            }

            return true;
        });

        Function<Node<Character>, Boolean> function;

        Approach(Function<Node<Character>, Boolean> function) {
            this.function = function;
        }

        public boolean apply(Node<Character> data) {
            return function.apply(data);
        }
    }

}
