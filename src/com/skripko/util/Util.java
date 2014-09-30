package com.skripko.util;

public class Util {
    public static final int AJAX_WAIT = 3;


    public static void configureBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\resources\\chromedriver.exe");
        System.setProperty("selenide.browser", "chrome"); //-Dbrowser=chrome
        System.setProperty("selenide.timeout", "10000");
        System.setProperty("selenide.start-maximized", "false");
        System.setProperty("selenide.screenshots", "false");
        System.setProperty("selenide.holdBrowserOpen", "false");
    }

    /*public static void terminateProcess(Long exceptionId) {
        JOptionPane.showMessageDialog(new JFrame(), exceptionId);
        throw new RuntimeException();
    }*/

    /*public static void terminateProcess(/*Long exceptionId, Exception e) {
        JOptionPane.showMessageDialog(new JFrame(), exceptionId + ">> " + e.getMessage());
        throw new RuntimeException(e);
    }*/

    /*
        getWebDriver();
        $(By.name("email")).sendKeys("johny");
        $(By.name("email")).shouldHave(Condition.text("Selenide.org"));
        $$("#ires li.g").shouldHave(size(10));
        $("#ires").find(By.linkText("selenide.org")).shouldBe(visible);
        $("#username").shouldHave(cssClass("green-text"));
        setValue(By.name("user.name"), "johny");
        selectRadio("user.gender", "male");
        selectOption(By.name("user.preferredLayout"), "plain");
        selectOptionByText(By.name("user.securityQuestion"), "What is my first car?");
        followLink(By.id("submit"));
        takeScreenShot("complex-form.png");
        waitFor("#username");
        waitUntil(By.id("username"), hasText("Hello, Johny!"));
        waitUntil("#username", hasText("Hello, Johny!"));
        waitUntil("#username", hasAttribute("name", "user.name"));
        waitUntil("#username", hasClass("green-button"));
        waitUntil("#username", hasValue("Carlson"));
        waitUntil("#username", appears);
        waitUntil("#username", disappears);
        $("#customerContainer").shouldNot(exist);
        $("TEXTAREA").shouldHave(value("John"));
        $(byText("Customer profile"));
        $("#customerContainer").should(matchText("profile"));
        $("li", 5); //element by index
        selectRadio(By.name("sex"), "woman");
        refresh();         url();         title();         source();
        $("#username").waitUntil(hasText("Hello, Johny!"), 8000);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();" ,webElement);
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + x + "," + y + ");");
        String code = "window.scroll(" + (webElement.getLocation().x + x) + "," + (webElement.getLocation().y + y) + ");";
                ((JavascriptExecutor)driver).executeScript(code, webElement, x, y);
        WebDriverRunner.setDriver(new org.openqa.selenium.phantomjs.PhantomJSDriver(capabilities));
     */
}