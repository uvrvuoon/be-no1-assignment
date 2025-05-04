package com.example.calculator.Lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum OperatorType {
    ADD('+'){
        @Override
        public <N extends Number> double calculate(N num1, N num2) {
            return num1.doubleValue() + num2.doubleValue();
        }
    },
    SUBTRACT('-'){
        @Override
        public <N extends Number> double calculate(N num1, N num2) {
                return num1.doubleValue() - num2.doubleValue();
            }
    },
    MULTIPLY('*') {
        @Override
        public <N extends Number > double calculate(N num1, N num2) {
            return num1.doubleValue() * num2.doubleValue();
        }
    },
    DIVIDE('/') {
        @Override
        public <N extends Number > double calculate (N num1, N num2) throws Exception{
            if(num2.doubleValue() == 0)
                throw new Exception("0으로 나눌 수 없음");
            return num1.doubleValue() / num2.doubleValue();
        }
    };

    private char operator;

    OperatorType(char operator){
        this.operator = operator;
    }

    // enum의 추상 메서드는 반드시 상수들 아래에 두어야 한다!!!!
    abstract <N extends Number> double calculate(N num1, N num2) throws Exception;
}

public class ArithmeticCalculatorLv3 <N extends Number> implements printBig{
    private ArrayList<Double> arrayList = new ArrayList<>();
    // 피연산자는 여러 타입을 받을 수 있지만, 결과값은 double로 통일하여 관리

    public String calculate(N num1, N num2, char operator) throws Exception {
        String result = "";

        switch (operator) {
            case '+':
                result = OperatorType.ADD.calculate(num1, num2) + ""; break;
            case '-':
                result = OperatorType.SUBTRACT.calculate(num1, num2) + ""; break;
            case '*':
                result = OperatorType.MULTIPLY.calculate(num1, num2) + ""; break;
            case '/':
                try {
                    result = OperatorType.DIVIDE.calculate(num1, num2) + ""; break;
                } catch(Exception e){
                    return "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                }
        }
        return result;
    }

    public ArrayList<Double> getList() { return arrayList; }
    public void setList(ArrayList<Double> resultList) { arrayList = resultList; }

    @Override
    public void printBigger(double num) {
        List<Double> printList = getList().stream()
                .filter(n -> n > num)
                .collect(Collectors.toList());

        System.out.println(printList);
    }
}

@FunctionalInterface
interface printBig {
    void printBigger(double num);
}