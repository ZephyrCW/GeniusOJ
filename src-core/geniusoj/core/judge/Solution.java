package geniusoj.core.judge;

import java.util.UUID;

public class Solution {

	public String solution_uuid;
	public UserCode user_code;
	public JudgeScript judge_script;
	public AdditionalFile addal_file;
	
	public Solution(int solution_id){
		//TODO db
		solution_uuid=UUID.randomUUID().toString();
	}
}
