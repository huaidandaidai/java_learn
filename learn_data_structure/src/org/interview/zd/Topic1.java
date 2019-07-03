package org.interview.zd;

/**
 * 玫瑰6元/支，牡丹3元/支，月季1元/3支，给你100元（全部花完）买100支花（三种花全部包含），
 * 请问一共有多少种买法
 */
public class Topic1 {
    public static void main(String[] args) {
        int i=0;
        for(int x=1;x<100;x++){
            for(int y=1;y<100;y++){
                for(int z=1;z<100;z++){
                    int num=x+y+z;
                    int pay=6*x+3*y+z/3;
                    if(num == 100 && pay ==100){
                        i++;
                        System.out.println(x+"=="+y+"=="+z);
                    }
                }
            }
        }
        System.out.println(i);
    }

}
