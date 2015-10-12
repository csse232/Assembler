package config;

public abstract class Instruction {
	protected String opCode;
	protected boolean isComplete;

	public Instruction(String opCode) {
		this.opCode = opCode;
	}

	public abstract char getType();

	// 3 Argument version
	public void addArgs(String rd, String rs, String rt) {
	}

	// 1 Argument version
	public void addArgs(String mImm) {
	}
	
	public int getInstructionFormat(){
		return 0;
	}
}
