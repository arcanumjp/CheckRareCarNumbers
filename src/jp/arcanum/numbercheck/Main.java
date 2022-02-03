package jp.arcanum.numbercheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.arcanum.numbercheck.chk.Check1to9;
import jp.arcanum.numbercheck.chk.CheckContinued;
import jp.arcanum.numbercheck.chk.CheckGoroawase;
import jp.arcanum.numbercheck.chk.CheckMirror;
import jp.arcanum.numbercheck.chk.CheckMultiplication;
import jp.arcanum.numbercheck.chk.CheckSameLeftRight;
import jp.arcanum.numbercheck.chk.CheckZorome;

public class Main {
	
	private static List<CheckBase> _checklist = new ArrayList<CheckBase>();
	static {
		_checklist.add(new Check1to9());
		_checklist.add(new CheckZorome());
		_checklist.add(new CheckContinued());
		_checklist.add(new CheckMultiplication());
		_checklist.add(new CheckMirror());
		_checklist.add(new CheckGoroawase());
		_checklist.add(new CheckSameLeftRight());
	};
	
	private static Map<CheckBase, Result> _rareResultMap = new HashMap<CheckBase, Result>();
	static {
		for (CheckBase chk : _checklist) {
			Result result = new Result();
			result.checkName = chk.getCheckName();
			_rareResultMap.put(chk, result);
		}
	}
	private static Result _notRare = new Result();
	
	public static void main(String[] args) {
		
		System.out.println("======================================");
		System.out.println("珍しい車のナンバーはどれぐらいあるのかチェック");
		System.out.println("======================================");
		
		for (int i = 1 ; i <= 9999; i++) {
			System.out.println("■ " + i + " -----------");
			boolean isNotRare = true;
			for (CheckBase chk : _checklist) {
				boolean isRare = chk.execute(i);
				if (isRare) {
					isNotRare = false;
					//System.out.println("  " + chk.getCheckName() + " --> " + (isRare ? "珍しい" : "珍しくない" ));
					Result result = _rareResultMap.get(chk);
					result.includes.add(i);
				}
			}
			if (isNotRare) {
				_notRare.includes.add(i);
			}
		}
		
		System.out.println("======================================");
		System.out.println("結果発表！");
		System.out.println("======================================");
		
		Iterator<CheckBase> ite = _rareResultMap.keySet().iterator();
		while (ite.hasNext()) {
			CheckBase chk = ite.next();
			Result result = _rareResultMap.get(chk);
			System.out.println("* " + result.checkName + " (" + result.includes.size() + "件)");
			String nums = "";
			for (int num : result.includes) {
				if (!nums.equals("")) {
					nums = nums + ", ";
				}
				nums = nums + num;
			}
			System.out.println(nums);
		}
		System.out.println("* 平凡なヤツ達..." + " (" + _notRare.includes.size() + "件)");
		String nums = "";
		for (int num : _notRare.includes) {
			if (!nums.equals("")) {
				nums = nums + ", ";
			}
			nums = nums + num;
		}
		System.out.println(nums);
		
		
	}
	
}
