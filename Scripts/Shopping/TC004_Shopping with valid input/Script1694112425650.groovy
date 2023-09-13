import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Reusable Testcase/Login success'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Homepage/btn_special offer'))

def nameproductoffer = WebUI.getText(findTestObject('Homepage/text_nameproductoffer'))

def lowernameproductoffer = nameproductoffer.toLowerCase()

GlobalVariable.Global_nameproductoffer = lowernameproductoffer

WebUI.click(findTestObject('Homepage/btn_see offer'))

WebUI.waitForElementVisible(findTestObject('Product/text_nameproduct'), 0)

WebUI.verifyElementVisible(findTestObject('Product/text_nameproduct'))

WebUI.verifyElementVisible(findTestObject('Product/text_priceproduct'))

def priceproductoffer = WebUI.getText(findTestObject('Product/text_priceproduct'))

GlobalVariable.Global_priceproductoffer = priceproductoffer

WebUI.verifyElementVisible(findTestObject('Product/radio_colorblack'))

WebUI.click(findTestObject('Product/radio_colorblack'))

WebUI.click(findTestObject('Product/btn_qtyproduct'))

WebUI.sendKeys(findTestObject('Product/btn_qtyproduct'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Product/btn_qtyproduct'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Product/btn_qtyproduct'), '1')

WebUI.click(findTestObject('Product/btn_add to cart'))

WebUI.waitForElementNotVisible(findTestObject('Cart/popup_cartbig'), 0)

WebUI.verifyElementNotVisible(findTestObject('Cart/popup_cartbig'))

WebUI.verifyElementVisible(findTestObject('Product/radio_colorgrey'))

WebUI.click(findTestObject('Product/radio_colorgrey'))

WebUI.click(findTestObject('Product/btn_qtyproduct'))

WebUI.sendKeys(findTestObject('Product/btn_qtyproduct'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Product/btn_qtyproduct'), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Product/btn_qtyproduct'), '1')

WebUI.click(findTestObject('Product/btn_add to cart'))

WebUI.waitForElementNotVisible(findTestObject('Cart/popup_cartbig'), 0)

WebUI.verifyElementNotVisible(findTestObject('Cart/popup_cartbig'))

WebUI.click(findTestObject('Cart/btn_cart'))

WebUI.verifyElementText(findTestObject('Cart/text_shopping cart'), 'SHOPPING CART (2)')

WebUI.waitForElementVisible(findTestObject('Cart/text_cartnameproduct1'), 0)

def cartprod1 = WebUI.getText(findTestObject('Cart/text_cartnameproduct1'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(cartprod1.toLowerCase(), GlobalVariable.Global_nameproductoffer, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Cart/text_cartcolor1'))

WebUI.verifyElementText(findTestObject('Cart/text_cartprice1'), GlobalVariable.Global_priceproductoffer)

WebUI.waitForElementVisible(findTestObject('Cart/text_cartnameproduct2'), 0)

def cartprod2 = WebUI.getText(findTestObject('Cart/text_cartnameproduct2'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(cartprod2.toLowerCase(), GlobalVariable.Global_nameproductoffer, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Cart/text_cartcolor2'))

WebUI.verifyElementText(findTestObject('Cart/text_cartprice2'), GlobalVariable.Global_priceproductoffer)

WebUI.verifyElementText(findTestObject('Cart/text_totalcart'), '$899.98')

WebUI.click(findTestObject('Cart/btn_checkout'))

WebUI.click(findTestObject('Checkout/btn_next'))

WebUI.waitForElementVisible(findTestObject('Checkout/radio_paymentsafepay'), 0)

WebUI.click(findTestObject('Checkout/radio_paymentsafepay'))

WebUI.setText(findTestObject('Checkout/textbox_safepayusername'), GlobalVariable.Global_usernamevalid)

WebUI.setText(findTestObject('Checkout/textbox_safepaypassword'), GlobalVariable.Global_passwordvalid)

WebUI.click(findTestObject('Checkout/btn_pay now'))

WebUI.waitForElementVisible(findTestObject('Checkout/text_thankyou for buying'), 0)

def checkoutordernumber = WebUI.getText(findTestObject('Checkout/text_ordernumber'))

WebUI.click(findTestObject('Homepage/btn_profile'))

WebUI.click(findTestObject('Homepage/btn_my order profile'))

WebUI.waitForElementVisible(findTestObject('My Orders/text_my orders'), 0)

WebUI.verifyElementText(findTestObject('My Orders/text_my orders'), 'MY ORDERS')

WebUI.verifyTextPresent(checkoutordernumber, false)

WebUI.closeBrowser()

