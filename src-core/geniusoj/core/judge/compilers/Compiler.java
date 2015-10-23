package geniusoj.core.judge.compilers;

import java.io.File;

public interface Compiler {

	/**
	 * default if no prefix
	 * @return prefix to filter
	 */
	public String getPrefix();
	
	/**
	 * default if no suffix
	 * @return suffix to filter
	 */
	public String getSuffix();
	
	public CompileResult compile(String language, File source_file);
}
