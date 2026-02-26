By usernameTextbox = By.id("username");
By passwordTextbox = By.id("password");
By signInButton = By.id("login");
By registeredPatientTextElement = By.xpath("//span[contains(text(),'Registered Patient')]");

By billingNavigationMenuElement = By.xpath("//span[contains(text(),'Billing')]");
By new1TextElement = By.xpath("//div[contains(text(),'New 1')]");
By addNewPatientTextElement = By.xpath("//span[contains(text(),'Add New Patient')]");

By firstNameTextFieldElement = By.id("FirstName");
By middleNameTextFieldElement = By.id("MiddleName");
By lastNameTextfieldElement = By.id("LastName");
By ageTextfieldElement = By.id("Age");
By contactNumberTextfieldElement = By.id("Contact");
By countryDropdownByElement = By.id("Country");

By registerAndBillingButtonElement = By.xpath("//button[contains(text(),'Register')]");
By errorMessageOfRegisterBillingByElement = By.xpath("//p[contains(text(),'Some of the inputs')]");

By dispensaryToggle = By.xpath("//a[contains(text(),'Dispensary')]");
By prescriptionSubMenu = By.xpath("//a[contains(text(),'Prescription')]");
By settingLeftNavigationMenu = By.xpath("//a[contains(text(),'Settings')]");



public boolean loginToHealthAppByGivenValidCredetial(Map<String,String> expectedData) throws Exception {
driver.findElement(usernameTextbox).sendKeys(expectedData.get("username"));
driver.findElement(passwordTextbox).sendKeys(expectedData.get("password"));
driver.findElement(signInButton).click();
Thread.sleep(2000);
return true;
}


public String verifyTitleOfThePage() throws Exception {
return driver.getTitle();
}


public String verifyURLOfThePage() throws Exception {
return driver.getCurrentUrl();
}

public Boolean verifySelectCounterPopupIsPresentAndNavigateToNextpage() throws Exception {
driver.findElement(billingNavigationMenuElement).click();
Thread.sleep(2000);
driver.findElement(new1TextElement).click();
Thread.sleep(2000);
return driver.findElement(registeredPatientTextElement).isDisplayed();
}

public String performKeyBoardOperationToOpenAddNewPatientPopup() throws Exception {
Actions act = new Actions(driver);
act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();
Thread.sleep(2000);
return driver.findElement(addNewPatientTextElement).getText();
}

public Boolean findTheTextFieldInAddNewPatientPopup(Map<String,String> expectedData) throws Exception {

driver.findElement(firstNameTextFieldElement).sendKeys(expectedData.get("FirstName"));
driver.findElement(middleNameTextFieldElement).sendKeys(expectedData.get("MiddleName"));
driver.findElement(lastNameTextfieldElement).sendKeys(expectedData.get("LastName"));
driver.findElement(ageTextfieldElement).sendKeys(expectedData.get("Age"));
driver.findElement(contactNumberTextfieldElement).sendKeys(expectedData.get("ContactNumber"));

return true;
}

public String verifyFirstNameIsPresent(Map<String,String> expectedData) throws Exception {
return driver.findElement(firstNameTextFieldElement).getAttribute("value");
}

public String verifyMiddleNameIsPresent(Map<String,String> expectedData) throws Exception {
return driver.findElement(middleNameTextFieldElement).getAttribute("value");
}

public String verifyLastNameIsPresent(Map<String,String> expectedData) throws Exception {
return driver.findElement(lastNameTextfieldElement).getAttribute("value");
}

public String verifyAgeValueIsPresent(Map<String,String> expectedData) throws Exception {
return driver.findElement(ageTextfieldElement).getAttribute("value");
}

public String verifyContactNumberIsPresent(Map<String,String> expectedData) throws Exception {
return driver.findElement(contactNumberTextfieldElement).getAttribute("value");
}

public String verifyIndiaIsSelectedFromCountryDropdown(Map<String,String> expectedData) throws Exception {
Select s = new Select(driver.findElement(countryDropdownByElement));
s.selectByVisibleText("India");
return s.getFirstSelectedOption().getText();
}

public String validateErrorMessageWhenClickOnRegisterBillingButton() throws Exception {

Actions act = new Actions(driver);
act.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).perform();
Thread.sleep(2000);

driver.findElement(registerAndBillingButtonElement).click();
Thread.sleep(2000);

String error = driver.findElement(errorMessageOfRegisterBillingByElement).getText();
return error;
}

public Boolean verifyDispensaryArrowIsExpanding() throws Exception {
driver.findElement(dispensaryToggle).click();
Thread.sleep(2000);
return driver.findElement(prescriptionSubMenu).isDisplayed();
}

public Boolean verifyDispensaryArrowIsMinimizing() throws Exception {
driver.findElement(dispensaryToggle).click();
Thread.sleep(2000);
return true;
}

public Boolean verifyControlIsScrollingFromDispensaryToSettingModule() throws Exception {
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(settingLeftNavigationMenu));
return true;
}

