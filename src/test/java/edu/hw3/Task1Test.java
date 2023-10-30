package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static edu.hw3.Task1.encode;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Тест шифрования одиночных символов")
    public void singleCharEncodeTest() {
        assertEquals(encode('A'), 'Z');

        assertEquals(encode('B'), 'Y');

        assertEquals(encode('a'), 'z');

        assertEquals(encode('m'), 'n');

        assertEquals(encode('П'), 'П');

        assertEquals(encode('!'), '!');
    }

    @Test
    @DisplayName("Тест шифрования строки")
    public void stringEncodeTest() {
        assertEquals(atbash("Hello world!"), "Svool dliow!");

        assertEquals(
            atbash(
                "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler"),
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
        );

        assertEquals(atbash("Megamind"), "Nvtznrmw");
    }

    @Test
    @DisplayName("Проверка на шифрования на латинских символов")
    public void notLatinCharsTest() {
        assertEquals(atbash("Привет, мир!"), "Привет, мир!");

        assertEquals(atbash("123абв"), "123абв");
    }

    @Test
    @DisplayName("Проверка шифрования пустой строки")
    public void emptyStringTest() {
        assertEquals(atbash(""), "");
    }
}
