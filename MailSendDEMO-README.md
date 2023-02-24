
# Dummy send mail

This is a program that sends demo emails. For now I set it so that it sends a testing message to the email address input by the user. Ideally in the future these addresses will be retrieved from the website itself.

I used the mevan quickstart archetype as the base and the sole added dependency is the same javamail API i use to send the mails. 

Running it shouldn't be anything too hard everything is already in place except for the destination email just make sure you have all the files, then run SendMailDemo.java 

I decided to go with outlook for the smtp email provider since netcore seemed to be having a problem where they didnt let me sign up.

Emails can be sent to any address(may end up in spam though) I used a scanner to make testing this easier you just need to run the program and type in your address. This is really the base of everything to come since javamail lets you do a lot with it adapting this base to fit with the rest of the project as its developed should not be too hard I'll continue to do that as more pieces of code is done.

-Radnitz



