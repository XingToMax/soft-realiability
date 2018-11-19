package nuaa.softrely.tomax.homework.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/15 18:15
 */
public class DatasetBean implements DataReader{
    /**
     * 错误数
     */
    protected int n;

    /**
     * 失效时间列表
     */
    protected List<Double> failCountList;

    public DatasetBean() {
        failCountList = new LinkedList<>();
        failCountList.add(0d);
    }

    public void add(Double data) {
        this.failCountList.add(data);
        n++;
    }

    @Override
    public void readData(String path) throws IOException {
        FileInputStream stream = new FileInputStream(path);
        Scanner scanner = new Scanner(stream);
        while (scanner.hasNext()) {
            scanner.nextInt();
            add(scanner.nextDouble());
        }
        stream.close();
        scanner.close();
    }

    public double get(int i) {
        return this.failCountList.get(i);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public List<Double> getFailCountList() {
        return failCountList;
    }

    public void setFailCountList(List<Double> failCountList) {
        this.failCountList = failCountList;
    }
}
