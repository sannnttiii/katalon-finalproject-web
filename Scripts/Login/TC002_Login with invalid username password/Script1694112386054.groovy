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

def randomNumber = org.apache.commons.lang.RandomStringUtils.randomNumeric(6)

def usernameinvalid = 'errorusernameokebzahaha+123@email.com'

def passwordinvalid = 'BoonganPassword+123'

def modifiedusername = usernameinvalid.replace('123', randomNumber.toString())

def modifiedpassword = passwordinvalid.replace('123', randomNumber.toString())

WebUI.callTestCase(findTestCase('Reusable Testcase/Open Browser'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Homepage/btn_profile'))

WebUI.waitForElementVisible(findTestObject('Login/popup_login'), 0)

WebUI.verifyElementVisible(findTestObject('Login/popup_login'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Login/btn_login with facebook'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Login/textbox_username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_username'), modifiedusername)

WebUI.verifyElementVisible(findTestObject('Login/textbox_password'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Login/textbox_password'), modifiedpassword)

WebUI.verifyElementVisible(findTestObject('Login/text_remember me'))

WebUI.verifyElementVisible(findTestObject('Login/btn_forgot password'))

WebUI.verifyElementVisible(findTestObject('Login/btn_signup'))

WebUI.verifyElementVisible(findTestObject('Login/btn_login'))

WebUI.click(findTestObject('Login/btn_login'))

WebUI.verifyElementPresent(findTestObject('Homepage/text_incorrect username password'), 0)

WebUI.closeBrowser()

