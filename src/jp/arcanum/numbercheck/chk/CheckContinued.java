package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

/**
 * 続き数字かどうか
 * @author hosokawashinya
 *
 */
public class CheckContinued extends CheckBase {

	@Override
	public String getCheckName() {
		return "続き数字";
	}

	@Override
	public boolean execute(int num) {

		if (num < 100) {
			return false;
		}
		String numstr = Integer.toString(num);
		
		// 123, 456 1234 ...
		{
			int exnum = Integer.parseInt(numstr.substring(0, 1));
			boolean isContinue = true;
			for (int i = 1 ; i < numstr.length(); i++) {
				Integer target = Integer.parseInt(numstr.substring(i, i + 1));
				if (target != exnum + 1) {
					isContinue = false;
					break;
				}
				exnum = target;
			}
			if (isContinue) {
				System.out.println(num + "is continue - 1");
				return true;
			}
		}
		
		// 4321, 654, 321
		{
			int exnum = Integer.parseInt(numstr.substring(0, 1));
			boolean isContinue = true;
			for (int i = 1 ; i < numstr.length(); i++) {
				Integer target = Integer.parseInt(numstr.substring(i, i + 1));
				if (target != exnum - 1) {
					isContinue = false;
					break;
				}
				exnum = target;
			}
			if (isContinue) {
				System.out.println(num + "is continue - 1");
				return true;
			}
		}
			
		return false;
		
	}
	
	
}

