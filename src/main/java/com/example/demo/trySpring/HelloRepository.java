package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ④：dbへのCRUDを行い
 * ⑤：結果を返却するクラス
 * @author datey
 */

@Repository
public class HelloRepository {

	@Autowired //new JdbcTmplate()のイメージ。インスタンスを生成してる感じ
	private JdbcTemplate jdbcTemplate;

	/**
	 * idをWhere句に入れて、jdbcのqueryForMapメソッドにてSELECT文実行するメソッド
	 *
	 * @param id 検索条件のemployee_id
	 * @return カラム名(key)にSELECT結果の値(value)がマッピング（紐付け）されたMap型。1レコードにつき3つのkeyとvalueがある
	 */
	public Map<String, Object> findOne(int id) {

		String query = "SELECT "
				+ " employee_id,"
				+ " employee_name,"
				+ " age"
				+ " FROM employee "
				+ "WHERE employee_id = ?";

		Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);

		return employee;
	}

}
