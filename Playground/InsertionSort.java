import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class InsertionSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {
        for (int i = 1; i < unsortedList.size(); i++) {
            int currentElement = unsortedList.get(i);
            int j = i - 1;
            while (j >= 0 && unsortedList.get(j) > currentElement) {
                unsortedList.set(j + 1, unsortedList.get(j));
                j--;
            }
            unsortedList.set(j + 1, currentElement);
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
