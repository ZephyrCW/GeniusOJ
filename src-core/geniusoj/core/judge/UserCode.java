package geniusoj.core.judge;

//%%url%% 代表下面的字符串不是usercode而是usercode上传路径
public class UserCode {

	public String user_code;
	public String user_code_path;
	public String target_path;
	
	public static final String path_flag="%%url%%";
	
	public UserCode(String user_code_string, String target_file, String target){
		target_path=target;
		if(user_code_string.substring(0, path_flag.length()+1).equals(path_flag)){
			user_code="";
			user_code_path=user_code_string.substring(path_flag.length()+1);
		}else{
			user_code=user_code_string;
			user_code_path="";
		}
	}
	
	private boolean file_check(){
		
	}
	
	private boolean readyForJudge(){
		
	}
	
	private boolean copy(){
		
	}
	
	private boolean write(){
		
	}
	
	private boolean security_check(){
		
	}
	
	public String prepare(){
		
	}
}
