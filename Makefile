JAVA_SRCS	= Matrix.java

JAVA_CLASSES	= Matrix.class

JAVAC		= javac

JAVA_FLAGS	= -x

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

new:
	make clean
	make
