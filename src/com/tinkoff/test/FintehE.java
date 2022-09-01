package com.tinkoff.test;

import java.util.Arrays;
import java.util.Scanner;

public class FintehE {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();

        String sn = line1.substring(0, line1.indexOf(" "));
        String sm = line1.substring(line1.indexOf(" ") + 1);
        int n = Integer.parseInt(sn);
        //int m = Integer.parseInt(sm);

        String[] line = new String[n];
        char[] array_char = new char[n]; //массив для знака
        int[] array_t = new int[n]; // для времени
        int[] array_k = new int[n]; // для коньков

        for (int i = 0; i < n; i++) {
            //scanner = new Scanner(System.in);
            line[i] = scanner.nextLine();
            array_char[i] = line[i].charAt(0); // заволняю массив знаков, времени и коньков
            String line_a = line[i].substring(line[i].indexOf(" ") + 1);
            array_t[i] = Integer.parseInt(line_a.substring(0, line_a.indexOf(" ")));
            array_k[i] = Integer.parseInt(line_a.substring(line_a.indexOf(" ") + 1));
        }
        //System.out.println(Arrays.toString(array_char));
        //System.out.println(Arrays.toString(array_t));
        //System.out.println(Arrays.toString(array_k));
        int t;
        //scanner = new Scanner(System.in);
        String line3 = scanner.nextLine();
        int[] array_k2; // для копии коньков

        int[] array_line3 = Arrays.stream(line3.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int k = 0; k < array_line3.length; k++) {
            t = 0;
            array_k2 = Arrays.copyOf(array_k, array_k.length); // работаем с копией
            for (int i = 0; i < n; i++) {
                if (array_char[i] == '-') {
                    array_k2[i] = array_line3[k] - array_k[i];
                    array_line3[k] = array_k2[i];
                }
                if (array_char[i] == '+') {
                    array_k2[i] = array_line3[k] + array_k[i];
                    array_line3[k] = array_k2[i];
                }
            }
            System.out.println(Arrays.toString(array_k2));// сколько коньков в наличии(это положительные) или
            // в ожидании на момент времени
            for (int i = 0; i < n - 1; i++) {
                if (array_k2[i] < 0) {// учитываю только время ожидания,
                    // то есть когда количество коньков отрицательно
                    t = t + (-1) * array_k2[i] * (array_t[i + 1] - array_t[i]); // умножаю на период времени
                }
            }
            if (array_k2[n - 1] < 0) System.out.println("INFINITY");//если на последний момент времени отрицательное
                // количество коньков, то INFINITY
            else System.out.println(t);
        }
    }
}
