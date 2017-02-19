import java.util.Arrays;

public class ArrayProducts {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5};
		int[] products = products(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(products));
	}
	
	public static int[] products(int[] nums) {
		int[] products = new int[nums.length];
		int p = 1;
		for(int i = 0; i < nums.length; i++) {
			products[i] = p;
			p *= nums[i];
		}

		p = 1;
		for(int i = nums.length - 1; i >= 0; i--) {
			products[i] *= p;
			p *= nums[i];
		}
		return products;
	}
}