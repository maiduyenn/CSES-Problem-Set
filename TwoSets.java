import java.util.*;
import java.io.*;

public class TwoSets {

	static InputStream is = System.in;

	public static void main(String[] args) {
		StringBuilder out = new StringBuilder();
		int n = ni();
		if (n % 4 == 1 || n % 4 == 2) {
			System.out.println("NO");
		} else {
			SortedSet<Integer> left = new TreeSet<Integer>();
			SortedSet<Integer> right = new TreeSet<Integer>();

			int i;
			int j = n;
			if (n % 2 == 0) {
				i = 1;
			} else {
				left.add(1);
				left.add(2);
				right.add(3);
				i = 4;
			}
			while (i <= j) {
				left.add(i);
				i++;
				right.add(i);
				i++;
				left.add(j);
				j--;
				right.add(j);
				j--;
			}
			out.append("YES").append("\n");
			out.append(left.size()).append("\n");
			for (Integer a : left) {
				out.append(a).append(" ");
			}
			out.append("\n");
			out.append(right.size()).append("\n");
			for (Integer a : right) {
				out.append(a).append(" ");
			}
			System.out.println(out);
		}
	}

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
