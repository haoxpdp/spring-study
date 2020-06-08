package c.hao.spring.study.processor;

import java.util.*;

public class Cal {

    static final Map<Character, Operator> operatorHashMap = new HashMap<>();

    static {
        for (Operator o : Operator.values()) {
            operatorHashMap.put(o.gets(), o);
        }
    }

    public static void main(String[] args) {
        String s = "1+79-3";
        parserAndCalExpression(s);


    }

    public static Double parserAndCalExpression(String s) {
        Stack<Double> ds = new Stack<>();
        Stack<Operator> op = new Stack<>();

        String numberStr = "";
        //上一位是否为符合
        boolean sub = false;
        for (char a : s.toCharArray()) {
            if (operatorHashMap.containsKey(a)) {
                op.push(operatorHashMap.get(a));
                Double v = Double.valueOf(numberStr);
                ds.push(v);
                numberStr = "";
            } else {
                numberStr += a;
            }

        }
        Double v = Double.valueOf(numberStr);
        ds.push(v);
        return null;
    }


    enum Operator {
        /**
         *
         */
        plus('+'), divide('/'), multiply('*'), substract('-');
        Character s;

        public Double calculation(Double a, Double b) {

            if ('+' == s) {
                return a + b;
            }
            if ('-' == s) {
                return a - b;
            }
            if ('*' == s) {
                return a * b;
            }
            if ('/' == s) {
                return a / b;
            }
            return null;
        }

        public Character gets() {
            return s;
        }

        Operator(Character s) {
            this.s = s;
        }
    }

}
