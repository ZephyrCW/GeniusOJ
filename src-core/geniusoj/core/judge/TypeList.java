package geniusoj.core.judge;

/**
 * 
 * WARNING: this class is used to provide prefixs and suffix. it also register all of the compiler and runner, so that's the only one class which don't in role OO2;
 * @author GISDYT@SS
 *
 */
public class TypeList {

	public static final String JUDGESCRIPT_PREFIX="jscript_";
	public static final String USERCODE_PREFIX="userc_";
	public static final String ADDITIONALFILE_PREFIX="addf_";
	
	public static final String JAVA_SUFFIX=".java";
	public static final String CPP_SUFFIX=".cpp";
	
	public static void register_compilers(){
		
	}
	
	public static void register_runners(){
		
	}
}
