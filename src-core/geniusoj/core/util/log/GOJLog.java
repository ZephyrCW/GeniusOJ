package geniusoj.core.util.log;

import java.util.Date;

public class GOJLog {

	public static boolean print_log=true;
	public static final String LOG_PREFIX="[LOG][GeniusOJ]["+new Date().toString()+"]";
	
	public static void print(String s){
		if(print_log) System.out.print(LOG_PREFIX+s);
	}
	
	public static void println(String s){
		if(print_log) System.out.println(LOG_PREFIX+s);
	}
}
