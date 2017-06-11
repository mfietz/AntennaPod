package de.danoeh.antennapod.core.storage;

import android.text.TextUtils;

import de.danoeh.antennapod.core.feed.Feed;

public class FeedUpdate {

    private final Feed target;
    private final Feed source;

    public FeedUpdate(Feed target, Feed source) {
        this.target = target;
        this.source = source;
    }

    public boolean updateRequired() {
        if (source.getDownload_url() != null && !TextUtils.equals(source.getDownload_url(), target.getDownload_url())) {
            return true;
        }
        if(source.getImage() != null &&
                !TextUtils.equals(source.getImage().getDownload_url(), target.getImage().getDownload_url())) {
            return true;
        }
        if (source.getFeedTitle() != null && !TextUtils.equals(source.getFeedTitle(), target.getFeedTitle())) {
            return true;
        }
        if (source.getFeedIdentifier() != null && !TextUtils.equals(source.getFeedIdentifier(), target.getFeedIdentifier())) {
            return true;
        }
        if (source.getLink() != null && !TextUtils.equals(source.getLink(), target.getLink())) {
            return true;
        }
        if (source.getDescription() != null && !TextUtils.equals(source.getDescription(), target.getDescription())) {
            return true;
        }
        if (source.getLanguage() != null && !TextUtils.equals(source.getLanguage(), target.getLanguage())) {
            return true;
        }
        if (source.getAuthor() != null && !TextUtils.equals(source.getAuthor(), target.getAuthor())) {
            return true;
        }
        if (!TextUtils.equals(source.getPaymentLink(), target.getPaymentLink())) {
            return true;
        }
        if (source.isPaged() != target.isPaged()) {
            return true;
        }
        if (!TextUtils.equals(source.getNextPageLink(), target.getNextPageLink())) {
            return true;
        }
        return false;
    }

}
