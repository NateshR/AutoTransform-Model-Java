public class ShareDataEntityMapper {
    public ShareDataContent transform(ShareDataEntity shareDataEntity) {
        ShareDataContent shareDataContent = new ShareDataContent();
        if (shareDataEntity != null) {
            shareDataContent.setShareText(shareDataEntity.getShareText());
            shareDataContent.setUrl(shareDataEntity.getUrl());
        }
        return shareDataContent;
    }
}
