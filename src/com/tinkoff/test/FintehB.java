package com.tinkoff.test;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class FintehB {
    public void run(){
        Scanner scan = new Scanner(System.in);
//        int W = scan.nextInt();
//        int H = scan.nextInt();
//        scan = new Scanner(System.in);
//        int w = scan.nextInt();
//        int h = scan.nextInt();

        String WH = scan.nextLine();
        String wh = scan.nextLine();

        int W = Integer.parseInt(WH.substring(0, WH.indexOf(" ")));
        int H = Integer.parseInt(WH.substring(WH.indexOf(" ") + 1));
        int w = Integer.parseInt(wh.substring(0, wh.indexOf(" ")));
        int h = Integer.parseInt(wh.substring(wh.indexOf(" ") + 1));

        int res = 0;

        if ((W / w == 0) && (H / w == 0) || (W / h == 0) && (H / h == 0)) res = -1;
        else{
            int MIN = min(W, H);
            int min = min(w, h);
            int MAX = max(W, H);
            int max = max(w, h);

            while (MAX / max != 0){
                if (MAX == max) break;
                if (MAX % 2 == 0) MAX = MAX / max;
                else MAX = (MAX + 1) / max;
                if (MAX != 0) res++;
            }

            while (MIN / min != 0){
                if (MIN == min) break;
                if (MIN % 2 == 0) MIN = MIN / min;
                else MIN = (MIN + 1) / min;
                if (MIN != 0) res++;
            }
        }

        System.out.println(res);
    }
}
