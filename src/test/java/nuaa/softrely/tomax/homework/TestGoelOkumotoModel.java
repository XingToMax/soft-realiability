package nuaa.softrely.tomax.homework;

import nuaa.softrely.tomax.homework.bean.GoelOkumotoBean;
import org.junit.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/19 22:46
 */
public class TestGoelOkumotoModel {
    @Test
    public void test() {
        try {
            GoelOkumotoBean go = GoelOkumotoModel.execute();
            assertEquals(136d, go.getaPoint(), 10);
            assertEquals(0.0014, go.getbPoint(), 0.001);
        } catch (IOException e) {
            assertEquals(IOException.class, e.getClass());
        }
    }
}
