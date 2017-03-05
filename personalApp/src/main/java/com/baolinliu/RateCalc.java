package com.baolinliu;

/**
 * Created by richey on 16-12-18.
 * 定投复利计算
 */
public class RateCalc {


    public static double basicMoney = 10000;//每次定投金额
    public static int limit = 10;        //定投期限
    public static double rate = 0.05;     //利率

    public static double getAllMoney(double money,int year,double rate){
        if(year == 1){
            return money;
        }else if(year <= limit){
            return getAllMoney(money,year-1,rate) * (1+rate) +basicMoney;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("===============贷款计算================");
        System.out.println("贷款88万,等额本息");
        System.out.println("20年月供5400,30年月供4285,差1100");
        System.out.println("20年总利息42万,30年总利息66万,差额24万");
        System.out.println();
        double AllMoney = getAllMoney(basicMoney,limit,rate);
        System.out.println("每年定存:"+basicMoney+"元(月供一年差出来的钱)");
        System.out.println("年利率"+rate*100+"%");
        System.out.println(limit+"年后,"+"本息总共:"+AllMoney+"元");
        System.out.println("其中本金:"+basicMoney*limit+"元,利息:"+(AllMoney-basicMoney*limit)+"元");
    }


}
