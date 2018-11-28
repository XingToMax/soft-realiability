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
public abstract class Model implements DataReader{
    /**
     * 错误数
     */
    protected int n;
    protected int trainDataNum;

    /**
     * 失效时间列表
     */
    protected List<Double> failCountList;
    protected List<Double> trainDataset;
    protected List<Double> testDataset;

    /**
     * U-图数据
     */
    protected List<Double> uValueList;

    /**
     * Y-图数据
     */
    protected List<Double> yValueList;

    public Model() {
        failCountList = new LinkedList<>();
        uValueList = new LinkedList<>();
        yValueList = new LinkedList<>();
        trainDataset = new LinkedList<>();
        testDataset = new LinkedList<>();
        trainDataset.add(0d);
    }
    /**
     * 计算分布值
     * @param x
     * @return
     */
    public abstract double calculateFunctionDistribution(double x);

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

        // 构造训练集和测试集
        trainDataNum = (int) (n * 0.7);
        for (int i = 0; i < n; i++) {
            if (i < trainDataNum) {
                trainDataset.add(failCountList.get(i));
            } else {
                testDataset.add(failCountList.get(i));
            }
        }

    }

    public double get(int i) {
        return this.trainDataset.get(i);
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getTrainDataNum() {
        return trainDataNum;
    }

    public void setTrainDataNum(int trainDataNum) {
        this.trainDataNum = trainDataNum;
    }

    public List<Double> getFailCountList() {
        return failCountList;
    }

    public void setFailCountList(List<Double> failCountList) {
        this.failCountList = failCountList;
    }

    public List<Double> getuValueList() {
        return uValueList;
    }

    public void setuValueList(List<Double> uValueList) {
        this.uValueList = uValueList;
    }

    public List<Double> getyValueList() {
        return yValueList;
    }

    public void setyValueList(List<Double> yValueList) {
        this.yValueList = yValueList;
    }

    public List<Double> getTrainDataset() {
        return trainDataset;
    }

    public void setTrainDataset(List<Double> trainDataset) {
        this.trainDataset = trainDataset;
    }

    public List<Double> getTestDataset() {
        return testDataset;
    }

    public void setTestDataset(List<Double> testDataset) {
        this.testDataset = testDataset;
    }
}
