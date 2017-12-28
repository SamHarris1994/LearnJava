package com.test;

public class NumberSolutions {

	public static int NumberOf1(int n) {
		int count = 0;
        /*
        char[] binaryCode = Integer.toBinaryString(n).toCharArray();
        for(int i = 0; i < binaryCode.length; i++) {
            if(binaryCode[i] == '1') count++;
        }
        */
        while(n != 0) {
            count++;
            n = n & (n - 1);
        }
        /*
	         如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
	         原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。其余所有位将不会受到影响。
	         举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，
	         而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
	         这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
	         如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
	         那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。 
        */
        return count;
    }
	
	public static int NumberOf1Between1AndN(int n) {
        int count = 0;
        int high;
        int low;
        for(int i = 1; i <= n; i *= 10) {
            high = n/i;
            low = n%i;
            if(high % 10 == 1) { count += (high + 8)/10*i + (low + 1); }
            else { count += (high + 8)/10*i; }
        }
        return count;
    }
	
	public static int GetUglyNumber(int index) { //number with factors 2,3,5 only
		if(index == 0) return 0;
        int[] records = new int[index];
        records[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        int newRecord;
        for(int i = 1; i < index; i++) {
            newRecord = Math.min(records[i2] * 2, Math.min(records[i3] * 3, records[i5] * 5));
            if(newRecord == records[i2] * 2) i2++;
            if(newRecord == records[i3] * 3) i3++;
            if(newRecord == records[i5] * 5) i5++;
            records[i] = newRecord;
        }
        return records[index - 1];
    }
	
}
