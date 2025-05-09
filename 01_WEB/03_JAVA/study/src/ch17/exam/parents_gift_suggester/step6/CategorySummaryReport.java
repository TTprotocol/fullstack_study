package ch17.exam.parents_gift_suggester.step6;

import ch17.exam.parents_gift_suggester.data.GiftRepository;
import ch17.exam.parents_gift_suggester.model.GiftItem;

import java.text.DecimalFormat;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CategorySummaryReport {
    public static void run() {
        List<GiftItem> item = GiftRepository.getGifts();

        DecimalFormat formatter = new DecimalFormat("#,###");

        TreeMap<String, List<GiftItem>> map = item.stream()
            .collect(
                Collectors.groupingBy(
                    GiftItem::getCategory,
                    TreeMap::new,
                    Collectors.toList()
                )
            );

        
    }
}
