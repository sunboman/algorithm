

import java.util.*;
import java.util.stream.Collectors;

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

  public int[] findOrderII(int numCourses, int[][] prerequisites) {
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

  public List<List<Integer>> combinationSum2(int[] num, int target) {
    // write your code here
    if (num == null || num.length == 0) {
      return new ArrayList<>(0);
    }
    Arrays.sort(num);
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < num.length; i++) {
      if (i > 0 && num[i] == num[i - 1]) {
        continue;
      }
      dfs(i, target, num, new ArrayList<>(), res);
    }
    return res;
  }

  private void dfs(int curr, int target, int[] num, List<Integer> path, List<List<Integer>> res) {
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    if (target < 0 || target < num[curr]) {
      return;
    }
    path.add(num[curr]);
    target -= num[curr];
    if (target == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    int size = path.size();
    for (int i = curr + 1; i < num.length; i++) {
      dfs(i, target, num, path, res);
      if (path.size() > size)
        path.remove(path.size() - 1);
    }
  }

  public int stoneGame(int[] A) {
    // Write your code here
    if (A == null || A.length == 0) {
      return 0;
    }
    int n = A.length;
    int[] sum = new int[n + 1];
    sum[1] = A[0];
    for (int i = 1; i < n; i++) {
      sum[i + 1] += sum[i] + A[i];
    }
    int[][] dp = new int[n][n];
    for (int len = 2; len <= n; len++) {
      for (int i = 0; i < n - len + 1; i++) {
        int right = i + len - 1;
        int min = Integer.MAX_VALUE;
        for (int j = i; j < right; j++) {
          min = Math.min(min, dp[i][j] + dp[j + 1][right]);
        }
        dp[i][right] = min + sum[right + 1] - sum[i];
      }
    }
    return dp[0][n - 1];
  }

  public void partitionArray(int[] nums) {
    // write your code here;
    if (nums == null || nums.length == 0) {
      return;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      while (left <= right && (nums[left] % 2 == 1)) {
        left++;
      }
      while (left <= right && (nums[right] % 2 == 0)) {
        right--;
      }
      if (left <= right) {
        swap(nums, left, right);
      }
    }
  }

  public boolean isPalindrome(String s) {
    // Write your code here
    if (s == null || s.length() <= 1) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left <= right) {
      char cl = Character.toLowerCase(s.charAt(left));
      while (!((cl >= '0' && cl <= '9') || (cl >= 'a' && cl <= 'z'))) {
        left++;
        if (left == right) {
          return true;
        }
        cl = Character.toLowerCase(s.charAt(left));
      }
      char cr = Character.toLowerCase(s.charAt(right));
      while (!((cr >= '0' && cr <= '9') || (cr >= 'a' && cr <= 'z'))) {
        right--;
        if (left == right) {
          return true;
        }
        cr = Character.toLowerCase(s.charAt(right));
      }
      if (cl == cr) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true;
  }

  public void rerange(int[] A) {
    // write your code here
    if (A == null || A.length <= 2) {
      return;
    }
    Arrays.sort(A);
    int n = A.length;
    int left = 0;
    int right = n - 1;
    if (n % 2 == 0) {
      left = 1;
      right = n - 2;
    } else {
      if (A[(left + right) / 2] > 0) {
        right = n - 2;
      } else {
        left = 1;
      }
    }
    while (left <= right) {
      swap(A, left, right);
      left += 2;
      right -= 2;
    }
  }

  public int copyBooksII(int n, int[] times) {
    // write your code here
    int m = times.length;
    int[][] dp = new int[m][n + 1];
    for (int i = 1; i <= n; i++) {
      dp[0][i] = i * times[0];
    }
    for (int j = 1; j < m; j++) {
      for (int i = 1; i <= n; i++) {
        dp[j][i] = Integer.MAX_VALUE;
        for (int l = i; l >= 0; l--) {
          dp[j][i] = Math.min(dp[j][i], Math.max(dp[j - 1][l], times[j] * (i - l)));
        }
      }
    }
    return dp[m - 1][n];
  }

  public int[][] submatrixSum(int[][] matrix) {
    // Write your code here
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0][0];
    }
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] preSum = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k <= m; k++) {
          int sum = preSum[j][k] - preSum[i][k];
          if (!map.containsKey(sum)) {
            map.put(sum, k);
          } else {
            int[][] res = new int[2][2];
            res[0][0] = i;
            res[0][1] = map.get(sum);
            res[1][0] = j - 1;
            res[1][1] = k - 1;
            return res;
          }
        }
      }
    }
    return new int[0][0];
  }

  public List<Integer> findPeakII(int[][] A) {
    // write your code here
    if (A == null || A.length == 0 || A[0].length == 0) {
      return new ArrayList<>(0);
    }
    int n = A.length;
    int m = A[0].length;
    return find(A, 1, n - 2, 1, m - 2, true);
  }

  private List<Integer> find(int[][] A, int u, int d, int l, int r, boolean horizontal) {
    if (horizontal) {
      int mid = (u + d) >>> 1;
      int maxIndex = l;
      for (int i = l + 1; i <= r; i++) {
        if (A[mid][i] > A[mid][maxIndex]) {
          maxIndex = i;
        }
      }
      if (A[mid - 1][maxIndex] > A[mid][maxIndex]) {
        return find(A, u, mid - 1, l, r, false);
      } else if (A[mid + 1][maxIndex] > A[mid][maxIndex]) {
        return find(A, mid + 1, d, l, r, false);
      } else {
        return new ArrayList<Integer>(Arrays.asList(mid, maxIndex));
      }
    } else {
      int mid = (l + r) >>> 1;
      int maxIndex = u;
      for (int i = u + 1; i <= d; i++) {
        if (A[i][mid] > A[maxIndex][mid]) {
          maxIndex = i;
        }
      }
      if (A[maxIndex][mid - 1] > A[maxIndex][mid]) {
        return find(A, u, d, l, mid - 1, true);
      } else if (A[maxIndex][mid + 1] > A[maxIndex][mid]) {
        return find(A, u, d, mid + 1, r, true);
      } else {
        return new ArrayList<Integer>(Arrays.asList(maxIndex, mid));
      }
    }
  }

  public ArrayList<Integer> continuousSubarraySum(int[] A) {
    // Write your code here
    if (A == null || A.length == 0) {
      return new ArrayList<>(0);
    }
    int n = A.length;
    ArrayList<Integer> res = new ArrayList<>(2);
    res.add(0);
    res.add(0);
    int minSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int left = -1;
    int sum = 0;
    for (int right = 0; right < n; right++) {
      sum += A[right];
      if (sum - minSum > maxSum) {
        maxSum = sum - minSum;
        res.set(0, left + 1);
        res.set(1, right);
      }
      if (sum < minSum) {
        minSum = sum;
        left = right;
      }
    }
    return res;
  }

  public ArrayList<Integer> continuousSubarraySumII(int[] A) {
    // Write your code here
    if (A == null || A.length == 0) {
      return new ArrayList<Integer>(0);
    }
    int[] maxSum = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
    ArrayList<Integer> res1 = getMaxSum(A, maxSum, 0);
    int totalSum = 0;
    for (int i = 0; i < A.length; i++) {
      totalSum += A[i];
      A[i] = -A[i];
    }
    ArrayList<Integer> res2 = getMaxSum(A, maxSum, 1);
    maxSum[1] += totalSum;
    if (!(maxSum[1] == 0 && totalSum < 0) && maxSum[1] > maxSum[0]) {
      int left = res2.get(1) + 1;
      int right = res2.get(0) - 1;
      return new ArrayList<Integer>(Arrays.asList(left, right));
    } else {
      return res1;
    }
  }

  private ArrayList<Integer> getMaxSum(int[] A, int[] maxSum, int i) {
    ArrayList<Integer> res = new ArrayList<>(2);
    res.add(0);
    res.add(0);
    int left = -1;
    int sum = 0;
    int minSum = 0;
    for (int right = 0; right < A.length; right++) {
      sum += A[right];
      int insum = sum - minSum;
      if (insum > maxSum[i]) {
        maxSum[i] = insum;
        res.set(0, left + 1);
        res.set(1, right);
      }
      if (sum < minSum) {
        minSum = sum;
        left = right;
      }
    }
    return res;
  }

