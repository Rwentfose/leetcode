package 两个数组的交集;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> integerIntegerHashMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            integerIntegerHashMap.put(nums1[i], 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (integerIntegerHashMap.containsKey(nums2[i])) {
                integerIntegerHashMap.put(nums2[i], integerIntegerHashMap.get(nums2[i]) + 1);
            }
        }

        int i = 0;
        Set<Integer> integers = integerIntegerHashMap.keySet();
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            int key = iterator.next(); // 保存当前 key
            if (integerIntegerHashMap.get(key) > 1){
                list.add(key);
            }
        }
        int[] res =  list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }

    public static void main(String[] args) {
       int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    }
