import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import config.IType;
import config.Instruction;
import config.JType;
import config.RType;
import io.FileIO;
import io.Pair;
import io.ReadConfig;
import io.ReadFile;
import io.WriteFile;

/**
 * An assembler that takes instructions for a 16bit load-store architecture and
 * converts them to machine code.
 * 
 * @author schmitml
 *
 */
public class Assembler {
	private static String configFile = "configFile.txt";
	private static String instructionFile;
	private static String outputFile;
	private static Map<String, String> regMap; // Maps a string representation
												// to a binary number
	private static Map<String, Instruction> instMap; // Maps a string
														// instruction to an
														// instruction object

	public static void main(String[] args) {
		Pair<String, String> inputs = getInput();
		instructionFile = inputs.getValue1();
		outputFile = inputs.getValue2();
		loadConfig();
		parseInstructions();
	}

	private static void loadConfig() {
		ReadConfig conf = new ReadConfig(configFile);
		conf.readFile();
		Pair<Map<String, String>, Map<String, Instruction>> pair = conf.getPair();
		regMap = pair.getValue1();
		instMap = pair.getValue2();
	}

	private static void parseInstructions() {
		WriteFile write = new WriteFile(outputFile);
		ReadInstruction read = new ReadInstruction(instructionFile, write);
		read.readFile();
	}

	private static Pair<String, String> getInput() {
		String input = "";
		String output = "";

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter the path of the instruction file.");
			input = in.readLine();
			System.out.println("Please enter the path of the output file.");
			output = in.readLine();
		} catch (IOException e) {
			System.err.println("Error getting user input.");
			e.printStackTrace();
		}
		return new Pair<String, String>(input, output);
	}

	static class ReadInstruction extends ReadFile {
		private static WriteFile write;

		public ReadInstruction(String path, WriteFile mWrite) {
			super(path);
			write = mWrite;
		}

		public void readLine(String line) {
			String[] args = line.split(" ");
			String type = args[0];
			if (!instMap.containsKey(type)) {
				// Handle an instruction that is not in the configuration
				return;
			}
			Instruction inst = instMap.get(type);
			switch (inst.getType()) {
			case 'r':
				RType instR = (RType) inst;
				instR.addArgs(args[1], args[2], args[3]);
				break;
			case 'i':
				IType instI = (IType) inst;
				if (instI.getInstructionFormat() == 0) {
					instI.addArgs(args[1], args[2], args[3]);
				} else {
					String[] split = args[2].split("(");
				}

				break;
			case 'j':
				JType instJ = (JType) inst;

				break;
			}
			try {
				write.writeToFile(inst.toString());
			} catch (IOException e) {
				System.err.println("Error writing to output file.");
				e.printStackTrace();
			}

		}

	}
}