package io;

import java.util.HashMap;
import java.util.Map;

import config.IType;
import config.Instruction;
import config.JType;
import config.RType;

public class ReadConfig extends ReadFile{
	private Map<String, String> regMap; //Maps a string representation to a binary number
	private Map<String, Instruction> instMap; //Maps a string instruction to an instruction object
	
	public ReadConfig(String path){
		super(path);
		this.regMap = new HashMap<>();
		this.instMap = new HashMap<>();
	}
	
	public void readLine(String line){
		if(line.length() != 0){
			String[] segments = line.substring(1).split("_");
			Instruction inst = null;

			if(line.substring(0,1).equals("#")){
				// A register config
				regMap.put(segments[0],segments[1]);
				
			}else if(line.substring(0,1).equals("@")){
				// An instruction config
				if(segments[1].equals("R")){
					inst = new RType(segments[2], segments[3]); 
				}else if(segments[1].substring(0,1).equals("I")){
					if(segments[1].substring(1).equals("0")){
						inst = new IType(segments[2],0);
					} else{
						inst = new IType(segments[2],1);
					}
					
				}else if(segments[1].equals("J")){
					inst = new JType(segments[2]);
				}
				
				instMap.put(segments[0], inst);
			}
		}
	}
	
	public Pair<Map<String,String>, Map<String, Instruction>> getPair(){
		return new Pair(this.regMap, this.instMap);
	}
	
	public void printVals(){
		for (String key : regMap.keySet()) {
			System.out.println(key);
		}
		for (String key : instMap.keySet()) {
			System.out.println(key);
		}
	}
	
}
