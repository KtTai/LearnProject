package kttai.learn;

public class TestOverride {

    public Number test1(int a){
        return 0;
    }

    public class TestOverrideSub extends TestOverride{
        @Override
        public Double test1(int a) {
            return 0d;
        }
    }

}
