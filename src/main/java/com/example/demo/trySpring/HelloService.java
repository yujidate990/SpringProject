package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ②：controllerクラスからサービス実行依頼が来るので
 * ③：repositoryクラスにSQL実行してもらうよう指示するビジネスロジッククラス
 * ⑥：③の結果が届くので
 * ⑦：contorollerクラスに返却するクラス
 *
 * @author datey
 *
 */
@Service
public class HelloService {

	@Autowired //Repositoryクラスのインスタンスを生成
	private HelloRepository helloRepository;

	/**
	 * RepositoryクラスのfindOneを実行し<br>受け取ったMap型のSELECT結果を<br>domainクラスにセットして返却するメソッド
	 * @param id 検索条件のemployee_id
	 * @return domainクラスのEmployee型
	 */
	public Employee findOne(int id) {

		// 1件検索
		Map<String, Object> map = helloRepository.findOne(id);

		// Mapから値(value)を取得。
		// DBのカラム名(key)でgetし、わかりやすいようにdomainクラスと同じ変数名で格納
		int employeeId = (Integer)map.get("employee_id");
		String employeeName = (String)map.get("employee_name");
		int age = (Integer)map.get("age");

		// Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);

		return employee;
	}

}
