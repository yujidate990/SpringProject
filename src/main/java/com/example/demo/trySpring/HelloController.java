package com.example.demo.trySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * HelloWorldを表示するクラス
 * ポストテスト用の文字を出力するクラス
 *
 * ①：画面からのPOSTリクエストを受け取る
 * ②：①のパラメータを使ってサービスクラスを実行
 * ⑦：サービスクラスの結果を受け取り
 * ⑧：Model登録し、画面表示する
 *
 * @author datey
 *
 */

@Controller
public class HelloController {

	@Autowired //サービスクラスのインスタンス生成
	private HelloService helloService;

	@GetMapping("/hello") //localhost:8080/helloへのgetリクエストに対する処理を行う
	public String getHello() {
		return "hello"; //拡張子なしのhtmlファイル名を指定する：resources/templatesからのパス
	}

	@PostMapping("/hello")
	public String postRequest(@RequestParam("testText1") String str, Model model) {
		model.addAttribute("sample", str); //sampleというキーで、引数のstrをセット：modelに登録
		return "helloResponse";
	}


	/**
	 * hello.htmlからのPOSTリクエストのパラメータ（従業員ID）にて、<br>Serviceクラスを実行してdomainクラスを受け取る。
	 * domainクラスの値をModelに登録して、htmlが"id","name","age"を受け取れるようにし、結果表示用のhtmlを返却するメソッド
	 * @param str
	 * @param model
	 * @return 結果表示用のhtml
	 */
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("testText2") String str, Model model) { //htmlのname属性に対応するvalueが引数になる

		// employeeIdをintに型変換
		int id = Integer.parseInt(str);

		// serviceクラス実行
		Employee employee = helloService.findOne(id);

		// 画面に渡すために、Modelに登録
		model.addAttribute("id", employee.getEmployeeId());
		model.addAttribute("name", employee.getEmployeeName());
		model.addAttribute("age", employee.getAge());

		return "helloResponseDB";
	}
}
