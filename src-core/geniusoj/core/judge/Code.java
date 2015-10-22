package geniusoj.core.judge;

import geniusoj.core.data.global.GlobalJudgeConfig;
import geniusoj.core.util.log.GOJLog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * Class Code
 * Code can check, copy or write and security check the code or judgescript of judgement operation.
 * By invoking the public method, prepare, to start whole progress of finishing prepare of code or judgescript.
 * %%url%% is special delerting string.
 * @author GISDYT@SS
 *
 */
public class Code {

	public String code;
	public String code_path;
	public String target_path;
	public String target_file;
	
	public static final String path_flag="%%url%%";
	
	public Code(String user_code_string, String target_file, String target){
		target_path=target;
		this.target_file=target_file;
		if(user_code_string.substring(0, path_flag.length()+1).equals(path_flag)){
			code="";
			code_path=user_code_string.substring(path_flag.length()+1);
		}else{
			code=user_code_string;
			code_path="";
		}
	}
	
	private boolean check(){
		if(!code_path.equals("") && !new File(code_path).exists()){
			return false;
		}
		return true;
	}
	
	private boolean copy(){
		File source=new File(code);
		File target=new File(target_path);
		if(target.exists() && source.exists()){
			try {
				BufferedReader br=new BufferedReader(new FileReader(source));
				PrintWriter pw=new PrintWriter(target.toURI().toString()+"/"+target_file);
				String temp;
				while((temp=br.readLine())!=null){
					pw.println(temp);
				}
				br.close();
				pw.close();
				return true;
			} catch (IOException e) {
				// TODO: handle exception
				GOJLog.println("An exception was thrown when copy code.\n"+e.toString());
			}
		}
		return false;
	}
	
	private boolean write(){
		if(code_path.equals("")){
			File target=new File(new File(target_path).toURI()+"/"+target_file);
			if(target.exists()) {
				target.delete();
				try {
					target.createNewFile();
					return true;
				} catch (IOException e) {
					// TODO: handle exception
					GOJLog.println("Cannot create new file when write code.");
				}
			}
			try {
				PrintWriter pw=new PrintWriter(target);
				pw.print(code);
				pw.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
			return false;
		}else{
			return copy();
		}
	}
	
	private boolean security(){
		if(GlobalJudgeConfig.use_source_code_security_check){
			//TODO Security checking
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 
	 * Invoke this method to prepare the code or judgescript.
	 * @return "code_security_check_error" means that code or judgescript don't pass the security check.<br/>"code_write_error" means that we can't write or copy code.<br/>"code_file_check_error" means that we cannot find the file or target path.<br/>Otherwise, code writing finish successfully, return "code_"
	 * 
	 */
	public String prepare(){
		if(!check()) return "code_file_check_error";
		if(security()) return "code_security_check_error";
		if(write()) return "code_write_error";
		return "code_operation_finish_successfully";
	}
}
