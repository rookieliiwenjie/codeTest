package LeetCode.everyDay;

import java.util.Arrays;
import java.util.Map;

public class SmallestRangeII {

    public int smallestRangeII(int[] nums, int k) {
        int smallRange = Integer.MAX_VALUE;
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int a= nums[i];int b = nums[i+1];
//            smallRange = Math.min(smallRange,Math.max(Math.max()-Math.min()));
        }
        return smallRange;
    }

    public static void main(String[] args) {
        SmallestRangeII smallestRangeII = new SmallestRangeII();
//        int nums[]={0,10};
//        int k = 2;
        int nums[]={1,3,6};
        int k =3;
        int i = smallestRangeII.smallestRangeII(nums, k);
        System.out.println(i);
    }

//    public static void main(String[] args) {
//        String orderlists = "732565478507\n" +
//                "820635875516\n" +
//                "821683980081\n" +
//                "825418034590\n" +
//                "812774191405\n" +
//                "815771703808\n" +
//                "815766343722\n" +
//                "811651207819\n" +
//                "811567126299\n" +
//                "811539426399\n" +
//                "811340895599\n" +
//                "825489206890\n" +
//                "791582815907\n" +
//                "791387042907\n" +
//                "791384355407\n" +
//                "791230426407\n" +
//                "733726999140\n" +
//                "817963099577\n" +
//                "812774191405\n" +
//                "812697131105\n" +
//                "806967690600\n" +
//                "796295006974\n" +
//                "825706032090\n" +
//                "825418034590\n" +
//                "819147131645\n" +
//                "795807551274\n" +
//                "790375440007\n" +
//                "790182310307\n" +
//                "806713939700\n" +
//                "806478818700\n" +
//                "805961326800\n";
//        String[] split = orderlists.split("\n");
//        for (String orderId:split){
//            HttpRequest request = HttpUtil.createGet("http://work.depot.dmall.com/manual/doreleaseoccupy")
//                    .form("orderId", orderId)
//                    .form("shopId", 1)
//                    .header("cookie", "userName=%E6%9D%8E%E6%96%87%E6%9D%B0; tempid=CAF156DC348000022E986299F030F300; timeZone=Asia/Shanghai; language=zh; loginType=account; login_token=Bearer%20eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3Mjk0NzQ4MjYzMjcsImV4cCI6MTczMDA3OTYyNjMyNywiaXNzIjoia2VuIiwiZGF0YSI6eyJ1c2VyX2luZm8iOnsidXNlcl9pZCI6NjI4MzcyMSwidXNlcl9jb2RlIjoid2VuamllLmxpIiwidXNlcl9uYW1lIjoiXHU2NzRlXHU2NTg3XHU2NzcwIiwicHJlZmVycmVkX25hbWUiOiJcdTY3NGVcdTY1ODdcdTY3NzAiLCJwaG9uZSI6IiIsImVtYWlsIjoid2VuamllLmxpQGRtYWxsLmNvbSIsImhyc19pZCI6NjIxNjkyMSwiaHJtc19pZCI6MTAwMDEwNjQ4MSwidXNlcl9ubyI6IjEwMDAwMDUwMiJ9LCJsb2dpbl90aW1lIjoxNzI5NDc0ODI2MzI3fX0.76YVnzPaEoO2rS6Gshkii_CxcUwsqgEwNFx--C_qTg4; login_user_name=%E6%9D%8E%E6%96%87%E6%9D%B0; login_type=vpn; login_dmall_id=wenjie.li; appname=cloud; username=wenjie.li; signature=eef66924b8561a8744b36d79ae72dc42; timestamp=1729562530; userName=%E6%9D%8E%E6%96%87%E6%9D%B0")
//                    .form("orderSource", "112");
//            HttpResponse response = request.execute();
//            String result = response.body();
//            Map<String, Object> data = JSON.parseObject(result, Map.class);
//            System.out.println("---"+data);
//        }
////        List<StockFlowVO> stockFlowVOS =JSON.parseArray("[{\"cacheOccupy\":1,\"computeByChildOrMaster\":-1,\"created\":1719833095000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66829207606af40001de30d3\",\"ip\":\"10.56.214.156\",\"orderId\":\"20000211500277303\",\"originOperNum\":2,\"originSkuId\":180356561,\"realOperNum\":2,\"recordType\":2,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"OFL\",\"tid\":\"c3d1e00297a677b3\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":-1,\"created\":1719833088000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66829200074b080001b9760c\",\"ip\":\"10.56.215.28\",\"orderId\":\"20000211500277303\",\"originOperNum\":1,\"originSkuId\":180356561,\"realOperNum\":1,\"recordType\":2,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"api.interception.dmall.com\",\"tid\":\"1d96f5e8ecd9e088\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":-1,\"created\":1719828160000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827ec0de941f000134885c\",\"ip\":\"10.56.213.144\",\"orderId\":\"20000211500276703\",\"originOperNum\":1,\"originSkuId\":180356561,\"realOperNum\":1,\"recordType\":2,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"api.interception.dmall.com\",\"tid\":\"73e442b959a9e414\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":-1,\"created\":1719827261000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827b3d3ea6eb0001a62af7\",\"ip\":\"10.56.212.168\",\"orderId\":\"20000211500276503\",\"originOperNum\":2,\"originSkuId\":180356561,\"realOperNum\":2,\"realStockStore\":999,\"recordType\":2,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"PSMP\",\"tid\":\"39aa28e2e6262945\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719889632000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66836ee0f5ea560001d8edc1\",\"ip\":\"10.56.214.178\",\"needCheck\":1,\"orderId\":\"20000211500280103\",\"originOperNum\":1,\"originSkuId\":180356561,\"realOperNum\":1,\"recordType\":1,\"shopId\":172601,\"specNum\":1000,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"ef1f5ed869862f07\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719832918000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66829156074b080001b97609\",\"ip\":\"10.56.215.28\",\"needCheck\":1,\"orderId\":\"20000211500277303\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"471d5d1ce152ad01\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719832918000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66829156074b080001b9760a\",\"ip\":\"10.56.215.28\",\"needCheck\":1,\"orderId\":\"20000211500277303\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":2,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"471d5d1ce152ad01\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719832918000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66829156074b080001b9760b\",\"ip\":\"10.56.215.28\",\"needCheck\":1,\"orderId\":\"20000211500277303\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":1000,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"471d5d1ce152ad01\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827952000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827df0de941f0001348859\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276703\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"80d6a7d87dcec5bf\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827952000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827df0de941f000134885a\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276703\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":2,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"80d6a7d87dcec5bf\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827952000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827df0de941f000134885b\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276703\",\"originOperNum\":3,\"originSkuId\":180356561,\"realOperNum\":3,\"recordType\":1,\"shopId\":172601,\"specNum\":1000,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"80d6a7d87dcec5bf\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827113000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827aa9de941f0001348854\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276503\",\"originOperNum\":2,\"originSkuId\":180356561,\"realOperNum\":2,\"recordType\":1,\"shopId\":172601,\"specNum\":1,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"b9cbe7585a39e05a\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827113000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827aa9de941f0001348855\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276503\",\"originOperNum\":2,\"originSkuId\":180356561,\"realOperNum\":2,\"recordType\":1,\"shopId\":172601,\"specNum\":2,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"b9cbe7585a39e05a\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1},{\"cacheOccupy\":1,\"computeByChildOrMaster\":2,\"created\":1719827113000,\"depotId\":12931,\"destSkuId\":180356561,\"id\":\"66827aa9de941f0001348856\",\"ip\":\"10.56.213.144\",\"needCheck\":1,\"orderId\":\"20000211500276503\",\"originOperNum\":2,\"originSkuId\":180356561,\"realOperNum\":2,\"recordType\":1,\"shopId\":172601,\"specNum\":1000,\"stockStore\":999,\"system\":\"orderapi\",\"tid\":\"b9cbe7585a39e05a\",\"tradeType\":1,\"version\":1,\"weightNum\":1,\"yn\":1}]",StockFlowVO.class);
////        List<StockFlowVO> flowVOS = StockFlowCalculate.caculateUnReleaseOccupy(stockFlowVOS);
////        System.out.println(JSON.toJSONString(flowVOS));
////        List<StockFlowVO> flowVONew = StockFlowCalculate.caculateUnReleaseOccupy(null,stockFlowVOS);
////        System.out.println(JSON.toJSONString(flowVONew));
//    }
}
