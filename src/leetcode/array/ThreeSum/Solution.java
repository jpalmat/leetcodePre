package leetcode.array.ThreeSum;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> resultTemp = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        Map<KeyMap, Integer> m1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(i, 0 - nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for(Map.Entry<Integer, Integer> entry: m.entrySet()){
                if(entry.getKey() == i)
                    continue;
                m1.put(KeyMap.createKeyMap(entry.getKey(), i), entry.getValue() - nums[i]);
            }
        }
        Map<int[], List<Integer>> subReultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for(Map.Entry<KeyMap, Integer> entry: m1.entrySet()){
                int finalI = i;
                if(entry.getKey().getFirst() == i || entry.getKey().getSecond() == i){
                    continue;
                }
                if(entry.getValue()==nums[i]){
                    List<Integer> subReult = new ArrayList<>();
                    subReult.add(nums[i]);
                    subReult.add(nums[entry.getKey().getFirst()]);
                    subReult.add(nums[entry.getKey().getSecond()]);
                    Collections.sort(subReult);
                    resultTemp.add(subReult);
                }
            }
        }
        result = resultTemp.stream().map(x -> x.stream().collect(Collectors.toList())).distinct().collect(Collectors.toList());
        return result;
    }
}

class KeyMap {
    private int first;
    private int second;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    private KeyMap(){

    }

    public static KeyMap createKeyMap(int firstKey, int secondKey){
        KeyMap key = new KeyMap();
        key.setFirst(firstKey < secondKey ? firstKey : secondKey);
        key.setSecond(firstKey > secondKey ? firstKey : secondKey);
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyMap keyMap = (KeyMap) o;
        return first == keyMap.first &&
                second == keyMap.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}