package com.mycompany.app;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {
    public static void execute() {
        System.out.println("Выполнение Задания №2 - Получение IP-адреса");
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get("https://api.ipify.org/?format=json");
            WebElement elem = webDriver.findElement(By.tagName("pre"));
            
            String json_str = elem.getText();
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(json_str);
            String ip = (String) obj.get("ip");
            
            System.out.println("IP-адрес: " + ip);
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("Ошибка при выполнении Задания №2");
            System.out.println(e.toString());
        } finally {
            webDriver.quit();
        }
    }
} 