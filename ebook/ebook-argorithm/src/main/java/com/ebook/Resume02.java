package com.ebook;

import java.time.Duration;

/**
 * @Description:
 * @Authr: yaunde
 * @Date: 2019-10-27 21:24
 */
public class Resume02 {
    public static void main(String[] args) {
        String abc = new String("abc");
        String xyz = "abc";
        String tmp = "abc";
        String tmp2 = new String("abc");
        System.out.println(abc == xyz);
        System.out.println(xyz == tmp);
        System.out.println(xyz == tmp2);
        System.out.println(abc.equals(xyz));
        StringBuilder sb = new StringBuilder("abbbbsdfgb");
        System.out.println(sb.indexOf("z"));
        System.out.println(sb.delete(0,sb.indexOf("b") + 1));

        int i = "aabaab!bb".codePointAt(0);
        System.out.println(i +"  000");


        System.out.println("-------------------------");
        System.out.println(lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));


        System.out.println("-----------------------");
        System.out.println(longestPalindrome("abcabcbb"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj"));

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        int maxLength = 0;

        StringBuilder sb = new StringBuilder();

        for (char aChar : chars) {
            int index = sb.indexOf(String.valueOf(aChar));
            if (index == -1) {
                sb.append(aChar);
                if (sb.length() > maxLength) {
                    maxLength = sb.length();
                }
            } else {
                sb.delete(0, index + 1);
                sb.append(aChar);
            }
        }

        return maxLength;

    }


    public static String longestPalindrome(String s) {

        long start = System.currentTimeMillis();

        String maxString = "";
        //int maxLength = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        StringBuilder reverseTemp = new StringBuilder();


        /*char[] chars = s.toCharArray();
        for (char aChar : chars) {
            sb.append(aChar);
            for(int j=0; j< sb.length(); j++){
                String substring = sb.substring(j, sb.length());
                if(maxString.length() < substring.length()){
                    temp = temp.delete(0, temp.length())
                            .append(substring);
                    reverseTemp = reverseTemp.delete(0, reverseTemp.length())
                            .append(substring).reverse();
                    if(temp.toString().equals(reverseTemp.toString())){
                        maxString = temp.toString();
                    }
                }


            }
        }*/

        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            for(int j=0; j< sb.length(); j++){
                String substring = sb.substring(j, sb.length());
                if(maxString.length() < substring.length()){
                    temp = temp.delete(0, temp.length())
                            .append(substring);
                    reverseTemp = reverseTemp.delete(0, reverseTemp.length())
                            .append(substring).reverse();
                    if(temp.toString().equals(reverseTemp.toString())){
                        maxString = temp.toString();
                    }
                }


            }
        }

        System.out.println("耗时："+(System.currentTimeMillis()-start));

        return maxString;
    }
}

