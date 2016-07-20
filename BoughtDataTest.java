import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by 普通账户 on 2016/7/17.
 */
public class BoughtDataTest {
    private BoughtData boughtData = new BoughtData();
    private BoughtGoods Goods = new BoughtGoods();
    private AllGoods All = new AllGoods();


    //拆分所给字符串部分的测试

    //输入字符串，输出商品数量
    @org.junit.Test
    public void return_1_when_input_ITEM000001()
    {
        assertThat(boughtData.GetAmount("ITEM000001"),is(1));
    }

    @Test
    public void return_2_when_input_ITEM000001_2()
    {
        assertThat(boughtData.GetAmount("ITEM000001-2"),is(2));
    }

    @Test
    public void return_2_when_input_ITEM000002_2()
    {
        assertThat(boughtData.GetAmount("ITEM000002-2"),is(2));
    }

    //输入字符串，输出商品条形码
    @Test
    public void return_ITEM000002_when_input_ITEM000002()
    {
        assertThat(boughtData.GetBarcode("ITEM000002"),is("ITEM000002"));
    }

    @Test
    public void return_ITEM000002_when_input_ITEM000002_2()
    {
        assertThat(boughtData.GetBarcode("ITEM000002-2"),is("ITEM000002"));
    }
    @Test
    public void return_ITEM000001_when_input_ITEM000001_2()
    {
        assertThat(boughtData.GetBarcode("ITEM000001-1"),is("ITEM000001"));
    }

    @Test
    public void return_umbrella_when_input_ITEM000005()
    {
        assertThat(All.GetName("ITEM000005"),is("雨伞"));
    }

    @Test
    public void return_Cococola_when_input_ITEM000003()
    {
        assertThat(All.GetName("ITEM000003"),is("可口可乐"));
    }
    @Test
    public void return_NULL_when_input_ITEM000006()
    {
        assertThat(All.GetName("ITEM000006"), is(""));
    }
    @Test
    public void return_five_dot_five_when_input_ITEM000001()
    {
        assertThat(All.GetPrice("ITEM000001"),is(5.5));
    }
    @Test
    public void return_1_when_input_ITEM000002()
    {
        assertThat(All.GetPrice("ITEM000002"),is(1.0));
    }
    @Test
    public void return_negative_1_when_input_ITEM000006()
    {
        assertThat(All.GetPrice("ITEM000006"),is(-1.0));
    }
    @Test
    public void return_bottle_when_input_ITEM000003()
    {
        assertThat(All.GetUnit("ITEM000003"),is("瓶"));
    }
    @Test
    public void return_500g_when_input_ITEM000001()
    {
        assertThat(All.GetUnit("ITEM000001"),is("斤"));
    }
    @Test
    public void return_NULL_Unit_when_input_ITEM000006()
    {
        assertThat(All.GetUnit("ITEM000006"),is(""));
    }
    @Test
    public void return_DISCOUNT_NULL_when_input_ITEM000001()
    {
        assertThat(All.GetDiscountState("ITEM000001"),is(SingleGoods.DISCOUNT_NULL));
    }
    @Test
    public void return_DISCOUNT_2_FOR_3_when_input_ITEM000002()
    {
        assertThat(All.GetDiscountState("ITEM000002"),is(SingleGoods.DISCOUNT_2_FOR_3));
    }
    @Test
    public void return_negative_1_Discount_State_when_input_ITEM000006()
    {
        assertThat(All.GetDiscountState("ITEM000006"),is(-1));
    }
    @Test
    public void return_umbrella_info_when_input_ITEM000005()
    {
        assertThat(All.GetSingleGoods("ITEM000005").m_Name,is("雨伞"));
    }
    @Test
    public void return_NULL_info_when_input_ITEM000006()
    {
        assertThat(All.GetSingleGoods("ITEM000006").m_Name,is(""));
    }
    @Test
    public void return_3_and_1_when_input_ITEM000001_ITEM000001_2_ITEM000002()
    {
        String Data[] = {"ITEM000001","ITEM000001-2","ITEM000002"};
        Goods.Set(Data);
        assertThat(Goods.m_GoodsAmount[0],is(3));
        assertThat(Goods.m_GoodsAmount[1],is(1));
    }
    @Test
    public void return_Item000001_and_ITEM000002_when_input_ITEM000001_ITEM000001_2_ITEM000002()
    {
        String Data[] = {"ITEM000001","ITEM000001-2","ITEM000002"};
        Goods.Set(Data);
        assertThat(Goods.m_Items[0],is("ITEM000001"));
        assertThat(Goods.m_Items[1],is("ITEM000002"));
    }
    @Test
    public void return_true_when_input_ITEM000001_and_ITEM000002()
    {
        String[] Data = {"ITEM000001","ITEM000002"};
        Goods.Set(Data);
        assertThat(Goods.m_2For3,is(true));
    }
    @Test
    public void return_false_when_input_ITEM000001_and_ITEM000002()
    {
        String[] Data = {"ITEM000001","ITEM000002"};
        Goods.Set(Data);
        assertThat(Goods.m_95,is(false));
    }
    @Test
    public void return_false_when_input_ITEM000004()
    {
        String[] Data = {"ITEM000004"};
        Goods.Set(Data);
        assertThat(Goods.m_95,is(false));
    }

    @Test
    public void return_1_when_input_ITEM000002_3()
    {
        String[] Data = {"ITEM000002-3"};
        Goods.Set(Data);
        assertThat(Goods.CalculateSave(),is(1.00));
    }
    @Test
    public void return_3_when_input_ITEM000002_3_and_ITEM000004_3()
    {
        String[] Data = {"ITEM000002-3","ITEM000004-3"};
        Goods.Set(Data);
        assertThat(Goods.CalculateSave(),is(3.00));
    }
    @Test
    public void return__ITEM0000001_when_input_ITEM000001()
    {
        Print Printer = new Print();
        String[] Data = {"ITEM0000001"};
        Goods.Set(Data);
        Printer.PrintBody(Goods);
        assertThat(Printer.m_ErrorItems[0],is("ITEM0000001"));
        assertThat(Printer.m_ErrorCount,is(1));
    }
}