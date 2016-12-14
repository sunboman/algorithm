

import java.util.*;

/**
 * Created by sunbo on 11/2/2016.
 */
public class Test {
    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private static class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        if (dict.size() == 0) {
            return s.length() == 0;
        }
        int n = s.length();
        int maxLen = getMaxLength(dict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (!dp[i]) {
                continue;
            }
            for (int j = i + 1; j <= maxLen + i && j <= n; j++) {
                if (dict.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            cuts[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (j > 0) {
                        cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
                    } else {
                        cuts[i] = 0;
                    }
                }
            }
        }
        return cuts[n - 1];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 1; i <= m; i++) {
            if (s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1]) {
                dp[i] = true;
            }
        }

        for (int j = 1; j <= n; j++) {
            if (s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0]) {
                dp[0] = true;
            } else {
                dp[0] = false;
            }
            for (int i = 1; i <= m; i++) {
                boolean top = dp[i];
                boolean left = dp[i - 1];
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && left ||
                        s3.charAt(i + j - 1) == s2.charAt(j - 1) && top) {
                    dp[i] = true;
                } else {
                    dp[i] = false;
                }
            }

        }

        return dp[m];
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            int sub = Integer.parseInt(s.substring(i - 2, i));
            if (sub >= 10 && sub <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] dp = new int[m + 1];
        /*for (int i = 1; i <= m; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - A[j]] + A[j]);
                }
            }
        }*/
        for (int i = 0; i < A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i] <= j) {
                    dp[j] = Math.max(dp[j], A[i] + dp[j - A[i]]);
                }
            }
        }
        return dp[m];
    }

    public int backPackII(int m, int[] A, int V[]) {
        int[] dp = new int[m + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                if (j >= A[i]) {
                    dp[j] = Math.max(dp[j], V[i] + dp[j - A[i]]);
                }
            }
        }
        return dp[m];
    }

    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        int n = A.size();
        int[][] dp = new int[n][101];
        for (int i = 0; i <= 100; i++) {
            dp[0][i] = Math.abs(A.get(0) - i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - target); k <= Math.min(100, j + target); k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(j - A.get(i)));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 100; i++) {
            result = Math.min(result, dp[n - 1][i]);
        }

        return result;
    }

    public List<String> wordBreakII(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        List<String>[] dp = new List[s.length() + 1];
        dp[0] = new ArrayList<>(0);
        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null) {
                continue;
            }
            for (String word : wordDict) {
                int len = word.length();
                if (i + len > s.length()) {
                    continue;
                }
                String sub = s.substring(i, i + len);
                if (sub.equals(word)) {
                    if (dp[i + len] == null) {
                        dp[i + len] = new ArrayList<>();
                    }
                    dp[i + len].add(sub);
                }
            }
        }

        if (dp[s.length()] == null) {
            return result;
        } else {
            dfs(new StringBuffer(), result, s.length(), dp);
        }
        return result;
    }

    private void dfs(StringBuffer temp, List<String> result, int end, List<String>[] dp) {
        if (end <= 0) {
            result.add(temp.toString().trim());
            return;
        }
        for (String word : dp[end]) {
            StringBuffer newTemp = new StringBuffer();
            newTemp.append(word + " ");
            newTemp.append(temp);
            dfs(newTemp, result, end - word.length(), dp);
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pivotNode = new ListNode(head.val);
        ListNode left = new ListNode(0);
        ListNode lCurr = left;
        ListNode right = new ListNode(0);
        ListNode rCurr = right;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < pivotNode.val) {
                lCurr.next = new ListNode(curr.val);
                lCurr = lCurr.next;
            } else {
                rCurr.next = new ListNode(curr.val);
                rCurr = rCurr.next;
            }
            curr = curr.next;
        }
        left = sortList(left.next);
        right = sortList(right.next);
        ListNode result = new ListNode(0);
        if (left != null) {
            result.next = left;
            while (left.next != null) {
                left = left.next;
            }
            left.next = pivotNode;
        } else {
            result.next = pivotNode;
        }
        pivotNode.next = right;
        return result.next;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        int index = 0;
        ListNode curr = preHead;
        while (index + 1 < m) {
            curr = curr.next;
            index++;
        }
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode left = curr;
        while (index + 1 <= n) {
            curr = curr.next;
            if (curr != null) {
                stack.push(curr);
            }
            index++;
        }
        curr = curr.next;
        left.next = stack.peek();
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (stack.peek() != null) {
                node.next = stack.peek();
            } else {
                node.next = curr;
            }
        }
        return preHead.next;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> sets = new HashSet<>();
        while (head != null) {
            if (!sets.contains(head)) {
                sets.add(head);
            } else {
                return head;
            }
            head = head.next;
        }

        return null;
    }

    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>(2);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        while (i++ < nums.length) {
            int sum = nums[i];
            if (sum == 0) {
                result.add(i);
                result.add(i);
                return result;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }
        return result;
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public int twoSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low + 1 < high) {
                int mid = (low + high) >>> 1;
                if (nums[i] + nums[mid] == target) {
                    return 0;
                } else if (nums[i] + nums[mid] > target) {
                    gap = Math.min(gap, Math.abs(nums[i] + nums[mid] - target));
                    high = mid;
                } else {
                    gap = Math.min(gap, Math.abs(nums[i] + nums[mid] - target));
                    low = mid;
                }

            }
            if (low > i && low < nums.length && nums[i] + nums[low] == target) {
                return 0;
            }
            if (high > i && high < nums.length && nums[i] + nums[high] == target) {
                return 0;
            }

        }
        return gap;
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                swap(nums, 0, 1);
            }
            return;
        }
        int lo = 0;
        int lt = 1;
        int gt = nums.length - 1;
        int t = 1;
        while (lt <= gt) {
            if (nums[lt] < t) {
                swap(nums, lo++, lt++);
            } else if (nums[t] > t) {
                swap(nums, lt, gt--);
            } else {
                lt++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                result[0] = map.get(sum) + 1;
                result[1] = i;
                return result;
            } else {
                map.put(sum, i);
            }
        }
        Set<Integer> sortedSet = new TreeSet<>();
        sortedSet.addAll(map.keySet());
        int gap = Integer.MAX_VALUE;
        Iterator<Integer> it = sortedSet.iterator();
        Integer a = it.next();
        while (it.hasNext()) {
            Integer b = it.next();
            if (b - a < gap) {
                gap = b - a;
                int left = map.get(b);
                int right = map.get(a);
                result[0] = Math.min(left, right) + 1;
                result[1] = Math.max(left, right);
            }
            a = b;
        }
        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[0];
        }
        int[] result = new int[2];
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int index = Arrays.binarySearch(numbers, i + 1, numbers.length, t);
            if (index > i) {
                result[0] = i + 1;
                result[1] = index + 1;
                return result;
            }
        }
        return result;
    }

    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        Set<Integer> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                pointer.next = new ListNode(head.val);
                head = head.next;
                pointer = pointer.next;
            } else {
                head = head.next;
            }
        }

        return result.next;
    }

    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode next = node.next;
        while (next != null) {
            node.val = next.val;
            next = next.next;
            if (next != null) {
                node = node.next;
            }
        }
        node.next = null;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }

    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        boolean carry = false;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            if (carry) {
                val++;
            }
            if (val > 9) {
                carry = true;
            } else {
                carry = false;
            }
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && carry) {
            curr.next = new ListNode(1);
            carry = false;
        }
        if (l2 != null) {
            l1 = l2;
        }
        if (l1 != null) {
            curr.next = l1;
            while (carry) {
                int val = l1.val + 1;
                l1.val = val % 10;
                if (l1.next == null) {
                    l1.next = new ListNode(1);
                    carry = false;
                    break;
                }
                l1 = l1.next;
                if (val < 10) {
                    carry = false;
                }
            }
        }
        return result.next;
    }

    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>(2);
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode l1 = result;
        ListNode l2 = head;
        while (l2 != null) {
            if (l2.val == v1) {
                list.add(l1);
            }
            if (l2.val == v2) {
                list.add(l1);
            }
            if (list.size() == 2) {
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (list.size() == 2) {
            ListNode b1 = list.get(0);
            ListNode b2 = list.get(1);
            ListNode c1 = b1.next;
            ListNode c2 = b2.next;
            ListNode a1 = b1.next.next;
            ListNode a2 = b2.next.next;
            if (c1.next == c2) {
                b1.next = c2;
                c2.next = c1;
                c1.next = a2;
            } else if (c2.next == c1) {
                b2.next = c1;
                c1.next = c2;
                c2.next = a1;
            } else {
                b1.next = c2;
                c2.next = a1;
                b2.next = c1;
                c1.next = a2;
            }
        }
        return result.next;
    }

    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        ReturnType result = dfs(root);
        return result.first;
    }

    private class ReturnType {
        DoublyListNode first;
        DoublyListNode last;

        public ReturnType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }

    private ReturnType dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        DoublyListNode node = new DoublyListNode(root.val);
        ReturnType prev = dfs(root.left);
        ReturnType next = dfs(root.right);
        ReturnType result = new ReturnType(null, null);
        if (prev == null) {
            result.first = node;
        } else {
            result.first = prev.first;
            prev.last.next = node;
            node.prev = prev.last;
        }

        if (next == null) {
            result.last = node;
        } else {
            result.last = next.last;
            node.next = next.first;
            next.first.prev = node;
        }

        return result;
    }

    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(0);
            sum += num;
            if (sum >= 0) {
                sum = 0;
            }
            min = Math.min(min, sum);
        }
        return min;
    }


    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int one = 0;
        int two = 0;
        int n = prices.length;
        int[] gap = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            gap[i] = prices[i + 1] - prices[i];
        }
        int sum = 0;
        for (int i = 0; i < gap.length; i++) {
            sum += gap[i];
            one = Math.max(sum, one);
            if (one > two) {
                int temp = one;
                one = two;
                two = temp;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return one + two;
    }

    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        if (k == 0) {
            return;
        }
        int[] kArray = new int[k + 1];
        for (int color : colors) {
            kArray[color]++;
        }
        int index = 0;
        for (int i = 1; i <= k; i++) {
            int j = 0;
            while (j < kArray[i]) {
                colors[index++] = i;
            }
        }
    }

    public void sortColors22(int[] colors, int k) {
        if (colors == null || colors.length == 0) {
            return;
        }
        if (k == 0) {
            return;
        }
        int min = 1;
        int max = k;
        int start = 0;
        int end = colors.length - 1;
        while (min < max) {
            int curr = start;
            while (curr <= end) {
                if (colors[curr] == min) {
                    swap(colors, curr++, start++);
                } else if (colors[curr] > min && colors[curr] < max) {
                    curr++;
                } else {
                    swap(colors, curr, end--);
                }
            }
            min++;
            max--;
        }
    }

    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int n = nums.length;
        int[] lMin = new int[n];
        int[] lMax = new int[n];
        lMin[0] = nums[0];
        lMax[0] = nums[0];
        int minSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; i++) {
            if (minSum > 0) {
                minSum = 0;
            }
            if (maxSum < 0) {
                maxSum = 0;
            }
            minSum += nums[i];
            maxSum += nums[i];
            lMin[i] = Math.min(lMin[i - 1], minSum);
            lMax[i] = Math.max(lMax[i - 1], maxSum);
        }
        int[] rMin = new int[n];
        int[] rMax = new int[n];
        rMin[n - 1] = nums[n - 1];
        rMax[n - 1] = nums[n - 1];
        minSum = nums[n - 1];
        maxSum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (minSum > 0) {
                minSum = 0;
            }
            if (maxSum < 0) {
                maxSum = 0;
            }
            minSum += nums[i];
            maxSum += nums[i];
            rMin[i] = Math.min(rMin[i + 1], minSum);
            rMax[i] = Math.max(rMax[i + 1], maxSum);
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, Math.abs(lMin[i] - rMax[i + 1]));
            result = Math.max(result, Math.abs(lMax[i] - rMin[i + 1]));
        }
        return result;
    }

    private static class WordNote {
        String word;
        int steps;
        WordNote prev;

        public WordNote(String word, int steps, WordNote prev) {
            this.word = word;
            this.steps = steps;
            this.prev = prev;
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Set<String> unvisited = new HashSet<>();
        unvisited.addAll(dict);
        unvisited.add(end);
        LinkedList<WordNote> queue = new LinkedList<>();
        queue.offer(new WordNote(start, 1, null));
        int minSteps = -1;
        int prevSteps = 0;
        while (!queue.isEmpty()) {
            WordNote note = queue.poll();
            int currSteps = note.steps;

            if (note.word.equals(end)) {
                if (minSteps == -1) {
                    minSteps = currSteps;
                }

                if (minSteps > 0 && currSteps == minSteps) {
                    List<String> temp = new ArrayList<>();
                    while (note != null) {
                        temp.add(0, note.word);
                        note = note.prev;
                    }
                    result.add(new ArrayList<>(temp));
                    continue;
                }
            }

            if (prevSteps < currSteps) {
                unvisited.removeAll(visited);
            }
            prevSteps = currSteps;
            char[] charArray = note.word.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                for (char x = 'a'; x <= 'z'; x++) {
                    char temp = charArray[i];
                    if (temp != x) {
                        charArray[i] = x;
                    }
                    String newWord = new String(charArray);
                    if (unvisited.contains(newWord)) {
                        queue.offer(new WordNote(newWord, currSteps + 1, note));
                        visited.add(newWord);
                    }
                    charArray[i] = temp;
                }
            }
        }
        return result;
    }

    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }
        return result;
    }

    public int hashCode(char[] key, int HASH_SIZE) {
        long ans = 0;
        for (int i = 0; i < key.length; i++) {
            ans = (ans * 33 + (int) (key[i])) % HASH_SIZE;
        }
        return (int) ans;
    }

    public int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int len = nums.length;


        int[][] globalMax = new int[len + 1][k + 1];
        int[][] localMax = new int[len + 1][k + 1];
        for (int j = 1; j <= k; j++) {
            localMax[j - 1][j] = Integer.MIN_VALUE;
            for (int i = j; i <= len; i++) {
                localMax[i][j] = Math.max(globalMax[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1];
                globalMax[i][j] = i == j ? localMax[i][j] : Math.max(localMax[i][j], globalMax[i - 1][j]);
            }
        }

        return globalMax[len][k];
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] result = new int[nums.length - k + 1];

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            deque.offer(i);

            if (i + 1 >= k)
                result[i + 1 - k] = nums[deque.peek()];
        }

        return result;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(s, new ArrayList<String>(), result);
        return result;
    }

    private boolean isPalindrome(StringBuffer s) {
        String temp = s.toString();
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        if (sb.toString().equals(temp)) {
            return true;
        } else {
            return false;
        }
    }

    private void helper(String s, List<String> path, List<List<String>> result) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!isPalindrome(sb)) {
                continue;
            }
            path.add(sb.toString());
            if (i == s.length() - 1) {
                result.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            } else {
                helper(s.substring(i + 1, s.length()), path, result);
                path.remove(path.size() - 1);
            }
        }

    }

    private static class DirectedGraphNode {
        int label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if (graph == null) {
            return res;
        }
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        List<DirectedGraphNode> visited = new ArrayList<>();
        for (DirectedGraphNode gNode : graph) {
            dfs(map, gNode, visited);
        }
        Map<DirectedGraphNode, Integer> sortMap = new TreeMap(new ValueComparator(map));
        sortMap.putAll(map);
        for (Map.Entry<DirectedGraphNode, Integer> entry : sortMap.entrySet()) {
            res.add(entry.getKey());
        }
        return res;
    }

    class ValueComparator implements Comparator {
        Map map;

        public ValueComparator(Map map) {
            this.map = map;
        }

        public int compare(Object keyA, Object keyB) {
            Comparable valueA = (Comparable) map.get(keyA);
            Comparable valueB = (Comparable) map.get(keyB);
            int val = valueB.compareTo(valueA);
            if (val != 0) {
                return -val;
            } else {
                return keyA.hashCode() - keyB.hashCode();
            }
        }
    }

    private void dfs(Map<DirectedGraphNode, Integer> map, DirectedGraphNode node, List<DirectedGraphNode> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (!map.containsKey(node)) {
            map.put(node, 0);
        }
        for (DirectedGraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, map.get(node) + 1);
            } else {
                if (neighbor != node) {
                    map.put(neighbor, Math.max(map.get(neighbor), map.get(node)) + 1);
                }
            }
        }
    }

    int N;
    boolean[] left;
    boolean[] right;
    boolean[] vertical;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        left = new boolean[2 * n - 1];
        right = new boolean[2 * n - 1];
        vertical = new boolean[n];
        int[] res = new int[]{0};
        dfs(0, res);
        return res[0];
    }

    private void dfs(int row, int[] res) {
        for (int col = 0; col < N; col++) {
            int l = col + row;
            int r = N - 1 - col + row;
            if (left[l] || right[r] || vertical[col]) {
                continue;
            }
            if (row == N - 1) {
                res[0] = res[0] + 1;
                return;
            } else {
                left[l] = right[r] = vertical[col] = true;
                dfs(row + 1, res);
                left[l] = right[r] = vertical[col] = false;
            }
        }
    }

    public String[] topKFrequentWords(String[] words, int k) {
        if (words == null || k <= 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        PqComparator comp = new PqComparator(map);
        PriorityQueue<String> pq = new PriorityQueue<>(comp);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry.getKey());
            } else {
                if (entry.getValue() > map.get(pq.peek()) ||
                        (entry.getValue() == map.get(pq.peek()) && entry.getKey().compareTo(pq.peek()) < 0)) {
                    pq.poll();
                    pq.offer(entry.getKey());
                }
            }
        }
        String[] result = new String[k];
        int index = pq.size() - 1;
        while (!pq.isEmpty()) {
            result[index--] = pq.poll();
        }
        return result;
    }

    private static class PqComparator implements Comparator<String> {

        Map<String, Integer> map;

        public PqComparator(Map<String, Integer> map) {
            this.map = map;
        }

        public int compare(String k1, String k2) {
            Comparable a = map.get(k1);
            Comparable b = map.get(k2);
            int result = a.compareTo(b);
            if (result == 0) {
                return k2.compareTo(k1);
            } else {
                return result;
            }
        }
    }

    private void siftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest]) {
                smallest = k * 2 + 1;
            }
            if (k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest]) {
                smallest = k * 2 + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[k];
            A[k] = temp;

            k = smallest;
        }
    }

    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        dict.add(start);
        dict.add(end);
        LinkedList<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWordList = getNextWord(word, dict);
                for (String next : nextWordList) {
                    if (next.equals(end)) {
                        return length;
                    }
                    if (hash.contains(next)) {
                        continue;
                    }
                    hash.add(next);
                    queue.offer(next);
                }
            }
        }
        return 0;
    }

    private List<String> getNextWord(String str, Set<String> dict) {
        List<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char temp = chars[i];
            for (int j = 0; j < 26; j++) {
                if (temp == 'a' + j) {
                    continue;
                }
                chars[i] = (char) ('a' + j);
                String word = new String(chars);
                if (dict.contains(word)) {
                    result.add(word);
                }
            }
            chars[i] = temp;
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length == 0 || k > A.length) {
            return result;
        }
        Arrays.sort(A);
        helper(A, new ArrayList<Integer>(k), result, target, k, 0);
        return result;
    }

    private void helper(int[] A, ArrayList<Integer> path,
                        ArrayList<ArrayList<Integer>> result,
                        int target, int k, int index) {
        if (path.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }

        for (int i = index; i < A.length; i++) {
            if (i > index && A[i] == A[i - 1]) {
                continue;
            }
            if (target < A[index]) {
                return;
            }
            path.add(A[i]);
            helper(A, path, result, target - A[i], k, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public int findMissing2(int n, String str) {
        // Write your code here
        boolean[] hash = new boolean[n + 1];
        int m = 0;
        int temp = n;
        while (temp > 0) {
            m++;
            temp = temp / 10;
        }
        int i = 0;
        while (i < str.length()) {
            int t = 0;
            int s = 0;
            while (t < m && i + t < str.length()) {
                s = (str.charAt(i + t) - '0') + s * 10;
                t++;
            }
            int t2 = t;
            while (s > 0) {
                if (s > n || hash[s]) {
                    t--;
                    s = s / 10;
                    continue;
                } else {
                    i += t;
                    hash[s] = true;
                    break;
                }
            }
            if (s == 0) {
                i += t2;
            }
        }
        for (int j = 1; j <= n; j++) {
            if (!hash[j]) {
                return j;
            }
        }
        return -1;
    }

    public int twoSum2(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp > target) {
                result += (right - left);
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    public double sqrt(double x) {
        // Write your code here
        if (x == 0) {
            return 0;
        }
        double left = 0.0;
        double right = 1.0;
        while (right * right <= x) {
            if (right * right == x) {
                return right;
            }
            left++;
            right++;
        }
        while (left < right) {
            double mid = (left + right) / 2.0;
            double sqr = mid * mid;
            if (sqr == x || mid == left || mid == right) {
                return mid;
            } else if (sqr > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int n = str.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; ++i)
            for (int j = 0; j <= n; ++j)
                dp[i][j] = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j)
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }

    public int kthSmallest(int k, int[] nums) {
        // write your code here
        int result = quickselect(nums, 0, nums.length - 1, k - 1);
        return result;
    }


    private int quickselect(int[] G, int first, int last, int k) {
        if (first <= last) {
            int pivot = partition(G, first, last);
            if (pivot == k) {
                return G[k];
            }
            if (pivot > k) {
                return quickselect(G, first, pivot - 1, k);
            }
            return quickselect(G, pivot + 1, last, k);
        }
        return Integer.MIN_VALUE;
    }

    private int partition(int[] G, int first, int last) {
        int pivot = first + new Random().nextInt(last - first + 1);
        swap(G, last, pivot);
        for (int i = first; i < last; i++) {
            if (G[i] < G[last]) {
                swap(G, i, first);
                first++;
            }
        }
        swap(G, first, last);
        return first;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) {
            throw new IllegalArgumentException("illegal prerequisites array");
        }

        int len = prerequisites.length;

        //if there is no prerequisites, return a sequence of courses
        if (len == 0) {
            int[] res = new int[numCourses];
            for (int m = 0; m < numCourses; m++) {
                res[m] = m;
            }
            return res;
        }

        //records the number of prerequisites each course (0,...,numCourses-1) requires
        int[] pCounter = new int[numCourses];
        for (int i = 0; i < len; i++) {
            pCounter[prerequisites[i][0]]++;
        }

        //stores courses that have no prerequisites
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (pCounter[i] == 0) {
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        //initialize result
        int[] result = new int[numCourses];
        int j = 0;

        while (!queue.isEmpty()) {
            int c = queue.remove();
            result[j++] = c;

            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == c) {
                    pCounter[prerequisites[i][0]]--;
                    if (pCounter[prerequisites[i][0]] == 0) {
                        queue.add(prerequisites[i][0]);
                        numNoPre++;
                    }
                }

            }
        }

        //return result
        if (numNoPre == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }


    /*private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[j] = nums[i];
        nums[i] = temp;
    }*/
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int index = 0;
        StringBuffer sb = new StringBuffer();
        int n = strs[0].length();
        while (true) {
            if (index >= n) {
                break;
            }
            char c = strs[0].charAt(index);
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        str = str.split("\\.")[0];
        if (str.length() == 0) {
            return 0;
        }
        boolean negative = false;
        boolean first = true;
        if (str.charAt(0) == '-') {
            negative = true;
        }
        int index = 0;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            first = false;
            index++;
        }
        double result = 0.0;
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                if (!first) {
                    return 0;
                } else {
                    break;
                }
            }
            result = result * 10 + Integer.parseInt(String.valueOf(str.charAt(index++)));
        }
        if (negative) {
            if (-result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return -(int) (result);
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) result;
            }
        }
    }

    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            while (low <= high && A[high] == elem) {
                high--;
            }
            while (low <= high && A[low] != elem) {
                low++;
            }
            if (low <= high) {
                swap(A, low, high--);
            }
        }
        return low;
    }

    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        if (A == null || A.size() == 0) {
            return new ArrayList<>(0);
        }
        int n = A.size();
        ArrayList<Long> result = new ArrayList<>(n);
        if (A.size() == 1) {
            result.add(Long.valueOf(A.get(0)));
            return result;
        }
        long[] f = new long[n];
        f[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            f[i] = A.get(i) * f[i + 1];
        }
        long[] p = new long[n];
        p[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            p[i] = A.get(i) * p[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result.add(f[1]);
            } else if (i == n - 1) {
                result.add(p[n - 2]);
            } else {
                result.add(p[i - 1] * f[i + 1]);
            }
        }
        return result;
    }

    public int sqrt2(int x) {
        // write your code here
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        long left = 1;
        long right = x;
        while (left + 1 < right) {
            long mid = (left + right) >>> 1;
            double temp = mid * mid;
            if (temp == x) {
                return (int) mid;
            } else if (temp > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        char c = word.charAt(0);
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == c) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        board[i][j] = '*';
        boolean res = dfs(board, word, index + 1, i + 1, j) ||
                dfs(board, word, index + 1, i - 1, j) ||
                dfs(board, word, index + 1, i, j + 1) ||
                dfs(board, word, index + 1, i, j - 1);
        board[i][j] = word.charAt(index);
        return res;
    }

    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public List<Integer> numIslands2(int n, int m, List<Point> operators) {
        // Write your code here
        if (operators == null || operators.size() == 0) {
            return new ArrayList<>(0);
        }
        int[] root = new int[n * m];
        Arrays.fill(root, -1);
        int[][] directions = new int[][]{
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (Point point : operators) {
            count++;
            int index = point.x * m + point.y;
            root[index] = index;
            for (int i = 0; i < 4; i++) {
                int x = point.x + directions[i][0];
                int y = point.y + directions[i][1];
                if (x < 0 || y < 0 || x >= n || y >= m || root[x * m + y] == -1) {
                    continue;
                }
                int nRoot = findRoot(root, x * m + y);
                if (nRoot != index) {
                    root[nRoot] = index;
                    count--;
                }
            }
            result.add(count);
        }
        return result;
    }

    private int findRoot(int[] root, int a) {
        while (root[a] != a) {
            a = root[a];
        }
        return a;
    }

    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        ArrayList<Integer> result = new ArrayList<>(n - k + 1);
        if (k == 1) {
            for (int num : nums) {
                result.add(num);
            }
            return result;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        maxHeap.offer(nums[0]);
        for (int i = 1; i < k; i++) {
            insert(minHeap, maxHeap, nums[i]);
        }
        for (int i = k - 1; i < n; i++) {
            if (k % 2 != 0) {
                result.add(maxHeap.peek());
            } else {
                int max = maxHeap.peek();
                int min = minHeap.peek();
                int median = Math.min(max, min);
                result.add(median);
            }
            if (i < n - 1) {
                remove(minHeap, maxHeap, nums[i - k + 1]);
                insert(minHeap, maxHeap, nums[i + 1]);
            }
        }
        return result;
    }

    private void insert(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, Integer ele) {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.offer(ele);
        }
        int med = maxHeap.peek();
        if (ele > med) {
            minHeap.offer(ele);
        } else {
            maxHeap.offer(ele);
        }
        balance(minHeap, maxHeap);
    }

    private void remove(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, Integer ele) {
        int med = maxHeap.peek();
        if (ele > med) {
            minHeap.remove(ele);
        } else {
            maxHeap.remove(ele);
        }
        balance(minHeap, maxHeap);
    }

    private void balance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        while (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        HashMap map = new HashMap();
    }

    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i, visited);
            }
            if (board[n - 1][i] == 'O') {
                bfs(board, n - 1, i, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0, visited);
            }
            if (board[i][m - 1] == 'O') {
                bfs(board, i, m - 1, visited);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        String a = "";
    }

    private void bfs(char[][] board, int x, int y, boolean[][] visited) {
        int n = board.length;
        int m = board[0].length;
        if (visited[x][y]) {
            return;
        }
        LinkedList<String> queue = new LinkedList<>();
        visited[x][y] = true;
        board[x][y] = 'Y';
        queue.offer(x + "," + y);
        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        while (!queue.isEmpty()) {
            String point = queue.poll();
            int i = Integer.valueOf(point.split(",")[0]);
            int j = Integer.valueOf(point.split(",")[1]);
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                if (newX < 0 || newY < 0 || newX >= n || newY >= m || visited[newX][newY]) {
                    continue;
                }
                if (board[newX][newY] == 'O') {
                    visited[newX][newY] = true;
                    board[newX][newY] = 'Y';
                    queue.offer(newX + "," + newY);
                }
            }
        }
    }

    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return new ArrayList<>(0);
        }
        int[] biTree = new int[10002];
        ArrayList<Integer> result = new ArrayList<>(A.length);
        for (int a : A) {
            result.add(prefixSum(a, biTree));
            add(a + 1, 1, biTree);
        }
        return result;
    }

    private void add(int index, int val, int[] biTree) {
        while (index < biTree.length) {
            biTree[index] += val;
            index += lowBit(index);
        }
    }

    private int prefixSum(int index, int[] biTree) {
        int sum = 0;
        while (index > 0) {
            sum += biTree[index];
            index -= lowBit(index);
        }
        return sum;
    }

    private int lowBit(int c) {
        return c & -c;
    }

    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] heights = new int[m];
        for (int i = 0; i < m; i++) {
            if (matrix[0][i]) {
                heights[i]++;
            }
        }
        max = Math.max(max, findMax(heights));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j]) {
                    if (heights[j] != 0) {
                        heights[j]++;
                    }
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(max, findMax(heights));
        }
        return max;
    }

    private int findMax(int[] heights) {
        int m = heights.length;
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= m; i++) {
            int height = i == m ? -1 : heights[i];
            while (!stack.isEmpty() && height <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }

    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 1) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = heights.length - 1;
        int ll = left;
        int rr = right;
        while (left <= right) {
            if (heights[ll] < heights[rr]) {
                left++;
                if (left < heights.length && heights[left] > heights[ll]) {
                    max = Math.max(max, (left - ll) * heights[ll]);
                    ll = left;
                }
            } else {
                right--;
                if (right > 0 && heights[right] > heights[rr]) {
                    max = Math.max(max, (rr - right) * heights[rr]);
                    rr = right;
                }
            }
        }
        if (ll == 0 && rr == heights.length - 1) {
            max = Math.max(max, Math.min(heights[ll], heights[rr]) * (heights.length - 1));
        }
        return max;
    }

    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length <= 2) {
            return true;
        }
        int n = values.length;
        int[] dp = new int[n];
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];
        int total = values[n - 1] + values[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            total += values[i];
            int value1 = values[i] + Math.min(dp[i + 2], i + 3 < n ? dp[i + 3] : 0);
            int value2 = values[i] + values[i + 1] +
                    Math.min(i + 3 < n ? dp[i + 3] : 0, i + 4 < n ? dp[i + 4] : 0);
            dp[i] = Math.max(value1, value2);
        }

        return dp[0] > (total - dp[0]);
    }

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        boolean[][] mark = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, dfs(A, i, j, mark, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] A, int x, int y, boolean[][] mark, int[][] dp) {
        if (mark[x][y]) {
            return dp[x][y];
        }
        int[][] directions = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        int n = A.length;
        int m = A[0].length;
        dp[x][y]++;
        mark[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= n || newY >= m || A[newX][newY] <= A[x][y]) {
                continue;
            }
            dfs(A, newX, newY, mark, dp);
        }
        return dp[x][y];
    }

    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int lowMask = 1;
        if (i == 0) {
            lowMask = 0;
        } else {
            for (int k = 1; k < i; k++) {
                lowMask <<= 1;
                lowMask++;
            }
        }
        int low = n & lowMask;
        int high = (n >>> j) << j;
        int mid = m << i;
        return low + mid + high;
    }

    public String binaryRepresentation(String n) {
        // write your code here
        double x = Double.parseDouble(n);
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return "ERROR";
        }
        if (x == 0) {
            return "0";
        }
        int left = Integer.parseInt(n.split("\\.")[0]);
        double right = Double.parseDouble("0." + n.split("\\.")[1]);
        StringBuilder sb = new StringBuilder();
        while (left > 0) {
            sb.insert(0, left % 2);
            left /= 2;
        }
        if (right == 0) {
            return sb.toString();
        }
        if (sb.length() == 0) {
            sb.append(0);
        }
        sb.append(".");
        int count = 1;
        while (count <= 32) {
            double temp = Math.pow(2, -count);
            if (right >= temp) {
                right -= temp;
                sb.append(1);
            } else {
                sb.append(0);
            }
            if (right == 0) {
                return sb.toString();
            }
            count++;
        }
        return "ERROR";
    }

    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) {
            return "0";
        }
        int n = num.length;
        List<String> list = new ArrayList<>(n);
        for (int i : num) {
            list.add(i + "");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return a.compareTo(b);
            }
        });
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            res.append(str);
        }
        return res.toString();
    }

    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuffer sb = new StringBuffer(A);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) > sb.charAt(j + 1)) {
                    sb.delete(j, j + 1);
                    break;
                }
                if (j == sb.length() - 2) {
                    sb.delete(j + 1, j + 2);
                }
            }
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        return sb.toString();
    }

    public int majorityNumber(int[] nums) {
        // write your code
        int a = 0;
        int countA = 0;
        int b = 0;
        int countB = 0;
        for (int num : nums) {
            if (countA == 0) {
                a = num;
                countA = 1;
            } else if (countB == 0) {
                b = num;
                countB = 1;
            } else if (num == a) {
                countA++;
            } else if (num == b) {
                countB++;
            } else {
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int num : nums) {
            if (num == a) {
                countA++;
            } else if (num == b) {
                countB++;
            }
        }

        return countA > countB ? a : b;
    }

    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
                if (map.size() >= k) {
                    removeZeroCount(map);
                }
            }
        }
        for (int key : map.keySet()) {
            map.put(key, 0);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }
        int max = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                max = entry.getKey();
                count = entry.getValue();
            }
        }
        return max;
    }

    private void removeZeroCount(Map<Integer, Integer> map) {
        for (int key : map.keySet()) {
            map.put(key, map.get(key) - 1);
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 0) {
                it.remove();
            }
        }
    }

    public int copyBooks(int[] pages, int k) {
        // write your code here
        int n = pages.length;
        int[] sum = new int[n];
        sum[0] = pages[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + pages[i];
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][1] = sum[i];
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[i][j - 1], sum[n - 1] - sum[i]));
            }
        }
        return dp[n - 1][k];
    }

    public static void main(String[] args) {
        int test = new Test().copyBooks(new int[]{3, 2, 4}, 2);
    }
}

