package com.github.checketts.client.mvp;

import com.github.checketts.client.mvp.TokenizerContainer.InfoTokenizer;
import com.github.checketts.client.mvp.TokenizerContainer.StartTokenizer;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({ InfoTokenizer.class,StartTokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

    /*
     * At GWT compile time, GWT generates (see PlaceHistoryMapperGenerator) a
     * class based on your interface that extends AbstractPlaceHistoryMapper.
     * PlaceHistoryMapper is the link between your PlaceTokenizers and GWT's
     * PlaceHistoryHandler that synchronizes the browser URL with each Place.
     * 
     * For more control of the PlaceHistoryMapper, you can use the @Prefix
     * annotation on a PlaceTokenizer to change the first part of the URL
     * associated with the Place. For even more control, you can instead
     * implement PlaceHistoryMapperWithFactory and provide a TokenizerFactory
     * that, in turn, provides individual PlaceTokenizers.
     */
}
