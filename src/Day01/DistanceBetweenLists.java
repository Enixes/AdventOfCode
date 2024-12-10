package Day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DistanceBetweenLists {
    public static void getAnswer() {
        String inputFileName = "src/Day01/input";

        ArrayList<Integer> points1 = new ArrayList<>();
        ArrayList<Integer> points2 = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while (((line = br.readLine()) != null)) {
                System.out.println(line);
                String[] numbers = line.split("\\s+");
                System.out.println(Arrays.toString(numbers));

                int point1 = Integer.parseInt(numbers[0]);
                int point2 = Integer.parseInt(numbers[1]);

                points1.add(point1);
                points2.add(point2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        points1.sort(Comparator.naturalOrder());
        points2.sort(Comparator.naturalOrder());
        assert points1.size() == points2.size();

        long distanceBetween = IntStream.range(0, points1.size()).parallel().map(i -> Math.abs(points1.get(i) - points2.get(i))).sum();
        System.out.println("Distance Between two lists: " + distanceBetween);
    }

    public static void main(String[] args) {
        getAnswer();
    }
}
