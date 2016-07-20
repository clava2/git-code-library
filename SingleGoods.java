/**
 * Created by 普通账户 on 2016/7/17.
 */

public class SingleGoods
{
    final static int DISCOUNT_NULL = 0;
    final static int DISCOUNT_95 = 1;
    final static int DISCOUNT_2_FOR_3 = 2;
    final static int DISCOUNT_BOTH = 3;



    public String m_Name = new String();
    public String m_Item =  new String();
    public String m_Unit = new String();
    public double m_Price;
    public int m_DiscountState;

    SingleGoods(String Item, String Name, double Price,String Unit)
    {
        m_Item = Item;
        m_Name = Name;
        m_Price = Price;
        m_Unit = Unit;
        m_DiscountState = DISCOUNT_NULL;
    }
    public void SetDiscount(int DiscountState)
    {
        m_DiscountState = DiscountState;
    }

    public void Print(int Quantity)
    {
        System.out.print("\t名称：");
        System.out.print(m_Name);
        System.out.print("\t,数量：");
        System.out.print(Quantity);
        System.out.print("\t");
        System.out.print(m_Unit);
        System.out.print("\t,单价：");
        System.out.print(m_Price);
        System.out.print("\t(元)");
        System.out.print("\t\t,小计：");
        System.out.print(CalculateCost(Quantity));
        if(CalculateCost(Quantity)<m_Price*Quantity)
        {
            System.out.print("\t\t节省：");
            System.out.print(m_Price*Quantity-CalculateCost(Quantity));
        }
    }

    public double CalculateCost(int Quantity)
    {
        switch(m_DiscountState)
        {
            case DISCOUNT_NULL: {
                return m_Price * Quantity;
            }
            case DISCOUNT_BOTH:
            case DISCOUNT_2_FOR_3: {
                return (Quantity / 3 * 2 + Quantity % 3) * m_Price;
            }
            case DISCOUNT_95: {
                return Quantity * m_Price * 0.95;
            }
        }
        return -1;
    }
}
