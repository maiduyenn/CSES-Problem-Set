import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class ConcertTickets {
	static InputStream is = System.in;

	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		int n = ni();
		int customers = ni();
		TreeMap<Integer, Integer> priceTickets = new TreeMap<Integer, Integer>();
		Entry<Integer, Integer> ticket;

		for (int i = 0; i < n; i++) {
			int temp = ni();
			if (priceTickets.containsKey(temp)) {
				priceTickets.put(temp, priceTickets.get(temp) + 1);
			} else {
				priceTickets.put(temp, 1);
			}
		}

		for (int i = 0; i < customers; i++) {
			int temp = ni();

			ticket = priceTickets.floorEntry(temp); //
			if (priceTickets.floorEntry(temp) != null) {
				// <= maxpay > other
				output.append(priceTickets.floorKey(temp)).append("\n");
				if (ticket.getValue() > 1) { // tickets vs same price
					priceTickets.put(ticket.getKey(), ticket.getValue() - 1);
				} else {
					priceTickets.remove(ticket.getKey());
				}
			} else {
				output.append(-1).append("\n");
			}
		}
		System.out.println(output);
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
