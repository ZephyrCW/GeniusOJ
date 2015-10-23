package geniusoj.core.judge.compilers;

public class CompileResult {

	public static final String COMPILE_SUCCES="compile_success";
	public static final String COMPILE_ERROR="compile_error";
	public static final String INTERNAL_ERROR="internal_error";
	
	/**
	 * compile_success - Compile successfully
	 * compile_error - faliure to compile
	 * internal_error - cannot find file/security problem/etc.
	 */
	public String status;
	
	/**
	 * Compile details
	 */
	public String detail;
	
	/**
	 * The executable target if exits
	 */
	public String target;
}
