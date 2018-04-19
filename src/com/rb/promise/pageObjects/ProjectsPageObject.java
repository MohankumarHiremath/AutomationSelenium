package com.rb.promise.pageObjects;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.rb.promise.dataExtraction.ReadObject;
import com.rb.promise.handlers.FileHandler;
import com.rb.promise.handlers.LocatorHandler;
import com.rb.promise.handlers.EnumHandler.FilterBlockOptions;
import com.rb.promise.keywords.GenericAction;
import com.rb.promise.keywords.Promise;

public class ProjectsPageObject {

	public static LocatorHandler loc = new LocatorHandler();

	public void creatSubProject(WebDriver driver, Hashtable<String, String> createSubPro){
		try {			
			Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"), createSubPro.get("ProjectId"));			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects", "ClickOnProjectId").replace("$", createSubPro.get("ProjectId"))))).click();
			GenericAction.mouseOverClick(driver, ReadObject.getPageObject("ProjectPageObjects", "ProjectProfileLink"), ReadObject.getPageObject("ProjectPageObjects", "SubProjectsLink"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects", "NewSubProjectLink")))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","SubProjectIDTxtBox")))).sendKeys(createSubPro.get("SubprojectID"));	
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","SubProjectNameTxtBox")))).sendKeys(createSubPro.get("SubProjectName"));
			TimeUnit.SECONDS.sleep(4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","SubProjectNameTxtBox")))).clear();
			TimeUnit.SECONDS.sleep(4);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","SubProjectNameTxtBox")))).sendKeys(createSubPro.get("SubProjectName"));
			TimeUnit.SECONDS.sleep(4);
			Promise.datePickerFormat(driver,  ReadObject.getPageObject("ProjectPageObjects","StartDatePickerImg"), createSubPro.get("StartDate"));
			Promise.datePickerFormat(driver,  ReadObject.getPageObject("ProjectPageObjects","EndDatePickerImg"), createSubPro.get("EndDate"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","PMDate")))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","PMDate")))).sendKeys(createSubPro.get("PMDate"));			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","APMDate")))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","APMDate")))).sendKeys(createSubPro.get("APMDate"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","TeamSizeTxtBox")))).clear();
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","TeamSizeTxtBox")))).sendKeys(createSubPro.get("TeamSize"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","SubProjectTypeDropDwn"), createSubPro.get("SubProjectType"));
			TimeUnit.SECONDS.sleep(4);
			Promise.datePickerFormat(driver,  ReadObject.getPageObject("ProjectPageObjects","PLAAvailableFromDatePickImg"), createSubPro.get("PLAAvailableFromDate"));
			TimeUnit.SECONDS.sleep(4);			
			Promise.datePickerFormat(driver,  ReadObject.getPageObject("ProjectPageObjects","PLAAvailableToDatePickImg"), createSubPro.get("PLAAvailableToDate"));
			TimeUnit.SECONDS.sleep(4);
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","EffortOffshoreTxtBox"), createSubPro.get("EffortOffshore"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","EffortOnsiteTxtBox"), createSubPro.get("EffortOnsite"));
			if(!createSubPro.get("Customer").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","CustomerTxtBox"), createSubPro.get("Customer"));
			}
			if(!createSubPro.get("CustomerDept").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","CustomerDeptTxtBox"), createSubPro.get("CustomerDept"));
			}
			if(!createSubPro.get("CustomerProjRefCode").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","CustomerProjRefCodeTxtBox"), createSubPro.get("CustomerProjRefCode"));
			}			
			if(!createSubPro.get("CustomerCoOrdinator").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","CustomerCoOrdinatorTxtBox"), createSubPro.get("CustomerCoOrdinator"));
			}
			if(!createSubPro.get("ContractingParty").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ContractingPartyTxtBox"), createSubPro.get("ContractingParty"));
			}
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","BillingTypeDropDwn"), createSubPro.get("BillingType"));
			if(!createSubPro.get("InitiatingSection").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","InitiatingSectionTxtBox"), createSubPro.get("InitiatingSection"));
			}
			if(!createSubPro.get("InitiatingDepartment").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","InitiatingDepartmentTxtBox"), createSubPro.get("InitiatingDepartment"));
			}
			if(!createSubPro.get("InitiatingGroup").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","InitiatingGroupTxtBox"), createSubPro.get("InitiatingGroup"));
			}
			if(!createSubPro.get("ServiceType").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ServiceTypeTxtBox"), createSubPro.get("ServiceType"));
			}
			if(!createSubPro.get("ProjectClassification").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProjectClassificationTxtBox"), createSubPro.get("ProjectClassification"));
			}
			if(!createSubPro.get("Domain").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","DomainTxtBox"), createSubPro.get("Domain"));
			}
			if(!createSubPro.get("ProjectCategory").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProjectCategoryTxtBox"), createSubPro.get("ProjectCategory"));
			}
			if(!createSubPro.get("ProjectType").isEmpty()){
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProjectTypeTxtBox"), createSubPro.get("ProjectType"));
			}
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","SaveBtn"));		
			TimeUnit.SECONDS.sleep(5);
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","SubmitForApprovalBtn"));
			TimeUnit.SECONDS.sleep(10);	    	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in creatSubProject "+e.getMessage());
		}
	}

	public static enum createProject{
		ContinuationProject,
		NewProject
	}
	String ProProjectId = null;
	public void createProject(WebDriver driver, createProject project, Hashtable<String, String> createProject){
		try {
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProNewProjectLink"));
			if(project.toString().equals("NewProject")){

				WebDriverWait wait = new WebDriverWait(driver, 10);			
				GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProNewProjectTab"));


				wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","ProProjectNameTxtBox")))).sendKeys(createProject.get("ProjectName"));
				Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProAvailableListSearchRequestedBy"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("RequestedByFirstName"));

				System.out.println(createProject);
				System.out.println("aaa"+createProject.get("EngineeringUnit")+"ddd");
				System.out.println("aaa"+createProject.get("EngineeringUnit").trim()+"ddd");
				if(!createProject.get("EngineeringUnit").trim().isEmpty()){
					GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProEngineeringUnitTxtDropDwn"), createProject.get("EngineeringUnit"));
				}
				//			if(!createProject.get("Section").isEmpty()){
				//			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProSectionDropDwn"), createProject.get("Section"));
				//			}
				//			if(!createProject.get("Department").isEmpty()){
				//			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProDepartmentDropDwn"), createProject.get("Department"));
				//				}
				//				
				//			if(!createProject.get("Group").isEmpty()){
				//			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProGroupDropDwn"), createProject.get("Group"));
				//				}			
				Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProAvailableListSearchDiscussInitiatedBy"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("DiscussionInitiatedByFirstName"));
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProLocationDropDwn"), createProject.get("Location"));
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProOperatingModelDropDwn"), createProject.get("OperatingModel"));
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProProjectClassificationDropDwn"), createProject.get("ProjectClassification"));
				if(createProject.get("ProjectClassification").equals("Global Customer Project")){        
					Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProAvailableListSearchCustomer"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectCustomerCodeField"),createProject.get("Customer"));			
					GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProCustomerProjRefCodeTxtBox"), createProject.get("CustomerProjRefCode"));
					GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProCustomerCoordinatoTxtBox"), createProject.get("CustomerCoordinator"));
					GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProBillingType"), createProject.get("BillingType"));
				}
				if(createProject.get("ProjectClassification").equals("Competency Project")){        	   
					GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","AdditionalnformDropDwn"), createProject.get("AdditionalInformation"));
					if(createProject.get("AdditionalInformation").equals("CI Services for RBEI")||createProject.get("AdditionalInformation").equals("Internal Project")){
						GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProRequestinDeptDropDwn"), createProject.get("RequestingDepartment"));
					}       	    
				}

				if(createProject.get("ProjectClassification").equals("Software")){        	
					GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProRequestinDeptDropDwn"), createProject.get("RequestingDepartment"));
				}			
				//			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProCustomerDeptTxtBox"), createProject.get("CustomerDept"));
				//			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProContractinParty"), createProject.get("ContractingParty"));
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects","ProServiceType"), createProject.get("ServiceType"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProEconomicImpactImmediate"), createProject.get("EconomicImpactImmediate"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProEconomicImpactFuture"), createProject.get("EconomicImpactFuture"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProProjectStructure"), createProject.get("ProjectStructure"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProCultureDiversity"), createProject.get("CultureDiversity"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProRiskAndDependencies"), createProject.get("RiskAndDependencies"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProOwnership"), createProject.get("Ownership"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProInnovation"), createProject.get("Innovation"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects","ProTechnologyExpertise"), createProject.get("TechnologyExpertise"));
				GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProComputePCVCBtn"));
								
				Assert.assertEquals(createProject.get("ProjectCategory"), GenericAction.getAttributeValue(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectCategoryTxtBox"),"value"),createProject.get("ProjectCategory")+" is not equal");
		    	Assert.assertEquals(createProject.get("ValueContribution"), GenericAction.getAttributeValue(driver, ReadObject.getPageObject("ProjectPageObjects", "ProValueContribution"),"value"),createProject.get("ValueContributions")+" is not equal");
			    Assert.assertEquals(createProject.get("RecommendedPMLevel"), GenericAction.getAttributeValue(driver, ReadObject.getPageObject("ProjectPageObjects", "ProRecomentedPM"),"value"),createProject.get("RecommendedPMLevel")+" is not equal");
			    //Assert.assertEquals(createProject.get("RecommendedPMLevel"), GenericAction.getAttributeValue(driver, ReadObject.getPageObject("ProjectPageObjects", "ProRecomenProjectType"),"value"),createProject.get("RecommendedProjectType")+" is not equal");
				 
				Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProAvailableListSearchNameofPM"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("NameofPM"));
				Promise.datePickerFormat(driver, ReadObject.getPageObject("ProjectPageObjects", "ProStartDatePicker"),createProject.get("StartDate"));
				Promise.datePickerFormat(driver, ReadObject.getPageObject("ProjectPageObjects", "ProEndDatePicker"),createProject.get("EndDate"));
				GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProDescriptionTextArea"), createProject.get("Description"));			
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProServiceAgreementDropDwn"), createProject.get("Service Agreement"));
				GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProGroupLevelAgreementDropDwn"), createProject.get("GLAgreement"));
				Promise.datePickerFormat(driver, ReadObject.getPageObject("ProjectPageObjects", "ProGLAAvailableFromDatePicker"),createProject.get("GLAAvailableFrom"));
				Promise.datePickerFormat(driver, ReadObject.getPageObject("ProjectPageObjects", "ProGLAAvailableToDatePicker"),createProject.get("GLAAvailableTo"));
				GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProSaveBtn"));
				TimeUnit.SECONDS.sleep(15);	

				String proID = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
				System.out.println("creatingProject Status"+proID);
				
				
				ProProjectId=(String) proID.subSequence(19,28);
				 //Promise.getProjectID(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
				//GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProForwardToPMBtn"));
                System.out.println("dynamic id"+ProProjectId);
                System.out.println("before forwarding to PM");
                TimeUnit.SECONDS.sleep(15);
				driver.findElement(By.xpath("//span[starts-with(text(),'Forward to PM')]")).click();
                System.out.println("After forwarding to PM");


				driver.switchTo().alert().accept();
				
			try {
				driver.switchTo().alert().accept();
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("popup alert");
			}

				// continuation project code 
			}else if(project.toString().equals("ContinuationProject")){
				GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProContinuationProTab"));
			}				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in createproject"+e.getMessage());
		}
		}

	public void createModifyProject(WebDriver driver, Hashtable<String, String> createProject){
		try {
			// GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProGotoModule"));
		    /*GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProUnifiedInBox"));
		    GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProUnifiedSubject"));*/
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProAllProjLink"));
			Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"), ProProjectId);

			/*String passProjectID=FileHandler.readFromFile();
		    System.out.println("its priting  hhh"+passProjectID);
		    Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"),passProjectID);*/
		


			WebDriverWait wait = new WebDriverWait(driver, 10);			
			System.out.println("dynamic id"+ProProjectId);
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator("//div[starts-with(text(),'"+ProProjectId+"')]"))).click();
			
			/*GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProIndproj"));
		    GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProSubmitBtn"));
		    GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProRefreshBtn"));*/

			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModifyBtn"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModProjectTypeDropDwn"), createProject.get("ProjectType"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModProductLineDropDwn"), createProject.get("ProductLine"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModTechnologyDropDwn"), createProject.get("Technology"));

			//GenericAction.clear(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModBackgroundInfoTextArea"));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator(ReadObject.getPageObject("ProjectPageObjects","ProModBackgroundInfoTextArea")))).clear();
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModBackgroundInfoTextArea"), createProject.get("BackgroundInfo"));			
			Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProModAvailableListSearchAPM"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("NameOfAPM"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModOverallRisk"), createProject.get("OverallRisk"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModDomain"), createProject.get("Domain"));

			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModTeamSize"), createProject.get("TeamSize"));			
			Thread.sleep(1000);
			Promise.datePickerFormat(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjEngStartDate"),createProject.get("ProjEngStartDate"));
			
			Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProModSearchPQA"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("NameFieldPQA"));
			Promise.SelectFromAvailableList(driver,ReadObject.getPageObject("ProjectPageObjects", "ProModAssociateSearchPQA"),FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectNameField"),createProject.get("NameFieldAssociatePQA"));

			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModPQAType"), createProject.get("PQAType"));
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModProjLifeCycle"), createProject.get("ProjLifeCycle"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModEffortOnsite"), createProject.get("ModEffortOnsite"));			
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModEffortOffShore"), createProject.get("ModEffortOffShore"));			
			GenericAction.selectDropDownByLabel(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModCriticalProjDropDwn"), createProject.get("CriticalProject"));


			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProModReasonForCritical"), createProject.get("CriticalReason"));	
			System.out.println("before save");
			
			GenericAction.click(driver,  ReadObject.getPageObject("ProjectPageObjects", "ProModSave"));
			Thread.sleep(15);
			String proID = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
			System.out.println("creatingProject Status"+proID);
			
			System.out.println("after save");
			GenericAction.click(driver,  ReadObject.getPageObject("ProjectPageObjects", "ProSubmitBtn"));
			Thread.sleep(10);

            System.out.println("after submit");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in createModifyProject"+e.getMessage());
		}
	}





	public void createApproveProject(WebDriver driver, Hashtable<String, String> createProject){
		try {
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProAllProjLink"));

			//Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"), ProProjectId);
			Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"),createProject.get("ProProjectId"));

			WebDriverWait wait = new WebDriverWait(driver, 15);			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator("//div[starts-with(text(),'"+ProProjectId+"')]"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator("//div[starts-with(text(),'EI-100347')]"))).click();

			String proID = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
			//System.out.println("creatingProject Status"+proID);
			//unblock me after debug
			driver.findElement(By.xpath("//tbody/tr/td/div[@id='EIPMS75928IPMSDEMO88150stepControl10']/table/tbody/tr/td/div/span[@accesskey='A']")).click();
			driver.findElement(By.xpath("//div/span[starts-with(text(),'Approve')]")).click();
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProApproveBtn"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProapprovalComment"), createProject.get("approvalComment"));			
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProCommentConfirmBtn"));
			Thread.sleep(10);

			String proID1 = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
			System.out.println("creatingProject Status"+proID1);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in Approveproject"+e.getMessage());
		}

	}

	public void createGrmApproveProject(WebDriver driver, Hashtable<String, String> createProject){
		try {
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProAllProjLink"));
			Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"), ProProjectId);

			WebDriverWait wait = new WebDriverWait(driver, 10);			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator("//div[starts-with(text(),'"+ProProjectId+"')]"))).click();
			String proID = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
			System.out.println("creatingProject Status"+proID);
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProApproveBtn"));
		    GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProapprovalComment"), createProject.get("approvalComment"));			
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProCommentCheckBox1"));
		    GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProCommentConfirmBtn"));
			Thread.sleep(10);

			String proID1 = GenericAction.getText(driver, ReadObject.getPageObject("ProjectPageObjects", "ProProjectIDNO"));
			System.out.println("creatingProject Status"+proID1);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in createGrmApproveProject"+e.getMessage());
		}
		
	}
	public void createDHApproveProject(WebDriver driver, Hashtable<String, String> createProject){
		try {
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects","ProRegistrationlink"));
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProAllProjLink"));
			Promise.searchFilterBlock(driver, FilterBlockOptions.Filter, ReadObject.getPageObject("ProjectPageObjects", "ProjectIdField"), ProProjectId);

			WebDriverWait wait = new WebDriverWait(driver, 5);			
			wait.until(ExpectedConditions.visibilityOfElementLocated(loc.autoLocator("//div[starts-with(text(),'"+ProProjectId+"')]"))).click();
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProApproveBtn"));
			GenericAction.sendKeys(driver, ReadObject.getPageObject("ProjectPageObjects", "ProapprovalComment"), createProject.get("approvalComment"));			
			GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProCommentCheckBox1"));
		    GenericAction.click(driver, ReadObject.getPageObject("ProjectPageObjects", "ProCommentConfirmBtn"));
			Thread.sleep(10);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception in createDHApproveProject"+e.getMessage());
		}
		
	}

		
}






