package eu.vytenis.magicsq;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Finder {
	private int i11;
	private int i12;
	private int i13;
	private int i21;
	private int i22;
	private int i23;
	private int i31;
	private int i32;
	private int i33;	
	private int count;

	public void find() {
		for (i11 = 1; i11 < 10; ++i11) {
			if (isDuplicateExists(1)) continue;
			for (i12 = 1; i12 < 10; ++i12) {
				if (isDuplicateExists(2)) continue;
				for (i13 = 1; i13 < 10; ++i13) {
					if (isDuplicateExists(3)) continue;
					for (i21 = 1; i21 < 10; ++i21) {
						if (isDuplicateExists(4)) continue;
						for (i22 = 1; i22 < 10; ++i22) {
							if (isDuplicateExists(5)) continue;
							for (i23 = 1; i23 < 10; ++i23) {
								if (isDuplicateExists(6)) continue;
								for (i31 = 1; i31 < 10; ++i31) {
									if (isDuplicateExists(7)) continue;
									for (i32 = 1; i32 < 10; ++i32) {
										if (isDuplicateExists(8)) continue;
										for (i33 = 1; i33 < 10; ++i33) {
											if (isDuplicateExists(9)) continue;
											//System.out.println(new int[] {i11, i12, i13, i21, i22, i23, i31, i32, i33});
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
		int[] ints = new int[] {i11, i12, i13, i21, i22, i23, i31, i32, i33};
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
		sums.add(getSum(i11, i12, i13));
		sums.add(getSum(i21, i22, i23));
		sums.add(getSum(i31, i32, i33));		
		sums.add(getSum(i11, i21, i31));
		sums.add(getSum(i12, i22, i32));
		sums.add(getSum(i13, i23, i33));		
		sums.add(getSum(i11, i22, i33));
		sums.add(getSum(i31, i22, i13));
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
		System.out.println(Arrays.asList(i11, i12, i13));
		System.out.println(Arrays.asList(i21, i22, i23));
		System.out.println(Arrays.asList(i31, i32, i33));
		System.out.println();
	}
	
	public int getCount() {
		return count;
	}

}
