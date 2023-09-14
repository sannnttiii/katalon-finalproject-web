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

WebUI.click(findTestObject('Homepage/btn_profile'))

WebUI.click(findTestObject('Homepage/btn_myaccount'))

WebUI.waitForElementVisible(findTestObject('Profile/text_myaccount'), 0)

WebUI.verifyElementVisible(findTestObject('Profile/text_myaccount'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Profile/btn_editprofile'))

WebUI.waitForElementVisible(findTestObject('Profile/text_accountdetails'), 0)

WebUI.verifyElementVisible(findTestObject('Profile/text_accountdetails'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Profile/textbox_emailprofile'), newemail)

WebUI.setText(findTestObject('Profile/textbox_firstnameprofile'), newfirstname)

WebUI.setText(findTestObject('Profile/textbox_lastnameprofile'), newlastname)

WebUI.setText(findTestObject('Profile/textbox_phoneprofile'), newphone)

WebUI.selectOptionByLabel(findTestObject('Profile/dropdown_country'), newcountry, false)

WebUI.setText(findTestObject('Profile/textbox_city'), newcity)

WebUI.setText(findTestObject('Profile/textbox_address'), newaddress)

WebUI.setText(findTestObject('Profile/textbox_postalcode'), newpostalcode)

WebUI.setText(findTestObject('Profile/textbox_stateprovinceregion'), newstateprovinceregion)

WebUI.click(findTestObject('Profile/btn_save'))

WebUI.waitForElementVisible(findTestObject('Profile/text_myaccount'), 0)

WebUI.verifyElementVisible(findTestObject('Profile/text_myaccount'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Profile/btn_editprofile'))

WebUI.waitForElementVisible(findTestObject('Profile/text_accountdetails'), 0)

WebUI.verifyElementVisible(findTestObject('Profile/text_accountdetails'), FailureHandling.STOP_ON_FAILURE)

def modifiedemail = WebUI.getAttribute(findTestObject('Profile/textbox_emailprofile'), 'value')

WebUI.verifyEqual(modifiedemail, newemail)

def modifiedfirst = WebUI.getAttribute(findTestObject('Profile/textbox_firstnameprofile'), 'value')

WebUI.verifyEqual(modifiedfirst, newfirstname)

def modifiedlast = WebUI.getAttribute(findTestObject('Profile/textbox_lastnameprofile'), 'value')

WebUI.verifyEqual(modifiedlast, newlastname)

def modifiedphone = WebUI.getAttribute(findTestObject('Profile/textbox_phoneprofile'), 'value')

WebUI.verifyEqual(modifiedphone, newphone)

def modifiedcountry = ((WebUI.executeJavaScript('\n    return document.querySelector(\'select[name="countryListboxAccountDetails"]\').selectedOptions[0].label;\n', 
        null)) as String)

WebUI.verifyEqual(modifiedcountry, newcountry)

def modifiedcity = WebUI.getAttribute(findTestObject('Profile/textbox_city'), 'value')

WebUI.verifyEqual(modifiedcity, newcity)

def modifiedaddress = WebUI.getAttribute(findTestObject('Profile/textbox_address'), 'value')

WebUI.verifyEqual(modifiedaddress, newaddress)

def modifiedpostalcode = WebUI.getAttribute(findTestObject('Profile/textbox_postalcode'), 'value')

WebUI.verifyEqual(modifiedpostalcode, newpostalcode)

def modifiedstateprovinceregion = WebUI.getAttribute(findTestObject('Profile/textbox_stateprovinceregion'), 'value')

WebUI.verifyEqual(modifiedstateprovinceregion, newstateprovinceregion)

WebUI.closeBrowser()

