## Examples of software design methods in project Dia. Konstantine Tsurtsumia ZIPZ-22-1

[Directory](app/src/main/java/com/example/newdiya_lab1) with classes

The **DRY** principle grounds on awoiding repeating parts of code in your project.
As example in the project there are abstract class with abstract method of generating QR-code for each document.
Instead of copying the code of the method in every document class, they inherit it from class Document.
[Example 1](https://github.com/Konstantin2033/Software-engineering/blob/9539bd24588ac2d05d7925da713184fc41d0ae47/app/src/main/java/com/example/newdiya_lab1/Document.kt#L6)
[Example 2](https://github.com/Konstantin2033/Software-engineering/blob/9539bd24588ac2d05d7925da713184fc41d0ae47/app/src/main/java/com/example/newdiya_lab1/DriverLicense.kt#L24)
[Example 3](https://github.com/Konstantin2033/Software-engineering/blob/9539bd24588ac2d05d7925da713184fc41d0ae47/app/src/main/java/com/example/newdiya_lab1/PersonalNumber.kt#L20)
[Example 4](https://github.com/Konstantin2033/Software-engineering/blob/9539bd24588ac2d05d7925da713184fc41d0ae47/app/src/main/java/com/example/newdiya_lab1/Passport.kt#L20)

The **KISS** principle stands on simplyfying your code to make it more readeble. As exaple, the classes written in same way with variable initializations and get-set methods.
The adapter also uses different function for different documents to awoid putting all the code in one method. All the variables and function names are understandeble.
[Driver license class](app/src/main/java/com/example/newdiya_lab1/DriverLicense.kt)
[Passport class](app/src/main/java/com/example/newdiya_lab1/Passport.kt)
[Personal number class](app/src/main/java/com/example/newdiya_lab1/PersonalNumber.kt)

**Yagni** stands for awoiding functions, that you don't need yet. All function in the project are utilized with no "ghost parts" or unuseful functions.

**Program to Interfaces not Implementations** here for example the project uses class container to interract with documents classes objects and even sort them in Array
[Example](https://github.com/Konstantin2033/Software-engineering/blob/9539bd24588ac2d05d7925da713184fc41d0ae47/app/src/main/java/com/example/newdiya_lab1/Container.kt#L3)


Task #2 Demonstration
Project is made in Android Stuido using Kotlin to immitate Dia application. So instead of printin in console results I'll just show it here as screen record:
[Recording](1.gif)
