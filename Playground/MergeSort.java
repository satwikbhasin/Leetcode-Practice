import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

class MergeSort {
    private static void merge(List<Integer> sortedArray, List<Integer> leftHalf, List<Integer> rightHalf){
        int l = 0;
        int r = 0;
        int s = 0;

        while(l < leftHalf.size() && r < rightHalf.size()){
            if(leftHalf.get(l) <= rightHalf.get(r)){
                sortedArray.set(s++, leftHalf.get(l++));
            } else{
                sortedArray.set(s++, rightHalf.get(r++));
            }
        }

        while(l < leftHalf.size()){
            sortedArray.set(s++, leftHalf.get(l++));
        }

        while(r < rightHalf.size()){
            sortedArray.set(s++, rightHalf.get(r++));
        }
    }

    private static void mergeSort(List<Integer> array){
        if(array.size() > 1){

            int mid = array.size()/2;
            List<Integer> leftHalf = new ArrayList<>(array.subList(0, mid));
            List<Integer> rightHalf = new ArrayList<>(array.subList(mid, array.size()));

            mergeSort(leftHalf);
            mergeSort(rightHalf);

            merge(array, leftHalf, rightHalf);
        }
    }

    public static List<Integer> sortList(List<Integer> unsortedList) {
        mergeSort(unsortedList);
        return unsortedList;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> unsortedList = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = sortList(unsortedList);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
