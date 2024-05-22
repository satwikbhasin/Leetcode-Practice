import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class QuickSort {

    private static void quickSort(List<Integer> array, int start, int end){
        if (end - start <= 1)
            return;

        int startPtr = start;
        int endPtr = end - 1;
        int pivot = array.get(endPtr);

        while(startPtr < endPtr){
            while(array.get(startPtr) < pivot && startPtr < endPtr){
                startPtr++;
            }

            while(array.get(endPtr) >= pivot && startPtr < endPtr){
                endPtr--;
            }

            if(startPtr != endPtr){
                int temp = array.get(startPtr);
                array.set(startPtr, array.get(endPtr));
                array.set(endPtr, temp);
            }
        }

        int temp = array.get(startPtr);
        array.set(startPtr, array.get(end - 1));
        array.set(end - 1, temp);

        quickSort(array, start, startPtr);
        quickSort(array, startPtr + 1, end);
    }

    public static List<Integer> sortList(List<Integer> unsortedList) {
        quickSort(unsortedList, 0, unsortedList.size());
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
