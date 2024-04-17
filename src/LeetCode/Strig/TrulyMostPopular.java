package LeetCode.Strig;

import java.util.*;

public class TrulyMostPopular {
    public static void main(String[] args) {
        String names[] = {"John(15)", "Jon(12)", "Chris(13)", "Kris(4)", "Christopher(19)"};
        String synoyms[] = {"(Jon,John)", "(John,Johnny)", "(Chris,Kris)", "(Chris,Christopher)"};
        TrulyMostPopular trulyMostPopular = new TrulyMostPopular();
        trulyMostPopular.trulyMostPopular(names, synoyms);
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        if (names.length == 0 || synonyms.length == 0) return names;
        List<List<String>> nameList = new ArrayList<>();
        for (String sy : synonyms) {
            if (nameList.size() > 0) {
                boolean flag = false;
                String[] split = sy.substring(1, sy.length() - 1).split(",");
                for (List<String> name : nameList) {
                    for (String sName : split) {
                        if (name.contains(sName)) {
                            List<String> list = Arrays.asList(split);
                            name.addAll(new ArrayList<>(list));
                            flag = true;
                            break;
                        }
                    }
                }
                if (!flag) {
                    List<String> list = Arrays.asList(split);
                    nameList.add(new ArrayList<>(list));
                }
            } else {
                List<String> list = Arrays.asList(sy.substring(1, sy.length() - 1).split(","));
                nameList.add(new ArrayList<>(list));
            }
        }
        for (List<String> name : nameList) {
            Collections.sort(name);
        }
        HashMap<String, Integer> nameNum = new HashMap<>();
        for (String name : names) {
            int start = name.indexOf("(");
            int num = Integer.parseInt(name.substring(start + 1, name.indexOf(")")));
            String subName = name.substring(0, start);
            for (List<String> list : nameList) {
                if (list.contains(subName)) {
                    subName = list.get(0);
                    nameNum.put(subName, nameNum.getOrDefault(subName, 0) + num);
                    break;
                }
            }
        }
        String[] newName = new String[nameNum.size()];
        int i = 0;
        for (String key : nameNum.keySet()) {
            newName[i] = key + "(" + nameNum.get(key) + ")";
            i++;
        }
        return newName;
    }
}
