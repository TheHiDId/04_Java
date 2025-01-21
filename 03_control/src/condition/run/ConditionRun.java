package condition.run;

import condition.service.ConditionService;

/**
 * 실행용 클래스
 */
public class ConditionRun {
	public static void main(String[] args) {
		ConditionService service = new ConditionService();
		
		// service.method1();
		// service.method2();
		// service.method3();
		service.displayMenu();
	}
}