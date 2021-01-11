# algorithm

牛客IOC

https://ac.nowcoder.com/acm/contest/5652#question



牛客题霸-求职必刷题

https://www.nowcoder.com/ta/job-code



按公司刷题

https://leetcode-cn.top/#/home

# leetcode

## easy

#### 1. 两数之和

**加法变减法**

```
* 1. 使用hashmap:查找元素为O(1)
* 2. b = tar-a is in nums
```

#### 7. int数反转

```
* 1. 数字反转，123-->321：*升位 /降位 %取个位
* 2. 防止溢出：ans溢出/10一定不等于temp=ans*10 
```

#### 13. 罗马数字

用**字典保存**每种情况，依次遍历；

#### 14. 最长公共前缀  

两两词比较得公共串，公共串在与后面词继续比较

#### 20. 有效的括号

左括号入栈，遇右括号出栈；HashMap作匹配

```java
public static void main(String[] args) {
  // 双端队列--栈
  Deque<Object> stack = new LinkedList<>();
  // 入栈
  stack.push(1);
  // 获取栈顶元素
  System.out.println(stack.peek());
  // 出栈
  stack.pop();
  System.out.println(stack.peek());

  // 队列
  Queue<Object> queue = new LinkedList<>();
}
```



#### 26. 删除排序数组中的重复项 : 

- **排序数组**

#### 27. 移除元素  ；返回新长度

1. 原地操作：
   1. 重复：两个指针监听：一个指向唯一，另一个找唯一；
   2. 当不相等时，将新唯一赋予当前下一个元素，新唯一变唯一

2. 移除val：
   1. 重点：元素的顺序可以改变
   2. 思路：两个指针i、j，i 找val, 另一个j从后面找不是val填充 i 的val
   3. 处理边界值

#### 28. 匹配字串：KMP

1. 适用于重复字符串

2. https://www.zhihu.com/question/21923021

3. 简言之，以图中的例子来说，在 i 处失配，那么主字符串和模式字符串的前边6位就是相同的。又因为模式字符串的前6位，它的前4位前缀和后4位后缀是相同的，所以我们推知主字符串i之前的4位和模式字符串开头的4位是相同的。就是图中的灰色部分。那这部分就不用再比较了。

4. <img src="https://pic4.zhimg.com/v2-03a0d005badd0b8e7116d8d07947681c_r.jpg?source=1940ef5c" alt="preview" style="zoom: 50%;" />

5. 在把PMT【部分匹配表(Partial Match Table)】进行向右偏移时，第0位的值，我们将其设成了-1，这只是为了编程的方便，并没有其他的意义。在本节的例子中，next数组如下表所示。

   <img src="https://pic4.zhimg.com/50/v2-40b4885aace7b31499da9b90b7c46ed3_hd.jpg?source=1940ef5c" alt="img" style="zoom:50%;" />

#### 35. 搜索插入位置

给定一个**排序数组**和一个**目标值**，在数组中***找到*目标值，并返回其索引**。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

-----

> # **查找题**

1. 二分法

   ```java
   while (l <= r) {
     // int mid = (l+r)/2;		// 拒绝使用，l+r可能超出整型溢出
     int mid = l + (r - l) / 2;		// (l+r)/2 = l + (r - l) / 2；不会溢出
     if (nums[mid] >= target) {
       r = mid-1;
     } else {
       l = mid+1;
     }
   }
   return l;
   ```

   - mid = (l + r) / 2的劣势:
     - 溢出
     - 求上下界会不统一
   - mid = l + (r - l) / 2
     - 减法替代了加法
     - 除法代替乘法

#### 38. 外观数列

1. 递归

2. - String 是final对象，不会被修改，每次使用 + 进行拼接都会创建新的对象，而不是改变原来的对象；`速度最慢`

   * 2.StringBuffer 可变字符串，主要用于字符串的拼接，`属于线程安全的`；
     * 因为方法加入了`synchronized`关键字，是一种同步锁
   * 3.StringBuilder 可变字符串，主要用于字符串的拼接，属于线程不安全的；`速度最快`

#### 53. 最大子序和

1.     * 只考虑当前 nums[i], 上一个值的最大值+当前值是否大于当前值，
       * 是，则加入到子数组； 否，则当前值更大
       * 比较大小用Math.max();

#### 67. 二进制求和

1. ```java
   // 2进制转10进制
   System.out.println(Integer.parseInt("11", 2));
   // 10进制转2进制
   System.out.println(Integer.toBinaryString(10));
   ```

2. 加一个carry获取进位， carry % 2当前答案，carry/2当前答案； 遍历完carry!=0在加1

#### 69. x的平方根

1. 二分法

   ```java
   public int mySqrt(int x) {
     int l = 0, r = x, ans = 0;
     while(l <= r) {
       /*
        * 拒绝使用，l+r可能超出整型溢出
        * */
       // int mid = (l+r)/2;
   
       /*
        * 加法变减法的思想
        * (l+r)/2 = l + (r - l) / 2；不会溢出
        * */
       int mid = l + (r - l) / 2;
       /*
        * if (mid <= x * 1.0 / mid)  乘法变除法思想
        * 错误(long)(mid * mid)  已经溢出
        * */
       if ((long)mid * mid <= x) {
         ans = mid;
         l = mid + 1;
       } else {
         r = mid - 1;
       }
     }
     return ans;
   }
   ```


#### 70. 爬楼梯

​	假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

```java
    /*
    * 1. 递归--dfs
    * 超时
    * */

    public int climbStairs(int n) {
        if (n == 0) return 1;       // 1，1，1
        if (n < 0) return 0;
        int ans = 0;
        // 1 or 2 steps
        for (int i = 1; i <=2; i++) {
            ans += climbStairs(n-i);
        }
        return ans;
    }


    /*
    * 动态规划
    * f(x) = f(x-1) + f(x-2)
    * 理解为：一共n阶台阶，到最后一个选择时，有两种选择：【无视前面走法， 例如4】
    *       ​ 1.走一步【1,1,1; 1,2; 2,1] -> 1
    *       ​ 2.走两步【1,1; 2】-> 2
    * */

    public int climbStairsD(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }

```

