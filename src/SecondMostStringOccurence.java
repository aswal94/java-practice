import java.util.HashMap;
import java.util.Map;

public class SecondMostStringOccurence {
    public static void main(String[] args) {
        new SecondMostStringOccurence().test();
    }

    public void test(){
        String[] strings = {"aaa", "bbb", "aaa", "ccc", "ddd", "bbb"};

        Map<String, Integer> map = new HashMap<>();


        for(int i=0;i<strings.length;i++){
            if(map.containsKey(strings[i])){
                map.put(strings[i], map.get(strings[i]) + 1);
            }else {
                map.put(strings[i], 1);
            }
        }
    }
}
