# Computer Architecture Processor Assembler

An assembler created to take instructions for a load-store architecture.

## Usage
The assembler takes two inputs, an input file with instructions, and output file where the assembler will output machine code.

## Configuration File
The configuration file sets two maps that correspond to the available registers and available instructions. 

Registers begin with a '#' followed by an underscore, separating the typed value from the register's 3 bit binary address.

Instructions begin with an '@' followed by the instruction name, instruction type, op code, and funk code, if the instruction is an R-Type. 