2. 斐波那契数列:

   ![image-20201022205942514](/Users/star/Library/Application Support/typora-user-images/image-20201022205942514.png)

#### 100. 相同的树

1. 二叉树的遍历

   - dfs：
     - 递归：trav(root.left), trav(root.right);
     - 栈：push(root), pop(top); push(top.right), push(top.left), pop(top); push....

   ```java
   /**
    * Definition for a binary tree node.
    * public class TreeNode {
    *     int val;
    *     TreeNode left;
    *     TreeNode right;
    *     TreeNode() {}
    *     TreeNode(int val) { this.val = val; }
    *     TreeNode(int val, TreeNode left, TreeNode right) {
    *         this.val = val;
    *         this.left = left;
    *         this.right = right;
    *     }
    * }
    */
   class Solution {
       public boolean isSameTree(TreeNode p, TreeNode q) {
           /*
            * 包含：两者均为空 ； 或者其中一个为空
           */
           if (p == null || q == null)
               return p == q;
           // dfs[深度搜索]--递归
           return p.val == q.val &&
                   isSameTree(p.left, q.left) &&
                   isSameTree(p.right, q.right);
       }
   }
   ```

#### 101. 对称二叉树

1. **引入一个队列，这是把递归程序改写成迭代程序的常用方法**

2. 队列

   ```java
   Queue<TreeNode> queue = new LinkedList<>();
   
   add  增加一个元索   如果队列已满，则抛出一个IIIegaISlabEepeplian异常
   offer  添加一个元素并返回true  如果队列已满，则返回false
   put  添加一个元素 如果队列满，则阻塞
   
   remove   移除并返回队列头部的元素     如果队列为空，则抛出一个NoSuchElementException异常
   poll  移除并返问队列头部的元素 如果队列为空，则返回null
   take 移除并返回队列头部的元素
   
   element  返回队列头部的元素   如果队列为空，则抛出一个NoSuchElementException异常
   peek       返回队列头部的元素   如果队列为空，则返回null
   ```


#### 104. 二叉树的最大深度

1. 递归遍历，DFS深度优先搜索

   - 左子树和右子树的最大深度 L 和 R，那么该二叉树的最大深度即为

   - max(l,r)+1

     ```java
     public int maxDepth(TreeNode root) {
     	return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
     }
     ```

2. 广度优先搜索

   - 队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展

     ```java
     public int maxDepth(TreeNode root) {
       if (root == null)
         return 0;
       Queue<TreeNode> queue = new LinkedList<>();
       int ans = 0;
       // 加入第一层根节点
       queue.offer(root);
       // 判断队列是否为空，即遍历完所有节点
       while(!queue.isEmpty()) {
         // 获得该层节点的数目
         int size = queue.size();
         // 遍历该层节点，添加下层节点，删除本层节点
         while(size > 0) {
           // 头节点出对
           TreeNode t = queue.poll();
           // 本层节点减1
           size--;
           // 加入左右不为null节点
           if (t.left != null)
             queue.offer(t.left);
           if (t.right != null)
             queue.offer(t.right);
         }
         // 层数+1
         ans += 1;
       }
       return ans;
     }
     ```

#### 107. 二叉树的层次遍历 II

1. ```java
   class Solution {
       public List<List<Integer>> levelOrderBottom(TreeNode root) {
           /*层次遍历， 往结果集头部插*/ 
         	// List无addFirst方法
           LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
           if (root == null)
               return result;
           Queue<TreeNode> queue = new LinkedList<>();
           queue.offer(root);
   
           while (!queue.isEmpty()) {
               int size = queue.size();
               List<Integer> temp = new ArrayList<>();
               while (size > 0) {
                   TreeNode curr = queue.poll();
                   temp.add(curr.val);
                   TreeNode l = curr.left, r = curr.right;
                   if (l != null)
                       queue.offer(l);
                   if (r != null)
                       queue.offer(r);
                       size--;
               }
               result.addFirst(temp);
               // result.add(0, temp);
           }
           return result;
       }
   }
   ```



#### 108. 将有序数组转换为二叉搜索树

1. ```java
   public class E_108_sortedArrayToBST {
       /*
       * 思路：递归，总选数组的中间点作为根节点，即中序遍历
       * 排序数组
       * */
       public TreeNode sortedArrayToBST(int[] nums) {
           if (nums.length == 0)
               return null;
           if (nums.length == 1)
               return new TreeNode(nums[0]);
   
           // 选择数组中间节点
           int mid = nums.length / 2;
           // 为根节点
           TreeNode tree = new TreeNode(nums[mid]);
           // 左半数组[0, mid]为左节点
           tree.left = sortedArrayToBST(Arrays.copyOf(nums, mid));
           // 右办数组[mid, length]为右节点
           tree.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
           return tree;
       }
   }
   ```

#### 110. 平衡二叉树

1. ```java
   public boolean isBalanced(TreeNode root) {
           return test(root) != -1; 
       }
   
       // -1代表不是平衡二叉树
       public int test(TreeNode root) {
           if (root == null)
               return 0;
           int l = test(root.left);
           if (l == -1)
               return -1;
           int r = test(root.right);
           if(r == -1)
               return -1;
           // 判断当前是否为平衡二叉树，如是，高度+1
           return Math.abs(l-r) <= 1 ? Math.max(l, r)+1 : -1;
       }
   ```




## mid

### 6. Z 字形变换

```java
/*
* 思路，用数组装
* 在第 0 行或 numR-1 行时换方向【想到首尾】
* 向下加 换方向 向上加
*/
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows < 2)
            return s;
        // 装每一行
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++)
            // 留意该种初始化 rows.get(i) = new StringBuilder();【final,错误】
            rows.add(new StringBuilder());
        
        /*
        * mark代表行标-上下来回，
        * flag换方向【1为向下,-1为向上；0行刚好变号，所以初始为-1】
        */ 
        int mark = 0, flag = -1;
        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // 换方向
            if(mark == 0 || mark == numRows-1) {
                flag = -flag;
            }
            // 每行加对应字符
            rows.get(mark).append(s.charAt(i));
            // 很巧妙【来回传递】
            mark += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows)
            res.append(sb);
        return res.toString();
    }
}
```



