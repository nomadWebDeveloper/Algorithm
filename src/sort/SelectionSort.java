package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {


        for (int index = 0; index < dataList.size() - 1; index++) {
            int min = dataList.get(index);
            int midIdx = index;

            for(int index2 = index; index2 < dataList.size(); index2++) {
                if (dataList.get(index2) < min) {
                    min = dataList.get(index2);
                    midIdx = index2;
                }
            }
            Collections.swap(dataList, index, midIdx);
        }

        return dataList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0 ; i < 10; i++) {
            dataList.add((int)(Math.random() * 10));
        }
        SelectionSort Ssort = new SelectionSort();

        System.out.println(Ssort.sort(dataList));

    }

}
