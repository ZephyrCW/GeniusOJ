package geniusoj.core.judge;

import java.util.UUID;

public class Solution {

	public String solution_uuid;
	public Code user_code;
	public Code judge_script;
	public AdditionalFile addal_file;
	
	private static final String usercode_testing_data_1="";
	private static final String judgescript_testing_data_1="";
	
	public Solution(int solution_id){
		//TODO db
		solution_uuid=UUID.randomUUID().toString();
		/*Testing Code Begin*/
		//Integer.MIN_VALUE-1 : usercode direct judgescript direct additional filenon usercode-language Java judgescript-language Java
		switch (solution_id) {
		case Integer.MIN_VALUE-1:
			judge_script=new Code(judgescript_testing_data_1, solution_uuid+".java", "C:\\testing");
			user_code=new Code(usercode_testing_data_1, solution_uuid+".java", "C:\\testing");
			break;

		default:
			break;
		}
		/*Testing Code End*/
		
	}
	
	public void async_judge(){
		
	}
	
	public JudgeReport sync_judge(){
		
		return null;
	}
}