### 31. 下一个排列

```java
class Solution {
    /*
    * 思路：
    * 1. 从后找倒叙【不是倒叙的标志位】
    * 2. 在倒叙中找刚好大于nums[mark]的数进行交换
    * 3. 交换之后在将倒叙数变正序变最小
    */
    public void nextPermutation(int[] nums) {
        // 指向当前非倒叙数
        int mark = nums.length-2;
        // 从后找倒序mark
        for (; mark >=0; mark--) {
            // 找到非倒叙位
            if (nums[mark] < nums[mark+1]) {
                break;
            }
        }
        if (mark >= 0) {
            // 找倒叙中找刚好大于nums[mark]的
            for (int i = nums.length-1; i > mark; i--) {
                if (nums[i] > nums[mark]) {
                    swap(nums, i, mark);
                    break;
                }
            }
            
        }
        // 将倒叙变正序变为最小
        int i = nums.length-1;
        int j = mark+1;
        while (j < i) {
            swap(nums, i, j);
            i--;
            j++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 43. 字符串相乘

- 大数相乘-字符串模拟

<img src="https://pic.leetcode-cn.com/171cad48cd0c14f565f2a0e5aa5ccb130e4562906ee10a84289f12e4460fe164-image.png" alt="img" style="zoom:50%;" />

```java
class Solution {
    // 字符串表达的数字上模拟乘法
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int lena = num1.length();
        int lenb = num2.length();
        // 相乘最大位数【i保存进位，i+1为相乘位】,初始为0
        int ans[] = new int[lena+lenb];
        /*
            123
           * 45
        ---------
        */
        // 从后向前提取字符乘
        for (int i = lena-1; i >= 0; i--) {
            int a = num1.charAt(i)-'0';
            for (int j = lenb-1; j >= 0; j--) {
                int b = num2.charAt(j)-'0';
                // 进位 + 相乘值
                int res = ans[i+j+1] + a*b;
                ans[i+j+1] = res%10;     // 相乘值个位
                ans[i+j] += res/10;       // 相乘值进位 + 之前进位
            }
        }
        StringBuilder sb = new StringBuilder();
        // 从前往后不用乘
        for (int i = 0; i < ans.length; i++) {
            // 123*100 首位可能不为0
            if (i == 0 && ans[i] == 0)
                continue;
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}
```



### 48. 旋转图像

- 二维矩阵技巧
  - 水平、对角翻折

```java
class Solution {
    /*
       1. 先水平翻折
       2. 在沿对角线翻折
    */ 
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int temp = 0;
        // 必须只翻折一半，否则又翻折回原来了
        for(int i = 0; i < m / 2; i++) {
            for (int j = 0; j < m; j++) {
                // 水平翻折
                temp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];
                matrix[m-i-1][j] = temp;
            }
        }

        for(int i = 0; i < m; i++) {
            // 只遍历下三角
            for (int j = 0; j < i; j++) {
                // 主对角线翻转
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
```



### 114. 二叉树展开为链表

- 给定一个二叉树，[原地](https://baike.baidu.com/item/原地算法/8010757)将它展开为一个单链表。
- 思想很重要

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
      	// 很重要 
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }
}
```



### 50. Pow(x, n)

- 快速幂
- 位运算技巧
  - n % 2==1 等价于 奇数==判断二进制最右位 n&1 是否为1
  - n = n/2 : 等价于 右移一位 n>>1 ；
- 二进制

```java
class Solution {
    /*
        1. 快速幂
        2. x→x^2→x^4→x^9→x^19→x^38→x^77【右到左看】
        3. 递归只考虑正数：负--> 1.0/-n
    */ 
    public double myPow(double x, int n) {
        // -2^31 转正
        long N = n;
        return N > 0 ? iter(x, N) : 1.0/iter(x, -N);
    }
    /*
        迭代，位运算技巧[二进制]
        x^n = x*(n的二进制迭代次)
        5^3 = 5^(11)
    */ 
    public double iter(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            // 奇数==判断二进制最右位 n&1 是否为1
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            // 等价于 右移一位 n>>1 ；
            N /= 2;
        }
        return ans;
    }

    /*
        根据递归计算的结果，如果 n为偶数，那么 x^n=y^2；如果 n为奇数，那么 x^n=y^2∗x；    
    */ 
    public double help(double x, long n) {
        if (n == 0)
            return 1.0;
        double y = help(x, n/2);
        return n % 2 == 0 ? y*y : y*y*x;
    }
}
```









## 排序

### 215. 数组中的第K个最大元素

- 最小堆--O(nlogn)
- 快排 patition--O(n)：需要随机

```java
class Solution {

    private static Random random = new Random(System.currentTimeMillis());

    /*
    * 优先队列最小堆实现【第 2 大数，即维护堆中只有两个数，每次移除堆顶最小数，到最后堆顶元素极为第二大数】
    */
    public int findKthLargest(int[] nums, int k) {
        // 默认最小堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer n : nums) {
            queue.add(n);
            // 保持堆中只有 k 个元素
            if (queue.size() > k) {
                // 移除堆顶元素
                queue.poll();
            }
        }
        // 返回堆顶元素
        return queue.peek();
    }

    // 每排一次至少一个归位
    public int findKthLargest1(int[] nums, int k) {
        // 该元素的坐标
        int target = nums.length - k;
        int a = 0;
        int b = nums.length-1;
        while(true) {
            int mark = patition(nums, a, b);
            if (mark == target) {
                return nums[mark];
            }
            // 只排一半
            if(mark < target) {
                a = mark+1;
            } else {
                b = mark-1;
            }
        }
    }

    // 快排
    public int patition(int[] nums, int start, int end) {
        // 在区间随机选择一个元素作为标定点
        if (end > start) {
            int randomIndex = start + 1 + random.nextInt(end - start);
            swap(nums, start, randomIndex);
        }

        int pivot = nums[start];
        int mark = start;
        for(int i = start+1; i <= end; i++) {
            if (nums[i] < pivot) {
                mark++;
                swap(nums, mark, i);
            }
        }
        swap(nums, start, mark);
        return mark;
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
```





## 双指针

- 排序
- 左右指针【L++,R--】
- 


### 11. 盛最多水的容器

```java
class Solution {
    /*
    * S = min(H_i,H_j) * index
    * 思路：双指针法
    * 1. 移动板，index = index-1一定减少，所以看移动长板还是短版
    *   假如移动长板，短板只会不变或更小，所以 S 一定不会增大
    *   在看移动短板，短板可能增大、不变、减少，所以S可能增大
    */
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1, max = 0;
        while(l < r) {
            int s = Math.min(height[l], height[r]) * (r-l);
            max = Math.max(max, s);
            
            if (height[l] > height[r])
                r--;
            else
                l++;
        } 
        return max;
    }
}
```

### 15. 三数之和

```java
class Solution {

    /*
    * 排序 + 双指针i l=i+1,r;
    * 当当前index与上一个index相同时，说明已经用过该方式，重复，跳下一个【-1，-1，0，1，2】
    */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) return list;

        Arrays.sort(nums);
        if (nums[0] > 0) return list;

        for (int i = 0; i < nums.length-1; i++) {
            // 当前index与上一个index相同时，说明已经用过该方式，重复【-1，-1，0，1，2】
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i]+nums[l]+nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if(sum < 0) {
                    l++;
                }else{
                    r--;
                }
            }
        }
        return list;
    }

}
```



## 二分法

### 33. 搜索旋转排序数组

看153

```java
class Solution {
    /*
    * 思路：考虑中间节点与首节点是否有序
    * 即考虑：以中点-->不是左半边有序，就是右半边有序
    */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid = nums[0];
        while(l <= r) {
            mid = l + (r-l)/2;
            if (nums[mid] == target)
                return mid;
            /*
            * 中间节点与首节点有序
            * 1. [1,2,3,4,5]
            * 2. [4,5,6,7,0,1,2]
            */
            // 左半边有序
            if (nums[0] <= nums[mid]) {
                
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            // 右半边有序[4,5,6,0,1,2,3]
            else {
                if (nums[mid] < target && target <= nums[nums.length-1]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
```



### 34. 在排序数组中查找元素的第一个和最后一个位置

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length-1])
            return new int[]{-1,-1};

