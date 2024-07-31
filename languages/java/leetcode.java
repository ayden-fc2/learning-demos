
class Solution {
    public static boolean isMatch(String s, String p) {
        //指针指向p
        int pPointer = 0;
        
        //遍历s
        for (int i = 0; i < s.length(); i++) {
            //已经指向末尾+1
            if(pPointer > p.length() - 1){
                return false;
            }
            //指向*
            if(p.charAt(pPointer) == '*'){
                //组成.*
                if(p.charAt(pPointer-1)=='.'){
                    if(pPointer + 1 > p.length() - 1){
                        return true;
                    }else{
                        // 后续可能还跟着.* x*b*之外的字符，比如 acc，这时要从后往前匹配
                    }
                }else{
                    if(p.charAt(pPointer-1)!=s.charAt(i)){
                        pPointer++;
                        i--;
                    }
                }
            }else{
                //未指向*
                if(p.charAt(pPointer) == '.' || p.charAt(pPointer) == s.charAt(i)){
                    pPointer++;
                }else{
                    pPointer++;
                    i--;
                }
            }
        }
        //遍历完成后p还有位数
        if(pPointer < p.length() - 1){
            // 可能跟随着*  .*.*... 这时要return true
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(isMatch("a","ab*")));
    }
}