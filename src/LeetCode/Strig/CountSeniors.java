package LeetCode.Strig;

import java.util.List;

public class CountSeniors {
    public int countSeniors(String[] details) {
        int preNum = 0;
        for (int i = 0; i < details.length; i++) {
            if (Integer.valueOf(details[i].substring(11, 13)) > 60) {
                preNum++;
            }
        }
        return preNum;
    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(10);
//        }
        System.out.println("sap_location_ware".contains("sap_location_ware_11"));
//        addList(list);
//        System.out.println(list);
//        CountSeniors countSeniors = new CountSeniors();
//        String[] details = {"5612624052M0130", "5378802576M6424", "5447619845F0171", "294170117409078"};
//        System.out.println(countSeniors.countSeniors(details));
    }

    public static void addList(List<Integer> list) {
        list.add(13);
    }
}
