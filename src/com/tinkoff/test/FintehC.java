package com.tinkoff.test;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FintehC {
    public void run() throws InterruptedException {

        // БЛОК ВВОДА ДАННЫХ

        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();      // 1 <= n <= 100
//        int k = scan.nextInt();      // 1 <= k <= 10
//
//
//        Random ran = new Random();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++){
//            scan = new Scanner(System.in);
//            arr[i] = scan.nextInt();
////            arr[i] = ran.nextInt((1000000 - 1) + 1) + 1;
//        }

        String nk = scan.nextLine();

        int n = Integer.parseInt(nk.substring(0, nk.indexOf(" ")));
        int k = Integer.parseInt(nk.substring(nk.indexOf(" ") + 1));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(scan.nextLine());
        }

        long start = System.nanoTime();

        // СОЗДАЮ МАССИВ, ГДЕ БУДУТ ХРАНИТЬСЯ ИНДЕКСЫ НАИБОЛЬШИХ ЗНАЧЕНИЙ МАССИВА (ТИП НАИБОЛЬШЕЕ ЗНАЧЕНИЕ ЛЮДЕЙ В СЕКТОРЕ)

        int[] indexes = new int[k];
        for (int i = 0; i < k; i++){
            indexes[i] = i;
        }

        // В СЛЕДУЮЩЕМ ЦИКЛЕ КАК РАЗ ИЩУ ЭТИ ИНДЕКСЫ И СОХРАНЯЮ ИХ СРАЗУ ОТСОРТИРОВАННЫМИ

        boolean check_similar = false;
        for (int i = k; i < n; i++){

            int min = arr[indexes[0]];
            int ind = 0;

            for (int j = 1; j < k; j++){
                if (arr[indexes[j]] < min) {
                    min = arr[indexes[j]];
                    ind = j;
                }
                if (arr[indexes[j]] == min) check_similar = true;
            }

            if (check_similar) {
                Arrays.sort(indexes);
                FintehC.invertArray(indexes);
                check_similar = false;
            }
            if (arr[i] > arr[indexes[ind]]){
                indexes[ind] = i;
            }
        }

        Arrays.sort(indexes);

        System.out.println(Arrays.toString(indexes));

        // НАЧАЛЬНЫЙ МАССИВ СМЕЩАЮ ВЛЕВО ДЛЯ УДОБСТВА

        int shift = indexes[0];
        FintehC.shiftArrayLeft(arr, shift);
        System.out.println(Arrays.toString(arr));

        // ИНДЕКСЫ СМЕЩАЮ СООТВЕТСВЕННО

        for (int j = 0; j < k; j++){
            indexes[j] = indexes[j] - shift;
        }
        System.out.println(Arrays.toString(indexes));

        // В ПОСЛЕДНЕМ ЦИКЛЕ СЧИТАЮ ИСКОМОЕ ЧИСЛО

        int count = 0;
        int result = 0;
        int current = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = current; j < k; j++){
                if (count == indexes[j]){
                    count = 0;
                    current = j + 1;
                    break;
                }
            }
            result += count * arr[i];
            count++;
        }

        System.out.println(result);

        Thread.sleep(1000);
        long finish = System.nanoTime();
        long elapsed = finish - start;
        System.out.println(elapsed / 1000000);
    }

    static void  invertArray(int[] array){
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
    static void shiftArrayLeft(int[] array, int shift) {
        if (array.length > 0){
            int[] a = Arrays.copyOf(array, array.length);
            System.arraycopy(a, shift, array, 0, array.length - shift);
            System.arraycopy(a, 0, array, array.length - shift, shift);
        }
    }

}
