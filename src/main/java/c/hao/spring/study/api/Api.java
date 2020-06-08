package c.hao.spring.study.api;

import java.util.ArrayList;
import java.util.List;

public class Api implements TestApi {
    @Override
    public List<String> list() {
        List<String> l = new ArrayList<>();
        l.add("sss");
        l.add("bbbb");
        return l;
    }
}
