package exercise2;

import java.io.*;

public class File_copier {

	public static void main(String[] args) throws IOException {

		InputStream in_stream = null;
		BufferedInputStream in_buffer = null;

		OutputStream out_stream = null;
		BufferedOutputStream out_buffer = null;

		long initial_time = System.nanoTime();
		try {
			System.out.println("Tring to copy file with Buffer...");
			in_stream = new FileInputStream(args[0]);
			in_buffer = new BufferedInputStream(in_stream);

			out_stream = new FileOutputStream("output_test.txt");
			out_buffer = new BufferedOutputStream(out_stream);

			int c;
			while ((c = in_buffer.read()) != -1) {
				out_buffer.write(c);
			}

		} catch (IOException e) {
			System.out.println("There was a problem with the process of copying.");
			System.out.println("Exception details :");
			System.out.println(e);

		} finally {
			
			/*
			 * if(in_stream != null) { in_stream.close(); }
			 */

			if (in_buffer != null) {
				in_buffer.close();
			}
			/*
			 * if(out_stream != null) { out_stream.close(); }
			 */
			if (out_buffer != null) {
				out_buffer.close();
			}
		}
		long pre_final_time = System.nanoTime();
		System.out.println("Time with buffer:" + (pre_final_time - initial_time));

		// Trying without buffer
		initial_time = System.nanoTime();
		try {
			System.out.println("Tring to copy file without Buffer...");
			in_stream = new FileInputStream(args[0]);

			out_stream = new FileOutputStream("output_test.txt");

			int c;
			while ((c = in_stream.read()) != -1) {
				out_stream.write(c);
			}

		} catch (IOException e) {
			System.out.println("There was a problem with the process of copying.");
			System.out.println("Exception details :");
			System.out.println(e);

		} finally {

			if (in_stream != null) {
				in_stream.close();
			}

			if (out_stream != null) {
				out_stream.close();
			}
		}
		pre_final_time = System.nanoTime();
		System.out.println("Time without buffer:" + (pre_final_time - initial_time));

	}

}
