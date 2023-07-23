class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> checkCloserI(a , b , x));
        for(int num: arr){
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
    //     LinkedList<Integer> res = new LinkedList<>();
    //     int i = 0;
    //     for(; i < arr.length ; i++){
    //         if(arr[i] == x){
    //             break;
    //         }else if (arr[i] > x){
    //             i--;
    //             break;
    //         }
    //     }
    //     if(i == arr.length) i--;
    //     int left = i;
    //     int right = i+1;
    //     while(right - left  <= k){
    //         if(right < arr.length && left >= 0){
    //             if(checkCloser(arr[left] , arr[right] , x)){
    //                 res.addFirst(arr[left--]);
    //             }else{
    //                 res.addLast(arr[right++]);
    //             }
    //         }
    //         else if(right >= arr.length){
    //             res.addFirst(arr[left--]);
    //         }
    //         else if(left < 0){
    //             res.addLast(arr[right++]);
    //         }
    //     }
    //     return res;
    // }
    public boolean checkCloser(int a , int b , int x){
        if(Math.abs(a-x) < Math.abs(b-x) || (Math.abs(a-x) == Math.abs(b-x) && a <= b)) return true;
        return false;
    }
    public int checkCloserI(int a , int b , int x){
        if(Math.abs(a-x) < Math.abs(b-x) || (Math.abs(a-x) == Math.abs(b-x) && a <= b)) return 1;
        return -1;
    }
}