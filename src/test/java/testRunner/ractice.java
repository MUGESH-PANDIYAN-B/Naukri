package testRunner;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ractice {
    String name="Rajinikath";
    char[] array=name.toCharArray();
    Map<Character,Integer> map=new HashMap<>();
    int count;
    @Test
    void getRepeat(){
        for(char ch:array){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

        }
        System.out.println(map);
    }

}
