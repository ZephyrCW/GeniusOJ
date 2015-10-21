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
 * Class UserCode
 * UserCode can check, copy or write and security check the usercode of judgement operation.
 * By invoking the public method, prepare, to start whole progress of finishing prepare of usercode.
 * %%url%% is special delerting string.
 * @author GISDYT@SS
 *
 */
public class UserCode {

	public String user_code;
	public String user_code_path;
	public String target_path;
	
	public static final String path_flag="%%url%%";
	
	public String target_file;
	public UserCode(String user_code_string, String target_file, String target){
		target_path=target;
		this.target_file=target_file;
		if(user_code_string.substring(0, path_flag.length()+1).equals(path_flag)){
			user_code="";
			user_code_path=user_code_string.substring(path_flag.length()+1);
		}else{
			user_code=user_code_string;
			user_code_path="";
		}
	}
	
	private boolean check(){
		if(!user_code_path.equals("") && !new File(user_code_path).exists()){
			return false;
		}
		return true;
	}
	
	private boolean copy(){
		File source=new File(user_code);
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
				GOJLog.println("An exception was thrown when copy UserCode.\n"+e.toString());
			}
		}
		return false;
	}
	
	private boolean write(){
		if(user_code_path.equals("")){
			File target=new File(new File(target_path).toURI()+"/"+target_file);
			if(target.exists()) {
				target.delete();
				try {
					target.createNewFile();
					return true;
				} catch (IOException e) {
					// TODO: handle exception
					GOJLog.println("Cannot create new file when write UserCode.");
				}
			}
			try {
				PrintWriter pw=new PrintWriter(target);
				pw.print(user_code);
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
	 * Invoke this method to prepare the usercode.
	 * @return "usercode_security_check_error" means that usercode don't pass the security check.<br/>"usercode_write_error" means that we can't write or copy usercode.<br/>"usercode_file_check_error" means that we cannot find the file or target path.<br/>Otherwise, usercode writing finish successfully, return "usercode_"
	 */
	public String prepare(){
		if(!check()) return "usercode_file_check_error";
		if(security()) return "usercode_security_check_error";
		if(write()) return "usercode_write_error";
		return "usercode_operation_finish_successfully";
	}
}
