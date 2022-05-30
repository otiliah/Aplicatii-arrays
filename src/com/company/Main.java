package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //populatingArrayRandom(8);
        //countUniqueNumers(populatingArrayRandom(10));
        //killDuplicate(populatingArrayRandom(10));
        arrayBi(populatingArrayRandom(10));
    }

    //generare array random  cu lungime dorita
    public static int[] populatingArrayRandom(int lengthArray) {
        int[] arrayRandom = new int[lengthArray];
        for (int i = 0; i < lengthArray; i++) {
            arrayRandom[i] = (int) (Math.random() * lengthArray);
        }
        return arrayRandom;
    }

    // numararea elementelor unice intr-un array
    public static int countUniqueNumers(int[] arrCopy) {
        int countDuplicate = 0, caseMoreDuplicates = 0;
        //int[] arr = Arrays.copyOfRange(arrCopy, 0, arrCopy.length);
        for (int i = 0; i < arrCopy.length; i++) {
            if (arrCopy[i] == -1) continue;
            for (int j = i + 1; j < arrCopy.length; j++) {
                if (arrCopy[i] == arrCopy[j]) {
                    caseMoreDuplicates++;
                    arrCopy[j] = -1;
                }
            }
            if (caseMoreDuplicates >= 1) {
                countDuplicate += caseMoreDuplicates;
            }
            caseMoreDuplicates = 0;
        }
        //System.out.println("Afisare array inital: " + Arrays.toString(arr));
        //System.out.println("Afisare array copy: " + Arrays.toString(arrCopy));
        //System.out.println("In array-ul random sunt " + (arr.length - countDuplicate) + " numere");
        return arrCopy.length - countDuplicate;
    }

    //remove elemente duplicat
    public static int[] killDuplicate(int[] arr) {
        int index = 0;
        int[] array = Arrays.copyOfRange(arr, 0, arr.length);
        int length = countUniqueNumers(arr);
        int[] noDuplicates = new int[length];

        if (arr.length == 0 || arr.length == 1) {
            return new int[]{arr.length};
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                continue;
            }
            noDuplicates[index++] = arr[i];
        }
        //System.out.println("Array-ul random este:" + Arrays.toString(array));
        //System.out.println("Lungimea array-ului cu elemente unice este: " + length);
        //System.out.println("Array-ul cu elemente unice este: " + Arrays.toString(withoutDuplicates));
        return noDuplicates;
    }

    //creare array bidimensional: array[0][] - array cu elementele unice ale unui array generat random
    //                            array[1][] - numarul de aparitii al elementelor in array
    public static void arrayBi(int[] arr) {
        int count = 0;
        int[] array = Arrays.copyOfRange(arr, 0, arr.length);
        int[] arrNoDuplicates = killDuplicate(arr);
        int[][] arrBi = new int[2][arrNoDuplicates.length];
        for (int i = 0; i < arrNoDuplicates.length; i++) {
            arrBi[0][i] = arrNoDuplicates[i];
        }
        for (int i = 0; i < arrNoDuplicates.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (arrNoDuplicates[i] == array[j]) {
                    count++;
                }
            }
            arrBi[1][i] = count;
            count = 0;
        }
        System.out.println("Array-ul initial este: " + Arrays.toString(array));
        System.out.println("Array-ul cu elemente unice este: " + Arrays.toString(arrNoDuplicates));
        System.out.println("Array-ul bidimensional este: " + Arrays.deepToString(arrBi));
    }
}
