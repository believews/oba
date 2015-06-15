// Decompiled by Jad v1.5.7g. Copyright 2000 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 
// Source File Name:   TypeConvert.java

package com.oba.web.util;

import java.math.BigInteger;

/**
 * 字节转换
 * @author liuxq
 * @date 2013-7-4
 * @time 上午09:58:59
 * @version 1.00
 */
public class TypeConvert {

	public TypeConvert() {
	}

	public static int byte2int(byte b[], int offset) {
		return b[offset + 3] & 0xff | (b[offset + 2] & 0xff) << 8
				| (b[offset + 1] & 0xff) << 16 | (b[offset] & 0xff) << 24;
	}

	private static int toInt(byte b[]) {
		// return b >= 0 ? (int)b : (int)(b + 256);
		return b[3] & 0xff | (b[2] & 0xff) << 8 | (b[1] & 0xff) << 16
				| (b[0] & 0xff) << 24;
	}

	private static byte[] sort(byte[] source) {
		byte[] desc = new byte[source.length];
		for (int i = 0; i < source.length; i++) {
			desc[i] = source[source.length - (i + 1)];
//			System.out.println("desc[" + i + "]:" + desc[i]);
		}
		return desc;
	}

	public static int byte2int(byte b[]) {
		//byte c[] = sort(b);
		return getInt( b, 0);
	}

