package com.bellsw.pf4jdemo.plugins.hello;
import com.bellsw.pf4jdemo.commons.PhraseExtensionPoint;
import org.pf4j.Extension;

@Extension(ordinal = 2)
public class HelloExtension implements PhraseExtensionPoint {
    @Override
    public String phraseOfTheDay() {
        return "Hello!";
    }
}
