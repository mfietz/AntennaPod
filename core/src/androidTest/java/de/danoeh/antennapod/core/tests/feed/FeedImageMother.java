package de.danoeh.antennapod.core.tests.feed;

import de.danoeh.antennapod.core.feed.FeedImage;

public class FeedImageMother {

    public static FeedImage anyFeedImage() {
        return new FeedImage(0, "image", null, "http://example.com/picture", false);
    }

}
