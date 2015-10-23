package geniusoj.core.judge.compilers;

import geniusoj.core.data.global.GlobalJudgeConfig;

import java.io.File;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * The Java Compiler
 * @author GISDYT@SS
 *
 */
public class JavaCompiler implements Compiler{

	public static String JAVA_COMPILER_PATH="javac";
	
	@Override
	public String getPrefix() {
		// TODO Auto-generated method stub
		return "default";
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return ".java";
	}

	@Override
	public CompileResult compile(String language, File source_file) {
		// TODO Auto-generated method stub
		CompileResult result=new CompileResult();
		try {
			Process proc=Runtime.getRuntime().exec("\""+JAVA_COMPILER_PATH+"\""+" \""+source_file.toString()+"\"");
			/*TODO problem*/File target_file=new File(source_file.toString().substring(source_file.toString().lastIndexOf(GlobalJudgeConfig.splash)+1, source_file.toString().lastIndexOf(".")));
			//......
		} catch (Exception e) {
			// TODO: handle exception
			result.status=CompileResult.INTERNAL_ERROR;
			result.detail=e.toString();
		}
		return result;
	}
}
