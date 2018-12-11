package nuaa.softrely.tomax.homework.util;

import java.io.*;
import java.util.*;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/28 23:36
 */
public class Sort {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream(Sort.class.getResource("/").getPath() + "/failure_count.txt");
        FileWriter writer = new FileWriter(Sort.class.getResource("/").getPath() + "/failure_count_sorted.txt");
        Scanner scanner = new Scanner(input);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            scanner.nextInt();
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int i = 1;
        for (Integer in : list) {
            writer.write(i + " " + in);
            writer.write("\n");
        }
        scanner.close();
        input.close();
        writer.close();
    }
}