        int leftIdx = binarySearch(nums, target, true);
        if (nums[leftIdx] == target) {
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length) {
                return new int[]{leftIdx, rightIdx};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     *
     * @param nums      数组
     * @param target    待查找目标数，如果存在，返回其索引；如果不存在，返回第一个大于target的索引
     * @param firstBig     false-查找目标数的索引; true-查找第一个大于target的索引
     * @return
     */
    public int binary(int[] nums, int target, boolean firstBig) {
      int l = 0, r = nums.length-1;
      while (l <= r) {
        int mid = l + (r-l)/2;
        /*
        *	(nums[mid] > target)返回刚好大于target的第一个索引
        * (nums[mid] >= target)返回target的索引
        */ 
        if (nums[mid] > target || (!firstBig && nums[mid] >= target)) {
          r = mid-1;
        } else {
          l = mid+1;
        }
      }
      return l;
    }
}
```



### 153. 寻找旋转排序数组中的最小值

输入：nums = [3,4,5,1,2]
输出：1

```java
class Solution {
    // 二分查找：
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int mid = l + (r-l)/2;
            // num[mid] 一定不是最小值
            if (nums[mid] > nums[r]) {
                l++;
            } else {
                // mid 可能为最小值
                r--;
            }
        }
        return nums[l];
    }
}
```







## 贪心算法

### 392. 判断子序列

```java
class Solution {
    // 贪心--判断s[i]是否在t中， 更快，优先匹配最先遇到的【s="abc", t="asdbadsc"】
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            // 保存相对位置【点睛之笔】
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }

    // 双指针法
    public boolean isSubsequence1(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            } 
            j++;
        }
        if (i == s.length()) 
            return true;
        return false;
    }
}
```



### 435. 无重叠区间-参加会议

```java
class Solution {

