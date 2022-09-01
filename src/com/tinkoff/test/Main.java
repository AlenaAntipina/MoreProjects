package com.tinkoff.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String nm = scanner.nextLine();

        int n = Integer.parseInt(nm.substring(0, nm.indexOf(" ")));
        int m = Integer.parseInt(nm.substring(nm.indexOf(" ") + 1));

        String[] line = new String[n];
        char[] array_char = new char[n];
        int[] array_t = new int[n];
        int[] array_k = new int[n];

        for (int i = 0; i < n; i++) {
            line[i] = scanner.nextLine();
            array_char[i] = line[i].charAt(0);
            String line_a = line[i].substring(line[i].indexOf(" ") + 1);
            array_t[i] = Integer.parseInt(line_a.substring(0, line_a.indexOf(" ")));
            array_k[i] = Integer.parseInt(line_a.substring(line_a.indexOf(" ") + 1));
        }
        int t;
        String request = scanner.nextLine();
        int[] array_k2;

        int[] array_request = Arrays.stream(request.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int k = 0; k < array_request.length; k++) {
            t = 0;
            array_k2 = Arrays.copyOf(array_k, array_k.length);
            for (int i = 0; i < n; i++) {
                if (array_char[i] == '-') {
                    array_k2[i] = array_request[k] - array_k[i];
                    array_request[k] = array_k2[i];
                }
                if (array_char[i] == '+') {
                    array_k2[i] = array_request[k] + array_k[i];
                    array_request[k] = array_k2[i];
                }
            }

            for (int i = 0; i < n - 1; i++) {
                if (array_k2[i] < 0) {
                    t = t + (-1) * array_k2[i] * (array_t[i + 1] - array_t[i]);
                }
            }
            if (array_k2[n - 1] < 0) System.out.println("INFINITY");
            else System.out.println(t);
        }
    }
}
