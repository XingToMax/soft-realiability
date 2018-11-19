package nuaa.softrely.tomax.homework;

import nuaa.softrely.tomax.homework.bean.JmModelDataBean;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/19 22:52
 */
public class TestJelinskiMorandaModel {
    @Test
    public void test() {
        try {
            JmModelDataBean jm = JelinskiMorandaModel.execute();
            assertEquals(136d, jm.getnPointEvaluate(), 0.5);
            assertEquals(0.0015, jm.getFaiPointEvaluate(), 0.0001);
        } catch (IOException e) {
            assertEquals(IOException.class, e.getClass());
        }
    }
}
