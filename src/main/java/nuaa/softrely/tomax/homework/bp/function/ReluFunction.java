package nuaa.softrely.tomax.homework.bp.function;

/**
 * @Author: ToMax
 * @Description: relu
 * @Date: Created in 2018/12/10 23:07
 */
public class ReluFunction implements ActivationFunction{
    @Override
    public double activate(double x) {
        return Math.max(0, x);
    }

    @Override
    public Double derivative(Double x) {
        return x > 0 ? 1d : 0d;
    }
}
