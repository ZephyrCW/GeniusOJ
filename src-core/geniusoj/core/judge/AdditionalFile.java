package geniusoj.core.judge;

import geniusoj.core.util.log.GOJLog;
import geniusoj.core.util.zip.ZipUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

public class AdditionalFile {

	public String source_file;
	public String target_path;
	
	public AdditionalFile(String source_file_path, String target_path_s){
		this.source_file=source_file_path;
		this.target_path=target_path_s;
	}
	
	public boolean check(){
		if(new File(target_path).exists() && new File(target_path).isDirectory() && new File(source_file).exists()){
			return true;
		}
		return false;
	}
	
	public boolean copy(){
		if(!check()){
			GOJLog.println("File didn't found when copying judgement script addtional files.");
			return false;
		}
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
	
	public boolean unzip(){
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
	
	public static void main(String[] args) throws MalformedURLException {
		
	}
}
