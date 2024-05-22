import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class BubbleSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        boolean swapped = true;
        while(swapped){
            int swapCount = 0;
            for(int i = 0; i < unsortedList.size() - 1; i++){
                if(unsortedList.get(i) > unsortedList.get(i+1)){
                    int next = unsortedList.get(i+1);
                    unsortedList.set(i+1, unsortedList.get(i));
                    unsortedList.set(i, next);
                    swapCount++;
                }
            }
            swapped = swapCount > 0;
        }
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
