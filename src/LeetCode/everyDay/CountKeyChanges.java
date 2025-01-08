package LeetCode.everyDay;

public class CountKeyChanges {
    public static void main(String[] args) {
        CountKeyChanges countKeyChanges = new CountKeyChanges();
        System.out.println(countKeyChanges.countKeyChanges("aAbBcC"));
    }
    public int countKeyChanges(String s) {
        int res = 0;
        String lowerCase = s.toLowerCase();
        for (int i = 1; i < lowerCase.length(); i++) {
            if (lowerCase.charAt(i) != lowerCase.charAt(i - 1)) {
                res++;
            }
        }
        return res == 0 ? 0 : res - 1;
    }

    public int countKeyChanges2(String s) {
        int ans=0;
        for(int i=1;i<s.length();i++){
            char pre=s.charAt(i-1),cur=s.charAt(i);
            if((cur!=pre)&&((cur^pre)!=32)){
                ans++;
            }
        }
        return ans;
    }






}
