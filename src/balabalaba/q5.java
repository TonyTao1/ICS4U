package balabalaba;

public class q5 {
	public static void main(String[] args) {
		int[] example = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int num = 11;
		int[] result = insertElement(example, num);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

	public static int[] insertElement(int[] input, int num) {
		int[] result = new int[input.length + 1];
		int index;
		for (index = 0; index < input.length; index++) {
			if (input[index] < num) {
				result[index] = input[index];
			} else {
				break;
			}
		}
		result[index] = num;
		for (; index < input.length; index++) {
			result[index + 1] = input[index];
		}
		return result;
	}

}
