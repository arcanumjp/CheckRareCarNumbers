package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class Check1to9 extends CheckBase {

	@Override
	public String getCheckName() {
		return "1-9";
	}

	@Override
	public boolean execute(int num) {

		if (1 <= num && num <= 9 ) {
			return true;
		}
		return false;
	}
	
	
}

