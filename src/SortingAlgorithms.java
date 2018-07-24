public class SortingAlgorithms {


    /*1) Choose an element, called pivot, from the list. Generally pivot can be the middle index element.
      2) Reorder the list so that all elements with values less than the pivot come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
      3) Recursively apply the above steps to the sub-list of elements with smaller values and separately the sub-list of elements with greater values.
    */

    private int[] array;
    private int length;
    public void quickSort(int[] inputArr)
    {
        if(inputArr == null || inputArr.length==0)
            return;
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length-1);
    }

    public void quickSort(int left, int right)
    {
        if(left>=right)
            return;
        int pivot = array[(left+right)/2];
        int index = partition(left,right,pivot);
        quickSort(left,index-1);
        quickSort(index, right);

    }

    public int partition(int left, int right, int pivot)
    {
        while(left<=right)
        {
            while(array[left] < pivot)
                left++;
            while(array[right]>pivot)
                right--;

            if(left<=right)
            {
                swap(left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /*
    1) Divide the unsorted array into n partitions, each partition contains 1 element. Here the one element is considered as sorted.
    2) Repeatedly merge partitioned units to produce new sublists until there is only 1 sublist remaining. This will be the sorted list at the end.
     */

    int[] tempMergeArr;

    public void sort(int inputArr[]){
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergeArr = new int[length];
        doMergeSort(0,length-1);
    }

    public void doMergeSort(int left, int right)
    {
        if(left<right)
        {
            int middle = left + (right-left)/2;

            doMergeSort(left, middle);
            doMergeSort(middle+1, right);
            mergeParts(left,middle,right);
        }
    }

    public void mergeParts(int left, int middle, int right)
    {
        for(int i=left; i<=right; i++)
        {
            tempMergeArr[i] = array[i];
        }

        int i= left;
        int j = middle+1;
        int k = left;

        while(i<=middle && j<=right)
        {
            if(tempMergeArr[i] <= tempMergeArr[j])
            {
                array[k] = tempMergeArr[i];
                i++;
            }
            else{
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }

        while(i<=middle)
        {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }
    }

    public static void main(String a[]){

        SortingAlgorithms sorter = new SortingAlgorithms();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        sorter.quickSort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }

        System.out.println();

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        SortingAlgorithms mms = new SortingAlgorithms();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
