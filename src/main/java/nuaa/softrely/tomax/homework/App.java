package nuaa.softrely.tomax.homework;

import nuaa.softrely.tomax.homework.bean.GoelOkumotoBean;
import nuaa.softrely.tomax.homework.bean.JmModelDataBean;
import nuaa.softrely.tomax.homework.ui.EvaluateGraph;

import java.io.IOException;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/27 19:53
 */
public class App {
    public static void main(String[] args) throws IOException {
        JmModelDataBean model = JelinskiMorandaModel.execute();
//        GoelOkumotoBean model = GoelOkumotoModel.execute();
        EvaluateModel.uGraphEvaluate(model);
        EvaluateModel.yGraphEvaluate(model);
        EvaluateModel.calculateKSDistance(model);
        System.out.println("K-S");
        System.out.println(model.getuKS());
        System.out.println(model.getyKS());
        EvaluateGraph evaluateGraph = new EvaluateGraph("model evaluate", "model evaluate", model);
        evaluateGraph.pack();
        evaluateGraph.setVisible(true);

        GoelOkumotoBean goModel = GoelOkumotoModel.execute();
        System.out.println("plr : " + EvaluateModel.plrEvaluate(model, goModel));
    }
}
