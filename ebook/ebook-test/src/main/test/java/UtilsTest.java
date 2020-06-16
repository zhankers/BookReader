import com.ebook.interview.Extension;
import com.ebook.interview.QuarterSalesItem;
import com.ebook.interview.SaleItem;
import com.ebook.interview.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Authr: chenchunhui
 * @Date: 2020-06-10 13:49
 */
public class UtilsTest {

    @Test
    public void question1() {
        List<Extension> extensionData = getExtensionData();
        List<Extension> extensions = Utils.sortByName(extensionData);
        extensions.forEach(System.out::println);
    }
    @Test
    public void question2() {
        List<Extension> extensionData = getExtensionData();
        List<Extension> extensions2 = Utils.sortByExtType(extensionData);
        extensions2.forEach(System.out::println);
    }
    @Test
    public void question3() {
        List<SaleItem> saleItemData = getSaleItemData();
        List<QuarterSalesItem> quarterSalesItems = Utils.maxByQuarter(saleItemData);
        quarterSalesItems.forEach(System.out::println);
    }
    @Test
    public void question4() {
        List<SaleItem> saleItemData = getSaleItemData();
        List<QuarterSalesItem> quarterSalesItems1 = Utils.sumByQuarter(saleItemData);
        quarterSalesItems1.forEach(System.out::println);
    }
    @Test
    public void question5() {
        int[] allKeys = {0,1,2,3,4,5,6,7,8,9};
        int[] usedKeys = {4,6,7};
        int[] unUsedKeys = Utils.getUnUsedKeys(allKeys, usedKeys);
        System.out.println(Arrays.toString(unUsedKeys));
    }


    private static List<Extension> getExtensionData() {
        Extension extension1 = new Extension();
        extension1.setExt("A");
        extension1.setExtType("User");
        extension1.setFirstName("zhan");
        extension1.setLastName("zhiqiang");
        Extension extension2 = new Extension();
        extension2.setExt("B");
        extension2.setExtType("Dept");
        extension2.setFirstName("chen");
        extension2.setLastName("chunhui");
        Extension extension3 = new Extension();
        extension3.setExt("E");
        extension3.setExtType("Other");
        extension3.setFirstName("xi");
        extension3.setLastName("jinping");
        Extension extension4 = new Extension();
        extension4.setExt("D");
        extension4.setExtType("TMO");
        extension4.setFirstName("li");
        extension4.setLastName("zhanshu");
        Extension extension5 = new Extension();
        extension5.setExt("E");
        extension5.setExtType("AO");
        extension5.setFirstName("li");
        extension5.setLastName("keqiang");

        Extension extension6 = new Extension();
        extension6.setExt("C");
        extension6.setExtType("AO");
        extension6.setFirstName("li");
        extension6.setLastName("keqiang");

        Extension extension7 = new Extension();
        extension7.setExt("");
        extension7.setExtType("AO");
        extension7.setFirstName("li");
        extension7.setLastName("");

        return Arrays.asList(extension1, extension2, extension3, extension4, extension5, extension6, extension7);
    }


    private static List<SaleItem> getSaleItemData() {

        SaleItem saleItem2 = new SaleItem();
        saleItem2.setDate(new Date(2019, 3, 6));
        saleItem2.setMonth(3);
        saleItem2.setSaleNumbers(567.83);
        saleItem2.setTransationId("1");
        SaleItem saleItem3 = new SaleItem();
        saleItem3.setDate(new Date(2019, 2, 6));
        saleItem3.setMonth(2);
        saleItem3.setSaleNumbers(554.63);
        saleItem3.setTransationId("1");
        SaleItem saleItem4 = new SaleItem();
        saleItem4.setDate(new Date(2019, 1, 6));
        saleItem4.setMonth(1);
        saleItem4.setSaleNumbers(567.43);
        saleItem4.setTransationId("1");
        SaleItem saleItem5 = new SaleItem();
        saleItem5.setDate(new Date(2019, 4, 6));
        saleItem5.setMonth(4);
        saleItem5.setSaleNumbers(587.23);
        saleItem5.setTransationId("1");
        SaleItem saleItem6 = new SaleItem();
        saleItem6.setDate(new Date(2019, 5, 6));
        saleItem6.setMonth(5);
        saleItem6.setSaleNumbers(554.83);
        saleItem6.setTransationId("1");

        SaleItem saleItem7 = new SaleItem();
        saleItem7.setDate(new Date(2019, 5, 6));
        saleItem7.setMonth(6);
        saleItem7.setSaleNumbers(554.83);
        saleItem7.setTransationId("1");


        SaleItem saleItem8 = new SaleItem();
        saleItem8.setDate(new Date(2019, 5, 6));
        saleItem8.setMonth(7);
        saleItem8.setSaleNumbers(574.83);
        saleItem8.setTransationId("1");


        SaleItem saleItem9 = new SaleItem();
        saleItem9.setDate(new Date(2019, 5, 6));
        saleItem9.setMonth(8);
        saleItem9.setSaleNumbers(554.83);
        saleItem9.setTransationId("1");

        SaleItem saleItem10 = new SaleItem();
        saleItem10.setDate(new Date(2019, 5, 6));
        saleItem10.setMonth(9);
        saleItem10.setSaleNumbers(954.83);
        saleItem10.setTransationId("1");

        SaleItem saleItem11 = new SaleItem();
        saleItem11.setDate(new Date(2019, 5, 6));
        saleItem11.setMonth(10);
        saleItem11.setSaleNumbers(654.83);
        saleItem11.setTransationId("1");

        SaleItem saleItem12 = new SaleItem();
        saleItem12.setDate(new Date(2019, 5, 6));
        saleItem12.setMonth(11);
        saleItem12.setSaleNumbers(754.83);
        saleItem12.setTransationId("1");

        SaleItem saleItem1 = new SaleItem();
        saleItem1.setDate(new Date(2020, 3, 6));
        saleItem1.setMonth(12);
        saleItem1.setSaleNumbers(565.93);
        saleItem1.setTransationId("1");

        return Arrays.asList(saleItem1, saleItem2, saleItem3, saleItem4, saleItem5, saleItem6, saleItem7, saleItem8, saleItem9, saleItem10, saleItem12, saleItem11);
    }

}
