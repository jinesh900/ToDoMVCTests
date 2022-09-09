package definitions;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ManageToDoDefinitions extends TestBase {
	
	//WebDriver driver;
	By HomePageHeader 	=    By.cssSelector("header[class='header']");
	By itemTextBox   	=    By.cssSelector("input[class='new-todo']");
	By toDoCount      	=    By.cssSelector("span[class='todo-count']");
	By completedBtn  	=    By.cssSelector("a[href='#/completed']");
	By activeBtn      	=    By.cssSelector("a[href='#/active']");
	By clearCompleteBtn = 	 By.cssSelector("button[class='clear-completed']");
	By allBtn           =    By.cssSelector("a[href='#/all']");
	By toDoList         =    By.cssSelector("ul[class='todo-list']");
	
		
	//Open browser instance before each test
	@Before
    public void setUp() {
    	
			try {
				super.setupmain();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
			super.context.setAttribute("WebDriver", driver);
			} catch (Exception e) {
				
			}
	  }
		
    @Given("User is on Home page")
    public void userOnHomePage() {
    	    driver.get("https://todomvc.com/examples/vue/");
    }
    
     @Then("ToDos Header should be visible")
    public void verifyHomePageHeader() {
    	assertEquals(driver.findElement(HomePageHeader).getText(), "todos");
    }
    
    @When("Add Item to ToDo List as {string}")
    public void addToDoItem(String item) {
    	WebElement toDoTextBox = driver.findElement(itemTextBox);
    	toDoTextBox.sendKeys(item);  
    	toDoTextBox.sendKeys(Keys.RETURN);
    }
    
    @Then("Items Left to Complete as {string}")
    public void verifyItemsLeft(String numberOfItems){
    	assertEquals(driver.findElement(toDoCount).getText(), numberOfItems+" items left");    	
    	
    }
    
    @When("Mark Item Completed as {string}")
    public void markItemCompleted(String item) {
    	driver.findElement(By.xpath("//label[text()='"+item+"']//preceding-sibling::input[1]")).click();
    }
    
    @When("Navigate to Completed")
    public void navigateToCompleted(){
    	driver.findElement(completedBtn).click();
    }
    
    @When("Navigate to Active")
    public void navigateToActive(){
    	driver.findElement(activeBtn).click();
    }
    
    @When("Navigate to All")
    public void navigateToAll() {
    	driver.findElement(allBtn).click();
    }
    
    @Then("Item Listed In completed as {string}")
    public void verifyItemInCompleted(String item) {
    	assertTrue(driver.findElements(By.xpath("//label[text()='"+item+"']")).size()!=0);
    }
    
    @Then("Verify Item In Active as {string}")
    public void verifyItemInActive(String item) {
    	assertTrue(driver.findElements(By.xpath("//label[text()='"+item+"']")).size()!=0);
    	
    }
    
    @When("Clear Completed Items")
    public void clearCompletedItems() {
    	driver.findElement(clearCompleteBtn).click();    		
    	}
    
    @Then("Verify Number of Items as {int}")
    public void verifyNumberOfItems(int numberItems) {
    	assertTrue((driver.findElement(toDoList)).findElements(By.tagName("li")).size()==numberItems);
    }
    
    @When("Delete Item from ToDo List as {string}")
    public void deleteItem(String item) {
    	driver.findElement(By.xpath("//label[text()='"+item+"']")).click();
    	driver.findElement(By.xpath("//label[text()='"+item+"']//following-sibling::button[1]")).click();
    	
    }
    
    //Close browser instance after each test
       
	

}
