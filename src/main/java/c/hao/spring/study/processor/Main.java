package com.zichan360.search.core.support;

import java.util.*;

/**
 * Main
 *
 * @author fxbin
 * @version v1.0
 * @since 2020/6/3 9:51
 */
public class Main {


    // 编写程序，从键盘输入一个合法的表达式，对该表达式进行求值并输出，为降低题目难度，特做如下要求：
    //
    //运算数均为整型数（即不带小数点）
    //运算符只支持加减乘除四种（+、-、*、/）以及小括号（()）
    //计算规则为实型数运算规则，例如1/2=0.5
    //输出计算结果保留两位小数（四舍五入）
    //表达式中不允许出现如下情况
    //空字符串
    //错误的运算符
    //错误的运算数
    //括号不匹配
    //空括号
    //连续的运算符，例如--5
    //运算符为正数时，其符号+必须省略，例如+2+4定义为非法，而负数时为合法，例如-2+4
    //程序要能处理表达式中间出现的空格（输入表达式中存在空格为合法情况）
    //其他不符合表达式书写规则的情况
    //输入格式:
    //从键盘输入一行表达式。例如2+3*(5  -6   /    4)/3 +26-300*3/29
    //
    //输出格式:
    //有以下三种输出结果：
    //
    //表达式不合法时，输出Wrong Format
    //出现无法计算情况时（例如除0），输出输入表达式 = NaN
    //能够正确运算时，输出输入表达式 = 计算结果

    // 输入样例1:
    //在这里给出一组输入。例如：
    //
    //2+3*(5  -6   /    4)/3 +26-300*3/29
    //输出样例1:
    //在这里给出相应的输出。例如：
    //
    //2+3*(5  -6   /    4)/3 +26-300*3/29 = 0.47
    //输入样例2:
    //在这里给出一组输入。例如：
    //
    //2+3-      5  /   0
    //输出样例2:
    //在这里给出相应的输出。例如：
    //
    //2+3-      5  /   0         = NaN
    //输入样例3:
    //在这里给出一组输入。例如：
    //
    //((2-3/4*5/4  +8-0.4)/100-003*5
    //输出样例3:
    //在这里给出相应的输出。例如：
    //
    //Wrong Format

    // 1*1-1*7+1*5-3+4


