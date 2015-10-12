package config;

/**
 * 
 * 
 * @author schmitml
 *
 */
public class IType extends Instruction{
	private static char type = 'i';
	private String rd;
	private String rs;
	private String imm;
	private int instuctionFormat; // 0 is addi #T0 #T0 1
								// 1 is lw #T0 imm(#T1)
	
	public IType(String mOpCode, String rd, String rs, String imm) {
		super(mOpCode);
		this.rd = rd;
		this.rs = rs;
		this.imm = imm;
		this.isComplete = true;
	}
	
	public IType(String mOpCode, int instructionType){
		super(mOpCode);
		this.instuctionFormat = instructionType;
		this.isComplete = false;
	}
	
	public void addArgs(String rd, String rs, String imm){
		this.rd = rd;
		this.rs = rs;
		this.imm = imm;
	}
	
	public void addArgs(String rd, String imm){
		this.rd = rd;
		this.imm = imm;
	}

	@Override
	public String toString(){
		return this.opCode + this.rd + this.rs + this.imm;
	}
	
	public char getType(){
		return IType.type;
	}
	
	public int getInstructionFormat(){
		return this.instuctionFormat;
	}
}
