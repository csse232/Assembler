package config;

public class RType extends Instruction{
	private static char type = 'r';
	private String rd;
	private String rs;
	private String rt;
	private String funk;
	
	public RType(String mOpCode, String rd, String rs, String rt, String funk) {
		super(mOpCode);
		this.rd = rd;
		this.rs = rs;
		this.rt = rt;
		this.funk = funk;
		this.isComplete = true;
	}
	
	public RType(String mOpCode, String funk){
		super(mOpCode);
		this.funk = funk;
		this.isComplete = false;
	}
	
	public void addArgs( String rd, String rs, String rt){
		this.rd = rd;
		this.rs = rs;
		this.rt = rt;
	}
	
	@Override
	public String toString(){
		return this.opCode + this.rd + this.rs + this.rt + this.funk;
	}
	
	public char getType(){
		return RType.type;
	}
}
