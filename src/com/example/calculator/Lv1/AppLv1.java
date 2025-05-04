package com.example.calculator.Lv1;

import java.util.Scanner;

// Lv1 구현 코드
public class AppLv1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String line = sc.nextLine();
            char operator = sc.next().charAt(0);

            switch(operator) {
                case '+':
                    System.out.println(num1 + num2);    break;
                case '-':
                    System.out.println(num1 - num2);    break;
                case '*':
                    System.out.println(num1 * num2);    break;
                case '/':
                    try{
                        System.out.println(num1 / num2);
                        break;
                    }catch(Exception e){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");

                    }
            }

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료)");
        }while(sc.nextLine() != null && !sc.nextLine().equals("exit"));

        System.out.println("계산기가 종료됩니다.");
    }
}
