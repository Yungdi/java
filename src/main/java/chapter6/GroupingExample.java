package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingExample {

    // 통화별로 트랜잭션 리스트를 그룹화하시오
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction(),
            new Transaction(),
            new Transaction(),
            new Transaction(),
            new Transaction()
        );

        Map<Currency, List<Transaction>> transactionsByCurrencies1 = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            if (!transactionsByCurrencies1.containsKey(currency)) {
                transactionsByCurrencies1.put(currency, new ArrayList<>());
            }
            transactionsByCurrencies1.get(currency).add(transaction);
        }

        Map<Currency, List<Transaction>> transactionsByCurrencies2 = transactions.stream()
            .collect(Collectors.groupingBy(Transaction::getCurrency));
    }
}