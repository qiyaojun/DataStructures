package com.qyj;

import java.io.*;

/**
 * @Auther YaoJun Qi
 * @Date 2020/12/31 10:32
 * @description 二维数组、稀疏数组转换
 */
public class SparseArray {

    //文件夹路径
    private static final String folderUrl= "d:/1";
    //文件路径
    private static final String fileUrl= "d:/1/save.data";

    public static void main(String[] args) throws Exception{
        //二维数组11*11
        //0：表示没有棋子 1：表示黑子 2：表示篮子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        int num = 0;
        System.out.println("原始的二维数组：");
        for (int[] ints : chessArr1){
            for (int item : ints){
                System.out.printf("%d\t",item);
                if(item!=0){
                    num++;
                }
            }
            System.out.println();
        }

        int[][] sparseArr1 = new int[num+1][3];
        sparseArr1[0][0] = chessArr1.length;
        sparseArr1[0][1] = chessArr1[0].length;
        sparseArr1[0][2] = num;
        int count = 0;
        for (int i=0 ; i< chessArr1.length ; i++){
            for (int j=0 ; j< chessArr1[0].length ; j++){
                if(chessArr1[i][j]!=0){
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println("稀疏数组：");
        for (int[] ints : sparseArr1){
            for (int item : ints){
                System.out.printf("%d\t",item);
                if(item!=0){
                    num++;
                }
            }
            System.out.println();
        }

        //保存稀疏数组到磁盘
        save(sparseArr1);
        //从磁盘读取稀疏数组
        int[][] sparseArr2 = get();

        //将稀疏数组转换为二维数组
        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i=1 ; i< sparseArr2.length ; i++){
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }

        System.out.println("转化的二维数组：");
        for (int[] ints : chessArr2){
            for (int item : ints){
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }

    /**
     * 使用对象流保存文件到本地磁盘
     * @param sparseArr1
     * @throws Exception
     */
    public static void save(int[][] sparseArr1) throws Exception{
        File dir = new File(folderUrl);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(fileUrl);
        file.createNewFile();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(sparseArr1);
        oos.close();
    }

    /**
     * 使用对象流读取文件
     * @return
     * @throws Exception
     */
    public static int[][] get() throws Exception{
        File file = new File(fileUrl);
        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
        Object o = oos.readObject();
        oos.close();
        return (int[][])o;
    }
}
