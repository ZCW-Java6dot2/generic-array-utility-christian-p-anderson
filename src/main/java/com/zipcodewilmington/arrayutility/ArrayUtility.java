package com.zipcodewilmington.arrayutility;

import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    private final ArrayList<T> newList;
    private T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
        newList = new ArrayList<>(Arrays.asList(inputArray));
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        this.newList.addAll(Arrays.asList(arrayToMerge)); // merged inputArray with arrayToMerge
        return Collections.frequency(newList, valueToEvaluate);
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        this.newList.addAll(Arrays.asList(arrayToMerge));

        T[] mergedArray = (T[]) this.newList.toArray();
        Arrays.sort(mergedArray);

        int maxCount = 1;
        T result = mergedArray[0];
        int currentCount = 1;

        for (int i = 1; i < mergedArray.length; i++) {
            if (mergedArray[i] == mergedArray[i - 1]) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    result = mergedArray[i - 1];
                }
                currentCount = 1;
            }
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            result = mergedArray[mergedArray.length - 1];
        }

        return result;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        return Collections.frequency(this.newList, valueToEvaluate);
    }

    public T[] removeValue(T valueToRemove) {
        int numberOfOccurrences = getNumberOfOccurrences(valueToRemove);

        T[] results = Arrays.copyOf(inputArray, inputArray.length - numberOfOccurrences);

        int j = 0; // need to track what we put in results array appropriately

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] != valueToRemove) {
                results[j] = inputArray[i];
                j++;
            }
        }

        return results;

    }

}