    static Set<Character> invalidOperatorSetAtFirstPosition = new HashSet<Character>(Arrays.asList(new Character[]{'+', '*', '/', ')'}));
    static Set<Character> invalidOperatorSetAtLastPosition = new HashSet<Character>(Arrays.asList(new Character[]{'-', '+', '*', '/', '('}));
    static Set<Character> operatorSet = new HashSet<Character>(Arrays.asList(new Character[]{'-', '+', '*', '/', '(', ')'}));
    static Stack digitStack;
    static Stack operatorStack;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String exprForDisplay = sc.nextLine();
        String expr = exprForDisplay.replace(" ", "");
        digitStack = new Stack();
        operatorStack = new Stack();
        if (!validate(expr) || hasInvalidOperator(expr)) {
            System.out.println("Wrong Format");
        } else {
            String result = transExpression(expr);
            if ("Wrong Format".equals(result)) {
                System.out.println(result);
            } else {
                System.out.println(exprForDisplay + " = " + String.format("%.2f", Double.valueOf(calculate())));
            }
        }
    }

    private static boolean numberStartWithZero(String expr) {
        String[] split = expr.replace("+", ",").replace("-", ",")
                .replace("*", ",")
                .replace("/", ",").replace("(", ",").replace(")", ",").split(",");
        for (int i = 0; i < split.length; i++) {
            if (split[i] != null && split[i].length() > 1 && split[i].startsWith("0")) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasInvalidOperator(String expr) {
        if (expr.length() > 0) {
            if (invalidOperatorSetAtFirstPosition.contains(expr.trim().charAt(0))
                    || invalidOperatorSetAtLastPosition.contains(expr.trim().charAt(expr.trim().length() - 1))) {
                return true;
            }
        }
        return false;
    }

    private static boolean validate(String expr) {
        expr = expr.replaceAll("\\s+", "");
        if ("".equals(expr)) {
            return false;
        }

        if (expr.contains("--") || expr.startsWith("+")) {
            return false;
        }
        if (expr.startsWith("-")) {
            expr = expr.substring(1);
        }
        if (expr.equals("")) {
            return false;
        }
        char[] charArray = expr.toCharArray();
        int leftCount = 0;
        boolean hasOperator = false;
        List<Character> temp = new ArrayList<Character>();
        for (char c : charArray) {
            if ((c >= '0' && c <= '9') || operatorSet.contains(c)) {
                if (c == '(') {
                    leftCount++;
                    temp = new ArrayList<Character>();
                } else if (c == ')') {
                    leftCount--;
                    if (leftCount < 0) {
                        return false;
                    }
                    if (temp.isEmpty()) {
                        return false;
                    }
                    StringBuffer sb = new StringBuffer();
                    for (Character character : temp) {
                        sb.append(character);
                    }
                    if (!validate(sb.toString())) {
                        return false;
                    }
                } else {
                    temp.add(c);
                    if (operatorSet.contains(c)) {
                        if (hasOperator && c != '-') {
                            return false;
                        } else {
                            hasOperator = true;
                        }
                    } else {
                        hasOperator = false;
                    }
                }
            } else {
                return false;
            }

        }
        return true;
    }

    private static String calculate() throws Exception {
        Stack stack = reverse(digitStack);
        Stack stack1 = new Stack();
        while (!stack.isEmpty()) {

            String value = (String) stack.pop();

            if (!isOperator(value)) {
                stack1.push(value);
            } else {
                String value1 = (String) stack1.pop();
                String value2 = (String) stack1.pop();
                Double result = cal(value1, value2, value);
                if ("/".equals(value) && Double.parseDouble(value1) == 0) {
                    return "NaN";
                } else {
                    stack1.push(String.valueOf(result));
                }
            }
        }

        return (String) stack1.pop();
    }

    private static Stack reverse(Stack s) throws Exception {
        Stack result = new Stack();
        while (!s.isEmpty()) {
            result.push(s.pop());
        }
        return result;
    }

    private static int getPriority(String operatorA) {
        if (operatorA.equals("+") || operatorA.equals("-")) {
            return 1;
        } else if (operatorA.equals("*") || operatorA.equals("/")) {
            return 2;
        } else if (operatorA.equals("(") || operatorA.equals(")")) {
            return 0;
        }
        return 0;
    }

    private static boolean isOperator(String a) {
        char c = a.charAt(a.length() - 1);
        return operatorSet.contains(c);
    }

    private static boolean comparePriority(String operatorA, String operatorB) {
        return getPriority(operatorA) >= getPriority(operatorB);
    }

    private static Double cal(String a, String b, String operator) {
        Double tempValue1 = Double.parseDouble(a);
        Double tempValue2 = Double.parseDouble(b);
        if (operator.equals("+")) {
            return tempValue1 + tempValue2;
        }
        if (operator.equals("-")) {
            return tempValue2 - tempValue1;
        }
        if (operator.equals("*")) {
            return tempValue1 * tempValue2;
        }
        if (operator.equals("/")) {
            if (tempValue1.compareTo(0.0) == 0) {
                return Double.NaN;
            } else {
                return tempValue2 / tempValue1;
            }
        }
        return 0D;
    }

    private static String transExpression(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", "");
        int n = 0;
        boolean flag = false;
        boolean negativeFlag = false;
        for (int i = 0; i < expression.length(); i++) {
            String c = String.valueOf(expression.charAt(i));
            if (isOperator(c)) {
                if (flag) {
                    if (negativeFlag) {
                        negativeFlag = false;
                        n *= -1;
                    }
                    digitStack.push("" + n);
                    n = 0;
                    flag = false;
                } else if (c.equals("-")) {
                    negativeFlag = true;
                    continue;
                }
                if (operatorStack.isEmpty()) {
                    operatorStack.push(c);
                } else {
                    // 遇到一个右括号，则弹出操作栈到后缀栈，直到弹出的符号是左括号
                    if (c.equals(")")) {
                        String operator = (String) operatorStack.pop();
                        while (operator != null && !operator.equals("(")) {
                            digitStack.push(operator);
                            if (operatorStack.isEmpty()) {
                                 break;
                            }
                            operator = (String) operatorStack.pop();
                        }
                    } else if (c.equals("(")) {
                        operatorStack.push(c);
                    } else {
                        String operator = (String) operatorStack.peek();
                        while (operator != null) {
                            // 比如当前操作符优先级是否大于操作栈中栈顶的符号，如果大于，则压入操作栈，如果小于，则弹出操作栈的符号，
                            // 一直到弹出的操作符号小于当前符号为止
                            if (comparePriority(c, operator)) {
                                operatorStack.push(c);
                                break;
                            } else {
                                operator = (String) operatorStack.pop();
                                digitStack.push(operator);
                                if (operatorStack.isEmpty()) {
                                    operatorStack.push(c);
                                    break;
                                }
                                operator = (String) operatorStack.peek();
                                if (operator == null) {
                                    operatorStack.push(c);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            else {
                if (flag && n == 0) {
                    return "Wrong Format";
                }
                n = n * 10 + Integer.valueOf(c);
                flag = true;
            }
        }
        if (flag) {
            if (negativeFlag) {
                negativeFlag = false;
                n *= -1;
            }
            digitStack.push("" + n);
        }

        // 将操作栈的符号压入到数字栈
        while (!operatorStack.isEmpty()) {
            digitStack.push(operatorStack.pop());
        }
        return "";
    }

}
