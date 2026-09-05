package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Subscription;

public class SubscriptionService {
	private List<Subscription> subscriptions = new ArrayList<>();
	private int nextId = 1;

	// 1. サブスク登録機能
	public void addSubscription(String name, int price, String category, int renewalDay) {
		Subscription sub = new Subscription(nextId, name, price, category, renewalDay);
		subscriptions.add(sub);
		System.out.println("\n✅ 「" + name + "」を登録しました！（ID: " + nextId + "）");
		nextId++;
	}

	// 2. サブスク一覧表示機能 & 月額合計算出 & ⚠️更新日通知機能
	public void showAllSubscriptions() {
		if (subscriptions.isEmpty()) {
			System.out.println("\n登録されているサブスクはありません。");
			return;
		}

		// 現在の「日」を取得
		int currentDay = LocalDate.now().getDayOfMonth();

		System.out.println("\n=========================================================");
		System.out.println(" ID | サービス名     | 月額料金   | カテゴリ | 更新日 | 状態");
		System.out.println("---------------------------------------------------------");

		int totalPrice = 0;
		for (Subscription sub : subscriptions) {
			int renewalDay = sub.getRenewalDay();

			// 残り日数の計算（更新日が今月の中で残り何日か、または当日の判定）
			int daysLeft = renewalDay - currentDay;
			String status = "";

			if (daysLeft >= 0 && daysLeft <= 3) {
				status = "⚠️解約注意 (あと" + daysLeft + "日)";
			}

			System.out.printf(" %2d | %-12s | %6d円 | %-6s | 毎月%2d日 | %s\n",
					sub.getId(),
					sub.getName(),
					sub.getPrice(),
					sub.getCategory(),
					sub.getRenewalDay(),
					status);
			totalPrice += sub.getPrice();
		}

		System.out.println("---------------------------------------------------------");
		System.out.println(" 毎月の合計金額: " + totalPrice + "円");
		System.out.println("=========================================================");
	}

	// 3. サブスク情報更新機能
	public void updateSubscription(int id, String newName, int newPrice, String newCategory, int newRenewalDay) {
		for (Subscription sub : subscriptions) {
			if (sub.getId() == id) {
				sub.setName(newName);
				sub.setPrice(newPrice);
				sub.setCategory(newCategory);
				sub.setRenewalDay(newRenewalDay);
				System.out.println("\n✅ ID: " + id + " の情報を更新しました！");
				return;
			}
		}
		System.out.println("\n⚠️ 指定されたID (" + id + ") のサブスクが見つかりませんでした。");
	}

	// 4. サブスク削除機能
	public void deleteSubscription(int id) {
		for (int i = 0; i < subscriptions.size(); i++) {
			if (subscriptions.get(i).getId() == id) {
				String removedName = subscriptions.get(i).getName();
				subscriptions.remove(i);
				System.out.println("\n🗑️ 「" + removedName + "」（ID: " + id + "）を解約・削除しました。");
				return;
			}
		}
		System.out.println("\n⚠️ 指定されたID (" + id + ") のサブスクが見つかりませんでした。");
	}
}