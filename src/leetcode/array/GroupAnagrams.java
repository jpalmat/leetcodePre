package leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
            return null;

        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] strarChar = strs[i].toCharArray();
            Arrays.sort(strarChar);
            if(map.containsKey(String.valueOf(strarChar))){
                List<String> anagram = new ArrayList<>(map.get(String.valueOf(strarChar)));
                anagram.add(strs[i]);
                map.put(String.valueOf(strarChar), anagram);
            } else {
                map.put(String.valueOf(strarChar), Arrays.asList(new String[]{strs[i]}));
            }
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }
}
