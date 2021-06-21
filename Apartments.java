import java.util.*;
import java.io.*;

public class Apartments {
	static InputStream is = System.in;

	public static void main(String[] args) {
		int applicants = ni();
		int apartment = ni();
		long maxDiffer = nl();

		List<Long> desiredApartment = new ArrayList<Long>();
		desiredApartment.add(nl());

		List<Long> aparmentSize = new ArrayList<Long>();
		for (int i = 0; i < apartment; i++) {
			aparmentSize.add(nl());
		}

		Collections.sort(desiredApartment);
		Collections.sort(aparmentSize);

		int count = 0;
		long temp = 0;
		int eachPlace = 0;
		int person = 0;

		while (eachPlace < apartment && person < applicants) {
			temp = Math.abs(aparmentSize.get(eachPlace) - desiredApartment.get(person)); // >||< k
			if (temp <= maxDiffer) {
				count++;
				eachPlace++;
				person++;
			} else if (aparmentSize.get(eachPlace) < desiredApartment.get(person)) { // sorted
				eachPlace++;
			} else {
				person++;
			}
		}
		System.out.println(count);
	}

	// input reader
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
