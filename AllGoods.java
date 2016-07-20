

public class AllGoods
{
    final static int ALL_SPECIES = 5;
    private SingleGoods m_AllGoods[] = new SingleGoods[ALL_SPECIES];
    AllGoods()
    {
        m_AllGoods[0] = new  SingleGoods("ITEM000001","苹果",5.5,"斤");
        m_AllGoods[0].SetDiscount(SingleGoods.DISCOUNT_NULL);
        m_AllGoods[1] = new SingleGoods("ITEM000002","羽毛球",1,"个");
        m_AllGoods[1].SetDiscount(SingleGoods.DISCOUNT_2_FOR_3);
        m_AllGoods[2] = new SingleGoods("ITEM000003","可口可乐",3.00,"瓶");
        m_AllGoods[2].SetDiscount(SingleGoods.DISCOUNT_95);
        m_AllGoods[3] = new SingleGoods("ITEM000004","Thinking in Java",2.00,"本");
        m_AllGoods[3].SetDiscount(SingleGoods.DISCOUNT_BOTH);
        m_AllGoods[4] = new SingleGoods("ITEM000005","雨伞",20.0,"把");
        m_AllGoods[4].SetDiscount(SingleGoods.DISCOUNT_NULL);
    }

    public String GetName(String Item)
    {
        for(int Count = 0;Count != ALL_SPECIES;Count++)
        {
            if(m_AllGoods[Count].m_Item.equals(Item))
            {
                return m_AllGoods[Count].m_Name;
            }
        }
        return "";
    }

    public double GetPrice(String Item)
    {
        for(int Count = 0;Count != ALL_SPECIES;Count++)
        {
            if(m_AllGoods[Count].m_Item.equals(Item))
            {
                return m_AllGoods[Count].m_Price;
            }
        }
        return -1;
    }

    public String GetUnit(String Item)
    {
        for(int Count = 0;Count != ALL_SPECIES;Count++)
        {
            if(m_AllGoods[Count].m_Item.equals(Item))
            {
                return m_AllGoods[Count].m_Unit;
            }
        }
        return "";
    }

    public int GetDiscountState(String Item)
    {
        for(int Count = 0;Count != ALL_SPECIES;Count++)
        {
            if(m_AllGoods[Count].m_Item.equals(Item))
            {
                return m_AllGoods[Count].m_DiscountState;
            }
        }
        return -1;
    }
    public SingleGoods GetSingleGoods(String Item)
    {
        for(int Count = 0;Count != ALL_SPECIES;Count++) {
            if (m_AllGoods[Count].m_Item.equals(Item)) {
                return m_AllGoods[Count];
            }
        }
        return new SingleGoods("ITEM000000","",0.0,"");
    }
}
