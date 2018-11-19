package nuaa.softrely.tomax.homework.bean;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/15 19:39
 */
public interface DataReader {
    /**
     * 读取数据
     * @param path
     */
    void readData(String path) throws IOException;
}
