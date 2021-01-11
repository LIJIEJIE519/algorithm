package com.topic2;

/**
 * @Author LJ
 * @Date 2020/12/8
 * msg
 */

public class T_03_findNumberIn2DArray {

    /*
    *   - 从右上角开始，如 == target，结束；
        - 如 > target，剔除当前列
        - 如 < target，剔除当前行
    * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = col-1;
        while (i < row && j >=0 ) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
