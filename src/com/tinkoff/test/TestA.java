package com.tinkoff.test;

import java.util.Scanner;

public class TestA {
    public void run(){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();          // Абонентская плата Кости составляет A рублей в месяц.
        int b = scan.nextInt();          // За эту стоимость Костя получает B мегабайт интернет-трафика.
        int c = scan.nextInt();          // Каждый следующий мегабайт будет стоить ему  C  рублей.
        int d = scan.nextInt();          // Костя планирует потратить D мегабайт интернет-трафика в следующий месяц.

        int res = d <= b ? a : a + (d - b) * c;

        System.out.println(res);
        System.out.println("hey");
        System.out.println("b");
    }
}
