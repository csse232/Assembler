package io;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
	 * Class to write to a text file from the given path. Erases existing text
	 * files with the same name.
	 * 
	 * @author schmitml
	 *
	 */
	public class WriteFile {
		private String fileName;

		/**
		 * Erases any text file with the same name upon instantiation.
		 * 
		 * @param name
		 */
		public WriteFile(String name) {
			this.fileName = name;

			// Erase the Text File
			try {
				this.writeToFile("", false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * Append to string to the text file.
		 * 
		 * @param toWrite
		 * @throws IOException
		 */
		public void writeToFile(String toWrite) throws IOException {
			writeToFile(toWrite, true);
		}

		/**
		 * Erase the text file and write the string or append the string to the
		 * text file.
		 * 
		 * @param toWrite
		 * @param append:
		 *            true to append; false to erase
		 * @throws IOException
		 */
		public void writeToFile(String toWrite, boolean append) throws IOException {
			FileWriter write = new FileWriter(this.fileName, append);
			PrintWriter print_line = new PrintWriter(write);

			print_line.println(toWrite);

			print_line.close();
		}
	}