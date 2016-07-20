import sun.awt.SunHints;

/**
 * Created by 普通账户 on 2016/7/17.
 */
public class BoughtData
{
    public static int GetAmount(String BarcodeAndAmount)
    {
        return (BarcodeAndAmount.split("-").length != 2)?1:(Integer.parseInt(BarcodeAndAmount.split("-")[1]));
    }

    public static String GetBarcode(String BarcodeAndAmount)
    {
        return BarcodeAndAmount.split("-")[0];
    }
}
