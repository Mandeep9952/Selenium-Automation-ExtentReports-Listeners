package basics_extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class LoginTest {

    public void sateekTestMethod() {
        System.out.println("Hello from Sateek");
    }

    //what is Extent Report - it is a logger(kind of an object which logs certain messages) style reporting library for automated tests
    //What does it do - it adds info about test cases, screenshots, assigning tags, series of steps and sequencing those steps
    //All methods inside Extent Reports are thread safe - Recommend to create a single instance of Extent Reports

    @Test
    public void login(){
        //STEP 1 - Create the object of ExtentReports class

        ExtentReports extent = new ExtentReports(); //ExtentReports is in internal class responsible for generation of extent reports
                                                    //ExtentReports acts a Subject

        //STEP 2 = Create the object of ExtentSparkReporter(acts as an Observer) and it is attached to ExtentReports(Subject) Class
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        spark.config().setReportName("YouTube English TestNG Playlist Testing");
        spark.config().setDocumentTitle("ProjectName_JIRAstory_QA/UAT/Prod Extent Reports");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("utf-8");
        System.out.println("Spark File Path");
        System.out.println(spark.getFile().getPath());

        //STEP 3 - need to attach the report
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Login Functionality Test"); //returns object of Class ExtentTest
        test.log(Status.INFO, "Start Login Test Case");
        test.log(Status.INFO, "Opening Browser");
        test.log(Status.INFO, "Validate Sigin Link");
        test.log(Status.INFO, "Enter user credential");
        test.log(Status.INFO, "Login Test PASS");

        //STEP 4 - need to call method flush() - it instruct ExtentReport to write the test info at a certain destination
        extent.flush();
    }
}
