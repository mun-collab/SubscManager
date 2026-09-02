package main;

import java.util.Scanner;

import constant.MenuConst;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("\n==============================");
			System.out.println("   SubscManager (サブスク管理)");
			System.out.println("==============================");
			System.out.println("1. サブスク登録");
			System.out.println("2. サブスク一覧表示");
			System.out.println("3. サブスク情報更新");
			System.out.println("4. サブスク削除");
			System.out.println("0. 終了");
			System.out.println("------------------------------");
			System.out.print("メニュー番号を入力してください: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case MenuConst.ADD:
				System.out.println("【未実装】登録処理呼び出し");
				break;
			case MenuConst.LIST:
				System.out.println("【未実装】一覧表示処理呼び出し");
				break;
			case MenuConst.UPDATE:
				System.out.println("【未実装】更新処理呼び出し");
				break;
			case MenuConst.DELETE:
				System.out.println("【未実装】削除処理呼び出し");
				break;
			case MenuConst.EXIT:
				System.out.println("アプリを終了します。");
				running = false;
				break;
			default:
				System.out.println("無効な番号です。もう一度入力してください。");
			}
		}
		scanner.close();
	}
}