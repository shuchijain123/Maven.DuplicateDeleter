package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    String[] stringArray = super.array;
    String[] numberArray = new String[]{};
    public StringDuplicateDeleter(String[] stringArray) {
        super(stringArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {

        numberArray = Arrays.stream(stringArray).distinct().toArray(String[]::new);
        Integer[] countArray = new Integer[numberArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            int cnt = 0;
            for (int j = 0; j < stringArray.length; j++) {

                if (numberArray[i] == stringArray[j]) {
                    cnt++;
                }

            }

            countArray[i] = cnt;


        }
        System.out.println(Arrays.toString(countArray));
        int resultSize = Arrays.stream(countArray).filter(num -> num < maxNumberOfDuplications).reduce(0, (x, y) -> x + y);
        System.out.println("resultSize=" + resultSize);

        String[] resultArray = new String[resultSize];
        int ctr = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; countArray[i]<maxNumberOfDuplications && j < countArray[i]; j++) {
                resultArray[ctr] = numberArray[i];
                ctr++;
            }


        }

        return resultArray;
    }



    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        numberArray = Arrays.stream(stringArray).distinct().toArray(String[]::new);
        Integer[] countArray = new Integer[numberArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            int cnt = 0;
            for (int j = 0; j < stringArray.length; j++) {

                if (numberArray[i] == stringArray[j]) {
                    cnt++;
                }

            }

            countArray[i] = cnt;


        }
        System.out.println(Arrays.toString(countArray));
        int resultSize = Arrays.stream(countArray).filter(num -> num != exactNumberOfDuplications).reduce(0, (x, y) -> x + y);
        System.out.println("resultSize=" + resultSize);

        String[] resultArray = new String[resultSize];
        int ctr = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; countArray[i] != exactNumberOfDuplications && j <countArray[i]; j++) {
                resultArray[ctr] = numberArray[i];
                ctr++;
            }


        }

        return resultArray;
    }


}
