/**
 * Created by 普通账户 on 2016/7/17.
 */
public class BoughtGoods {

    final static int MAX_LENGTH = 50;

    public String m_Items[];                        //保存所有购买商品的条形码
    public int m_GoodsAmount[];                     //保存所有购买上平的数量
    public static AllGoods m_All;                   //保存商品所有商品的信息
    public int m_GoodsType;                         //商品的种类（去掉重复条形码之后）
    public boolean m_95;                            //商品中是否存在打95折的商品
    public boolean m_2For3;                         //商品中是否存在买2送1的商品

    /**设置购买商品
     *参数String AllData          :同时含有商品条形码信息和数量信息的字符串数组
     *无返回值
     *功能                        :将商品条形码和数量信息分开储存，并去掉重复的商品
     */
    public void Set(String[] AllData)
    {
        m_Items = new String[MAX_LENGTH];
        m_GoodsAmount = new int[MAX_LENGTH];
        m_All = new AllGoods();
        for(int Count1 = 0;Count1 != AllData.length;Count1++) {
            boolean Found = false;
            String NowSearch = BoughtData.GetBarcode(AllData[Count1]);
            for (int Count2 = 0; Count2 != m_GoodsType; Count2++) {
                if (m_Items[Count2].equals(NowSearch)) {
                    m_GoodsAmount[Count2] += BoughtData.GetAmount(AllData[Count1]);
                    Found = true;
                    break;
                }
            }
            if(!Found) {
                m_Items[m_GoodsType] = NowSearch;
                m_GoodsAmount[m_GoodsType] = BoughtData.GetAmount(AllData[Count1]);
                m_GoodsType++;
            }
            if(m_All.GetSingleGoods(m_Items[Count1]).m_DiscountState == SingleGoods.DISCOUNT_95)
            {
                m_95 = true;
            }
            if((m_All.GetSingleGoods(m_Items[Count1]).m_DiscountState == SingleGoods.DISCOUNT_2_FOR_3)||(m_All.GetSingleGoods(m_Items[Count1]).m_DiscountState == SingleGoods.DISCOUNT_2_FOR_3))
            {
                m_2For3 = true;
            }
        }
    }


    /**计算所有商品的总价
     * *无参数
     * *返回值                     ：所有商品的总价
     * *功能                      ：将所有商品的总价加起来并返回
     * */
    public double CalculateAll() {
        double AllCost = 0;
        for (int Count = 0; Count != m_GoodsType; Count++) {
            SingleGoods Temp = m_All.GetSingleGoods(m_Items[Count]);
            if(Temp.equals(""))
            {
                continue;
            }
            AllCost += Temp.CalculateCost(m_GoodsAmount[Count]);
        }
        return AllCost;
    }

    /**计算节省的价格
     * 无参数
     * 返回值                      ：节省的钱
     * *功能                      ：计算节省的钱
     * */
    public double CalculateSave()
    {
        double ShouldPay = 0;
        for(int Count = 0;Count != m_GoodsType;Count++)
        {
            if(m_All.GetPrice(m_Items[Count]) == -1)
            {
                continue;
            }
            ShouldPay += (m_GoodsAmount[Count])*(m_All.GetPrice(m_Items[Count]));
        }
        return ShouldPay-CalculateAll();
    }
}
