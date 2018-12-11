package nuaa.softrely.tomax.homework.bp.function;

import nuaa.softrely.tomax.homework.bp.matrix.Matrix;
import nuaa.softrely.tomax.homework.bp.matrix.MatrixOps;
import nuaa.softrely.tomax.homework.bp.matrix.MatrixOpsNormal;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/12/8 21:37
 */
public class SigmoidFunction implements ActivationFunction{
    @Override
    public double activate(double x) {
        return 1 / (1 + Math.exp(x));
    }

    @Override
    public Double derivative(Double x) {
        return activate(x) * (1 - activate(x));
    }
}
