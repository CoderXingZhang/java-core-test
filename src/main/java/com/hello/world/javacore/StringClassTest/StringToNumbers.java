package com.hello.world.javacore.StringClassTest;

/**
 * @author xing
 */
public class StringToNumbers {
    public static void main(String[] args) throws Exception {

        //字符转化为数字
        String test = "123143";
        System.out.println(stoNum(test));
        char s = '1';
        System.out.println(Character.getNumericValue('-'));
        System.out.println((int) s);
    }

    private static int stoNum(String key) throws Exception {
        int num = 0, j = 0;
        if (key.length() == 0) {
            return 0;
        }
        for (int k = key.length() - 1; k >= 0; k--) {
            if (Character.getNumericValue(key.charAt(k)) > 10) {
                throw new Exception();
            }
            double top = Math.pow(10, j);
            num = num + (Character.getNumericValue(key.charAt(k))) * (int) top;
            j++;
        }

        if (key.startsWith("-")){
            return -num;
        }
        return num;
    }
}
