package com.bsu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void ifValidCheck(){
        List<String> mails = new ArrayList<String>();
        mails.add("mark@facebook.com");
        mails.add("TimCook@icloud.com");
        mails.add("Larry+-*/Page@google.com");
        mails.add("guriev-yandex.ru");
        mails.add("gov.mvd@info.by");
        assertEquals(Main.ifValid(mails.get(0)), 1);
        assertEquals(Main.ifValid(mails.get(1)), 1);
        assertEquals(Main.ifValid(mails.get(2)), 0);
        assertEquals(Main.ifValid(mails.get(3)), 0);
        assertEquals(Main.ifValid(mails.get(4)), 1);
        }

    }

