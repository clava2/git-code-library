import java.util.Scanner;

/**
 * Created by 普通账户 on 2016/7/20.
 */
public class Main {
    public static void main(String args[])
    {
        Print Printer = new Print();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入条形码个数：");
        int n = in.nextInt();
        String[] result = new String[n];
        System.out.println("请输入条形码：");
        result[0] = in.nextLine();
        for(int i = 0;i < n;i++)
        {
            result[i] = in.nextLine();
        }
        BoughtGoods m_Bought = new BoughtGoods();
        m_Bought.Set(result);
        Printer.PrintHead();
        Printer.PrintBody(m_Bought);
        System.out.print("\n");
        Printer.PrintAddition(m_Bought);
        Printer.PrintEnd(m_Bought);
        System.out.print("\n");
        Printer.PrintError();
    }
}
