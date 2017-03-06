package pageobjects.Blog;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BaseObjectPage;


import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/3/17.
 */
public class BlogPage extends BaseObjectPage {

    public BlogPage() {
        super(getDriver());
    }



    public String getValidationMessages() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//li/label")).getText();
    }


    public void clickOnSocialNetworkButton() throws InterruptedException {

        String data[] = {"facebook", "twitter", "plusone", "linkedin", "pinterest"};
        String links[] = {"facebook.com", "twitter.com", "plus.google.com", "linkedin.com", "pinterest.com"};



        for (int j = 0; j < links.length; j++) {
            Thread.sleep(6000);
            WebElement socialNetwork = getDriver().findElement(By.xpath("//div[@class='social-likes__widget social-likes__widget_" + data[j] + "']"));
            socialNetwork.click();
            Thread.sleep(3000);
            switchingBetweenTabs(1);
            Thread.sleep(3000);
            String linkOpenedPage = getDriver().getCurrentUrl();
            System.out.println(links[j]);
            org.testng.Assert.assertTrue(linkOpenedPage.contains(links[j]));
            getDriver().close();
            switchingBetweenTabs(0);

        }


    }

    public Boolean getPartOfLink(String socialNetworkText){

        return getDriver().getPageSource().contains(socialNetworkText);
    }

    public void openPostByClickOnTitle() {
        WebElement postTitle= getDriver().findElement(By.xpath("//h2[@class='post-title']"));
        postTitle.click();
    }

    public String getPostTitleOnMainBlog(){
        return getDriver().findElement(By.xpath("//h2[@class='post-title']")).getText();
    }

    public String getPostTitleOnBlogPage(){
        return getDriver().findElement(By.xpath("//h1[@class='post-title']")).getText();
    }

    public void openPostByClickOnReadThisPost() throws InterruptedException {
        Thread.sleep(2000);
        WebElement readThisPostBtn = getDriver().findElement(By.xpath("//a[text()='Read This Post']"));
        readThisPostBtn.click();
    }
    public void clickOnClickHereLink() throws InterruptedException {
        Thread.sleep(4000);
        WebElement clickHereLnk = getDriver().findElement(By.xpath("//div[@class='post-meta']/p[@class='post-comments-info']/a"));
        clickHereLnk.click();
        Thread.sleep(5000);
    }
    public String getTitleOfDisqus() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//a[@title='Powered by Disqus']")).getText();
    }

    public void clickingOnTag(String tagName) throws InterruptedException {
        WebElement tag = getDriver().findElement(By.xpath("//a[@rel='tag'][text()='"+tagName+"']"));
        tag.click();
        Thread.sleep(3000);
    }

    public void clickingOnAuthor(String authorName) throws InterruptedException {
        WebElement author = getDriver().findElement(By.xpath("//span[@class='post-author']/a[text()=' "+authorName+"']"));
        author.click();
        Thread.sleep(3000);

    }
    public void clickOnRecentPostLink() throws InterruptedException {
        WebElement recentPost = getDriver().findElement(By.xpath("//div[@id='recent-posts-3'][@class='widget widget_recent_entries']//a"));
        recentPost.click();
        Thread.sleep(3000);
    }
    public String getTitleOfRecentOfPost() throws InterruptedException {
        Thread.sleep(7000);
        WebElement post = getDriver().findElement(By.xpath("//div[@id='recent-posts-3'][@class='widget widget_recent_entries']//a"));
        return post.getText();
    }

    public void findMeOnClicking() throws InterruptedException {
        Thread.sleep(2000);
        WebElement findMeOn = getDriver().findElement(By.xpath("//p[text()='Find me on ']/span/a[@class='icon-twitter']"));
        findMeOn.click();

    }

    public void socialNetworksClickOnIcon() throws InterruptedException {

        String data[] = {"facebook", "twitter", "plusone", "linkedin", "pinterest"};
        String links[] = {"facebook.com", "twitter.com", "plus.google.com", "linkedin.com", "pinterest.com"};



            for (int j = 0; j < links.length; j++) {
                Thread.sleep(4000);
                WebElement socialNetwork = getDriver().findElement(By.xpath("//div[@data-service='" + data[j] + "']"));
                socialNetwork.click();
                Thread.sleep(3000);
                switchingBetweenTabs(1);
                Thread.sleep(3000);
                String linkOpenedPage = getDriver().getCurrentUrl();
                System.out.println(links[j]);
                org.testng.Assert.assertTrue(linkOpenedPage.contains(links[j]));
                getDriver().close();
                switchingBetweenTabs(0);

            }


    }



}
