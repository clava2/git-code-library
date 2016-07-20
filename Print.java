/**
 * Created by 普通账户 on 2016/7/19.
 */
public class Print {

    public String[] m_ErrorItems = new String[BoughtGoods.MAX_LENGTH];
    public int m_ErrorCount = 0;

    public void EraseError()
    {
        for(int i = 0;i != m_ErrorCount;i++)
        {
            m_ErrorItems[i] = "";
        }
        m_ErrorCount = 0;
    }

    public void PrintHead()
    {
        System.out.print("******<没钱赚商店>购物清单******\n\n");
    }

    public void PrintBody(BoughtGoods Goods)
    {
        EraseError();
        for(int Count = 0;Count != Goods.m_GoodsType;Count++)
        {
            SingleGoods Temp = Goods.m_All.GetSingleGoods(Goods.m_Items[Count]);
            if(Temp.m_Name.equals(""))
            {
                m_ErrorItems[m_ErrorCount] = Goods.m_Items[Count];
                m_ErrorCount++;
                continue;
            }
            Temp.Print(Goods.m_GoodsAmount[Count]);
            System.out.print("\n");
        }
    }

    public void PrintAddition(BoughtGoods Goods)
    {
        if(Goods.m_2For3)
        {
            System.out.print("--------------------------------------------\n\n");
            System.out.print("买二赠一的商品：\n");
            for(int Count = 0; Count != Goods.m_GoodsType;Count++)
            {
                if(Goods.m_All.GetSingleGoods(Goods.m_Items[Count]).m_DiscountState == SingleGoods.DISCOUNT_2_FOR_3)
                {
                    System.out.print("\t名称：");
                    System.out.print(Goods.m_All.GetName(Goods.m_Items[Count]));
                    System.out.print(",数量:");
                    System.out.print(Goods.m_GoodsAmount[Count]/3);
                    System.out.print(Goods.m_All.GetUnit(Goods.m_Items[Count]));
                    System.out.print("\n");
                }
            }
            System.out.print("\n");
        }
    }
    public void PrintEnd(BoughtGoods Goods)
    {
        System.out.print("--------------------------------------------\n");
        System.out.print("总计：");
        System.out.print(Goods.CalculateAll());
        System.out.print("(元)");
        if(Goods.m_95||Goods.m_2For3)
        {
            System.out.print("节省：");
            System.out.print(Goods.CalculateSave());
            System.out.print("（元）");
        }
        System.out.print("\n*****************************************************");
    }
    public void PrintError()
    {
        if(m_ErrorCount == 0)
        {
            return;
        }
        System.out.print("\n\n");
        System.out.print("很不幸，以下条形码我们没有找到，请重新核对：\n");
        for(int i = 0;i < m_ErrorCount;i++)
        {
            System.out.print(m_ErrorItems[i]);
            System.out.print("\n");
        }
    }
}
