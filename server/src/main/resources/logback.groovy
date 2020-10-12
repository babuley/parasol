// LOGBACK LOGGING CONFIGURATION


import ch.qos.logback.classic.AsyncAppender
import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy


import static ch.qos.logback.classic.Level.*

def home = System.getProperty("parasol.home");
def consolePattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"

scan("30 seconds")

appender("parasol", RollingFileAppender) {
    file = "${home}/logs/parasol.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%d %5p %c{1}:%L - %m%n"
    }
    rollingPolicy(FixedWindowRollingPolicy) {
        maxIndex = 50
        fileNamePattern = "${home}/logs/parasol.log.%i"
    }
    triggeringPolicy(SizeBasedTriggeringPolicy) {
        maxFileSize = "10MB"
    }
}

appender("STDOUT", ConsoleAppender) {
    withJansi = true;
    encoder(PatternLayoutEncoder) {
        pattern = "[%thread] %highlight(%-5level) %cyan(%logger{15}) - %msg %n";
    }
}

logger("org.hibernate.engine.StatefulPersistenceContext.ProxyWarnLog", ERROR)
logger("org.hibernate.engine.internal.StatefulPersistenceContext", ERROR)

logger("org.openapitools",ERROR,["parasol"])

root(WARN, ["STDOUT", "parasol"])
