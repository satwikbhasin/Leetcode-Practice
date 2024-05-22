import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class SelectionSort {
    public static List<Integer> sortList(List<Integer> unsortedList) {

        for (int i = 0; i < unsortedList.size(); i++) {
            for (int j = i + 1; j < unsortedList.size(); j++) {
                if (unsortedList.get(j) < unsortedList.get(i)) {
                    int temp = unsortedList.get(i);
                    unsortedList.set(i, unsortedList.get(j));
                    unsortedList.set(j, temp);
                }
            }
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
