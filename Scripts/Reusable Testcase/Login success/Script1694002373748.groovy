import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Reusable Testcase/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Homepage/btn_profile'))

WebUI.waitForElementVisible(findTestObject('Login/popup_login'), 0)

WebUI.verifyElementVisible(findTestObject('Login/popup_login'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Login/btn_login with facebook'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Login/textbox_username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_username'), GlobalVariable.Global_usernamevalid)

WebUI.verifyElementVisible(findTestObject('Login/textbox_password'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_password'), GlobalVariable.Global_passwordvalid)

WebUI.verifyElementVisible(findTestObject('Login/text_remember me'))

WebUI.verifyElementVisible(findTestObject('Login/btn_forgot password'))

WebUI.verifyElementVisible(findTestObject('Login/btn_signup'))

WebUI.verifyElementVisible(findTestObject('Login/btn_login'))

WebUI.click(findTestObject('Login/btn_login'))

WebUI.waitForElementVisible(findTestObject('Homepage/text_nameprofile'), 0)

WebUI.verifyElementVisible(findTestObject('Homepage/text_nameprofile'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent(GlobalVariable.Global_usernamevalid, false)

WebUI.verifyElementNotVisible(findTestObject('Login/popup_login'))

