# 排序算法

[toc]

## 一、选择排序

### 	1.过程

​		arr[0 ~ N-1]范围上，找到最小值所在的位置，然后把最小值交换到0位置。

​		arr[1 ~ N-1]范围上，找到最小值所在的位置，然后把最小值交换到1位置。

​		arr[2 ~ N-1]范围上，找到最小值所在的位置，然后把最小值交换到2位置。

​		...

​		arr[N-1 ~ N-1]范围上，找到最小值所在的位置，然后把最小值交换到N-1位置。

### 	2.复杂度

#### 		（1）时间复杂度

​				很明显，如果arr的长度为N，每一步常数操作的数量，如同等差数列一般，N, N-1, N-2 ... 1

​				所以，总的常数操作数量 = a*(N^2) + b*N + c (a、b、 c都是常数)

​				所以选择排序的时间复杂度为O(N^2)。

#### 		（2）额外空间复杂度

​				很明显，操作过程中只使用了有限个额外的内存空间，所以空间复杂度为O(1)

### 	3.代码
```java
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 0 ~ n-1
        // 1 ~ n-1
        // 2 ~
        for (int i = 0; i < arr.length - 1; i++) { // 0 ~ n-2 剩下一个数时不用比较
            // 最小值在哪个位置上 i ~ n-1
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) { // i ~ n-1 上找最小值的下标
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
```