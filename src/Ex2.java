import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex2 {
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

        if (isNumber(number) == true && num.startsWith("=")) {
            ans = true;
        }

        return ans;
    }

    public static String[] PartofStrings(String num) {
        int a = 0;
        for (int i = 0; i < num.length(); i = i + 1) {
            if ("-*/+".contains(num.charAt(i) + "")) {
                a = a + 1;
            }
        }
        String[] ans = new String[a];
        for (int j = 0; j < num.length(); j = j + 1) {
            if ("(".contains(num.charAt(j) + "")) {
                String z = num.substring('(' + 1, ')' - 1);
                if ("()".contains(z)) {

                }
            }

        }
        return ans;
    }

    public static Double computeForm(String form) {
        double ans = 0;


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
        int ans = Ex2.numberOfOperators(Values);
        String[] Numbers = new String[ans + 1];
        String num = "";
        for (int i = 0; i < Values.size(); i = i + 1) {
            if (Values.get(i) == 0.0 && Character.isDigit(form.charAt(i))) {
                num = num + form.charAt(i) + "";
            } else if ("/*-+()".contains(form.charAt(i)+ "")&& i!=0 && num!="") {
                 Numbers[j] = num;
                 num = "";
                 j=j+1;
            }}
            if (!num.isEmpty()) {
                Numbers[j] = num;
                j=j+1;
                num="";
            }

            return Numbers;
        }

    /**
     * there is aproblame in the '-' char cuse he is doing the cuaculation wrong !!!!
     * @param form
     * @return
     */
    public static double calculateFormula(String form) {
        // 1. להפיק את הערכים של האופרטורים
        List<Double> operatorValues = giveOpValue(form);

        // 2. להפיק את המספרים
        String[] numbers = NumbersOnlyByOrder(form, operatorValues);
        List<String> NumbersNewList=new ArrayList<>(0);

        for(int i=0;i< numbers.length;i=i+1) {
            NumbersNewList.add(numbers[i]);
        }

        for (int i = 0; i < form.length(); i = i + 1) {
            if ("/*-+".contains(form.charAt(i) + "")) {

            }
        }
        int h = 0;
        int NumOfOp = Ex2.numberOfOperators(operatorValues);

        List<Double> operatorValuesOnly = giveOpValue(form);
        for (int i = operatorValuesOnly.size() - 1; i >= 0; i--) {
            if (operatorValuesOnly.get(i)==0.0||operatorValuesOnly.get(i)==-1.0){
                operatorValuesOnly.remove(i);
            }
        }
        // 3. חישוב לפי סדר העדיפות של האופרטורים
        while (NumOfOp > 0) {
            // לחפש את האופרטור עם הערך הגבוה ביותר
            double maxValueRaound = 0;
            double maxValue = -1.0;
            int maxIndex = -1;
            int maxValueOfFullChars = 0;
             int trackOfAntiOp=1;

            List<Double> operatorValuesOnlyIndexs = giveOpValue(form);
            for (int i = 0; i < operatorValuesOnly.size(); i++) {
                if (operatorValuesOnly.get(i) > maxValue) {
                    maxValue = operatorValuesOnly.get(i);
                    maxIndex = i;
                    maxValueRaound = Math.round(maxValue);
                }
            }



           List<Double> sub= operatorValues.subList(0,maxIndex);

            for (int i=0;i<sub.size();i=i+1){
                if(sub.get(i)==-1){
                    trackOfAntiOp=trackOfAntiOp;
                }
            }
            // לבצע את החישוב על פי האופרטור
            if(maxIndex>=0&&NumOfOp>0) {
                double num1 = Double.parseDouble(NumbersNewList.get(maxIndex ));
                double num2 = Double.parseDouble(NumbersNewList.get(maxIndex  + 1));
                double result = 0.0;
                double ansMaxValue = maxValue % 1;
                ansMaxValue = Math.round(ansMaxValue * 10.0) / 10.0;
                // אם האופרטור הוא * או /
                if (ansMaxValue == 0.7) {//chack if its maxValue is 0.7 its need to do the * operator
                    result = num1 * num2;
                } else if (ansMaxValue == 0.6) {
                    result = num1 / num2;
                }

                // אם האופרטור הוא + או -
                else if (ansMaxValue == 0.3) {
                    result = num1 + num2;
                } else if (ansMaxValue == 0.4) {
                    result = num1 - num2;
                }


                // עדכון המספרים במערך
                NumbersNewList.set(maxIndex , String.valueOf(result));
                NumbersNewList.remove(maxIndex + 1);
            }// להזיז את כל האיברים אחריו במערך numbers
            int track=0;
            if(trackOfAntiOp>0){
                track=trackOfAntiOp;
            }
            // עדכון operatorValues
            operatorValues.remove(maxIndex);
            // עדכון מספר האופרטורים
            NumOfOp--;
                trackOfAntiOp=0;
                operatorValuesOnly.remove(maxIndex);
        }
            // בשלב הזה נשאר רק מספר אחד במערך, זה התוצאה
            return Double.parseDouble(NumbersNewList.get(0));

    }
}