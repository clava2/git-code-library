import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by 普通账户 on 2016/7/17.
 */
public class SingleGoodsTest {
    @Test
    public void return_20_when_input_DISCOUNT_NULL_and_4_and_Price_5()
    {
        SingleGoods goods = new SingleGoods("ITEM000001","雨伞",5.00,"个");
        goods.SetDiscount(SingleGoods.DISCOUNT_NULL);
        assertThat(goods.CalculateCost(4),is(20.00));
    }
    @Test
    public void return_15_when_input_DISCOUNT_2_FOR_3_and_4_and_Price_5()
    {
        SingleGoods goods = new SingleGoods("ITEM000001","雨伞",5.00,"个");
        goods.SetDiscount(SingleGoods.DISCOUNT_2_FOR_3);
        assertThat(goods.CalculateCost(4),is(15.00));
    }
    @Test
    public void return_19_when_input_DISCOUNT_95_and_4_and_Price_5()
    {
        SingleGoods goods = new SingleGoods("ITEM000001","雨伞",5.00,"个");
        goods.SetDiscount(SingleGoods.DISCOUNT_95);
        assertThat(goods.CalculateCost(4),is(19.00));
    }
    @Test
    public void return_15_when_input_DISCOUNT_BOTH_and_4_and_Price_5()
    {
        SingleGoods goods = new SingleGoods("ITEM000001","雨伞",5.00,"个");
        goods.SetDiscount(SingleGoods.DISCOUNT_BOTH);
        assertThat(goods.CalculateCost(4),is(15.00));
    }
    @Test
    public void return_negative_1_when_input_4_and_4_and_Price_5()
    {
        SingleGoods goods = new SingleGoods("ITEM000001","雨伞",5.00,"个");
        goods.SetDiscount(5);
        assertThat(goods.CalculateCost(4),is(-1.00));
    }
}
