import java.util.*;

import java.io.*;

public class BuildingRoads {
	static InputStream is = System.in;

	public static void main(String[] args) {
		StringBuilder outputBuffer = new StringBuilder();
		Vertex[] vertices = readGraph(is);
		List<Integer> number = new ArrayList<Integer>();
		for (Vertex vertex : vertices) {
			if (vertex != null)
				if (!vertex.visited) {
					number.add(vertex.id);
					vertex.visited = true;
					dfs(vertex);
				}
		}
		int temp = number.size();
		if (temp == 1) {
			System.out.println(0);
			return;
		}
		outputBuffer.append(temp - 1).append("\n");
		for (int i = 1; i < temp; i++) {
			outputBuffer.append(number.get(0)).append(" ").append(number.get(i)).append("\n");
		}
		System.out.println(outputBuffer);
	}

	static void dfs(Vertex vertex) {
		for (Vertex next : vertex.adjacentVertices) {
			if (!next.visited) {
				next.visited = true;
				dfs(next);
			}
		}
	}

	static Vertex[] readGraph(InputStream reader) {
		int n = ni();
		int m = ni();
		Vertex[] vertices = new Vertex[n + 1];
		for (int i = 1; i <= n; i++) {
			vertices[i] = new Vertex(i);
		}

		for (int i = 0; i < m; i++) {
			Vertex u = vertices[ni()];
			Vertex v = vertices[ni()];
			u.addVertex(v);
			v.addVertex(u);
		}
		return vertices;
	}

	static class Vertex {
		public int id;
		public boolean visited = false;
		public List<Vertex> adjacentVertices = new ArrayList<Vertex>();

		public Vertex(int id) {
			this.id = id;
		}

		public void addVertex(Vertex vertex) {
			adjacentVertices.add(vertex);
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