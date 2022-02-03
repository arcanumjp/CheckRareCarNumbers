package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class CheckZorome extends CheckBase {

	@Override
	public String getCheckName() {
		return "ゾロ目";
	}

	/**
	 * 111 - 999
	 */
	@Override
	public boolean execute(int num) {

		if (num < 100) {
			return false;
		}
		
		boolean isZorome = true;
		String numstr = Integer.toString(num);
		String exnumstr = numstr.substring(0, 1);
		for (int i = 1 ; i < numstr.length(); i++){
			String target = numstr.substring(i, i+1);
			if (!exnumstr.equals(target)) {
				isZorome = false;
				break;
			}
		}
		return isZorome;
	}

	
	
}
