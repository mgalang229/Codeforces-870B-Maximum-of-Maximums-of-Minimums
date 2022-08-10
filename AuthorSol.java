import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AuthorSol {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			int[] a = fs.readArray(n);
			if (k == 1) {
				int min = Integer.MAX_VALUE;
				for (int i = 0; i < n; i++) {
					min = Math.min(min, a[i]);
				}
				out.print(min);
			} else if (k == 2) {
				int[] suffixMin = new int[n];
				suffixMin[n-1] = a[n-1];
				for (int i = n - 2; i >= 0; i--) {
					suffixMin[i] = Math.min(a[i], suffixMin[i+1]);
				}
				int prefixMin = a[0];
				int ans = Math.max(prefixMin, suffixMin[1]);
				for (int i = 1; i < n - 1; i++) {
					prefixMin = Math.min(prefixMin, a[i]);
					ans = Math.max(ans, Math.max(suffixMin[i+1], prefixMin));
				}
				out.println(ans);
			} else {
				int max = Integer.MIN_VALUE;
				for (int i = 0; i < n; i++) {
					max = Math.max(max, a[i]);
				}
				out.println(max);
			}
		}
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
