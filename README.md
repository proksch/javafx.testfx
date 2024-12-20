# Testing JavaFX with TestFX

This project illustrates how to test a JavaFX applicaton with UI tests using [TestFX](https://github.com/TestFX/TestFX).

The project contains an basic application that only consists of a `Button` and a `Label`.
Everytime the `Button` is clicked, the count of previous clicks will be shown via the `Label`.
The JUnit5 test suite runs the UI and tests whether the controller works as expected.

*Please note:* The source code of `Main` and `Controller`, the corresponding `basic.fxml` file, and the test suite are all
extensively commented to explain the implementation.
The `pom.xml` (see `maven-surefire-plugin` configuration and the test dependencies) and
`.gitlab-ci.yml` (see `yum` invocation) files contain comments that explain what is necessary
to run the example in [headless mode](https://en.wikipedia.org/wiki/Headless_software), e.g.,
on a build server.
 
Assuming that you have [Maven](https://maven.apache.org/install.html) installed, you can run the test suite via:

    mvn clean verify

The basic application can be run out-of-the-box from your terminal via:

    mvn clean javafx:run

Running the application and the tests from within your IDE (Eclipse/IntelliJ) requires setting up OpenJFX.

First download (and unzip!) an [OpenJFX SDK](https://openjfx.io).
Make sure that the download *matches your Java JDK version*.
You might also need to adapt the version property in the `pom.xml` file.

Then create a *run configuration* and add the following *VM* commands:

	--module-path="/path/to/javafx-sdk/lib"
	--add-modules=javafx.controls,javafx.fxml

Adjust the module path to your local download and make sure you adapt the path
to the `lib`(!) directory (not just the directory that you unzipped)...

*Tip:* Windows uses `\` to separate path elements.

*Tip:* Make sure not to forget the `/lib` at the end of the path

*Tip:* Double-check that the path is correct. If you receive abstract error messages, like `Module javafx.fxml not found`
or a segmentation fault, you are likely not pointing to the right folder