	//C#与Java byte转int不同，采用如下方法
	public static int getInt(byte[] bb, int index) {
		return (int) ((((bb[index + 3] & 0xff) << 24)
				| ((bb[index + 2] & 0xff) << 16)
				| ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
	}

	// public static int byte2int(byte b[])
	// {
	// int tmpb = toInt(b);
	// System.out.println("tmpb:"+tmpb);
	// int ret = tmpb >= 0 ? (int)tmpb : (int)(tmpb + 256);
	// System.out.println("ret:"+ret);
	// return ret;
	// }

	public static long byte2long(byte b[]) {
		return (long) b[7] & (long) 255 | ((long) b[6] & (long) 255) << 8
				| ((long) b[5] & (long) 255) << 16
				| ((long) b[4] & (long) 255) << 24
				| ((long) b[3] & (long) 255) << 32
				| ((long) b[2] & (long) 255) << 40
				| ((long) b[1] & (long) 255) << 48 | (long) b[0] << 56;
	}

	public static long byte2long(byte b[], int offset) {
		return (long) b[offset + 7] & (long) 255
				| ((long) b[offset + 6] & (long) 255) << 8
				| ((long) b[offset + 5] & (long) 255) << 16
				| ((long) b[offset + 4] & (long) 255) << 24
				| ((long) b[offset + 3] & (long) 255) << 32
				| ((long) b[offset + 2] & (long) 255) << 40
				| ((long) b[offset + 1] & (long) 255) << 48
				| (long) b[offset] << 56;
	}
	
	public static void putInt(byte[] bb, int x, int index) {  
        bb[index + 3] = (byte) (x >> 24);  
        bb[index + 2] = (byte) (x >> 16);  
        bb[index + 1] = (byte) (x >> 8);  
        bb[index + 0] = (byte) (x >> 0);  
    }  

	/**
	 * int转成byte[]
	 * @param n
	 * @return
	 */
	public static byte[] int2byte(int n) {
		byte b[] = new byte[4];
		b[3] = (byte) (n >> 24);
		b[2] = (byte) (n >> 16);
		b[1] = (byte) (n >> 8);
		b[0] = (byte) n;
		return b;
	}

	public static void int2byte(int n, byte buf[], int offset) {
		buf[offset] = (byte) (n >> 24);
		buf[offset + 1] = (byte) (n >> 16);
		buf[offset + 2] = (byte) (n >> 8);
		buf[offset + 3] = (byte) n;
	}

	public static byte[] short2byte(int n) {
		byte b[] = new byte[2];
		b[0] = (byte) (n >> 8);
		b[1] = (byte) n;
		return b;
	}

	public static void short2byte(int n, byte buf[], int offset) {
		buf[offset] = (byte) (n >> 8);
		buf[offset + 1] = (byte) n;
	}

	public static byte[] long2byte(long n) {
		byte b[] = new byte[8];
		b[0] = (byte) (int) (n >> 56);
		b[1] = (byte) (int) (n >> 48);
		b[2] = (byte) (int) (n >> 40);
		b[3] = (byte) (int) (n >> 32);
		b[4] = (byte) (int) (n >> 24);
		b[5] = (byte) (int) (n >> 16);
		b[6] = (byte) (int) (n >> 8);
		b[7] = (byte) (int) n;
		return b;
	}

	public static void long2byte(long n, byte buf[], int offset) {
		buf[offset] = (byte) (int) (n >> 56);
		buf[offset + 1] = (byte) (int) (n >> 48);
		buf[offset + 2] = (byte) (int) (n >> 40);
		buf[offset + 3] = (byte) (int) (n >> 32);
		buf[offset + 4] = (byte) (int) (n >> 24);
		buf[offset + 5] = (byte) (int) (n >> 16);
		buf[offset + 6] = (byte) (int) (n >> 8);
		buf[offset + 7] = (byte) (int) n;
	}

	public static long getLongByBytesBe(byte abyte0[]) {
		int i = abyte0.length >= 8 ? 8 : abyte0.length;
		long l = 0L;
		for (int j = 0; j < i; j++) {
			l <<= 8;
			l |= 255L & (long) abyte0[j];
		}

		return l;
	}

	public static long getLongByBytesLe(byte abyte0[]) {
		int i = abyte0.length >= 8 ? 8 : abyte0.length;
		long l = 0L;
		for (int j = 0; j < i; j++) {
			l <<= 8;
			l |= 255L & (long) abyte0[i - j - 1];
		}

		return l;
	}

	public static String printHex(int i) {
		BigInteger biginteger = BigInteger.valueOf((long) i + 0x100000000L);
		BigInteger biginteger1 = BigInteger.valueOf(0x100000000L);
		if (biginteger.compareTo(biginteger1) != -1) {
			biginteger = biginteger.subtract(biginteger1);
		}
		return biginteger.toString(16);
	}

	public static String printHex(byte abyte0[]) {
		byte abyte1[] = new byte[abyte0.length + 1];
		abyte1[0] = 0;
		System.arraycopy(abyte0, 0, abyte1, 1, abyte0.length);
		BigInteger biginteger = new BigInteger(abyte1);
		return biginteger.toString(16);
	}

	public static String FormatInt(int i, int j) {
		String s;
		for (s = String.valueOf(i); s.length() < j; s = "0" + s) {
		}
		if (s.length() > 5) {
			s = s.substring(0, 5);
		}
		return s;
	}

	public static int DecodeCMPPMsgID(byte[] sequence, String[] as) {
		StringBuffer stringbuffer = new StringBuffer();
		if (sequence.length != 8) {
			return -1;
		}
		long l1 = getLongByBytesBe(sequence);
		int k1 = (int) (l1 & 65535L);
		l1 >>>= 16;
		int i = (int) (l1 & 0x3fffffL);
		l1 >>>= 22;
		int j1 = (int) (l1 & 63L);
		l1 >>>= 6;
		int i1 = (int) (l1 & 63L);
		l1 >>>= 6;
		int l = (int) (l1 & 31L);
		l1 >>>= 5;
		int k = (int) (l1 & 31L);
		l1 >>>= 5;
		int j = (int) (l1 & 15L);
		if (j1 >= 60) {
			i1 += j1 / 60;
			j1 %= 60;
		}
		if (i1 >= 60) {
			l += i1 / 60;
			i1 = j1 % 60;
		}
		if (l >= 24) {
			k += l / 24;
			l %= 24;
		}
		stringbuffer.setLength(0);
		stringbuffer.append(FormatInt(j, 2));
		stringbuffer.append(FormatInt(k, 2));
		stringbuffer.append(FormatInt(l, 2));
		stringbuffer.append(FormatInt(i1, 2));
		stringbuffer.append(FormatInt(j1, 2));
		stringbuffer.append(FormatInt(i, 5));
		stringbuffer.append(FormatInt(k1, 5));
		as[0] = stringbuffer.toString();
		return 0;
	}
	/**
	 * 根据地推类型返回相应的地推值
	 * @param type
	 * @return
	 */
	public static String getExType(Integer type){
		String result = "";
		if(type == 1){
		   result = "公司福利";
		}else if(type == 2){
			result = "驻店";
		}else if(type ==3 ){
			result = "路演";
		}
		return result;
	}
	public static void main(String[] args) {
		byte[] a = int2byte(10);
		System.out.print("111");
	}

}