    /*
    * 贪心算法
    一天有好多活动，你可以选择不重叠的时间参加多个活动。

    按照活动结束的时间排序后（不管开始得多早，都不如选择早点结束的活动，这样还能继续选其他活动）
        假设当前参加的是活动A，如果活动B的开始时间大于等于活动A的结束时间，则继续参加B活动。
        这时活动数+1，后面的活动开始时间要和活动B结束的时间进行比较，所以活动结束的时间更新为活动B结束的时间。

    */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;
        // lambda, 按第二位排序，很慢
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
      	//Comparator.comparingInt(a -> a[1]) Comparator.compare(a -> a[1]) (a,b)->Integer.compare(a[1],b[1])
      	// 避免使用 return o1[1] - o2[1]; 这种减法操作，防止溢出。
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1]) ? -1 : (o1[1] == o2[1]) ? 0 : 1;
            }
        });
        // 一定有一个会议可以参加
        int res = 1;
        // 结束最早的会，排序之后为第一个
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            // 下一个会开始时间
            int start = intervals[i][0];
            // 是否可以参加下一个会议
            if (start >= end) {
                res++;
                // 该长会议结束时间
                end = intervals[i][1];
            }
        }
        return intervals.length - res;
    }
}
```





## 回溯

**当题目中出现 “所有组合” 等类似字眼时，第一感觉就要想到用回溯。**



### 17. 电话号码的字母组合

`回溯完一次，删除上一个加的元素【a, 从b开始】---即回溯【DFS】`

```java
class Solution {
    // 映射集
    private String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    // 结果集
    private List<String> res;
    // 路径集
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return res;
        findCombination(digits, 0);
        return res;
    }
    // 回溯方法 --> 递归
    public void findCombination(String digits, int index) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        // 获取映射集值 2->abc
        String val = map[digits.charAt(index)-'0'];
        for(char c : val.toCharArray()) {
            sb.append(c);
            findCombination(digits, index+1);
            // 回溯完一次，删除上一个加的元素【a, 从b开始】---即回溯【DFS】
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
```

![算法过程.png](https://pic.leetcode-cn.com/38567dcbb6401d88946ca974aacffb5ab27cb1ad54056f02b59016c0cc68b40f-file_1562774451350)<img src="README.assets/image-20201223113342665.png" alt="image-20201223113342665" style="zoom:20%;" />



### 22. 括号生成

```java
/*
* 当题目中出现 “所有组合” 等类似字眼时，第一感觉就要想到用回溯。
*/
class Solution {
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        help(n, 0, 0);
        return list;
    }
    // 回溯法
    public void help(int n, int left, int right) {
        if (sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }
        // 添加左括号
        if (left < n) {
            sb.append("(");
            help(n, left+1, right);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }
        // 添加右括号【留意，需有左括号才有右括号】
        if (right < left) {
            sb.append(")");
            help(n, left, right+1);
            // 回溯
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
```



### 39. 组合总和

- 无重复

```java
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> line = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        help(candidates, target, 0, 0);
        return list;
    }

    public void help(int[] nums, int target, int sum, int index) {
        if (sum >= target) {
            if (sum == target)
                // 递归下需要 new ArrayList<Integer>(line)
                list.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            line.add(nums[i]);
            sum += nums[i];
            // index不能让其返回找[2,2,3]->[2,3,2]
            help(nums, target, sum, i);
            line.remove(line.size()-1);
            sum -= nums[i];
        }
    }
  
  	// 升序剪枝
    public void helpSort(int[] nums, int target, int sum, int index) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            line.add(nums[i]);
            sum += nums[i];
            if (sum > target) {
                line.remove(line.size()-1);
                sum -= nums[i];
                return;
            }
            // index不能让其返回找[2,2,3]->[2,3,2]
            helpSort(nums, target, sum, i);
            line.remove(line.size()-1);
            sum -= nums[i];
        }
    }
}
```



### 40. 组合总和 II--去重

- 思想来自第15题-三和之和
- [1,1,2,5,6,7,10] target=8

```java
class Solution {
    // 利用Set去重，效率差
    // Set<List<Integer>> list = new HashSet<>();
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> line = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      	// 排序是前提
        Arrays.sort(candidates);
        if (candidates[0] > target)
            return list;
        helpSort(candidates, target, 0, 0);
        return list;
    }

    // 升序
    public void helpSort(int[] nums, int target, int sum, int index) {
        if (sum == target) {
            list.add(new ArrayList<Integer>(line));
            return;
        }
        for(int i = index; i < nums.length; i++) {
            /*
            * 去重，同 15题
            * [1,1,2,5,6,7,10](8) -> [[1,1,6],[1,2,5],[1,7],[1,2,5],[1,7],[2,6]]
            */
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            line.add(nums[i]);
            sum += nums[i];
            if (sum > target) {
                line.remove(line.size()-1);
                sum -= nums[i];
                return;
            }
            // index不能让其返回找[2,2,3]->[2,3,2]
            helpSort(nums, target, sum, i+1);
            line.remove(line.size()-1);
            sum -= nums[i];
        }
    }
}
```

### 46. 全排列-标记

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

- 非标记：[1,1,1]

```java
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> line = new ArrayList<>();
    // 解决重复使用，标记该序是否已经使用
    int[] used;     
    public List<List<Integer>> permute(int[] nums) {
        used = new int[nums.length];
        help(nums);
        return list;
    }

    public void help(int[] nums) {
        // 全排列
        if (line.size() == nums.length) {
            // Java为值传递
            list.add(new ArrayList<>(line));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 该序未使用
            if (used[i] == 0) {
                line.add(nums[i]);
                used[i] = 1;
                help(nums);
                // 回溯
                used[i] = 0;
                line.remove(line.size()-1);
            }
            
        }
    }
}
```



### 47. 全排列 II：去重+标记

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

- 未使用标记used：收集为空
- 未使用去重：`if (i != 0 && nums[i] == nums[i-1])`
  - [[1,1,2],[1,2,1],[1,1,2],[1,2,1],[2,1,1],[2,1,1]]

```java
class Solution {
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    List<Integer> line = new ArrayList<>();
    // 解决重复使用，标记该序是否已经使用
    int[] used;     
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new int[nums.length];
        help(nums);
        return list;
    }

    public void help(int[] nums) {
        // 全排列
        if (line.size() == nums.length) {
            // Java为值传递
            list.add(new ArrayList<>(line));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 也正确，较慢【1,1,2 : 用在第二次收集】
            // if (i != 0 && nums[i] == nums[i-1] && used[i-1] == 1)

            // 去重+标记【1,1,2 : 用在第一次收集】
            if (i != 0 && nums[i] == nums[i-1] && used[i-1] == 0)
                continue;
            // 该序未使用
            if (used[i] == 0) {
                line.add(nums[i]);
                used[i] = 1;
                help(nums);
                // 回溯
                used[i] = 0;
                line.remove(line.size()-1);
            }
            
        }
    }
}
```







## 分治法

- **构建多个+递归**
- `List<T> list = new ArrayList<>();`

### 95. 不同的二叉搜索树 II

```
输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<>();
        return help(1, n);
    }
		// 构建多棵树
    public List<TreeNode> help(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            // ArrayList可添加 null 并遍历
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++) {
            // 左子树集合
            List<TreeNode> ls = help(start, i-1);
            // 右子树集合
            List<TreeNode> rs = help(i+1, end);
            // 进行组合
            for(TreeNode l : ls) {
                for(TreeNode r : rs) {
                    // 构建新树,root的左右子树一直在更新，如果每次不新建一个root，就会导致num个root为根节点的树都相同。
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }

    // 平衡树
    public TreeNode buildATree(int start, int end) {
        if(start > end)
            return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(mid);
        root.left = buildATree(start, mid-1);
        root.right = buildATree(mid+1, end);
        return root;
    }
}
```



### 241. 为运算表达式设计优先级

```
输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```

```java
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return help(input);
    }

    public List<Integer> help(String input) {
        List<Integer> list = new ArrayList<>();
        // 是否纯数字
        boolean f = true;
        int res = 0;
        for(int i = 0; i < input.length()-1; i++) {
            char c = input.charAt(i);
            // 包含运算符
            if (c == '+' || c == '-' || c == '*') {
                f = false;
                // substring(s,e) 不包含e
                // 左集合
                List<Integer> l_list = help(input.substring(0, i));
                // 右集合
                List<Integer> r_list = help(input.substring(i+1, input.length()));
                for(Integer l_res : l_list) {
                    for (Integer r_res : r_list) {
                        switch(c) {
                            case '+' : res = l_res + r_res;break;
                            case '-' : res = l_res - r_res;break;
                            case '*' : res = l_res * r_res;break;
                        }
                        list.add(res);
                    }
                }
                
            }
        }
        // 如果存数字
        if (f) {
            list.add(Integer.valueOf(input));
        }
        return list;
    }
}
```







## 二叉树

#### `递归，队列，再看看先、中、后序遍历合不合要求`



### 剑指 Offer 26. 树的子结构

```java
class Solution {
    /*
    * 思路：先序遍历【两个递归】
    *   1. 根相同，则当前树可能包含
    *   2. 否则，可能左子树包含，或者，可能右子树包含
    */ 
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        // 先序遍历
        boolean fir = false, l = false, r = false;
        // [4,2,3,4,5,6,7,8,9]
        // [4,8,9]
        // 不能if-else 直接判断根
        return help(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean help(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null || a.val != b.val)
            return false;
        return help(a.left, b.left) && help(a.right, b.right);
    }
}
```



### 94. 二叉树的中序遍历

```java
class Solution {
    // 记录
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        return list;
    }
		// 中序遍历
    public void help(TreeNode root) {
        if (root == null)
            return;
        help(root.left);
        list.add(root.val);
        help(root.right);
    }
}
```

### 98. 验证二叉搜索树

**中序遍历对应二叉搜索树为升序则为正确的【左，根，右】**

```java
class Solution {
    // 记录上一个节点的值，初始值为Long的最小值
    long pre = Long.MIN_VALUE; 

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    // 中序遍历为升序则为正确的【左，根，右】
    private boolean inorder(TreeNode node) {
        if(node == null) 
            return true;
        // 中序遍历
        boolean l = inorder(node.left);
        // 如果当前值小于上一个遍历到的节点值，则不为升序，则false
        if(node.val <= pre) 
            return false;
        pre = node.val;
        boolean r = inorder(node.right);
        return l && r;
    }
}
```



### 199. 二叉树的右视图

- 当前深度第一次访问添加,size一定大于depth,因为已经添加元素了
- 优先访问右节点

```java
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        help(root, 0);
        return list;
    }
    // 加一个深度辅助
    public void help(TreeNode root, int depth) {
        if (root == null)
            return;
        // 重要，如果当前深度第一次访问添加，当当前访问 > 1 ,size一定大于depth,因为已经添加元素了
        if (depth == list.size()) {
            list.add(root.val);
        }
        // 深度+1
        depth++;
        // 优先访问右节点
        help(root.right,depth);
        help(root.left, depth);
    }
}
```



### 103. 二叉树的锯齿形层次遍历

```java
class Solution {

