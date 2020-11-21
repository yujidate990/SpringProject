package com.example.demo.trySpring;

import lombok.Data;

/**
 * domainクラス（DTO）
 * 
 * @author datey
 *
 */
@Data //setter, getterをlombokが自動生成してくれる

// domainClass : リポジトリークラスやサービスクラスの間などで渡すクラスのこと。DTOともいう
public class Employee {

	private int employeeId;
	private String employeeName;
	private int age;
}
