import java.util.*;

class LinkedList {
    public static void main(String[] args) {

//        println(findMaxLength(new int[]{0, 1}));
        ListNode head = new ListNode(0);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
//        printListNode(head);
//        println("============ Reverting ============");
//        printListNode(revert(head));
//        printListNode(reverseBetween(head, 2, 4));
//        println(removeDuplicates(new int[]{1,1,2}));


//        long start = System.currentTimeMillis();
//        long end = 0;
//
//        start = System.currentTimeMillis();
//        println(fibonacci_dp(48));
//        end = System.currentTimeMillis();
//        println("DP: " + ((end - start) / 1000) + "s");
//
//        start = System.currentTimeMillis();
//        end = 0;
//        println(fibonacci_classic(48));
//        end = System.currentTimeMillis();
//        println("Classico: " + (end - start) / 1000 + "s");

        for(int i: intersect(new int[] {1,2,2,1}, new int[]{2,2})) {
            println(i);
        }
    }

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        println(set);
        return set.size();
        // [0l,0r,1,1,1,2,2,3,3,4]
        // while left < right && right < nums.length
        // when left != right => left++, right++;
    }

    public static int fibonacci_classic(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci_classic(n - 1) + fibonacci_classic(n - 2);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // [1,2i,2,1]
        // [2,2j]
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];

            for (int j = 0; j < nums2.length; j++) {
                if (target == nums2[j]) {
                    list.add(target);
                    break;
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    static HashMap<Integer, Long> memo = new HashMap<>();
    public static long fibonacci_dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, fibonacci_dp(n -1) + fibonacci_dp(n -2));
        return memo.get(n);
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;

        ListNode currLeft = head;
        while (currLeft.val != left && currLeft.next != null) {
            currLeft = currLeft.next;
        }

        ListNode currRight = currLeft;
        while (currRight.val != right && currRight.next != null) {
            currRight = currRight.next;
        }

        ListNode oldNextRight = currRight.next;
        ListNode reverted = revert(currLeft);
        head.next = reverted;
        currLeft.next = oldNextRight;
        return head;
    }

    public static ListNode revert(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void printListNode(ListNode head) {
        ListNode dummy = head;

        while (dummy != null) {
            println(dummy.val);
            dummy = dummy.next;
        }
    }

    public static int findMaxLength(int[] nums) {
        int left = 0;
        int right = 0;
        int count0 = 0;
        int count1 = 0;
        // [0l,1, 1r]
        // 0s => 0
        // 1s => 2
        while (right < nums.length - 1) {
            if (nums[right] == 0) {
                count0++;
            } else {
                count1++;
            }

            right++;
        }

        while (count0 != count1) {
            if (nums[left] == 0) {
                count0--;
            } else {
                count1--;
            }

            left++;
        }

        return right - left + 1;
    }

    public static void println(Object obj) {
        System.out.println(obj == null ? "null" : obj);
    }
}