    // 双链表交替实现
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 负责左向右加数据
        Stack<TreeNode> stack1 = new Stack<>();
        // 负责右向左加数据
        Stack<TreeNode> stack2 = new Stack<>();

        int i = 0;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // 0，2，4层
            if(i % 2 == 0) {
                // 栈1
                int size = stack1.size();
                while (size > 0) {
                    // 右向左加数据
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                    size--;
                }
            } else {
                // 栈2
                int size = stack2.size();
                while (size > 0) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                    size--;
                }
            }

            list.add(temp);
            i++;
        }
        return list;
    }
}
```

### 236. 二叉树的最近公共祖先

#### 怎样保存任一节点的父节点

```java
/*
 我们可以用哈希表存储所有节点的父节点，
 然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，并记录已经访问过的节点，
 再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
 */
class Solution {
    // 保存任一节点的父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    // 标记是否已经访问该节点【包含该节点】
    Set<Integer> isVisited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root);
        // p节点向上跳
        while(p != null) {
            // 已经访问该节点
            isVisited.add(p.val);
            // 向上跳
            p = parent.get(p.val);
        }
        // q节点向上跳
        while(q != null) {
            // 已经访问过该节点
            if (isVisited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        // 没找到
        return null;
    }
    // 怎样保存任一节点的父节点
    public void help(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            help(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            help(root.right);
        }
    }
}
```

#### 递归

https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/

**后序遍历**

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
```

### 814. 二叉树剪枝

```java
/*
 * 思路：
 * 1. 从一个节点开始查看【到递归】
 * 2. [0,0,1],[0,0,0]然后左右节点都为0[T]，则删除该节点
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean rb = help(root);
        // [0,0,0]
        if (rb == true)
            root = null;
        return root;
    }

    public boolean help(TreeNode root) {
        // 删除
        if (root == null)
            return true;
        // 判断左节点是否可以删除
        boolean l = help(root.left);
        if (l) {
            root.left = null;
        }
        boolean r = help(root.right);
        if (r) {
            root.right = null;
        }
        // 不可删除
        if (root.val == 1)
            return false;
        // 左右节点都为 0 或 null 删除
        return l && r;
    }
}
```





## 滑动窗口

### 3. 无重复字符的最长子串

abcba

[abc]->[cb]->[cba]

```java
class Solution {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
      	// 窗口
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int bengin = 0;
        for(int i = 0; i < s.length(); i++){
            // 已经遍历【包含改键】
            if(map.containsKey(s.charAt(i))) {
                // 防止bengin往回走【abba】
                bengin = Math.max(bengin, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // i-bengin+1窗口的大小
            max = Math.max(max, i-bengin+1);
        }
        return max;
    }
}
```





## 数据结构

### 链表

- 栈
- 逆序访问用栈



#### 19. 删除链表的倒数第N个节点

