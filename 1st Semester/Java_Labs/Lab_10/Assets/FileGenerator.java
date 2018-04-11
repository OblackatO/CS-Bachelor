package lu.uni.programming1.lab10.exercise2;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class FileGenerator {

	public static void main(String[] args) throws Exception {

		if (args.length < 2) {
			throw new Exception("Please indicate the file name and size.");
		}

		try {
			String fileName = args[0];
			int fileSize = Integer.parseInt(args[1]);

			Random generator = new Random();
			generator.setSeed(System.currentTimeMillis());

			byte[] content = new byte[fileSize];
			for (int i = 0; i < fileSize; i++) {
				content[i] = (byte) (generator.nextInt(95) + 32);
			}

			System.out.format("Generating the file %s... ", fileName);
			long start = System.currentTimeMillis();
			try (DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(fileName)))) {
				dos.write(content);
			}
			long end = System.currentTimeMillis();
			double time = (double) (end - start) / 1000;

			File newCreatedFile = new File(fileName);

			if (newCreatedFile.length() == fileSize) {
				System.out.format("Done (t = %.3f s, size: %d).", time, newCreatedFile.length());
			} else {
				System.err.println("Inconsistent file size.");
			}

		} catch (IllegalArgumentException e) {
			System.err.println("Invalid file size.");
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
}
