package mainpack;
public class ArrayAsc {
	public static void main(String[] args)
	{
		ArrayAsc obj = new ArrayAsc();
		int[] inputArr =  {12,2,2,56,74,84,94,104,114,1,12,32,43,56,67,1,234,889,1000};
		int[] array = obj.recursiveSub(inputArr,0,new int[]{inputArr[0] },new int[]{inputArr[0] });
		for(int i=0;i<array.length;i++)
			System.out.println(array[i]);
	}	
	public int[] recursiveSub(int[] inputArr,int i,int[] subArray,int[] maxArray)
	{
		if(i+1>inputArr.length-1)
			return (maxArray.length<subArray.length) ? subArray:maxArray;
		if(inputArr[i]<=inputArr[i+1])
		{
			int[] temp_array = new int[subArray.length+1];			
			for(int j=0;j<subArray.length;j++)
				temp_array[j] = subArray[j];
			temp_array[subArray.length] = inputArr[i+1];			
			return (maxArray.length<temp_array.length) ? recursiveSub(inputArr,i+1,temp_array,temp_array) : recursiveSub(inputArr,i+1,temp_array,maxArray);		
		}		
		else						
			return recursiveSub(inputArr,i+1,new int[]{inputArr[i+1] },maxArray);		
	}
}
