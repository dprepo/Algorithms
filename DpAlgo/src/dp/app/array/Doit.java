package dp.app.array;

// 10,20,30,40,50,60
 // i ,i+1........n-1
public class Doit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,20,2,60,90};
		
	    findNGE(a,a.length);
	    

	}

	private static void findNGE(int[] a, int length) {
		// TODO Auto-generated method stub
		System.out.println("inside find NGE");
		for (int i = 0; i < a.length; i++) {
			 int nge = -1;
			for (int j = i+1; j < a.length; j++) {
				if(a[j] > a[i])
					nge =a[j];
					break;
			}
			System.out.println(a[i] + "- " +nge);
			
		}
	}
	
}
