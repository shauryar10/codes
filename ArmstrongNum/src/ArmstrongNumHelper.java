import java.util.Scanner;

/**
 * Created by vanshika on 14/6/17.
 */
public class ArmstrongNumHelper {
    public int getZ1() {
        return z1;
    }

    public void setZ1(int z1) {
        this.z1 = z1;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    private int  z1,y=1,num=0,a,b,c,sum=0,check;
    private int  x=10 ,z;

    public int EnterNumber(){
        Scanner number = new Scanner(System.in);

        System.out.println("ENTER THE NUMBER YOU WANT TO CHECK IT IS ARMSTRONG OR NOT");
        this.num = number.nextInt();
        this.check = num;
        Scanner Z = new Scanner(System.in);

        System.out.println("ENTER THE NUMBER OF DIGIT IN NUMBER ");
        z = Z.nextInt();
        return num ;
    }
    public int ComputeSum() {
        while (z > 0) {
            try {
                this.y=1;
                this.z1=z-1;
                while (z1>0){
                    this.y=y*x;
                    this.z1--;
                }

                this.a = num / y;
                this.b = num % y;
                this.num=b;
                this.z--;
                this.sum = sum + (a * a *a);
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public int CheckNum(){
        try {
            if(sum==check){
                System.out.println("Number is armstrong number");
            }
            else{
                System.out.println("number not an armstrong number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
