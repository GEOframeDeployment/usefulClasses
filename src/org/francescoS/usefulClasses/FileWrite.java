package org.francescoS.usefulClasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

	static PrintWriter errestat;
	static FileWriter Rstatfile;

	public static void openTxtFile(String path, boolean overwrite)
			throws IOException {

		try {

			File file = new File(path);

			if (overwrite) {

				file.createNewFile();
				
				System.out.println("Overwrite option selected");
				System.out.println("File name is " + file.getName());

				Rstatfile = new FileWriter(file, false); // overwrites file
				errestat = new PrintWriter(Rstatfile);

			} else if (!file.exists()) {
				
				file.createNewFile();

				System.out.println("Overwrite option not selected");
				System.out.println("File name is " + file.getName());

				Rstatfile = new FileWriter(file, true); // no overwrites file
				errestat = new PrintWriter(Rstatfile);

			} else {

				System.err.println("Path\n" + file.getAbsolutePath()
						+ "\nexists and overwrite option not selected\n");
				System.err.println("\nEnd of code");
				System.exit(0);

			}

		} catch (IOException e) {

			File file = new File(path);

			System.err.println("Path\n" + file.getAbsolutePath());
			// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			throw new RuntimeException(e);

		}

	}

	public static void writeDouble1Column(double[] data) throws IOException {

		for (int j = 0; j < data.length; j++) {

			errestat.println(data[j]);

		}

		errestat.println();
		System.out.println();
		Rstatfile.close();

	}
}