/*    class Bucket {
        int low;
        int high;

        public Bucket() {
            low = -1;
            high = -1;
        }
    }*/

  /*public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }

        int max = num[0];
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
            min = Math.min(min, num[i]);
        }

        // initialize an array of buckets
        Bucket[] buckets = new Bucket[num.length + 1]; //project to (0 - n)
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        double interval = (double) num.length / (max - min);
        //distribute every number to a bucket array
        for (int i = 0; i < num.length; i++) {
            int index = (int) ((num[i] - min) * interval);

            if (buckets[index].low == -1) {
                buckets[index].low = num[i];
                buckets[index].high = num[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, num[i]);
                buckets[index].high = Math.max(buckets[index].high, num[i]);
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                result = Math.max(result, buckets[i].low - prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }*/
  class Bucket {
    int min;
    int max;

    public Bucket(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }

  public int maximumGap(int[] nums) {
    // write your code here
    if (nums == null || nums.length < 2) {
      return 0;
    }
    int max = -1;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    int n = nums.length;
    int size = (int) Math.ceil((double) (max - min) / (n - 1));
    if (size == 0) {
      return 0;
    }
    Bucket[] buckets = new Bucket[n];
    for (int num : nums) {
      int index = (num - min) / size;
      Bucket bucket = buckets[index];
      if (bucket == null) {
        buckets[index] = new Bucket(num, num);
      } else {
        bucket.max = Math.max(bucket.max, num);
        bucket.min = Math.min(bucket.min, num);
      }
    }
    int res = 0;
    int prev = buckets[0].max;
    for (int i = 1; i < n; i++) {
      if (buckets[i] == null) {
        continue;
      }
      res = Math.max(res, buckets[i].min - prev);
      prev = buckets[i].max;
    }
    return res;
  }

  public int maxKilledEnemies(char[][] grid) {
    // Write your code here
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    int[][] dp = new int[n][m];
    //left to right
    int count = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '0') {
          dp[i][j] += count;
        } else if (grid[i][j] == 'E') {
          count++;
        } else {
          count = 0;
        }
      }
    }
    //right to left
    count = 0;
    for (int i = 0; i < n; i++) {
      count = 0;
      for (int j = m - 1; j >= 0; j--) {
        if (grid[i][j] == '0') {
          dp[i][j] += count;
        } else if (grid[i][j] == 'E') {
          count++;
        } else {
          count = 0;
        }
      }
    }
    //top to down
    count = 0;
    for (int j = 0; j < m; j++) {
      count = 0;
      for (int i = 0; i < n; i++) {
        if (grid[i][j] == '0') {
          dp[i][j] += count;
        } else if (grid[i][j] == 'E') {
          count++;
        } else {
          count = 0;
        }
      }
    }
    //down to top
    count = 0;
    for (int j = 0; j < m; j++) {
      count = 0;
      for (int i = n - 1; i >= 0; i--) {
        if (grid[i][j] == '0') {
          dp[i][j] += count;
        } else if (grid[i][j] == 'E') {
          count++;
        } else {
          count = 0;
        }
      }
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }

  public static class Interval {
    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }


  public List<Interval> merge(List<Interval> intervals) {
    // write your code here
    if (intervals == null || intervals.size() == 0) {
      return intervals;
    }
    Collections.sort(intervals, new Comparator<Interval>() {
      public int compare(Interval a, Interval b) {
        return a.start - b.start;
      }
    });
    Interval temp = intervals.get(0);
    List<Interval> res = new ArrayList<>();
    for (Interval interval : intervals) {
      if (interval.start > temp.end) {
        res.add(temp);
        temp = interval;
      } else {
        temp.end = interval.end;
      }
    }
    res.add(temp);
    return res;
  }

  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    // write your code here
    intervals.add(intervals.size(), new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE));
    boolean flag = false;
    for (Interval interval : intervals) {
      if (interval.start < newInterval.start) {
        if (interval.end < newInterval.start) {
          result.add(interval);
        } else {
          newInterval.start = interval.start;
          newInterval.end = Math.max(newInterval.end, interval.end);
        }
      } else if (interval.start == newInterval.start) {
        newInterval.end = Math.max(interval.end, newInterval.end);
      } else {
        if (interval.start > newInterval.end) {
          if (!flag) {
            flag = true;
            result.add(newInterval);
          }
          if (interval.start != Integer.MAX_VALUE)
            result.add(interval);
        } else {
          newInterval.end = Math.max(interval.end, newInterval.end);
        }
      }
    }
    if (result.size() == 0) {
      result.add(newInterval);
    }
    return result;
  }

  public int shortestDistance(int[][] grid) {
    // Write your code here
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();
    List<Integer> sumx = new ArrayList<>();
    List<Integer> sumy = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          x.add(i);
          y.add(j);
        }
      }
    }
    Collections.sort(x);
    Collections.sort(y);
    sumx.add(0);
    sumy.add(0);
    int total = x.size();
    for (int i = 1; i <= total; i++) {
      sumx.add(sumx.get(i - 1) + x.get(i - 1));
      sumy.add(sumy.get(i - 1) + y.get(i - 1));
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != 0) {
          continue;
        }
        int costX = getCost(x, sumx, i, total);
        int costY = getCost(y, sumy, j, total);
        res = Math.min(res, costX + costY);
      }
    }
    return res;
  }

  private int getCost(List<Integer> list, List<Integer> preSum, int pos, int total) {
    if (total == 0) {
      return 0;
    }
    if (pos <= list.get(0)) {
      return preSum.get(total) - pos * total;
    }
    int l = 0;
    int r = total - 1;
    while (l + 1 < r) {
      int mid = (l + r) >>> 1;
      if (list.get(mid) <= pos) {
        l = mid;
      } else {
        r = mid;
      }
    }
    int index = -1;
    if (list.get(r) <= pos) {
      index = r;
    } else {
      index = l;
    }
    return preSum.get(total) - preSum.get(index + 1) - (total - index - 1) * pos
            + (index + 1) * pos - preSum.get(index + 1);
  }

  public int shortestDistanceII(int[][] grid) {
    // Write your code here
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    int[][] dist = new int[n][m];
    int[][] reach = new int[n][m];
    int total = 0;
    int[][] dis = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] != 1) {
          continue;
        }
        total++;
        boolean[][] visited = new boolean[n][m];
        int level = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(i * m + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
          int size = queue.size();
          for (int z = 0; z < size; z++) {
            int l = queue.poll();
            int ox = l / m;
            int oy = l % m;
            for (int k = 0; k < 4; k++) {
              int x = ox + dis[k][0];
              int y = oy + dis[k][1];
              if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] != 0) {
                continue;
              }
              queue.offer(x * m + y);
              visited[x][y] = true;
              dist[x][y] += level + 1;
              reach[x][y]++;
            }
          }
          level++;
        }
      }
    }
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0 && reach[i][j] == total) {
          res = Math.min(res, dist[i][j]);
        }
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }

  public int copyBooksIIB(int n, int[] times) {
    // write your code here
    int m = times.length;
    int[][] dp = new int[m][n + 1];
    for (int i = 1; i <= n; i++) {
      dp[0][i] = times[0] * i;
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = 0; k <= j; k++) {
          int curr = Math.max(times[i] * k, dp[i - 1][j - k]);
          dp[i][j] = Math.min(dp[i][j], curr);
        }
      }
    }
    return dp[m - 1][n];
  }

  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }
    int left = 0;
    int right = x;
    while (left + 1 < right) {
      long mid = (left + right) >>> 1;
      long temp = mid * mid;
      if (temp < x) {
        left = (int) mid;
      } else if (temp == x) {
        return (int) mid;
      } else {
        right = (int) mid;
      }
    }
    long t = (long) right * (long) right;
    if (t <= x) {
      return right;
    } else {
      return left;
    }
  }

  public int reverse(int x) {
    boolean neg = x < 0;
    long y = Math.abs((long) x);
    LinkedList<Long> queue = new LinkedList<>();
    while (y != 0) {
      queue.offer(y % 10);
      y = y / 10;
    }
    long res = 0;
    while (!queue.isEmpty()) {
      res = queue.poll() + res * 10;
    }
    if (neg) {
      if (-res < Integer.MIN_VALUE) {
        return 0;
      } else {
        return (int) (0 - res);
      }
    } else {
      if (res > Integer.MAX_VALUE) {
        return 0;
      } else {
        return (int) res;
      }
    }
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length != inorder.length) {
      return null;
    }
    int n = preorder.length;
    if (n == 0) {
      return null;
    }
    return buildNode(preorder, 0, n - 1, inorder, 0, n - 1);
  }

  private TreeNode buildNode(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
    TreeNode root = new TreeNode(preorder[ps]);
    int i = is;
    while (inorder[i] != root.val) {
      i++;
    }
    if (i != is) {
      root.left = buildNode(preorder, ps + 1, ps + i - is, inorder, is, i - 1);
    }
    if (i != ie) {
      root.right = buildNode(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
    }
    return root;
  }

  public int myAtoi(String str) {
    if (str == null || str.trim().length() == 0) {
      return 0;
    }
    str = str.trim();
    char[] chars = str.toCharArray();
    boolean neg = false;
    long res = 0;
    for (int i = 0; i < chars.length; i++) {
      char c = chars[i];
      if (i == 0 && !Character.isDigit(c)) {
        if (c == '-' || c == '+') {
          neg = c == '-';
        } else {
          return 0;
        }
      } else {
        if (res >= Integer.MAX_VALUE) {
          if (!neg) {
            return Integer.MAX_VALUE;
          } else {
            if (-res <= Integer.MIN_VALUE) {
              return Integer.MIN_VALUE;
            }
          }
        }
        if (c >= '0' && c <= '9') {
          res = c - '0' + res * 10;
        } else {
          break;
        }
      }
    }
    if (res >= Integer.MAX_VALUE) {
      if (!neg) {
        return Integer.MAX_VALUE;
      } else {
        if (-res <= Integer.MIN_VALUE) {
          return Integer.MIN_VALUE;
        }
      }
    }
    return (int) res;
  }

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>(0);
    }
    boolean left = true;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<List<Integer>> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> temp = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        temp.add(node.val);
      }
      if (!left) {
        Collections.reverse(temp);
      }
      left = !left;
      res.add(new ArrayList<>(temp));
    }
    return res;
  }

  public boolean myWordBreak(String s, Set<String> wordDict) {
    if (s == null || s.length() == 0) {
      return true;
    }
    int n = s.length();
    int maxLen = getMaxLen(wordDict);
    boolean[] dp = new boolean[n + 1];
    dp[0] = true;
    for (int i = 0; i <= n; i++) {
      if (!dp[i]) {
        continue;
      }
      int left = i + 1;
      for (int right = left; right <= i + maxLen && right <= n; right++) {
        if (wordDict.contains(s.substring(left - 1, right))) {
          dp[right] = true;
        }
      }
    }
    return dp[n];
  }

  private int getMaxLen(Set<String> wordDict) {
    int max = 0;
    for (String word : wordDict) {
      max = Math.max(word.length(), max);
    }
    return max;
  }

  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }
    int n = citations.length;
    int[] buckets = new int[n + 1];
    for (int citation : citations) {
      if (citation >= n) {
        buckets[n]++;
      } else {
        buckets[citation]++;
      }
    }
    int count = 0;
    for (int i = n; i >= 0; i--) {
      count += buckets[i];
      if (count >= i) {
        return i;
      }
    }
    return 0;
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode res = head.next;
    ListNode curr = head;
    ListNode prev = new ListNode(0);
    while (curr != null) {
      ListNode next = curr.next;
      if (next == null) {
        prev.next = curr;
        break;
      }
      ListNode temp = next.next;
      next.next = curr;
      prev.next = next;
      prev = curr;
      prev.next = null;
      curr = temp;
    }
    return res;
  }

  public int myBackPack(int m, int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int n = A.length;
    int[][] dp = new int[n][m + 1];
    for (int j = A[0]; j <= m; j++) {
      dp[0][j] = A[0];
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= m; j++) {
        if (j >= A[i])
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + A[i]);
        else
          dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[n - 1][m];
  }

  public int backPackIV(int[] nums, int target) {
    // Write your code here
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int[][] dp = new int[n][target + 1];
    dp[0][0] = 1;
    for (int j = 1; j <= target; j++) {
      if (j >= nums[0]) {
        dp[0][j] += dp[0][j - nums[0]];
      }
    }
    for (int i = 1; i < n; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= target; j++) {
        if (nums[i] <= j)
          dp[i][j] = dp[i - 1][j] + dp[i][j - nums[i]];
        else
          dp[i][j] = dp[i - 1][j];
      }
    }

    return dp[n - 1][target];
  }

  public int backPackV(int[] nums, int target) {
    // Write your code here
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int[][] dp = new int[n][target + 1];
    dp[0][0] = 1;
    if (nums[0] <= target) {
      dp[0][nums[0]] = 1;
    }
    for (int i = 1; i < n; i++) {
      dp[i][0] = 1;
      for (int j = 1; j <= target; j++) {
        if (j >= nums[i]) {
          dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n - 1][target];
  }

  public int backPackVI(int[] nums, int target) {
    // Write your code here
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i >= nums[j]) {
          dp[i] += dp[i - nums[j]];
        }
      }
    }
    return dp[target];
  }

  public int threeSumClosest(int[] nums, int target) {
    if (nums == null || nums.length < 3) {
      return Integer.MAX_VALUE;
    }
    Arrays.sort(nums);
    int gap = Integer.MAX_VALUE;
    int n = nums.length;
    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int newGap = twoSum(nums, i + 1, n - 1, target, nums[i], gap);
      if (Math.abs(newGap) < Math.abs(gap)) {
        gap = newGap;
      }
      if (gap == 0) {
        return target;
      }
    }
    return target + gap;
  }

  private int twoSum(int[] nums, int start, int end, int target, int prev, int gap) {
    int i = start;
    int j = end;
    while (i < j) {
      if (i > start && nums[i] == nums[i - 1]) {
        i++;
        continue;
      }
      if (j < end && nums[j] == nums[j + 1]) {
        j--;
        continue;
      }
      if (Math.abs(gap) > Math.abs(prev + nums[i] + nums[j] - target)) {
        gap = prev + nums[i] + nums[j] - target;
      }
      if (prev + nums[i] + nums[j] == target) {
        return gap;
      } else if (prev + nums[i] + nums[j] > target) {
        j--;
      } else {
        i++;
      }
    }
    return gap;
  }

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return new ArrayList<>(0);
    }
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, sum, new ArrayList<Integer>(), res);
    return res;
  }

  private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
    if (node == null) {
      return;
    }
    path.add(node.val);
    if (node.val == sum && node.left == null && node.right == null) {
      res.add(new ArrayList<>(path));
    }
    dfs(node.left, sum - node.val, path, res);
    dfs(node.right, sum - node.val, path, res);
    path.remove(path.size() - 1);
  }

  public int myMaxArea(int[] height) {
    if (height == null || height.length < 2) {
      return 0;
    }
    int n = height.length;
    int left = 0;
    int right = n - 1;
    int leftMax = height[left];
    int rightMax = height[right];
    int res = 0;
    while (left < right) {
      int width = right - left;
      if (leftMax < rightMax) {
        res = Math.max(res, width * leftMax);
        leftMax = height[++left];
      } else {
        res = Math.max(res, width * rightMax);
        rightMax = height[--right];
      }
    }
    return res;
  }

  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    List<List<String>> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<String> temp = new ArrayList<String>();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node == null) {
          temp.add("-");
          continue;
        }
        temp.add(node.val + "");
        queue.offer(node.left);
        queue.offer(node.right);
      }
      res.add(new ArrayList<>(temp));
    }
    StringBuffer sb = new StringBuffer();
    res.forEach(list ->
            list.forEach(str -> sb.append(str).append(","))
    );

    for (int i = sb.length() - 1; i >= 0; i--) {
      if (sb.charAt(i) == '-' || sb.charAt(i) == ',') {
        sb.deleteCharAt(i);
      } else {
        break;
      }
    }
    return sb.toString();
  }

  public int kthSmallest(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode curr = root;
    int count = 0;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        if (count == k) {
          return curr.val;
        }
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      count++;
      if (count == k) {
        return curr.val;
      }
      curr = curr.right;
    }
    return -1;
  }

  public boolean palindromePermutaion(String str) {
    int[] map = new int[256];
    for (char c : str.toCharArray()) {
      map[c]++;
    }
    int odd = 0;
    for (int i : map) {
      if (i % 2 == 1) {
        odd++;
      }
    }
    return odd <= 1;
  }

  public List<String> palindromePermutaionII(String str) {
    int[] map = new int[256];
    for (char c : str.toCharArray()) {
      map[c]++;
    }
    StringBuffer mid = new StringBuffer();
    List<Character> even = new ArrayList<>();
    for (int i = 0; i < 256; i++) {
      if (map[i] % 2 == 1) {
        mid.append((char) i);
      }
      for (int j = 0; j < map[i] / 2; j++) {
        even.add((char) i);
      }
    }
    if (mid.length() > 1) {
      return new ArrayList<>(0);
    }
    List<String> permutations = new ArrayList<>();
    permute(even, new StringBuffer(), permutations, new boolean[even.size()]);
    List<String> res = new ArrayList<>(permutations.size());
    permutations.forEach(p -> {
      StringBuffer sb = new StringBuffer(p);
      sb.reverse();
      res.add(p + mid + sb);
    });
    return res;
  }

  private void permute(List<Character> even, StringBuffer path, List<String> res, boolean[] visited) {
    if (path.length() == even.size()) {
      res.add(path.toString());
      return;
    }
    for (int i = 0; i < even.size(); i++) {
      if (visited[i] || i > 0 && even.get(i) == even.get(i - 1) && visited[i - 1]) {
        continue;
      }
      path.append(even.get(i));
      visited[i] = true;
      permute(even, path, res, visited);
      path.deleteCharAt(path.length() - 1);
      visited[i] = false;
    }
  }

  public boolean isIsomorphic(String s, String t) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      if (map.containsKey(sc)) {
        if (tc != map.get(sc)) {
          return false;
        }
      } else {
        if (map.values().contains(tc)) {
          return false;
        }
        map.put(sc, tc);
      }
    }
    return true;
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words == null || words.length == 0) {
      return new ArrayList<>(0);
    }
    if (maxWidth == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }
    List<String> res = new ArrayList<>();
    int left = 0;
    int count = 0;
    for (int i = 0; i < words.length; i++) {
      count += words[i].length();
      if (count + i - left > maxWidth) {
        int wordsLen = count - words[i].length();
        int spaceLen = maxWidth - wordsLen;
        int eachSpace = 1;
        int extraSpace = 0;
        if (i - left - 1 > 0) {
          eachSpace = spaceLen / (i - left - 1);
          extraSpace = spaceLen % (i - left - 1);
        }
        String eachSpaceStr = generateSpace(eachSpace);
        StringBuilder sb = new StringBuilder();
        for (int j = left; j < i - 1; j++) {
          sb.append(words[j]).append(eachSpaceStr);
          if (extraSpace > 0) {
            sb.append(" ");
            extraSpace--;
          }
        }
        sb.append(words[i - 1]);
        while (sb.length() < maxWidth) {
          sb.append(" ");
        }
        res.add(sb.toString());
        left = i;
        count = words[i].length();
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = left; i < words.length - 1; i++) {
      sb.append(words[i]).append(" ");
    }
    sb.append(words[words.length - 1]);
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
    res.add(sb.toString());
    return res;
  }

  private String generateSpace(int n) {
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < n; i++) {
      temp.append(" ");
    }
    return temp.toString();
  }

  public List<String> findRepeatedDnaSequences(String s) {
    if (s == null || s.length() < 10) {
      return new ArrayList<>(0);
    }
    Set<String> repeated = new HashSet<>();
    Set<String> all = new HashSet<>();
    for (int left = 0; left < s.length(); left++) {
      int right = left + 10;
      if (right > s.length()) {
        break;
      }
      String seq = s.substring(left, right);
      if (!all.contains(seq)) {
        all.add(seq);
      } else {
        repeated.add(seq);
      }
    }
    return new ArrayList<String>(repeated);
  }

  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int maxPre = nums[0];
    int minPre = nums[0];
    int res = nums[0];
    int max, min;
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        max = Math.max(nums[i], nums[i] * maxPre);
        min = Math.min(nums[i], nums[i] * minPre);
      } else {
        max = Math.max(nums[i], nums[i] * minPre);
        min = Math.min(nums[i], nums[i] * maxPre);
      }
      res = Math.max(res, max);
      maxPre = max;
      minPre = min;
    }
    return res;
  }

  public List<Integer> topKFrequent(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>(0);
    }
    List<Integer> res = new ArrayList<>();
    if (k >= nums.length) {
      for (int num : nums) {
        res.add(num);
      }
      return res;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, 1);
      } else {
        map.put(num, map.get(num) + 1);
      }
    }
    int max = 0;
    for (Integer frq : map.values()) {
      max = Math.max(max, frq);
    }
    Map<Integer, List<Integer>> buckets = new HashMap(max + 1);
    for (int i = 1; i <= max; i++) {
      buckets.put(i, new ArrayList<Integer>());
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int num = entry.getKey();
      int frq = entry.getValue();
      List<Integer> list = buckets.get(frq);
      list.add(num);
      buckets.put(frq, list);
    }
    int count = 0;
    int frq = max;
    while (count < k) {
      while (buckets.get(frq).size() <= 0) {
        frq--;
      }
      res.addAll(buckets.get(frq));
      count += buckets.get(frq).size();
      frq--;
    }
    return res;
  }

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n == 1) {
      return x;
    }
    if (n == -1) {
      return 1 / x;
    }
    double y = myPow(x, n / 2);
    if (Math.abs(n) % 2 == 1) {
      if (n > 0) {
        return y * y * x;
      } else {
        return y * y / x;
      }
    }
    return y * y;
  }

  public double myPow_iterative(double x, int n) {
    if (x == 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    double res = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        res *= x;
      }
      x *= x;
      n >>= 1;
    }
    return res;
  }

  public int[] plusOne(int[] digits) {
    if (digits == null || digits.length == 0) {
      return new int[]{1};
    }
    int carry = 1;
    int n = digits.length;
    for (int i = n - 1; i >= 0; i--) {
      int val = digits[i] + carry;
      digits[i] = val % 10;
      carry = val / 10;
    }
    if (carry == 0) {
      return digits;
    }
    int[] res = new int[n + 1];
    res[0] = carry;
    for (int i = 1; i <= n; i++) {
      res[i] = digits[i - 1];
    }
    return res;
  }

  class Node {
    Node left, right;
    int val;
    int sum;
    int dup;

    public Node(int val, int sum) {
      this.val = val;
      this.sum = sum;
      this.dup = 1;
    }
  }

  public List<Integer> countSmaller(int[] nums) {
    if (nums == null || nums.length == 0) {
      return new ArrayList<>(0);
    }
    Integer[] res = new Integer[nums.length];
    Node root = null;
    for (int i = nums.length - 1; i >= 0; i--) {
      root = insert(nums[i], root, res, i, 0);
    }
    return Arrays.asList(res);
  }

  private Node insert(int num, Node node, Integer[] res, int index, int preSum) {
    if (node == null) {
      node = new Node(num, 0);
      res[index] = preSum;
    } else if (num == node.val) {
      node.dup++;
      res[index] = preSum + node.sum;
    } else if (num > node.val) {
      node.right = insert(num, node.right, res, index, preSum + node.sum + node.dup);
    } else {
      node.sum++;
      node.left = insert(num, node.left, res, index, preSum);
    }
    return node;
  }

    /*public String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
        }
        if (j == s.length()) {
            return s;
        }
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }*/

  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = new ListNode(0);
    slow.next = head;
    while (fast != null) {
      if (fast.next == null) {
        break;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode second = reverse(slow.next);
    ListNode first = head;
    slow.next = null;
    reorder(first, second);
  }

  private void reorder(ListNode first, ListNode second) {
    while (first != null && second != null) {
      ListNode t1 = first.next;
      first.next = second;
      first = t1;
      ListNode t2 = second.next;
      if (first != null) {
        second.next = first;
      }
      second = t2;
    }
  }

  private ListNode reverse(ListNode head) {
    ListNode l1 = head;
    ListNode l2 = l1.next;
    l1.next = null;
    while (l2 != null) {
      ListNode temp = l2.next;
      l2.next = l1;
      l1 = l2;
      l2 = temp;
    }
    return l1;
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int n = grid.length;
    int m = grid[0].length;
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1') {
          bfs(i, j, grid);
          res++;
        }
      }
    }
    return res;
  }

  private void bfs(int i, int j, char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.offer(i * m + j);
    grid[i][j] = '0';
    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        int temp = queue.poll();
        int x = temp / m;
        int y = temp % m;
        for (int l = 0; l < 4; l++) {
          int newX = x + directions[l][0];
          int newY = y + directions[l][1];
          if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == '0') {
            continue;
          }
          grid[newX][newY] = '0';
          queue.offer(newX * m + newY);
        }
      }
    }
  }

  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[0][0];
    }
    if (n == 1) {
      return new int[][]{{1}};
    }
    int first = 0;
    int curr = 1;
    int max = n * n;
    int[][] res = new int[n][n];
    while (n > 0) {
      //top
      for (int i = first; i < first + n && curr <= max; i++) {
        res[first][i] = curr++;
      }
      //right
      for (int i = first + 1; i < first + n && curr <= max; i++) {
        res[i][first + n - 1] = curr++;
      }
      //bottom
      for (int i = first + n - 2; i >= first && curr <= max; i--) {
        res[first + n - 1][i] = curr++;
      }
      //left
      for (int i = first + n - 2; i > first && curr <= max; i--) {
        res[i][first] = curr++;
      }
      first++;
      n -= 2;
    }
    return res;
  }

  public List<List<Integer>> combine(int n, int k) {
    if (k <= 0) {
      return new ArrayList<>(0);
    }
    boolean[] visited = new boolean[n + 1];
    List<List<Integer>> res = new ArrayList<>();
    dfs(visited, 1, k, new ArrayList<>(), res);
    return res;
  }

  private void dfs(boolean[] visited, int left, int k, List<Integer> path, List<List<Integer>> res) {
    if (path.size() == k) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = left; i < visited.length; i++) {
      if (visited[i]) {
        continue;
      }
      path.add(i);
      visited[i] = true;
      dfs(visited, i + 1, k, path, res);
      path.remove(path.size() - 1);
      visited[i] = false;
    }
  }

  public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
      return false;
    }
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left + 1 < right) {
      int mid = (left + right) >>> 1;
      if (nums[mid] == target) {
        return true;
      }
      if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid;
        } else {
          right = mid;
        }
      } else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
        if (nums[left] <= target && target < nums[mid]) {
          right = mid;
        } else {
          left = mid;
        }
      } else {
        right--;
      }
    }
    if (nums[left] == target || nums[right] == target) {
      return true;
    }
    return false;
  }

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode fast = head;
    ListNode slow = new ListNode(0);
    slow.next = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode rH = reverse(slow.next);
    slow.next = null;
    while (head != null) {
      if (head.val != rH.val) {
        return false;
      }
      head = head.next;
      rH = rH.next;
    }
    return true;
  }

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (!isValid(board, i, 0, i, 8) || !isValid(board, 0, i, 8, i)) {
        return false;
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (!isValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2)) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean isValid(char[][] board, int x1, int y1, int x2, int y2) {
    Set<Character> set = new HashSet<>();
    for (int i = x1; i <= x2; i++) {
      for (int j = y1; j <= y2; j++) {
        if (board[i][j] == '.') {
          continue;
        }
        if (!set.add(board[i][j])) {
          return false;
        }
      }
    }
    return true;
  }

  public boolean isSubstring(char[] txt, char[] pat) {
    if (txt == null || txt.length == 0) {
      return false;
    }
    if (pat == null || pat.length == 0) {
      return true;
    }
    int m = txt.length;
    int n = pat.length;
    int j = 0;
    while (pat[j] == '*') {
      j++;
    }
    int i = 0;
    while (txt[i] != pat[j]) {
      i++;
    }
    int star = -1;
    int mark = -1;
    while (i < m && j < n) {

      if (txt[i] == pat[j]) {
        i++;
        j++;
      } else if (pat[j] == '*') {
        star = j++;
        mark = i;
      } else if (star != -1) {
        j = star + 1;
        i = ++mark;
      }

    }
    while (j < n && pat[j] == '*') {
      j++;
    }
    return j == n;
  }

  public int findKthNumber(int n, int k) {
    int curr = 1;
    k = k - 1;
    while (k > 0) {
      int steps = calSteps(n, curr, curr + 1);
      if (steps <= k) {
        curr += 1;
        k -= steps;
      } else {
        curr *= 10;
        k -= 1;
      }
    }
    return curr;
  }

  //use long in case of overflow
  private int calSteps(int n, long n1, long n2) {
    int steps = 0;
    while (n1 <= n) {
      steps += Math.min(n + 1, n2) - n1;
      n1 *= 10;
      n2 *= 10;
    }
    return steps;
  }

  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    if (beginWord.equals(endWord)) {
      return new ArrayList<>();
    }
    Set<String> unvisited = new HashSet<>();
    Set<String> visited = new HashSet<>();
    unvisited.addAll(wordList);
    unvisited.add(endWord);
    LinkedList<WordNode> queue = new LinkedList<>();
    queue.offer(new WordNode(null, 1, beginWord));
    int preLevel = 0;
    int finalLevel = Integer.MAX_VALUE;
    List<List<String>> res = new ArrayList<>();
    while (!queue.isEmpty()) {
      WordNode node = queue.poll();
      if (node.word.equals(endWord)) {
        finalLevel = Math.min(finalLevel, node.level);
        if (node.level == finalLevel) {
          LinkedList<String> stack = new LinkedList<>();
          while (node != null) {
            stack.push(node.word);
            node = node.prev;
          }
          res.add(new ArrayList<>(stack));
          continue;
        }
      }
      if (preLevel < node.level) {
        unvisited.removeAll(visited);
      }
      preLevel = node.level;
      char[] wordChar = node.word.toCharArray();
      for (int i = 0; i < wordChar.length; i++) {
        char temp = wordChar[i];
        for (char c = 'a'; c <= 'z'; c++) {
          if (c == temp) {
            continue;
          }
          wordChar[i] = c;
          String str = new String(wordChar);
          if (unvisited.contains(str)) {
            visited.add(str);
            queue.offer(new WordNode(node, node.level + 1, str));
          }
          wordChar[i] = temp;
        }
      }
    }
    return res;
  }

  private class WordNode {
    WordNode prev;
    int level;
    String word;

    public WordNode(WordNode prev, int level, String word) {
      this.prev = prev;
      this.level = level;
      this.word = word;
    }
  }

  public String shortestPalindrome(String s) {
    if (s == null) {
      return null;
    }
    if (s.length() == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder(s);
    sb.reverse();
    sb.insert(0, s + '#');
    int n = sb.length();
    int[] lps = new int[n];
    computeLps(lps, sb);
    return new StringBuilder(s.substring(lps[n - 1])).reverse().toString() + s;
  }

  private void computeLps(int[] lps, StringBuilder s) {
    int index = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(index) == s.charAt(i)) {
        index++;
        lps[i] = lps[i - 1] + 1;
      } else {
        index = lps[i - 1];
        while (index > 0 && s.charAt(index) != s.charAt(i)) {
          index = lps[index - 1];
        }
        if (s.charAt(index) == s.charAt(i)) {
          index++;
        }
        lps[i] = index;
      }
    }
  }

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0) {
      int[] res = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        res[i] = i;
      }
      return res;
    }
    List<Set<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adj.add(new HashSet<Integer>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
    boolean[] marked = new boolean[numCourses];
    LinkedList<Integer> stack = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (!dfs(stack, new boolean[numCourses], marked, adj, i)) {
        return new int[0];
      }
    }
    int i = 0;
    int[] result = new int[numCourses];
    while (!stack.isEmpty()) {
      result[i++] = stack.pop();
    }
    return result;
  }

  private boolean dfs(LinkedList<Integer> stack, boolean[] onStack, boolean[] marked, List<Set<Integer>> adj, int v) {
    if (onStack[v]) {
      return false;
    }
    if (marked[v]) {
      return true;
    }
    onStack[v] = true;
    marked[v] = true;
    for (int w : adj.get(v)) {
      if (onStack[w]) {
        return false;
      }
      if (!marked[w]) {
        if (!dfs(stack, onStack, marked, adj, w)) {
          return false;
        }
      }
    }
    stack.push(v);
    onStack[v] = false;
    return true;
  }


  public List<List<Integer>> combinationSum3(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (candidates == null || candidates.length == 0) return result;
    Arrays.sort(candidates);
    HashSet<ArrayList<Integer>> tempResult = new HashSet<>();
    dfs(candidates, 0, target, new ArrayList<>(), tempResult);
    result = new ArrayList<>(tempResult);
    return result;
  }

  private void dfs(int[] candidates, int pointer, int target, List<Integer> temp, HashSet<ArrayList<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = pointer; i < candidates.length; i++) {
      if (target < candidates[i] && (pointer > 0 && candidates[pointer] > candidates[pointer - 1])) return;
      temp.add(candidates[i]);
      dfs(candidates, i + 1, target - candidates[i], temp, result);
      temp.remove(temp.size() - 1);
    }
  }

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    int[] heights = new int[m];
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == '0') {
          heights[j] = 0;
        } else {
          heights[j]++;
        }
      }
      max = Math.max(max, getMaxRect(heights));
    }
    return max;
  }

  private int getMaxRect(int[] heights) {
    LinkedList<Integer> stack = new LinkedList<>();
    int n = heights.length;
    int max = 0;
    for (int i = 0; i <= n; i++) {
      int height = 0;
      if (i == n) {
        height = -1;
      } else {
        height = heights[i];
      }
      while (!stack.isEmpty() && height <= heights[stack.peek()]) {
        int h = heights[stack.pop()];
        int w = 0;
        if (stack.isEmpty()) {
          w = i;
        } else {
          w = i - stack.peek() - 1;
        }
        max = Math.max(max, w * h);
      }
      stack.push(i);
    }
    return max;
  }

  public String intToRoman(int num) {
    Map<Integer, Character> map = new HashMap<>();
    map.put(1, 'I');
    map.put(5, 'V');
    map.put(10, 'X');
    map.put(50, 'L');
    map.put(100, 'C');
    map.put(500, 'D');
    map.put(1000, 'M');
    StringBuilder res = new StringBuilder();
    int dim = 1;
    while (num > 0) {
      int temp = num % 10 * dim;
      if (temp == 5 * dim) {
        res.insert(0, map.get(5 * dim));
      } else if (temp == 4 * dim) {
        res.insert(0, map.get(dim));
        res.insert(1, map.get(5 * dim));
      } else if (temp == 9 * dim) {
        res.insert(0, map.get(dim));
        res.insert(0, map.get(10 * dim));
      } else if (temp < 4 * dim) {
        for (int i = 1; i <= temp / dim; i++) {
          res.insert(0, map.get(dim));
        }
      } else {
        res.insert(0, map.get(5 * dim));
        for (int i = 1; i <= (temp / dim) - 5; i++) {
          res.insert(1, map.get(dim));
        }
      }
      dim *= 10;
      num /= 10;
    }
    return res.toString();
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if (prerequisites == null || prerequisites.length == 0) {
      return true;
    }
    List<Set<Integer>> list = new ArrayList<>(numCourses);
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      list.add(new HashSet<>());
    }
    int n = prerequisites.length;
    for (int i = 0; i < n; i++) {
      list.get(prerequisites[i][1]).add(prerequisites[i][0]);
      inDegree[prerequisites[i][0]]++;
    }
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }
    int count = 0;
    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;
      for (int next : list.get(course)) {
        inDegree[next]--;
        if (inDegree[next] == 0) {
          queue.offer(next);
        }
      }
    }
    return count == numCourses;
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (edges == null || edges.length == 0) {
      return new ArrayList<>(0);
    }
    List<Set<Integer>> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list.add(new HashSet<>());
    }
    int m = edges.length;
    for (int i = 0; i < m; i++) {
      list.get(edges[i][0]).add(edges[i][1]);
      list.get(edges[i][1]).add(edges[i][0]);
    }
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (list.get(i).size() == 1) {
        leaves.add(i);
      }
    }
    while (n > 2) {
      n -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for (int leaf : leaves) {
        int connect = list.get(leaf).iterator().next();
        list.get(connect).remove(leaf);
        if (list.get(connect).size() == 1) {
          newLeaves.add(connect);
        }
      }
      leaves = newLeaves;
    }
    return leaves;
  }

  public int maxPoints(Point[] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int max = 0;
    int n = points.length;
    for (int i = 0; i < n; i++) {
      Map<Double, Integer> slopeCount = new HashMap<>();
      slopeCount.put(Double.MIN_VALUE, 1);
      int dup = 0;
      Point origin = points[i];
      for (int j = i + 1; j < n; j++) {
        Point point = points[j];
        if (point.x == origin.x && point.y == origin.y) {
          dup++;
          continue;
        }
        double slope = point.x == origin.x ? Double.MAX_VALUE :
                0.0 + ((double) point.y - (double) origin.y) / ((double) point.x - (double) origin.x);
        if (!slopeCount.containsKey(slope)) {
          slopeCount.put(slope, 2);
        } else {
          slopeCount.put(slope, slopeCount.get(slope) + 1);
        }
      }
      for (int count : slopeCount.values()) {
        max = Math.max(max, count + dup);
      }
    }
    return max;
  }

  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    boolean firstCol = false;
    boolean firstRow = false;
    for (int j = 0; j < m; j++) {
      if (matrix[0][j] == 0) {
        firstRow = true;
        break;
      }
    }
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        firstCol = true;
        break;
      }
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = matrix[i][0] = 0;
        }
      }
    }
    for (int i = n - 1; i > 0; i--) {
      if (matrix[i][0] == 0) {
        for (int j = 0; j < m; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int j = m - 1; j > 0; j--) {
      if (matrix[0][j] == 0) {
        for (int i = 0; i < n; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (firstCol) {
      for (int i = 0; i < n; i++) {
        matrix[i][0] = 0;
      }
    }
    if (firstRow) {
      for (int j = 0; j < m; j++) {
        matrix[0][j] = 0;
      }
    }
  }

  public int findTargetSumWays(int[] nums, int S) {
    if (nums == null || nums.length == 0) {
      return S == 0 ? 1 : 0;
    }
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (S < -sum || S > sum) {
      return 0;
    }
    int[] dp = new int[2 * sum + 1];
    dp[sum] = 1;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < 2 * sum + 1; j++) {
        if (dp[j] != 0) {
          dp[j + nums[i]] += dp[j];
          dp[j - nums[i]] += dp[j];
        }
      }
    }
    return dp[S + sum];
  }

  public int islandPerimeter(int[][] grid, int i, int j) {
    int[] res = new int[]{0};
    int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    dfs(grid, i, j, d, res);
    return res[0];
  }

  private void dfs(int[][] grid, int i, int j, int[][] d, int[] res) {
    int n = grid.length;
    int m = grid[0].length;
    grid[i][j] = 2;
    for (int x = 0; x < d.length; x++) {
      int newX = i + d[x][0];
      int newY = j + d[x][1];
      if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] == 0) {
        res[0]++;
      } else if (grid[newX][newY] == 1) {
        dfs(grid, newX, newY, d, res);
      }
    }
  }

  public List<List<Integer>> printDiagonal(int[][] data) {
    List<List<Integer>> res = new ArrayList<>();
    if (data == null || data.length == 0) {
      return res;
    }
    int n = data.length;
    int m = data[0].length;
    int x = n - 1;
    int y = 0;
    for (int i = 1; i < m + n; i++) {
      List<Integer> temp = new ArrayList<>();
      int curr_x = x;
      int curr_y = y;
      while (curr_x >= 0 && curr_x < n && curr_y >= 0 && curr_y < m) {
        temp.add(data[curr_x][curr_y]);
        curr_x++;
        curr_y++;
      }
      res.add(new ArrayList<>(temp));
      if (x > 0) {
        x--;
      } else {
        y++;
      }
    }
    return res;
  }

  public List<Interval> mergeII(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
      return intervals;
    }
    Collections.sort(intervals, (a, b) -> a.start - b.start);
    Interval prev = intervals.get(0);
    List<Interval> result = new ArrayList<>();
    for (int i = 1; i < intervals.size(); i++) {
      if (prev.end < intervals.get(i).start) {
        result.add(prev);
        prev = intervals.get(i);
      } else {
        prev.end = Math.max(prev.end, intervals.get(i).end);
      }
    }
    result.add(prev);
    return result;
  }

  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<String> stack2 = new LinkedList<>();
    int prev = 0;
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
        prev = prev * 10 + (s.charAt(i) - '0');
      } else if (s.charAt(i) == '[') {
        stack1.push(prev);
        stack2.push("[");
        prev = 0;
      } else if (s.charAt(i) == ']') {
        LinkedList<String> tempStack = new LinkedList<>();
        while (!stack2.isEmpty()) {
          String str = stack2.pop();
          if (str.equals("[")) {
            StringBuffer temp = new StringBuffer();
            StringBuffer rs = new StringBuffer();
            int num = stack1.pop();
            while (!tempStack.isEmpty()) {
              temp.append(tempStack.pop());
            }
            for (int j = 0; j < num; j++) {
              rs.append(temp);
            }
            stack2.push(rs.toString());
            break;
          }
          tempStack.push(str);
        }
      } else {
        stack2.push(String.valueOf(s.charAt(i)));
      }
    }
    StringBuffer res = new StringBuffer();
    while (!stack2.isEmpty()) {
      res.append(stack2.pollLast());
    }
    return res.toString();
  }

  int count = 0;
  TreeNode node1;
  TreeNode node2;
  TreeNode prev = new TreeNode(Integer.MIN_VALUE);

  public void recoverTree(TreeNode root) {
    findMistakes(root);
    int temp = node1.val;
    node1.val = node2.val;
    node2.val = temp;
  }

  private void findMistakes(TreeNode root) {
    if (count >= 2 || root == null) {
      return;
    }
    findMistakes(root.left);
    if (node1 == null && prev.val >= root.val) {
      node1 = prev;
    }
    if (node1 != null && prev.val >= root.val) {
      node2 = root;
    }
    prev = root;
    findMistakes(root.right);
  }

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] catched = new int[n][m];
    int res = 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        res = Math.max(res, dfs(matrix, i, j, catched));
      }
    }
    return res;
  }

  private int dfs(int[][] matrix, int i, int j, int[][] catched) {
    if (catched[i][j] != 0) return catched[i][j];
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dis = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int len = 1;
    for (int k = 0; k < 4; k++) {
      int x = i + dis[k][0];
      int y = j + dis[k][1];
      if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] <= matrix[i][j]) {
        continue;
      }
      len = Math.max(len, 1 + dfs(matrix, x, y, catched));
    }
    catched[i][j] = len;
    return len;
  }

  public List<Integer> largestValues(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(res, root, 0);
    return res;
  }

  private void dfs(List<Integer> list, TreeNode root, int level) {
    if (root == null) {
      return;
    }
    if (list.size() <= level) {
      list.add(root.val);
    } else
      list.set(level, Math.max(list.get(level), root.val));
    dfs(list, root.left, level + 1);
    dfs(list, root.right, level + 1);
  }

  public List<int[]> pacificAtlantic(int[][] matrix) {
    List<int[]> res = new ArrayList<>();
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    boolean[][] pacific = new boolean[n][m];
    boolean[][] atlantic = new boolean[n][m];
    for (int i = 0; i < m; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
      dfs(matrix, atlantic, Integer.MIN_VALUE, n - 1, i);
    }
    for (int i = 0; i < n; i++) {
      dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
      dfs(matrix, atlantic, Integer.MIN_VALUE, i, m - 1);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          res.add(new int[]{i, j});
        }
      }
    }
    return res;
  }

  private void dfs(int[][] matrix, boolean[][] visited, int height, int x, int y) {
    int n = matrix.length;
    int m = matrix[0].length;
    if (x < 0 || x >= n || y < 0 || y >= m ||
            visited[x][y] || matrix[x][y] < height) {
      return;
    }
    visited[x][y] = true;
    int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int[] dir : d) {
      dfs(matrix, visited, matrix[x][y], x + dir[0], y + dir[1]);
    }
  }

  public List<String> findItinerary(String[][] tickets) {
    List<String> res = new ArrayList<>();
    if (tickets == null || tickets.length == 0) {
      return res;
    }
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    for (String[] ticket : tickets) {
      map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
    }
    dfs("JFK", res, map);
    return res;
  }

  private void dfs(String airPort, List<String> res, Map<String, PriorityQueue<String>> map) {
    while (map.containsKey(airPort) && !map.get(airPort).isEmpty()) {
      dfs(map.get(airPort).poll(), res, map);
    }
    res.add(0, airPort);
  }

  TreeNode flatten_prev = null;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.right = flatten_prev;
    root.left = null;
    flatten_prev = root;
  }

  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
      return 0;
    }
    PriorityQueue<Cell> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
    int n = heightMap.length;
    int m = heightMap[0].length;
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < m; i++) {
      heap.offer(new Cell(0, i, heightMap[0][i]));
      visited[0][i] = true;
      heap.offer(new Cell(n - 1, i, heightMap[n - 1][i]));
      visited[n - 1][i] = true;
    }
    for (int i = 1; i < n - 1; i++) {
      heap.offer(new Cell(i, 0, heightMap[i][0]));
      visited[i][0] = true;
      heap.offer(new Cell(i, m - 1, heightMap[i][m - 1]));
      visited[i][m - 1] = true;
    }
    int res = 0;
    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!heap.isEmpty()) {
      Cell curr = heap.poll();
      for (int i = 0; i < 4; i++) {
        int x = curr.x + dir[i][0];
        int y = curr.y + dir[i][1];
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
          continue;
        }
        heap.offer(new Cell(x, y, heightMap[x][y]));
        visited[x][y] = true;
        res += Math.max(0, curr.h - heightMap[x][y]);
      }
    }
    return res;
  }

  private class Cell {
    int x, y, h;

    public Cell(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }
  }

  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    if (A == null || A.length == 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int n = A.length;
    for (int a : A) {
      for (int b : B) {
        int sum = a + b;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int res = 0;
    for (int c : C) {
      for (int d : D) {
        res += map.getOrDefault(-(c + d), 0);
      }
    }
    return res;
  }

  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    for (int num : nums) {
      nums[(num % (n + 1)) - 1] += (n + 1);
    }
    for (int i = 0; i < n; i++) {
      if (nums[i] / (n + 1) > 1) {
        res.add(i + 1);
      }
    }
    return res;
  }

  public boolean find132pattern(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }
    LinkedList<Integer> stack = new LinkedList<>();
    int n = nums.length;
    int s3 = Integer.MIN_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      if (nums[i] < s3) {
        return true;
      } else {
        while (!stack.isEmpty() && nums[i] > stack.peek()) {
          s3 = stack.pop();
        }
        stack.push(nums[i]);
      }
    }
    return false;
  }

  public int strongPasswordChecker(String s) {
    int n = s.length();
    int res = 0, a = 1, A = 1, d = 1;
    int[] array = new int[n];
    for (int i = 0; i < n; ) {
      if (Character.isLowerCase(s.charAt(i))) {
        a = 0;
      } else if (Character.isUpperCase(s.charAt(i))) {
        A = 0;
      } else if (Character.isDigit(s.charAt(i))) {
        d = 0;
      }
      int j = i;
      while (i < n && s.charAt(i) == s.charAt(j)) {
        i++;
      }
      array[j] = i - j;
    }
    int missing = (a + A + d);
    if (n < 6) {
      res += missing + Math.max(0, 6 - n - missing);
    } else {
      int over_len = Math.max(0, n - 20), left = 0;
      res += over_len;
      for (int i = 1; i < 3; i++) {
        for (int j = 0; j < n && over_len > 0; j++) {
          if (array[j] < 3 || array[j] % 3 != (i - 1)) {
            continue;
          }
          array[j] -= Math.min(over_len, i);
          over_len -= i;
        }
      }
      for (int i = 0; i < n; i++) {
        if (array[i] >= 3 && over_len > 0) {
          int temp = array[i] - 2;
          array[i] -= over_len;
          over_len -= temp;
        }
        if (array[i] >= 3) {
          left += array[i] / 3;
        }
      }
      res += Math.max(missing, left);
    }
    return res;
  }

  public int maxProfitIII(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }
    int n = prices.length;
    int[] left = new int[n];
    int[] right = new int[n];
    split(prices, left, right);
    int res = 0;
    for (int i = 0; i < n; i++) {
      res = Math.max(res, left[i] + right[i]);
    }
    return res;
  }

  private void split(int[] prices, int[] left, int[] right) {
    int n = prices.length;
    int min = prices[0];
    left[0] = 0;
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], prices[i] - min);
      min = Math.min(min, prices[i]);
    }
    int max = prices[n - 1];
    right[n - 1] = 0;
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], max - prices[i]);
      max = Math.max(prices[i], max);
    }
  }

  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i <= rowIndex; i++) {
      res.add(1);
      for (int j = i - 1; j > 0; j--) {
        res.set(j, res.get(j - 1) + res.get(j));
      }
    }
    return res;
  }

  Map<Integer, Integer> map = new HashMap<>();
  int max = Integer.MIN_VALUE;

  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) {
      return new int[0];
    }
    dfsII(root);
    List<Integer> list = map.entrySet().stream()
            .filter(map -> map.getValue() == max)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    int[] res = new int[list.size()];
    int index = 0;
    for (int i : list) {
      res[index++] = i;
    }
    return res;
  }

  private int dfsII(TreeNode root) {
    if (root.left == null && root.right == null) {
      int sum = root.val;
      if (map.containsKey(sum)) {
        map.put(sum, map.get(sum) + 1);
      } else {
        map.put(sum, 1);
      }
      max = Math.max(max, map.get(sum));
      return sum;
    }
    int left = 0;
    int right = 0;
    if (root.left != null) {
      left = dfsII(root.left);
    }
    if (root.right != null) {
      right = dfsII(root.right);
    }
    int sum = left + right + root.val;
    if (map.containsKey(sum)) {
      map.put(sum, map.get(sum) + 1);
    } else {
      map.put(sum, 1);
    }
    max = Math.max(max, map.get(sum));
    return sum;
  }

  public String[] findWords(String[] words) {
    if (words == null || words.length == 0) {
      return new String[0];
    }
    Set<Character> set1 = new HashSet<>();
    for (char c : "qwertyuiop".toCharArray()) {
      set1.add(c);
    }
    Set<Character> set2 = new HashSet<>();
    for (char c : "asdfghjkl".toCharArray()) {
      set2.add(c);
    }
    Set<Character> set3 = new HashSet<>();
    for (char c : "zxcvbnm".toCharArray()) {
      set3.add(c);
    }
    List<String> res = new ArrayList<>();
    for (String word : words) {
      String temp = word.toLowerCase();
      char a = temp.charAt(0);
      Set<Character> set = null;
      if (set1.contains(a)) {
        set = set1;
      } else if (set2.contains(a)) {
        set = set2;
      } else {
        set = set3;
      }
      for (int i = 1; i <= temp.length(); i++) {
        if (i == temp.length()) {
          res.add(word);
          break;
        }
        if (!set.contains(temp.charAt(i))) {
          break;
        }
      }
    }
    return res.toArray(new String[res.size()]);
  }

  public String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    int n = s.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    Map<Integer, List<Character>> buckets = new HashMap<>();
    int max = 0;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      max = Math.max(entry.getValue(), max);
      if (!buckets.containsKey(entry.getValue())) {
        List<Character> list = new ArrayList<>();
        list.add(entry.getKey());
        buckets.put(entry.getValue(), list);
      } else {
        buckets.get(entry.getValue()).add(entry.getKey());
      }
    }
    StringBuilder res = new StringBuilder();
    int m = buckets.size();
    for (int i = 0; i < m; i++) {
      for (char c : buckets.get(max)) {
        for (int k = 0; k < max; k++) {
          res.append(c);
        }
      }
      max--;
      while (!buckets.containsKey(max) && i < m && max > 0) {
        max--;
      }
    }
    return res.toString();
  }

  public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
    int n = nums1.length;
    int m = nums2.length;
    List<int[]> res = new ArrayList<>();
    if (n == 0 || m == 0 || k == 0) {
      return res;
    }
    for (int i = 0; i < n && i < k; i++) {
      pq.offer(new int[]{nums1[i], nums2[0], 0});
    }
    while (k-- > 0 && !pq.isEmpty()) {
      int[] top = pq.poll();
      res.add(new int[]{top[0], top[1]});
      if (top[2] == m - 1) {
        continue;
      }
      pq.offer(new int[]{top[0], nums2[top[2] + 1], top[2] + 1});
    }
    return res;
  }

  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] map = new int[26];
    for (char c : p.toCharArray()) {
      map[c - 'a']++;
    }
    int left = 0, right = 0, count = p.length();
    while (right < s.length()) {
      char c = s.charAt(right++);
      if (--map[c - 'a'] >= 0) {
        count--;
      }
      if (count == 0) {
        res.add(left);
      }
      if (right - left == p.length() && map[s.charAt(left++) - 'a']++ >= 0) {
        count++;
      }
    }
    return res;
  }

  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length < 2 || k < 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (k == 0) {
        if (entry.getValue() > 1) {
          count++;
        }
      } else if (map.containsKey(entry.getKey() + k)) {
        count++;
      }
    }
    return count;
  }

  public int findLonelyPixel(char[][] picture) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) {
      return 0;
    }
    int n = picture.length;
    int m = picture[0].length;
    int[] row = new int[n];
    int[] col = new int[m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == 'B') {
          row[i]++;
          col[j]++;
        }
      }
    }
    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == 'B') {
          if (row[i] == 1 && col[j] == 1) {
            res++;
          }
        }
      }
    }
    return res;
  }

  public int findBlackPixel(char[][] picture, int N) {
    if (picture == null || picture.length == 0 || picture[0].length == 0) {
      return 0;
    }
    int n = picture.length;
    int m = picture[0].length;
    int[] col = new int[m];
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == 'B') {
          col[j]++;
          count++;
        }
      }
      if (count == N) {
        String str = new String(picture[i]);
        map.put(str, map.getOrDefault(str, 0) + 1);
      }
    }
    int res = 0;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (entry.getValue() != N) {
        continue;
      }
      String str = entry.getKey();
      for (int i = 0; i < m; i++) {
        if (str.charAt(i) == 'B' && col[i] == N) {
          res += N;
        }
      }
    }
    return res;
  }

  public String reverseStr(String s, int k) {
    if (s == null || s.length() == 0 || k <= 1) {
      return s;
    }
    int idx = 0;
    StringBuilder sb = new StringBuilder();
    while (idx + 2 * k < s.length()) {
      sb.append(reverse(s.substring(idx, idx + k)));
      sb.append(s.substring(idx + k, idx + 2 * k));
      idx += 2 * k;
    }
    if (idx < s.length()) {
      if (idx + k >= s.length()) {
        sb.append(reverse(s.substring(idx, s.length())));
      } else {
        sb.append(reverse(s.substring(idx, idx + k)));
        sb.append(s.substring(idx + k, s.length()));
      }
    }
    return sb.toString();
  }

  private String reverse(String str) {
    StringBuilder sb = new StringBuilder(str);
    sb.reverse();
    return sb.toString();
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.MAX_VALUE);
    node.left = root;
    TreeNode parent = node;
    TreeNode target = root;
    while (target != null && target.val != key) {
      parent = target;
      if (target.val > key) {
        target = target.left;
      } else {
        target = target.right;
      }
    }
    if (target == null) {
      return root;
    } else {
      if (parent.left == target) {
        if (target.left == null) {
          parent.left = target.right;
        } else {
          parent.left = target.left;
        }
      } else {
        if (target.left == null) {
          parent.right = target.right;
        } else {
          parent.right = target.left;
        }
      }
      if (target.left != null && target.right != null) {
        TreeNode curr = target.left;
        while (curr.right != null) {
          curr = curr.right;
        }
        curr.right = target.right;
      }
    }
    return root;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null || (root.left == null && root.right == null)) {
      return 0;
    }
    return getDiameter(root)[0];
  }

  private int[] getDiameter(TreeNode root) {
    if (root == null) {
      return new int[]{0, -1};
    }
    int[] left = getDiameter(root.left);
    int[] right = getDiameter(root.right);
    int longest = Math.max(left[1] + right[1] + 2, Math.max(left[0], right[0]));
    return new int[]{longest, Math.max(left[1], right[1]) + 1};
  }

  public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
    if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
      return matrix;
    }
    List<List<Integer>> res = new ArrayList<>();
    int n = matrix.size();
    int m = matrix.get(0).size();
    LinkedList<int[]> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix.get(i).get(j) == 0) {
          queue.offer(new int[]{i, j});
        } else {
          matrix.get(i).set(j, m + n);
        }
      }
    }
    int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    while (!queue.isEmpty()) {
      int len = queue.size();
      for (int i = 0; i < len; i++) {
        int[] cor = queue.poll();
        int x = cor[0], y = cor[1];
        for (int j = 0; j < 4; j++) {
          int newX = x + d[j][0];
          int newY = y + d[j][1];
          if (newX < 0 || newX >= n || newY < 0 || newY >= m
                  || matrix.get(newX).get(newY) <= matrix.get(x).get(y) + 1) {
            continue;
          }
          queue.offer(new int[]{newX, newY});
          matrix.get(newX).set(newY, matrix.get(x).get(y) + 1);
        }
      }
    }
    return matrix;
  }

  public String findContestMatch(int n) {
    List<String> list = new ArrayList<>(n);
    for (int i = 1; i <= n; i++) {
      list.add(i + "");
    }
    while (n > 1) {
      int lo = 0, hi = n - 1;
      while (lo < hi) {
        String temp = "(" + list.get(lo) + "," + list.get(hi) + ")";
        list.set(lo, temp);
        lo++;
        hi--;
      }
      n /= 2;
    }
    return list.get(0);
  }

  public int findMinDifference(List<String> timePoints) {
    if (timePoints == null || timePoints.size() < 2) {
      return Integer.MAX_VALUE;
    }
    Collections.sort(timePoints, (a, b) -> {
      String[] arr1 = a.split(":");
      String[] arr2 = b.split(":");
      for (int i = 0; i < 2; i++) {
        int i1 = Integer.parseInt(arr1[i]);
        int i2 = Integer.parseInt(arr2[i]);
        if (i1 < i2) {
          return -1;
        } else if (i1 > i2) {
          return 1;
        }
      }
      return 0;
    });
    int min = Integer.MAX_VALUE;
    int n = timePoints.size();
    for (int i = 1; i < n; i++) {
      min = Math.min(min, getDiff(timePoints.get(i - 1), timePoints.get(i)));
    }
    String first = timePoints.get(0);
    String[] arr = first.split(":");
    arr[0] = Integer.parseInt(arr[0]) + 24 + "";
    first = arr[0] + ":" + arr[1];
    min = Math.min(min, getDiff(timePoints.get(n - 1), first));
    return min;
  }

  private int getDiff(String time1, String time2) {
    int res = 0;
    String[] arr1 = time1.split(":");
    String[] arr2 = time2.split(":");
    res += Integer.parseInt(arr2[1]) - Integer.parseInt(arr1[1]);
    res += 60 * (Integer.parseInt(arr2[0]) - Integer.parseInt(arr1[0]));
    return res;
  }

  public static void main(String[] args) {
    String res = new Test().findContestMatch(4);
  }
}

