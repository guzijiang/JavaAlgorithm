package src.com.greed;

import java.util.ArrayList;

public class Test3 {
    //https://mp.weixin.qq.com/s/mT86T7FES-9Qj6rLfAltGA

    // 不同字符的最小子序列
    public static void main(String[] args) {
//        String text = "ecbacba"; //eacb
//        String text = "cdadabcc"; //adbc
        String text = "ebcee"; //bce

        String ret = "";
        ArrayList<String> selectedArr = new ArrayList<>();

        boolean exit = false;
        while (text.length() > 0 && !exit) { //text中还有字符没有选
            for (int i = 0; i < 26; i++) {
                String s1 = strContainAZChar(text, i);
                if (s1 == null || selectedArr.contains(s1)) {
                    if (i == 25) {
                        exit = true;
                    }
                    continue;
                }

                int subStrIdx = text.indexOf(s1);
                String subStr = text.substring(subStrIdx);
                //text包含该字符 && 子序列可包含text中所有字符
                if (!existDifferentChar(text, subStr, selectedArr)) {
                    ret += s1;
                    text = text.substring(subStrIdx + 1);;
                    selectedArr.add(s1);

                    break;
                }
            }
        }

        System.out.println("----------" + ret);
    }

    public static boolean existDifferentChar(String oriStr, String descStr, ArrayList<String> selectedArr) {
        boolean existDifferent = false;
        for (char c1 : oriStr.toCharArray()) {
            if (selectedArr.contains(String.valueOf(c1))) continue;

            if (!descStr.contains(String.valueOf(c1))) {
                existDifferent = true;
                break;
            }
        }
        return existDifferent;
    }

    public static String strContainAZChar(String oriStr, int idx) {
        char c1 = (char) ((byte)'a' + idx);
        String s1 = String.valueOf(c1);
        if (oriStr.contains(s1)) {
            return s1;
        } else {
            return null;
        }
    }
}
