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
import com.kms.katalon.core.util.KeywordUtil

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

WebUI.setText(findTestObject('Product/btn_qtyproduct'), '999')

WebUI.click(findTestObject('Product/btn_add to cart'))

WebUI.waitForElementNotVisible(findTestObject('Cart/popup_cartbig'), 0)

WebUI.verifyElementNotVisible(findTestObject('Cart/popup_cartbig'))

WebUI.click(findTestObject('Cart/btn_cart'))

if (WebUI.verifyTextNotPresent('999', false, FailureHandling.OPTIONAL)) {
    KeywordUtil.markPassed('Test Success: Text 999 is not present.')

} else if (WebUI.verifyTextPresent('10', false, FailureHandling.OPTIONAL)) {
    KeywordUtil.markPassed('Test Success: 999 change to 10.')
} 
else {
	KeywordUtil.markFailed("TEST FAILED")
}

WebUI.closeBrowser()

