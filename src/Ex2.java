public class Ex2 {
    // chack if the string is in the ok formet
    public static boolean isNumber(String num) {
        boolean ans = true;
        if (!isAllCharsAreValid(num) == true || !isAritmaticaction(num) == true) {
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

    public static boolean isAllCharsAreValid(String num) {
        boolean ans = false;
        for (int i = 0; i < num.length(); i++) {
            if ("()0123456789+-*/.".contains(num.charAt(i) + "")) {
                ans = true;
            }
        }
        return ans;
    }
//chak if all the char are okfor the isNmber funcstion
     //add"." later
    public static boolean isAritmaticaction(String num) {
        for (int i = 0; i < num.length(); i = i + 1) {
            if ("+-*/".contains(num.charAt(i) + "")) {
                if (i == num.length() - 1) {
                    return false;
                }
                if (!"0123456789()".contains(num.charAt(i + 1) + "")) {
                    return false;
                }
            }
        }
        return  true;

    }
}

