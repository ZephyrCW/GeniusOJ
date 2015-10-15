package geniusoj.core.judge;

public class Solution {

	public UserCode user_code;
	public JudgeScript judge_script;
	
	public Solution(UserCode code, JudgeScript script){
		this.user_code=code;
		this.judge_script=script;
	}
}
