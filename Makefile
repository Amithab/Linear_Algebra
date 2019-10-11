JAVA_SRCS	= Matrix.java

JAVA_CLASSES	= Matrix.class

JUNIT_SRCS	= CheckMatrix.java #TestJUnit.java #TestRunner.java
JUNIT_CLASSES	= TestRunner.class TestJUnit.class

JAVAC		= javac
JAVA		= java

JAVA_FLAGS	= -x
JUNIT_FLAGS	= -cp .:/usr/share/java/junit4.jar

%.class: %.java
	@echo	"Compiling each java source file separately ..."
	$(JAVAC) $<
	@echo ""

math18:	$(JAVA_CLASSES)
	@echo "Compiling directory ..."
	@echo ""
	@echo "Done."

clean:
	@echo	"Cleaning up project directory ..."
	rm -f *.class
	@echo ""
	@echo "Clean."

testJUnit:
	@echo "Compiling CheckMatrix"
	$(JAVAC) $(JUNIT_FLAGS) $(JUNIT_SRCS)
	@echo "Done"

runJUnit:
	@echo "Running CheckMatrix"
	$(JAVA) $(JUNIT_FLAGS) org.junit.runner.JUnitCore CheckMatrix
	@echo "Done"

new:
	make clean
	make
//topup
