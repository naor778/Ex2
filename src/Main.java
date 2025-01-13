import EX2.ex2.Ex2Funcstion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static EX2.ex2.Ex2Funcstion.giveOpValue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String num1 = "=50";
        String ans77=Ex2.calculateFormula(num1)+"";
      List<String>okso= Ex2.NumbersOnlyByOrderV2(num1);
        System.out.println(okso.toString());
        System.out.println(ans77);
        boolean ans = Ex2.isAritmaticaction(num1);
        System.out.println(ans);
        boolean ans2 = Ex2.isAllCharsAreValid(num1);
        System.out.println(ans2);
        int a = Ex2.valueOfChar(num1);
        System.out.println(a);
        boolean ans1 = Ex2.isNumber(num1);
        System.out.println(ans1);
        boolean ans3 = Ex2.isForm(num1);
        System.out.println(ans3);
        String form = "6.0+5.0";
        List<Double> b = Ex2.giveOpValue(form);
        String Ran ="=5+5";
        if ("1023.456789()".contains(Ran.substring(1, Ran.length()))) ;
        Ran = Ran + "50";
        System.out.println(Ran);
        // String Numbers="6.0+5.0";
        //double asdas=0.3333;
        //char hi ='z';
        //int asada=Ex2.ValueOfLetters(hi);
        // System.out.println(asada);
        // double Numans=Ex2.calculateFormula(Numbers);
        // System.out.println(Numans);

        String s = "55+6+9*8*8+a0";
      List<String> letssee= Ex2.NumbersOnlyByOrderV2(s);
       System.out.println(letssee);
        List<String> letstry=Ex2.ans(s);

        System.out.println(letstry);
    }
    //chack if the y is 2 digit
//    public boolean isValid() {
  //      boolean ans = false;
    //    if ("ABCDEFGJIKLMNOPQRSTUVWXYZabcdefgjiklmnopqrstuvwxyz".contains(toString(getX(),getY()).substring(0, 0)) && "0123456789".contains(toString(getX(),getY()).substring(1, toString(getX(),getY()).length()))) {
      //      ans = true;
        //}
        //return ans;

    //}
}