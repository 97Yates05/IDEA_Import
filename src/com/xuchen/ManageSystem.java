package com.xuchen;

import java.util.Scanner;

import static java.lang.Boolean.TRUE;

public class ManageSystem {         //管理系统类
    public void notice() {          //方法用于显示提示信息菜单
        System.out.println("*******************************" + "\n"
                + "\t\t1--插入数据" + "\n"
                + "\t\t2--显示所有数据" + "\n"
                + "\t\t3--在指定位置处插入数据" + "\n"
                + "\t\t4--查询能被3整除的数据" + "\n"
                + "\t\t0--退出" + "\n"
                + "*******************************" + "\n "
                + "请输入对应的数字进行操作");

    }

    public int[] insertData(ManageSystem us) {      //方法用于插入前9个数据
        int[] a = new int[10];
        System.out.println("(总共可以输入9个数据)");
        for (int i = 0; i < 9; i++) {
            System.out.println("请输入第" + (i + 1) + "个数据");
            int c = us.judge(us);
            if (c == 0) {
                System.out.println("添加数据不能为0，请重新输入");
                i--;
            } else {
                a[i] = c;
            }

        }
        return a;


    }

    public void showData(int[] a) {                 //方法用于显示所有数据
        if (a[0] == 0) {
            System.out.println("还未插入数据，请先插入数据");
        } else if (a[9] == 0) {
            System.out.print("数组元素为：");
            for (int i = 0; i < 9; i++) {
                System.out.print("\t" + a[i]);
            }
        } else {
            System.out.print("数组元素为：");
            for (int n : a) {
                System.out.print("\t" + n);
            }
        }
        System.out.println();
    }

    public void insertAtArray(int[] a, int n, int k) {      //方法用于指定位置出插入数据
        int t = a[k];
        a[k] = n;
        for (int i = 0; i < 9 - k; i++) {
            if (i == 8 - k) {
                a[k + 1] = t;
                break;
            }

            a[9 - i] = a[8 - i];
        }
    }

    public void divThree(int[] a) {                 //方法用于判断能被3整除的数据
        int b = 0;
        for (int n : a) {
            if (n % 3 == 0 && n != 0) {
                b++;
                if (b == 1) {
                    System.out.print("能被3整除的数为：");
                }
                System.out.print("\t" + n);
            }
        }
        if (b == 0) {
            System.out.print("没有能被3整除的数");
        }
        System.out.println();
    }

    public int judge(ManageSystem us) {         //方法用于判断用户输入类型是否为int型数据，是则返回该值，不是提示重新输入
        int a = 2;
        while (TRUE) {
            try {
                Scanner aa = new Scanner(System.in);
                a = aa.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("异常警告：请不要输入非int类型的数据！！！");

            }


        }
        return a;
    }


    public static void main(String[] args) {            //主方法
        int a;
        ManageSystem us = new ManageSystem();
        int[] b = new int[10];
        us.notice();
        while (TRUE) {                              //程序循环执行起点
            a = us.judge(us);

            while (TRUE) {          //判定a的范围在0~4后跳出循环，否则提示重新输入
                if (a < 0 || a > 4) {
                    System.out.println("请重新输入(提示：0~4)");
                    us.notice();
                } else {
                    break;
                }
            }

            if (a == 0) {
                System.out.println("退出程序！");
                break;
            }

            switch (a) {            //switch结构判定执行操作并调用相应的方法
                case 1:
                    b = us.insertData(us);
                    us.showData(b);
                    us.notice();
                    break;
                case 2:
                    us.showData(b);
                    us.notice();
                    break;
                case 3:
                    if (b[9] != 0) {
                        System.out.println("数组已满，无法插入！");
                        break;
                    }
                    System.out.println("请输入要插入的数据");
                    int n = us.judge(us);
                    System.out.println("请输入要插入的位置（0~9）");
                    int k = us.judge(us);
                    while (TRUE) {
                        if (k < 0 || k > 9) {
                            System.out.println("插入位置错误，请重新插入");
                            k = us.judge(us);
                        } else {
                            break;
                        }
                    }

                    us.insertAtArray(b, n, k);
                    us.showData(b);
                    us.notice();
                    break;
                case 4:
                    us.divThree(b);
                    us.notice();
                    break;


            }

        }

    }
}
