package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class CheckMultiplication extends CheckBase {

	@Override
	public String getCheckName() {
		return "九九";
	}

	/**
	 * 九九になってるか
	 */
	@Override
	public boolean execute(int num) {

		if (num < 100) {
			return false;
		}
		String numstr = Integer.toString(num);
			
		int left = Integer.parseInt(numstr.substring(0, 1));
		int right = Integer.parseInt(numstr.substring(1, 2));
		int answer = Integer.parseInt(numstr.substring(2));

		if (left == 1) {
			return false;	// 1の段は無視
		}
		if (right == 0) {
			return false;	// 0の掛け算は無視
		}
		
		return (left * right == answer);
	
	}
}
