package eu.vytenis.magicsq;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Finder {
	private static final int MIN_INCL = 1;
	private static final int MAX_EXCL = 10;
	
	private int i[][] = new int[3][3];
	private int count;

	public void find() {
		for (i[0][0] = MIN_INCL; i[0][0] < MAX_EXCL; ++i[0][0]) {
			if (isDuplicateExists(1)) continue;
			for (i[0][1] = 1; i[0][1] < 10; ++i[0][1]) {
				if (isDuplicateExists(2)) continue;
				for (i[0][2] = 1; i[0][2] < 10; ++i[0][2]) {
					if (isDuplicateExists(3)) continue;
					for (i[1][0] = 1; i[1][0] < 10; ++i[1][0]) {
						if (isDuplicateExists(4)) continue;
						for (i[1][1] = 1; i[1][1] < 10; ++i[1][1]) {
							if (isDuplicateExists(5)) continue;
							for (i[1][2] = 1; i[1][2] < 10; ++i[1][2]) {
								if (isDuplicateExists(6)) continue;
								for (i[2][0] = 1; i[2][0] < 10; ++i[2][0]) {
									if (isDuplicateExists(7)) continue;
									for (i[2][1] = 1; i[2][1] < 10; ++i[2][1]) {
										if (isDuplicateExists(8)) continue;
										for (i[2][2] = 1; i[2][2] < 10; ++i[2][2]) {
											if (isDuplicateExists(9)) continue;
											if (isMagicSquare()) {
												print();
												++count;
											}											
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count);
	}
	
	private boolean isDuplicateExists(int count) {
		Set<Integer> items = new TreeSet<Integer>();
		int[] ints = new int[] {i[0][0], i[0][1], i[0][2], i[1][0], i[1][1], i[1][2], i[2][0], i[2][1], i[2][2]};
		for (int i = 0; i < count; ++i) {
			if (items.contains(ints[i])) {
				return true; 
			}
			items.add(ints[i]);
		}
		return false;
	}
	
	private boolean isMagicSquare() {
		Set<Integer> sums = new TreeSet<Integer>();
		sums.add(getSum(i[0][0], i[0][1], i[0][2]));
		sums.add(getSum(i[1][0], i[1][1], i[1][2]));
		sums.add(getSum(i[2][0], i[2][1], i[2][2]));		
		sums.add(getSum(i[0][0], i[1][0], i[2][0]));
		sums.add(getSum(i[0][1], i[1][1], i[2][1]));
		sums.add(getSum(i[0][2], i[1][2], i[2][2]));		
		sums.add(getSum(i[0][0], i[1][1], i[2][2]));
		sums.add(getSum(i[0][2], i[1][1], i[2][0]));
		return sums.size() == 1;
	}
	
	private int getSum(int... ints) {
		int r = 0;
		for (int i : ints) {
			r += i;
		}
		return r;		
	}
	
	public void print() {
		System.out.println(Arrays.asList(i[0][0], i[0][1], i[0][2]));
		System.out.println(Arrays.asList(i[1][0], i[1][1], i[1][2]));
		System.out.println(Arrays.asList(i[2][0], i[2][1], i[2][2]));
		System.out.println();
	}
	
	public int getCount() {
		return count;
	}

}
