package nuaa.softrely.tomax.homework.bean;

/**
 * @Author: ToMax
 * @Description:
 * @Date: Created in 2018/11/15 18:14
 */
public class GoelOkumotoBean extends Model {

    /**
     * 误差允许值D
     */
    private double dValue;

    private double aPoint;

    private double bPoint;

    /**
     * 计算d
     */
    public void initdValue() {
        double dSum = 0;
        for (Double d : trainDataset) {
            dSum += d;
        }
        dValue = dSum / (trainDataNum * trainDataset.get(trainDataNum));
    }

    private double xr;
    private double xm;
    private double xl;

    @Override
    public double calculateFunctionDistribution(double x) {
        return 0;
    }

    public double getdValue() {
        return dValue;
    }

    public void setdValue(double dValue) {
        this.dValue = dValue;
    }

    public double getaPoint() {
        return aPoint;
    }

    public void setaPoint(double aPoint) {
        this.aPoint = aPoint;
    }

    public double getbPoint() {
        return bPoint;
    }

    public void setbPoint(double bPoint) {
        this.bPoint = bPoint;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getXm() {
        return xm;
    }

    public void setXm(double xm) {
        this.xm = xm;
    }

    public double getXl() {
        return xl;
    }

    public void setXl(double xl) {
        this.xl = xl;
    }
}
