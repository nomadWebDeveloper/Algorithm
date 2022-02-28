package sort;

import java.util.ArrayList;
import java.util.Collections;


public class BubbleSort {

    public ArrayList<Integer> sort(ArrayList<Integer> dataList) {
        for (int index = 0; index < dataList.size() - 1; index++){
            boolean swap = false;

            for (int index2 = 0; index2 < dataList.size() - 1 - index; index2++) {
                if (dataList.get(index2) > dataList.get(index2 + 1)) {
                    Collections.swap(dataList, index2, index2 + 1);
                    swap = true;
                }
            }
            if (swap == false) break;
        }
        return dataList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> dataList = new ArrayList<>();
        BubbleSort instance = new BubbleSort();

        dataList.add(6);
        dataList.add(1);
        dataList.add(2);
        dataList.add(5);
        dataList.add(3);
        dataList.add(4);

        System.out.println(instance.sort(dataList));

// 내방법
//        int a = 0;
//        while(true) {
//            for (int i = 0 ; i < dataList.size() - 1; i++) {
//                if (dataList.get(i) > dataList.get(i + 1)) {
//                    Collections.swap(dataList, i, i+1);
//                }
//            }
//
//            for (int i = 0 ; i < dataList.size() - 1; i++) {
//                if (dataList.get(i) > dataList.get(i + 1)) {
//                    a++;
//                }
//            }
//            if (a == 0) break;
//            else a = 0;
//
//        }
//
//        System.out.println(dataList);


    }

}
