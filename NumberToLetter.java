package cn.leet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  NumberToLetter {
    //定义一个数组存放手机键盘数字对应的字母
    private final String[] digit_Map = new String[]{
            " ",     " ",     "abc",  //0 1 2
            "def",  "ghi",  "jkl",  //3 4 5
            "mno",  "pqrs", "tuv",  //6 7 8
            "wxyz"                  //9
    };
    public List<String> letterCombinations(String digits) {
        //如果数字串为空则直接返回
        if(digits==null || digits.length()==0) {
            return new ArrayList<String>();
        }
       /*1、遍历数字串，并先取第一个数字对应的字母列表，add进数组里
         2、得到每个数字对应的字母列表，add进数组里
         3、取第二个数字对应得字母列表，并且每次先从list里面取出一个字母（remove），再组合起来add进数组里
       * */
        List<String> results = new ArrayList<>();
        results.add("");
        for(int i=0;i<digits.length();i++) {
            String letters = digit_Map[digits.charAt(i)-'0'];
            int size = results.size();
            for(int j=0;j<size;j++) {
                String tmp = results.remove(0);
                for(int k=0;k<letters.length();k++) {
                    results.add(tmp+letters.charAt(k));
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.print("输入数字");
        Scanner scan = new Scanner(System.in);
        String read = scan.nextLine();
        System.out.println("您输入的数是："+read);
        NumberToLetter numberToLetter = new NumberToLetter();
        List<String> list = numberToLetter.letterCombinations(read);
        System.out.println(list);
    }

}
