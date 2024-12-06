package binarySearch.bsOnAnswers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookAllocationProblem {
    public static int findPages(List<Integer> list , int n, int m) {
        if (m > n) return -1;
        int low = Collections.max(list);
        int high = list.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = low + (high - low)/2;
            int students = countStudents(list, mid);
            if (students > m) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countStudents(List<Integer> list, int pages) {
        int n = list.size();
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0 ; i < n; i++ ) {
            if (pagesStudent + list.get(i) <= pages) {
                pagesStudent += list.get(i);
            }
            else {
                students++;
                pagesStudent = list.get(i);
            }
        }
        return students;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        int n = 5;
        int m = 4;
        System.out.println("The minimum number of pages to allocate is: " + findPages(array, n, m));
    }
}
