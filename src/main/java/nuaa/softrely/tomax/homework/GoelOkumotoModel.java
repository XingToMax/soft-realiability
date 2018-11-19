package nuaa.softrely.tomax.homework;

import nuaa.softrely.tomax.homework.bean.GoelOkumotoBean;

import java.io.IOException;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/15 18:06
 */
public class GoelOkumotoModel {
    /**
     * 阈值
     */
    private static final int EV = 1;

    /**
     * 执行计算go模型
     * @return
     * @throws IOException
     */
    public static GoelOkumotoBean execute() throws IOException {
        GoelOkumotoBean go = new GoelOkumotoBean();
        // 读取数据
        go.readData(GoelOkumotoBean.class.getResource("/").getPath() + "failure_count.txt");
        // 计算d
        go.initdValue();
        // 执行计算步骤
        calculateStepFirst(go);
        // 返回
        return go;
    }

    /**
     * 步骤一
     * @param go
     */
    private static void calculateStepFirst(GoelOkumotoBean go) {
        if (go.getdValue() > 0 && go.getdValue() < 0.5) {
            go.setXl((1 - 2 * go.getdValue()) / 2);
            go.setXr(1 / go.getdValue());
            calculateStepSecond(go);
        } else if (go.getdValue() >= 0.5) {
            calculateStepFifth(go);
        }
    }

    /**
     * 步骤二
     * @param go
     */
    private static void calculateStepSecond(GoelOkumotoBean go) {
        go.setXm((go.getXl() + go.getXr()) / 2);
        if (Math.abs(go.getXr() - go.getXl()) <= EV) {
            calculateStepFourth(go);
        } else {
            calculateStepThird(go);
        }
    }

    /**
     * 步骤三
     * @param go
     */
    private static void calculateStepThird(GoelOkumotoBean go) {
        double fValue = calculateF(go);
        if (fValue > EV) {
            go.setXl(go.getXm());
        } else if (fValue < -EV){
            go.setXr(go.getXm());
        } else {
            calculateStepFourth(go);
            return;
        }
        calculateStepSecond(go);
    }

    /**
     * 步骤四
     * @param go
     */
    private static void calculateStepFourth(GoelOkumotoBean go) {
        // 计算b
        go.setbPoint(go.getXm() / go.get(go.getN()));
        // 计算a
        go.setaPoint(go.getN() / (1 - Math.pow(Math.E, -1 * go.getbPoint() * go.get(go.getN()))));
        // 执行步骤五
        calculateStepFifth(go);
    }

    /**
     * 步骤五
     * @param go
     */
    private static void calculateStepFifth(GoelOkumotoBean go) {
        System.out.println("a value : " + go.getaPoint());
        System.out.println("b value : " + go.getbPoint());
        return;
    }

    /**
     * 计算f
     * @param go
     * @return
     */
    private static double calculateF(GoelOkumotoBean go) {
        double fValue = 0;
        fValue = (1 - go.getdValue() * go.getXm()) * Math.pow(Math.E, go.getXm());
        fValue += (go.getdValue() - 1) * go.getXm() - 1;
        return fValue;
    }

    public static void main(String[] args) throws IOException {
        GoelOkumotoBean go = GoelOkumotoModel.execute();
    }
}
