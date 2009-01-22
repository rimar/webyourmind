import java.util.Date
import groovy.xml.MarkupBuilder

if (session == null) {
  session = request.getSession(true);
}

if (session.counter == null) {
      session.counter = 1
}

html.html {    // html is implicitly bound to new MarkupBuilder(out)
  head {
      title("Groovy Servlet")
  }
  body {
    foo("x") 
    p("Hello, ${request.remoteHost}: ${session.counter}! ${new Date()}")
  }
}
session.counter = session.counter + 1