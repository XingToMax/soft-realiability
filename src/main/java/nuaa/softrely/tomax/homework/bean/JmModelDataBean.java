package nuaa.softrely.tomax.homework.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/5 18:59
 */
public class JmModelDataBean extends DatasetBean{
    /**
     * p的值对于单个jm而言应是定值
     */
    private Double valueP;

    /**
     * n 的估计值
     */
    private double nPointEvaluate;

    /**
     * fai 的估计值
     */
    private double faiPointEvaluate;

    // 过程变量
    private int right;
    private int left;
    private int root;

    public Double getValueP() {
        return valueP;
    }

    public void setValueP(Double valueP) {
        this.valueP = valueP;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public double getnPointEvaluate() {
        return nPointEvaluate;
    }

    public void setnPointEvaluate(double nPointEvaluate) {
        this.nPointEvaluate = nPointEvaluate;
    }

    public double getFaiPointEvaluate() {
        return faiPointEvaluate;
    }

    public void setFaiPointEvaluate(double faiPointEvaluate) {
        this.faiPointEvaluate = faiPointEvaluate;
    }
}
