package ru.qa_guru3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize= "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form"); //Открываю вкладку "automation-practice-form"
        $("#firstName").setValue("Pavel"); // Вписываю имя в userName
        $("#lastName").setValue("Nasonov"); // Вписываю фамилию в lastName
        $("#userEmail").setValue("4laste@gmail.com"); //Вписываю Email
        $(By.id("genterWrapper")).$(byText("Male")).click();
        $("#userNumber").setValue("9857974787"); //Выставлю номер телефона
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("May")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1993")).click();
        $(".react-datepicker__day--009").click();
    }
}