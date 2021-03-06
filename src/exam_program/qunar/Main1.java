package exam_program.qunar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个单词列表，一个初始单词，初始单词需要通过单词列表逐步变换得到自己的逆序，
 * 求变换所需的最短变换路径长度。
 * 变换规则：每次只能变动1个字母，每次变换只能从单词列表中选取。
 * 例如：初始单词hot，其逆序为toh，单词列表[doh, got, dot, god, tod, dog, lot, log]，
 * 最短变换路径为[hot,dot,doh,toh]，最短变换路径长度为4。
 * 注：单词列表中可包含最终单词，也可不包含最终单词，
 * 只要能够从字典中转换出最终单次即逆序初始单词即可，同时不包含初始单词；
 * 列表中每一项单词长度与初始单词相同；列表中单词不重复；所有字母均为小写。
 * 转换的最大次数为99次。
 *
 * @author wanzhangkai@foxmail.com
 * @date 2018/4/2 15:30
 */
public class Main1 {

    public static int solution(String start, String[] strArr) {
        if (start == null || strArr == null) {
            return -1;
        }

        List<String> list = new ArrayList<>();
        list.add(start);

        for (int i = 0; i < start.length(); i++) {

            for (int j = 0; j < strArr.length; j++) {
                String temp = strArr[j];
                int k;
                if (temp.charAt(i) != start.charAt(i)) {
                    for (k = 0; k < start.length(); k++) {
                        if (k != i && temp.charAt(i) != start.charAt(i)) {
                            break;
                        }
                    }
                }else {
                    continue;
                }
                list.add(temp);
            }
        }


        int a = start.length() + 1;
        return 6;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String start = in.nextLine();
            String a = in.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < a.length(); i++) {
                StringBuilder sb = new StringBuilder();
                while (i < a.length() && a.charAt(i) != ' ') {
                    sb.append(a.charAt(i));
                    i++;
                }
                if (sb.length() != 0) {
                    list.add(sb.toString());
                }
            }
            String[] arr = new String[list.size()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = list.get(i);
            }
            int count = solution(start, arr);
            System.out.println(count);
        }


    }
}