package JumpTable;

import lombok.experimental.var;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by tangjialiang
 *         时间 2020/4/3.
 *         说明 ...
 */
public class Solution {

    public static void main(String[] args) {
        HashMap<String, String> datas = new HashMap(){{
            put("aaa", "aaa");
            put("bbb", "bbb");
            put("ccc", "ccc");
            put("ddd", "ddd");
            put("eee", "eee");
            put("fff", "fff");
        }};


        SkipTable st = new SkipTable<String, String>();
        for (Map.Entry<String, String> entry : datas.entrySet()) {
            st.add(entry.getKey(), entry.getValue());
        }

        System.out.println(st);

        System.out.println("Min: " + st.findMin() + " Max: " + st.findMax());
    }
}
