package geniusoj.core.judge;

import geniusoj.core.util.log.GOJLog;

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
	
	public interface JudgeCallback{
		
		public void judgeFinished(JudgeReport report);
	}
	
	public void async_judge(JudgeCallback cb){
		new Thread(){
			
			@Override
			public void run(){
				GOJLog.println("Async judge start to progress with uuid: ["+solution_uuid+"] ......");
				cb.judgeFinished(sync_judge());
				GOJLog.println("Async judge progress finish with uuid: ["+solution_uuid+"] ......");
			}
		}.start();
	}
	
	public JudgeReport sync_judge(){
		
		return null;
	}
}
