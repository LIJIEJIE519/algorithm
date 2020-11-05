# algorithm
算法学习笔记






# leetcode
### easy

#### 1. 两数之和

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

用字典保存每种情况，依次遍历；

#### 14. 最长公共前缀  

两两词比较得公共串，公共串在与后面词继续比较

#### 20. 有效的括号

左括号入栈，遇右括号出栈；HashMap作匹配

#### 26. 删除排序数组中的重复项 : 

#### 27. 移除元素  ；返回新长度

1. 原地操作：
   1. 重复：两个指针监听：一个指向唯一，另一个找唯一；
   2. 当不相等时，将新唯一赋予当前下一个元素，新唯一变唯一

2. 移除val：
   1. 重点：元素的顺序可以改变
   2. 思路：两个指针i、j，i 找val, 另一个j从后面找不是val填充 i 的val

#### 28. 匹配字串：KMP

1. 适用于重复字符串

2. https://www.zhihu.com/question/21923021

3. 简言之，以图中的例子来说，在 i 处失配，那么主字符串和模式字符串的前边6位就是相同的。又因为模式字符串的前6位，它的前4位前缀和后4位后缀是相同的，所以我们推知主字符串i之前的4位和模式字符串开头的4位是相同的。就是图中的灰色部分。那这部分就不用再比较了。

4. <img src="https://pic4.zhimg.com/v2-03a0d005badd0b8e7116d8d07947681c_r.jpg?source=1940ef5c" alt="preview" style="zoom: 50%;" />

5. 在把PMT【部分匹配表(Partial Match Table)】进行向右偏移时，第0位的值，我们将其设成了-1，这只是为了编程的方便，并没有其他的意义。在本节的例子中，next数组如下表所示。

   <img src="https://pic4.zhimg.com/50/v2-40b4885aace7b31499da9b90b7c46ed3_hd.jpg?source=1940ef5c" alt="img" style="zoom:50%;" />

#### 35. 搜索插入位置

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
   * 3.StringBuilder 可变字符串，主要用于字符串的拼接，属于线程不安全的；`速度最快`

#### 53. 最大子序和

1.     * 只考虑当前 nums[i], 上一个值的最大值+当前值是否大于当前值，
       *    是，则加入到子数组； 否，则当前值更大
       * 比较大小用Math.max();

#### 67. 二进制求和

1. ```java
   // 2进制转10进制
   System.out.println(Integer.parseInt("11", 2));
   // 10进制转2进制
   System.out.println(Integer.toBinaryString(10));
   ```

2. 加一个carry获取进位， carry % 2当前答案，carry/2当前答案； 遍历完carry!=0在加1

#### 69. mySqrt

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

     