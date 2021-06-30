import java.util.*;

import java.io.*;

public class RestaurantCustomers {
	static InputStream is = System.in;

	public static void main(String[] args) {
		int n = ni();
		TreeMap<Integer, Integer> end = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			end.put(ni(), 1); // ++
			end.put(ni(), -1); // --
		}
		int maxCustomer = 0;
		int currentCustomer = 0;
		for (Map.Entry<Integer, Integer> entry : end.entrySet()) {
			currentCustomer += entry.getValue();
			maxCustomer = Math.max(maxCustomer, currentCustomer);
		}
		System.out.println(maxCustomer);
	}

	// different way
	/*
	 * static void solveSort() { int n = ni() * 2; int[] endPoints = new int[n]; for
	 * (int i = 0; i < n; i += 2) { endPoints[i] = ni() * 2 + 1; endPoints[i + 1] =
	 * ni() * 2; } Arrays.sort(endPoints); int customer = 0, maxCustomer = 0; for
	 * (int endPoint : endPoints) { customer += (endPoint & 1) == 0 ? -1 : +1;
	 * maxCustomer = Math.max(maxCustomer, customer); }
	 * System.out.println(maxCustomer); }
	 */

	static byte[] inbuf = new byte[1 << 24];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static int ni() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static long nl() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}
