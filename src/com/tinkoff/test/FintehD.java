package com.tinkoff.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Math.max;

public class FintehD {
    public void run() {
        Scanner scan = new Scanner(System.in);

        String wlr = scan.nextLine();
        int w = Integer.parseInt(wlr.substring(0, wlr.indexOf(" ")));
        wlr = wlr.substring(wlr.indexOf(" ") + 1);
        int l = Integer.parseInt(wlr.substring(0, wlr.indexOf(" ")));
        int r = Integer.parseInt(wlr.substring(wlr.indexOf(" ") + 1));

        String left_line = scan.nextLine();
        String right_line = scan.nextLine();

        int[] left = Arrays.stream(left_line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum_left = IntStream.of(left).sum();

        int[] right = Arrays.stream(right_line.split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum_right = IntStream.of(right).sum();

//        int w = scan.nextInt();
//        int l = scan.nextInt();
//        int r = scan.nextInt();
//
//        int[] left = new int[l];
//        scan = new Scanner(System.in);
//        int sum_left = 0;
//        for (int i = 0; i < l; i++){
//            left[i] = scan.nextInt();
//            sum_left += left[i];
//        }
//
//        int[] right = new int[r];
//        int sum_right = 0;
//        scan = new Scanner(System.in);
//        for (int i = 0; i < r; i++){
//            right[i] = scan.nextInt();
//            sum_right += right[i];
//        }

        int current_sum = 0;
        int result_sum = 0;
        if (sum_right >= sum_left){
            int r_line = sum_right / w + 1;    // r_line - кол-во слоев правой бригады

            do {
                int w_right = sum_right % r_line == 0 ? sum_right / r_line : sum_right / r_line + 1;  // длина правой стороны
                System.out.println("слоев кирпичей с правой стороны: " + r_line + ", длина правого слоя: " + w_right);
                int w_left = w - w_right;
                int l_line = sum_left % w_left == 0 ? sum_left / w_left : sum_left / w_left + 1;
                System.out.println("слоев кирпичей с девой стороны: " + l_line + ", длина левого слоя: " + w_left);
                current_sum = max(r_line, l_line);
                if (result_sum >= current_sum || result_sum == 0) result_sum = current_sum;
                r_line++;
                System.out.println("высота стены: " + current_sum);
            } while (current_sum <= result_sum);
        }

        System.out.println(result_sum);
    }
}
