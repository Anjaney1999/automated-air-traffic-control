@echo off
rem Post-build step command file for building a Java application from Perfect Developer version 3

rem Check that at least two command-line parameters have been supplied
if not %2.==. goto GOTPARAMS
echo Post-build file: not enough parameters provided!
echo Usage:    postbuildjava.bat  main-class-name library-name  additional-java-files
echo Example:  postbuildjava.bat  Entry PerfectRuntime.jar  Entry.java
exit 1

:GOTPARAMS

set MAINCLASS=%1

rem The Project Manager (version 3 or later) sets up PD_JAVA_LIB_PATH before calling the post-build file. Check for this.
if not "%PD_JAVA_LIB_PATH%"=="" goto JAVALIBPATHOK
echo Post-build file: variable PD_JAVA_LIB_PATH has not been set up! Use this file only with Perfect Developer version 3 or later.
exit 1

:JAVALIBPATHOK

rem The Project Manager also sets up PD_JDK_BIN_PATH provided the user has configured it. Check for this.
if not "%PD_JDK_BIN_PATH"=="" goto GOTJAVAPATH
echo Post-build file: Path to Java tools not configured! Please configure the path to the Java tools in the Project Manager 'Options' page.
exit 1

:GOTJAVAPATH

if exist "%PD_JDK_BIN_PATH%javac.exe" goto GOTCOMPILER
echo Post-build file: Java compiler not found on path "%PD_JDK_BIN_PATH%"! Please configure the path to the Java tools in the Project Manager 'Options' page
exit 1

:GOTCOMPILER

rem Build the complete library filename from the path variable and the supplied filename, then check that it exists
set PERFECTLIB=%PD_JAVA_LIB_PATH%%2
if exist "%PERFECTLIB%" goto LIBEXISTS
echo Post-build file: incorrect library file and/or path name (can't find file "%PERFECTLIB%")
exit 1

:LIBEXISTS

rem Check that a package name has been set up
if not %PD_PACKAGE_NAME%.==. goto PKGNAMEOK
echo Post-build file: You must set a package name in the project to use this file!
exit 1

:PKGNAMEOK

rem Check that there are some generated java source files where we expect them
if exist .\src\%PD_PACKAGE_NAME%\*.java goto GOTJAVAFILES
echo Post-build file: PD_PACKAGE_NAME setting is incorrect (can't find .\src\%PD_PACKAGE_NAME%\*.java)
goto :ERROR

:GOTJAVAFILES

rem Check the the classes subdirectory exists, else the Java compiler fails
if not exist classes\* mkdir classes

rem Checks complete, now perform the post-build

echo Compiling Java files
"%PD_JDK_BIN_PATH%javac" -d .\classes -classpath ".\classes;.\src;%PERFECTLIB%" .\src\%PD_PACKAGE_NAME%\*.java %3 %4 %5 %6
if errorlevel 1 goto ERROR

rem Copy the library archive to the output directory, changing its name to the name of our package
if not exist output mkdir output
echo Copying library
copy /Y "%PERFECTLIB%" output\%PD_PACKAGE_NAME%.jar
if errorlevel 1 goto ERROR

rem Add our own class files to the archive and delete its manifest, if any
echo Creating JAR file
"%PD_JDK_BIN_PATH%jar" ufM0 output\%PD_PACKAGE_NAME%.jar -C .\classes %PD_PACKAGE_NAME%
if errorlevel 1 goto ERROR

rem Create a manifest file
echo>jarManifest Manifest-Version: 1.0
echo>>jarManifest Class-path: ./
echo>>jarManifest Main-Class: %PD_PACKAGE_NAME%.%MAINCLASS%

rem Add the manifest to the archive
"%PD_JDK_BIN_PATH%jar" ufm0 output\%PD_PACKAGE_NAME%.jar jarManifest
if errorlevel 1 goto ERROR

rem Success, so delete the manifest file and exit
del jarManifest
echo Build successful
exit

:ERROR
echo ERROR: Post-build step failed!
exit 1
