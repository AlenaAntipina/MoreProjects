package com.tinkoff.test;

import java.util.Scanner;

import static java.lang.Math.abs;

public class FintehA {
    public void run(){
        System.out.println("finA");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();          // начальная точка маршрута
        int b = scan.nextInt();          // конечная точка маршрута
        int x = scan.nextInt();
        int y = scan.nextInt();

        int res = abs(a - x) < abs(a - y) ? abs(a - x) + abs (b - y) : abs(a - y) + abs (b - x);

        System.out.println(res);
    }
}
