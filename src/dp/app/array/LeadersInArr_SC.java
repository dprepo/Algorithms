package dp.app.array;


class LeadersInArr_SC 
{
	
	void displayLeaders(int arr[], int size)
	{
		int maxFromRight = arr[size-1];

		/* Rightmost element is always leader */
		System.out.print(maxFromRight + " ");
	
		for (int i = size-2; i >= 0; i--)
		{
			if (maxFromRight < arr[i])
			{		 
			maxFromRight = arr[i];
			System.out.print(maxFromRight + " ");
			}
		} 
	}

	
	public static void main(String[] args) 
	{
		LeadersInArr_SC lead = new LeadersInArr_SC();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2};
		int n = arr.length;
		lead.displayLeaders(arr, n);
	}
}
