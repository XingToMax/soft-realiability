package nuaa.softrely.tomax.homework.bp;

import nuaa.softrely.tomax.homework.bp.function.NormalLossFunction;
import nuaa.softrely.tomax.homework.bp.function.ReluFunction;
import nuaa.softrely.tomax.homework.bp.function.UselessActivationFunction;
import nuaa.softrely.tomax.homework.bp.matrix.Matrix;
import nuaa.softrely.tomax.homework.bp.matrix.MatrixOps;
import nuaa.softrely.tomax.homework.bp.matrix.MatrixOpsNormal;
import nuaa.softrely.tomax.homework.exception.MatrixSizeException;
import nuaa.softrely.tomax.homework.exception.NetworkException;

import java.util.Random;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/12/8 10:28
 */
public class Demo {

    public static void main(String[] args) throws MatrixSizeException, NetworkException {
        Network network = new Network()
                .addLayer(
                        new Layer("layer1", 1, 3)
                )
                .addLayer(
                        new Layer("layer2", 3, 4)
                )
                .addLayer(
                        new Layer("layer3", 4, 3)
                )
                .addLayer(
                        new Layer("layer4", 3, 1)
                                .setActivation(new UselessActivationFunction())
                )
                .setLossThreshold(0.00001d)
                .setMaxGeneration(100000)
                .setLearningRate(0.0001);

        Matrix input = new Matrix(1, 1);
        Matrix output = new Matrix(1, 1);

        Random intRand = new Random();
        for (int i = 0; i < 1000; i++) {
            int num = intRand.nextInt(20) - 10;
            input.set(0, 0, num);
            output.set(0, 0, num * num / 400d);
            System.out.println(network.execute(input, output).get(0, 0) * 400);
            System.out.println(num * num);
        }
        System.out.println("test learn");
        for (int i = -100; i <= 100; i++) {
            input.set(0, 0, i);
            System.out.println(network.execute(input).get(0, 0) * 400);
            System.out.println(i * i);
        }

        System.out.println("test");
        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            double value = random.nextInt(200);
            System.out.println("input : " + value);
            input.set(0, 0, value);
            Matrix result = network.execute(input);
            System.out.println("target : " + value * value);
            System.out.println(result.get(0, 0) * 400);
            System.out.println("error : " + Math.abs(value * value - result.get(0, 0) * 400));
        }
    }
}
