package com.bellsw.pf4jdemo.plugins.bye;

import com.bellsw.pf4jdemo.commons.PhraseExtensionPoint;
import org.pf4j.Extension;

@Extension(ordinal = 1)
public class ByeExtension implements PhraseExtensionPoint {
    @Override
    public String phraseOfTheDay() {
        return "Bye!";
    }
}
