package LeetCode;

public class DecodeWays {
	public static int numDecodings(String s) {
        if (s.length() == 0)
            return 0;
        int[] nums = new int[s.length()];
        if (s.charAt(s.length() - 1) != '0')
            nums[s.length() - 1] = 1;
        if (s.length() >= 2) {
            int value = Integer.parseInt(s.substring(s.length() - 2, s.length()));
            if (value >= 10 && value <= 26)
                nums[s.length() - 2] = nums[s.length() - 1] + 1;
            else if (s.charAt(s.length() - 2) != '0')
                nums[s.length() - 2] = nums[s.length() - 1];
            for (int i = s.length() - 3; i >= 0; i--) {
                if (s.charAt(i) != '0')
                    nums[i] = nums[i + 1];
                value = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                if (value >= 10 && value <= 26)
                    nums[i] += nums[i + 2];
            }
        }
        return nums[0];
    }
	public static void main(String[] args) {
		String s = "11";
		System.out.println(numDecodings(s));
	}
}
