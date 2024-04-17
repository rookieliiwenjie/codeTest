package com.company.Java.objectpool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ObjectPoolTest {
//    public static void main(String[] args) { // 创建一个大小为5的对象池，并指定创建对象的工厂类
//        ObjectPool<MyObject> objectPool = ObjectPool.create(5, new MyObjectFactory()); // 借用对象
//        try {
//            MyObject object1 = objectPool.borrowObject();
//            System.out.println("借用对象1：" + object1);
//            MyObject object2 = objectPool.borrowObject();
//            System.out.println("借用对象2：" + object2); // 归还对象
//            objectPool.returnObject(object1);
//            System.out.println("归还对象1：" + object1);
//            MyObject object3 = objectPool.borrowObject();
//            System.out.println("借用对象3：" + object3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    static class MyObject { // 自定义对象类
//    }
//
//    static class MyObjectFactory implements ObjectFactory<MyObject> {
//        @Override
//        public MyObject createObject() { // 创建自定义对象的逻辑
//            return new MyObject();
//        }
//    }




    public static final String EVENT_UPDATE = "UPDATE";

    public static final String DB_NAME = "dmall_ware";
    public static final String EVENT_INSERT = "INSERT";
    private static final String START_TIME_STR = "12:00:00";
    private static final String END_TIME_STR = "23:59:59";
    /**
     * 要监控更改的表
     */
    private static String[] listenerTables = {
            "ware_ware","ware_ware10","ware_sku","ware_sku10","sap_location_ware","ware_onway_stock_rule","ware_onway_stock_rule_sku"
    };

    private static final String LISTENER_TABLE = "sap_location_ware";

    public static boolean isListenerEventTables(String tableName){
        boolean isListener = false;
        if(StringUtils.isEmpty(tableName)) return false;
        isListener = Arrays.asList(listenerTables).contains(tableName);
        return isListener;
    }

    public static boolean isListenerEventTables2(String tableName){
        return LISTENER_TABLE.equals(tableName);
    }

    public static void main(String[] args) throws ParseException {
//        for (int i = 0; i < 5; i++) {
//            outerloop:
//            for (int j = 0; j < 5; j++) {
//                for (int k = 0; k < 5; k++) {
//                    if (i == 2 && j == 3 && k == 4) {
//                        break outerloop;
//                    }
//                    System.out.println("i: " + i + ", j: " + j + ", k: " + k);
//                }
//            }
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date currentTime = sdf.parse("2024-01-05 11:00:00");
        Date now = DateUtil.getCurrentDate();
        String todayDateStr = DateUtil.formatYYYYMMDD(now);
        Calendar arriveDate = Calendar.getInstance();
        arriveDate.setTime(DateUtil.toYyyymmddDateTime(now));
        try {
            Date startTime = DateUtil.parseDateTime(todayDateStr + " " + START_TIME_STR);
            Date endTime = DateUtil.parseDateTime(todayDateStr + " " + END_TIME_STR);
            if(currentTime.compareTo(startTime) > 0 && currentTime.compareTo(endTime) <= 0){
                arriveDate.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
        }
        System.out.println(arriveDate.getTime());
    }
    /**
     * 转换表名为指定格式的方法名
     * 例如：ware_ware  对应方法为  wareWareChange
     * sap_location_ware : sapLocationWareChange
     * ware_sku : wareSkuChange
     * @param tableName
     * @return
     */
    public static String convertTableToMethodName(String tableName){
        String name = "";
        String suffix = "Change";
        if(StringUtils.isEmpty(tableName)){
            return null;
        }
        if(StringUtils.equals(tableName, "ware_ware") || StringUtils.equals(tableName, "ware_ware10")){
            name = "wareWare";
        } else if(StringUtils.equals(tableName, "ware_sku") || StringUtils.equals(tableName, "ware_sku10")){
            name = "wareSku";
        } else {
            String[] names = StringUtils.split(tableName, "_");
            for(String mn : names){
                if(StringUtils.isEmpty(name)){
                    name = mn;
                } else {
                    StringBuilder sb = new StringBuilder(mn);
                    if(sb != null && sb.length() > 0){
                        String upperStr = sb.substring(0, 1).toUpperCase();
                        sb.delete(0, 1);
                        sb.insert(0, upperStr);
                        name += sb.toString();
                    }
                }
            }
        }

        return name + suffix;
    }

    public static String convertTableToMethodName2(String tableName){
        String name = "";
        String suffix = "Change";
        if(LISTENER_TABLE.equals(tableName)){
            name = "sapLocationWareNum";
        }
        return name + suffix;
    }
}