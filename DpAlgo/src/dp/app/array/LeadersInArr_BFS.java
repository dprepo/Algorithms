package dp.app.array;

class LeadersInArr_BFS 
{
	/*Java Function to print leaders in an array */
	void printLeaders(int arr[], int size) 
	{
		for (int i = 0; i < size; i++) 
		{
			int j;
			for (j = i + 1; j < size; j++) 
			{
				if (arr[i] <=arr[j])
					break;
			}
			if (j == size) // the loop didn't break
				System.out.print(arr[i] + " ");
		}
	}


	public static void main(String[] args) 
	{
		LeadersInArr_BFS lead = new LeadersInArr_BFS();
		int arr[] = new int[]{16, 17, 4, 3, 5, 2};
		int n = arr.length;
		lead.printLeaders(arr, n);
	}
}
