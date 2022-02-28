package recursiveFunction;

import java.util.ArrayList;

public class ArrayListSum {

    public int ArraySum(ArrayList<Integer> dataList) {

        if (dataList.size() <= 0) {
            return 0;
        } else {
            return dataList.get(0) + this.ArraySum(new ArrayList<Integer>(dataList.subList(1, dataList.size())));
        }
    }

    public static void main(String[] args) {
        ArrayListSum sum = new ArrayListSum();
        ArrayList<Integer> dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataList.add(i);
        }

        System.out.println(sum.ArraySum(dataList));
    }
}
