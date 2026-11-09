
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int r = 0;

        while (r < arr.length && arr[r] < x) {
            r++;
        }

        int l = r - 1;
        int count = 0;
        int[] res = new int[k];

        while (l >= 0 && r < arr.length && count < k) {
            if (x - arr[l] <= arr[r] - x) {
                res[count++] = arr[l--];
            } else {
                res[count++] = arr[r++];
            }
        }

        while (count < k && l >= 0) {
            res[count++] = arr[l--];
        }

        while (count < k && r < arr.length) {
            res[count++] = arr[r++];
        }

        Arrays.sort(res);

        List<Integer> result = new ArrayList<>();
        for (int num : res) {
            result.add(num);
        }

        return result;
    }
}
