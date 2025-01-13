package EX2.ex2;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static EX2.ex2.Ex2Utils.EMPTY_CELL;
import static EX2.ex2.Ex2Utils.ERR;

public class Ex2Funcstion {
    // chack if the string is in the ok formet
    public static boolean isNumber(String num) {
        boolean ans = true;
        if ((!isAllCharsAreValid(num) == true || !isAritmaticaction(num) == true)) {
            ans = false;
        }
        if (valueOfChar(num) < 0 || valueOfChar(num) > 0) {
            ans = false;
            return false;
        }
        return ans;
    }

    public static boolean isOnlyNumber(String c) {
        boolean ans = false;
        try {
            Double.parseDouble(c);
            ans = true;
        } catch (NumberFormatException e) {
            ans = false;
        }
        return ans;
    }


    //chack if string of ')' ans '(' is ok in the ammout
    public static int valueOfChar(String num) {
        int ans = 0;
        if (num.contains("()")) {
            ans = -1;
            return ans;
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '(') {
                ans = ans + 1;

            } else if (num.charAt(i) == ')') {
                ans = ans - 1;
            }
            if (ans < 0) {
                return ans;
            }
        }
        return ans;
    }

    /**
     * here i am chackeing that all the char are valid for the is number to be true
     * and this is the corract char i can use
     * need to fix the null in the test
     *
     * @param num
     * @return
     */
    public static boolean isAllCharsAreValid(String num) {
        boolean ans = false;
        if (num.length() == 0 | num == null) {
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            if ("()0123456789+-*/.".contains(num.charAt(i) + "")) {
                ans = true;
            } else {
                return false;
            }

        }
        return ans;
    }

    /**
     * //chak if all the char are okfor the isNmber funcstion
     * //add"." later
     * here i am chacking the the aritmatc is ok like "++5" is not ok
     * but "5+5" is ok
     *
     * @param num
     * @return
     */
    public static boolean isAritmaticaction(String num) {
        if (num.length() == 0 | num == null) {
            return false;
        }
        for (int i = 0; i < num.length(); i = i + 1) {
            if ("+-*/.".contains(num.charAt(i) + "")) {
                if (i == num.length() - 1) {
                    return false;
                }
                if (!"0123456789(".contains(num.charAt(i + 1) + "")) {
                    return false;
                }
                if (i >= 1 && num.charAt(i - 1) == '(') {
                    return false;
                }


            }
        }
        return true;

    }

    /**
     * chack if the String is indeed number or just normal String
     *
     * @param num
     * @return
     */
    public static boolean isText(String num) {
        boolean ans = true;
        if (isNumber(num) == true || isForm(num) == true) {
            ans = false;
        }
        return ans;
    }

    /**
     * chak first if the furmula is start whit = and the rest of the string is ineed in the corract format
     * mean that he is true to is number fancstion
     *
     * @param num
     * @return
     */
    public static boolean isForm(String num) {
        boolean ans = false;
        if (num == null || num == "") {
            return false;
        }
        String number = num.substring(1);

        if ((isNumber(number) == true && num.startsWith("=")) || num.startsWith("=")) {
            ans = true;
        }
        if ("=".contains(number) || Ex2Funcstion.isAritmaticaction(number) == false || Ex2Funcstion.isNumber(number) == false || Ex2Funcstion.isText(number) == true) {
            ans = false;
        }

        return ans;
    }

    public static double eval(String subnum) {
        double ans = 0;
        if ("/*-+".contains(subnum)) {
            for (int i = 0; i < subnum.length(); i = i + 1) {
                char a = subnum.charAt(i);
                if ("+-*/".indexOf(a) != -1 || "+-*/".indexOf(a) != 0) ;
                {

                }

            }
        }
        return ans;
    }

    public static List<Double> giveOpValue(String op) {
        double first = 0.0;
        List<Double> values = new ArrayList<>(0);
        for (int i = 0; i < op.length(); i = i + 1) {
            if (op.charAt(i) == '(') {
                first = first + 2;
                values.add(-1.0);
            }
            if (op.charAt(i) == ')') {
                first = first - 2;
                values.add(-1.0);
            }
            if (op.charAt(i) == '-') {
                values.add(0.4 + first);
            }
            if (op.charAt(i) == '+') {
                values.add(0.3 + first);
            }
            if (op.charAt(i) == '/') {
                values.add(0.6 + first);
            } else if (op.charAt(i) == '*') {
                values.add(0.7 + first);

            }
            if (!"/*-+)(=".contains(op.charAt(i) + "")) {
                values.add(0.0);
            }
        }
        return values;
    }

    public static int numberOfOperators(List<Double> Values) {
        int ans = 0;
        for (int i = 0; i < Values.size(); i = i + 1) {
            if (Values.get(i) > 0.0) {
                ans = ans + 1;
            }
        }
        return ans;
    }


    public static String[] NumbersOnlyByOrder(String form, List<Double> Values) {
        int j = 0;
        int ans = Ex2Funcstion.numberOfOperators(Values);
        String[] Numbers = new String[ans + 1];
        String num = "";
        for (int i = 0; i < Values.size(); i = i + 1) {
            if (Values.get(i) == 0.0) {
                num = num + form.charAt(i) + "";
            } else if ("/*-+()".contains(form.charAt(i) + "") && i != 0 && num != "") {
                Numbers[j] = num;
                num = "";
                j = j + 1;
            }
        }
        if (!num.isEmpty()) {
            Numbers[j] = num;
            j = j + 1;
            num = "";
        }

        return Numbers;
    }

    /**
     * there is aproblame in the '-' char cuse he is doing the cuaculation wrong !!!!
     *
     * @param form
     * @return
     */
    public static String calculateFormula(String form) {
        if (form.startsWith("=")){
            form=form.substring(1);
        }
        List<Double> operatorValues = giveOpValue(form);

        String[] numbers = NumbersOnlyByOrder(form, operatorValues);
        List<String> NumbersNewList = new ArrayList<>(0);

        for (int i = 0; i < numbers.length; i = i + 1) {
            NumbersNewList.add(numbers[i]);
        }

        for (int i = 0; i < form.length(); i = i + 1) {
            if ("/*-+".contains(form.charAt(i) + "")) {

            }
        }
        int h = 0;
        int NumOfOp = Ex2Funcstion.numberOfOperators(operatorValues);

        List<Double> operatorValuesOnly = giveOpValue(form);
        for (int i = operatorValuesOnly.size() - 1; i >= 0; i--) {
            if (operatorValuesOnly.get(i) == 0.0 || operatorValuesOnly.get(i) == -1.0) {
                operatorValuesOnly.remove(i);
            }
        }
        while (NumOfOp > 0) {
            double maxValueRaound = 0;
            double maxValue = -1.0;
            int maxIndex = -1;
            int maxValueOfFullChars = 0;
            int trackOfAntiOp = 1;

            List<Double> operatorValuesOnlyIndexs = giveOpValue(form);
            for (int i = 0; i < operatorValuesOnly.size(); i++) {
                if (operatorValuesOnly.get(i) > maxValue) {
                    maxValue = operatorValuesOnly.get(i);
                    maxIndex = i;
                    maxValueRaound = Math.round(maxValue);
                }
            }


            List<Double> sub = operatorValues.subList(0, maxIndex);

            for (int i = 0; i < sub.size(); i = i + 1) {
                if (sub.get(i) == -1) {
                    trackOfAntiOp = trackOfAntiOp;
                }
            }
            if (maxIndex >= 0 && NumOfOp > 0) {
                double num1 = Double.parseDouble(NumbersNewList.get(maxIndex));
                double num2 = Double.parseDouble(NumbersNewList.get(maxIndex + 1));
                double result = 0.0;
                double ansMaxValue = maxValue % 1;
                ansMaxValue = Math.round(ansMaxValue * 10.0) / 10.0;
                if (ansMaxValue == 0.7) {//chack if its maxValue is 0.7 its need to do the * operator
                    result = num1 * num2;
                } else if (ansMaxValue == 0.6) {
                    result = num1 / num2;
                } else if (ansMaxValue == 0.3) {
                    result = num1 + num2;
                } else if (ansMaxValue == 0.4) {
                    result = num1 - num2;
                }


                NumbersNewList.set(maxIndex, String.valueOf(result));
                NumbersNewList.remove(maxIndex + 1);
            }
            int track = 0;
            if (trackOfAntiOp > 0) {
                track = trackOfAntiOp;
            }

            operatorValues.remove(maxIndex);

            NumOfOp--;
            trackOfAntiOp = 0;
            operatorValuesOnly.remove(maxIndex);
        }
        try {
            String ans=Double.parseDouble(NumbersNewList.get(0))+"";
            return ans;
        }catch (NumberFormatException e) {
            String ans = "";
            if (ans == "" || ans == null) {
                ans = Ex2Utils.EMPTY_CELL;
            }
        }
       String ans=Ex2Utils.ERR_FORM;
return ans;
    }

    public static int ValueOfLetters(char c) {
        int castingToInt = 0;
        if (Character.isLetter(c)) {
            castingToInt = c;
            if (castingToInt < 91 && castingToInt > 64) {
                castingToInt = castingToInt - 65;
            } else if (castingToInt < 123 && castingToInt > 96) {
                castingToInt = castingToInt - 97;
            }
        }

        return castingToInt;

    }

    public static char intToLetters(int x) {
        if (x >= 0 && x <= 25) {
            return (char) ('A' + x);
        } else {
            throw new IllegalArgumentException("the Number must be between 0-25");
        }
    }

    /**
     * Esy just used what i allready worked hard on in cuaculteform funcstion
     *
     * @param s
     * @return
     */
    public static List<String> BringListOfAllNumbersAndCord(String s) {
        List<Double> operatorValues = giveOpValue(s);

        String[] numbers = NumbersOnlyByOrder(s, operatorValues);
        List<String> NumbersNewList = new ArrayList<>(Arrays.asList(numbers)); // המרה למערך List

        return NumbersNewList;
    }

    public static List<String> BringFullList(String s) {
        List<Double> operatorValues = Ex2Funcstion.giveOpValue(s);

        String[] numbers = Ex2Funcstion.NumbersOnlyByOrder(s, operatorValues);
        List<String> NumbersNewList = new ArrayList<>(Arrays.asList(numbers));

        return NumbersNewList;
    }

    public static List<String> NumbersOnlyByOrderV2(String form) {
        if (form.startsWith("=")){
            form=form.substring(1);
        }
        List<Double> Values =  giveOpValue(form);
        List<String> Numbers = new ArrayList<>();
        String num = "";
        for (int i = 0; i < Values.size(); i = i + 1) {
            if (Values.get(i) == 0.0) {
                num = num + form.charAt(i) + "";
            } else if ("/*-+()".contains(form.charAt(i) + "") && i != 0 && num != "") {
                Numbers.add(num);
                Numbers.add(form.charAt(i) + "");
                num = "";
            }
        }Numbers.add(num);
        return Numbers;
    }

    public static boolean IsItCellCords(String furmula) {
        boolean ans = true;
        if (furmula.length() < 2) {
            return false;
        }
        char Letter = furmula.charAt(0);
        String DigitOfCell = furmula.substring(1);
        if (DigitOfCell.length() > 2) {
            return false;
        }
        if (!Character.isLetter(Letter)) {
            return false;
        }
        try {
            int row = Integer.parseInt(DigitOfCell);
            if( row >= 0 && row <= 99){
                ans=true;
            }} catch (NumberFormatException e) {
            return false;}
        return ans;
    }

}

