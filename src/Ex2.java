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

    /**
     * here i am chackeing that all the char are valid for the is number to be true
     * and this is the corract char i can use
     * @param num
     * @return
     */
    public static boolean isAllCharsAreValid(String num) {
        boolean ans = false;
        for (int i = 0; i < num.length(); i++) {
            if ("()0123456789+-*/.".contains(num.charAt(i) + "")) {
                ans = true;
            }else {return false;}

        }
        return ans;
    }

    /**
     * //chak if all the char are okfor the isNmber funcstion
     *      //add"." later
     *       here i am chacking the the aritmatc is ok like "++5" is not ok
     *       but "5+5" is ok
     * @param num
     * @return
     */
    public static boolean isAritmaticaction(String num) {
        for (int i = 0; i < num.length(); i = i + 1) {
            if ("+-*/".contains(num.charAt(i) + "")) {
                if (i == num.length() - 1 ) {
                    return false;
                }
                if (!"0123456789(".contains(num.charAt(i + 1) + "")) {
                    return false;}
                    if(i>=1 && num.charAt(i-1)=='('){
                            return false;
                        }


            }
        }
        return  true;

    }

    /**
     * chack if the String is indeed number or just normal String
     *
     * @param num
     * @return
     */
    public static boolean isText(String num){
        boolean ans=true;
        if(isNumber(num)==true || isForm(num)==true){
            ans=false;
        }
        return ans;
    }

    /**
     * chak first if the furmula is start whit = and the rest of the string is ineed in the corract format
     *  mean that he is true to is number fancstion
     * @param num
     * @return
     */
    public static boolean isForm(String num){
        boolean ans= false;
        if(num==null || num==""){
            return false;
        }
         String number=num.substring(1);

        if(isNumber(number)==true && num.startsWith("=")){
            ans=true;
        }

        return ans;
    }
    public static String[] PartofStrings (String num){
        int a =0;
        for (int i=0 ;i<num.length();i=i+1){
            if("-*/+".contains(num.charAt(i)+ "" )){
                a=a+1;
            }
        }
      String[] ans = new String[a];
        for (int j=0;j<num.length();j=j+1){
            if("(".contains(num.charAt(j) + "") && ){
              String z=num.substring('('+1,')'-1);
              if("()".contains(z)){

              }
            }

        }

    }
    public static Double computeForm(String form){
        double ans=0;


        return ans;
    }
    public static double eval(String subnum){
        double ans = 0;
        if("/*-+".contains(subnum)){
            for(int i =0;i<subnum.length();i=i+1){
                char a=subnum.charAt(i);
                if("+-*/".indexOf(a)!=-1||"+-*/".indexOf(a)!=0);{

                }

            }
        }
         return ans;
    }
}

