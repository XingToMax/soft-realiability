package nuaa.softrely.tomax.homework;

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
        EvaluateModel.uGraphEvaluate(model);
        EvaluateModel.yGraphEvaluate(model);
        EvaluateGraph evaluateGraph = new EvaluateGraph("model evaluate", "U-Graph", model);
        evaluateGraph.pack();
        evaluateGraph.setVisible(true);
    }
}
