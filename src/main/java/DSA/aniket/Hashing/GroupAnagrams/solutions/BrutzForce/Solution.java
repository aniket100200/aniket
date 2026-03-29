package DSA.aniket.Hashing.GroupAnagrams.solutions.BrutzForce;

import DSA.aniket.Hashing.GroupAnagrams.GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution implements GroupAnagrams {
    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null)throw new IllegalArgumentException("Please Provide the Array");
        Map<String,List<String>> map=new HashMap<>();
        for(String str: strs){
            char[]arr=str.toCharArray();
            Arrays.sort(arr);
         String key  = String.copyValueOf(arr);
         List<String> list=map.getOrDefault(key,new ArrayList<>());
         list.add(str);
         map.put(key,list);
        }
        List<List<String>>ans=new ArrayList<>();
        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
       return ans;
    }
}
