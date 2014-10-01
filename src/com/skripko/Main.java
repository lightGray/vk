package com.skripko;

import com.codeborne.selenide.ElementsCollection;
import com.skripko.util.Util;

import javax.swing.*;
import java.util.Set;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
/*вести учет только постов, написанных админами. не репосты и не посты из доставки*/

public class Main {

    public static final String LOGIN = "";
    public static final String PASS = "";

    public static final String ADMIN_TAB ="?act=users&tab=admins";
    public static final int POSTS_MONITORING_COUNT = 50;
    public static final int EXCEL_SCANNED_DAYS = 7;
    public static final String[] PUBLIC_URLS = {""};


    public static void main(String[] args) {
        String urlForException = null;
        try {
            Main main = new Main();
            for (String publicUrl : PUBLIC_URLS) {
                urlForException = publicUrl;
                main.execute(publicUrl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Exception with " + urlForException + ":\\n" + e.getMessage());
        }
    }

    private void execute(String publicUrl) {
        Util.configureBrowser();
        Set<User> admins = getAdmins(publicUrl + ADMIN_TAB, LOGIN, PASS);
        //Set<Post> excelPosts = getExcelPosts(EXCEL_SCANNED_DAYS);
        Set<Post> newPosts = getPostedPosts(publicUrl, POSTS_MONITORING_COUNT); //todo reminder - posponed part was removed
        /*if ($("#wall_postponed").isDisplayed()) {
            newPosts.addAll(processPostponed());
        }*/
    }

    private void logInAndAdminTab(String url, String login, String pass) {
        open(url);
        $("#email").setValue(login);
        $("#pass").setValue(pass);
        $("#login").submit();
    }


    private Set<User> getAdmins(String url, String login, String pass) {
        /*int dryShots = 0;
        while (!$("gedit_users_more_admins").isDisplayed()) { //todo test block
            if (dryShots > 10) {
                terminateProcess("2114090914 id=..");
            }
            ((JavascriptExecutor) getWebDriver()).executeScript("GroupsEdit.uShowMore()");
        }*/
        logInAndAdminTab(url + ADMIN_TAB, LOGIN, PASS);
        ElementsCollection adminEls = $("#gedit_users_rows_admins").findAll(".gedit_user_lnk");
        Set<User> admins = adminEls.stream().map(User::new).collect(Collectors.toSet());
        return admins;
    }

    private Set<Post> getExcelPosts(int excelScannedDays) {
        return null;
    }

    private Set<Post> getPostedPosts(String url, int count) {
        /*int dryShots = 0; //el.scrollTo
        while (!$("gedit_users_more_admins").isDisplayed()) { //todo test block
            if (dryShots > 10) {
                terminateProcess("2114090914 id=..");
            }
            ((JavascriptExecutor) getWebDriver()).executeScript("GroupsEdit.uShowMore()");
        }*/
        open(url);
        ElementsCollection postEls = $("#page_wall_posts").findAll(".gedit_user_lnk");
        Set<Post> posts = postEls.stream().map(Post::new).collect(Collectors.toSet());
        return posts;
    }

    /*private Set<Post> processPostponed() {
        $("#wall_postponed_link").click();
        SelenideElement parent = $("#wall_postponed_posts");
        ElementsCollection allSuggestions = $$("#page_suggestions > div")*//*.shouldHaveSize(10)*//*;
        System.out.println(">> " + allSuggestions.size());
        $("#page_suggest_more").shouldBe(exist, visible).click();
        return null;
    }*/
}
