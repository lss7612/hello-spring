package hello.hello.spring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    /**
     * 맥 단축키 적응기
     * @param args
     */
    public static void main(String[] args) {

        //cmd + delete => 한줄 지우기
        //opt + return(enter) => 자동 import
        //현재 메서드 실행 ctrl shift r


        Map<String, Object> result = new HashMap<>();
        result.put("1",1);
        System.out.println(result.get("1"));

    }

}
