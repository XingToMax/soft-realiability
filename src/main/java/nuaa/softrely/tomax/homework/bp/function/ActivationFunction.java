package nuaa.softrely.tomax.homework.bp.function;

import nuaa.softrely.tomax.homework.bp.matrix.Matrix;

/**
 * @Author: ToMax
 * @Description: 激活函数
 * @Date: Created in 2018/12/8 14:40
 */
public interface ActivationFunction extends Derivable<Double, Double>{
    /**
     * 激活
     * @param x input value
     * @return output value
     */
    double activate(double x);
}
