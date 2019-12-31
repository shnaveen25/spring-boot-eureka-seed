package core.dvaar.impl.common.di.guice.model;

public class SampleModelImpl implements SampleModel {
    private String text;
    
    public SampleModelImpl() {
        
    }
    
    public SampleModelImpl(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
