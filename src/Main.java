import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Lav GCD table: GCD(a, b)");
        System.out.println("Indtast a og b delt med mellemrum");
        //input, men a og b bliver til r_2 og r_1
        int in1 = Math.abs(input.nextInt());
        int in2 = Math.abs(input.nextInt());
        int a;
        int b;

        //sørger for at a er større end b
        if(in1>in2){
            a = in1;
            b = in2;
        }
        else{
            a = in2;
            b = in1;
        }
        //setting start values
        int i = -1;

        int s_2 = 1;
        int s_1 = 0;
        int s;

        int t_2 = 0;
        int t_1 = 1;
        int t;

        int q;

        int r_2 = a;
        int r_1 = b;
        int r = r_2 % r_1;

        //printer første 3 linjer
        System.out.format("%4s|%6s|%6s|%6s|%6s|\n", "i", "s  ", "t  ", "q  ", "r  ");
        System.out.println("_________________________________");
        System.out.format("%4d|%6d|%6d|%6s|%6d|\n", i, s_2, t_2, "  -  ", r_2);
        System.out.println("_________________________________");
        i++;
        System.out.format("%4d|%6d|%6d|%6s|%6d|\n", i, s_1, t_1, "  -  ", r_1);
        System.out.println("_________________________________");
        i++;


        while(r != 0){
            //calc this round
            r = r_2 % r_1;
            q = (r_2 - r) / r_1;
            s = s_2 - (q * s_1);
            t = t_2 - (q * t_1);

            //print this round
            System.out.format("%4d|%6d|%6d|%6d|%6d|\n", i, s, t, q, r); //format til outputtet - %6d erstattes med int-inputs i den rækkefølge de indsættes her i,s,t,q,r
            System.out.println("________________________________");

            //prep for next round
            s_2 = s_1;
            s_1 = s;
            t_2 = t_1;
            t_1 = t;
            r_2 = r_1;
            r_1 = r;

            i++;
        }
        System.out.println("GCD("+a+","+b+") = " + r_2);//print gcd (normalt r_1, men fordi "prep" kører før loop sluttes bliver r_2 til r_1... derfor print r_2.

    }
}
