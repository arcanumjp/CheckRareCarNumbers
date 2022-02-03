package jp.arcanum.numbercheck.chk;

import jp.arcanum.numbercheck.CheckBase;

public class CheckGoroawase extends CheckBase {

	@Override
	public String getCheckName() {
		return "語呂合わせ";
	}

	private static String[] goros = {
			"5963",	// ご苦労さん
			"4649",	// 宜しく
			"3476",	// さよなら
			"1984",	// いくわよ！
			"1374",	// 意味無し
			"2525",	// ニコニコ
			"5909",	// 極楽
			"3156",	// サイコロ
			"3470",	// さよなら
			"4989",	// 四苦八苦
			"",	//
			"",	//
			"",	//
			"",	//
			"",	//
			"",	//
	};
	
	/**
	 * 九九になってるか
	 */
	@Override
	public boolean execute(int num) {

		String numstr = Integer.toString(num);
		for (String str : goros) {
			if (str.equals(numstr)) {
				return true;
			}
		}
		return false;
	}
}
