package com.example.calculator.Lv2;

import java.util.ArrayList;
import java.util.Scanner;

class Calculator {
    private ArrayList<Integer> arrayList = new ArrayList<>();

    public String calculate(int num1, int num2, char operator) throws Exception {
        String result = "";
        switch (operator) {
            case '+':
                result = num1 + num2 + "";  break;
            case '-':
                result = num1 - num2 + "";  break;
            case '*':
                result = num1 * num2 + "";  break;
            case '/':
                try {
                    result = num1 / num2 + "";  break;
                } catch(Exception e){
                    return "나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.";
                }
        }
        return result;
    }

    public ArrayList<Integer> getList() { return arrayList; }
    public void setList(ArrayList resultList) { arrayList = resultList; }

    public void removeResult() {
        // 가장 먼저 저장된 데이터를 삭제
        arrayList.remove(0);
    }
}

public class AppLv2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 번째 반복마다 저장된 결과값들을 확인하시겠습니까?(숫자만 입력): ");
        int n = sc.nextInt();
        System.out.println("계산기를 시작합니다.");

        Calculator cal = new Calculator();

        int i = 0;  // 연산 횟수를 세기 위한 변수
        do {
            i++;
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String line = sc.nextLine();
            char operator = sc.next().charAt(0);

            String result = cal.calculate(num1, num2, operator);

            System.out.println(result);

            // getter, setter 테스트
            ArrayList mainList = cal.getList();
            try{
                mainList.add(Integer.parseInt(result));
                cal.setList(mainList);
            }catch(Exception e){
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
                continue;
            }

            // removeResult() 메서드 테스트
            if(i == n) {
                System.out.print("첫 번째 저장된 값을 삭제하기 전: ");
                System.out.println(cal.getList().toString());

                cal.removeResult();

                System.out.print("첫 번째 저장된 값을 삭제한 후: ");
                System.out.println(cal.getList().toString());
                i = 0;
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");

        }while(sc.nextLine() != null && !sc.nextLine().equals("exit"));

        System.out.println("계산기가 종료됩니다.");
    }
}

