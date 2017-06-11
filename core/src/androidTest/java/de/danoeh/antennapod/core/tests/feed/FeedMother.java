package de.danoeh.antennapod.core.tests.feed;

import de.danoeh.antennapod.core.feed.Feed;
import de.danoeh.antennapod.core.feed.FeedImage;

public class FeedMother {

    public static Feed anyFeed() {
        FeedImage image = FeedImageMother.anyFeedImage();
        return new Feed(0, null, "title", "http://example.com", "This is the description",
                "http://example.com/payment", "Daniel", "en", null, "http://example.com/feed", image,
                null, "http://example.com/feed", true);
    }

}
