package interviews;

import java.util.HashMap;
import java.util.Map;

public class Occurance {

    public static void main(String[] args) {
        String input = "lalit vishwakarma";

        Map<Character, Integer> map = new HashMap<>();

        for(int i =0; i < input.length(); i++ ){
            char character = input.charAt(i);
            if(map.containsKey(character)){
                int value = map.get(character);
                map.put(character, value + 1);
            } else {
                map.put(character, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println("character " + entry.getKey() + " occured " + entry.getValue() + " times.");
        }
    }
}
