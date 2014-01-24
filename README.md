PasswordVerificationService
===========================

This is just some example code that I've done for people that would like to see my coding style. 

The ant build file can create a jar file to include the code in another project. There are 3 dependency lib jars in the /lib directory that may already be included in the project. These are Spring, Commons-logging, and Guava.  The build.xml also has “test”, “compile”, and  “clean” available.  

The PasswordVerificationService is in com.mccormi.service.password.  The service has one primary method testPassword(String password), which returns a boolean whether the password is acceptable or not. The service takes a list of PasswordVerificationRules. All of the rules must pass for a given password for the service to return that the password is acceptable. 

In the /conf dir there is a PasswordVerificationContext.xml that can be used for configuring the PasswordVerificationService as well the PasswordVerificationRules. 

Feel free to ping me with any questions - bryan@mccormi.com