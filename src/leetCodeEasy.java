import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class leetCodeEasy {
    public static class TwoSum {
        public static void main(String[] args) {
            int[] nums = new int[]{5, 7, 3, 2, 1};
            int target = 6;
            System.out.println(Arrays.toString(solution(nums, target)));
        }

        public static int[] solution(int[] nums, int target) {
            HashMap<Integer, Integer> m = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                m.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (m.containsKey(complement) && m.get(complement) != i) {
                    return new int[]{i, m.get(complement)};
                }
            }
            return new int[]{};
        }
    }
    public static class RomanToInteger{
        public static void main(String[] args) {
            String s="XXVII";
            System.out.println(solution(s));
        }

        public static int solution(String s) {
            HashMap<Character,Integer>m=new HashMap<>();
            m.put('I',1);
            m.put('V',5);
            m.put('X',10);
            m.put('L',50);
            m.put('C',100);
            m.put('D',500);
            m.put('M',1000);
            int sum=0;
            for(int i=0;i<s.length();i++){
                if(i<s.length()-1&&m.get(s.charAt(i))<m.get(s.charAt(i+1))){
                    sum-=m.get(s.charAt(i));
                }
                else{
                    sum+=m.get(s.charAt(i));
                }
            }
            return sum;
        }
    }
    public static class PalindromNumber{
        public static void main(String[] args) {
            int x=5225;
            System.out.println(mySolution(x));
            System.out.println(BetterSolution(x));

        }

        public static boolean mySolution(int x) {
            if(x<10&&x>-1)
                return true;
            Stack<Integer>s1=new Stack<>();
            Stack<Integer>s2=new Stack<>();

            while(x!=0){
                s1.push(x%10);
                x/=10;
            }
            s2.push(s1.pop());
            while(!s1.isEmpty()){
                if(s1.peek()!=s2.peek()){
                    s2.push(s1.pop());
                }
                else{
                    s1.pop();
                    s2.pop();
                }
            }
            if(!s2.isEmpty())
                return false;
            else
                return true;

        }
        public static boolean BetterSolution(int x) {
            if(x<0)
                return false;
            /*The Better Solution is to Just reverse the number and check each digit*/
            int reversed=0;
            int tmp=x;
            while(tmp!=0){
                int digit=tmp%10;
                reversed=reversed*10+digit;
                tmp/=10;
            }
            if(x==reversed)
                return true;
            else
                return false;
        }
    }
    public static class RemoveElement{
        public static void main(String[] args) {
        int [] nums=new int[]{3,2,3,3,2,2};
        int val=2;
            System.out.println(Solution(nums,val));
        }
        public static int Solution(int[]nums,int val){
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index++;
                }
            }
            return index;
        }
    }
    public static class ContainsDuplicate{
        public static void main(String[] args) {
            int [] nums=new int[]{5,1,2,3,4,7,5,8,9};
            System.out.println(Solution(nums));
        }
        public static boolean Solution(int[] nums){
            HashSet<Integer>s=new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if(s.contains(nums[i]))
                    return true;
                s.add(nums[i]);
            }
            return false;

        }
    }
    public static class MajorityElement{
        public static void main(String[] args) {
            int []nums=new int[]{3,3,2,3,3,2,2,2,2};
            System.out.println(solution(nums));
        }
        public static int solution(int [] nums){
            /*Using moore voting algorithm,the algorithm is based
             on the fact that if there is a majority element it will always
             be in the lead.
             hashMap could have worked too, but I didn't
            know how to do it in O(1) space as I was asked to.
             */
            int candidate=0;
            int count=0;
            for(int num:nums){
                if(count==0)
                    candidate=num;
                if(candidate==num)
                    count++;
                if (candidate!=num)
                    count--;
            }
        return candidate;
        }
    }

}