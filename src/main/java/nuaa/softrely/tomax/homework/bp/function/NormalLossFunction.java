package nuaa.softrely.tomax.homework.bp.function;

import nuaa.softrely.tomax.homework.bp.matrix.Matrix;

/**
 * @Author: ToMax
 * @Description: loss = 1/2 *segma(y - y_)^2
 * @Date: Created in 2018/12/8 20:18
 */
public class NormalLossFunction implements LossFunction {
    @Override
    public double loss(Matrix result, Matrix target) {
        double value = 0;
        for (int i = 0; i < result.getRow(); i++) {
            value += (result.get(i, 0) - target.get(i, 0));
        }
        value *= value;
        value /= 2;
        return value;
    }

    @Override
    public Double derivative(Double x) {
        return 0D;
    }

    @Override
    public double derivativeValue(double x, double target) {
        return target - x;
    }
}
