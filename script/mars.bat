set classpath= .;../lib/Mars.jar;

if exist ../../jdk/jre/bin/javaw.exe goto innerJRE
if not exist ../../jdk/jre/bin/javaw.exe goto sysJRE

:sysJRE
 echo 222
 start "ats-pissystem"  java.exe com.tw.Main

goto end
:innerJRE 
 echo 111
 start "ats-pissystem" ../../jdk/jre/bin/java.exe com.tw.Main
goto end
:end