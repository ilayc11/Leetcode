import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class leetCodeMedium {
  public static class MaximumSubarray{
      public static void main(String[] args) {
          int []nums=new int[]{-5,3,2,-6,-7,2};
          System.out.println((Solution(nums)));
      }
      public static int Solution(int[]nums){
          int maxValue=nums[0];
          int currentSum=nums[0];
          for(int i=1;i<nums.length;i++){
             currentSum=Math.max(nums[i],currentSum+nums[i]);
             maxValue=Math.max(currentSum,maxValue);
          }
          return maxValue;
      }
  }
  public static class AddTwoNumbers{
      public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

      public static void main(String[] args) {

         ListNode l1=new ListNode();
          ListNode l2=new ListNode();


          System.out.println(solution(l1,l2));
      }
      public static ListNode solution(ListNode l1,ListNode l2){
              ListNode dummyHead = new ListNode(0);
              ListNode tail = dummyHead;
              int carry = 0;

              while (l1 != null || l2 != null || carry != 0) {
                  int digit1 = (l1 != null) ? l1.val : 0;
                  int digit2 = (l2 != null) ? l2.val : 0;

                  int sum = digit1 + digit2 + carry;
                  int digit = sum % 10;
                  carry = sum / 10;

                  ListNode newNode = new ListNode(digit);
                  tail.next = newNode;
                  tail = tail.next;

                  l1 = (l1 != null) ? l1.next : null;
                  l2 = (l2 != null) ? l2.next : null;
              }

              ListNode result = dummyHead.next;
              dummyHead.next = null;
              return result;
          }
      }
      public static class lengthOfLongestSubstring {
          public static void main(String[] args) {
              String s="abcabcbb";
              System.out.println(solution(s));
          }
          public static int solution(String s) {
              int n = s.length();
              int maxLength = 0;
              HashMap<Character, Integer> charMap = new HashMap<>();
              int left = 0;

              for (int right = 0; right < n; right++) {
                  if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                      charMap.put(s.charAt(right), right);
                      maxLength = Math.max(maxLength, right - left + 1);
                  } else {
                      left = charMap.get(s.charAt(right)) + 1;
                      charMap.put(s.charAt(right), right);
                  }
              }

              return maxLength;
          }
      }
  }
