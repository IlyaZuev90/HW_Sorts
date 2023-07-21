package ru.netology.sorts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class AviaSoulsTest {

    @Test
    void getFrom() {
    }

    @Test
    void getTo() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void getTimeFrom() {
    }

    @Test
    void getTimeTo() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void shouldCompareToPositiveScenario() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Калыма", 50_000, 9, 16);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
        System.out.println("Сравнение меньшего с большим");
        System.out.println("Ожидаемое: " + expected + " " + "Фактичекое: " + actual);
        System.out.println();

    }

    @Test
    void shouldTestFindAll() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 9, 16);
        Ticket ticket3 = new Ticket("Москва", "Петропавловск-Камчатск", 22_000, 12, 15);
        Ticket ticket4 = new Ticket("Москва", "Петропавловск-Камчатск", 60_000, 9, 12);
        Ticket ticket5 = new Ticket("Москва", "Петропавловск-Камчатск", 35_000, 11, 15);

        AviaSouls t = new AviaSouls();

        t.add(ticket1);
        t.add(ticket2);
        t.add(ticket3);
        t.add(ticket4);
        t.add(ticket5);

        String from = "Москва";
        String to = "Петропавловск-Камчатск";

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = t.findAll();

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Поиск всех билетов");
        Arrays.asList(actual).stream().forEach(s -> System.out.println(s));
        System.out.println();

    }

    @Test
    void shouldCompareToNegativeScenario() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 50_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Калыма", 40_000, 9, 16);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
        System.out.println("Сравнение большего с меньшим");
        System.out.println("Ожидаемое: " + expected + " " + "Фактичекое: " + actual);
        System.out.println();

    }

    @Test
    void shouldCompareToEqualScenario() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Калыма", 40_000, 9, 16);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
        System.out.println("Сравнение одинаковых параметров");
        System.out.println("Ожидаемое: " + expected + " " + "Фактичекое: " + actual);
        System.out.println();

    }

    @Test
    void search() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 9, 16);
        Ticket ticket3 = new Ticket("Москва", "Петропавловск-Камчатск", 22_000, 12, 15);
        Ticket ticket4 = new Ticket("Москва", "Петропавловск-Камчатск", 60_000, 9, 12);
        Ticket ticket5 = new Ticket("Москва", "Петропавловск-Камчатск", 35_000, 11, 15);

        AviaSouls t = new AviaSouls();

        t.add(ticket1);
        t.add(ticket2);
        t.add(ticket3);
        t.add(ticket4);
        t.add(ticket5);

        String from = "Москва";
        String to = "Петропавловск-Камчатск";

        Ticket[] expected = {ticket3, ticket5, ticket1, ticket2, ticket4};
        Ticket[] actual = t.search(from, to);

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Поиск с сортировкой по цене билета");
        Arrays.asList(actual).stream().forEach(s -> System.out.println(s));
        System.out.println();
    }

    @Test
    void shouldSearchOne() {
        Ticket ticket1 = new Ticket("Москва", "Санкт-Петербург", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 9, 16);
        Ticket ticket3 = new Ticket("Москва", "Коломна", 22_000, 12, 15);
        Ticket ticket4 = new Ticket("Москва", "Самара", 60_000, 9, 12);
        Ticket ticket5 = new Ticket("Москва", "Саратов", 35_000, 11, 15);

        AviaSouls t = new AviaSouls();

        t.add(ticket1);
        t.add(ticket2);
        t.add(ticket3);
        t.add(ticket4);
        t.add(ticket5);

        String from = "Москва";
        String to = "Петропавловск-Камчатск";

        Ticket[] expected = {ticket2};
        Ticket[] actual = t.search(from, to);

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Поиск только одного элемента, удовлетворяющего условиям");
        Arrays.asList(actual).stream().forEach(s -> System.out.println(s));
        System.out.println();
    }

    @Test
    void shouldSearchNothing() {
        Ticket ticket1 = new Ticket("Москва", "Урюпинск", 40_000, 3, 12);
        Ticket ticket2 = new Ticket("Москва", "Калининград", 40_000, 9, 16);
        Ticket ticket3 = new Ticket("Москва", "Коломна", 22_000, 12, 15);
        Ticket ticket4 = new Ticket("Москва", "Самара", 60_000, 9, 12);
        Ticket ticket5 = new Ticket("Москва", "Саратов", 35_000, 11, 15);

        AviaSouls t = new AviaSouls();

        t.add(ticket1);
        t.add(ticket2);
        t.add(ticket3);
        t.add(ticket4);
        t.add(ticket5);

        String from = "Москва";
        String to = "Петропавловск-Камчатск";

        Ticket[] expected = {};
        Ticket[] actual = t.search(from, to);

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Негативный сценарий поиска");
        Arrays.asList(actual).stream().forEach(s -> System.out.println(s));
        System.out.println();
    }

    @Test
    void searchAndSortBy() {
        Ticket ticket1 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 3, 12); // 9
        Ticket ticket2 = new Ticket("Москва", "Петропавловск-Камчатск", 40_000, 9, 16); // 7
        Ticket ticket3 = new Ticket("Москва", "Петропавловск-Камчатск", 22_000, 12, 15); // 3
        Ticket ticket4 = new Ticket("Москва", "Петропавловск-Камчатск", 60_000, 9, 12); // 3
        Ticket ticket5 = new Ticket("Москва", "Петропавловск-Камчатск", 35_000, 11, 15); // 4

        AviaSouls t = new AviaSouls();

        t.add(ticket1);
        t.add(ticket2);
        t.add(ticket3);
        t.add(ticket4);
        t.add(ticket5);

        String from = "Москва";
        String to = "Петропавловск-Камчатск";

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket3, ticket4, ticket5, ticket2, ticket1};
        Ticket[] actual = t.searchAndSortBy(from, to, ticketTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
        System.out.println("Тест на сортировку по продолжительности полета");
        Arrays.asList(actual).stream().forEach(s -> System.out.println(s));
        System.out.println();
    }
}
