package org.interview.zd;

/**
 * 水仙花数（指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153），
 * 请在100~999范围内，找出所有满足X^3+Y^3+Z^3=XYZ的数字。
 */
public class Topic2 {
    public static void main(String[] args) {
        for(int x=1;x<10;x++){
            for(int y=0;y<10;y++){
                for(int z=0;z<10;z++){
                    int num1=100*x+10*y+z;
                    int num2=x*x*x+y*y*y+z*z*z;
                    if(num1 == num2){
                        System.out.println(x+""+y+""+z);
                    }
                }
            }
        }
    }
}
