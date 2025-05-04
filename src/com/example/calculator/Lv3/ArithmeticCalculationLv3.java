//package com.example.calculator.Lv3;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//enum OperatorType {
//    abstract <N extends Number> N calculate(N num1, N num2);
//    ADD{
//        @Override
//        public <N extends Number> N calculate(N num1, N num2) throws Exception {
//            double result = num1.doubleValue() + num2.doubleValue();
//            if(num1 instanceof Integer)
//                return (int)result;
//            return num1.doubleValue() + num2.doubleValue();
//        }
//    },
//    SUBTRACT{
//        public <N extends Number> N calculate(N num1, N num2) throws Exception {
//                return num1.doubleValue() - num2.doubleValue();
//            }
//    },
//    MULTIPLY {
//        public <N extends Number > N calculate(N num1, N num2) throws Exception {
//            return num1.doubleValue() * num2.doubleValue();
//        }
//    },
//    DIVIDE {
//        public <N extends Number > N calculate (N num1, N num2) throws Exception {
//            if(num2.doubleValue() == 0)
//                throw new Exception("0으로 나눌 수 없음");
//            return num1.doubleValue() / num2.doubleValue();
//        }
//    };
//
//    private char operator;
//    private double num1, num2;
//
//    abstract <N extends Number> N calculate(N num1, N num2) throws Exception;
//
//    OperatorType(){}
//
//    <N extends Number> OperatorType(char op, N num1, N num2) {
//        this.operator = op;
//        this.num1 = num1.doubleValue();
//        this.num2 = num2.doubleValue();
//    }
//
//}
//public class ArithmeticCalculationLv3 <N extends Number> implements printBig{
//    private ArrayList<N> arrayList = new ArrayList<>();
//
//    public String calculate(N num1, N num2, char operator) throws Exception {
//        String result = "";
//
//        switch (operator) {
//            case '+':
//                result = num1 + num2 + "";  break;
//            case '-':
//                result = num1 - num2 + "";  break;
//            case '*':
//                result = num1 * num2 + "";  break;
//            case '/':
//                try {
//                    result = num1 / num2 + "";  break;
//                } catch(Exception e){
//                    return "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
//                }
//        }
//        return result;
//    }
//
//    public ArrayList getList() { return arrayList; }
//    public void setList(ArrayList resultList) { arrayList = resultList; }
//
//    @Override
//    public void printBigger(double num) {
//        List<N> printList = getList().stream()
//                .map(n -> (double)n)
//                .filter(n -> n > num)
//                .collect(Collectors.toList());
//
//        System.out.println(printList);
//    }
//}
//
//@FunctionalInterface
//interface printBig {
//    void printBigger(double num);
//}
//
///*
//int n = sc.nextNumber;
//
//// 원래 그냥 메서드로 작성하면 이렇게.
//public printBigger(int n) {
//    for(int i = 0; i < list.length(); i++){
//        if(n < list.get(i))
//            System.out.print(list.get(i) + " ");
//    }
//}
//
////
//@FunctionalInterface
//interface print(N numm) {
//    printBigger(N num);
//}
//
//람다로 구현하면
//public <N extends Number> printBigger implements print (N num) {
//    List<N> printList = getList().stream()
//    .filter(n -> n < list)
//    .collect(Collectors toList());
//
//    System.out.println(printList);
//*/