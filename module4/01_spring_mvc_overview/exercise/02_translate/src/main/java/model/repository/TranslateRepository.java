package model.repository;

import java.util.HashMap;
import java.util.Map;

public class TranslateRepository {
    static Map<String, String> trans = new HashMap<>();
    static {
        trans.put("hello", "Xin chào");
        trans.put("i", "tôi");
        trans.put("you", "bạn");
        trans.put("love", "yêu");
        trans.put("hate", "ghét");
    }

    public String transVn(String eng){
        eng = eng.toLowerCase();
        return trans.get(eng);
    }

    public String transEng(String vn){
        vn = vn.toLowerCase();

        return trans.get(vn);
    }
}
