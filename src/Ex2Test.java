import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex2Test {

    @org.junit.jupiter.api.Test
    void isNumber() {
        String[] try1 = {"50", "(50)", "50+80", "(3+4)*3+2*1"};
        for (int i = 0; i < try1.length; i = i + 1) {
            assertTrue(Ex2.isNumber(try1[i]));
        }
        String need = "75++-";
        assertFalse(Ex2.isNumber(need));
        String[] needToFail = {"++62))", ")50", "75++-", "-*150", "2*-3", "85*4+3bla","(50+)","((50)+)",""};
        for (int j = 0; j < needToFail.length; j = j + 1) {
            assertFalse(Ex2.isNumber(needToFail[j]));
        }
    }

    @org.junit.jupiter.api.Test
    void valueOfChar() {
        String[] isOk = {"((5))", "(8)", "(((7)))"};
        for (int i = 0; i < isOk.length; i = i + 1) {
            assertEquals(Ex2.valueOfChar(isOk[i]), 0);
        }
        String[] isNotOk = {")(", "()", "((())", "())"};
        for (int j = 0; j < isNotOk.length; j = j + 1) {

            assertEquals(Ex2.valueOfChar(isNotOk[j]), -1);
        }
    }

    @org.junit.jupiter.api.Test
    void isAllCharsAreValid() {
        String[] isOk = {"123", "4564", "1234567890", "+-*/"};
        for (int i = 0; i < isOk.length; i = i + 1) {
            assertTrue(Ex2.isAllCharsAreValid(isOk[i]));
        }
        String[] isNotOk = {"asd", "s", "asda", "asd", "bla"};
        for (int j = 0; j < isNotOk.length; j = j + 1) {
            assertFalse(Ex2.isAllCharsAreValid(isNotOk[j]));
        }
    }

    @org.junit.jupiter.api.Test
    void isAritmaticaction() {
        String[] isOk = {"2+2", "5*5", "(54)", "85*4+3", "9*5+2*6"};
        for (int i = 0; i < isOk.length; i = i + 1) {
            assertTrue(Ex2.isAritmaticaction(isOk[i]));
        }
        String[] notOk = {"++", "+-5", "-(++5)", "*/+", "123-9*5*"};
        for (int j = 0; j < notOk.length; j = j + 1) {
            assertFalse(Ex2.isAritmaticaction(notOk[j]));
        }
    }

    @Test
    void isText() {
        String[] isOk = {"2+2hello", "5*5hi", "(54)ok", "85*4+3bla", "9*5+2*6+", "hi my name is naor"};
        for (int i = 0; i < isOk.length; i = i + 1) {
            assertTrue(Ex2.isText(isOk[i]));
            String[] isNotOk = {"50", "(50)", "50+80", "(3+4)*3+2*1",};
            for (int j = 0; j < isNotOk.length; j = j + 1) {
                assertFalse(Ex2.isText(isNotOk[j]));
            }
        }
    }

    @Test
    void isForm() {
        String[] isOk = {"=50", "=(50)", "=50+80", "=(3+4)*3+2*1","=((5+5)*(5*5)+50)","=(0.2)"};
        for (int i = 0; i < isOk.length; i = i + 1) {
            assertTrue(Ex2.isForm(isOk[i]));
        }
        String[] isNotOk = {"=50=", "=(50+)", "50+80jhk", "(3+4)*3+2*1","=0..2","=asda"};
        for (int j = 0; j < isNotOk.length; j = j + 1) {
            assertFalse(Ex2.isForm(isNotOk[j]));
        }
    }
    @Test
    void calculateFormula(){
        String[] try1 = {"2*16-8/4","(6+3)*2","6+6","2+2","2-2","2-0","8/4","2*6"};
        double[] ansOfTry1={30.0,18.0,12.0,4.0,0.0,2.0,2.0,12.0};
        for(int i=0;i< try1.length;i=i+1) {
            assertEquals(ansOfTry1[i]+"", Ex2.calculateFormula(try1[i])+"");
        }
    }

    @Test
    void valueOfLetters() {
        char[] testValueOfLetter={'A','a','z','Z','b','C'};
        int[] RealAns={0,0,25,25,1,2};
        int c=0;
        for (int i=0;i<testValueOfLetter.length;i=i+1){
            char letter = testValueOfLetter[i];
            int ans = Ex2.ValueOfLetters(letter);
            int okAns=RealAns[i];
            assertEquals(ans,okAns);

        }
    }
}