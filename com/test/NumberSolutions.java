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
	         ���һ��������Ϊ0����ô�������������һλ��1��������ǰ����������1����ôԭ�������������ұߵ�1�ͻ��Ϊ0��
	         ԭ����1��������е�0������1(������ұߵ�1���滹��0�Ļ�)����������λ�������ܵ�Ӱ�졣
	         �ٸ����ӣ�һ����������1100�����ұ��������λ�Ǵ������ұߵ�һ��1����ȥ1�󣬵���λ���0�����������λ0�����1��
	         ��ǰ���1���ֲ��䣬��˵õ��Ľ����1011.���Ƿ��ּ�1�Ľ���ǰ����ұߵ�һ��1��ʼ������λ��ȡ���ˡ�
	         ���ʱ����������ٰ�ԭ���������ͼ�ȥ1֮��Ľ���������㣬��ԭ���������ұ�һ��1��һλ��ʼ����λ������0��
	         ��1100&1011=1000.Ҳ����˵����һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұ�һ��1���0.
	         ��ôһ�������Ķ������ж��ٸ�1���Ϳ��Խ��ж��ٴ������Ĳ����� 
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
