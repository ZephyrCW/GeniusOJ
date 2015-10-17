package geniusoj.core.judge;

import geniusoj.core.util.log.GOJLog;
import geniusoj.core.util.zip.ZipUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 * Class AdditionalFile
 * AdditionalFile can check, copy and unzip the additional file(s) of judgement operation.
 * By invoking the public method, prepare, to start whole progress of finishing prepare of additional file(s).
 * @author GISDYT@SS
 *
 */
public class AdditionalFile {

	public String source_file;
	public String target_path;
	
	public AdditionalFile(String source_file_path, String target_path_s){
		this.source_file=source_file_path;
		this.target_path=target_path_s;
	}
	
	private boolean check(){
		if(new File(target_path).exists() && new File(target_path).isDirectory() && new File(source_file).exists()){
			return true;
		}
		return false;
	}
	
	private boolean copy(){
		try {
			File target_file=new File(new File(target_path).toURI()+"/"+new File(source_file).getName());
			if(target_file.exists()){
				GOJLog.println("Copying judge addtional file,\nsource file: ["+source_file+"]\n["+target_path+"]\nFile already exits.");
				target_file.delete();
			}
			target_file.createNewFile();
			BufferedReader br=new BufferedReader(new FileReader(source_file));
			File source_file=new File(this.source_file);
			PrintWriter pw=new PrintWriter(new FileWriter(target_file));
			String temp;
			while((temp=br.readLine())!=null){
				pw.println(temp);
			}
			br.close();
			pw.close();
			GOJLog.println("Addtional file copying finished.");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			GOJLog.println("Exception thrown by addtional file copyer when copy file ["+source_file+"] into ["+target_path+"]\n"+e.toString());
			return false;
		}
	}
	
	private boolean unzip(){
		if(copy()){
			try {
				new ZipUtil().unZip(new File(target_path).toURI()+"/"+new File(source_file).getName(), target_path, false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				GOJLog.println("Exception thrown by addtional file unziper when unzip judgement script addtional files.");
				return false;
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Yap, you found this. Invoke this to finish the progress of preparing additional file(s).
	 * @return "additional_file_check_error" when file not exites or is read-only.<br/>"additional_file_copy_error" when file can't be copied to target.<br/>"additional_file_unzip_error" when file can't be unziped successfully.<br/>Otherwise, the progress finished successfully, return "addtional_file_operation_finish_successfully"
	 * 
	 */
	public String prepare(){
		if(!check()) return "additional_file_check_error";
		if(!copy()) return "additional_file_copy_error";
		if(!unzip()) return "additional_file_unzip_error";
		return "addtional_file_operation_finish_successfully";
	}
}
