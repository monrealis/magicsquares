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
		find(0);
		System.out.println(count);
	}
	
	private void find(int numberIndex) {
		for (i[getRow(numberIndex)][getCol(numberIndex)] = MIN_INCL; i[getRow(numberIndex)][getCol(numberIndex)] < MAX_EXCL; ++i[getRow(numberIndex)][getCol(numberIndex)]) {
			if (isDuplicateExists(numberIndex + 1)) {
				continue;
			}
			if (numberIndex + 1 < 9) {
				find(numberIndex + 1);
			}
			if (numberIndex + 1 == 9) {
				checkSquare();
			}
		}		
	}

	private void checkSquare() {
		if (!isMagicSquare()) {
			return;
		}
		print();
		++count;
	}
	
	private boolean isDuplicateExists(int count) {
		Set<Integer> items = new TreeSet<Integer>();
		for (int j = 0; j < count; ++j) {
			int n = i[getRow(j)][getCol(j)];
			if (!items.add(n)) {
				return true; 
			}
		}
		return false;
	}

	private int getRow(int j) {
		return j / 3;
	}
	
	private int getCol(int j) {
		return j % 3;
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
