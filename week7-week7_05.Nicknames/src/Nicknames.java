import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put("matti", "mage");
        hashMap.put("mikael", "mixu");
        hashMap.put("arto", "arppa");

        System.out.println(hashMap.get("mikael"));

    }

}