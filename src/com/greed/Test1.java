package src.com.greed;

import static src.com.greed.Test1.Money.*;

public class Test1 {

    //https://zhuanlan.zhihu.com/p/53334049
    //步骤1：从某个初始解出发；
    //步骤2：采用迭代的过程，当可以向目标前进一步时，就根据局部最优策略，得到一部分解，缩小问题规模；
    //步骤3：将所有解综合起来

    // 硬币找零
    public static void main(String[] args) {
        int sum_money = 41;
        int num_25 = 0, num_10 = 0, num_5 = 0, num_1 = 0;

        while (sum_money >= Money25.num) {
            num_25++;
            sum_money -= Money25.num;
        }

        while (sum_money >= Money10.num) {
            num_10++;
            sum_money -= Money10.num;
        }

        while (sum_money >= Money5.num) {
            num_5++;
            sum_money -= Money5.num;
        }

        while (sum_money >= Money1.num) {
            num_1++;
            sum_money -= Money1.num;
        }

        System.out.println("-------" + num_25 + "-------" + num_10 + "-------" + num_5 + "-------" + num_1);
    }

    public enum Money {
        Money25(25), Money10(10), Money5(5), Money1(1);

        private int num;

        Money(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
