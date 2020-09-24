package com.example.suanfa.recursion;

/**
 * @Author zhourui
 * @Date 2019/12/10 16:20
 */
public class MazeTest {

    public static void main(String[] args){
        // 创建二维数组,模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }

        // 设置挡板, 1表示
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

//        setWay(map, 1, 1);
        setWay2(map, 1, 1);
        System.out.println("小球走过,并标识");
        // 走过的节点
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 使用递归回溯给小球找路
     *
     * @Param map 表示地图
     * @Param i 从哪个位置开始找
     * @Param j
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { // 该点没有走过
                map[i][j] = 2; // 假设可以走通
                if (setWay(map,i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else {
                    map[i][j] = 3; // 走不通,死路
                    return false;
                }
            } else { // map[i][j] != 0
                return false;
            }
        }
    }

    /**
     * 上右下左
     */
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { // 该点没有走过
                map[i][j] = 2; // 假设可以走通
                if (setWay(map,i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    map[i][j] = 3; // 走不通,死路
                    return false;
                }
            } else { // map[i][j] != 0
                return false;
            }
        }
    }
}
