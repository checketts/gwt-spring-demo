package com.github.checketts.client.mvp;

import com.github.checketts.client.ui.info.InfoPlace;
import com.google.gwt.place.shared.PlaceHistoryMapperWithFactory;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TokenizerContainer {
    
    @Prefix("info")
    public static class InfoTokenizer implements PlaceTokenizer<InfoPlace>{
        @Override
        public  InfoPlace getPlace(String token) {
            return new InfoPlace(token);
        }

        @Override
        public String getToken(InfoPlace place) {
            return place.getToken();
        }
    }

    @Prefix("home")
    public static class StartTokenizer implements PlaceTokenizer<StartPlace>{
        @Override
        public StartPlace getPlace(String token) {
            return new StartPlace(token);
        }

        @Override
        public String getToken(StartPlace place) {
            return place.getToken();
        }
    }
    
}