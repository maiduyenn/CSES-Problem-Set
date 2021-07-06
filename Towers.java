import java.util.*;
import java.io.*;

public class Towers {
	public static void main(String[] args) {
		int number = ni();
		TreeMap<Integer, Integer> towers = new TreeMap<Integer, Integer>();
		towers.put(ni(), 1);
		int count = 0;
		for (int i = 1; i < number; i++) {
			int temp = ni();
			if (towers.higherKey(temp) != null) {
//---------------// contains value >temp:
				int a = towers.higherKey(temp);
				if (towers.get(a) > 1) { // value of a>1
					towers.put(a, towers.get(a) - 1);
					count--;
					towers.put(temp, 1);
				} else {
					// value of a=1 /remove a
					if (towers.containsKey(temp)) { // already exist temp
						count++;
						towers.put(temp, towers.get(temp) + 1);
					} else { // not exist
						towers.put(temp, 1);
					}
					towers.remove(a);
				}
			}
//---------------// contains no value > temp:
			else if (towers.containsKey(temp)) {// already contain temp ==
				count++;
				towers.put(temp, towers.get(temp) + 1);
			} else { // doesn't exist, put to treemap
				towers.put(temp, 1);
			}
		}

		System.out.println(towers.size() == 1 ? count + 1 : towers.size() + count);

	}

	// input reader
	static InputStream is = System.in;
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