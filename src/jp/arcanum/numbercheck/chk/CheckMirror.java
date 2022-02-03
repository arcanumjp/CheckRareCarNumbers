package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class CheckMirror extends CheckBase {

	@Override
	public String getCheckName() {
		return "鏡";
	}

	/**
	 * 111 - 999
	 */
	@Override
	public boolean execute(int num) {

		if (num < 1000) {
			return false;
		}
		String numstr = Integer.toString(num);
		
		int left1 = Integer.parseInt(numstr.substring(0, 1));
		int left2 = Integer.parseInt(numstr.substring(1, 2));
		int right2 = Integer.parseInt(numstr.substring(2, 3));
		int right1 = Integer.parseInt(numstr.substring(3, 4));
		
		return (left1 == right1) && (left2 == right2);
		
	}

	
	
}
