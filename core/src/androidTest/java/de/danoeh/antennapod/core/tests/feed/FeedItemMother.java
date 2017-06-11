package de.danoeh.antennapod.core.tests.feed;

import java.util.Date;

import de.danoeh.antennapod.core.feed.FeedItem;

class FeedItemMother {

    static FeedItem anyFeedItemWithImage() {
        FeedItem item = new FeedItem(0, "Item", "Item", "url", new Date(), FeedItem.PLAYED, FeedMother.anyFeed());
        item.setImage(FeedImageMother.anyFeedImage());
        return item;
    }

}
