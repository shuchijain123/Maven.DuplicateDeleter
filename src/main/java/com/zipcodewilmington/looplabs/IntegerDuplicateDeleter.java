package com.zipcodewilmington.looplabs;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    Integer[] intArray = super.array;
    Integer[] numberArray = new Integer[]{};

    int maxNumberOfDuplications;

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }


    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {

        numberArray = Arrays.stream(intArray).distinct().toArray(Integer[]::new);
        Integer[] countArray = new Integer[numberArray.length];

        for (int i = 0; i < numberArray.length; i++) {
            int cnt = 0;
            for (int j = 0; j < intArray.length; j++) {

                if (numberArray[i] == intArray[j]) {
                    cnt++;
                }

            }

            countArray[i] = cnt;


        }
        System.out.println(Arrays.toString(countArray));
        int resultSize = Arrays.stream(countArray).filter(num -> num < maxNumberOfDuplications).reduce(0, (x, y) -> x + y);
        System.out.println("resultSize=" + resultSize);

        Integer[] resultArray = new Integer[resultSize];
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
        public Integer[] removeDuplicatesExactly ( int exactNumberOfDuplications) {


                numberArray = Arrays.stream(intArray).distinct().toArray(Integer[]::new);
                Integer[] countArray = new Integer[numberArray.length];

                for (int i = 0; i < numberArray.length; i++) {
                    int cnt = 0;
                    for (int j = 0; j < intArray.length; j++) {

                        if (numberArray[i] == intArray[j]) {
                            cnt++;
                        }

                    }

                    countArray[i] = cnt;


                }
                System.out.println(Arrays.toString(countArray));
                int resultSize = Arrays.stream(countArray).filter(num -> num != exactNumberOfDuplications).reduce(0, (x, y) -> x + y);
                System.out.println("resultSize=" + resultSize);

                Integer[] resultArray = new Integer[resultSize];
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


