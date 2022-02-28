package sort;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class InsertionSort {
    public ArrayList<Integer> Sort(ArrayList<Integer> dataList) {

        for (int index = 0; index < dataList.size() - 1; index++) {
            int temp = dataList.get(index + 1);
            for (int index2 = index + 1; index2 > 0; index2--) {

                if(dataList.get(index2) < dataList.get(index2 - 1)) {
                    Collections.swap(dataList, index2, index2 - 1);
                } else {
                    break;
                }


            }
        }
        return dataList;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dataList.add((int)(Math.random() * 10));
        }

        System.out.println(insertionSort.Sort(dataList));


    }
}
