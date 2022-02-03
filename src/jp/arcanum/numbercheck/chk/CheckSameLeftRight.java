package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class CheckSameLeftRight extends CheckBase {

	@Override
	public String getCheckName() {
		return "左右同じ";
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
		
		String left = numstr.substring(0, 2);
		String right = numstr.substring(2, 4);
		
		return left.equals(right);
		
	}

	
	
}
