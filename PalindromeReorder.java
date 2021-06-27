import java.util.*;
import java.io.*;

public class PalindromeReorder {
	static InputStream is = System.in;

	public static void main(String[] args) {
		String n = ns();
		HashMap<Character, Integer> eachCharacter = new HashMap<Character, Integer>();

		StringBuilder left = new StringBuilder();
		StringBuilder right = new StringBuilder();
		StringBuilder mid = new StringBuilder();
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < n.length(); i++) {
			Character temp = n.charAt(i);
			if (!eachCharacter.containsKey(temp)) {
				eachCharacter.put(temp, 1);
			} else {
				eachCharacter.put(temp, eachCharacter.get(temp) + 1);
			}
		}
		for (Character key : eachCharacter.keySet()) {
			int count = eachCharacter.get(key);
			if (count < 2) {
				mid.append(key);
			} else {
				if (eachCharacter.get(key) % 2 == 0) {
					for (int i = 0; i < count / 2; i++) {
						left.append(key);
						right.append(key);
					}
				} else {
					for (int i = 0; i < (count - 1) / 2; i++) {
						left.append(key);
						right.append(key);
					}
					mid.append(key);
				}
			}
		}

		if (mid.length() > 1) {
			System.out.println("NO SOLUTION");
		} else {
			right.reverse();
			line.append(left).append(mid).append(right);
			System.out.print(line);

		}
	}

	
	
	
	//
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
