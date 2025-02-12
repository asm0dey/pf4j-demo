package com.bellsw.pf4jdemo;

import com.bellsw.pf4jdemo.commons.PhraseExtensionPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@DependsOn("pluginManager")
public class PhraseController {
    private final List<PhraseExtensionPoint> extensions;

    @Autowired
    public PhraseController(List<PhraseExtensionPoint> extensions) {
        this.extensions = extensions;
    }

    @GetMapping("/phrase")
    public String phraseOfTheDay() {
        return extensions.stream().map(PhraseExtensionPoint::phraseOfTheDay).collect(Collectors.joining("\n"));
    }
}
