package de.danoeh.antennapod.core.tests.storage;

import android.test.AndroidTestCase;

import de.danoeh.antennapod.core.feed.Feed;
import de.danoeh.antennapod.core.feed.FeedImage;
import de.danoeh.antennapod.core.storage.FeedUpdate;

public class FeedUpdateTest extends AndroidTestCase {

    private final Feed target = new Feed();
    private Feed source = new Feed();
    private final FeedUpdate feedUpdate = new FeedUpdate(target, source);

    @Override
    protected void setUp() {
        target.setTitle("current title");
        target.setDownload_url("http://example.com/current");
        FeedImage currentImage = new FeedImage();
        currentImage.setDownload_url("http://example.com/current.png");
        target.setImage(currentImage);
        target.setFeedIdentifier("current identifier");
        target.setLink("http://example.com/current");
        target.setDescription("Current description");
        target.setLanguage("Current language");
        target.setAuthor("Current author");
        target.setPaymentLink("http://example.com/current-payment");
        target.setPaged(false);
        target.setNextPageLink("http://example.com/current-next-page-link");

        source = new Feed();
    }

    public void testDownloadUrlUpdateRequiresUpdate() {
        downloadUrlUpdated();
        updateRequired();
    }

    public void testDownloadUrlRemovalRequiresNoUpdate() {
        downloadUrlRemoved();
        updateNotRequired();
    }

    public void testUImageUpdateRequiresUpdate() {
        imageUpdated();
        updateRequired();
    }

    public void testImageRemovalRequiresNoUpdate() {
        imageRemoved();
        updateNotRequired();
    }

    public void testFeedTitleUpdateRequiresUpdate() {
        feedTitleUpdated();
        updateRequired();
    }

    public void testFeedTitleRemovalRequiresNoUpdate() {
        feedTitleRemoved();
        updateNotRequired();
    }

    public void testFeedIdentifierUpdateRequiresUpdate() {
        feedIdentifierUpdated();
        updateRequired();
    }

    public void testFeedIdentifierRemoovalRequiresNoUpdate() {
        feedIdentifierRemoved();
        updateNotRequired();
    }

    public void testLinkUpdateRequiresUpdate() {
        linkUpdated();
        updateRequired();
    }

    public void testLinkRemovalRequiresNoUpdate() {
        linkRemoved();
        updateNotRequired();
    }

    public void testDescriptionUpdateRequiresUpdate() {
        descriptionUpdated();
        updateRequired();
    }

    public void testDescriptionRemovalRequiresNoUpdate() {
        descriptionRemoved();
        updateNotRequired();
    }

    public void testLanguageUpdateRequiresUpdate() {
        languageUpdated();
        updateRequired();
    }

    public void testLanguageRemovalRequiresNoUpdate() {
        languageRemoved();
        updateNotRequired();
    }

    public void testAuthorUpdateRequiresUpdate() {
        authorUpdated();
        updateRequired();
    }

    public void testAuthorRemovalRequiresNoUpdate() {
        authorRemoved();
        updateNotRequired();
    }

    public void testPaymentLinkUpdateRequiresUpdate() {
        paymentLinkUpdated();
        updateRequired();
    }

    public void testPaymentLinkRemovalRequiresUpdate() {
        paymentLinkRemoved();
        updateRequired();
    }

    public void testPagedUpdateRequiresUpdate() {
        pagedUpdated();
        updateRequired();
    }

    public void testNextPageLinkUpdatedRequiresUpdate() {
        nextPageLinkUpdated();
        updateRequired();
    }

    public void testNextPageLinkRemovalRequiresUpdate() {
        nextPageLinkRemoved();
        updateRequired();
    }

    private void downloadUrlUpdated() {
        source.setDownload_url("http://example.com/updated");
    }

    private void downloadUrlRemoved() {
        source.setDownload_url(null);
    }

    private void imageUpdated() {
        FeedImage newImage = new FeedImage();
        newImage.setDownload_url("http://example.com/updated.png");
        source.setImage(newImage);
    }

    private void imageRemoved() {
        source.setImage(null);
    }

    private void feedTitleUpdated() {
        source.setTitle("updated ttitle");
    }

    private void feedTitleRemoved() {
        source.setTitle(null);
    }

    private void feedIdentifierUpdated() {
        source.setDownload_url("updated identifier");
    }

    private void feedIdentifierRemoved() {
        source.setFeedIdentifier(null);
    }

    private void linkUpdated() {
        source.setLink("http://www.example.com/updated");
    }

    private void linkRemoved() {
        source.setLink(null);
    }

    private void descriptionUpdated() {
        source.setDescription("Updated description");
    }

    private void descriptionRemoved() {
        source.setDescription(null);
    }

    private void languageUpdated() {
        source.setLanguage("Updated language");
    }

    private void languageRemoved() {
        source.setLanguage(null);
    }

    private void authorUpdated() {
        source.setAuthor("Updated author");
    }

    private void authorRemoved() {
        source.setAuthor(null);
    }

    private void paymentLinkUpdated() {
        source.setPaymentLink("http://example.com/updated-payment");
    }

    private void paymentLinkRemoved() {
        source.setPaymentLink(null);
    }

    private void pagedUpdated() {
        source.setPaged(!target.isPaged());
    }

    private void nextPageLinkUpdated() {
        source.setNextPageLink("http://example.com/updated-next-page-link");
    }

    private void nextPageLinkRemoved() {
        source.setNextPageLink(null);
    }

    private void updateRequired() {
        assertTrue(feedUpdate.updateRequired());
    }

    private void updateNotRequired() {
        assertFalse(feedUpdate.updateRequired());
    }


}