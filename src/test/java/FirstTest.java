import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.homework.Lesson14.LastTask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstTest {

    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void firstTest(int[] inputArr, int[] outputArr) {
        Assertions.assertArrayEquals(LastTask.filterArray(inputArr), outputArr);
    }

    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        int[] inputArr = {1, 4, 3, 4, 3, 4, 7, 8, 9};
        int[] outputArr = {7, 8, 9};
        out.add(Arguments.arguments(inputArr, outputArr));

        int[] inputArr1 = {1, 4, 3};
        int[] outputArr1 = {3};
        out.add(Arguments.arguments(inputArr1, outputArr1));

        int[] inputArr2 = {4, 7, 8, 9};
        int[] outputArr2 = {7, 8, 9};
        out.add(Arguments.arguments(inputArr2, outputArr2));

        int[] inputArr3 = {4, 7, 8, 4};
        int[] outputArr3 = {};
        out.add(Arguments.arguments(inputArr3, outputArr3));

        return out.stream();
    }

}
