/**
 * Created by vanshika on 14/6/17.
 */
public class ArmstrongNumMain {
    public static void main(String[] args) {
        try {
            ArmstrongNumHelper armstrongNumHelper = new ArmstrongNumHelper();
            armstrongNumHelper.EnterNumber();
            armstrongNumHelper.ComputeSum();
            armstrongNumHelper.CheckNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
