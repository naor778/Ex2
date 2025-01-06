import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String num1 = "=50=";
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
        String form = "8/0";
        double realans = Ex2.calculateFormula(form);
        System.out.println(realans);
        List<Double> b = Ex2.giveOpValue(form);
        String Numbers="(5+5)*88+5+6+7";
        double asdas=0.3333;
        char hi ='z';
         int asada=Ex2.ValueOfLetters(hi);
        System.out.println(asada);
    }


}