```java
class Solution {

    /*一次遍历
    * 双指针【快慢指针】
    * p 在前，q在后；p先走n步，然后一起走，p达到尾时q指向前驱指针
    */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 保持移除head节点的一致性
        ListNode root = new ListNode(0, head);
        ListNode p = root, q = root;
        int i = 0;
        while(i < n) {
            p = p.next;
            i++;
        }
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return root.next;
    }
    // 栈解决
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 哑节点
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        // 删除节点的前驱节点
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 一次遍历获取链表长度，再次遍历
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode p = head;
        int deep = 0;
        while(p != null) {
            deep++;
            p = p.next;
        }
        p = head;

        for (int i = 1; i < deep-n; i++) {
            p = p.next;
        }
        if (deep == n) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }
        return head;
    }
}
```





#### 160. 相交链表

```java
/*
 此题比较的不是val相同，而是真正相同链表【示例1】
 思路：
 1. 先消除长度差
        指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
        如果 pA 到了末尾，则 pA = headB 继续遍历
        如果 pB 到了末尾，则 pB = headA 继续遍历
        比较长的链表指针指向较短链表head时，长度差就消除了
 2. 在遍历找相同节点 

 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        // 如果有相交链表，去除长度差之后就应该相同【不仅仅是val相同，是同一地址对象】
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
```

#### 445. 两数相加 II

输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 8 -> 0 -> 7

- 不能对列表中的节点进行翻转---->栈

```java
// 栈处理
public ListNode stack(ListNode l1, ListNode l2) {
  Deque<Integer> stack1 = new LinkedList<>();
  Deque<Integer> stack2 = new LinkedList<>();
  while(l1 != null) {
    stack1.push(l1.val);
    l1 = l1.next;
  }
  while(l2 != null) {
    stack2.push(l2.val);
    l2 = l2.next;
  }
  ListNode pre = null;
  int c = 0;
  while (!stack1.isEmpty() || !stack2.isEmpty() || c != 0) {
    int a = stack1.isEmpty() ? 0 : stack1.pop();
    int b = stack2.isEmpty() ? 0 : stack2.pop();
    ListNode curr = new ListNode((a+b+c) % 10);
    c = (a+b+c) / 10;
    curr.next = pre;
    pre = curr;
  }
  return pre;
}
```



#### 328. 奇偶链表

```java
class Solution {
    public ListNode oddEvenList(ListNode head) {
        return help1(head);
    }
    public ListNode help1(ListNode head) {
        if (head == null)
            return head;
        ListNode curr = head, temp = head.next, even = head.next;
        // 奇数个 与 偶数个
        while(curr.next != null && curr.next.next != null) {
            // 1->3->4,5,6 【奇节点，所有节点】->奇节点
            curr.next = curr.next.next;
            curr = curr.next;
            // 偶节点
            even.next = curr.next;
            even = even.next;
        }
        curr.next = temp;
        return head;
    }
}
```





### DFS

#### 130. 被围绕的区域

- 任何不在边界上，或不与边界上的 `'O'` 相连的 `'O'` 最终都会被填充为 `'X'`。

```java
class Solution {
    /*
    对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
        如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
        如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
    */ 
    int row, col; 
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        row = board.length;
        col = board[0].length;
        // 遍历标记边界 O
        for (int i = 0; i < col; i++) {
            // 第一行
            dfs(board, 0, i);
            // 最后一行
            dfs(board, row-1, i);
        }
        for (int i = 0; i < row; i++) {
            // 第一列
            dfs(board, i, 0);
            // 最后一列
            dfs(board, i, col-1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 边界 O , 复原
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }

    // 将与边界相连的 O 标记
    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= row || c < 0 || c >= col)
            return;
        if (board[r][c] != 'O')
            return;
        // 该直接或间接相连的字母 O；
        board[r][c] = 'T';
        
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}
```







## 动态规划



### 279. 完全平方数

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.

```java
class Solution {
    /*
        动态规划
        dp[i] = min(dp[i], dp[i-j*j]+1)
        i 为 当前数，每次都将当前数字先更新为最大的结果，即 dp[i]=i，比如 i=4，最坏结果为 4=1+1+1+1 即为 4 个数字
        j*j  为之前的平方数
    */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j*j >= 0; j++) {
                // 动态规划转移方程
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
```





















# 剑指Offer

## 第一章

<img src="README.assets/image-20201208194059691.png" alt="image-20201208194059691" style="zoom:50%;" />

- **“事先对链表的插入和删除结点了如指掌，对二叉树的各种遍历方法的循环和递归写法都烂熟于胸”**

- **“注重考查查找、排序等算法。重点掌握二分查找、归并排序和快速排序”**

- “通常越是简单的问题，面试官的期望值就会越高。”：
  - “考虑到边界条件、错误处理”
  - null指针处理
  - 输入条件判断
  - **最好的办法是在动手写代码之后想好测试用例**
  - “边界条件、特殊输入（比如NULL指针，空字符串等）及错误处理”
  
- 复杂问题
  - “不期待完整的答案”
  - “是否有清晰的思路”
  - 办法
    - 举例子
    - 模拟操作
    - 图形表示
  - “很多基于**递归**的思路，包括**分治法和动态规划**，都是把复杂的问题分解成一个或者多个简单的子问题。”

- **“斐波那契数列”**

- “与**招聘的职位或者项目相关**的问题。”

  - 很高兴能到贵公司进行面试，很珍惜这次面试机会，面试评价，缺少，作为应聘该实习岗位，还有什么不足，提高，学习。

  

## 第二章

### 1. 单例模式

#### 1. 单线程模式

```java
public class Singleton {
  // 构造函数实现单例
  private Singleton() {}
  
  private static final Singleton instance = null;
  
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
```

- “两个线程同时运行到判断instance是否为null的if语句，并且instance的确没有创建时，那么两个线程都会创建一个实例”-->不满足


#### 2. 双重校验锁

```java
public final class SingletonSafe {
  private SingletonSafe() {}
  
  // 保证此变量对所有的线程的可见性
  private static volatile SingletonSafe instance;
  
  public static SingletonSafe getInstance() {
    // 两个线程进来， 不为null则不用加锁了
    if (instance == null) {
      // 只许一个线程
      synchronized (Singleton.class) {
        // 一个线程进来之后在判null
        if (instance == null) {
          instance = new SingletonSafe();
        }
      }
    }
    return instance;
  }
  
}
```

- synchronized 降低效率
- 用枚举

https://www.cnblogs.com/ngy0217/p/9006716.html



