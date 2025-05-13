package ch17.exam.parents_gift_suggester.step6;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CategorySummaryReport {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        DecimalFormat formatter = new DecimalFormat("₩#,###원");

        Map<String, List<GiftItem>> map = item.stream()
                .collect(
                        Collectors.groupingBy(GiftItem::getCategory)
                );

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📦 카테고리별 선물 요약 리포트");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();

        map.forEach((k, v) -> {
            System.out.println("[" + k + "]");
            System.out.println("- 총 개수 \t : " + v.size() + "개");
            System.out.println("- 평균 가격 \t : " + formatter.format(v.stream().mapToInt(GiftItem::getPrice).average().orElse(0)));
            System.out.println("- 최고가 \t : " + formatter.format(v.stream().max(Comparator.comparingInt(GiftItem::getPrice)).get().getPrice()));
            System.out.println("- 최저가 \t : " + formatter.format(v.stream().min(Comparator.comparingInt(GiftItem::getPrice)).get().getPrice()));
            System.out.println();
        });

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("리포트 생성 완료 ✅");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}
