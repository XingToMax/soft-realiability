package nuaa.softrely.tomax.homework;

import nuaa.softrely.tomax.homework.bean.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/27 20:20
 */
public class EvaluateModel {

    /**
     * U-图
     * @param model
     */
    public static void uGraphEvaluate(Model model) {
        List<Double> xAxisValueList = new ArrayList<>();

        for (int i = 0; i < model.getTestDataset().size(); i++) {
            xAxisValueList.add(model.calculateFunctionDistribution(model.getTestDataset().get(i)));
        }

        Collections.sort(xAxisValueList);
        for (Double in : xAxisValueList) {
            if (!model.getuValueList().contains(in)) {
                model.getuValueList().add(in);
            }
        }
        model.getuValueList().forEach(System.out::println);
    }

    /**
     * 计算Y-图
     * 此处i取0，n取U-图坐标个数
     * @param model
     */
    public static void yGraphEvaluate(Model model) {
        List<Double> xAxisValueList = new ArrayList<>();
        List<Double> yAxisValueList = new ArrayList<>();
        for (int i = 0; i < model.getuValueList().size(); i++) {
            xAxisValueList.add(-Math.log(1 - model.getuValueList().get(i)));
        }
        for (int i = 0; i < model.getuValueList().size() - 1; i++) {
            double sumTop = 0;
            double sumBase = 0;

            for (int j = 0; j <= i; j++) {
                sumTop += xAxisValueList.get(j);
            }

            for (int j = 0; j < model.getuValueList().size() - 1; j++) {
                sumBase += xAxisValueList.get(j);
            }
            yAxisValueList.add(sumTop / sumBase);
        }

        Collections.sort(yAxisValueList);
        for (Double in : yAxisValueList) {
            if (!model.getyValueList().contains(in)) {
                model.getyValueList().add(in);
            }
        }
    }
}