### 2. 数据结构

- “栈是一个与递归紧密相关”
- “队列也与广度优先遍历算法”

#### 1. 数组

1. “由于**数组中的内存是连续的**，于是可以**根据下标**在O（1）时间**读/写任何元素**”

   - 用数组来实现简单的哈希表
     - 把数组的下标设为哈希表的键（Key），而把数组中的每一个数字设为哈希表的值（Value）

#### 2. 字符串

#### 3. 链表

- “链表应该是面试时被提及最频繁的数据结构”
- “链表是一种**动态数据结构**，是因为在**创建链表时，无须知道链表的长度**。”
- “内存不是一次性分配的，因而我们**无法保证链表的内存的是连续的**

#### 4. 树

- “面试的时候提到的树，大部分都是二叉树”

- “这3种遍历都有**递归和循环**两种不同的实现方法，每一种遍历的**递归实现都比循环实现要简捷**很多。”

  - 前序，中序，后序

- “二叉搜索树”

  - “左子结点总是小于或等于根结点，而右子结点总是大于或等于根结点”

  - O（logn）

    <img src="README.assets/image-20201209230325017.png" alt="image-20201209230325017" style="zoom:50%;" />

- 堆

  - 最大堆：根节点最大
  - 最小堆：根节点最小

- 红黑树

  - “树中的结点定义为红、黑两种颜色，
  - 通过规则确保从根结点到叶结点的最长路径的长度不超过最短路径的两倍”

- 确定树

  - 先序+中序 

    - 先序：**`[ 根节点 | 左子树 | 右子树 ]`** 
    - 中序：**`[ 左子树 | 根节点 | 右子树 ]`**

  - 后序+中序

    <img src="README.assets/image-20201209231702293.png" alt="image-20201209231702293" style="zoom:50%;" /><img src="https://img-blog.csdn.net/20160426111458126" alt="这里写图片描述" style="zoom:70%;" />

#### 5. 算法与数据操作

- 排序和查找
  - “二分查找、归并排序和快速排序”
- “很多算法都可以用递归和循环”
- 位运算
  - “与、或、异或、左移和右移5种位运算。”

1. 某个排序中找
   - 二分查找

### 3. 位运算

- “表示时间分秒的六十进制”

- “与、或、异或、左移和右移”

  - 左移==*2：但是左移效率更高；右边补0
  - 右移==/2：左边补0
- Java
  - **<<表示左移，不分正负数，低位补0；**　
  - **>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；**
  - **>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0**
  - 



####  二进制中1的个数

```java
// 适用于正数
public int hammingWeight(int n) {
  int res = 0;
  while (n != 0) {
    // 1001 & 0001 (& 1)查看二进制尾是否为1
    res += n & 1;
    // 1001 -> 0100
    n >>>= 1;
  }
  return res;
}
```



##### 巧用 n&(n−1)

- (n−1) ： 二进制数字最右边的 1变成 0, 此1右边的0都变为1

- n&(n−1) ： 二进制数字 n 最右边的 1 变成 0 ，其余不变。

  - “把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0”


<img src="https://pic.leetcode-cn.com/9bc8ab7ba242888d5291770d35ef749ae76ee2f1a51d31d729324755fc4b1b1c-Picture10.png" alt="Picture10.png" style="zoom:48%;" />



### 4. 斐波那契相关

#### 循环迭代去递归

```java
public static long fib(int n) {
  int[] a = {0,1};
  if (n < 2)
    return a[n];
  long one = 0, two = 1, ans = 0;
  for(int i = 2; i <= n; i++) {
    ans = one + two;
    one = two;
    two = ans;
  }
  return ans;
}
```



#### 相关题目

- 青蛙跳台阶，1阶或2阶
  - 如果也可以跳n阶：2^(n-1)种
- 矩形覆盖问题
  - (m x 1) 去覆盖 (m x n)  == f(n)种覆盖可能



## 第三章

### T10. 数值n次方

- “由于计算机表示小数（包括float和double型小数）都有误差，我们不能直接用等号（==）判断两个小数是否相等。”


```java
System.out.println(0.01+0.05 == 0.06); // false
```



### T11 打印大数

- 大数一般用字符串或数组表示
- **字符串表达的数字上模拟加法**



## 题

### T3. 二维排序数组中查找确定数

**target**

**思路要清晰，从测试例出发，模拟，抓好关键字【排序】**

步骤：

- 从右上角开始，如 == target，结束；
- 如 > target，剔除当前列
- 如 < target，剔除当前行

<img src="README.assets/image-20201208222342108.png" alt="image-20201208222342108" style="zoom:50%;" />

```java
int[][] a = new int[][]{{1,2,3},{4,5,6}};
// 行
System.out.println(a.length);
// 列
System.out.println(a[0].length);
```

### T5. 从尾到头打印链表

1. 思路

- **逆向问题-先进后出-栈**

- 栈--递归
- 循环--栈--递归

### T6. 重建二叉树

<img src="README.assets/image-20201209231702293.png" alt="image-20201209231702293" style="zoom:50%;" /><img src="https://img-blog.csdn.net/20160426111458126" alt="这里写图片描述" style="zoom:70%;" />

```java
class Solution {

    /*
    * 利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    * 左右子树，递归
    * 前序【根，左子树，右子树】
    * 中序【左子树，根，右子树】
    */
    // 保留先序遍历
    int[] preorder;
    // 标记中序遍历【值，索引】
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        this.preorder = preorder;
        // 标记中序遍历【值，索引】
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return help(0, 0, preorder.length - 1);
    }
    //【根，左子树，右子树】
    public TreeNode help(int root, int left, int right) {
        if (left > right)
            return null;
        // 构建树
        TreeNode node = new TreeNode(this.preorder[root]);
        // 获取该节点在中序中的索引
        int root_index = map.get(preorder[root]);
        // 获取左子树的范围【left,index-1】
        node.left = help(root+1, left,  root_index-1);
        // 右子树-下一个根=前序中取出上一个根(root)+左子树个数(index-left) + 1
        node.right = help(root+root_index-left+1, root_index+1, right);
        return node;
    }
}
```

