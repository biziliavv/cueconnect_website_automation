package pageobjects.Blog;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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



    public String getValidationMessages()  {
        waitFor(3);
        return getDriver().findElement(By.xpath("//label[@class='visible']")).getText();
    }


    public void clickOnSocialNetworkButton()  {

        String data[] = {"facebook", "twitter", "plusone", "linkedin", "pinterest"};
        String links[] = {"facebook.com", "twitter.com", "plus.google.com", "linkedin.com", "pinterest.com"};



        for (int j = 0; j < links.length; j++) {
            waitFor(6);
            String str = data[j];
            String cap = str.substring(0, 1).toUpperCase() + str.substring(1);
            WebElement socialNetwork = getDriver().findElement(By.xpath("//div[2]/div/div/div[@class='social-likes__widget social-likes__widget_"+data[j]+"']"));
            socialNetwork.click();
            waitFor(3);
            switchingBetweenTabs(1);
            waitFor(3);
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

    public void openPostByClickOnTitle()  {
        WebElement postTitle= getDriver().findElement(By.xpath("//h2[@class='post-title']/a"));
        postTitle.click();
        waitFor(4);
    }

    public String getPostTitleOnMainBlog(){
        return getDriver().findElement(By.xpath("//h2[@class='post-title']")).getText();
    }

    public String getPostTitleOnBlogPage()  {
        waitFor(2);
        return getDriver().findElement(By.xpath("//*[@id=\"blog-content\"]/h1")).getText();
    }

    public void openPostByClickOnReadThisPost()  {
        waitFor(2);
        WebElement readThisPostBtn = getDriver().findElement(By.xpath("//a[text()='Read This Post']"));
        readThisPostBtn.click();
    }
    public void clickOnClickHereLink()  {
        waitFor(4);
        WebElement clickHereLnk = getDriver().findElement(By.xpath("//div[@class='post-meta']/p[@class='post-comments-info']/a"));
        clickHereLnk.click();
        waitFor(5);
    }
    public String getTitleOfDisqus()  {
        waitFor(3);
        WebElement title = getDriver().findElement(By.xpath("//a[@title='Powered by Disqus']"));
        fluentWaitforElement(title, 10, 5);
        return title.getText();
    }

    public void clickingOnTag(String tagName)  {
        WebElement tag = getDriver().findElement(By.xpath("//a[@rel='tag']"));
        tag.click();
        waitFor(3);

    }
    public String getTagName(){
        waitFor(2);
        WebElement tag = getDriver().findElement(By.xpath("//a[@rel='tag']"));
        return tag.getText();
    }

    public void clickingOnAuthor(String authorName)  {
        waitFor(3);
        WebElement author = getDriver().findElement(By.xpath("//span[@class='post-author']/a"));
        fluentWaitforElement(author, 5, 5);
        author.click();
        waitFor(3);


    }
    public String getAuthorName(){
        waitFor(3);
        WebElement author = getDriver().findElement(By.xpath("//span[@class='post-author']/a"));
        return author.getText();
    }
    public void clickOnRecentPostLink()  {
        WebElement recentPost = getDriver().findElement(By.xpath("//div[@id='recent-posts-3'][@class='widget widget_recent_entries']//a"));
        recentPost.click();
        waitFor(3);
    }
    public String getTitleOfRecentOfPost()  {
        waitFor(7);
        WebElement post = getDriver().findElement(By.xpath("//div[@id='recent-posts-3'][@class='widget widget_recent_entries']//a"));
        return post.getText();
    }

    public void findMeOnClicking()  {
        waitFor(4);
        WebElement findMeOn = getDriver().findElement(By.xpath("//a[@class='icon-twitter']"));
        findMeOn.click();

    }

    public void socialNetworksClickOnIcon()  {

        String data[] = {"facebook", "twitter", "plusone", "linkedin", "pinterest"};
        String links[] = {"facebook.com", "twitter.com", "plus.google.com", "linkedin.com", "pinterest.com"};



            for (int j = 0; j < links.length; j++) {
                waitFor(4);
                WebElement socialNetwork = getDriver().findElement(By.xpath("//div[@data-service='" + data[j] + "']"));
                socialNetwork.click();
                waitFor(3);
                switchingBetweenTabs(1);
                waitFor(3);
                String linkOpenedPage = getDriver().getCurrentUrl();
                System.out.println(links[j]);
                org.testng.Assert.assertTrue(linkOpenedPage.contains(links[j]));
                getDriver().close();
                switchingBetweenTabs(0);

            }


    }
    public void closeSendUpdates() {

        waitFor(5);
        try {
            WebElement closeBtn = getDriver().findElement(By.xpath("//a[@class='js-close-subscribe-form']"));
            fluentWaitforElement(closeBtn, 20, 4);
            closeBtn.click();
        } catch (NoSuchElementException e) {

            System.out.println("No such element");
        }

    }


    }




