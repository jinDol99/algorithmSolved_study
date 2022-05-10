package algorithmSolved_study;
import java.io.*;
import java.util.*;
public class BJ220510_15552 {
	private static final String String = null;

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter n = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ab;
		int T = Integer.parseInt(input.readLine());
		int[] A = new int[T];
		int[] B = new int[T];
		for (int i = 0; i < T; i++) {
			ab = new StringTokenizer(input.readLine());
			n.write((Integer.parseInt(ab.nextToken()) + Integer.parseInt(ab.nextToken())) + "\n");
		}
		n.close();
	}
}
