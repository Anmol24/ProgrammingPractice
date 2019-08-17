import java.util.ArrayList;
import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

for each element in the current list, find the minimum sum and see if the sum up till the previous element in the list is to be
included or not.

find the minimum sum of this triangle.

 */
public class TriangleSum {
    public static void main(String[] args) {

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> result = new ArrayList<>();
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        result.add(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currList = triangle.get(i);
            List<Integer> minSum = new ArrayList<>();
            for (int j = 0; j < currList.size(); j++) {
                if (j == 0) {
                    minSum.add(result.get(i - 1).get(0) + currList.get(j));
                } else if (j == currList.size() - 1) {
                    minSum.add(result.get(i - 1).get(result.size() - 1) + currList.get(j));
                } else {
                    int min = Math.min(result.get(i - 1).get(j), result.get(i - 1).get(j - 1));
                    minSum.add(currList.get(j) + min);
                }
            }
            result.add(minSum);

        }
        int finalSum = Integer.MAX_VALUE;
        for (int sum : result.get(result.size() - 1)) {
            if (sum < finalSum) {
                finalSum = sum;
            }
        }
        return finalSum;
    }
}
