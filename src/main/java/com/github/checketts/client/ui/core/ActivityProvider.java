package com.github.checketts.client.ui.core;

import com.github.checketts.client.util.core.ActivityProxy;
import com.google.inject.Provider;

public interface ActivityProvider {
    Provider<? extends ActivityProxy<?>> getActivityProvider();
}
