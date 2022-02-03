package jp.arcanum.numbercheck;



public abstract class CheckBase {
	
	// チェック名称
	public abstract String getCheckName();
	
	// チェックする
	public abstract boolean execute(int num);
	
}