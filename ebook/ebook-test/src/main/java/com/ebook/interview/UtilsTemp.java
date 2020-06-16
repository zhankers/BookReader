//package com.ebook.interview;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//
//import static java.util.stream.Collectors.collectingAndThen;
//import static java.util.stream.Collectors.groupingBy;
//import static java.util.stream.Collectors.mapping;
//import static java.util.stream.Collectors.maxBy;
//import static java.util.stream.Collectors.reducing;
//import static java.util.stream.Collectors.summingDouble;
//import static java.util.stream.Collectors.toList;
//
//public class UtilsTemp {
//
//    private static final int SPRING = 1; //春
//    private static final int SUMMER = 2; //夏
//    private static final int  FALL = 3;   //秋
//    private static final int  WINTER = 4; //冬
//
//
//    //Question1
//
//    /**
//     * Question1, sort by firstName + lastName + ext,
//     * if firstName is the same then sort by lastName and
//     * ext, please note lastName and ext can be empty
//     * string or null.
//     */
//    public static List<Extension> sortByName(List<Extension> extensions) {
//
//        extensions.sort(Comparator.comparing(Extension::getFirstName)
//                .thenComparing(Extension::getLastName, Comparator.nullsFirst(String::compareTo))
//                .thenComparing(Extension::getExt, Comparator.nullsFirst(String::compareTo)));
//
//        return extensions;
//    }
//
//
//    //Question2
//
//    /**
//     * Question2, sort extType, extType is a string and can
//     * be "User", "Dept", "AO", "TMO", "Other",
//     * sort by User > Dept > AO > TMO > Other;
//     */
//    public static List<Extension> sortByExtType(List<Extension> extensions) {
//        // JDK 8 写法
////        Map<String, Integer> sortSeq = new HashMap<>(5);
////        sortSeq.put("User", 0);
////        sortSeq.put("Dept", 1);
////        sortSeq.put("AO", 2);
////        sortSeq.put("TMO", 3);
////        sortSeq.put("Other", 4);
//
//        // JDK 11 写法
//        Map<String, Integer> sortSeq = Map.of("User", 0, "Dept", 1, "AO", 2, "TMO", 3, "Other", 4);
//        extensions.sort(Comparator.comparing(Extension::getExtType, Comparator.comparing(sortSeq::get)));
//        return extensions;
//    }
//
//    //Question3
//
//    /**
//     * Question3, sum all sales items by quarter
//     */
//    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
//
//        List<QuarterSalesItem> result = new ArrayList<>();
//        // 使用long汇总
//        saleItems.stream()
//                .collect(groupingBy(UtilsTemp::getQuarter, summingDouble(SaleItem::getSaleNumbers)))
//                .forEach((quarter, sum) -> {
//                    QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
//                    quarterSalesItem.setQuarter(quarter);
//                    // 四舍五入
//                    quarterSalesItem.setValue(new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
//                    result.add(quarterSalesItem);
//                });
//
//
////        BigDecimal bigDecimal2 = new BigDecimal("567.83");
////        BigDecimal bigDecimal1 = new BigDecimal("554.63");
////        BigDecimal bigDecimal = new BigDecimal("567.43");
////        BigDecimal add = bigDecimal2.add(bigDecimal1).add(bigDecimal);
////        System.out.println("RWAR " + add);
////        System.out.println("RWAR " + add.doubleValue());
//
//
//        Map<Integer, List<BigDecimal>> collect = saleItems.stream()
//                .collect(groupingBy(UtilsTemp::getQuarter,
//                        mapping(item -> new BigDecimal(item.getSaleNumbers()),
//                                toList())));
//        collect.forEach((k, v) -> {
//            double v1 = v.stream().peek(item -> System.out.print(item.doubleValue() + " ")).reduce(BigDecimal.ZERO, BigDecimal::add).doubleValue();
//            System.out.println("----> " + v1);
//        });
//
//        saleItems.stream()
//                .collect(groupingBy(UtilsTemp::getQuarter,
//                        mapping(item -> {
//                                    System.out.println("2--> " + item.getSaleNumbers());
//                                    double saleNumbers = item.getSaleNumbers();
//                                    System.out.println("--> " + saleNumbers);
//                                    BigDecimal bigDecimal = new BigDecimal(item.getSaleNumbers());
//                                    BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(item.getSaleNumbers()));
//                                    System.out.println("3--> " + bigDecimal);
//                                    System.out.println("4--> " + bigDecimal2);
//                                    return new BigDecimal(String.valueOf(item.getSaleNumbers()));
//                        },
//                                reducing(BigDecimal.ZERO, (bigDecimal3, augend) -> {
//                                    System.out.println("RWAR " + bigDecimal3);
//                                    System.out.println("RWAR " + augend);
//                                    BigDecimal add1 = bigDecimal3.add(augend);
//                                    return add1;
//                                }))));
//
//        // 使用BigDecimal汇总
//        saleItems.stream()
//                .collect(groupingBy(UtilsTemp::getQuarter,
//                        mapping(item -> new BigDecimal(String.valueOf(item.getSaleNumbers())),
//                                reducing(BigDecimal.ZERO, BigDecimal::add))))
//                .forEach((quarter, decimalSum) -> {
//                    QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
//                    quarterSalesItem.setQuarter(quarter);
//
//                    quarterSalesItem.setValue(decimalSum.doubleValue());
//                    result.add(quarterSalesItem);
//                });
//
//
//        return result;
//    }
//
//    //Question4
//
//    /**
//     * max all sales items by quarter
//     */
//    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
//
//        List<QuarterSalesItem> result = new ArrayList<>();
//        saleItems.stream()
//                .collect(groupingBy(UtilsTemp::getQuarter,
//                        collectingAndThen(maxBy(Comparator.comparingDouble(SaleItem::getSaleNumbers)),
//                                optionalSaleItem -> optionalSaleItem.get().getSaleNumbers())))
//                .forEach((quarter, maxSale) -> {
//                    QuarterSalesItem quarterSalesItem = new QuarterSalesItem();
//                    quarterSalesItem.setQuarter(quarter);
//                    quarterSalesItem.setValue(maxSale);
//                    result.add(quarterSalesItem);
//                });
//
//
//        return result;
//    }
//
//    //Question5
//
//    /**
//     * We have all Keys: 0-9;
//     * usedKeys is an array to store all used keys like :[2,3,4];
//     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
//     */
//
//    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
//        List<Integer> usedKeyList = Arrays.stream(usedKeys).boxed().collect(toList());
//        return Arrays.stream(allKeys).filter(item -> !usedKeyList.contains(item)).toArray();
//    }
//
//    private static int getQuarter(SaleItem saleItem) {
//        int month = saleItem.getMonth();
//        if (month <= 3) {
//            // 1,2,3月：春
//            return SPRING;
//        } else if (month <= 6) {
//            // 4,5,6月：夏
//            return SUMMER;
//        } else if (month <= 9) {
//            // 7,8,9月：秋
//            return FALL;
//        } else if (month <= 12) {
//            // 10,11,12月：冬
//            return WINTER;
//        } else {
//            return -1;
//        }
//    }
//
//}
