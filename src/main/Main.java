package main;

import java.util.Scanner;

import constant.MenuConst;
import service.SubscriptionService;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SubscriptionService service = new SubscriptionService();
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
			scanner.nextLine(); // 改行コードの読み飛ばし

			switch (choice) {
			case MenuConst.ADD:
				System.out.print("サービス名を入力: ");
				String name = scanner.nextLine();
				System.out.print("月額料金（円）を入力: ");
				int price = scanner.nextInt();
				scanner.nextLine();
				System.out.print("カテゴリを入力: ");
				String category = scanner.nextLine();
				System.out.print("毎月の更新日（1〜31）を入力: ");
				int renewalDay = scanner.nextInt();
				scanner.nextLine();

				service.addSubscription(name, price, category, renewalDay);
				break;

			case MenuConst.LIST:
				service.showAllSubscriptions();
				break;

			case MenuConst.UPDATE:
				System.out.print("更新したいサブスクのIDを入力: ");
				int updateId = scanner.nextInt();
				scanner.nextLine();

				System.out.print("新しいサービス名を入力: ");
				String newName = scanner.nextLine();
				System.out.print("新しい月額料金（円）を入力: ");
				int newPrice = scanner.nextInt();
				scanner.nextLine();
				System.out.print("新しいカテゴリを入力: ");
				String newCategory = scanner.nextLine();
				System.out.print("新しい毎月の更新日（1〜31）を入力: ");
				int newRenewalDay = scanner.nextInt();
				scanner.nextLine();

				service.updateSubscription(updateId, newName, newPrice, newCategory, newRenewalDay);
				break;

			case MenuConst.DELETE:
				System.out.print("削除（解約）したいサブスクのIDを入力: ");
				int deleteId = scanner.nextInt();
				scanner.nextLine();

				service.deleteSubscription(deleteId);
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