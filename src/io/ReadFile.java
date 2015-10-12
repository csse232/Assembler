package io;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	private String path;
	/**
	 * Generic constructor, which is to be used if you want to read a file at a
	 * later time.
	 */
	public ReadFile() {
	}

	/**
	 * Creates a ReadFile and automatically reads the file at the given path.
	 * 
	 * @param path
	 */
	public ReadFile(String path) {
		this.path = path;
	}

	/**
	 * Reads the file at the given path. Passes the current line to the readLine
	 * method, which makes it easy to change how a line is treated.
	 * 
	 * @param path
	 */
	public void readFile() {

		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(this.path));
			String line = in.readLine();

			while (line != null) {
				readLine(line);
				line = in.readLine();
			}

			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Does nothing to the line.
	 *  
	 * @param line
	 */
	public void readLine(String line) {
		return;
	}
}
