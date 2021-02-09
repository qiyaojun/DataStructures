package com.qyj.recursion;

/**
 * @Auther YaoJun Qi
 * @Date 2021/02/08 16:36
 * @description
 */
public class Maze {
    public static void main(String[] args) {
        //创建二维数组模拟迷宫
        int[][] map = new int[8][7];
        //使用1表示墙
        for (int i=0 ; i < map[0].length ; i++){
            map[0][i] = 1;
            map[map.length-1][i] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;

        for (int i=0 ; i < map.length ; i++){
            map[i][0] = 1;
            map[i][map[0].length-1] = 1;
        }

        for (int i=0 ; i < map.length ; i++){
            for (int j=0 ; j < map[0].length ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        setWay(map , 1 , 1);

        System.out.println("这是新的地图：");
        for (int i=0 ; i < map.length ; i++){
            for (int j=0 ; j < map[0].length ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 传入形成的迷宫二维数组
     * @param i 从那个位置开始找
     * @param j
     * @return 如果找到通路返回true，没有就false
     */
    public static boolean setWay(int[][] map , int i , int j){
        if(map[6][5] == 2){
            return true;
        }else {
            if(map[i][j] == 0){
                //按照策略 下->右->上->左
                map[i][j] = 2;
                if(setWay(map , i+1 , j)){
                    return true;
                }else if(setWay(map , i , j+1)){
                    return true;
                }else if(setWay(map , i-1 , j)){
                    return true;
                }else if(setWay(map , i , j-1)){
                    return true;
                }else {
                    //说明这个点是走不通的
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
