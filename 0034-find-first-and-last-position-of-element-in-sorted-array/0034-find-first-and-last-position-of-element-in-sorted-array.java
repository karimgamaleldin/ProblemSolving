class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;
        int first = -1;

        // Binary search to find the leftmost occurrence of the target.
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Check if the target is found.
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }

        first = left;
        left = 0;
        right = nums.length - 1;

        // Binary search to find the rightmost occurrence of the target.
        while (left < right) {
            int mid = left + (right - left + 1) / 2; // Add 1 to round up mid.
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, left};
    }
}
