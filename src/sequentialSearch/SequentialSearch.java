package sequentialSearch;

import java.sql.Array;
import java.util.ArrayList;

public class SequentialSearch {

    public int searchFunc(ArrayList<Integer> dataList, Integer searchItem) {
        for (int index = 0; index < dataList.size(); index++) {
            if (dataList.get(index) == searchItem) {
                return index;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testData = new ArrayList<>();
        for (int index = 0; index < 10; index++) {
            testData.add((int)(Math.random() * 100));
        }

        SequentialSearch search = new SequentialSearch();

        System.out.println(testData);
        System.out.println(search.searchFunc(testData, 50));
    }

}
