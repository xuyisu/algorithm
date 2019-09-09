
# 0.Java 实现快速排序

快速排序的步骤：
- 1.选取第一个作为基准数据
- 2.循环对索引遍历，最左边的假设为i,最右边的假设为j
- 3.基准数据的右边放比基准数据大的数字，左边放比基准数据小的数字
- 4.从左边遍历第一个大于基准数据的数字，从右边遍历第一个小于基准数据的值，然后交换
- 5.继续执行此操作，知道i=j
- 6.然后将基准数据和第i或j位的数字交换，这样基准左边的小于基准数字，基准数据右边就会大于基准数据
- 7.之后以基准数据为分隔点，执行i到基准点和基准点+1到j分成两组继续执行1到6的步骤
- 8.快速排序就是对冒泡排序的升级，通过对一组数组分开排序而提高效率



# 1.代码如下
```java
public static void main(String[] args) {
        int [] arr={9,2,7,4,2,6,7};

        quickSort(arr,0,arr.length-1);
        String str1 = Arrays.stream(arr).boxed().map(i -> i.toString()) //必须将普通数组 boxed才能 在 map 里面 toString
                .collect(Collectors.joining(","));
        System.out.println(str1);

    }

    public static void quickSort(int[] arr, int start ,int end)
    {
        int i=start;
        int j=end;
        if(start>end){
            return;
        }
        int startValue=arr[start];
        while (i<j)
        {
            while(i<j&&startValue<=arr[j])
            {
                j--;
            }
            while(i<j&&startValue>=arr[i])
            {
                i++;
            }
            if(i<j)
            {
                int temp1=arr[i];
                arr[i]=arr[j];
                arr[j]=temp1;
            }
        }
        arr[start]=arr[i];
        arr[i]=startValue;
        quickSort(arr,start,j-1);
        quickSort(arr,j+1,end);

    }
```