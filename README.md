# camelxmltojson

A very simple example of using camel-jaxb and camel-jackson to convert
XML to JSON. I've implemented this in a Spring Boot application, but
that's not really relevant here -- the important stuff is in the 
Camel route definition in the class `Application.xml`.

Since the sad demise of the `camel-xmljson` component, I keep getting asked
how to do XML -> JSON in a Camel route. I don't think there is any 
single-component solution. The best I can come up with is to unmarshal
the XML into a Java class (using camel-jaxb), and then re-marshall 
that object into JSON (using camel-jackson).

In practice, it's unlike that you'll be able to get away with using
a single Java class to model the data in flight -- you'll probably need
to nest classes inside other classes, and some of the associations will
probably be lists. However, modeling XML using Java is pretty well-documented.

Both camel-json and camel-jackson make reasonable defaults about the naming
associations between the Java, XML, and JSON, but these can be tuned
by annotations on the Java class.

*This is not production-quality code, for all sorts of reasons*

To build and run:

$ mvn clean spring-boot:run

To test, copy the XML file "test.xml" into the "in" directory. 
The output should be some JSON, like this:

    INFO  route1 - >>> {"name":"Fred Blogs","id":"123"}

Please note that I've tested this with the Red Hat Camel build, not
upstream. See `configuration/settings.xml` for the necessary repositories.


