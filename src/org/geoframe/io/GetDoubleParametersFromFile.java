package org.geoframe.io;

import java.io.File;
//import java.util.*;

//import java.util.Arrays;

import org.geoframe.util.*;

public class GetDoubleParametersFromFile {
//
	File inputFile;

	//private File outputFile;

	public String[] vnames,vunits,var;
	public double[] vls;
	
	public GetDoubleParametersFromFile(){
	
		String inputFileName=CreateFolder.getFileName();
		try{
			TextIO.readFile(inputFileName);
		}catch(IllegalArgumentException ee){
			
		}
		//GetComments assume to know how comments are written in the file. I use the ! (bang) symbol for them
		//For the moment, I do not store the comments
		new GetComments();
		String variablesNames=TextIO.getlnString();
		//System.out.println(variablesNames);
		//System.out.println("000");
		String variablesUnits=TextIO.getlnString();
		//System.out.println("000");
		//System.out.println(variablesUnits);
		String variables=TextIO.getlnString();
		//System.out.println(variables);
		//We assume to know the format but not the number of variables: Names var1name var2name ... varNname
		
		this.vnames=variablesNames.split(" ");
		for(int k=0;k<vnames.length;k++){
			vnames[k]=vnames[k].replaceAll("\\s", "");
			//System.out.println("["+k+"] "+vnames[k]);
		};
		
		this.vunits=variablesUnits.split(" ",vnames.length);
		for(int k=0;k<vnames.length;k++){
			vunits[k]=vunits[k].replaceAll("\\s", "");
			//System.out.println("["+k+"] "+vunits[k]);
		};
		
		this.var=variables.split(" ",vnames.length);

		this.vls=new double[var.length-1];
		
		for(int k=1;k<var.length;k++){
		    vls[k-1]=Double.parseDouble(var[k]);	
			//System.out.println("["+k+"] "+var[k]+"\nThis is a double "+vls[k-1]);
		};
		
		
	}
	
	public static void main(String[] args) {

		System.out.println("This is the GetDoubleParametersFromFiles");
		
		GetDoubleParametersFromFile aDataFrame=new GetDoubleParametersFromFile();
		

		//Just because I know that there are three variables
		System.out.println(aDataFrame.vnames[0]+"\t"+aDataFrame.vnames[1]+"\t"+aDataFrame.vnames[2]);
		System.out.println(aDataFrame.vunits[0]+"\t"+aDataFrame.vunits[1]+"\t"+aDataFrame.vunits[2]);
		System.out.println(aDataFrame.var[0]+"\t"+aDataFrame.vls[0]+"\t"+aDataFrame.vls[1]+"\t");
		
//		System.out.println(Arrays.toString(aDataFrame.vnames));
//		System.out.println(Arrays.toString(aDataFrame.vunits));
//		System.out.println(Arrays.toString(aDataFrame.var));
		
		System.out.println("This ends computation");	
			}

}
