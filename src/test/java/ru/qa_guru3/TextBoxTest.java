package ru.qa_guru3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

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
        $("#dateOfBirthInput").click(); // Выбираю таблицу  с выбором даты
        $(".react-datepicker__month-select").click(); // Выбираю поле месяц
        $(byText("May")).click(); // Клик по нужному месяцу
        $(".react-datepicker__year-select").click(); // Выбираю поле год
        $(byText("1993")).click(); // Клик по нужному году
        $(".react-datepicker__day--009").shouldBe(visible).click();; // Клик по нужному числу
        $(".css-2b097c-container").click();
        $(".css-2b097c-container input").setValue("English").pressEnter(); //Выбираю subjects
        $(By.id("hobbiesWrapper")).$(byText("Sports")).click(); // Выбираю одно хобби
        $("#uploadPicture").uploadFromClasspath("Image.jpg"); // Загружаю картинку
        $("#currentAddress").setValue("Govnyaevo street , 14/5 house , 23 apts.");
        $("#state").click();
        $(byText("Rajasthan")).shouldBe(visible).click();
        $("#city").click();
        $(byText("Jaipur")).click();
        $("#submit").click();

        $(".modal-dialog ").shouldBe(visible);
        $(".modal-body").shouldHave(text("Pavel Nasonov"));
        $(".modal-body").shouldHave(text("4laste@gmail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9857974787"));
        $(".modal-body").shouldHave(text("09 May 1993"));
        $(".modal-body").shouldHave(text("Ebglish"));
        $(".modal-body").shouldHave(text("Sports"));
        $(".modal-body").shouldHave(text("Image.png"));
        $(".modal-body").shouldHave(text("Govnyaevo street , 14/5 house , 23 apts."));
        $(".modal-body").shouldHave(text("Rajasthan Jaipur"));
    }
}
