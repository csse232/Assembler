package config;

public class JType extends Instruction{
	private static char type = 'j';
	private String imm;
	
	public JType(String mOpCode, String mImm){
		super(mOpCode);
		this.imm = mImm;
		this.isComplete = true;
	}
	
	public JType(String mOpCode){
		super(mOpCode);
		this.isComplete = false;
	}
	
	public void addArgs(String mImm){
		this.imm = mImm;
	}
	
	@Override
	public String toString(){
		return this.opCode + this.imm;
	}
	
	public char getType(){
		return JType.type;
	}
}
